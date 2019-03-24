package com.plopiplop.leekwars.model;

public class Constant {
    private String name;
    private Object value;
    private int type;
    private int category;
    private int deprecated;
    public String description;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public int getType() {
        return type;
    }

    public int getCategory() {
        return category;
    }

    public int getDeprecated() {
        return deprecated;
    }

    public String getDescription() {
        return description;
    }
}
