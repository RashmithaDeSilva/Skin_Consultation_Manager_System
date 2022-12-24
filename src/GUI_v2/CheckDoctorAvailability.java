package GUI_v2;

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

public class CheckDoctorAvailability extends MenuOptionController{


    CheckDoctorAvailability(SkinConsultationManager SCM,MenuOptionController MOC){

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
        warningLbl.setFont(new Font("SansSerif",Font.BOLD,14));
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

                                    if (Integer.parseInt(hoursTxt.getText()) >= 9 && Integer.parseInt(hoursTxt.getText()) <= 21) {
                                        warningLbl.setText("");
                                        consultationStartTime = LocalTime.parse(hoursTxt.getText()+":00");

                                        // Check This Doctor Is Available Or Not
                                        doctorAvailability = checkDoctorAvailability(SCM.getDoctor(selectDoctorNumber-1),
                                                                                        consultationDate,
                                                                                        consultationStartTime);
                                        if(doctorAvailability){
                                            int alertBox = JOptionPane.showConfirmDialog(null,
                                                    "This Doctor Is Not Available\nOn This Date And Time\nDo You Want To Continue With Another Doctor?",
                                                    "Continue With Another Doctor", JOptionPane.YES_NO_OPTION);

                                            if (alertBox == 0) { // IF Alert Is Yes

                                                int newDoctorPosition = checkRandomlyAvailableDoctor(SCM.getDoctors(),consultationDate,consultationStartTime);
                                                System.out.println(newDoctorPosition);
                                                if (newDoctorPosition != -1) {

                                                    //////////////////////

                                                } else {
                                                    JOptionPane.showConfirmDialog(null,
                                                            "All Doctors Are Not Available On This Date And Time!\nSelect Another Date And Time .....",
                                                            "Sorry!", JOptionPane.CLOSED_OPTION);
                                                    selectDoctorCmBx.setSelectedIndex(0);
                                                    yearTxt.setText("");
                                                    monthTxt.setText("");
                                                    dayTxt.setText("");
                                                    hoursTxt.setText("");
                                                }

                                            } else { // IF Alert Is No
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
        // True = Doctor Is Not Available
        // False = Doctor Is Available
        return check;
    }
    private int checkRandomlyAvailableDoctor(ArrayList<Doctor> doctors, LocalDate date, LocalTime time){
        Random random = new Random();
        int doctorPosition, count = 0;
        boolean loopBreak;
        int[] docPositions = new int[doctors.size()];

        // Set All Doctors Positions In to "docPositions" Int Array
        for (int i=0;i<docPositions.length;i++) {
            docPositions[i] = count++;
        }

        // Randomly Select Available Doctor
        do {
            doctorPosition = random.nextInt(doctors.size());
            loopBreak = checkDoctorAvailability(doctors.get(doctorPosition),date,time);
            for (int i = 0; true; i++) {
                // If Random Position Is Equal In Array Position It Will Set -1
                if(docPositions[i] == doctorPosition){
                    docPositions[i] = -1;
                    break;
                } else { // After Generate All Random Doctor Positions And If All Doctors Are Available It returns -1
                        // If All Doctors Are Not Available It returns -1
                    doctorPosition = -1;
                    loopBreak = false;
                    break;
                }
            }
        } while (loopBreak);

        return doctorPosition;
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