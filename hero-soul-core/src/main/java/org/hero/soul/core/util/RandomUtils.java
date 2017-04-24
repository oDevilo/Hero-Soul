package org.hero.soul.core.util;

import java.util.Random;

public class RandomUtils {
    public static int nextInt(int bound) {
        int s = new Random(System.currentTimeMillis()).nextInt(bound);
        System.out.println(s);
        return s;
    }
}
