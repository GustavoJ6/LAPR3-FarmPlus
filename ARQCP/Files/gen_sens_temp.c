#include <stdio.h>
#include <stdint.h>
#include "pcg.h"
#include "sens_temp.h"

char gen_sens_temp(char ult_temp, char hour) {
  char comp_rand = (pcg32_random_r() & 0xff); 
  return sens_temp(ult_temp, comp_rand, hour);
}