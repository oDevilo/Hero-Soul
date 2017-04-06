package org.hero.soul.app.event.response;

import org.hero.soul.app.ui.MainWindow;
import org.hero.soul.core.util.ThreadUtils;

public class NewGameResponse implements ResponseEvent {

    @Override
    public void excute(int key) {
        // 加载信息
        MainWindow.changeText("新的游戏开始了\n");
//        ThreadUtils.sleep(1000l);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        MainWindow.appendText("你是新的国王\n");
//		ThreadUtils.sleep(1000l);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        MainWindow.appendText("你需要管理你的王国\n");
    }

    
}
