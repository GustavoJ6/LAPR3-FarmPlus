package Mapper;

import DTO.DijkstraObjectDTO;
import Domain.Graph.DijkstraObject;

public class DijkstraObjectMapper {

    public static <V, E extends Number> DijkstraObjectDTO<V, E> toDTO(DijkstraObject<V, E> dijkstraObject) {
        if (dijkstraObject == null) {
            return null;
        }

        return new DijkstraObjectDTO<>(dijkstraObject.getKey(), dijkstraObject.getDistance(), dijkstraObject.getPredecessor());
    }

    public static <V, E extends Number> DijkstraObject<V, E> toDomain(DijkstraObjectDTO<V, E> dijkstraObjectDTO) {
        if (dijkstraObjectDTO == null) {
            return null;
        }

        return new DijkstraObject<>(dijkstraObjectDTO.getKey(), dijkstraObjectDTO.getDistance(), dijkstraObjectDTO.getPredecessor());
    }

}

