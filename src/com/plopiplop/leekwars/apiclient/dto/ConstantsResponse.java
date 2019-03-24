package com.plopiplop.leekwars.apiclient.dto;

import com.plopiplop.leekwars.model.Constant;

import java.util.List;

public class ConstantsResponse {
    private boolean success;
    private List<Constant> constants;

    public boolean isSuccess() {
        return success;
    }

    public List<Constant> getConstants() {
        return constants;
    }
}
