.section .text
	.global sens_velc_vento	# unsigned char || rdi -> ult_velc_vento || rsi -> comp_rand

sens_velc_vento:
	movb	%sil, %al
	movb	$16, %cl

	cbtw	# Preparing the dividend
	idivb	%cl

	movb	%ah, %al
	cmpb	$3, %dl
	je		decrease

	addb	%dil, %al

	return:
		cmpb	$0, %al
		jle		smallest

		cmpb	$90, %al
		jge		biggest
	
		ret
	
	smallest:
		movb	$0, %al
		ret
	
	biggest:
		movb	$90, %al
		ret

	decrease:
		subb	%al, %dil
		movb	%dil, %al
		jmp	 	return
