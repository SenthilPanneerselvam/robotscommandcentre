package org.learning.rcc.models;

import java.util.Objects;

public class Robot {

    private String code;

    private Grid grid;

    public Robot(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return Objects.equals(code, robot.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
