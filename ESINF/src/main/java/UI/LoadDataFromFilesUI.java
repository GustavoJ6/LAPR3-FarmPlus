package UI;

import Controller.App;
import Controller.LoadDataFromFilesController;
import Utils.Utils;
import Utils.Constants;

public class LoadDataFromFilesUI implements Runnable {

    private final LoadDataFromFilesController controller = new LoadDataFromFilesController();

    @Override
    public void run() {
        System.out.printf("%n%n");

        int option;
        do {
            System.out.print(Constants.PURPLE + "|---------------------------------------------|\n        Load network participants Menu\n|---------------------------------------------|\n");

            System.out.println(Constants.GREEN + "Choose what you want to do:");

            System.out.printf(Constants.BLUE + "1 - Load Distribution Network - (Carregar Grafo).%n" +
                    "2 - Load Products and/or orders. - File with the baskets/orders (Cabazes)%n" +
                    "3 - Load a watering plan. - File with a Watering java.Controller (Plano de Rega)%n%n" +
                    Constants.RED + "0 - Back%n " + Constants.RESET);

            option = Utils.readIntegerFromConsole("Option: ");
            System.out.println();
            String path;
            int optionManual;
            switch (option) {
                case 0 -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return;
                }
                case 1 -> {

                    String pathDistances;
                    System.out.println("Choose how you want to load the distribution network:");
                    System.out.printf("1 - Automatic Big Files%n" +
                            "2 - Automatic Small Files%n" +
                            "3 - Manually%n" +
                            "0 - Back%n");
                    optionManual = Utils.readIntegerFromConsole("Option: ");
                    switch (optionManual) {
                        case 0 -> {
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return;
                        }
                        case 1 -> {
                            path = Constants.PATH_TO_BIG_FILE_VERTICES;
                            pathDistances = Constants.PATH_TO_BIG_FILE_DISTANCES;
                        }
                        case 2 -> {
                            path = Constants.PATH_TO_SMALL_FILE_VERTICES;
                            pathDistances = Constants.PATH_TO_SMALL_FILE_DISTANCES;
                        }
                        case 3 -> {
                            path = Utils.readLineFromConsole("Path to the file with the vertices: ");
                            pathDistances = Utils.readLineFromConsole("Path to the file with the distances: ");
                        }
                        default -> {
                            System.out.println("Invalid option!");
                            continue;
                        }
                    }

                    if (controller.loadParticipants(path)) {
                        System.out.printf("%n" + Constants.GREEN + "Participants loaded successfully" + Constants.RESET + "%n%n");
                    } else {
                        System.out.printf(Constants.RED + "Error loading participants" + Constants.RESET + "%n%n");
                    }

                    if (controller.loadRoutes(pathDistances)) {
                        System.out.printf(Constants.GREEN + "Distances loaded successfully" + Constants.RESET + "%n%n");
                    } else {
                        System.out.printf(Constants.RED + "Error loading distances" + Constants.RESET + "%n%n");
                    }
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 2 -> {
                    if (App.getInstance().isSystemDataEmpty()) {
                        System.out.printf(Constants.RED + "You need to load information about the distribution network first!" + Constants.RESET + "%n%n");
                        try {
                            Thread.sleep(1550);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("Choose how you want to load the products/orders:");
                        System.out.printf("1 - Automatic Big Files%n" +
                                "2 - Automatic Small Files%n" +
                                "3 - Manually%n" +
                                "0 - Back%n");
                        optionManual = Utils.readIntegerFromConsole("Option: ");
                        switch (optionManual) {
                            case 0 -> {
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                return;
                            }
                            case 1 -> {
                                path = Constants.PATH_TO_BIG_FILE_PRODUCTS;
                            }
                            case 2 -> {
                                path = Constants.PATH_TO_SMALL_FILE_PRODUCTS;
                            }
                            case 3 -> {
                                path = Utils.readLineFromConsole("Path to the file with the products/orders: ");
                            }
                            default -> {
                                System.out.println("Invalid option!");
                                continue;
                            }
                        }

                        if (controller.loadProducts(path)) {
                            System.out.printf(Constants.GREEN + "Products loaded successfully" + Constants.RESET + "%n%n");
                        } else {
                            System.out.printf(Constants.RED + "Error loading products" + Constants.RESET + "%n%n");
                        }
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case 3 -> {

                    System.out.println("Choose how you want to load the watering plan:");
                    System.out.printf("1 - Automatically%n" +
                            "2 - Manually%n" +
                            "0 - Back%n");
                    optionManual = Utils.readIntegerFromConsole("Option: ");
                    switch (optionManual) {
                        case 0 -> {
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return;
                        }
                        case 1 -> {
                            path = Constants.PATH_TO_FILE_WATERING_PLANS;
                        }
                        case 3 -> {
                            path = Utils.readLineFromConsole("Path to the file with the Watering plan: ");
                        }
                        default -> {
                            System.out.println("Invalid option!");
                            continue;
                        }
                    }

                    if (controller.loadWateringPlan(path)) {
                        System.out.printf(Constants.GREEN + "%nWatering Plan loaded successfully" + Constants.RESET + "%n%n");
                    } else {
                        System.out.printf(Constants.RED + "Error loading the watering plan" + Constants.RESET + "%n%n");
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> {
                    System.out.printf(Constants.RED + "Invalid option" + Constants.RESET + "%n%n");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } while (true);

    }

}

