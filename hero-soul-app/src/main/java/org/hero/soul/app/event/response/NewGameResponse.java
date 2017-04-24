package org.hero.soul.app.event.response;

import org.hero.soul.app.game.Game;
import org.hero.soul.app.ui.MainWindow;
import org.hero.soul.model.enemy.Goblin;
import org.hero.soul.model.map.City;
import org.hero.soul.model.map.Gate;
import org.hero.soul.model.map.MapEntity;
import org.hero.soul.model.map.Tribe;
import org.hero.soul.model.map.Wall;

public class NewGameResponse implements ResponseEvent {

    @Override
    public void excute(int key) {
        // TODO 加载并显示开头的独白信息
        String[] texts = new String[] { "新的游戏开始了\n", "你将在这里经历你的一生\n" };
        MainWindow.changeText(texts);

        // 初始化地图信息
        MapEntity<Wall> w11 = new MapEntity<Wall>("w11", new Wall());
        MapEntity<Wall> w13 = new MapEntity<Wall>("w13", new Wall());
        MapEntity<Wall> w31 = new MapEntity<Wall>("w31", new Wall());
        MapEntity<Wall> w33 = new MapEntity<Wall>("w33", new Wall());

        MapEntity<Gate> northGate = new MapEntity<Gate>("northGate", new Gate());
        MapEntity<Gate> southGate = new MapEntity<Gate>("southGate", new Gate());
        MapEntity<Gate> westGate = new MapEntity<Gate>("westGate", new Gate());
        MapEntity<Gate> eastGate = new MapEntity<Gate>("eastGate", new Gate());
        
        MapEntity<City> city = new MapEntity<City>("city", new City());

        Game.map.put(w11, 2, 2);
        Game.map.put(w13, 2, 4);
        Game.map.put(w31, 4, 2);
        Game.map.put(w33, 4, 4);
        Game.map.put(northGate, 2, 3);
        Game.map.put(southGate, 4, 3);
        Game.map.put(westGate, 3, 2);
        Game.map.put(eastGate, 3, 4);
        Game.map.put(city, 3, 3);

        // 哥布林部落
        MapEntity<Tribe<Goblin>> goblinTribe = new MapEntity<Tribe<Goblin>>("goblinTribe", new Tribe<Goblin>(Goblin.class));
        // TODO 根据环境因素，初始化部落的人员
        Game.map.put(goblinTribe, 6, 6);
        
        // TODO 进入游戏主流程
    }

}
