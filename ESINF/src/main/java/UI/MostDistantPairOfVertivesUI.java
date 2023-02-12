package UI;

import Controller.MostDistantPairOfVerticesController;
import DTO.DijkstraObjectDTO;
import Domain.Participants.Participant;
import Utils.Constants;

public class MostDistantPairOfVertivesUI implements Runnable {

    private final MostDistantPairOfVerticesController controller = new MostDistantPairOfVerticesController();


    @Override
    public void run() {
        System.out.printf(Constants.PURPLE + "|---------------------------------------------|%n        Most Distant Pair of Vertices%n|---------------------------------------------|%n" + Constants.RESET);

        boolean isConnected = controller.isConnected();


        if (isConnected) {
            System.out.printf("%nThe Distribution Network is%s connected! %s%n%n", Constants.GREEN, Constants.RESET);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            DijkstraObjectDTO<Participant, Double> longest = controller.getLongestPath();

            System.out.printf("The minimum number of connections between any to vertices is %s%d%s%n%n", Constants.GREEN, longest.getDistance().intValue(), Constants.RESET);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
