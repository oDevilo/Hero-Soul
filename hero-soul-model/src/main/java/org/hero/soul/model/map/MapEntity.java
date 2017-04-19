package org.hero.soul.model.map;

public class MapEntity<T> {
    private MapEntity<?> top;
    private MapEntity<?> bottom;
    private MapEntity<?> left;
    private MapEntity<?> right;
    private T value;
    private String name;

    public MapEntity() {
    }

    public MapEntity(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapEntity<?> getTop() {
        return top;
    }

    public void setTop(MapEntity<?> top) {
        this.top = top;
    }

    public MapEntity<?> getBottom() {
        return bottom;
    }

    public void setBottom(MapEntity<?> bottom) {
        this.bottom = bottom;
    }

    public MapEntity<?> getLeft() {
        return left;
    }

    public void setLeft(MapEntity<?> left) {
        this.left = left;
    }

    public MapEntity<?> getRight() {
        return right;
    }

    public void setRight(MapEntity<?> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
