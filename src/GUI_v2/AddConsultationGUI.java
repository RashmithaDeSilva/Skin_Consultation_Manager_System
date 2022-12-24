package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;
import consoleSystem_v2.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddConsultationGUI extends MenuOptionControllerGUI {

    AddConsultationGUI(){
        // Set Window
        setWindow(600,580,"Add Consultation");

        // Set Main Menu Name
        addConsultationPnl = new JPanel(new FlowLayout());
        addConsultationLbl = new JLabel("Add Consultation");
        addConsultationLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        addConsultationPnl.add(addConsultationLbl);
        add("North",addConsultationPnl);

        // Main Body
        bodyPartPnl = new JPanel(new GridLayout(2,1));

            // Patient Details
        patientDetailsPnl = new JPanel(new GridLayout(3,1));
        patientDetailsPnl.setBorder(BorderFactory.createTitledBorder("Patient Details"));
        patientDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));

                // First name
        namePnl = new JPanel(new GridLayout(1,2));
        firstNamePnl = new JPanel(new FlowLayout());
        firstNameLbl = new JLabel("First Name");
        firstNameLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        firstNameTxt = new JTextField(6);
        firstNameTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        firstNamePnl.add(firstNameLbl);
        firstNamePnl.add(firstNameTxt);
        namePnl.add(firstNamePnl);

                // Surname
        surnamePnl = new JPanel(new FlowLayout());
        surnameLbl = new JLabel("Surname");
        surnameLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        surnameTxt = new JTextField(10);
        surnameTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxt);
        namePnl.add(surnamePnl);
        patientDetailsPnl.add(namePnl);

                // Date Of Birth
        dateOfBirthPnl = new JPanel(new GridLayout(1,4));
        dateOfBirthNamepnl = new JPanel(new FlowLayout());
        dateOfBirthLbl = new JLabel("Date Of Birth");
        dateOfBirthLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        dateOfBirthNamepnl.add(dateOfBirthLbl);
        dateOfBirthPnl.add(dateOfBirthNamepnl);

                    // Year
        yearPnl = new JPanel(new FlowLayout());
        yearLbl = new JLabel("Y");
        yearLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        yearPnl.add(yearLbl);
        yearTxt = new JTextField(5);
        yearTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        yearPnl.add(yearTxt);
        dateOfBirthPnl.add(yearPnl);
                    // Month
        monthPnl = new JPanel(new FlowLayout());
        monthLbl = new JLabel("M");
        monthLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        monthPnl.add(monthLbl);
        monthTxt = new JTextField(3);
        monthTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        monthPnl.add(monthTxt);
        dateOfBirthPnl.add(monthPnl);
                    // Date
        dayPnl = new JPanel(new FlowLayout());
        dayLbl = new JLabel("D");
        dayLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        dayPnl.add(dayLbl);
        dayTxt = new JTextField(3);
        dayTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        dayPnl.add(dayTxt);
        dateOfBirthPnl.add(dayPnl);
        patientDetailsPnl.add(dateOfBirthPnl);

                // Mobile Number
        mobiAndIDPnl = new JPanel(new GridLayout(1,2));
        mobileNumberPnl = new JPanel(new FlowLayout());
        mobileNumberLbl = new JLabel("Mobile Number");
        mobileNumberLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        mobileNumberPnl.add(mobileNumberLbl);
        mobileNumberTxt = new JTextField(8);
        mobileNumberTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        mobileNumberPnl.add(mobileNumberTxt);
        mobiAndIDPnl.add(mobileNumberPnl);

                // Patient ID
        patientIDPnl = new JPanel(new FlowLayout());
        patientIDLbl = new JLabel("Patient ID");
        patientIDLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        patientIDPnl.add(patientIDLbl);
        patientIDTxt = new JTextField(5);
        patientIDTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        patientIDPnl.add(patientIDTxt);
        mobiAndIDPnl.add(patientIDPnl);
        patientDetailsPnl.add(mobiAndIDPnl);
        bodyPartPnl.add(patientDetailsPnl);

            // Other Details
        otherPnl = new JPanel(new GridLayout(2,1));
        otherPnl.setBorder(BorderFactory.createTitledBorder("Other Details"));
        otherPnl.setFont(new Font("SansSerif",Font.BOLD,14));

                // Cost
        costAndNotyPnl = new JPanel(new GridLayout(1,2));
        costPnl = new JPanel(new FlowLayout());
        costLbl = new JLabel("Cost");
        costLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        costPnl.add(costLbl);
        costTxt = new JTextField(5);
        costTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        costPnl.add(costTxt);
        costAndNotyPnl.add(costPnl);
        notyPnl = new JPanel(new FlowLayout());
        notyLbl = new JLabel("               ");
        notyLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        notyPnl.add(notyLbl);
        costAndNotyPnl.add(notyPnl);
        otherPnl.add(costAndNotyPnl);

            // Submit Button
        btnPnl = new JPanel(new FlowLayout());
        submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("SansSerif",Font.BOLD,12));
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnPnl.add(submitBtn);


        bodyPartPnl.add(otherPnl);
        add("West",new JLabel("          "));
        add("Center",bodyPartPnl);
        add("East",new JLabel("          "));
        add("South",btnPnl);
    }
    AddConsultationGUI(Doctor doctor, Consultation consultation){
        // Set Window
        setWindow(600,580,"Add Consultation");

        // Set Main Menu Name
        addConsultationPnl = new JPanel(new FlowLayout());
        addConsultationLbl = new JLabel("Westminster Skin Consultation Manager");
        addConsultationLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        addConsultationPnl.add(addConsultationLbl);
        add("North",addConsultationPnl);

        // Main Body
        bodyPartPnl = new JPanel(new GridLayout(2,1));
            // Patient Details
        patientDetailsPnl = new JPanel(new FlowLayout());
        patientDetailsPnl.setBorder(BorderFactory.createTitledBorder("Patient Details"));
        patientDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));
                // First name
        namePnl = new JPanel(new GridLayout(1,2));
        firstNamePnl = new JPanel(new FlowLayout());
        firstNameLbl = new JLabel("First Name");
        firstNameLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        firstNameTxt = new JTextField(10);
        firstNameTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        firstNamePnl.add(firstNameLbl);
        firstNamePnl.add(firstNameTxt);
        namePnl.add(firstNamePnl);

        patientDetailsPnl.add(namePnl);

        bodyPartPnl.add(patientDetailsPnl);



        add("West",new JLabel("          "));
        add("Center",bodyPartPnl);
        add("East",new JLabel("          "));
    }


    @Override
    public String getOptionName() {
        return null;
    }
    @Override
    public String getOptionNumber() {
        return null;
    }


    private JPanel addConsultationPnl;
    private JLabel addConsultationLbl;
    private JPanel bodyPartPnl;
    private JPanel patientDetailsPnl;
    private JPanel namePnl;
    private JPanel firstNamePnl;
    private JLabel firstNameLbl;
    private JTextField firstNameTxt;
    private JPanel surnamePnl;
    private JLabel surnameLbl;
    private JTextField surnameTxt;
    private JPanel dateOfBirthPnl;
    private JLabel dateOfBirthLbl;
    private JLabel yearLbl;
    private JTextField yearTxt;
    private JLabel monthLbl;
    private JTextField monthTxt;
    private JLabel dayLbl;
    private JTextField dayTxt;
    private JPanel dateOfBirthNamepnl;
    private JPanel yearPnl;
    private JPanel monthPnl;
    private JPanel dayPnl;
    private JPanel mobileNumberPnl;
    private JLabel mobileNumberLbl;
    private JTextField mobileNumberTxt;
    private JPanel patientIDPnl;
    private JLabel patientIDLbl;
    private JTextField patientIDTxt;
    private JPanel mobiAndIDPnl;
    private JPanel otherPnl;
    private JPanel costAndNotyPnl;
    private JPanel costPnl;
    private JLabel costLbl;
    private JTextField costTxt;
    private JPanel notyPnl;
    private JLabel notyLbl;
    private JPanel btnPnl;
    private JButton submitBtn;


}
