package Domain.Participants;

/**
 * A record that represents a Hub.
 */
public record Hub(String participantID, double averageDistance) implements Comparable<Hub> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hub hub = (Hub) o;
        return Double.compare(hub.averageDistance, averageDistance) == 0;
    }

    @Override
    public int compareTo(Hub o) {
        return Double.compare(averageDistance, o.averageDistance);
    }
}
