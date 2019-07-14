package com.plopiplop.leekwars.apiclient.dto;

import java.util.List;

public class AIsResponse {
    private List<AI> ais;

    public List<AI> getAis() {
        return ais;
    }

    public void setAis(List<AI> ais) {
        this.ais = ais;
    }

    public static class AI {
        private int id;
        private String name;
        private int level;
        private boolean valid;
        private int folder;
        private int v2;

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public int getId() {
            return id;
        }

        public boolean isValid() {
            return valid;
        }

        public int getFolder() {
            return folder;
        }

        public int getV2() {
            return v2;
        }
    }
}
