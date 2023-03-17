package commons;

import java.util.concurrent.ThreadLocalRandom;

public class Utilities {

    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
