package racinggame.domain;

public class DefaultForwardMovable implements ForwardMovable {

    private static final int FORWARD_CONDITION = 4;

    private final int value;

    public DefaultForwardMovable(final int value) {
        this.value = value;
    }

    @Override
    public boolean isMovable() {
        return value >= FORWARD_CONDITION;
    }

}
