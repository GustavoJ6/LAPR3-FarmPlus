#include "sensor.h"
void exportSensors(Sensor *temperature, Sensor *windSpeed , Sensor *windDir, Sensor *atmHum, Sensor *soilHum, Sensor *pluvio, int *sensorAmount){
    FILE *file;
    file = fopen("sensors_data_and_readings.csv", "w");
    fprintf(file, "Sensors Data and Readings");
    fprintf(file, "\nTemperature Sensors\n");
    fprintf(file, "Number of Sensors,Max Limit,Min Limit,Frequency(s)\n");
    fprintf(file, "%d,%d,%d,%ld", sensorAmount[0], temperature->max_limit, temperature->min_limit, temperature->frequency);
    for (int i = 0; i < sensorAmount[0]; i++){
        fprintf(file, "\nSensor ID - %d:", temperature[i].id);
        fprintf(file, "\nReadings: ");
        for(int j = 0; j < temperature->readings_size; j++){
            if (j == temperature->readings_size - 1){
                fprintf(file, "%d", (char) temperature[i].readings[j]);
        }else{
            fprintf(file, "%d,", (char) temperature[i].readings[j]);
        }
    }
    }

    fprintf(file, "\nWind Speed Sensors\n");
    fprintf(file, "Number of Sensors,Max Limit,Min Limit,Frequency(s)\n");
    fprintf(file, "%d,%d,%d,%ld", sensorAmount[1], windSpeed->max_limit, windSpeed->min_limit, windSpeed->frequency);
    for (int i = 0; i < sensorAmount[1]; i++){
        fprintf(file, "\nSensor ID - %d:", windSpeed[i].id);
        fprintf(file, "\nReadings: ");
        for(int j = 0; j < windSpeed->readings_size; j++){
        if (j == windSpeed->readings_size - 1){
                fprintf(file, "%d", windSpeed[i].readings[j]);
        } else {
            fprintf(file, "%d,", windSpeed[i].readings[j]);
        }
    }
    }

    fprintf(file, "\nWind Direction Sensors\n");
    fprintf(file, "Number of Sensors,Max Limit,Min Limit,Frequency(s)\n");
    fprintf(file, "%d,%d,%d,%ld", sensorAmount[2], windDir->max_limit, windDir->min_limit, windDir->frequency);
    for (int i = 0; i < sensorAmount[2]; i++){
        fprintf(file, "\nSensor ID - %d:", windDir[i].id);
        fprintf(file, "\nReadings: ");
        for(int j = 0; j < windDir->readings_size; j++){
            if (j == windDir->readings_size - 1){
                fprintf(file, "%d", windDir[i].readings[j]);
        } else {
            fprintf(file, "%d,", windDir[i].readings[j]);
        }
    }
    }

    fprintf(file, "\nAtmospheric Humidity Sensors\n");
    fprintf(file, "Number of Sensors,Max Limit,Min Limit,Frequency(s)\n");
    fprintf(file, "%d,%d,%d,%ld", sensorAmount[3], atmHum->max_limit, atmHum->min_limit, atmHum->frequency);
    for (int i = 0; i < sensorAmount[3]; i++){
            fprintf(file, "\nSensor ID - %d:", atmHum[i].id);
            fprintf(file, "\nReadings: ");
        for(int j = 0; j < atmHum->readings_size; j++){
           if (j == atmHum->readings_size - 1){
                fprintf(file, "%d", atmHum[i].readings[j]);
        }else{
            fprintf(file, "%d,", atmHum[i].readings[j]);
        }
    }
}

    fprintf(file, "\nSoil Humidity Sensors\n");
    fprintf(file, "Number of Sensors,Max Limit,Min Limit,Frequency(s)\n");
    fprintf(file, "%d,%d,%d,%ld", sensorAmount[4], soilHum->max_limit, soilHum->min_limit, soilHum->frequency);
    for (int i = 0; i < sensorAmount[4]; i++){
        fprintf(file, "\nSensor ID - %d:", soilHum[i].id);
        fprintf(file, "\nReadings: ");
        for(int j = 0; j < soilHum->readings_size; j++){
            if (j == soilHum->readings_size - 1){
                fprintf(file, "%d", soilHum[i].readings[j]);
        }else{
            fprintf(file, "%d,", soilHum[i].readings[j]);
        }
    }
}

    fprintf(file, "\nPluviosity Sensors\n");
    fprintf(file, "Number of Sensors,Max Limit,Min Limit,Frequency(s)\n");
    fprintf(file, "%d,%d,%d,%ld", sensorAmount[5], pluvio->max_limit, pluvio->min_limit, pluvio->frequency);
    for (int i = 0; i < sensorAmount[5]; i++){
            fprintf(file, "\nSensor ID - %d:", pluvio[i].id);
            fprintf(file, "\nReadings: ");
        for(int j = 0; j < pluvio->readings_size; j++){
            if (j == pluvio->readings_size - 1){
                fprintf(file, "%d", pluvio[i].readings[j]);
        }else{
            fprintf(file, "%d,", pluvio[i].readings[j]);
            }
    }
}

    fclose(file);
    if(file == NULL){
        printf("\nError Exporting the File with the Sensors Data.\n");
    }else{
        printf("File with the Sensors Data Exported  \033[32mSuccesfully!\033[0m\n\n");
    }
    }
