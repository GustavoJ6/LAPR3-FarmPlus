package UI;

import Controller.WateringController;
import Utils.Constants;

import java.util.Map;

public class WateringUI implements Runnable {

    private final WateringController controller = new WateringController();

    @Override
    public void run() {
        System.out.print(Constants.PURPLE + "|---------------------------------------------|\n                   Watering Menu\n|---------------------------------------------|\n" + Constants.RESET);

        Map<String, Integer> parcelsTime = controller.watering();

        if (parcelsTime.isEmpty())
            System.out.printf("%n%sThere are no parcels being watered at the moment.%s", Constants.RED, Constants.RESET);
        else {
            System.out.printf("%nParcels being watered:%n");
            for (Map.Entry<String, Integer> entry : parcelsTime.entrySet())
                System.out.printf("Parcel: %s%s%s ---| finishing in |--- %s%d%s minutes.%n",
                        Constants.BLUE, entry.getKey().toUpperCase(), Constants.RESET, Constants.GREEN, entry.getValue(), Constants.RESET);

        }

        System.out.printf("%n%n");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
