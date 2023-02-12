ARQCP: alter_frequency.o remove_sensor.o add_sensor.o pcg.o dev_random.o gen_sens_temp.o sens_temp.o gen_sens_humd_atm.o sens_humd_atm.o gen_sens_dir_vento.o sens_dir_vento.o gen_sens_velc_vento.o sens_velc_vento.o gen_sens_humd_solo.o sens_humd_solo.o gen_sens_pluvio.o sens_pluvio.o matrix_analysis.o read_frequencies.o remove_spaces.o configuration_file.o manual_input.o set_restrictions.o allocate_memory_sensors.o set_sensor.o alter_global.o  print_matrix.o export_daily_matrix.o max_min_avg_reset.o export_sensors.o treat_choices.o main.o
	gcc alter_frequency.o remove_sensor.o add_sensor.o pcg.o dev_random.o gen_sens_temp.o sens_temp.o gen_sens_humd_atm.o sens_humd_atm.o gen_sens_dir_vento.o sens_dir_vento.o gen_sens_velc_vento.o sens_velc_vento.o gen_sens_humd_solo.o sens_humd_solo.o gen_sens_pluvio.o sens_pluvio.o matrix_analysis.o read_frequencies.o remove_spaces.o configuration_file.o manual_input.o main.o set_restrictions.o allocate_memory_sensors.o set_sensor.o alter_global.o print_matrix.o export_daily_matrix.o max_min_avg_reset.o export_sensors.o treat_choices.o -o ARQCP

alter_frequency.o: alter_frequency.c
	gcc -Wall -g -c alter_frequency.c -o alter_frequency.o

remove_sensor.o: remove_sensor.c
	gcc -Wall -g -c remove_sensor.c -o remove_sensor.o

add_sensor.o: add_sensor.c
	gcc -Wall -g -c add_sensor.c -o add_sensor.o

alter_global.o: alter_global.c
	gcc -Wall -g -c alter_global.c -o alter_global.o

set_sensor.o: set_sensor.c
	gcc -Wall -g -c set_sensor.c -o set_sensor.o

allocate_memory_sensors.o: allocate_memory_sensors.c
	gcc -Wall -g -c allocate_memory_sensors.c -o allocate_memory_sensors.o

set_restrictions.o: set_restrictions.c
	gcc -Wall -g -c set_restrictions.c -o set_restrictions.o

manual_input.o: manual_input.c
	gcc -Wall -g -c manual_input.c -o manual_input.o

configuration_file.o: configuration_file.c
	gcc -Wall -g -c configuration_file.c -o configuration_file.o

read_frequencies.o: read_frequencies.c
	gcc -Wall -g -c read_frequencies.c -o read_frequencies.o

remove_spaces.o: remove_spaces.c
	gcc -Wall -g -c remove_spaces.c -o remove_spaces.o

matrix_analysis.o: matrix_analysis.c
	gcc -Wall -g -c matrix_analysis.c -o matrix_analysis.o

gen_sens_pluvio.o: gen_sens_pluvio.c
	gcc -Wall -g -c gen_sens_pluvio.c -o gen_sens_pluvio.o

sens_pluvio.o: sens_pluvio.s
	gcc -Wall -g -c sens_pluvio.s -o sens_pluvio.o

gen_sens_humd_solo.o: gen_sens_humd_solo.c
	gcc -Wall -g -c gen_sens_humd_solo.c -o gen_sens_humd_solo.o

sens_humd_solo.o: sens_humd_solo.s
	gcc -Wall -g -c sens_humd_solo.s -o sens_humd_solo.o

gen_sens_velc_vento.o: gen_sens_velc_vento.c
	gcc -Wall -g -c gen_sens_velc_vento.c -o gen_sens_velc_vento.o

sens_velc_vento.o: sens_velc_vento.s
	gcc -Wall -g -c sens_velc_vento.s -o sens_velc_vento.o

gen_sens_dir_vento.o: gen_sens_dir_vento.c
	gcc -Wall -g -c gen_sens_dir_vento.c -o gen_sens_dir_vento.o

sens_dir_vento.o: sens_dir_vento.s
	gcc -Wall -g -c sens_dir_vento.s -o sens_dir_vento.o

gen_sens_humd_atm.o: gen_sens_humd_atm.c
	gcc -Wall -g -c gen_sens_humd_atm.c -o gen_sens_humd_atm.o

sens_humd_atm.o: sens_humd_atm.s
	gcc -Wall -g -c sens_humd_atm.s -o sens_humd_atm.o

gen_sens_temp.o: gen_sens_temp.c
	gcc -Wall -g -c gen_sens_temp.c -o gen_sens_temp.o

sens_temp.o: sens_temp.s
	gcc -Wall -g -c sens_temp.s -o sens_temp.o

pcg.o: pcg.s
	gcc -Wall -g -c pcg.s -o pcg.o

dev_random.o: dev_random.c
	gcc -Wall -g -c dev_random.c -o dev_random.o

print_matrix.o: print_matrix.c
	gcc -Wall -g -c print_matrix.c -o print_matrix.o

export_daily_matrix.o: export_daily_matrix.c
	gcc -Wall -g -c export_daily_matrix.c -o export_daily_matrix.o

max_min_avg_reset.o: max_min_avg_reset.c
	gcc -Wall -g -c max_min_avg_reset.c -o max_min_avg_reset.o

export_sensors.o: export_sensors.c
	gcc -Wall -g -c export_sensors.c -o export_sensors.o

treat_choices.o: treat_choices.c
	gcc -Wall -g -c treat_choices.c -o treat_choices.o	

main.o: main.c
	gcc -Wall -g -c main.c -o main.o

r: ARQCP
	./ARQCP

c:
	rm *.o ARQCP

vg: ARQCP
	valgrind ./ARQCP
