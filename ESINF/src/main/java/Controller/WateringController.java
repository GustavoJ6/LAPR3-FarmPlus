package Controller;

import Stores.WateringPlanStore;

import java.util.Map;

public class WateringController {

    private final WateringPlanStore wateringStore = App.getInstance().getWateringStore();

    public Map<String, Integer> watering() {
        return wateringStore.beingWatered();
     }
}
