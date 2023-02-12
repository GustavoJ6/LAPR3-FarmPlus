package Domain.Graph;

import java.util.Objects;

/**
 * The type Kruskal object.
 * Kruskal object is used to store the information of the edges of the graph.
 * Kruskal object is also used because in order to use kruskal algorithm we need to have undirected and wheigthed graph.
 *
 * @param <V> the type parameter
 * @param <E> the type parameter
 */
public class KruskalObject <V, E extends Number> {

        private V vOrig;
        private E weight;
        private V vDest;

    /**
     * Instantiates a new Kruskal object.
     *
     * @param vOrig  the v orig
     * @param weight the weight
     * @param vDest  the v dest
     */
    public KruskalObject(V vOrig, E weight, V vDest) {
            this.vOrig = vOrig;
            this.weight = weight;
            this.vDest = vDest;
        }

    /**
     * Gets orig.
     *
     * @return the orig
     */
    public V getvOrig() {
        return vOrig;
    }

    /**
     * Sets orig.
     *
     * @param vOrig the v orig
     */
    public void setvOrig(V vOrig) {
        this.vOrig = vOrig;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public E getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(E weight) {
        this.weight = weight;
    }

    /**
     * Gets dest.
     *
     * @return the dest
     */
    public V getvDest() {
        return vDest;
    }

    /**
     * Sets dest.
     *
     * @param vDest the v dest
     */
    public void setvDest(V vDest) {
        this.vDest = vDest;
    }

        @Override
        public String toString() {
            return String.format("%s -> %s\nDistance: %s%n", vOrig, vDest, weight);
        }


        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;

            if (getClass() != obj.getClass())
                return false;

            final KruskalObject<?, ?> other = (KruskalObject<?, ?>) obj;
            if (!Objects.equals(this.vOrig, other.vOrig))
                return false;

            if (!Objects.equals(this.weight, other.weight))
                return false;

            return Objects.equals(this.vDest, other.vDest);
        }
    }