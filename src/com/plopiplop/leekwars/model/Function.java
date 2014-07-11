package com.plopiplop.leekwars.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Function {
    public String name;

    public String description;

    public Map<String, String> parameters = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
