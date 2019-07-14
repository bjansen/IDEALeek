package com.plopiplop.leekwars.apiclient.dto;

public class AIResponse {
    private AI ai;

    public boolean isSuccess() {
        return ai != null;
    }

    public AI getAi() {
        return ai;
    }

    public static class AI {
        private int id;
        private String name;
        private int level;
        private boolean valid;
        private String code;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public boolean isValid() {
            return valid;
        }

        public String getCode() {
            return code;
        }
    }
}
