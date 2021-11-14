package org.learning.rcc.models;

import java.util.Objects;

public class Grid {

    private Integer x;

    private Integer y;

    public Grid(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grid)) return false;
        Grid grid = (Grid) o;
        return Objects.equals(x, grid.x) &&
                Objects.equals(y, grid.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Grid[" + x + "," + y + "]";
    }
}
