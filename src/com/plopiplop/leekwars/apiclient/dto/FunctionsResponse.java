package com.plopiplop.leekwars.apiclient.dto;

import java.util.List;

public class FunctionsResponse {
    private List<Fun> functions;

    public List<Fun> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Fun> functions) {
        this.functions = functions;
    }

    public static class Fun {
        private String name;
        private int level;
        private int category;
        private List<String> arguments_names;

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public int getCategory() {
            return category;
        }

        public List<String> getArgumentNames() {
            return arguments_names;
        }
    }
}
