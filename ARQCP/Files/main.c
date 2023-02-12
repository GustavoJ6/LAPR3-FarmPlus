#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include "matrix_analysis.h"
#include "configuration_file.h"
#include "manual_input.h"
#include "restrictions.h"
#include "sensor.h"
#include "set_restrictions.h"
#include "allocate_memory_sensors.h"
#include "sensor_h.h"
#include "set_sensor.h"
#include "print_matrix.h"
#include "export_daily_matrix.h"
#include "max_min_avg_reset.h"
#include "export_sensors.h"
#include "treat_choices.h"


// Define the limits
#define MIN_LIMIT_TEMPERATURE 0
#define MAX_LIMIT_TEMPERATURE 25
#define MIN_LIMIT_WIND_SPEED 0
#define MAX_LIMIT_WIND_SPEED 115
#define MIN_LIMIT_WIND_DIRECTION 0
#define MAX_LIMIT_WIND_DIRECTION 359
#define MIN_LIMIT_ATMOSPHERIC_HUMIDITY 0
#define MAX_LIMIT_ATMOSPHERIC_HUMIDITY 100
#define MIN_LIMIT_SOIL_HUMIDITY 0
#define MAX_LIMIT_SOIL_HUMIDITY 100
#define MIN_LIMIT_PLUVIOSITY 0
#define MAX_LIMIT_PLUVIOSITY 135

// Global variables
uint64_t buffer[2];
uint64_t state = 0;  
uint64_t inc = 0;

// Daily Data Matrix
int matrix[6][3];
int maxMinAvg[3];

