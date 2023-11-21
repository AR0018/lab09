package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private static final String TITLE = "Write on file GUI";

    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnFile(text.getText());
                } catch (final IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Write Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sWidth = (int) screen.getWidth();
        final int sHeight = (int) screen.getHeight();
        frame.setSize(sWidth/PROPORTION, sHeight/PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
