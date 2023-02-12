#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "remove_spaces.h"

#define MAX_LINE_LENGTH 100
#define INVALID_FILE_PATH 0
#define VALID_EVERYTHING 1
#define INVALID_FREQUENCY 2
#define INVALID_SPACING 3
#define INVALID_SENSOR_AMOUNT 4

int read_frequencies(char *filename, unsigned long *frequencies, int *sensor_amounts)
{

    FILE *fp = fopen(filename, "r");

    if (fp == NULL)
    {
        printf("\033[31mError\033[0m: opening file %s\n", filename);
        //fclose(fp);
        return 0;
    }

    else
    {
    char line[MAX_LINE_LENGTH];
    int index = 0;
    
    while (fgets(line, MAX_LINE_LENGTH, fp) != NULL)
    {
        if (line[0] == '/' && line[1] == '/')
        {

            switch (line[2])
            {
            case 'T':
                index = 0;
                break;
            case 'V':
                index = 1;
                break;
            case 'D':
                index = 2;
                break;
            case 'A':
                index = 3;
                break;
            case 'S':
                index = 4;
                break;
            case 'P':
                index = 5;
                break;
            default:
                // Invalid option
                continue;
            }

            if (fgets(line, sizeof(line), fp) != NULL)
            {
                // Read the frequency value
                char *token = strtok(line, ":");
                token = strtok(NULL, ":");
                if (token != NULL)
                {
                    unsigned long frequency = strtoul(token, NULL, 10);
                    if (frequency > 0 && frequency < 86401) {
                        frequencies[index] = strtoul(token, NULL, 10);

                        // Read the inferior limit
                        if (fgets(line, sizeof(line), fp) != NULL) {
                            char *divisor = strtok(line, ":");
                            divisor = strtok(NULL, ":");
                            if (divisor != NULL) {
                                int sensor_amount = strtol(divisor, NULL, 10);
                                if (sensor_amount > 0 && sensor_amount < 51) {
                                    sensor_amounts[index] = sensor_amount;
                                }
                                else return INVALID_SENSOR_AMOUNT;
                            }
                            else return INVALID_SPACING;
                        }
                        else return INVALID_SENSOR_AMOUNT;
                    }
                    else return INVALID_FREQUENCY;
                }
                else return INVALID_SPACING;
            }
            else return INVALID_SPACING;
        }
    }
    }

    fclose(fp);
    return VALID_EVERYTHING;
}