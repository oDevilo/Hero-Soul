package org.hero.soul.app.event.option;

import java.util.List;

import org.hero.soul.app.constant.KeyConstants;
import org.hero.soul.app.constant.PrintConstants;
import org.hero.soul.app.event.Event;
import org.hero.soul.app.ui.MainWindow;

public class OptionEvent implements Event {
    private List<Option> options;
    private int total;
    private int current;

    public OptionEvent(List<Option> options) {
        this.options = options;
        this.total = options.size();
        this.current = 0;
        MainWindow.changeText(getOptionText()); // 先对界面进行一次渲染
    }

    @Override
    public void excute(int key) {
        if (KeyConstants.VK_ENTER == key) {
            options.get(current).getEvent().excute(key);
        }
        if (KeyConstants.VK_UP == key) {

        }
        if (KeyConstants.VK_DOWN == key) {

        }
        if (KeyConstants.VK_LEFT == key) {
            turnLeft();
            MainWindow.changeText(getOptionText());
        }
        if (KeyConstants.VK_RIGHT == key) {
            turnRight();
            MainWindow.changeText(getOptionText());
        }
    }

    /**
     * 获取选择的文本
     * 
     * @return
     */
    public String getOptionText() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < total; i++) {
            if (i == current)
                sb.append(PrintConstants.SELECT + (i + 1) + PrintConstants.POINT + options.get(i).getText());
            else
                sb.append(PrintConstants.TAB + (i + 1) + PrintConstants.POINT + options.get(i).getText());
        }
        return sb.toString();
    }

    public void turnLeft() {
        current--;
    }

    public void turnRight() {
        current++;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
