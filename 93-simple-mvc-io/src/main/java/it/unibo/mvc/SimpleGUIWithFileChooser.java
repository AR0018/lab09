package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String ERROR_TEXT = "There has been an error with the selection of the file";
    private static final String TITLE = "Access to files application";
    private static final int PROPORTION = 3;

    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        final JTextField pathText = new JTextField(controller.getFilePath());
        pathText.setEditable(false);
        final JButton browse = new JButton("Browse...");
        upperPanel.add(pathText, BorderLayout.CENTER);
        upperPanel.add(browse, BorderLayout.LINE_END);
        canvas.add(upperPanel, BorderLayout.NORTH);
        //SimpleGUI elements
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Handlers
         */
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

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooser.getSelectedFile()); 
                    pathText.setText(chooser.getSelectedFile().getAbsolutePath());
                }
                if (chooser.showSaveDialog(frame) == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, ERROR_TEXT, "Error", JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUIWithFileChooser().display();
    }

}
