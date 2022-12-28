package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Demo extends JFrame {
    public static void main(String[] args) throws IOException {
        //JFrame frame = new JFrame("Image Viewer");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an ImagePanel with the desired size and image file
        //ImagePanel panel = new ImagePanel("image.jpg", 400, 300);
        //frame.add(panel);

        //frame.pack();
        //frame.setVisible(true);
        //String dir = System.getProperty("user.dir");
        //System.out.println(dir);
        //Runtime.getRuntime().exec("explorer "+dir+"\\src\\img");
        //System.out.println(System.getProperty("user.dir"));
        //System.getProperty("os.name");
        //String os = System.getProperty("os.name");
        //if (os.equals("Windows 10") || os.equals("Windows 11")) {
            //System.out.println("Ok");
        //}
    }

    private void frame() throws IOException {
        setSize(400,400);
        setTitle("title");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        File file = new File("C:\\Users\\lahir\\OneDrive\\Pictures\\pic\\FB_IMG_1637932980351.jpg");


        setVisible(true);
    }
}
