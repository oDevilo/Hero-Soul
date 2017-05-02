package org.hero.soul.core.util;

import java.util.Random;

public class RandomUtils {

    private static Random randomNumberGenerator;

    private static synchronized Random initRNG() {
        Random rnd = randomNumberGenerator;
        return (rnd == null) ? (randomNumberGenerator = new Random()) : rnd;
    }

    /**
     * 根据范围生成int
     *
     * @param bound 数据范围
     * @return
     */
    public static int nextInt(int bound) {
        Random rnd = randomNumberGenerator;
        if (rnd == null) rnd = initRNG();
        return rnd.nextInt(bound);
    }

}
