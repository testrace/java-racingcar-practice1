package racinggame.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dice {

    private static final Random RANDOM = new Random();
    private static final Map<Integer, Dice> CACHED_DICE = new HashMap<>();

    private final int diceBound;

    private Dice(final int diceBound) {
        this.diceBound = diceBound;
    }

    public static Dice bound(final int diceBound) {
        return CACHED_DICE.computeIfAbsent(diceBound, Dice::new);
    }

    public int roll() {
        return RANDOM.nextInt(diceBound);
    }
}
