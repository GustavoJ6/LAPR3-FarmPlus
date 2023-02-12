#include <stdio.h>
#include <stdint.h>

void dev_random(uint64_t buffer[]) {
    FILE *f;
    // The result to be returned
    int result;
    // "f" is equal to the path of the fille to be opened
    f = fopen("/dev/urandom", "r"); 
    // If the path does not exist, then an exception must be thrown
    if (f == NULL) {
        printf("Error: open() failed to open /dev/random for reading\n"); 
        }
    // Here buffer is filled with 2 random values 
    result = fread(buffer , sizeof(uint64_t), 2,f);
    fclose(f);
    if (result < 1) {
        printf("error , failed to read and words\n"); 
        }
}