package com.plopiplop.leekwars.actions;

import java.util.ArrayList;
import java.util.List;

public class CompilationException extends Exception {

    private final List<CompilationError> errors = new ArrayList<>();

    public CompilationException(List<Object> objects) {
        for (Object o : objects) {
            errors.add(new CompilationError((List<Object>) o));
        }
    }

    public List<CompilationError> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return errors.size() == 0;
    }
}
