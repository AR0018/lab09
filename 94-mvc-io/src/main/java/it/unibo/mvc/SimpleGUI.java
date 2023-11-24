package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private static final String TITLE = "Simple I/O application";

    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new SimpleController();

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField stringField = new JTextField("String to print...");
        final JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show history");
        final JPanel buttonArea = new JPanel();
        buttonArea.setLayout(new BoxLayout(buttonArea, BoxLayout.X_AXIS));
        canvas.add(stringField, BorderLayout.NORTH);
        canvas.add(historyArea, BorderLayout.CENTER);
        buttonArea.add(print);
        buttonArea.add(history);
        canvas.add(buttonArea, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);

        /*
         * Handlers
         */

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(stringField.getText());
                controller.printString();
            }
        });

        history.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                /*
                 * This implementation prints the strings in the history
                 * by separating them with a newline, rather than using the method
                 * toString() to visualize the list in the standard way.
                 */
                String historyString = "";
                for(final String string : controller.getHistory()) {
                    historyString = historyString + string + "\n";
                }
                historyArea.setText(historyString);
            }
            
        });
        
    }

    private void display() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int sw = (int) screen.getWidth();
        int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        
        frame.setVisible(true);
    }

    public static void main(final String args[] ) {
        new SimpleGUI().display();
    }

}
