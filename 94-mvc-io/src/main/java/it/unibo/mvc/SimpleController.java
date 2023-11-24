package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of a simple controller for I/O access
 *
 */
public final class SimpleController implements Controller {

    private String current;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextString(final String newString) {
        Objects.requireNonNull(newString);
        this.current = newString;
    }

    @Override
    public String getNextString() {
        return this.current;
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public void printString() {
        if(this.current == null) {
            throw new IllegalStateException("The current string is unset");
        }
        System.out.println(current);
        history.add(current);
        current = null;
    }

}
