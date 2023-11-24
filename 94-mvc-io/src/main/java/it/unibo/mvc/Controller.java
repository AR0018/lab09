package it.unibo.mvc;

import java.util.List;

/**
 *Interface that models a simple controller responsible of I/O access
 */
public interface Controller {

    /**
     * Sets the next string to print
     * 
     * @param newString
     * @throws NullPointerException if the string passed is null
     */
    void setNextString(String newString);

    /**
     * @return the next string to print, or null if the string is unset
     */
    String getNextString();

    /**
     * Returns the history of the printed strings
     * 
     * @return a list with every printed string
     */
    List<String> getHistory();

    /**
     * Prints the current string
     * 
     * @throws IllegalStateException if the current string is unset
     */
    void printString();


}
