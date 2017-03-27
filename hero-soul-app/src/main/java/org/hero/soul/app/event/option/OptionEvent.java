package org.hero.soul.app.event.option;

import java.util.List;

import org.hero.soul.app.constant.KeyConstants;
import org.hero.soul.app.event.Event;
import org.hero.soul.app.handler.PrintHandler;
import org.hero.soul.app.ui.MainWindow;

public class OptionEvent implements Event {
    List<Option> options;

    public OptionEvent(List<Option> options) {
        this.options = options;
    }

    @Override
    public void excute(int key) {
        if (KeyConstants.VK_UP == key) {
            
        }
        if (KeyConstants.VK_DOWN == key) {

        }
        if (KeyConstants.VK_LEFT == key) {
            PrintHandler.turnLeft();
            MainWindow.doOption(options);
        }
        if (KeyConstants.VK_RIGHT == key) {
            PrintHandler.turnRight();
            MainWindow.doOption(options);
        }
    }

}
