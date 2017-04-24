package org.hero.soul.model.enemy;

/**
 * 哥布林
 * 
 * @author Devil
 *
 */
public class Goblin extends Entity<Goblin> {
    private String name;
    private String type;
    public static int breedCycle = 30; // 繁殖周期(天)
    public static int birthTime = 90; // 90天生育
    public static int minBreedAge = 12; // 最小繁殖年龄
    public static int maxBreedAge = 30; // 最大繁殖年龄

    @Override
    public String toString() {
        return "Goblin [id=" + id + ", name=" + name + ", type=" + type + ", age=" + age + ", live=" + live + ", sex=" + sex + "]";
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
