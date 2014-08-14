package com.plopiplop.leekwars.model;

public class AbstractItem {
    public String id;
    public String name;
    public String level;
    public String description;
    public String price;
    public String value;

    /**
     * @return {@link AbstractItem#id}
     */
    public String getId() {
        return id;
    }

    /**
     * @return {@link AbstractItem#name}
     */
    public String getName() {
        return name;
    }

    /**
     * @return {@link AbstractItem#level}
     */
    public String getLevel() {
        return level;
    }

    /**
     * @return {@link AbstractItem#description}
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return {@link AbstractItem#price}
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return {@link AbstractItem#value}
     */
    public String getValue() {
        return value;
    }
}
