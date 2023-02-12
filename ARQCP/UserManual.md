

###Hello!

If this is your first time around here, be welcome.
Using this can be overwhelming at first, but it's not that hard. I'll try to explain it as good as I can.
This is a simulation of how real life sensors work, so in order to work, our software uses a pseudo-random number generator to simulate the real world. 
This means that the results you get are not 100% accurate, but they are close enough to be useful.

The first thing you must do is insert the relevant data to the sensors, through a configuration file (1) or manually (2).
(1)
The configuration file is a .txt file that you can find in the same folder as the executable file.
The file is called "config.cfg" and it's a simple configuration file, so you can open it with any text editor.
In order to read it correctly, you must follow a set of instructions:
    1. The file must use comments to name the sensors. The comments must be in the following format: //sensor_name
        - The sensor name must be unique.
        - There are 6 possible sensors: 'Temperatura', 'Velocidade Vento', 'Direção Vento', 'Ar Umidade', 'Solo Umidade' and 'Pluviosidade'.
    2. The line after a comment cannot be empty. It must contain the data for the sensor.
    3. The data must be in the following format: 'Frequência : value'
    4. And that's all.

After you've inserted the data, you can run the program.

(2)
If you don't want to use the configuration file, you can insert the data manually.
To do so, you must select the second option on the first pop-up menu.
There you will be asked to insert the amount and frequency for each sensor type.
Be aware that the frequency is worked on, in seconds and it must be between 1 and 86400s.

After you've inserted the data, you can run the program.

What you will notice first is a simple, yet functional, interface.
The interface is divided in 5 parts:
    1. Adding Sensors.
    2. Removing Sensors.
    3. Altering Frequencies.
    4. Displaying Sensors Data.
    5. Obtaining Daily Report.

(1) Adding Sensors
    This is the first option you will see on the interface.
    It's pretty simple, you just have to select the sensor type and a new sensor will be added.
    There is no limit for each sensor type, so you can add as many as you want.

(2) Removing Sensors
    This is the second option you will see on the interface.
    Just like, the previous option, you just have to select the sensor type and a sensor will be removed.
    The case is not the same tho, as you must keep at least one sensor of each type.

(3) Altering Frequencies
    This is the third option you will see on the interface.
    This option allows you to change the frequency of each sensor type.
    You can change the frequency of each sensor type, but they must be between 1 and 86400.

(4) Displaying Sensors Data
    This is the fourth/fifth/sixth option you will see on the interface.
    This option allows you to display the data of each sensor type.
    You can display the data of each sensor type, respectively, amount, frequency and limits.

(5) Obtaining Daily Report
    This is the last option you will see on the interface.
    This option allows you to obtain a daily report of the data of each sensor type.
    You will obtain the daily report of each sensor type through two .csv files, created in the files section.

If you follow these instructions, you should be able to use the program without any problems.
If you have any questions, feel free to ask.
Enjoy our software and have a nice day!