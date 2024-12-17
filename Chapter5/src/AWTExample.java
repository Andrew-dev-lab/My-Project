import java.awt.*;
import java.awt.event.*;

public class AWTExample {
    public static void main(String[] args) {
        // Create a window (Frame)
        Frame frame = new Frame("AWT Example");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create a button and a label
        Button button = new Button("Click Me");
        Label label = new Label("Welcome!");

        // Add an event listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button clicked!");
            }
        });

        // Add components to the frame
        frame.add(button);
        frame.add(label);

        // Add window closing functionality
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Display the window
        frame.setVisible(true);
    }
}