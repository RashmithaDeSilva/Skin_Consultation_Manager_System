package GUI_v2;


import consoleSystem_v2.SkinConsultationManager;
import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainMenuGUI extends JFrame {

    private JLabel mainMenuNameLbl;
    private JPanel mainMenuPnl;
    private Color RGBColor = new Color(150,255,255);
    protected Color RGBColor2 = new Color(30, 70, 250);
    protected Color RGBColor3 = new Color(255, 255, 255);
    protected Color RGBColor4 = new Color(30, 250, 34);
    protected Color RGBColor5 = new Color(0, 0, 0);
    protected Color RGBColor6 = new Color(245, 116, 116);
    private final String os = System.getProperty("os.name");
    private ArrayList<MenuOptionControllerGUI> MOC = new ArrayList<>();
    private ArrayList<JLabel> lbl = new ArrayList<>();
    private ArrayList<JButton> btn = new ArrayList<>();


    // Contractor
    public MainMenuGUI(SkinConsultationManager SCM){

        // Set Window
        setWindow(600,400,"Westminster Skin Consultation Manager");

        // Set Body
        GUIBody(SCM);
    }


    // Set Window
    private void setWindow(int width, int height, String name){
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new FlowLayout());
    }

    // Set Body
    private void GUIBody(SkinConsultationManager SCM) {

        mainMenuPnl = new JPanel(new GridBagLayout());
        GridBagConstraints GBC = new GridBagConstraints();

        // Set Main Menu Name
        GBC.insets = new Insets(0,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        mainMenuNameLbl = new JLabel();
        // Set Gift Image Into Label
        try {
            // This Image Work With Only Windows And MacOs
            if(os.startsWith("Windows")){
                mainMenuNameLbl.setIcon(new ImageIcon(".\\src\\Data\\WSCM.gif"));
            } else if (os.startsWith("Mac")) {
                mainMenuNameLbl.setIcon(new ImageIcon("./src/Data/WSCM.gif"));
            }
        } catch (Exception e) {
            //If the image is not in the database
            // it will display the name "Westminster Skin Consultation Manager"
            mainMenuNameLbl = new JLabel("Main Menu");
            mainMenuNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        }
        mainMenuPnl.add(mainMenuNameLbl,GBC);

        // Menu Options
        MOC.add(new ViewListOfDoctorsGUI(SCM,this)); // 1 - View List of Doctors
        MOC.add(new ConsultationGUI(SCM,this)); // 2 - Consultation

        // Set Other Option Buttons, Labels And Events
        for(int i=0;i<MOC.size();i++){
            int count = i;
            lbl.add(new JLabel(MOC.get(i).getOptionNumber()));
            btn.add(new JButton(MOC.get(i).getOptionName()));
            btn.get(i).setBackground(RGBColor2);
            btn.get(i).setForeground(RGBColor3);
            btn.get(i).addActionListener( (e) -> MOC.get(count).setVisible(true));
        }

        // 2 - Consultation
        btn.get(1).addActionListener( (e) -> setVisible(false));

        // 3 - Refresh
        lbl.add(new JLabel("["+(lbl.size()+1)+"]"));
        btn.add(new JButton("Refresh"));
        btn.get(btn.size()-1).setBackground(RGBColor4);
        btn.get(btn.size()-1).setForeground(RGBColor5);
        btn.get(btn.size()-1).addActionListener( (e) -> {
             /*
                    This refresh button close all menu option windows and it closes itself also
                    here I use dispose() method in that work
                    because I want to kill all objects and open this object again
                    with WestminsterSkinConsultationManager Object
                    then this new MainMenu object is updated with a new doctor ArrayList
                 */
            for (MenuOptionControllerGUI menuOptionController : MOC) {
                menuOptionController.dispose();
            }
            dispose();
            SCM.openGUI();
        });

        // 4 - Exit
        lbl.add(new JLabel("["+(lbl.size()+1)+"]"));
        btn.add(new JButton("Exit"));
        btn.get(btn.size()-1).setBackground(RGBColor6);
        btn.get(btn.size()-1).setForeground(RGBColor5);
        btn.get(btn.size()-1).addActionListener( (e) -> {
            // This exit button is close all windows
            // All Visible False Object eligible for garbage collector
            for (MenuOptionControllerGUI menuOptionController : MOC) {
                menuOptionController.dispose();
            }
            dispose();
        });


        GBC.insets = new Insets(5,5,0,5);
        GBC.gridx = 0;
        GBC.gridy = 1;
        mainMenuPnl.add(mainMenuPotion(lbl.get(0),btn.get(0)),GBC);

        GBC.insets = new Insets(5,-43,0,5);
        GBC.gridx = 0;
        GBC.gridy = 2;
        mainMenuPnl.add(mainMenuPotion(lbl.get(1),btn.get(1)),GBC);

        GBC.insets = new Insets(5,-74,0,5);
        GBC.gridx = 0;
        GBC.gridy = 3;
        mainMenuPnl.add(mainMenuPotion(lbl.get(2),btn.get(2)),GBC);

        GBC.insets = new Insets(5,-97,25,5);
        GBC.gridx = 0;
        GBC.gridy = 4;
        mainMenuPnl.add(mainMenuPotion(lbl.get(3),btn.get(3)),GBC);


        mainMenuPnl.setBackground(RGBColor);
        add(mainMenuPnl);
    }

    // Set Main Menu Options
    private JPanel mainMenuPotion(JLabel lbl,JButton btn){
        JPanel pnl = new JPanel(new FlowLayout());
        lbl.setFont(new Font("",1,15));
        btn.setFont(new Font("",1,13));
        pnl.add(lbl);
        pnl.add(btn);
        pnl.setBackground(RGBColor);
        return pnl;
    }

    // Open Main Menu Option
    public void openMainMenuOption(int optionNumber){
        MOC.get(optionNumber-1).setVisible(true);
    }

}