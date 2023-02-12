#include <stdio.h>
void exportDailyMatrix(int matrix[6][3]){
    FILE *fp;
    fp = fopen("daily_matrix.csv", "w");
    fprintf(fp, "Daily Data Matrix \n");
    fprintf(fp, "Max,Min,Average\n");
    for(int i = 0; i<6; i++){
        for(int j = 0; j<2; j++){
            fprintf(fp, "%d,", matrix[i][j]);
    }
        fprintf(fp, "%d \n", matrix[i][2]);
}
    fclose(fp);

    if(fp == NULL){
        printf("Error creating file for the Daily Data Matrix!\n");
    }else{
        printf("File for the Daily Data Matrix Exported  \033[32mSuccessfully!\033[0m\n");
    }
}