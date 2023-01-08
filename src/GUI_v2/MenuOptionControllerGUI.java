package GUI_v2;

import javax.swing.*;
import java.awt.*;

abstract class MenuOptionControllerGUI extends JFrame {

    // Get Option Name
    protected abstract String getOptionName();
    // Get option Number
    protected abstract String getOptionNumber();
    // Set Window
    protected void setWindow(int width, int height, String title){
        setSize(width,height);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }
    // Set Color
    protected Color RGBColor = new Color(150,255,255);
    protected Color RGBColor2 = new Color(30, 70, 250);
    protected Color RGBColor3 = new Color(255, 255, 255);
    protected Color RGBColor4 = new Color(30, 250, 34);
    protected Color RGBColor5 = new Color(0, 0, 0);
    // Warning Massage
    protected void warningMassage(String massage,String warningType) {
        JOptionPane.showMessageDialog(null, massage, warningType, JOptionPane.WARNING_MESSAGE);
    }

}

