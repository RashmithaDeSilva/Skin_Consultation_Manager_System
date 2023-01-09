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
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CheckDoctorAvailabilityGUI extends MenuOptionControllerGUI {

    private String optionNumber = "[1]";
    private String optionName = "Add Consultation";
    private JPanel hoursCountSldPnl,hoursCountPnl,timePnl,CheckDoctorAvailabilityNamePnl,bodyPartPnl,doctorsNamePnl,btnPnl,datePnl;
    private JLabel hoursCountLbl,hoursCountNameLbl,hoursLbl,timeLbl,dayLbl,monthLbl,yearLbl,CheckDoctorAvailabilityNameLbl,dateLbl;
    private JButton backBtn,checkBtn;
    private JTextField yearTxt,monthTxt,dayTxt,hoursTxt;
    private JComboBox<String> selectDoctorCmBx;
    private String[] doctorNames;
    private JSlider hoursCountSld;
    private Font font;


    // Constructor
    CheckDoctorAvailabilityGUI(SkinConsultationManager SCM, MenuOptionControllerGUI MOC){

        // Set Window
        setWindow(600,400,"Check Doctor Availability");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set Body
        GUIBody(SCM,MOC);
    }


    // Set Body
    public void GUIBody(SkinConsultationManager SCM, MenuOptionControllerGUI MOC){

        font = new Font("SansSerif",Font.BOLD,14);
        GridBagConstraints GBC = new GridBagConstraints();

        // Set Consultation Menu Name
        CheckDoctorAvailabilityNamePnl = new JPanel(new GridBagLayout());
        CheckDoctorAvailabilityNamePnl.setBackground(RGBColor);
        CheckDoctorAvailabilityNameLbl = new JLabel("Check Doctor Availability");
        CheckDoctorAvailabilityNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));

        GBC.insets = new Insets(15,5,15,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        CheckDoctorAvailabilityNamePnl.add(CheckDoctorAvailabilityNameLbl,GBC);
        add("North",CheckDoctorAvailabilityNamePnl);

        // Body Parts
        bodyPartPnl = new JPanel(new GridLayout(7,1));
        bodyPartPnl.setBackground(RGBColor);

        // Show Doctors Name And Select Doctor
        doctorsNamePnl = new JPanel(new FlowLayout());
        doctorsNamePnl.setBackground(RGBColor);
        doctorNames = new String[SCM.getDoctors().size()+1];
        doctorNames[0] = "Select Doctor";
        for (int i=1;i<SCM.getDoctors().size()+1;i++) {
            doctorNames[i] = "  ["+i+"] "+SCM.getDoctor(i-1).getFullName();
        }
        selectDoctorCmBx = new JComboBox<>(doctorNames);
        doctorsNamePnl.add(selectDoctorCmBx);
        bodyPartPnl.add(doctorsNamePnl);

        // Consultation Date
        datePnl = new JPanel(new FlowLayout());
        datePnl.setBackground(RGBColor);
        dateLbl = new JLabel("Date  ");
        dateLbl.setFont(font);
        datePnl.add(dateLbl);

        yearLbl = new JLabel("Y");
        yearLbl.setFont(font);
        datePnl.add(yearLbl);
        yearTxt = new JTextField(5);
        yearTxt.setFont(font);
        datePnl.add(yearTxt);

        monthLbl = new JLabel("M");
        monthLbl.setFont(font);
        datePnl.add(monthLbl);
        monthTxt = new JTextField(3);
        monthTxt.setFont(font);
        datePnl.add(monthTxt);

        dayLbl = new JLabel("D");
        dayLbl.setFont(font);
        datePnl.add(dayLbl);
        dayTxt = new JTextField(3);
        dayTxt.setFont(font);
        datePnl.add(dayTxt);
        bodyPartPnl.add(datePnl);

        // Time
        timePnl = new JPanel(new FlowLayout());
        timePnl.setBackground(RGBColor);
        timeLbl = new JLabel("Time (24 Clock)   ");
        timeLbl.setFont(font);
        timePnl.add(timeLbl);

        hoursLbl = new JLabel("H");
        hoursLbl.setFont(font);
        timePnl.add(hoursLbl);
        hoursTxt = new JTextField(5);
        hoursTxt.setFont(font);
        timePnl.add(hoursTxt);
        bodyPartPnl.add(timePnl);

        //Hours Count
        hoursCountPnl = new JPanel(new FlowLayout());
        hoursCountPnl.setBackground(RGBColor);
        hoursCountNameLbl = new JLabel("Select Hours You Want > ");
        hoursCountLbl = new JLabel("   1 Hours");
        hoursCountNameLbl.setFont(font);
        hoursCountLbl.setFont(font);
        hoursCountPnl.add(hoursCountNameLbl);
        hoursCountPnl.add(hoursCountLbl);
        bodyPartPnl.add(hoursCountPnl);

        hoursCountSldPnl = new JPanel(new FlowLayout());
        hoursCountSldPnl.setBackground(RGBColor);
        hoursCountSld = new JSlider(1,12,1);
        hoursCountSld.addChangeListener( (e) -> {
            hoursCountLbl.setText("   "+hoursCountSld.getValue()+" Hours");
            hoursCountLbl.setFont(font);
        });
        hoursCountSldPnl.add(hoursCountSld);
        bodyPartPnl.add(hoursCountSldPnl);

        // Back Button
        btnPnl = new JPanel(new FlowLayout());
        btnPnl.setBackground(RGBColor);
        backBtn = new JButton("Back");
        backBtn.setBackground(RGBColor2);
        backBtn.setForeground(RGBColor3);
        backBtn.setFont(font);
        backBtn.addActionListener( (e) -> {
            //This button again shows Consultation Window and hides this window
            MOC.setVisible(true);
            setVisible(false);
        });
        btnPnl.add(backBtn);

        // Check Button
        checkBtn = new JButton("Check");
        checkBtn.setBackground(RGBColor2);
        checkBtn.setForeground(RGBColor3);
        checkBtn.setFont(font);
        // Check Button validation And It On Action Event
        checkBtn.addActionListener( (e) -> checkBtnAddAction(SCM));
        btnPnl.add(checkBtn);
        bodyPartPnl.add(btnPnl);


        add("Center",bodyPartPnl);
    }

    // Check Button On Action Listener
    public void checkBtnAddAction(SkinConsultationManager SCM){
        Consultation consultation;
        LocalDate consultationDate;
        LocalTime consultationStartTime;
        LocalTime consultationEndTime;
        String endTime;
        int hoursCount;

        try {
            // Select Doctor Validation
            int selectDoctorNumber = selectDoctorCmBx.getSelectedIndex();
            // If the doctor's checkBox output value is 0 it will show a warning message
            if(selectDoctorNumber != 0){

                try {
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
                        consultationDate = LocalDate.parse(yearTxt.getText()+"-"+monthTxt.getText()+"-"+dayTxt.getText());

                        try {

                            // Time Validation
                            // If the user will enter a single number this code line will set that number with 0
                            // Because LocalTime requests values like this (09:12)
                            if (Integer.parseInt(hoursTxt.getText()) < 10) {
                                hoursTxt.setText((hoursTxt.getText().length() != 2) ? "0"+hoursTxt.getText() : hoursTxt.getText());
                            }

                            // All Doctors Are Available in 9am - 21pm Only
                            if (Integer.parseInt(hoursTxt.getText()) >= 9 && Integer.parseInt(hoursTxt.getText()) < 21) {

                                consultationStartTime = LocalTime.parse(hoursTxt.getText()+":00");

                                // Checking Hours Count Is Right Or Wrong
                                if (hoursCountSld.getValue() <= (21 - Integer.parseInt(hoursTxt.getText()))) {

                                    // Check This Doctor Is Available Or Not
                                    hoursCount = hoursCountSld.getValue();
                                    boolean doctorAvailability = checkDoctorAvailability(SCM.getDoctor(selectDoctorNumber-1),
                                            consultationDate,
                                            hoursTxt.getText(),hoursCount);

                                    // If This Doctor Is Available It Opens Add Consultation Form With Patient Details
                                    if (doctorAvailability) {

                                        // Create New Consultation Object And Add Date And Time
                                        consultation = new Consultation();
                                        consultation.setDate(consultationDate);
                                        consultation.setConsultationStartTime(consultationStartTime);
                                        endTime = String.valueOf(Integer.parseInt(hoursTxt.getText())+hoursCountSld.getValue());
                                        endTime = (endTime.length() != 2) ? "0"+endTime : endTime;
                                        consultationEndTime = LocalTime.parse(String.valueOf(endTime+":00"));
                                        consultation.setConsultationEndTime(consultationEndTime);
                                        consultation.setRequestedTime(hoursCountSld.getValue());

                                        // Reset Check Doctor Availability Object(GUI)
                                        selectDoctorCmBx.setSelectedIndex(0);
                                        yearTxt.setText("");
                                        monthTxt.setText("");
                                        dayTxt.setText("");
                                        hoursTxt.setText("");

                                        // Pars That Consultation Object With Correct Doctor Object
                                        new AddConsultationGUI((selectDoctorNumber-1),consultation,SCM).setVisible(true);

                                    } else {
                                        // If This Doctor Is Not Available Programme Will Shows Alert Box
                                        // And It Ask Dou you Want To Continue With Another Doctor
                                        int alertBox = JOptionPane.showConfirmDialog(null,
                                                "This Doctor Is Not Available\nOn This Date And Time\nDo You Want To Continue With Another Doctor?",
                                                "Continue With Another Doctor", JOptionPane.YES_NO_OPTION);

                                        // If User Enter Yes It Wil Continue with Another Available Random Doctor
                                        if (alertBox == 0) {

                                            // Set Random Doctor
                                            int newDoctorPosition = checkRandomlyAvailableDoctor(SCM.getDoctors(),consultationDate,hoursTxt.getText(),hoursCount);

                                            // But If All Doctors Are Available In This Time Programme Will Shows Another Alert Box
                                            if (newDoctorPosition != -1) { // If Another Doctor Is Available
                                                // Programme Continue With That New Doctor

                                                // Create New Consultation Object And Add Date And Time
                                                consultation = new Consultation();
                                                consultation.setDate(consultationDate);
                                                consultation.setConsultationStartTime(consultationStartTime);
                                                endTime = String.valueOf(Integer.parseInt(hoursTxt.getText())+hoursCountSld.getValue());
                                                endTime = (endTime.length() != 2) ? "0"+endTime : endTime;
                                                consultationEndTime = LocalTime.parse(String.valueOf(endTime+":00"));
                                                consultation.setConsultationEndTime(consultationEndTime);
                                                consultation.setRequestedTime(hoursCountSld.getValue());

                                                // Reset Check Doctor Availability Object(GUI)
                                                selectDoctorCmBx.setSelectedIndex(0);
                                                yearTxt.setText("");
                                                monthTxt.setText("");
                                                dayTxt.setText("");
                                                hoursTxt.setText("");

                                                // Pars That Consultation Object With Correct Doctor Object
                                                new AddConsultationGUI(newDoctorPosition,consultation,SCM).setVisible(true);

                                            } else { // And All Doctors Are Not Available
                                                // After Show Alert Box Auto Reset Consultation Forme
                                                JOptionPane.showConfirmDialog(null,
                                                        "All Doctors Are Not Available On This Date And Time!\nSelect Another Date And Time .....!",
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
                                    warningMassage("You Can Select Maximum Hour Count Is "+(21 - Integer.parseInt(hoursTxt.getText()))+" !","Warning");
                                }

                            } else {
                                warningMassage("All Doctors Are Available From 9am - 9pm !","Warning");
                            }

                        } catch (NumberFormatException ex){
                            warningMassage("Fill Time Details Correctly !","Warning");
                        }

                    } else {
                        warningMassage("Enter Date Between Today And After One Year !","Warning");
                    }

                } catch (NumberFormatException ex){
                    warningMassage("Fill All Date Details Correctly !","Warning");
                }

            } else {
                warningMassage("Select Doctor !","Warning");
            }

        } catch (Exception ex){
            warningMassage("Fill All Details Correctly !","Warning");
        }
    }

    // Check Doctor Availability
    private boolean checkDoctorAvailability(Doctor doctor, LocalDate date, String hoursTxt,int hoursCount){
        boolean check = true;
        LocalTime time = LocalTime.parse(hoursTxt+":00");
        for (int j=0;j<hoursCount;j++) {
            for (int i=0;i<doctor.getConsultationsArrayList().size();i++) {
                if (doctor.getConsultation(i).getDate().equals(date)) {
                    if (doctor.getConsultation(i).getConsultationStartTime().equals(time)) {
                        check = false;
                        j = hoursCount;
                        break;
                    }
                }
            }
            time = LocalTime.parse(String.valueOf(Integer.parseInt(hoursTxt)+1)+":00");
        }
        // True = Doctor Is Available
        // False = Doctor Is Not Available
        return check;
    }

    // Select And Check Randomly Available Doctor
    private int checkRandomlyAvailableDoctor(ArrayList<Doctor> doctors, LocalDate date, String hoursTxt,int hoursCount){

        int doctorRandomPosition =-1;
        int[] doctorAvailablePositionArray = new int[0];

        for (int i=0;i<doctors.size();i++) {
            if (checkDoctorAvailability(doctors.get(i),date,hoursTxt,hoursCount)) {
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


    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }

}