package com.plopiplop.leekwars.actions;

import com.google.gson.annotations.SerializedName;

public class CompilationException extends Exception {
    private boolean success;
    private int line;
    @SerializedName("char")
    private int character;
    @SerializedName("error")
    private String message;

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
