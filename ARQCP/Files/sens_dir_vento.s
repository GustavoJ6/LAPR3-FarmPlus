.section .text
	.global sens_dir_vento	# unsigned short || rdi -> ult_dir_vento || rsi -> comp_rand

sens_dir_vento:
	movb	%dl, %r8b
	movw	%si, %ax	# Move the value of comp_rand to %sil to be able to make a quocient

	cwtd				# Preparing the dividend 
	movw	$11, %cx
	idivw	%cx			# Making sure that the random value is between 0 - 10
	
	cmpb	$1, %r8b
	je 		decrease

	addw	%dx, %di	# Add the random increment to direction

	return:
		cmpw	$0, %di
		jle		smallest

		cmpw	$359, %di
		jge		biggest

		movw	%di, %ax
		ret

	smallest:
		movw	$0, %ax
		ret
	
	biggest:
		movw	$359, %ax
		ret

decrease:
	subw 	%dx, %di
	jmp		return
