package com.epam.task.nine.model;

public class TimingMenu {
    private static final int  BURGER_TIME = 1000;
    private static final int  POTATO = 1000;
    private static final int  BEEF = 1000;
    private static final int  COFFEE = 400;
    private static final int  TEA = 500;

    public static int getBurgerTime() {
        return BURGER_TIME;
    }

    public static int getPotatoTime() {
        return POTATO;
    }

    public static int getBeefTime() {
        return BEEF;
    }

    public static int getCoffeeTime() {
        return COFFEE;
    }

    public static int getTeaTime() {
        return TEA;
    }
}
