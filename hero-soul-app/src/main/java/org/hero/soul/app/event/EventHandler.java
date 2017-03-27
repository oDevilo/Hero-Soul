package org.hero.soul.app.event;

public class EventHandler {
    private static Event event;

    public static void excuteEvent(int key) {
        event.excute(key);
    }

    public static Event getEvent() {
        return event;
    }

    public static void setEvent(Event event) {
        EventHandler.event = event;
    }
}
