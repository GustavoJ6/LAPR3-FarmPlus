#include "restrictions.h"
#include "sensor.h"
#include "set_sensor.h"

void set_all_sensors(Restrictions *restrict_sensor, unsigned long *frequencies, unsigned char *sensor_types, int *sensor_amounts, Sensor *temperature_sensors, Sensor *wind_speed_sensors, Sensor *wind_direction_sensors, Sensor *pluviosity_sensors, Sensor *atmospheric_humidity_sensors, Sensor *soil_humidity_sensors) {   
        // Set the sensors
        if (sensor_amounts[0] > 0) {
        for (int i = 0; i < sensor_amounts[0]; i++) {
            set_sensor(&temperature_sensors[i], &temperature_sensors[i], i, sensor_types[0], restrict_sensor[0].temperature_limits[1], restrict_sensor[0].temperature_limits[0], frequencies[0]);
        }
        }
        else {
            printf("\nNo temperature sensors\n");
        }

        if (sensor_amounts[1] > 0) {
        for (int i = 0; i < sensor_amounts[1]; i++) {
            set_sensor(&wind_speed_sensors[i], &wind_speed_sensors[i], i, sensor_types[1], restrict_sensor[0].wind_speed_limits[1], restrict_sensor[0].wind_speed_limits[0], frequencies[1]);
        }
        }
        else {
            printf("\nNo wind speed sensors\n");
        }

        if (sensor_amounts[2] > 0) {
        for (unsigned short i = 0; i < sensor_amounts[2]; i++) {
            set_sensor(&wind_direction_sensors[i], &wind_direction_sensors[i], i, sensor_types[2], restrict_sensor[0].wind_direction_limits[1], restrict_sensor[0].wind_direction_limits[0], frequencies[2]);
        }
        }
        else {
            printf("\nNo wind direction sensors\n");
        }

        if (sensor_amounts[3] > 0 && sensor_amounts[0] > 0) {
        for (int i = 0; i < sensor_amounts[5]; i++) {
            if (i >= sensor_amounts[0]) {
                set_sensor(&pluviosity_sensors[i], &temperature_sensors[sensor_amounts[0] - 1], i, sensor_types[3], restrict_sensor[0].pluviosity_limits[1], restrict_sensor[0].pluviosity_limits[0], frequencies[5]);
            }
            else set_sensor(&pluviosity_sensors[i], &temperature_sensors[i], i, sensor_types[3], restrict_sensor[0].pluviosity_limits[1], restrict_sensor[0].pluviosity_limits[0], frequencies[5]);
        }
        }
        else {
            printf("\nNo pluviosity sensors\n");
        }

        if (sensor_amounts[3] > 0 && sensor_amounts[0] > 0) {
        for (int i = 0; i < sensor_amounts[3]; i++) {
            if (i >= sensor_amounts[0]) {
                set_sensor(&atmospheric_humidity_sensors[i], &pluviosity_sensors[sensor_amounts[5] - 1], i, sensor_types[4], restrict_sensor[0].atmospheric_humidity_limits[1], restrict_sensor[0].atmospheric_humidity_limits[0], frequencies[3]);
            }
            else set_sensor(&atmospheric_humidity_sensors[i], &pluviosity_sensors[i], i, sensor_types[4], restrict_sensor[0].atmospheric_humidity_limits[1], restrict_sensor[0].atmospheric_humidity_limits[0], frequencies[3]);
        }
        }
        else {
            printf("\nNo atmospheric humidity sensors\n");
        }

        if (sensor_amounts[3] > 0 && sensor_amounts[0] > 0) {
        for (int i = 0; i < sensor_amounts[4]; i++) {
            if (i >= sensor_amounts[0]) {
                set_sensor(&soil_humidity_sensors[i], &pluviosity_sensors[sensor_amounts[5] - 1], i, sensor_types[5], restrict_sensor[0].soil_humidity_limits[1], restrict_sensor[0].soil_humidity_limits[0], frequencies[4]);
            }
            else set_sensor(&soil_humidity_sensors[i], &pluviosity_sensors[i], i, sensor_types[5], restrict_sensor[0].soil_humidity_limits[1], restrict_sensor[0].soil_humidity_limits[0], frequencies[4]);
        }
        }
        else {
            printf("\nNo soil humidity sensors\n");
        }
}