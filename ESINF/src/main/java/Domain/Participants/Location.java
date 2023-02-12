package Domain.Participants;

import java.util.Objects;

public class Location {

    private final String locationId;

    private final Coordinates coordinates;

    /**
     * Instantiates a new Location object.
     *
     * @param locationId the location id
     * @param coordinates the coordinates
     */
    public Location(String locationId, Coordinates coordinates) {
        this.locationId = locationId;
        this.coordinates = coordinates;
    }

    /**
     * Gets location id.
     *
     * @return the location id
     */
    public String getLocationId() {
        return locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(locationId, location.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, coordinates);
    }
}