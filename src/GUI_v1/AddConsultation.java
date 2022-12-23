package GUI_v1;

import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class AddConsultation extends MenuOptionController {
    private String  optionNumber = "[2]";
    private String optionName = "Add Consultation";
    private JLabel optionNameLbl;

    // Create Doctors Full Name Buttons And Labels
    private ArrayList<JButton> btns = new ArrayList<>();
    private ArrayList<JLabel> lbls = new ArrayList<>();

    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }


    // Contractor
    AddConsultation(SkinConsultationManager SCM){
        JPanel doctorsNameOptionPnl = new JPanel(new GridLayout(5,2));

        for(int i = 0; i< SCM.getDoctors().size(); i++){

            for(int j=0;j<1;j++){
                lbls.add(new JLabel("["+(i+1)+"]"));
                btns.add(new JButton("Dr " + SCM.getDoctors().get(i).getFullName()));
            }

            JPanel pnl = new JPanel(new FlowLayout());
            // Set All Doctor Name Buttons To AddConsultationForm (Anonymous Class)
            int doctorPotion = i;
            btns.get(i).addActionListener( (e) -> new AddConsultationForm(SCM,doctorPotion).setVisible(true));
            pnl.add(lbls.get(i));
            pnl.add(btns.get(i));

            if (SCM.getDoctors().size()/2 != 0) {
                doctorsNameOptionPnl.add(pnl);
            }else {
                doctorsNameOptionPnl.add(pnl);
            }
        }

        // Set Window
        setWindow(600,400,"Add Consultation");

        // Set Option Name
        JPanel optionNamePnl = new JPanel(new FlowLayout());
        optionNameLbl = new JLabel("Add Consultation");
        optionNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        optionNamePnl.add(optionNameLbl);
        add("North",optionNamePnl);


        add("Center",doctorsNameOptionPnl);
    }

}
