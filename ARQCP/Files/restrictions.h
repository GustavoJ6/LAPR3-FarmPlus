#ifndef RESTRICTIONS_H
#define RESTRICTIONS_H

#include <stdio.h>

typedef struct{
    int sensor_amounts[6];
    char temperature_limits[2];
    unsigned char wind_speed_limits[2];
    unsigned short wind_direction_limits[2];
    unsigned char atmospheric_humidity_limits[2];
    unsigned char soil_humidity_limits[2];
    unsigned char pluviosity_limits[2];
} Restrictions;
#endif