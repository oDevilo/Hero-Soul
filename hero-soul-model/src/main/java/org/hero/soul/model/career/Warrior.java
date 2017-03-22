package org.hero.soul.model.career;

/**
 * 战士
 *
 */
public class Warrior implements Career {
    private String name;
    private int hp = 10;
    private int atk = 2;
    private int def = 1;
    private int spd = 3;
    private double eva = 0; // 闪避
    private double hit = 1; // 命中
    private int ap = 100; // 行动点
    
    private Integer posX = 0;	//角色的X坐标
    private Integer poxY = 0;	//角色的Y坐标
    
    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public double getEva() {
        return eva;
    }

    public void setEva(double eva) {
        this.eva = eva;
    }

    public double getHit() {
        return hit;
    }

    public void setHit(double hit) {
        this.hit = hit;
    }

    public void attack() {

    }

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPoxY() {
		return poxY;
	}

	public void setPoxY(Integer poxY) {
		this.poxY = poxY;
	}
}
