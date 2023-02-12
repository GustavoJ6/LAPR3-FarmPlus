.section .data
	.global state   # unsigned long
    .global inc     # unsigned long
  
.section .text
	.global pcg32_random_r	# returns a unsigned int (32 bits) 

pcg32_random_r:
    movq    state(%rip), %rax  # oldstate = state 
    push   %rax    # %rax -> stack || We will need the value of oldstate later on

    # Advance internal state || Meaning that state will now be altered and every iteration will have a different state value
    movabsq $6364136223846793005, %rdi  # value -> %rdi || "movabsq" means move absolute quad
    mulq    %rdi                        # (oldstate * 6364136223846793005) -> %rax || multiplying %rdi by %rax

    movq    inc(%rip), %rdx     # inc -> %rdx || inc(%rip) was only moved now, because a mul between two quad, occupies both %rax and %rdx 
    orq     $1, %rdx            # (inc|1) -> %rdx || If the number is even we add 1

    addq    %rdx, %rax          # state = oldstate * 6364136223846793005ULL + (inc|1) 
    movq    %rax, state(%rip)   # state = %rax

    # Calculate output function (XSH RR), uses old state for max ILP
    pop     %rax        # stack -> %rax || We are now recovering the value of oldstate
    push    %rax        # %rax -> stack || We will still oldstate later, so we sen it to the stack again
    movq    %rax, %rcx  # oldstate is in %rax and %rdi

    # Here we are going to alter the values of both oldstate and this is were the return is performed
    shrq    $18, %rax   # (oldstate >> 18u)
    xorq    %rcx, %rax  # ((oldstate >> 18u) ^ oldstate)

    shrq    $27, %rax   # xorshifted = ((oldstate >> 18u) ^ oldstate) >> 27u

    pop     %rdx        # stack -> %rdx
    shrq    $59, %rdx   # rot = oldstate >> 59u

    movl    %eax, %edi  # xorshifted -> %edi
    movl    %edx, %esi  # rot -> %esi

    movb    %sil, %cl   # AND -> %cl, %xxx
    shrl    %cl, %edi   # xorshifted >> rot

    negl    %edx        # (-rot)
    andl    $31, %edx   # (-rot) & 31)

    movb    %dl, %cl    # AND -> %cl, %xxx
    shll    %cl, %eax   # (xorshifted << ((-rot) & 31))

    orl     %edi, %eax  # (xorshifted >> rot) | (xorshifted << ((-rot) & 31))
    ret
