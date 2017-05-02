package org.hero.soul.model.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hero.soul.core.util.RandomUtils;
import org.hero.soul.model.enemy.Entity;
import org.hero.soul.model.enemy.Goblin;

/**
 * 部落，一些有智慧的种族个体聚集而成
 * 
 * @author Devil
 *
 */
public class Tribe<T extends Entity<T>> {
    private Map<String, T> maleMap = new HashMap<String, T>(); // string为ID，唯一标识，雄性
    private Map<String, T> femaleMap = new HashMap<String, T>(); // string为ID，唯一标识，雌性
    private Map<String, T> asexualMap = new HashMap<String, T>(); // string为ID，唯一标识，无性
    private Class<T> clazz;
    
    private int maxPossible = 10000; // 最大概率 
    
    public Tribe(Class<T> clazz){
        this.clazz = clazz;
    }

    public void putMale(String name, T value) {
        maleMap.put(name, value);
    }

    public void putFemale(String name, T value) {
        femaleMap.put(name, value);
    }

    public void putAsexual(String name, T value) {
        asexualMap.put(name, value);
    }

    /**
     * 繁殖
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public void breed() throws InstantiationException, IllegalAccessException {
        // 雄性
        List<T> maleList = new ArrayList<T>();// 可以繁殖的对象
        for (String key : maleMap.keySet()) {
            T t = maleMap.get(key);
            if (t.getAge() >= Goblin.minBreedAge && t.getAge() <= Goblin.maxBreedAge) {
                maleList.add(t);
            }
        }
        
        if (!(maleList.size() > 0)) {
            return;
        }

        // 雌性
        List<T> femaleList = new ArrayList<T>();// 可以繁殖的对象
        for (String key : femaleMap.keySet()) {
            T t = femaleMap.get(key);
            if (t.getAge() >= Goblin.minBreedAge && t.getAge() <= Goblin.maxBreedAge) {
                femaleList.add(t);
            }
        }
        
        if (!(femaleList.size() > 0)) {
            return;
        }

        int fListSize = femaleList.size(); // 可进行繁殖的雌性数组大小
        for (int i = 0; i < fListSize; i++) {
            if (RandomUtils.nextInt(maxPossible) > femaleList.get(i).getPossible()) // 如果未生育可能性满足要求
                return;

            T mother = femaleList.get(i);
            int maleId = RandomUtils.nextInt(maleList.size() * 100) / 100;
            T father = maleList.get(maleId);
            // TODO 多胞胎?
            T kid = clazz.newInstance();
            kid.setFather(father);
            kid.setMother(mother);
            kid.setId(father.getId() + mother.getId());
            kid.setSex(maleId % 2 + 1);

            List<T> kids = null;
            if (mother.getKids() == null || mother.getKids().isEmpty()) {
                kids = new ArrayList<T>();
                mother.setKids(kids);
            } else {
                kids = mother.getKids();
            }
            kids.add(kid);

            if (maleId % 2 + 1 == 1) {
                System.out.println("put male father:" + father.getId() + " mother:" + mother.getId());
                maleMap.put(father.getId() + mother.getId() + "i" + maleMap.size(), kid);
            } else {
                System.out.println("put female father:" + father.getId() + " mother:" + mother.getId());
                femaleMap.put(father.getId() + mother.getId()+ "i" + femaleMap.size(), kid);
            }

        }

    }
    
    public void liveUp(){
        for (String id : maleMap.keySet()) {
            maleMap.get(id).liveUp();
        }
        for (String id : femaleMap.keySet()) {
            femaleMap.get(id).liveUp();
        }
    }

    public void print() {
        System.out.println("==========雄性:" + maleMap.size() + "=================");
        for (String id : maleMap.keySet()) {
            System.out.println(maleMap.get(id).toString());
        }
        System.out.println("==========雌性:" + femaleMap.size() + "=================");
        for (String id : femaleMap.keySet()) {
            System.out.println(femaleMap.get(id).toString());
        }
    }

}
