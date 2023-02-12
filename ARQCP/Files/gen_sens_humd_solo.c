#include <stdio.h>
#include <stdint.h>
#include "pcg.h"
#include "sens_humd_solo.h"

#define MAX_PRC 100
#define MAX_PLU 135

unsigned char fromHMDToPLU_solo(unsigned char ult_pluvio) {
    return ((ult_pluvio * MAX_PRC) / MAX_PLU);
}

unsigned char gen_sens_humd_solo(unsigned char ult_hmd_solo, unsigned char ult_pluvio) {
    ult_pluvio = fromHMDToPLU_solo(ult_pluvio); 
    char comp_rand = (pcg32_random_r() & 0xff);

    return sens_humd_solo(ult_hmd_solo, ult_pluvio, comp_rand);
}