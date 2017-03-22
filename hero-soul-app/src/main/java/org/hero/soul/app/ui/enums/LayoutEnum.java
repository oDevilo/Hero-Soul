package org.hero.soul.app.ui.enums;

/**
 * 用于定义尺寸的位置的枚举
 */
public enum LayoutEnum {
    FRAME(0, 0, 850, 700, "框架"),    // FRAME宽800高600,使用时需减去对应部分
    TALK_AREA(20,0,(FRAME.getWidth()-5)/2,(FRAME.getHeight()-100)/2,"文本显示区域"),
    SCENE(0,0,10,FRAME.getHeight()-100,"互动场景"),
    SELECT_BUTTON_AREA(TALK_AREA.getX(),TALK_AREA.getHeight(),TALK_AREA.getWidth(),FRAME.getHeight()-100-TALK_AREA.getHeight(),"用户选择按钮区域")
    ;
    private int x;
    private int y;
    private int width;
    private int height;
    private String description;

    private LayoutEnum(int x, int y, int width, int height, String description) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.description = description;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
