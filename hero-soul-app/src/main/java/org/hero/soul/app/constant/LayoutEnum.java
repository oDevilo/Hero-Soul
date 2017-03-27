package org.hero.soul.app.constant;

/**
 * 用于定义尺寸的位置的枚举
 */
public enum LayoutEnum {
    WINDOW(200, 20, 850, 700, "框架"),    // FRAME宽800高600,使用时需减去对应部分
    TALK_AREA(10, 10, WINDOW.getWidth() - 40, WINDOW.getHeight() - 70, "文本显示区域"),
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
