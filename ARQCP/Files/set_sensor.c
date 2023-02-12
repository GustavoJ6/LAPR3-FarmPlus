#include <stdlib.h>
#include "gen_sens_temp.h"
#include "gen_sens_velc_vento.h"
#include "gen_sens_dir_vento.h"
#include "gen_sens_humd_atm.h"
#include "gen_sens_humd_solo.h"
#include "gen_sens_pluvio.h"
#include "pcg.h"
#include "alter_global.h"
#include "sensor.h"

void set_sensor(Sensor * sensor, Sensor * sensor_to_use, unsigned short id, unsigned char sensor_type, unsigned short max_limit, unsigned short min_limit, unsigned long frequency)
{
    sensor->id = id;
    sensor->sensor_type = sensor_type;
    sensor->max_limit = max_limit;
    sensor->min_limit = min_limit;
    sensor->frequency = frequency;
    // A frequencia é dada em segundos
    sensor->readings_size = (86400 / frequency);
    sensor->readings = (unsigned short *)calloc(sensor->readings_size, sizeof(unsigned short));

    // Max Number of faults before generating a new value for state and inc
    int excess_fauls = 3;

    // You can not initialize variables in the middle of a switch
    int count = 0;
    int position = 0;
    char ult_temp;
    unsigned char ult_velc_vento;
    unsigned short ult_dir_vento;
    unsigned char ult_pluvio;
    unsigned char ult_hmd_atm;
    unsigned char ult_hmd_solo;

    switch (sensor_type)
    {
    case 'T':
        count = 0;
        ult_temp = (pcg32_random_r() & 0xF);
        for (int iteration = 0; iteration < sensor->readings_size; iteration++)
        {
            ult_temp = gen_sens_temp(ult_temp, iteration);
            if (ult_temp < (char) sensor->min_limit || ult_temp > (char) sensor->max_limit)
            {
                count++;
                sensor->readings[iteration] = ult_temp;
            }
            else
            {
                count = 0;
                sensor->readings[iteration] = ult_temp;
            }

            if (count == excess_fauls)
            {
                iteration = iteration - excess_fauls;
                count = 0;
                alterGlobal();
            }
        }
        break;

    case 'V':
        count = 0;
        ult_velc_vento = (pcg32_random_r() & 0x3F);
        for (int iteration = 0; iteration < sensor->readings_size; iteration++)
        {
            ult_velc_vento = gen_sens_velc_vento(ult_velc_vento);
            if (ult_velc_vento < sensor->min_limit || ult_velc_vento > sensor->max_limit)
            {
                count++;
                sensor->readings[iteration] = ult_velc_vento;
            }
            else
            {
                count = 0;
                sensor->readings[iteration] = ult_velc_vento;
            }
            if (count == excess_fauls)
            {
                iteration = iteration - excess_fauls;
                count = 0;
                alterGlobal();
            }
        }
        break;

    case 'D':
        count = 0;
        ult_dir_vento = (pcg32_random_r() & 0xFF);
        for (int iteration = 0; iteration < sensor->readings_size; iteration++)
        {
            ult_dir_vento = gen_sens_dir_vento(ult_dir_vento);
            if (ult_dir_vento < sensor->min_limit || ult_dir_vento > sensor->max_limit)
            {
                count++;
                sensor->readings[iteration] = ult_dir_vento;
            }
            else
            {
                count = 0;
                sensor->readings[iteration] = ult_dir_vento;
            }
            if (count == excess_fauls)
            {
                iteration = iteration - excess_fauls;
                count = 0;
                alterGlobal();
            }
        }
        break;

    case 'P':
        position = 0;
        ult_pluvio = (pcg32_random_r() & 0x3F);
        for (int iteration = 0; iteration < sensor->readings_size; iteration++)
        {
            ult_pluvio = gen_sens_pluvio(ult_pluvio, sensor_to_use->readings[pcg32_random_r() % sensor_to_use->readings_size]);
            if (ult_pluvio < sensor->min_limit || ult_pluvio > sensor->max_limit)
            {
                count++;
                sensor->readings[iteration] = ult_pluvio;
                position++;
            }
            else
            {
                count = 0;
                sensor->readings[iteration] = ult_pluvio;
                position++;
            }
            if (count == excess_fauls)
            {
                iteration = iteration - excess_fauls;
                count = 0;
                alterGlobal();
                position = position - excess_fauls;
            }
        }
        break;

    case 'H':
        ult_hmd_atm = (pcg32_random_r() & 0x3F);
        position = 0;
        for (int iteration = 0; iteration < sensor->readings_size; iteration++)
        {
            ult_hmd_atm = gen_sens_humd_atm(ult_hmd_atm, sensor_to_use->readings[pcg32_random_r() % sensor_to_use->readings_size]);
            if (ult_hmd_atm < sensor->min_limit || ult_hmd_atm > sensor->max_limit)
            {
                count++;
                sensor->readings[iteration] = ult_hmd_atm;
                position++;
            }
            else
            {
                count = 0;
                sensor->readings[iteration] = ult_hmd_atm;
                position++;
            }
            if (count == excess_fauls)
            {
                iteration = iteration - excess_fauls;
                count = 0;
                alterGlobal();
                position = position - excess_fauls;
            }
        }
        break;

    case 'S':
        ult_hmd_solo = (pcg32_random_r() & 0x3F);
        position = 0;
        for (int iteration = 0; iteration < sensor->readings_size; iteration++)
        {
            ult_hmd_solo = gen_sens_humd_solo(ult_hmd_solo, sensor_to_use->readings[pcg32_random_r() % sensor_to_use->readings_size]);
            if (ult_hmd_solo < sensor->min_limit || ult_hmd_solo > sensor->max_limit)
            {
                count++;
                sensor->readings[iteration] = ult_hmd_solo;
                position++;
            }
            else
            {
                count = 0;
                sensor->readings[iteration] = ult_hmd_solo;
                position++;
            }
            if (count == excess_fauls)
            {
                iteration = iteration - excess_fauls;
                count = 0;
                alterGlobal();
                position = position - excess_fauls;
            }
        }
        break;
    }
}