int main() {
    // Let the user select the way to insert the frequencies
    int option;
    printf("\nHow would you like to insert the \033[36mfrequencies\033[0m and the \033[36mamount\033[0m of sensors?\n\n");
    do {
    printf("1 - Configuration file\n");
    printf("2 - Manually\n\n");
    printf("\033[32mOption\033[0m: ");
    scanf("%d", &option);
    } while (option != 1 && option != 2);
    
    // Get the frequencies and the limits
    unsigned char sensor_types[6] = {'T', 'V', 'D', 'P', 'H', 'S'};
    unsigned long frequencies[6];
    int sensor_amounts[6];

    // Check if the file is valid
    int valid_file = 1;
    // If the user selected the configuration file option
    if (option == 1) {valid_file = configuration_file(frequencies, sensor_amounts);}
    // If the user selected the manual input option
    else if (option == 2) {manual_input(frequencies, sensor_amounts);}
    
    // If the file is valid
    if (valid_file == 1) {
        
        // Set the restrictions(sensor limits and the number of sensors of each type)
        Restrictions *restrict_sensor = calloc(1, sizeof(Restrictions));
        set_restrictions(restrict_sensor, sensor_amounts, MIN_LIMIT_TEMPERATURE, MAX_LIMIT_TEMPERATURE, MIN_LIMIT_WIND_SPEED, MAX_LIMIT_WIND_SPEED, MIN_LIMIT_WIND_DIRECTION, MAX_LIMIT_WIND_DIRECTION, MIN_LIMIT_ATMOSPHERIC_HUMIDITY, MAX_LIMIT_ATMOSPHERIC_HUMIDITY, MIN_LIMIT_SOIL_HUMIDITY, MAX_LIMIT_SOIL_HUMIDITY, MIN_LIMIT_PLUVIOSITY, MAX_LIMIT_PLUVIOSITY);
        
        // Allocate memory for the sensors
        Sensor *temperature_sensors = allocate_memory_sensors(restrict_sensor->sensor_amounts[0]);
        Sensor *atmospheric_humidity_sensors = allocate_memory_sensors(restrict_sensor->sensor_amounts[3]);
        Sensor *soil_humidity_sensors = allocate_memory_sensors(restrict_sensor->sensor_amounts[4]);
        Sensor *pluviosity_sensors = allocate_memory_sensors(restrict_sensor->sensor_amounts[5]);
        Sensor *wind_speed_sensors = allocate_memory_sensors(restrict_sensor->sensor_amounts[1]);
        Sensor *wind_direction_sensors = allocate_memory_sensors(restrict_sensor->sensor_amounts[2]);
        // Variable that keeps track of the user's choices.
        int iterator = 0;
        do{
            printf("\n-----------\n|MAIN MENU|\n-----------\n\n");
            printf("\033[34m1\033[0m - Add sensor.\n");
            printf("\033[35m2\033[0m - Remove sensor.\n");
            printf("\033[32m3\033[0m - Alter sensor frequency.\n");
            printf("\033[33m4\033[0m - Display sensors amounts.\n");
            printf("\033[33m5\033[0m - Dispaly sensors frequencies.\n");
            printf("\033[33m6\033[0m - Display sensors limits.\n\n");
            printf("\033[31m0\033[0m - View/export readings/analysis data.\n\n");
            printf("\033[32mOption\033[0m: ");
            scanf("%d", &iterator);
            treatChoice(iterator, sensor_amounts, frequencies, &temperature_sensors, &atmospheric_humidity_sensors, &soil_humidity_sensors, &pluviosity_sensors, &wind_speed_sensors, &wind_direction_sensors, MIN_LIMIT_TEMPERATURE, MAX_LIMIT_TEMPERATURE, MIN_LIMIT_WIND_SPEED, MAX_LIMIT_WIND_SPEED, MIN_LIMIT_WIND_DIRECTION, MAX_LIMIT_WIND_DIRECTION, MIN_LIMIT_ATMOSPHERIC_HUMIDITY, MAX_LIMIT_ATMOSPHERIC_HUMIDITY, MIN_LIMIT_SOIL_HUMIDITY, MAX_LIMIT_SOIL_HUMIDITY, MIN_LIMIT_PLUVIOSITY, MAX_LIMIT_PLUVIOSITY);  
            if (iterator < 0 || iterator > 6) iterator = 6;          
        }while (iterator > 0 && iterator < 7);

        // If the user selected the option 0
        if(iterator==0){     

        // Set the sensors
        for (unsigned short i = 0; i < sensor_amounts[0]; i++) {
            set_sensor(&temperature_sensors[i], &temperature_sensors[i], i, sensor_types[0], restrict_sensor[0].temperature_limits[1], restrict_sensor[0].temperature_limits[0], frequencies[0]);
        }

        for (unsigned short i = 0; i < sensor_amounts[1]; i++) {
            set_sensor(&wind_speed_sensors[i], &wind_speed_sensors[i], i, sensor_types[1], restrict_sensor[0].wind_speed_limits[1], restrict_sensor[0].wind_speed_limits[0], frequencies[1]);
        }

        for (unsigned short i = 0; i < sensor_amounts[2]; i++) {
            set_sensor(&wind_direction_sensors[i], &wind_direction_sensors[i], i, sensor_types[2], restrict_sensor[0].wind_direction_limits[1], restrict_sensor[0].wind_direction_limits[0], frequencies[2]);
        }

        for (unsigned short i = 0; i < sensor_amounts[5]; i++) {
            if (i >= sensor_amounts[0]) {
                set_sensor(&pluviosity_sensors[i], &temperature_sensors[0], i, sensor_types[3], restrict_sensor[0].pluviosity_limits[1], restrict_sensor[0].pluviosity_limits[0], frequencies[5]);
            }
            else set_sensor(&pluviosity_sensors[i], &temperature_sensors[i], i, sensor_types[3], restrict_sensor[0].pluviosity_limits[1], restrict_sensor[0].pluviosity_limits[0], frequencies[5]);
        }

        for (unsigned short i = 0; i < sensor_amounts[3]; i++) {
            if (i >= sensor_amounts[5]) {
                set_sensor(&atmospheric_humidity_sensors[i], &pluviosity_sensors[0], i, sensor_types[4], restrict_sensor[0].atmospheric_humidity_limits[1], restrict_sensor[0].atmospheric_humidity_limits[0], frequencies[3]);
            }
            else set_sensor(&atmospheric_humidity_sensors[i], &pluviosity_sensors[i], i, sensor_types[4], restrict_sensor[0].atmospheric_humidity_limits[1], restrict_sensor[0].atmospheric_humidity_limits[0], frequencies[3]);
        }

        for (unsigned short i = 0; i < sensor_amounts[4]; i++) {
            if (i >= sensor_amounts[5]) {
                set_sensor(&soil_humidity_sensors[i], &pluviosity_sensors[0], i, sensor_types[5], restrict_sensor[0].soil_humidity_limits[1], restrict_sensor[0].soil_humidity_limits[0], frequencies[4]);
            }
            else set_sensor(&soil_humidity_sensors[i], &pluviosity_sensors[i], i, sensor_types[5], restrict_sensor[0].soil_humidity_limits[1], restrict_sensor[0].soil_humidity_limits[0], frequencies[4]);
        }

    //Analyzing the sensors to obtain the maximum, minimum and average values of each one
                //Reset the values of the aux array for the max, min and average values
                maxMinAvgReset(maxMinAvg);
                for(unsigned short i = 0; i < sensor_amounts[0]; i++){
                 maxMinSumCalculator(&temperature_sensors[i], temperature_sensors[i].readings_size, sensor_types[0], maxMinAvg);
                }

                // Add the data to the matrix.
                *(*matrix) = *maxMinAvg;
                *(*(matrix)+1) = *(maxMinAvg + 1);
                *(*(matrix)+2) = *(maxMinAvg + 2) / (sensor_amounts[0] * temperature_sensors[0].readings_size);

                //Reset the values of the aux array for the max, min and average values
                maxMinAvgReset(maxMinAvg);
                for(unsigned short i = 0; i < sensor_amounts[1]; i++){
                    maxMinSumCalculator(&wind_speed_sensors[i], wind_speed_sensors[i].readings_size, sensor_types[1], maxMinAvg);
                }

                // Add the data to the matrix.
                *(*(matrix+1)) = *maxMinAvg;
                *(*(matrix + 1)+1) = *(maxMinAvg + 1);
                *(*(matrix + 1)+2) = *(maxMinAvg + 2) / (sensor_amounts[1] * wind_speed_sensors[0].readings_size);


                //Reset the values of the aux array for the max, min and average values
                maxMinAvgReset(maxMinAvg);
                for(unsigned short i = 0; i < sensor_amounts[2]; i++){
                    maxMinSumCalculator(&wind_direction_sensors[i], wind_direction_sensors[i].readings_size, sensor_types[2], maxMinAvg);
                }

                // Add the data to the matrix.
                *(*(matrix+2)) = *maxMinAvg;
                *(*(matrix + 2)+1) = *(maxMinAvg + 1);
                *(*(matrix + 2)+2) = *(maxMinAvg + 2) / (sensor_amounts[2] * wind_direction_sensors[0].readings_size);

                //Reset the values of the aux array for the max, min and average values
                maxMinAvgReset(maxMinAvg);
                for(unsigned short i = 0; i < sensor_amounts[3]; i++){
                    maxMinSumCalculator(&atmospheric_humidity_sensors[i], atmospheric_humidity_sensors[i].readings_size, sensor_types[4], maxMinAvg);
                }

                // Add the data to the matrix.
                *(*(matrix+3)) = *maxMinAvg;
                *(*(matrix + 3)+1) = *(maxMinAvg + 1);
                *(*(matrix + 3)+2) = *(maxMinAvg + 2) / (sensor_amounts[3] * atmospheric_humidity_sensors[0].readings_size);

                //Reset the values of the aux array for the max, min and average values
                maxMinAvgReset(maxMinAvg);
                for(unsigned short i = 0; i < sensor_amounts[4]; i++){
                    maxMinSumCalculator(&soil_humidity_sensors[i], soil_humidity_sensors[i].readings_size, sensor_types[5], maxMinAvg);
                }

                // Add the data to the matrix.
                *(*(matrix+4)) = *maxMinAvg;
                *(*(matrix + 4)+1) = *(maxMinAvg + 1);
                *(*(matrix + 4)+2) = *(maxMinAvg + 2) / (sensor_amounts[4] * soil_humidity_sensors[0].readings_size);


                //Reset the values of the aux array for the max, min and average values
                maxMinAvgReset(maxMinAvg);
                for(unsigned short i = 0; i < sensor_amounts[5]; i++){
                    maxMinSumCalculator(&pluviosity_sensors[i], pluviosity_sensors[i].readings_size, sensor_types[3], maxMinAvg);
                }

                // Add the data to the matrix.
                *(*(matrix+5)) = *maxMinAvg;
                *(*(matrix + 5)+1) = *(maxMinAvg + 1);
                *(*(matrix + 5)+2) = *(maxMinAvg + 2) / (sensor_amounts[5] * pluviosity_sensors[0].readings_size);


                //Print the Daily Matrix
                printMatrix(matrix);

                //Export the Daily Matrix to a .csv File
                exportDailyMatrix(matrix);

                //Export the sensors to a .csv File
                exportSensors(temperature_sensors, wind_speed_sensors, wind_direction_sensors, atmospheric_humidity_sensors, soil_humidity_sensors, pluviosity_sensors, sensor_amounts);


                // Free allocated memory for sensor readings
                for (unsigned short i = 0; i < sensor_amounts[0]; i++) {
                    free(temperature_sensors[i].readings);
                }
                for (unsigned short i = 0; i < sensor_amounts[1]; i++) {
                    free(wind_speed_sensors[i].readings);
                }
                for (unsigned short i = 0; i < sensor_amounts[2]; i++) {
                    free(wind_direction_sensors[i].readings);
                }
                for (unsigned short i = 0; i < sensor_amounts[3]; i++) {
                    free(atmospheric_humidity_sensors[i].readings);
                }
                for (unsigned short i = 0; i < sensor_amounts[4]; i++) {
                    free(soil_humidity_sensors[i].readings);
                }
                for (unsigned short i = 0; i < sensor_amounts[5]; i++) {
                    free(pluviosity_sensors[i].readings);
                }

        // Free the memory
        free(restrict_sensor);
        free(temperature_sensors);
        free(atmospheric_humidity_sensors);
        free(soil_humidity_sensors);
        free(pluviosity_sensors);
        free(wind_speed_sensors);
        free(wind_direction_sensors);
        }
    }
    return 0;
}