package GUI_v2;

import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultationGUI extends MenuOptionControllerGUI {

    private String optionNumber = "[2]";
    private String optionName = "Consultation";
    private JLabel consultationMenuNameLbl;
    private JPanel consultationMenuNamePnl,consultationMenuOptionsPnl;
    private ArrayList<MenuOptionControllerGUI> MOC = new ArrayList<>();
    private ArrayList<JLabel> lbl = new ArrayList<>();
    private ArrayList<JButton> btn = new ArrayList<>();


    // Constructor
    ConsultationGUI(SkinConsultationManager SCM, MainMenuGUI mainMenu){

        // Set Window
        setWindow(600,400,"Consultation");

        // Set Body
        GUIBody(SCM,mainMenu);

    }


    // Set Body
    private void GUIBody(SkinConsultationManager SCM, MainMenuGUI mainMenu){

        GridBagConstraints GBC = new GridBagConstraints();

        // Set Consultation Menu Name
        consultationMenuNamePnl = new JPanel(new GridBagLayout());
        consultationMenuNamePnl.setBackground(RGBColor);
        consultationMenuNameLbl = new JLabel("Consultation");
        consultationMenuNameLbl.setFont(new Font("SansSerif",Font.BOLD,30));

        GBC.insets = new Insets(50,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        consultationMenuNamePnl.add(consultationMenuNameLbl,GBC);
        add("North",consultationMenuNamePnl);

        // Menu Options
        MOC.add(new CheckDoctorAvailabilityGUI(SCM,this));
        MOC.add(new CheckConsultationDetailsGUI(SCM,this));
        consultationMenuOptionsPnl = new JPanel(new GridBagLayout());
        consultationMenuOptionsPnl.setBackground(RGBColor);

        // Set Other Option Buttons, Labels And Events
        for(int i=0;i<MOC.size();i++){
            int count = i;
            lbl.add(new JLabel(MOC.get(i).getOptionNumber()));
            btn.add(new JButton(MOC.get(i).getOptionName()));
            btn.get(i).setBackground(RGBColor2);
            btn.get(i).setForeground(RGBColor3);
            btn.get(i).setFont(new Font("SansSerif",Font.BOLD,12));
            btn.get(i).addActionListener( (e) -> {
                MOC.get(count).setVisible(true);
                setVisible(false);
            });
        }

        // 3 - Back
        lbl.add(new JLabel("["+(lbl.size()+1)+"]"));
        btn.add(new JButton("Back"));
        btn.get(btn.size()-1).setBackground(RGBColor2);
        btn.get(btn.size()-1).setForeground(RGBColor3);
        btn.get(btn.size()-1).setFont(new Font("SansSerif",Font.BOLD,12));
        btn.get(btn.size()-1).addActionListener( (e) -> {
            //This button again shows Main Window and hides this window
            mainMenu.setVisible(true);
            setVisible(false);
            // All Visible False Object eligible for garbage collector
            for (MenuOptionControllerGUI menuOptionController : MOC) {
                menuOptionController.dispose();
            }
        });

        // Add All Buttons And Labels Into Panel
        GBC.insets = new Insets(5,-12,5,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        consultationMenuOptionsPnl.add(consultationMenuPotion(lbl.get(0),btn.get(0)),GBC);

        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 1;
        consultationMenuOptionsPnl.add(consultationMenuPotion(lbl.get(1),btn.get(1)),GBC);

        GBC.insets = new Insets(5,-98,5,5);
        GBC.gridx = 0;
        GBC.gridy = 2;
        consultationMenuOptionsPnl.add(consultationMenuPotion(lbl.get(2),btn.get(2)),GBC);

        add("Center",consultationMenuOptionsPnl);
    }

    // Set Main Menu Options
    private JPanel consultationMenuPotion(JLabel lbl,JButton btn){
        JPanel pnl = new JPanel(new FlowLayout());
        lbl.setFont(new Font("",1,15));
        btn.setFont(new Font("",1,14));
        pnl.add(lbl);
        pnl.add(btn);
        pnl.setBackground(RGBColor);
        return pnl;
    }


    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }

}
