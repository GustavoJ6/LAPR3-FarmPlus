#include <stdio.h>
#include "read_frequencies.h"

int configuration_file(unsigned long *frequencies, int *sensor_amounts) {
    // Getting the path to the file with the frequencies
    char path[100];

    int file_exists = 0;
    do {
    printf("\nInsert the \033[36mpath\033[0m to the file with the frequencies: ");
    scanf("%s", path);

    // Reading the frequencies from the file
    file_exists = read_frequencies(path, frequencies, sensor_amounts);
    } while (file_exists == 0);

    if (file_exists == 2) {
        printf("\033[31mError\033[0m: invalid frequency in the file, please verify the file and try again.\n");
        return 0;
    }

    else if (file_exists == 3) {
        printf("\033[31mError\033[0m: Missing frequency or sensor amount in the file.\n");
        return 0;
    }

    else if (file_exists == 4) {
        printf("\033[31mError\033[0m: Invalid sensor amount in the file (0 < sensor amount < 51).\n");
        return 0;
    }

    printf("Frequencies and Sensors amounts read \033[32msuccessfully.\033[0m\n");
    return 1;
}