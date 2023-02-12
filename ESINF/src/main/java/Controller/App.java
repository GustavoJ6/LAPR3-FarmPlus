package Controller;

import Domain.DistributionNetworkData;
import GUI.Screens.MainPageGUI;
import Stores.WateringPlanStore;

import java.util.HashMap;
import java.util.Map;

public class App {

    private final DistributionNetworkData systemData;
    private final WateringPlanStore wateringStore;
    /**
     * The Desktop mode.
     */
    public boolean desktopMode;
    /**
     * The Loaded data in the system.
     */
    public Map<Integer, Boolean> loadedData = new HashMap<>();
    private MainPageGUI mainPageGUI;

    private App() {
        this.systemData = new DistributionNetworkData();
        this.wateringStore = new WateringPlanStore();
        initializeLoadedData();
    }

    /**
     * Checks if the distribution network of the program is empty.
     *
     * @return true if the distribution network is empty, false otherwise
     */
    public boolean isSystemDataEmpty() {
        return systemData.getDistributionNetwork().isEmpty();
    }

    /**
     * Checks is the routes of the distribution network are empty.
     *
     * @return true if the routes are empty, false otherwise
     */
    public boolean isRouteEmpty() { return systemData.getDistributionNetwork().getDistributionNetwork().isEmpty(); }

    /**
     * Checks if the watering plan store is empty.
     *
     * @return true if the watering plan store is empty, false otherwise
     */
    public boolean isWateringStoreEmpty() { return wateringStore.getWateringPlan().isEmpty(); }

    /**
     * Checks if there are Hubs defined.
     *
     * @return the boolean
     */
    public boolean isThereAnyHubDefined() {
        return systemData.getDistributionNetwork().getHubs().size() > 0;
    }

    /**
     * Checks if there are Hubs defined.
     *
     * @return the boolean
     */
    public boolean isThereAnyNearestHubDefined() {
        return systemData.getDistributionNetwork().getListOfClients().get(0).getNearestHubId() != null;
    }

    /**
     * Gets the system data.
     *
     * @return the system data
     */
    public DistributionNetworkData getSystemData() {
        return this.systemData;
    }

    /**
     * Gets the watering store.
     *
     * @return the watering store
     */
    public WateringPlanStore getWateringStore() { return this.wateringStore; }

    /**
     * Initialize loaded data.
     * This method serves the purpose of initializing the loaded data map.
     */
    public void initializeLoadedData() {
        desktopMode = false;
        loadedData.put(1, false);  // Products
        loadedData.put(2, false);  // Distribution network
        loadedData.put(3, false);  // Watering plan
    }

    private static App singleton = null;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }

    public void setMainPageGUI(MainPageGUI mainPageGUI) {
        this.mainPageGUI = mainPageGUI;
    }

    public MainPageGUI getMainPageGUI() {
        return mainPageGUI;
    }
}