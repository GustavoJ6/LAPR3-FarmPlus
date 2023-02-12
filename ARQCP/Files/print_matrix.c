#include <stdio.h>
void printMatrix(int matrix[6][3]){
    printf("\n                 --------\n                 |Matrix|\n                 --------\n\n");
    printf("                      \033[31mMax\033[0m  |   \033[36mMin\033[0m | \033[33mAverage\033[0m\n");
    for(int lines = 0; lines < 6; lines++){
        if(lines == 0){
            printf("%*s", -24, "Temperature: ");
        }else if(lines == 1){
            printf("%*s", -24, "Wind Speed: ");
        }else if(lines == 2){
            printf("%*s", -24, "Wind Direction: ");
        }else if(lines == 3){
            printf("%*s", -24, "Atmospheric Humidity: ");
        }else if(lines == 4){
            printf("%*s", -24, "Soil Humidity");
        }else if(lines ==5){
            printf("%*s", -24, "Pluviosity: ");
        }
        for(int columns = 0; columns<3; columns++){
            printf("%-7d", *(*(matrix+lines)+columns));
        }
        printf("\n");
    }
    printf("\n");
}