# User Manual - ESINF (SPRINT 1 - Legacy)

## 0. Run the Application
```
To execute the application, you will just need to follow this quick tutorial.
- "Hello there, I see that you are interested in our application."
- "Well, you are in the right place."
- "Let me show you how to use it."
- "First, you need to open 'ESINF' folder in your workspace."
- "Then, you need to open 'src' folder inside the previous one."
- "Now, you'll move onto 'main' folder and run 'ConsoleMode.java'."
Disclaimer: The tests refering to user story [US306] are dependent of the real time of the computer and to be executed in full performance, you should run change the time in the file.
```
## 1. Load all the data - [US301]

```
When you first run the application, you will be prompted to 6 different options.
First, load all the data you want using [US301], there are 3 options:
[1] Load Distribution Network
[2] Load Producers and/or orders
[3] Load a Watering plan
Inside each option, you will be prompted to load the data from a file with .csv extension.
Each one of the options, also has the opurtunity to load the data from predetermined files.
Warning: If you choose to load the data from a file containing invalid data, such data won't be loaded.
```

## 2. Check if the Graph is Connected and it´s Diameter - [US302]

```
After loading the data, you can check wether the graph is connected and it´s diameter.
To do so, you will need to run [US302].
With a simple press of a button you are going to receive a message saying if the graph is connected or not and also the biggest number of edges between any pair of nodes.
Disclaimer: If the distribution network is empty you are going to be redirected to the main menu.
```

## 3. Define 'N' Hubs - [US303]

```
Each distribution network has a number of hubs determined by the user, the programm does so, by calculating the average distance between each company and all reachable clients.
To achieve that, you will need to run [US303], and follow the instructions bellow:
- Firstly you will be prompted to insert the number of hubs you want.
- Then, you will receive a confirmation message saying if the number of Hubs is valid or not.
- If the number of hubs is valid, you will receive a message saying that the hubs were defined and you are good to go!
Disclaimer: If the number of hubs is not valid, you will be directed to the main menu.
```

## 4. Find Neares Hub for each Client - [US304]

```
After defining the hubs (in [US303]), you can find the nearest hub for each client.
Having this in mind, you will need to run [US304], and simply wait for the message showing the nearest hub for each client.
Disclaimer: If you run this US before defining the hubs, you will receive a message saying that you need to define the hubs first.
```

## 5. Get the Network that connects all clients and producers - [US305]

```
In order to get the network that connects all clients and producers, you will need to run [US305] and make sure that you have loaded the participants and distances between them.
After that you will receive a message containing all the edges and total cost of the network, also known as the minimum spanning tree.
Disclaimer: Again if you run this US before loading the participants and distances, you will receive a message saying that you need to load both of them first.

```

## EXIT

```
If you want to exit the application, you can do so by pressing [0] in the main menu.
At that moment the application will close and we will wait to see you soon!
```