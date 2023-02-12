package Stores;

import Controller.App;
import Miscellaneous.WateringParcel;

import java.time.*;
import java.time.temporal.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WateringPlanStore {

    // Map containing the hour of the day and the corresponding parcels to be watered
    Map<LocalTime, List<WateringParcel>> wateringPlan;

    /**
     * Instantiates a new Watering plan store.
     */
    public WateringPlanStore() {
        wateringPlan = new HashMap<>();
    }

    /**
     * Gets watering plan.
     *
     * @return the watering plan
     */
    public Map<LocalTime, List<WateringParcel>> getWateringPlan() {
        return wateringPlan;
    }

    /**
     * Method that returns a map with the parcels being watered and the time left to finish it
     *
     * @return Map with the parcels being watered and the time left to finish watering
     */
    public Map<String, Integer> beingWatered() {
        Map<String, Integer> resultMap = new HashMap<>();

        LocalTime currentTime = LocalTime.now();

        // iterate over the map using entry
        for (Map.Entry<LocalTime, List<WateringParcel>> entry : wateringPlan.entrySet()) {
            List<WateringParcel> parcels = entry.getValue();

            // If the current time is after the time of the map entry, then it can't be being watered
            if (entry.getKey().isBefore(currentTime)) {
                for (WateringParcel parcel : parcels) {
                    // If the hour of the watering plus its duration is after the current time, then it is being watered at the current moment
                    LocalDateTime finishDateTime = LocalDateTime.of(LocalDate.now(), entry.getKey());
                    finishDateTime = finishDateTime.plusMinutes(parcel.getDuration());
                    LocalDateTime currentDateTime = LocalDateTime.of(LocalDate.now(), currentTime);
                    // Check if the day is even or odd
                    boolean rightDay = currentDay(parcel.getRegularity());
                    if (finishDateTime.isAfter(currentDateTime) && rightDay) {
                        resultMap.put(parcel.getParcel().getIdentifier(), (int) getRemainingTime(finishDateTime, currentDateTime));
                    }
                }
            }
        }

        return resultMap;
    }

    private boolean currentDay(String regularity) {
        int day = LocalDate.now().getDayOfMonth();

        if (regularity.equals(WateringParcel.EVERYDAY))
            return true;
        else if (regularity.equals(WateringParcel.ODD) && day % 2 != 0)
            return true;
        else return regularity.equals(WateringParcel.EVEN) && day % 2 == 0;
    }


    // Gets how much time is left for a parcel to be watered
    private long getRemainingTime(LocalDateTime startDateTime, LocalDateTime currentDateTime) {
        long result =  ChronoUnit.MINUTES.between(startDateTime, currentDateTime);

        if (result < 0)
            return - result;
        else
            return result;
    }

    public void clearWateringPlan() {
        wateringPlan.clear();
        App.getInstance().loadedData.put(3, false);
    }
}
