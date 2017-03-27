package org.hero.soul.app.event;

/**
 * 一个需要监听的对象绑定一个事件处理器
 * @author Devil
 *
 */
public class EventHandler {
    private Event event;

    public void excuteEvent(int key) {
        event.excute(key);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
