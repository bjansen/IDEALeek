package com.plopiplop.leekwars.apiclient.dto;

import java.util.Collection;
import java.util.Map;

public class WeaponsResponse {

    private Boolean success;

    private Map<String, Weap> weapons;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Collection<Weap> getWeapons() {
        return weapons.values();
    }

    public void setWeapons(Map<String, Weap> weapons) {
        this.weapons = weapons;
    }

    public static class Weap {
        private String id;
        private String name;
        private int level;
        private int cost;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public int getCost() {
            return cost;
        }
    }
}
