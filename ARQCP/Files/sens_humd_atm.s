.section .text
	.global sens_humd_atm	# unsigned short || rdi -> ult_hmd_atm || rsi -> ult_pluvio || rdx -> comp_rand

sens_humd_atm:
	movb	%dl, %al
	movb	$4, %r8b

	movb	%dil, %cl
	subb	%sil, %cl

	cbtw
	idivb	%r8b

	cmpb	$0, %cl
	jge		increase

	cmpb	$0, %cl
	jl 		decrease

	decrease:
		movb	%ah, %al
		subb	%al, %dil
		movb	%dil, %al

		cmpb	$0, %al
		jle		smallest

		cmpb	$100, %al
		jge		biggest

		ret
	
	increase:
		movb	%ah, %al
		addb	%dil, %al

		cmpb	$0, %al
		jle		smallest

		cmpb	$100, %al
		jge		biggest

		ret

	smallest:
		movb	$0, %al
		ret
	
	biggest:
		movb 	$100, %al
		ret
		