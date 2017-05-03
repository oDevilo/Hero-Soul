package org.hero.soul.model.enemy;

import java.util.List;

import org.hero.soul.core.constant.DateConstants;

public class Entity<T> {
    protected String id;
    protected T father;
    protected T mother;
    protected List<T> kids;
    protected int age; // 年龄
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
        age = live / DateConstants.YEAR;
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

    public void setAge(int age) {
        this.age = age;
        this.live = age * DateConstants.YEAR;
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
