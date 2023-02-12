#include <stdint.h>
#include <stdio.h>
#include "dev_random.h"

extern uint64_t buffer[2];
extern uint64_t state;
extern uint64_t inc;

void alterGlobal() {
    dev_random(buffer);
    state = buffer[0];
    inc = buffer[1];
}