package GUI;

import consoleSystem_v2.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddConsultation extends MenuOptionController {
    private String  optionNumber = "[2]";
    private String optionName = "Add Consultation";
    private JLabel optionNameLbl;

    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }


    // Contractor
    AddConsultation(ArrayList<Doctor> doctors){
        // Create Doctors Full Name Buttons And Labels
        ArrayList<JButton> btns = new ArrayList<>();
        ArrayList<JLabel> lbls = new ArrayList<>();
        JPanel doctorsNameOptionPnl = new JPanel(new GridLayout(5,2));

        for(int i=0;i<doctors.size();i++){

            for(int j=0;j<1;j++){
                lbls.add(new JLabel("["+(i+1)+"]"));
                btns.add(new JButton("Dr "+doctors.get(i).getFullName()));
            }

            JPanel pnl = new JPanel(new FlowLayout());
            pnl.add(lbls.get(i));
            pnl.add(btns.get(i));

            if (doctors.size()/2 != 0) {
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
