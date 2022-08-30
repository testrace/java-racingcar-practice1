package racinggame.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Winners {

    private final Map<String, Integer> carsPositions;

    public Winners(final Map<String, Integer> carsPositions) {
        this.carsPositions = carsPositions;
    }

    public List<String> names() {
        final int maxPosition = maxPosition();

        return carsPositions.entrySet().stream()
            .filter(entry -> entry.getValue() == maxPosition)
            .map(Map.Entry::getKey)
            .collect(Collectors.toUnmodifiableList());
    }

    private int maxPosition() {
        return carsPositions.values().stream()
            .max(Integer::compareTo)
            .orElseThrow(IllegalArgumentException::new);
    }

}
