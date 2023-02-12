#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "sensor.h"
#include "set_sensor.h"
#include "restrictions.h"

void add_sensor(int * sensor_amounts, Sensor **temperature_sensors, Sensor **atmospheric_humidity_sensors, Sensor **soil_humidity_sensors, Sensor **pluviosity_sensors, Sensor **wind_speed_sensors, Sensor **wind_direction_sensors){
    int option = 0;
    do {
        printf("\n-------------\n|ADD SENSOR|\n-------------\n\n");
        printf("\033[34m1\033[0m - Add Temperature Sensor.\n");
        printf("\033[34m2\033[0m - Add Wind Speed Sensor.\n");
        printf("\033[34m3\033[0m - Add Wind Direction Sensor.\n");
        printf("\033[34m4\033[0m - Add Atmospheric Humidity Sensor.\n");
        printf("\033[34m5\033[0m - Add Soil Humidity Sensor.\n");
        printf("\033[34m6\033[0m - Add Pluviosity Sensor.\n\n");
        printf("\033[31m0\033[0m - Go back to the main menu.\n\n");
        printf("\033[32mOption\033[0m: ");
        scanf("%d", &option);
        switch (option)
            {
            case 0:
                system("clear");
                printf("\n\033[33mGoing back\033[0m to the main menu...\n\n");
                sleep(1.5);
                system("clear");
                break;
            case 1:
            if (sensor_amounts[0] <= 49) {
                sensor_amounts[0]++;                
                *temperature_sensors = (Sensor *) realloc(*temperature_sensors, sensor_amounts[0] * sizeof(Sensor));
                system("clear");
                printf("\n• Temperature sensor with id %d, was \033[32madded\033[0m.\n", sensor_amounts[0]);
                break;
            }
            else {
                    system("clear");
                    printf("\nYou must \033[31mnot add\033[0m another temperature sensor!\n");
                    break;
            }
            case 2:
            if (sensor_amounts[1] <= 49) {
                sensor_amounts[1]++;
                *wind_speed_sensors = (Sensor *) realloc(*wind_speed_sensors, sensor_amounts[1] * sizeof(Sensor));
                system("clear");
                printf("\n• Wind Speed sensor with id %d, was \033[32madded\033[0m.\n", sensor_amounts[1]);
                break;
            }
            else {
                    system("clear");
                    printf("\nYou must \033[31mnot add\033[0m another wind speed sensor!\n");
                    break;
            }
            case 3:
            if (sensor_amounts[2] <= 49) {
                sensor_amounts[2]++;
                *wind_direction_sensors = (Sensor *) realloc(*wind_direction_sensors, sensor_amounts[2] * sizeof(Sensor));
                system("clear");
                printf("\n• Wind Direction sensor with id %d, was \033[32madded\033[0m.\n", sensor_amounts[2]);
                break;
            }
            else {
                    system("clear");
                    printf("\nYou must \033[31mnot add\033[0m another wind direction sensor!\n");
                    break;
            }
            case 4:
            if (sensor_amounts[3] <= 49) {
                sensor_amounts[3]++;
                *atmospheric_humidity_sensors = (Sensor *) realloc(*atmospheric_humidity_sensors, sensor_amounts[3] * sizeof(Sensor));
                system("clear");
                printf("\n• Atmospheric Humidity sensor with id %d, was \033[32madded\033[0m.\n", sensor_amounts[3]);
                break;
            }
            else {
                    system("clear");
                    printf("\nYou must \033[31mnot add\033[0m another atmospheric humidity sensor!\n");
                    break;
            }
            case 5:
            if (sensor_amounts[4] <= 49) {
                sensor_amounts[4]++;
                *soil_humidity_sensors = (Sensor *) realloc(*soil_humidity_sensors, sensor_amounts[4] * sizeof(Sensor));
                system("clear");
                printf("\n• Soil Humidity sensor with id %d, was \033[32madded\033[0m.\n", sensor_amounts[4]);
                break;
            }
            else {
                    system("clear");
                    printf("\nYou must \033[31mnot add\033[0m another soil humidity sensor!\n");
                    break;
            }
            case 6:
            if (sensor_amounts[5] <= 49) {
                sensor_amounts[5]++;
                *pluviosity_sensors = (Sensor *) realloc(*pluviosity_sensors, sensor_amounts[5] * sizeof(Sensor));
                system("clear");
                printf("\n• Pluviosity sensor with id %d, was \033[32madded\033[0m.\n", sensor_amounts[5]);
                break;
            }
            else {
                    system("clear");
                    printf("\nYou must \033[31mnot add\033[0m another pluviosity sensor!\n");
                    break;
            }
            default:
                printf("\n--- Invalid Option ---\n");
                break;

        }
    } while (option > 0 && option < 7);
}