package Utils;

import Controller.AuthSystem;
import Functionalities.ParticipantsFileReader;
import Functionalities.ProductsFileReader;
import Functionalities.RoutesFileReader;
import Functionalities.WateringPlanReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Utils {

    /**
     * Reads user's input from the console
     *
     * @param prompt - Sentence to present
     * @return String - user's input
     */
    public static String readLineFromConsole(String prompt) {
        try {
            System.out.print("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public int selectsIndex(List list) {
        String input;
        int value = -1;

        do {
            try {
                input = Utils.readLineFromConsole("Type your option: ");
                value = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option");
            }
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    /**
     * Shows the chosen list (showList) and let the user choose an option
     *
     * @param list   A chosen list
     * @param header A chosen header
     * @return Integer - the option chosen by the user
     */
    static public int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    /**
     * Prints the chosen list with a header and options
     *
     * @param list   - A chosen list
     * @param header - A chosen header
     */
    static public void showList(List list, String header) {
        System.out.println(header);
        System.out.println();
        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }

    /**
     * Reads an integer from console and validates it
     *
     * @param prompt - Sentence to present
     * @return int - user's input
     */
    public static int readIntegerFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println(Constants.RED + "Invalid option." + Constants.RESET + " Must be number");
            }
        } while (true);
    }

    public static void filesBootstrapBig() {

        System.out.println(Constants.RED + "BOOTSTRAP BIG IS ON!!!\n" + Constants.RESET);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        if(!participantsFileReader.readFromFile("ESINF/DataToLoad/Big/clientes-produtores_big.csv")) {
            System.out.println(Constants.RED + "Error reading participants file." + Constants.RESET);
        }
        RoutesFileReader routesFileReader = new RoutesFileReader();
        if(!routesFileReader.readFromFile("ESINF/DataToLoad/Big/distancias_big.csv")) {
            System.out.println(Constants.RED + "Error reading routes file." + Constants.RESET);
        }
        ProductsFileReader productsFileReader = new ProductsFileReader();
        if(!productsFileReader.readFromFile("ESINF/DataToLoad/Big/cabazes_big.csv")) {
            System.out.println(Constants.RED + "Error reading products file." + Constants.RESET);
        }
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        if(!wateringPlanReader.readFromFile("ESINF/DataToLoad/WateringPlans/WateringPlan.txt")) {
            System.out.println(Constants.RED + "Error reading watering plan file." + Constants.RESET);
        }
    }

    public static void filesBootstrapSmall() {

        System.out.println(Constants.RED + "BOOTSTRAP SMALL IS ON!!!\n" + Constants.RESET);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ParticipantsFileReader participantsFileReader = new ParticipantsFileReader();
        if (!participantsFileReader.readFromFile("ESINF/DataToLoad/Small/clientes-produtores_small.csv")) {
            System.out.println("Error reading participants file");
        }
        RoutesFileReader routesFileReader = new RoutesFileReader();
        if (!routesFileReader.readFromFile("ESINF/DataToLoad/Small/distancias_small.csv")) {
            System.out.println("Error reading routes file");
        }
        ProductsFileReader productsFileReader = new ProductsFileReader();
        if (!productsFileReader.readFromFile("ESINF/DataToLoad/Small/cabazes_small.csv")) {
            System.out.println("Error reading products file");
        }
        WateringPlanReader wateringPlanReader = new WateringPlanReader();
        if (!wateringPlanReader.readFromFile("ESINF/DataToLoad/WateringPlans/WateringPlan.txt")) {
            System.out.println("Error reading watering plan file");
        }
    }

    public static void usersBootstrap() {
        AuthSystem authSystem = AuthSystem.getInstance();

        // Register users
        authSystem.registerUser("EsinfUser", "esinfPwd", AuthSystem.Role.ESINF_USER);
        authSystem.registerUser("BddadUser", "bddadPwd", AuthSystem.Role.BDDAD_USER);
    }
}
