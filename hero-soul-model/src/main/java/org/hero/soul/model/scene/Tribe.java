package org.hero.soul.model.scene;

import java.util.*;

import org.hero.soul.core.util.RandomUtils;
import org.hero.soul.model.race.Entity;
import org.hero.soul.model.race.Goblin;

/**
 * 部落，一些有智慧的种族个体聚集而成
 *
 * @author Devil
 */
public class Tribe<T extends Entity<T>> {
    private Map<String, T> maleMap = new HashMap<String, T>(); // string为ID，唯一标识，雄性
    private Map<String, T> femaleMap = new HashMap<String, T>(); // string为ID，唯一标识，雌性
    private Map<String, T> asexualMap = new HashMap<String, T>(); // string为ID，唯一标识，无性
    private Class<T> clazz;

    private int maxBreedPossible = 10000; // 最大繁殖概率

    public Tribe(Class<T> clazz) {
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
     *
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
        int mListSize = maleList.size();
        for (int i = 0; i < fListSize; i++) {
            if (RandomUtils.nextInt(maxBreedPossible) > femaleList.get(i).getPossible()) // 如果未生育可能性满足要求
                return;

            T mother = femaleList.get(i);
            int maleId = RandomUtils.nextInt(mListSize);
            T father = maleList.get(maleId);
            // TODO 多胞胎?
            T kid = clazz.newInstance();
            kid.setFather(father);
            kid.setMother(mother);
            kid.setSex(maleId % 2 + 1);

            List<T> kids = null; // add kids to mother and father
            if (mother.getKids() == null || mother.getKids().isEmpty()) {
                kids = new ArrayList<T>();
                mother.setKids(kids);
            } else {
                kids = mother.getKids();
            }
            kids.add(kid);

            if (father.getKids() == null || father.getKids().isEmpty()) {
                kids = new ArrayList<T>();
                father.setKids(kids);
            } else {
                kids = father.getKids();
            }
            kids.add(kid);

            String uuid = UUID.randomUUID().toString();
            if (maleId % 2 + 1 == 1) {
                // check if is exist
                uuid = checkId(uuid, maleMap);
                maleMap.put(uuid, kid);
            } else {
                uuid = checkId(uuid, femaleMap);
                femaleMap.put(uuid, kid);
            }
            kid.setId(uuid);

        }

    }

    /**
     * 检查ID
     *
     * @param uuid
     * @param map
     */
    public String checkId(String uuid, Map<String, T> map) {
        if (null != maleMap.get(uuid)) {
            uuid = UUID.randomUUID().toString();
            uuid = checkId(uuid, map);
        }
        return uuid;
    }

    /**
     * 表示生长
     */
    public void liveUp() {
        for (String id : maleMap.keySet()) {
            maleMap.get(id).liveUp();
        }
        for (String id : femaleMap.keySet()) {
            femaleMap.get(id).liveUp();
        }
    }

    /**
     * print all the entity in this tribe
     */
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
