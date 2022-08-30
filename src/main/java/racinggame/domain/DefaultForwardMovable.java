package racinggame.domain;

import java.util.HashMap;
import java.util.Map;

public class DefaultForwardMovable implements ForwardMovable {

    private static final int FORWARD_CONDITION = 4;
    private static final Map<Integer, ForwardMovable> CACHED_MOVABLE = new HashMap<>();

    private final int value;

    public DefaultForwardMovable(final int value) {
        this.value = value;
    }

    public static ForwardMovable of(final int value) {
        return CACHED_MOVABLE.computeIfAbsent(value, DefaultForwardMovable::new);
    }

    @Override
    public boolean isMovable() {
        return value >= FORWARD_CONDITION;
    }

}
