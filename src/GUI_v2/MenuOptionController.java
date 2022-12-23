package GUI_v2;

import javax.swing.*;
import java.awt.*;

abstract class MenuOptionController extends JFrame {

    public abstract String getOptionName();
    public abstract String getOptionNumber();
    public void setWindow(int width, int height, String title){
        setSize(width,height);
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

}

