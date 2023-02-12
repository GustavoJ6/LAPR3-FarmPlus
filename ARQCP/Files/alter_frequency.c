#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void alter_frequency(unsigned long * frequencies){
    int option = 0;
    do {
        printf("\n------------------\n|ALTER FREQUENCY|\n------------------\n\n");
        printf("\033[33m1\033[0m - Temperature.\n");
        printf("\033[34m2\033[0m - Wind Speed.\n");
        printf("\033[33m3\033[0m - Wind Direction.\n");
        printf("\033[34m4\033[0m - Atmospheric Humidity.\n");
        printf("\033[33m5\033[0m - Soil Humidity.\n");
        printf("\033[34m6\033[0m - Pluviosity.\n\n");
        printf("\033[31m0\033[0m - Go back to the main menu.\n\n");
        printf("\033[32mOption\033[0m: ");
        scanf("%d", &option);
        switch(option)
        {
            case 0:
                system("clear");
                printf("\n\033[33mGoing back\033[0m to the main menu...\n\n");
                sleep(1.5);
                system("clear");
                break;
            case 1:
            do {
                printf("\nChoose the \033[36mnew\033[0m frequency for temperature sensors: ");
                scanf("%ld", &frequencies[0]);
                system("clear");
                if (frequencies[0] < 1 || frequencies[0] > 86400) {
                    printf("\n--- INVALID FREQUENCY ---\n");
                    printf("The frequency must between 1 and 86400.\n");
                }else{
                    printf("\n• The frequency for Temperature sensors is \033[35mnow\033[0m %ld seconds.\n", frequencies[0]);
                }
            } while (frequencies[0] < 1 || frequencies[0] > 86400);
                printf("\n");
                break;
            case 2:
            do {
                printf("\nChoose the \033[36mnew\033[0m frequency for wind speed sensors: ");
                scanf("%ld", &frequencies[1]);
                system("clear");
                if (frequencies[1] < 1 || frequencies[1] > 86400) {
                    printf("\n--- INVALID FREQUENCY ---\n");
                    printf("The frequency must between 1 and 86400.\n");
                } else {
                    printf("\n• The frequency for Wind Speed sensors is \033[35mnow\033[0m %ld seconds.\n", frequencies[1]);
                }
            } while (frequencies[1] < 1 || frequencies[1] > 86400);
                printf("\n");
                break;
            case 3:
            do {
                printf("\nChoose the \033[36mnew\033[0m frequency for wind direction sensors: ");
                scanf("%ld", &frequencies[2]);
                system("clear");
                if (frequencies[2] < 1 || frequencies[2] > 86400) {
                    printf("\n--- INVALID FREQUENCY ---\n");
                    printf("The frequency must between 1 and 86400.\n");
                } else {
                    printf("\n• The frequency for Wind Direction sensors is \033[35mnow\033[0m %ld seconds.\n", frequencies[2]);
                }
            } while (frequencies[2] < 1 || frequencies[2] > 86400);
                printf("\n");
                break;
            case 4:
            do {
                printf("\nChoose the \033[36mnew\033[0m frequency for atmospheric humidity sensors: ");
                scanf("%ld", &frequencies[3]);
                system("clear");
                if (frequencies[3] < 1 || frequencies[3] > 86400) {
                    printf("\n--- INVALID FREQUENCY ---\n");
                    printf("The frequency must between 1 and 86400.\n");
                } else {
                    printf("\n• The frequency for Atmospheric Humidity sensors is \033[35mnow\033[0m %ld seconds.\n", frequencies[3]);
                }
            } while (frequencies[3] < 1 || frequencies[3] > 86400);
                printf("\n");
                break;
            case 5:
            do {
                printf("\nChoose the \033[36mnew\033[0m frequency for soil humidity sensors: ");
                scanf("%ld", &frequencies[4]);
                system("clear");
                if (frequencies[4] < 1 || frequencies[4] > 86400) {
                    printf("\n--- INVALID FREQUENCY ---\n");
                    printf("The frequency must between 1 and 86400.\n");
                } else {
                    printf("\n• The frequency for Soil Humidity sensors is \033[35mnow\033[0m %ld seconds.\n", frequencies[4]);
                }
            } while (frequencies[4] < 1 || frequencies[4] > 86400);
                printf("\n");
                break;
            case 6:
            do {
                printf("\nChoose the \033[36mnew\033[0m frequency for pluviosity sensors: ");
                scanf("%ld", &frequencies[5]);
                system("clear");
                if (frequencies[5] < 1  || frequencies[5] > 86400) {
                    printf("\n--- INVALID FREQUENCY ---\n");
                    printf("The frequency must between 1 and 86400.\n");
                } else {
                    printf("\n• The frequency for Pluviosity sensors is \033[35mnow\033[0m %ld seconds.\n", frequencies[5]);
                }
            } while (frequencies[5] < 1 || frequencies[5] > 86400);
                printf("\n");
                break;
            default:
                printf("\n--- INVALID CHARACTER ---\n");
                break;
        }
    } while (option > 0 && option < 7);
}