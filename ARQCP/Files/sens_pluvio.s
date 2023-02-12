.section .text
	.global sens_pluvio	# unsigned short || rdi -> ult_pluvio || rsi -> ult_temp || rdx -> comp_rand

sens_pluvio:
    movb	%dl, %al
    movb	$9, %r8b

    cbtw
	idivb	%r8b

    cmpb    $18, %sil
    jl     decrease

    movb    %ah, %al
    subb    %al, %dil
    movb    %dil, %al
    ret

    decrease:
        movb    %ah, %al
        addb    %dil, %al
        ret

    cmpb    $130, %dil
    jge     verify

    verify:
        cmpb    $18, %sil
        jge      keep

        keep:
            movb	%dl, %al
            movb	$9, %r8b

            cbtw
	        idivb	%r8b

            movb    %ah, %al
            subb    %al, %dil
            movb    %dil, %al
            ret
