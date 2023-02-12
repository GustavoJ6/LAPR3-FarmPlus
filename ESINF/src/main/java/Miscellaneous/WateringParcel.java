package Miscellaneous;

import Domain.Parcel;

import java.util.Objects;

public class WateringParcel {

    public static final String EVERYDAY = "t" ;
    public static final String ODD = "i" ;
    public static final String EVEN = "p" ;

    private final Parcel parcel;
    private final int duration;
    private final String regularity;

    /**
     * Instantiates a new Watering parcel.
     *
     * @param parcel     the parcel
     * @param duration   the duration
     * @param regularity the regularity
     */
    public WateringParcel(Parcel parcel, int duration, String regularity) {
        this.parcel = parcel;
        this.duration = duration;
        this.regularity = regularity;
    }

    /**
     * Gets parcel.
     *
     * @return the parcel
     */
    public Parcel getParcel() {
        return parcel;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets regularity.
     *
     * @return the regularity
     */
    public String getRegularity() {
        return regularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WateringParcel that = (WateringParcel) o;

        if (duration != that.duration) return false;
        if (regularity != that.regularity) return false;
        return Objects.equals(parcel, that.parcel);
    }
}
