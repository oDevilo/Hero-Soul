package org.hero.soul.app.event.response;

import org.hero.soul.app.ui.MainWindow;

public class NewGameResponse implements ResponseEvent {

    @Override
    public void excute(int key) {
        // 加载信息
        MainWindow.changeText("新的游戏开始了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainWindow.appendText("你是新的国王");
    }

    
}
