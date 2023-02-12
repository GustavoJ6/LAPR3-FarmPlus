#include <stdio.h>
#include "sensor.h"
void maxMinSumCalculator(Sensor *sensors , unsigned long readingsSize, unsigned char sensorType, int *ptrdest){

if(sensorType != 'T'){
        for(int iteration = 0; iteration<readingsSize; iteration++){
        if(sensors->readings[iteration]>*ptrdest) *ptrdest = sensors->readings[iteration];
        if(sensors->readings[iteration]<*(ptrdest+1)) *(ptrdest+1) = sensors->readings[iteration];
        *(ptrdest+2) += sensors->readings[iteration];
        }

    } else {
        for(int iteration = 0; iteration<readingsSize; iteration++){
        if((char) sensors->readings[iteration]>*ptrdest) *ptrdest = (char) sensors->readings[iteration];
        if((char)sensors->readings[iteration]<*(ptrdest+1)) *(ptrdest+1) = (char)sensors->readings[iteration];
        *(ptrdest+2) += (char) sensors->readings[iteration];
        }
    }
}