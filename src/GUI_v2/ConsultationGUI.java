package GUI_v2;

import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultationGUI extends MenuOptionControllerGUI {

    // Constructor
    ConsultationGUI(SkinConsultationManager SCM, MainMenuGUI mainMenu){

        // Set Window
        setWindow(600,400,"Consultation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set Body
        GUIBody(SCM,mainMenu);

    }


    // Set Body
    private void GUIBody(SkinConsultationManager SCM, MainMenuGUI mainMenu){
        // Set Consultation Menu Name
        consultationMenuNamePnl = new JPanel(new FlowLayout());
        consultationMenuNameLbl = new JLabel("Consultation");
        consultationMenuNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        consultationMenuNamePnl.add(consultationMenuNameLbl);
        add("North",consultationMenuNamePnl);

        // Menu Options
        MOC.add(new CheckDoctorAvailabilityGUI(SCM,this));
        //MOC.add();
        consultationMenuOptionsPnl = new JPanel(new GridLayout(MOC.size()+1,1));

        // Set Other Option Buttons, Labels And Events
        for(int i=0;i<MOC.size();i++){
            int count = i;
            lbl.add(new JLabel(MOC.get(i).getOptionNumber()));
            btn.add(new JButton(MOC.get(i).getOptionName()));
            btn.get(i).addActionListener( (e) -> {
                MOC.get(count).setVisible(true);
                setVisible(false);
            });
        }


        // 3 - Back
        lbl.add(new JLabel("["+(lbl.size()+1)+"]"));
        btn.add(new JButton("Back"));
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
        for (int i=0;i<MOC.size()+1;i++) {
            consultationMenuOptionsPnl.add(consultationMenuPotion(lbl.get(i),btn.get(i)));
        }

        add("Center",consultationMenuOptionsPnl);
    }

    // Set Main Menu Options
    private JPanel consultationMenuPotion(JLabel lbl,JButton btn){
        JPanel pnl = new JPanel(new FlowLayout());
        lbl.setFont(new Font("",1,15));
        btn.setFont(new Font("",1,13));
        pnl.add(lbl);
        pnl.add(btn);
        return pnl;
    }


    private String optionNumber = "[2]";
    private String optionName = "Consultation";
    private JLabel consultationMenuNameLbl;
    private JPanel consultationMenuNamePnl;
    private JPanel consultationMenuOptionsPnl;
    private ArrayList<MenuOptionControllerGUI> MOC = new ArrayList<>();
    private ArrayList<JLabel> lbl = new ArrayList<>();
    private ArrayList<JButton> btn = new ArrayList<>();

    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }

}
