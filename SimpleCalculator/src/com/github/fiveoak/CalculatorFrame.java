package com.github.fiveoak;

import javax.swing.JFrame;

/**
 * The JFrame for the calculator GUI.
 * @author fiveoak
 *
 */
public class CalculatorFrame extends JFrame {
    /**
     * Default height for the frame.
     */
    private static final int DEFAULT_FRAME_HEIGHT = 400;

    /**
     * Default width for the frame.
     */
    private static final int DEFAULT_FRAME_WIDTH = 400;

    /**
     * Default constructor which sets up the JFrame.
     */
    CalculatorFrame() {
        super("Simple Java Calculator");
        this.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
    }


}
