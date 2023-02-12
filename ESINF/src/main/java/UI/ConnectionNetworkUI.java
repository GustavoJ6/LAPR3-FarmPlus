package UI;

import Controller.ConnectionNetworkController;

public class ConnectionNetworkUI implements Runnable {

    private final ConnectionNetworkController networkController = new ConnectionNetworkController();

    @Override
    public void run() {
        networkController.runKruskalAlgorithm();
    }
}