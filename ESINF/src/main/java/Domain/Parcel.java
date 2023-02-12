package Domain;

import java.util.Objects;

public class Parcel {

    private final String identifier;

    /**
     * Instantiates a new Parcel.
     *
     * @param identifier the identifier
     */
    public Parcel(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets identifier.
     *
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parcel other = (Parcel) obj;

        return Objects.equals(this.identifier, other.identifier);
    }
}
