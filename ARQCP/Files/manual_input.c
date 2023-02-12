#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void manual_input(unsigned long *frequencies, int *sensor_amounts)
{
    // Getting the frequencies from the user
    char *sensors[6];
    sensors[0] = "Temperature";
    sensors[1] = "Wind Velocity";
    sensors[2] = "Wind Direction";
    sensors[3] = "Atmospheric Humidity";
    sensors[4] = "Ground Humidity";
    sensors[5] = "Pluviosity";

    printf("\nInsert the \033[33mfrequencies\033[0m of the sensors (0 < freq < 86400) :\n\n");
    // Temperature
    do
    {
        printf("%s: ", sensors[0]);
        scanf("%ld", &frequencies[0]);
    if ((long)frequencies[0] <= 0 || frequencies[0] > 86400)
        {
            printf("\n\033[31mInvalid\033[0m frequency. Please insert a valid one.\n");
        }
    } while ((long)frequencies[0] <= 0 || frequencies[0] > 86400);

    // Wind Speed
    do
    {
        printf("%s: ", sensors[1]);
        scanf("%ld", &frequencies[1]);
        if ((long)frequencies[1] <= 0 || frequencies[1] > 86400)
        {
            printf("\n\033[31mInvalid\033[0m frequency. Please insert a valid one.\n");
        }
    } while ((long)frequencies[1] <= 0  || frequencies[1] > 86400);

    // Wind Direction
    do
    {
        printf("%s: ", sensors[2]);
        scanf("%ld", &frequencies[2]);
        if ((long)frequencies[2] <= 0 || frequencies[2] > 86400)
        {
            printf("\n\033[31mInvalid\033[0m frequency. Please insert a valid one.\n");
        }
    } while ((long)frequencies[2] <= 0 || frequencies[2] > 86400);

    // Atmospheric Humidity
    do
    {
        printf("%s: ", sensors[3]);
        scanf("%ld", &frequencies[3]);
        if ((long)frequencies[3] <= 0 || frequencies[3] > 86400)
        {
            printf("\n\033[31mInvalid\033[0m frequency. Please insert a valid one.\n");
        }
    } while ((long)frequencies[3] <= 0 || frequencies[3] > 86400);

    // Ground Humidity
    do
    {
        printf("%s: ", sensors[4]);
        scanf("%ld", &frequencies[4]);
        if ((long)frequencies[4] <= 0 || frequencies[4] > 86400)
        {
            printf("\n\033[31mInvalid\033[0m frequency. Please insert a valid one.\n");
        }
    } while ((long)frequencies[4] <= 0 || frequencies[4] > 86400);

    // Pluviosity
    do
    {
        printf("%s: ", sensors[5]);
        scanf("%ld", &frequencies[5]);
        if ((long)frequencies[5] <= 0   || frequencies[5] > 86400)
        {
            printf("\n\033[31mInvalid\033[0m frequency. Please insert a valid one.\n");
        }
    } while ((long)frequencies[5] <= 0 || frequencies[5] > 86400);

    printf("\nIntroduce the \033[33mnumber of sensors\033[0m of each type:\n\n");

    // Temperature
    do
    {
        printf("Nº Temperature Sensors: ");
        scanf("%d", &sensor_amounts[0]);
        if (sensor_amounts[0] <= 0 || sensor_amounts[0] > 50)
        {
            printf("\n\033[31mInvalid\033[0m amount. Please insert a valid one.\n");
        }
    } while (sensor_amounts[0] <= 0 || sensor_amounts[0] > 50);

    // Wind Speed
    do
    {
        printf("Nº Wind Speed Sensors: ");
        scanf("%d", &sensor_amounts[1]);
        if (sensor_amounts[1] <= 0 || sensor_amounts[1] > 50)
        {
            printf("\n\033[31mInvalid\033[0m amount. Please insert a valid one.\n");
        }
    } while (sensor_amounts[1] <= 0 || sensor_amounts[1] > 50);

    // Wind Direction
    do
    {
        printf("Nº Wind Direction Sensors: ");
        scanf("%d", &sensor_amounts[2]);
        if (sensor_amounts[2] <= 0 || sensor_amounts[2] > 50)
        {
            printf("\n\033[31mInvalid\033[0m amount. Please insert a valid one.\n");
        }
    } while (sensor_amounts[2] <= 0 || sensor_amounts[2] > 50);

    // Atmospheric Humidity
    do
    {
        printf("Nº Atmospheric Humidity Sensors: ");
        scanf("%d", &sensor_amounts[3]);
        if (sensor_amounts[3] <= 0 || sensor_amounts[3] > 50)
        {
            printf("\n\033[31mInvalid\033[0m amount. Please insert a valid one.\n");
        }
    } while (sensor_amounts[3] <= 0 || sensor_amounts[3] > 50);

    // Ground Humidity
    do
    {
        printf("Nº Ground Humidity Sensors: ");
        scanf("%d", &sensor_amounts[4]);
        if (sensor_amounts[4] <= 0 || sensor_amounts[4] > 50)
        {
            printf("\n\033[31mInvalid\033[0m amount. Please insert a valid one.\n");
        }
    } while (sensor_amounts[4] <= 0 || sensor_amounts[4] > 50);

    // Pluviosity
    do
    {
        printf("Nº Pluviosity Sensors: ");
        scanf("%d", &sensor_amounts[5]);
        if (sensor_amounts[5] <= 0 || sensor_amounts[5] > 50)
        {
            printf("\n\033[31mInvalid\033[0m amount. Please insert a valid one.\n");
        }
    } while (sensor_amounts[5] <= 0 || sensor_amounts[5] > 50);
}