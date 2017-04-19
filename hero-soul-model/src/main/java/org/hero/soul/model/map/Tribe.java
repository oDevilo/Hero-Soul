package org.hero.soul.model.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 部落，一些有智慧的种族个体聚集而成
 * 
 * @author Devil
 *
 */
public class Tribe<T> {
    private Map<String, T> map = new HashMap<String, T>();

    public void put(String name, T value) {
        map.put(name, value);
    }
    
    public void excute(){
        
    }
}
