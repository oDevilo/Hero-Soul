package org.hero.soul.model.enemy;

/**
 * 丧尸 爬行者
 *
 */
public class Crawler implements Enemy {
    public static final String name = "Crawler";
    private int atk = 1;
    private int hp = 5;
    private int spd = 2;



    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

}
