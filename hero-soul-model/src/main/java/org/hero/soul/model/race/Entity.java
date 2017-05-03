package org.hero.soul.model.race;

import org.hero.soul.model.scene.DateDirector;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Entity<T> implements Race {
    protected String id;
    protected T father;
    protected T mother;
    protected List<T> kids;
    protected int age = 0; // 目前按公历的计算方式
    protected Date birthDay = DateDirector.NOW; // 出生日期
    protected int live = 0; // 按天计算的时间
    protected int sex; // 0.无性 1.男 2.女
    protected int possible = 5000; // 生育可能

    public int getPossible() {
        return possible;
    }

    public void setPossible(int possible) {
        this.possible = possible;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int liveUp() {
        live++;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDay);
        int tempAge = DateDirector.getTypeTime(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        if (DateDirector.getTypeTime(Calendar.MONTH) - calendar.get(Calendar.MONTH) > 0 || DateDirector.getTypeTime(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH) > 0)
            age = tempAge + 1;

        return live;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public T getFather() {
        return father;
    }

    public void setFather(T father) {
        this.father = father;
    }

    public T getMother() {
        return mother;
    }

    public void setMother(T mother) {
        this.mother = mother;
    }

    public List<T> getKids() {
        return kids;
    }

    public void setKids(List<T> kids) {
        this.kids = kids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
