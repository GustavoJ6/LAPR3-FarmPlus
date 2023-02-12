#ifndef SENSOR_H
#define SENSOR_H

#include <stdio.h>

typedef struct{
    unsigned short id;
    unsigned char sensor_type;
    unsigned short max_limit;
    unsigned short min_limit;
    unsigned long frequency; 
    unsigned long readings_size; 
    unsigned short *readings; 
} Sensor;

#endif