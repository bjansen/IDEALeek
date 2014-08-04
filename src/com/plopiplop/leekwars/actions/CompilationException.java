package com.plopiplop.leekwars.actions;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

public class CompilationException extends Exception {
    private boolean success;
    private int line;
    @SerializedName("char")
    private int character;
    @SerializedName("error")
    private String message;

    public CompilationException(String result) {
        Object[][] objects;

        try {
            objects = new Gson().fromJson(result, Object[][].class);
        } catch (JsonSyntaxException e) {
            success = false;
            message = "Internal error, please report it (result was " + result + ")";
            return;
        }

        for (Object[] object : objects) {
            int code = (int) Double.parseDouble(object[0].toString());
            success = code == 2;

            if (code == 1) {
                message = "Unknown error";
            } else if (code == 0) {
                line = (int) Double.parseDouble(object[3].toString());
                character = (int) Double.parseDouble(object[4].toString());
                message = object[5].toString();
            }
        }
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
