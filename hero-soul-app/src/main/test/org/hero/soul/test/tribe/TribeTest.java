package org.hero.soul.test.tribe;

import org.hero.soul.core.util.RandomUtils;
import org.hero.soul.model.enemy.Goblin;
import org.hero.soul.model.map.Tribe;
import org.junit.Test;

import java.util.Random;

public class TribeTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        // 哥布林部落
        Tribe<Goblin> tribe = new Tribe<Goblin>(Goblin.class);
        Goblin g1 = new Goblin();
        Goblin g2 = new Goblin();
        Goblin g3 = new Goblin();
        Goblin g4 = new Goblin();
        Goblin g5 = new Goblin();
        g1.setId("g1");
        g2.setId("g2");
        g3.setId("g3");
        g4.setId("g4");
        g5.setId("g5");
        g1.setSex(1);
        g2.setSex(2);
        g3.setSex(1);
        g4.setSex(2);
        g5.setSex(1);
        g1.setAge(12);
        g2.setAge(12);
        g3.setAge(12);
        g4.setAge(12);
        g5.setAge(12);
        g2.setPossible(8000);
        g3.setPossible(8000);
        g4.setPossible(8000);
        g5.setPossible(8000);
        tribe.putMale(g1.getId(), g1);
        tribe.putFemale(g2.getId(), g2);
        tribe.putMale(g3.getId(), g3);
        tribe.putFemale(g4.getId(), g4);
        tribe.putMale(g5.getId(), g5);

        for (int i = 0; i < 36500; i++) {
            if (i % Goblin.breedCycle == 0) {
                tribe.breed();
            }
            tribe.liveUp();
        }
        tribe.print();

    }

    @Test
    public void randDouble() {
        for (int i = 0; i < 36500; i++) {
            Random random = new Random();
            double fe = random.nextDouble();
            System.out.println(fe);
        }
    }

    @Test
    public void randInt() {
        for (int i = 0; i < 36500; i++) {
            int v = RandomUtils.nextInt(1000);
            System.out.println(v);
        }
    }

}
