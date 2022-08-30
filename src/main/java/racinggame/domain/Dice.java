package racinggame.domain;

import java.util.Random;

public class Dice {

    private static final Random RANDOM = new Random();
    private final int diceBound;

    public Dice(final int diceBound) {
        this.diceBound = diceBound;
    }

    public int roll() {
        return RANDOM.nextInt(diceBound);
    }
}
