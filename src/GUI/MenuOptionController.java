package GUI;

import javax.swing.*;
import java.awt.*;

abstract class MenuOptionController extends JFrame {
    public abstract String getOptionName();
    public abstract String getOptionNumber();
    public void setWindow(int width, int height, String name){
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 3
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

}

