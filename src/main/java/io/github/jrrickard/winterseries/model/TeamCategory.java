package io.github.jrrickard.winterseries.model;


public enum TeamCategory {
    HERO_COED(2),
    HIGH_SCHOOL(1),
    OPEN_COED(3);

    private int teamValue;

    TeamCategory(int value) {
        this.teamValue = value;
    }
}
