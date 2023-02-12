package Domain.Graph;

import java.util.*;

public class DijkstraObject <V, E extends Number> {
    private V key;
    private E distance;
    private V predecessor;

    public DijkstraObject(V key, E distance, V predecessor) {
        this.key = key;
        this.distance = distance;
        this.predecessor = predecessor;
    }

    public V getKey() {
        return key;
    }

    public void setKey(V key) {
        this.key = key;
    }

    public E getDistance() {
        return distance;
    }

    public void setDistance(E distance) {
        this.distance = distance;
    }

    public V getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(V predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s\nDistance: %s%n", key, predecessor, distance);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final DijkstraObject<?, ?> other = (DijkstraObject<?, ?>) obj;
        if (!Objects.equals(this.key, other.key))
            return false;

        if (!Objects.equals(this.distance, other.distance))
            return false;

        return Objects.equals(this.predecessor, other.predecessor);
    }
}