#include <stdio.h>
#include <stdint.h>
#include "pcg.h"
#include "sens_dir_vento.h"

unsigned short gen_sens_dir_vento(unsigned short ult_dir_vento) {
    short comp_rand = (pcg32_random_r() & 0x7FFF);
    char bit = (pcg32_random_r() & 0x1);

    return sens_dir_vento(ult_dir_vento, comp_rand, bit);
}
