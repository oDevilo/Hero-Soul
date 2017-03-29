package org.hero.soul.app.game;

import java.util.ArrayList;
import java.util.List;

import org.hero.soul.app.event.option.Option;
import org.hero.soul.app.event.response.NewGameResponse;

public class MenuOptions {
    // 主界面菜单
    public static List<Option> getMenuOptions() {
        List<Option> options = new ArrayList<Option>();
        Option newGame = new Option();
        newGame.setText("新游戏");
        newGame.setEvent(new NewGameResponse());
        options.add(newGame);
        Option loadGame = new Option();
        loadGame.setText("继续游戏");
        options.add(loadGame);
        Option setting = new Option();
        setting.setText("设置");
        options.add(setting);
        Option endGame = new Option();
        endGame.setText("退出游戏");
        options.add(endGame);
        return options;
    }
}
