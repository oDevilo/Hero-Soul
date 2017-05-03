package org.hero.soul.app.game;

import org.hero.soul.model.scene.MapEntity;

/**
 * 地图
 * 
 * @author Devil
 *
 */
public class Map {
    final int MIN_SIZE = 8;
    private MapEntity[][] table = new MapEntity[MIN_SIZE][MIN_SIZE];

    public void put(MapEntity<?> value, int x, int y) {
        table[x][y] = value;
    }
    
    
    
}
