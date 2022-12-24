package GUI_v2;


import consoleSystem_v2.SkinConsultationManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MainMenu extends JFrame {

    // Contractor
    public MainMenu(SkinConsultationManager SCM){

        // Set Window
        setWindow(600,400,"Westminster Skin Consultation Manager");

        // Set Main Menu Name
        mainMenuNamePnl = new JPanel(new FlowLayout());
        mainMenuNameLbl = new JLabel("Westminster Skin Consultation Manager");
        mainMenuNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        mainMenuNamePnl.add(mainMenuNameLbl);
        add("North",mainMenuNamePnl);

        // Menu Options
        MOC.add(new ViewListOfDoctors(SCM,this)); // 1 - View List of Doctors
        MOC.add(new Consultation(SCM,this)); // 2 - Consultation
        mainMenuOptionsPnl = new JPanel(new GridLayout(MOC.size()+2,1));

        // Set Other Option Buttons, Labels And Events
        for(int i=0;i<MOC.size();i++){
            int count = i;
            lbl.add(new JLabel(MOC.get(i).getOptionNumber()));
            btn.add(new JButton(MOC.get(i).getOptionName()));
            btn.get(i).addActionListener( (e) -> MOC.get(count).setVisible(true));
        }

        // 2 - Consultation
        btn.get(1).addActionListener( (e) -> setVisible(false));

        // 3 - Refresh
        lbl.add(new JLabel("["+(lbl.size()+1)+"]"));
        btn.add(new JButton("Refresh"));
        btn.get(btn.size()-1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                    This refresh button close all menu option windows and it closes itself also
                    here I use dispose() method in that work
                    because I want to kill all objects and open this object again
                    with WestminsterSkinConsultationManager Object
                    then this new MainMenu object is updated with a new doctor ArrayList
                 */
                for (MenuOptionController menuOptionController : MOC) {
                    menuOptionController.dispose();
                }
                dispose();
                SCM.openGUI();
            }
        });

        // 4 - Exit
        lbl.add(new JLabel("["+(lbl.size()+1)+"]"));
        btn.add(new JButton("Exit"));
        btn.get(btn.size()-1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                    This exit button is close all windows
                */
                for (MenuOptionController menuOptionController : MOC) {
                    menuOptionController.dispose();
                }
                dispose();
            }
        });

        // Add All Buttons And Labels Into Panel
        for (int i=0;i<MOC.size()+2;i++) {
            mainMenuOptionsPnl.add(mainMenuPotion(lbl.get(i),btn.get(i)));
        }


        add("Center",mainMenuOptionsPnl);
    }


    // Set Window
    private void setWindow(int width, int height, String name){
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // EXIT_ON_CLOSE or 3
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    // Set Main Menu Options
    private JPanel mainMenuPotion(JLabel lbl,JButton btn){
        JPanel pnl = new JPanel(new FlowLayout());
        lbl.setFont(new Font("",1,15));
        btn.setFont(new Font("",1,13));
        pnl.add(lbl);
        pnl.add(btn);
        return pnl;
    }

    // Open Main Menu Option
    public void openMainMenuOption(int optionNumber){
        MOC.get(optionNumber-1).setVisible(true);
    }


    private JLabel mainMenuNameLbl;
    private JPanel mainMenuNamePnl;
    private JPanel mainMenuOptionsPnl;
    private ArrayList<MenuOptionController> MOC = new ArrayList<>();
    private ArrayList<JLabel> lbl = new ArrayList<>();
    private ArrayList<JButton> btn = new ArrayList<>();

}