#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include "add_sensor.h"
#include "remove_sensor.h"
#include "alter_frequency.h"
#include "print_matrix.h"
#include "sensor.h"

void treatChoice(int choice, int *sensorAmount, unsigned long *frequencies, Sensor **temperature_sensors, Sensor **atmospheric_humidity_sensors, Sensor **soil_humidity_sensors, Sensor **pluviosity_sensors, Sensor **wind_speed_sensors, Sensor **wind_direction_sensors, int min_limit_temperature, int max_limit_temperature, int min_limit_wind_speed, int max_limit_wind_speed, int min_limit_wind_direction, int max_limit_wind_direction, int min_limit_atmospheric_humidity, int max_limit_atmospheric_humidity, int min_limit_soil_humidity, int max_limit_soil_humidity, int min_limit_pluviosity, int max_limit_pluviosity){
    switch(choice){
        case 1:
            add_sensor(sensorAmount,temperature_sensors, atmospheric_humidity_sensors, soil_humidity_sensors, pluviosity_sensors, wind_speed_sensors, wind_direction_sensors);
            break;
        case 2:
            remove_sensor(sensorAmount,temperature_sensors, atmospheric_humidity_sensors, soil_humidity_sensors, pluviosity_sensors, wind_speed_sensors, wind_direction_sensors);
            break;
        case 3:
            alter_frequency(frequencies);
            break;
        case 4:
            system("clear");
            printf("\n----------------\n|SENSOR AMOUNTS|\n----------------\n\n");
            printf("• Temperature: %d sensor(s)\n", sensorAmount[0]);
            printf("• Wind Speed: %d sensor(s)\n", sensorAmount[1]);
            printf("• Wind Direction: %d sensor(s)\n", sensorAmount[2]);
            printf("• Atmospheric Humidity: %d sensor(s)\n", sensorAmount[3]);
            printf("• Soil Humidity: %d sensor(s)\n", sensorAmount[4]);
            printf("• Pluviosity: %d sensor(s)\n", sensorAmount[5]);
            sleep(1.5);
            break;
        case 5:
            system("clear");
            printf("\n--------------------\n|SENSOR FREQUENCIES|\n--------------------\n\n");
            printf("• Temperature: %lds\n", frequencies[0]);
            printf("• Wind Speed: %lds\n", frequencies[1]);
            printf("• Wind Direction: %lds\n", frequencies[2]);
            printf("• Atmospheric Humidity: %lds\n", frequencies[3]);
            printf("• Soil Humidity: %lds\n", frequencies[4]);
            printf("• Pluviosity: %lds\n", frequencies[5]);
            sleep(1.5);
            break;
        case 6:
            system("clear");
            // Print the first temperature sensor's limits
            printf("\n----------------\n|SENSOR LIMITS|\n----------------\n\n");
            printf("• Temperature: %dºC - %dºC\n", min_limit_temperature, max_limit_temperature);
            printf("• Wind Speed: %dKm/h - %dKm/h\n", min_limit_wind_speed, max_limit_wind_speed);
            printf("• Wind Direction: %dº - %dº\n", min_limit_wind_direction, max_limit_wind_direction);
            printf("• Atmospheric Humidity: %d%% - %d%%\n", min_limit_atmospheric_humidity, max_limit_atmospheric_humidity);
            printf("• Soil Humidity: %d%% - %d%%\n", min_limit_soil_humidity, max_limit_soil_humidity);
            printf("• Pluviosity: %dmm - %dmm\n", min_limit_pluviosity, max_limit_pluviosity);
            sleep(1.5);
            break;
        case 0:
                system("clear");
                printf("\n\033[33mAnalyzing\033[0m the sensor's daily data...\n\n");
                sleep(2.5);
                system("clear");
            break;
        default:
            printf("Invalid option\n");
            sleep(1.0);
            system("clear");
            break;
    }
}