#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "sensor.h"

void remove_sensor(int * sensor_amounts, Sensor **temperature_sensors, Sensor **atmospheric_humidity_sensors, Sensor **soil_humidity_sensors, Sensor **pluviosity_sensors, Sensor **wind_speed_sensors, Sensor **wind_direction_sensors){
    int option = 0;
    do {
        printf("\n---------------\n|REMOVE SENSOR|\n---------------\n\n");
        printf("\033[35m1\033[0m - Remove Temperature Sensor.\n");
        printf("\033[35m2\033[0m - Remove Wind Speed Sensor.\n");
        printf("\033[35m3\033[0m - Remove Wind Direction Sensor.\n");
        printf("\033[35m4\033[0m - Remove Atmospheric Humidity Sensor.\n");
        printf("\033[35m5\033[0m - Remove Soil Humidity Sensor.\n");
        printf("\033[35m6\033[0m - Remove Pluviosity Sensor.\n\n");
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
                if(sensor_amounts[0] == 1){
                    system("clear");
                    printf("\nYou must \033[31mnot remove\033[0m the last temperature sensor!\n");
                    break;
                }else{
                    sensor_amounts[0]--;
                    *temperature_sensors = realloc(*temperature_sensors, sensor_amounts[0] * sizeof(Sensor));
                    system("clear");
                    printf("\n• Temperature sensor with id %d, \033[31mremoved\033[0m.\n", sensor_amounts[0]+1);
                    break;
                }
            case 2:
                if(sensor_amounts[1] == 1){
                    system("clear");
                    printf("\nYou must \033[31mnot remove\033[0m the last wind speed sensor!\n");
                    break;
                }else{
                    sensor_amounts[1]--;
                    *wind_speed_sensors = realloc(*wind_speed_sensors, sensor_amounts[1] * sizeof(Sensor));
                    system("clear");
                    printf("\n• Wind speed sensor with id %d, \033[31mremoved\033[0m.\n", sensor_amounts[1]+1);
                    break;
                }
            case 3:
                if(sensor_amounts[2] == 1){
                    system("clear");
                    printf("\nYou must \033[31mnot remove\033[0m the last wind direction sensor!\n");
                    break;
                }else{
                    sensor_amounts[2]--;
                    *wind_direction_sensors = realloc(*wind_direction_sensors, sensor_amounts[2] * sizeof(Sensor));
                    system("clear");
                    printf("\n• Wind direction sensor with id %d, \033[31mremoved\033[0m.\n", sensor_amounts[2]+1);
                    break;
                }
            case 4:
                if(sensor_amounts[3] == 1){
                    system("clear");
                    printf("\nYou must \033[31mnot remove\033[0m the last atmospheric humidity sensor!\n");
                    break;
                }else{
                    sensor_amounts[3]--;
                    *atmospheric_humidity_sensors = realloc(*atmospheric_humidity_sensors, sensor_amounts[3] * sizeof(Sensor));
                    system("clear");
                    printf("\n• Atmospheric humidity sensor with id %d, \033[31mremoved\033[0m.\n", sensor_amounts[3]+1);
                    break;
                }
            case 5:
                if(sensor_amounts[4] == 1){
                    system("clear");
                    printf("\nYou must \033[31mnot remove\033[0m the last soil humidity sensor!\n");
                    break;
                }else{
                    sensor_amounts[4]--;
                    *soil_humidity_sensors = realloc(*soil_humidity_sensors, sensor_amounts[4] * sizeof(Sensor));
                    system("clear");
                    printf("\n• Soil humidity sensor with id %d, \033[31mremoved\033[0m.\n", sensor_amounts[4]+1);
                    break;
                }
            case 6:
                if(sensor_amounts[5] == 1){
                    system("clear");
                    printf("\nYou must \033[31mnot remove\033[0m the last pluviosity sensor!\n");
                    break;
                }else{
                    sensor_amounts[5]--;
                    *pluviosity_sensors = realloc(*pluviosity_sensors, sensor_amounts[5] * sizeof(Sensor));
                    system("clear");
                    printf("\n• Pluviosity sensor with id %d, \033[31mremoved\033[0m.\n", sensor_amounts[5]+1);
                    break;
                }
            default:
                system("clear");
                printf("\n--- Inavalid Option ---\n");
                break;
        }
    } while (option > 0 && option < 7);
}