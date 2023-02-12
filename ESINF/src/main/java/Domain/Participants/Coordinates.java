package Domain.Participants;

import java.util.Objects;

/**
 *  Coordinates object.
 */
public class Coordinates {

    private final double latitude;

    private final double longitude;

    /**
     * Instantiates a new Coordinates object.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}