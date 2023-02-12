package Functionalities;

import Controller.App;
import Miscellaneous.WateringParcel;
import Stores.WateringPlanStore;
import Domain.Parcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WateringPlanReader implements IReaderFromFile {

    private final WateringPlanStore store = App.getInstance().getWateringStore();

    @Override
    public boolean readFromFile(String path) {

        // Instantiate the reader
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));

            String line = reader.readLine();
            if (line == null)
                return false;

            // Split the line by the delimiter
            String[] lineTime = line.split(",");;
            String[] lineData;

            while (line != null) {

                // Read the file line by line
                while ((line = reader.readLine()) != null) {

                    // Split the line by the delimiter
                    lineData = line.split(",");

                    // Check if the line is valid
                    if (Character.isDigit(line.charAt(0))) {
                       break;
                    }
                    if (lineData.length != 3) {
                        return false;
                    }

                    // Instantiate the parcel to be watered
                    WateringParcel wateringParcel = new WateringParcel(
                            new Parcel(lineData[0]),
                            Integer.parseInt(lineData[1]),
                            lineData[2]
                    );

                    for (String timeStr : lineTime) {
                        // check if time contains things other than numbers or ':'
                        if (!timeStr.matches("[\\d:]+")) {
                            return false;
                        }
                        timeStr = validateTime(timeStr);
                        LocalTime time = LocalTime.parse(timeStr);

                        List<WateringParcel> parcels = store.getWateringPlan().get(time);

                        // Checks whether the time is already in the store
                        if (parcels == null)
                            parcels = new ArrayList<>();

                        parcels.add(wateringParcel);
                        store.getWateringPlan().put(time, parcels);
                    }

                }

                if (line != null)
                    lineTime = line.split(",");
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private String validateTime(String timeStr) {
        // If the length is already 5, for example 10:10, then it's valid
        if (timeStr.length() == 5)
            return timeStr;

        String[] info = timeStr.split(":");

        if (info[0].length() == 1)
            info[0] = "0" + info[0];
        if (info[1].length() == 1)
            info[1] = "0" + info[1];

        return info[0] + ":" + info[1];
    }
}
