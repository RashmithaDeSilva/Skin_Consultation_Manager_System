package GUI_v1;

import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JFrame {

//    private JLabel mainMenuNameLbl = new JLabel();
//    private ArrayList<MenuOptionController> MOC = new ArrayList<>();
//    private ArrayList<JLabel> lbl = new ArrayList<>();
//    private ArrayList<JButton> btn = new ArrayList<>();
//
//
//    // Contractor
//    public MainMenu(SkinConsultationManager SCM){
//
//        // Set Window
//        setWindow(600,400,"Westminster Skin Consultation Manager");
//
//        // Set Main Menu Name
//        JPanel mainMenuNamePnl = new JPanel(new FlowLayout());
//        mainMenuNameLbl.setText("Westminster Skin Consultation Manager");
//        mainMenuNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
//        mainMenuNamePnl.add(mainMenuNameLbl);
//        add("North",mainMenuNamePnl);
//
//        // Menu Options
//        MOC.add(new ViewListOfDoctors(SCM,this));
//        MOC.add(new AddConsultation(SCM));
//        MOC.add(new CheckConsultations());
//        MOC.add(new Exit());
//        JPanel mainMenuOptionsPnl = new JPanel(new GridLayout(MOC.size(),1));
//        for(int i=0;i<MOC.size();i++){
//            for(int j=0;j<1;j++){
//                lbl.add(new JLabel(MOC.get(i).getOptionNumber()));
//                btn.add(new JButton(MOC.get(i).getOptionName()));
//            }
//            mainMenuOptionsPnl.add(mainMenuPotion(lbl.get(i),btn.get(i)));
//        }
//
//
//        // 1 - View List of Doctors -> (sort)
//        btn.get(0).addActionListener((e)->MOC.get(0).setVisible(true));
//
//        // 2 - Add Consultation -> (select doctor -> (check consultations, add consultation -> (add patient) ))
//        btn.get(1).addActionListener((e)->MOC.get(1).setVisible(true));
//
//        // 3 - Check Consultations -> (sort)
//
//
//        // 4 - Exit
//        btn.get(3).addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                for (int i=0;i<MOC.size();i++) {
//                    MOC.get(i).dispose();
//                }
//            }
//        });
//
//
//        add("Center",mainMenuOptionsPnl);
//    }
//
//    // Set Window
//    private void setWindow(int width, int height, String name){
//        setSize(width,height);
//        setTitle(name);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 3
//        setLocationRelativeTo(null);
//        setResizable(false);
//        setLayout(new BorderLayout());
//    }
//
//    // Set Main Menu Options
//    private JPanel mainMenuPotion(JLabel lbl,JButton btn){
//        JPanel pnl = new JPanel(new FlowLayout());
//        lbl.setFont(new Font("",1,15));
//        btn.setFont(new Font("",1,13));
//        pnl.add(lbl);
//        pnl.add(btn);
//        return pnl;
//    }
//
//    // Open Main Menu Option
//    public void openMainMenuOption(int optionNumber){
//        MOC.get(optionNumber-1).setVisible(true);
//    }
}
