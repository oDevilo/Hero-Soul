package org.hero.soul.app.event.option;

import org.hero.soul.app.event.Event;

public class Option {
    private int id;
    private String text;
    private Event event;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Option [id=" + id + ", text=" + text + ", event=" + event + "]";
    }

}
