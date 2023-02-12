package DTO;

public class DijkstraObjectDTO<V, E extends Number> {

    private final V key;
    private final E distance;
    private final V predecessor;

    public DijkstraObjectDTO(V key, E distance, V predecessor) {
        this.key = key;
        this.distance = distance;
        this.predecessor = predecessor;
    }

    public V getKey() {
        return key;
    }

    public E getDistance() {
        return distance;
    }

    public V getPredecessor() {
        return predecessor;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s%n", predecessor, key);
    }
}
