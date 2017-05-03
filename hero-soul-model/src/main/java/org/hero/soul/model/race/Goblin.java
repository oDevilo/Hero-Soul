package org.hero.soul.model.race;

/**
 * 哥布林
 * 
 * @author Devil
 *
 */
public class Goblin extends Entity<Goblin> {
    private String name = "goblin";
    private String type;
    public static int breedCycle = 30; // 繁殖周期(天)
    public static int minBirthTime = 80; // 最小生育天数
    public static int maxBirthTime = 100; // 最大生育天数
    public static int minBreedAge = 12; // 最小繁殖年龄
    public static int maxBreedAge = 30; // 最大繁殖年龄

    @Override
    public String toString() {
        return "Goblin{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", live=" + live +
                '}';
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
