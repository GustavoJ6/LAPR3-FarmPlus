#include <stdio.h>
#include <stdint.h>
#include "pcg.h"
#include "sens_velc_vento.h"

unsigned char gen_sens_velc_vento(unsigned char ult_velc_vento) {
    char comp_rand = (pcg32_random_r() & 0xff);
    char bit = (pcg32_random_r() & 0x3);

    return sens_velc_vento(ult_velc_vento, comp_rand, bit);
}