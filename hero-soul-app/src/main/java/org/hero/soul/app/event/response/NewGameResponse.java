package org.hero.soul.app.event.response;

public class NewGameResponse implements BaseResponse {

    @Override
    public void excute(int key) {
        System.out.println("do init game");
    }

}
