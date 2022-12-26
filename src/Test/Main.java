package Test;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        // Create an ImagePanel with the desired size and image file
        ImagePanel panel = new ImagePanel("C:\\Users\\lahir\\OneDrive\\Pictures\\Saved Pictures\\devil-boy-4k-f9.jpg", 400, 300);
        frame.add(panel);

        //frame.pack();
        frame.setVisible(true);
    }
}
