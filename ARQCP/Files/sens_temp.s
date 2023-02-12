.section .text
	.global sens_temp	# char || rdi -> ult_temp || rsi -> comp_rand || rdx -> hour

sens_temp:
	movb	%dl, %cl	# Make a copy of hour, since it will get destroyed in the quocient
	movb	%sil, %al	# Move the value of comp_rand to %sil to be able to make a quocient

	cbtw				# Preparing the dividend 
	movb	$5, %dl
	idivb	%dl			# Making sure that the random value is between 0 - 2

	movb	%ah, %al
	addb	%dil, %al	# Adding the ult_temp to (comp_rand % 3)
	ret
