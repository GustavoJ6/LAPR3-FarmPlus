#include <stdio.h>
#include <stdint.h>
#include "pcg.h"
#include "sens_pluvio.h"

unsigned char gen_sens_pluvio(unsigned char ult_pluvio, char ult_temp) {
  unsigned char pluvio;
  do {
    char comp_rand = (pcg32_random_r() & 0xff); 
    pluvio = sens_pluvio(ult_pluvio, ult_temp, comp_rand);
  } while(pluvio >= 150);
  return pluvio;
}