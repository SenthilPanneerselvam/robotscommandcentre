package org.learning.rcc.models;

public class Board {

    private Integer length;

    private Integer breadth;

    public Board(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getBreadth() {
        return breadth;
    }

    public void setBreadth(Integer breadth) {
        this.breadth = breadth;
    }

    public boolean isGridValid(int x, int y) {
        return x < length && y < breadth;
    }

    public boolean isGridValid(Grid grid) {
        return isGridValid(grid.getX(), grid.getY());
    }

    @Override
    public String toString() {
        return "Board{" +
                "length=" + length +
                ", breadth=" + breadth +
                "}";
    }
}
