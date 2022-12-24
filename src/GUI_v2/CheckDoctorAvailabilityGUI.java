package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;
import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CheckDoctorAvailabilityGUI extends MenuOptionControllerGUI {


    CheckDoctorAvailabilityGUI(SkinConsultationManager SCM, MenuOptionControllerGUI MOC){

        // Set Window
        setWindow(600,400,"Check Doctor Availability");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // EXIT_ON_CLOSE or 3

        // Set Consultation Menu Name
        CheckDoctorAvailabilityNamePnl = new JPanel(new FlowLayout());
        CheckDoctorAvailabilityNameLbl = new JLabel("Check Doctor Availability");
        CheckDoctorAvailabilityNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        CheckDoctorAvailabilityNamePnl.add(CheckDoctorAvailabilityNameLbl);
        add("North",CheckDoctorAvailabilityNamePnl);

        // Body Parts
        bodyPartPnl = new JPanel(new GridLayout(5,1));

            // Show Doctors Name And Select Doctor
        doctorsNamePnl = new JPanel(new FlowLayout());
        doctorNames = new String[SCM.getDoctors().size()+1];
        doctorNames[0] = "Select Doctor";
        for (int i=1;i<SCM.getDoctors().size()+1;i++) {
            doctorNames[i] = "["+i+"] "+SCM.getDoctor(i-1).getFullName();
        }
        selectDoctorCmBx = new JComboBox<>(doctorNames);
        doctorsNamePnl.add(selectDoctorCmBx);
        bodyPartPnl.add(doctorsNamePnl);

            // Consultation Date
        datePnl = new JPanel(new FlowLayout());
        dateLbl = new JLabel("Date  ");
        dateLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(dateLbl);

        yearLbl = new JLabel("Y");
        yearLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(yearLbl);
        yearTxt = new JTextField(5);
        yearTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(yearTxt);

        monthLbl = new JLabel("M");
        monthLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(monthLbl);
        monthTxt = new JTextField(3);
        monthTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(monthTxt);

        dayLbl = new JLabel("D");
        dayLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(dayLbl);
        dayTxt = new JTextField(3);
        dayTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(dayTxt);
        bodyPartPnl.add(datePnl);

            // Time
        timePnl = new JPanel(new FlowLayout());
        timeLbl = new JLabel("Time (24 Clock)   ");
        timeLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        timePnl.add(timeLbl);

        hoursLbl = new JLabel("H");
        hoursLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        timePnl.add(hoursLbl);
        hoursTxt = new JTextField(5);
        hoursTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        timePnl.add(hoursTxt);
        bodyPartPnl.add(timePnl);

            // Warning
        warningPnl = new JPanel(new FlowLayout());
        warningLbl = new JLabel("");
        warningLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        warningPnl.add(warningLbl);
        bodyPartPnl.add(warningPnl);

            // Back Button
        btnPnl = new JPanel(new FlowLayout());
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("SansSerif",Font.BOLD,14));
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This button again shows Consultation Window and hides this window

                setVisible(false);
                MOC.setVisible(true);
            }
        });
        btnPnl.add(backBtn);

            // Check Button
        checkBtn = new JButton("Check");
        checkBtn.setFont(new Font("SansSerif",Font.BOLD,14));
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LocalDate consultationDate;
                LocalTime consultationStartTime;
                boolean doctorAvailability;
                Consultation consultation;

                try {
                    // Select Doctor Validation
                    int selectDoctorNumber = 0;
                    selectDoctorNumber = selectDoctorCmBx.getSelectedIndex();
                        // If the doctor's checkBox output value is 0 it will show a warning message
                    if(selectDoctorNumber != 0){
                        warningLbl.setText("");

                        try {
                            warningLbl.setText("");

                            // Date Validation
                            // If the user will enter a single number this code line will set that number with 0
                            // Because LocalDate requests values like this (2022-12-24)
                            if (Integer.parseInt(monthTxt.getText()) < 10 || Integer.parseInt(dayTxt.getText()) < 10) {
                                monthTxt.setText((monthTxt.getText().length() != 2) ? "0"+monthTxt.getText() : monthTxt.getText());
                                dayTxt.setText((dayTxt.getText().length() != 2) ? "0"+dayTxt.getText() : dayTxt.getText());
                            }
                            // Get Today Date
                            Calendar cal = Calendar.getInstance();
                            Date today = cal.getTime();
                            // Get After One Year
                            cal.add(Calendar.YEAR, 1);
                            Date after_1_Year = cal.getTime();
                            // Checking user input date is between today and the after one year
                            SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd");
                            int tdy = Integer.parseInt(dateForm.format(today)),aftYear = Integer.parseInt(dateForm.format(after_1_Year));
                            int userInputDate = Integer.parseInt(yearTxt.getText()+monthTxt.getText()+dayTxt.getText());

                            if (tdy < userInputDate && aftYear > userInputDate){
                                warningLbl.setText("");
                                consultationDate = LocalDate.parse(yearTxt.getText()+"-"+monthTxt.getText()+"-"+dayTxt.getText());

                                try {
                                    warningLbl.setText("");

                                    // Time Validation
                                    // If the user will enter a single number this code line will set that number with 0
                                    // Because LocalTime requests values like this (09:12)
                                    if (Integer.parseInt(hoursTxt.getText()) < 10) {
                                        hoursTxt.setText((hoursTxt.getText().length() != 2) ? "0"+hoursTxt.getText() : hoursTxt.getText());
                                    }

                                    // All Doctors Are Available in 9am - 21pm Only
                                    if (Integer.parseInt(hoursTxt.getText()) >= 9 && Integer.parseInt(hoursTxt.getText()) <= 21) {
                                        warningLbl.setText("");
                                        consultationStartTime = LocalTime.parse(hoursTxt.getText()+":00");

                                        // Check This Doctor Is Available Or Not
                                        doctorAvailability = checkDoctorAvailability(SCM.getDoctor(selectDoctorNumber-1),
                                                                                        consultationDate,
                                                                                        consultationStartTime);

                                        // If This Doctor Is Available It Opens Add Consultation Form With Patient Details
                                        if(doctorAvailability){

                                            // Create New Consultation Object And Add Date And Time
                                            consultation = new Consultation();
                                            consultation.setDate(consultationDate);
                                            consultation.setConsultationStartTime(consultationStartTime);

                                            // Reset Check Doctor Availability Object(GUI)
                                            selectDoctorCmBx.setSelectedIndex(0);
                                            yearTxt.setText("");
                                            monthTxt.setText("");
                                            dayTxt.setText("");
                                            hoursTxt.setText("");

                                            // Pars That Consultation Object With Correct Doctor Object
                                            new AddConsultationGUI(SCM.getDoctor(selectDoctorNumber-1),consultation).setVisible(true);

                                        } else {
                                            // If This Doctor Is Not Available Programme Will Shows Alert Box
                                            // And It Ask Dou you Want To Continue With Another Doctor
                                            int alertBox = JOptionPane.showConfirmDialog(null,
                                                    "This Doctor Is Not Available\nOn This Date And Time\nDo You Want To Continue With Another Doctor?",
                                                    "Continue With Another Doctor", JOptionPane.YES_NO_OPTION);

                                            // If User Enter Yes It Wil Continue with Another Available Random Doctor
                                            if (alertBox == 0) {

                                                // Set Random Doctor
                                                int newDoctorPosition = checkRandomlyAvailableDoctor(SCM.getDoctors(),consultationDate,consultationStartTime);

                                                // But If All Doctors Are Available In This Time Programme Will Shows Another Alert Box
                                                if (newDoctorPosition != -1) { // If Another Doctor Is Available
                                                                                // Programme Continue With That New Doctor

                                                    // Create New Consultation Object And Add Date And Time
                                                    consultation = new Consultation();
                                                    consultation.setDate(consultationDate);
                                                    consultation.setConsultationStartTime(consultationStartTime);

                                                    // Reset Check Doctor Availability Object(GUI)
                                                    selectDoctorCmBx.setSelectedIndex(0);
                                                    yearTxt.setText("");
                                                    monthTxt.setText("");
                                                    dayTxt.setText("");
                                                    hoursTxt.setText("");

                                                    // Pars That Consultation Object With Correct Doctor Object
                                                    new AddConsultationGUI(SCM.getDoctor(newDoctorPosition),consultation).setVisible(true);

                                                } else { // And All Doctors Are Not Available
                                                        // After Show Alert Box Auto Reset Consultation Forme
                                                    JOptionPane.showConfirmDialog(null,
                                                            "All Doctors Are Not Available On This Date And Time!\nSelect Another Date And Time .....",
                                                            "Sorry!", JOptionPane.CLOSED_OPTION);
                                                    selectDoctorCmBx.setSelectedIndex(0);
                                                    yearTxt.setText("");
                                                    monthTxt.setText("");
                                                    dayTxt.setText("");
                                                    hoursTxt.setText("");
                                                }

                                            } else { // IF Alert Is No Add Consultation Form Will Reset
                                                selectDoctorCmBx.setSelectedIndex(0);
                                                yearTxt.setText("");
                                                monthTxt.setText("");
                                                dayTxt.setText("");
                                                hoursTxt.setText("");
                                            }
                                        }

                                    } else {
                                        warningLbl.setText("All Doctors Are Available In 9am - 9pm !");
                                    }

                                } catch (NumberFormatException ex){
                                    warningLbl.setText("Fill All Time Details Correctly !");
                                }

                            } else {
                                warningLbl.setText("Enter Date Between Today And After One Year !");
                            }

                        } catch (NumberFormatException ex){
                            warningLbl.setText("Fill All Date Details Correctly !");
                        }

                    } else {
                        warningLbl.setText("Select Doctor !");
                    }

                } catch (Exception ex){
                    warningLbl.setText("Fill All Details Correctly !");
                }

            }
        });
        btnPnl.add(checkBtn);
        bodyPartPnl.add(btnPnl);


        add("Center",bodyPartPnl);
    }


    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }
    private boolean checkDoctorAvailability(Doctor doctor, LocalDate date, LocalTime time){
        boolean check = true;
        for (int i=0;i<doctor.getConsultationsArrayList().size();i++) {
            if (doctor.getConsultation(i).getDate().equals(date)) {
                if (doctor.getConsultation(i).getConsultationStartTime().equals(time)) {
                    check = false;
                    break;
                }
            }
        }
        // True = Doctor Is Available
        // False = Doctor Is Not Available
        return check;
    }
    private int checkRandomlyAvailableDoctor(ArrayList<Doctor> doctors, LocalDate date, LocalTime time){

        int doctorRandomPosition =-1;
        int[] doctorAvailablePositionArray = new int[0];

        for (int i=0;i<doctors.size();i++) {
            if (checkDoctorAvailability(doctors.get(i),date,time)) {
                int[] temp = new int[doctorAvailablePositionArray.length+1];
                for (int j=0;j<doctorAvailablePositionArray.length;j++) {
                    temp[j] = doctorAvailablePositionArray[j];
                }
                temp[temp.length-1] = i;
                doctorAvailablePositionArray = temp;
            }
        }

        if(doctorAvailablePositionArray.length > 0){
            Random random = new Random();
            doctorRandomPosition = random.nextInt(doctorAvailablePositionArray.length);
        }

        return doctorRandomPosition;
    }


    private String optionNumber = "[1]";
    private String optionName = "Add Consultation";
    private JPanel CheckDoctorAvailabilityNamePnl;
    private JLabel CheckDoctorAvailabilityNameLbl;
    private JPanel bodyPartPnl;
    private JPanel doctorsNamePnl;
    private JButton backBtn;
    private JPanel btnPnl;
    private JPanel datePnl;
    private JLabel dateLbl;
    private JLabel yearLbl;
    private JTextField yearTxt;
    private JLabel monthLbl;
    private JTextField monthTxt;
    private JLabel dayLbl;
    private JTextField dayTxt;
    private JComboBox<String> selectDoctorCmBx;
    private String[] doctorNames;
    private JPanel timePnl;
    private JLabel timeLbl;
    private JLabel hoursLbl;
    private JTextField hoursTxt;
    private JPanel warningPnl;
    private JLabel warningLbl;
    private JButton checkBtn;

}