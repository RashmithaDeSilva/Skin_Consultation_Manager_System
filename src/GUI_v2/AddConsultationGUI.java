package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;
import consoleSystem_v2.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddConsultationGUI extends MenuOptionControllerGUI {

    // Constructor
    AddConsultationGUI(Doctor doctor, Consultation consultation){
        // Set Window
        setWindow(600,500,"Add Consultation");

        // Set Body
        GUIBody(doctor,consultation);

    }


    // Set Body
    private void GUIBody(Doctor doctor, Consultation consultation){
        // Set Main Menu Name
        addConsultationPnl = new JPanel(new FlowLayout());
        addConsultationLbl = new JLabel("Add Consultation");
        addConsultationLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        addConsultationPnl.add(addConsultationLbl);
        add("North",addConsultationPnl);

        // Main Body
        bodyPartPnl = new JPanel(new FlowLayout());
        font = new Font("SansSerif",Font.BOLD,14);


        // Doctor Details
        doctorDetailsPnl = new JPanel(new GridBagLayout());
        doctorDetailsPnl.setBorder(BorderFactory.createTitledBorder("Doctor Details"));
        doctorDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));
        GBC = new GridBagConstraints();

        // Doctor Name
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        doctorNameLbl = new JLabel("Doctor Name >   "+doctor.getFullName());
        doctorNameLbl.setFont(font);
        doctorDetailsPnl.add(doctorNameLbl,GBC);
        GBC.insets = new Insets(5,20,5,20);
        GBC.gridx = 1;
        GBC.gridy = 0;
        doctorNameLbl = new JLabel("Requested Time >   "+String.valueOf(consultation.getRequestedTime()));
        doctorNameLbl.setFont(font);
        doctorDetailsPnl.add(doctorNameLbl,GBC);
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 1;
        consultationDateLbl = new JLabel("Consultation Date >   "+String.valueOf(consultation.getDate()));
        consultationDateLbl.setFont(font);
        doctorDetailsPnl.add(consultationDateLbl,GBC);
        GBC.insets = new Insets(5,20,5,20);
        GBC.gridx = 1;
        GBC.gridy = 1;
        consultationTimeLbl = new JLabel("Consultation Start Time >   "+String.valueOf(consultation.getConsultationStartTime()));
        consultationTimeLbl.setFont(font);
        doctorDetailsPnl.add(consultationTimeLbl,GBC);
        bodyPartPnl.add(doctorDetailsPnl);


        // Patient Details
        patientDetailsPnl = new JPanel(new GridBagLayout());
        patientDetailsPnl.setBorder(BorderFactory.createTitledBorder("Patient Details"));
        patientDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));

        // First name
        GBC.insets = new Insets(5,-55,5,0);
        GBC.gridx = 0;
        GBC.gridy = 0;
        firstNamePnl = new JPanel(new FlowLayout());
        firstNameLbl = new JLabel("First Name");
        firstNameLbl.setFont(font);
        firstNamePnl.add(firstNameLbl);
        firstNameTxt = new JTextField(6);
        firstNameTxt.setFont(font);
        firstNamePnl.add(firstNameTxt);
        patientDetailsPnl.add(firstNamePnl,GBC);

        // Surname
        GBC.insets = new Insets(5,-40,5,0);
        GBC.gridx = 1;
        GBC.gridy = 0;
        surnamePnl = new JPanel(new FlowLayout());
        surnameLbl = new JLabel("Surname");
        surnameLbl.setFont(font);
        surnamePnl.add(surnameLbl);
        surnameTxt = new JTextField(10);
        surnameTxt.setFont(font);
        surnamePnl.add(surnameTxt);
        patientDetailsPnl.add(surnamePnl,GBC);

        // Date Of Birth
        GBC.insets = new Insets(5,-120,5,0);
        GBC.gridx = 0;
        GBC.gridy = 1;
        dateOfBirthPnl = new JPanel(new FlowLayout());
        dateOfBirthLbl = new JLabel("Date Of Birth");
        dateOfBirthLbl.setFont(font);
        dateOfBirthPnl.add(dateOfBirthLbl);
        patientDetailsPnl.add(dateOfBirthPnl,GBC);

        // Year
        GBC.insets = new Insets(5,-280,5,0);
        GBC.gridx = 1;
        GBC.gridy = 1;
        yearPnl = new JPanel(new FlowLayout());
        yearLbl = new JLabel("Y");
        yearLbl.setFont(font);
        yearPnl.add(yearLbl);
        yearTxt = new JTextField(5);
        yearTxt.setFont(font);
        yearPnl.add(yearTxt);
        patientDetailsPnl.add(yearPnl,GBC);
        // Month
        GBC.insets = new Insets(5,-280,5,0);
        GBC.gridx = 2;
        GBC.gridy = 1;
        monthPnl = new JPanel(new FlowLayout());
        monthLbl = new JLabel("M");
        monthLbl.setFont(font);
        monthPnl.add(monthLbl);
        monthTxt = new JTextField(3);
        monthTxt.setFont(font);
        monthPnl.add(monthTxt);
        patientDetailsPnl.add(monthPnl,GBC);
        // Date
        GBC.insets = new Insets(5,-100,5,150);
        GBC.gridx = 3;
        GBC.gridy = 1;
        dayPnl = new JPanel(new FlowLayout());
        dayLbl = new JLabel("D");
        dayLbl.setFont(font);
        dayPnl.add(dayLbl);
        dayTxt = new JTextField(3);
        dayTxt.setFont(font);
        dayPnl.add(dayTxt);
        patientDetailsPnl.add(dayPnl,GBC);

        // Mobile Number
        GBC.insets = new Insets(5,3,5,0);
        GBC.gridx = 0;
        GBC.gridy = 2;
        mobileNumberPnl = new JPanel(new FlowLayout());
        mobileNumberLbl = new JLabel("Mobile Number");
        mobileNumberLbl.setFont(font);
        mobileNumberPnl.add(mobileNumberLbl);
        mobileNumberTxt = new JTextField(8);
        mobileNumberTxt.setFont(font);
        mobileNumberPnl.add(mobileNumberTxt);
        patientDetailsPnl.add(mobileNumberPnl,GBC);

        // Patient ID
        GBC.insets = new Insets(5,20,5,10);
        GBC.gridx = 1;
        GBC.gridy = 2;
        patientIDPnl = new JPanel(new FlowLayout());
        patientIDLbl = new JLabel("Patient ID");
        patientIDLbl.setFont(font);
        patientIDPnl.add(patientIDLbl);
        patientIDTxt = new JTextField(5);
        patientIDTxt.setFont(font);
        patientIDPnl.add(patientIDTxt);
        patientDetailsPnl.add(patientIDPnl,GBC);
        bodyPartPnl.add(patientDetailsPnl);

        // Other Details
        otherPnl = new JPanel(new GridBagLayout());
        otherPnl.setBorder(BorderFactory.createTitledBorder("Other Details"));
        otherPnl.setFont(new Font("SansSerif",Font.BOLD,14));

        // Cost
        GBC.insets = new Insets(5,5,5,0);
        GBC.gridx = 0;
        GBC.gridy = 0;
        costPnl = new JPanel(new FlowLayout());
        costLbl = new JLabel("Cost");
        costLbl.setFont(font);
        costPnl.add(costLbl);
        costTxt = new JTextField(5);
        costTxt.setFont(font);
        costPnl.add(costTxt);
        otherPnl.add(costPnl,GBC);
        // Cost Notification
        GBC.insets = new Insets(5,10,5,355);
        GBC.gridx = 1;
        GBC.gridy = 0;
        notyPnl = new JPanel(new FlowLayout());
        notyLbl = new JLabel("$15");
        notyLbl.setFont(font);
        notyPnl.add(notyLbl);
        otherPnl.add(notyPnl,GBC);
        bodyPartPnl.add(otherPnl);


        // Submit Button
        btnPnl = new JPanel(new FlowLayout());
        submitBtn = new JButton("Submit");
        submitBtn.setFont(font);
        submitBtn.addActionListener( event -> submitBtnAddAction(doctor,consultation));
        btnPnl.add(submitBtn);



        add("West",new JLabel("          "));
        add("Center",bodyPartPnl);
        add("East",new JLabel("          "));
        add("South",btnPnl);
    }

    // Submit Button Add Action Listener
    private void submitBtnAddAction(Doctor doctor, Consultation consultation){

    }


    @Override
    public String getOptionName() {
        return null;
    }
    @Override
    public String getOptionNumber() {
        return null;
    }

    private Font font;
    private JPanel addConsultationPnl;
    private JLabel addConsultationLbl;
    private JPanel bodyPartPnl;
    private JPanel patientDetailsPnl;
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
    private JPanel yearPnl;
    private JPanel monthPnl;
    private JPanel dayPnl;
    private JPanel mobileNumberPnl;
    private JLabel mobileNumberLbl;
    private JTextField mobileNumberTxt;
    private JPanel patientIDPnl;
    private JLabel patientIDLbl;
    private JTextField patientIDTxt;
    private JPanel otherPnl;
    private JPanel costPnl;
    private JLabel costLbl;
    private JTextField costTxt;
    private JPanel notyPnl;
    private JLabel notyLbl;
    private JPanel btnPnl;
    private JButton submitBtn;
    private JPanel doctorDetailsPnl;
    private JLabel doctorNameLbl;
    private JLabel consultationDateLbl;
    private JLabel consultationTimeLbl;
    private GridBagConstraints GBC;

}
