#include "restrictions.h"

void set_restrictions(Restrictions * restrictions, int * sensor_amounts, char temperature_limits_min, char temperature_limits_max, unsigned char wind_speed_limits_min, unsigned char wind_speed_limits_max, unsigned short wind_direction_limits_min, unsigned short wind_direction_limits_max, unsigned char atmospheric_humidity_limits_min, unsigned char atmospheric_humidity_limits_max, unsigned char soil_humidity_limits_min, unsigned char soil_humidity_limits_max, unsigned char pluviosity_limits_min, unsigned char pluviosity_limits_max) {
    for (int i = 0; i < 6; i++) {
        restrictions->sensor_amounts[i] = sensor_amounts[i];
    }

    restrictions->temperature_limits[0] = temperature_limits_min;
    restrictions->temperature_limits[1] = temperature_limits_max;
    restrictions->wind_speed_limits[0] = wind_speed_limits_min;
    restrictions->wind_speed_limits[1] = wind_speed_limits_max;
    restrictions->wind_direction_limits[0] = wind_direction_limits_min;
    restrictions->wind_direction_limits[1] = wind_direction_limits_max;
    restrictions->atmospheric_humidity_limits[0] = atmospheric_humidity_limits_min;
    restrictions->atmospheric_humidity_limits[1] = atmospheric_humidity_limits_max;
    restrictions->soil_humidity_limits[0] = soil_humidity_limits_min;
    restrictions->soil_humidity_limits[1] = soil_humidity_limits_max;
    restrictions->pluviosity_limits[0] = pluviosity_limits_min;
    restrictions->pluviosity_limits[1] = pluviosity_limits_max;
}