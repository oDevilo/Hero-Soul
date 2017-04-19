package org.hero.soul.app.game;

import java.util.List;

import org.hero.soul.app.event.option.Option;
import org.hero.soul.app.event.option.OptionEvent;
import org.hero.soul.app.ui.MainWindow;

/**
 * 游戏主类
 */
public class Game {
    
    public static Map map = new Map();

    public void initGame() {
        MainWindow.init();
        List<Option> options = MenuOptions.getMenuOptions();
        MainWindow.addEvent(new OptionEvent(options));
    }
    
}
