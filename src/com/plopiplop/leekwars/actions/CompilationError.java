package com.plopiplop.leekwars.actions;

import java.util.List;

public class CompilationError {
    private final boolean success;

    private final int line;

    private final int character;

    private final String message;

    public CompilationError(List<Object> data) {
        int code = (int) Double.parseDouble(data.get(0).toString());

        if (code == 2) {
            success = true;
            line = -1;
            character = -1;
            message = null;
        } else if (code == 0) {
            success = false;
            line = (int) Double.parseDouble(data.get(2).toString());
            character = (int) Double.parseDouble(data.get(3).toString());
            message = data.get(5).toString();
        } else {
            success = false;
            line = -1;
            character = -1;
            message = "Unknown error";
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public int getLine() {
        return line;
    }

    public int getCharacter() {
        return character;
    }

    public String getMessage() {
        return message;
    }
}
