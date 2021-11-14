package org.learning.rcc;

import org.learning.rcc.internals.BoardState;

public class ApplicationLauncher {

    public static void main(String[] args) {
        // initialize the state
        BoardState state = BoardState.getInstance();
        // create a thread to look for collision
        // seems hard to test this by command line
        // listen for inputs
        // pass the instruction to the processor
        // break when given exit
    }

}
