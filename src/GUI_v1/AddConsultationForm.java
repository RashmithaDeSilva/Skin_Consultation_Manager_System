package GUI_v1;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Patient;
import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class AddConsultationForm extends JFrame {

    private int hoursCount = 0;
    private int minitsCount = 0;
    private Patient patient;
    private Consultation consultation;
    private boolean checkID = true;


    // Contractor
    AddConsultationForm(SkinConsultationManager SCM,int doctorsArrayPosition){

        // Set Window
        setWindow(600,400,"Add Consultation Form");

        // Set Main Menu Name
        JPanel formPnl = new JPanel(new FlowLayout());
        JLabel formName = new JLabel();
        formName.setText("Add Consultation Form");
        formName.setFont(new Font("",1,25));
        formPnl.add(formName);
        add("North",formPnl);


        add("Center",consultationPart(SCM,doctorsArrayPosition));

    }

    // Set Window
    private void setWindow(int width, int height, String name){
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 3
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }
    private boolean checkDoctorAvailability(SkinConsultationManager SCM,int position,LocalDate date,LocalTime startTime,LocalTime endTime){
        boolean returnValue = true;

        for (int i=0;i<SCM.getDoctor(position).getConsultationsArrayList().size();i++) {

            if (SCM.getDoctor(position).getConsultation(i).getDate().equals(date)) {

                if (startTime.compareTo(SCM.getDoctor(position).getConsultation(i).getConsultationStartTime()) != 0) {

                    boolean consultationEndInsideInThisTimeStart = (startTime.compareTo(SCM.getDoctor(position).getConsultation(i).getConsultationEndTime()) < 0);
                    boolean consultationEndInsideBeforeThisTimeEnd = (endTime.compareTo(SCM.getDoctor(position).getConsultation(i).getConsultationEndTime()) > 0);

                    if (!(consultationEndInsideInThisTimeStart && consultationEndInsideBeforeThisTimeEnd)) {

                        boolean consultationStartInsideInThisTimeStart = (startTime.compareTo(SCM.getDoctor(position).getConsultation(i).getConsultationStartTime()) < 0);
                        boolean consultationStartBeforeThisTimeEnd = (endTime.compareTo(SCM.getDoctor(position).getConsultation(i).getConsultationStartTime()) > 0);

                        if (!(consultationStartInsideInThisTimeStart && consultationStartBeforeThisTimeEnd)) {

                            returnValue = true;

                        } else {
                            returnValue = false;
                        }

                    }else {
                        returnValue = false;
                    }

                } else {
                    returnValue = false;
                    break;
                }

            } else {
                returnValue = true;
            }

        }

        return returnValue;
    }
    private JPanel consultationPart(SkinConsultationManager SCM, int doctorsArrayPosition){
        // Get Date And Time
        JPanel dateAndTimePnl = new JPanel(new GridLayout(8,1));

        // Date Part
        JPanel datePnl = new JPanel(new FlowLayout());
        JLabel dateLbl = new JLabel("   Date");
        dateLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(dateLbl);

        JLabel yearLbl = new JLabel("Year");
        yearLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(yearLbl);
        JTextField yearTxt = new JTextField(5);
        yearTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(yearTxt);

        JLabel monthLbl = new JLabel("Month");
        monthLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(monthLbl);
        JTextField monthTxt = new JTextField(5);
        monthTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(monthTxt);

        JLabel dayLbl = new JLabel("Date");
        dayLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(dayLbl);
        JTextField dayTxt = new JTextField(5);
        dayTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(dayTxt);
        dateAndTimePnl.add(datePnl);

        // Time Part
        JPanel startTimePnl = new JPanel(new FlowLayout());

        JLabel startTimeLbl = new JLabel("   Time To Start");
        startTimeLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        startTimePnl.add(startTimeLbl);

        JLabel startHoursLbl = new JLabel("Hours");
        startHoursLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        startTimePnl.add(startHoursLbl);
        JTextField startHoursTxt = new JTextField(5);
        startHoursTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        startTimePnl.add(startHoursTxt);

        String[] minits = {" 00 ", " 15 ", " 30 ", " 45 "};
        JComboBox<String> selectMinutes1 = new JComboBox<>(minits);
        selectMinutes1.setFont(new Font("SansSerif",Font.BOLD,12));
        startTimePnl.add(selectMinutes1);
        dateAndTimePnl.add(startTimePnl);

        // Time Select Part
        JPanel timePnl = new JPanel(new FlowLayout());

        JLabel timeCountLbl = new JLabel("Enter Time You Want   Hours");
        timeCountLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        timePnl.add(timeCountLbl);
        JTextField timeCountTxt = new JTextField(3);
        timeCountTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        timePnl.add(timeCountTxt);

        JComboBox<String> selectMinutes2 = new JComboBox<>(minits);
        selectMinutes2.setFont(new Font("SansSerif",Font.BOLD,12));
        timePnl.add(selectMinutes2);
        dateAndTimePnl.add(timePnl);

        // Cost
        JPanel costPnl = new JPanel(new FlowLayout());
        JLabel costLbl = new JLabel("Cost :- ");
        costLbl.setFont(new Font("SansSerif",Font.BOLD,12));
        costLbl.setEnabled(false);
        costPnl.add(costLbl);
        dateAndTimePnl.add(costPnl);

        // Note
        JPanel notePnl= new JPanel(new GridLayout(1,3));
        notePnl.add(new JLabel(""));
        JTextArea noteTxtAr = new JTextArea();
        noteTxtAr.setFont(new Font("SansSerif",Font.BOLD,12));
        JScrollPane noteSP = new JScrollPane(noteTxtAr);
        noteSP.setBorder(BorderFactory.createTitledBorder("Note"));
        notePnl.add(noteSP);
        notePnl.add(new JLabel(""));
        dateAndTimePnl.add(notePnl);

        // Button And Warning Label Part
        JPanel btnPnl = new JPanel(new FlowLayout());
        JPanel warningPnl = new JPanel(new FlowLayout());
        JButton submitBtn = new JButton("Submit");
        JLabel warningLbl = new JLabel();
        warningLbl.setFont(new Font("SansSerif",Font.BOLD,16));
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                LocalDate consultationDate;
                LocalTime consultationStartTime;
                LocalTime consultationEndTime;

                try {
                    warningLbl.setText("");

                    // Check All Blank Are Fill Or Not
                    if (Integer.parseInt(monthTxt.getText()) < 10 || Integer.parseInt(dayTxt.getText()) < 10) {
                        monthTxt.setText((monthTxt.getText().length() != 2) ? "0"+monthTxt.getText() : monthTxt.getText());
                        dayTxt.setText((dayTxt.getText().length() != 2) ? "0"+dayTxt.getText() : dayTxt.getText());
                    }

                    int startHours = Integer.parseInt(startHoursTxt.getText());
                    int startMinits = 0;
                    startMinits = selectMinutes1.getSelectedIndex();
                    startMinits = (startMinits == 0) ? 0 : (startMinits == 1) ? 15 : (startMinits == 2) ? 30 : 45;
                    String startMnts = (startMinits == 0) ? "00" : String.valueOf(startMinits);

                    hoursCount = (0 <= Integer.parseInt(timeCountTxt.getText()) && 14 >= Integer.parseInt(timeCountTxt.getText())) ? Integer.parseInt(timeCountTxt.getText()) : -1;
                    hoursCount = (timeCountTxt.getText().equals("")) ? 0 : hoursCount;
                    minitsCount = selectMinutes2.getSelectedIndex();
                    minitsCount = (minitsCount == 0) ? 0 : (minitsCount == 1) ? 15 : (minitsCount == 2) ? 30 : 45;
                    String mnts = (minitsCount == 0) ? "00" : String.valueOf(minitsCount);

                    try {
                        warningLbl.setText("");

                        consultationDate = LocalDate.parse(yearTxt.getText()+"-"+monthTxt.getText()+"-"+dayTxt.getText());
                        SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMdd");

                        // Get Today Date
                        Calendar cal = Calendar.getInstance();
                        Date today = cal.getTime();

                        // Get After One Year
                        cal.add(Calendar.YEAR, 1);
                        Date after_1_Year = cal.getTime();

                        int tdy = Integer.parseInt(dateForm.format(today)),aftYear = Integer.parseInt(dateForm.format(after_1_Year));
                        int userInputDate = Integer.parseInt(yearTxt.getText()+monthTxt.getText()+dayTxt.getText());

                        if (tdy < userInputDate && aftYear > userInputDate) {
                            warningLbl.setText("");

                            try {
                                warningLbl.setText("");

                                if (Integer.parseInt(startHoursTxt.getText()) < 10) {
                                    startHoursTxt.setText((startHoursTxt.getText().length() != 2) ? "0"+startHoursTxt.getText() : startHoursTxt.getText());
                                }
                                consultationStartTime = LocalTime.parse(startHoursTxt.getText()+":"+startMnts);

                                if (startHours >= 9 && startHours < 23) {
                                    warningLbl.setText("");

                                    int hours = startHours + hoursCount, minits = startMinits +minitsCount;
                                    hours += minits / 60;
                                    minits = minits % 60;
                                    boolean timeValidate1 = (hours <= 23 && hours >= 9), timeValidate2 = !(hours == 23 && minits != 0);//? false : true;

                                    if ((hoursCount != -1) && (hoursCount + minitsCount != 0) && timeValidate1 && timeValidate2 ) {
                                        warningLbl.setText("");

                                        if (hours < 10) {
                                            consultationEndTime = LocalTime.parse("0"+String.valueOf(hours)+":"+mnts);
                                        } else {
                                            consultationEndTime = LocalTime.parse(String.valueOf(hours)+":"+mnts);
                                        }
                                        boolean doctorAvailability = checkDoctorAvailability(SCM,doctorsArrayPosition,consultationDate,consultationStartTime,consultationEndTime);

                                        if (doctorAvailability) {

                                            setVisible(false);
                                            remove(dateAndTimePnl);
                                            add("Center",patientParts(SCM));
                                            setVisible(true);
                                            //consultation = new Consultation(consultationDate,consultationStartTime,consultationEndTime,);

                                            //SCM.getDoctor(doctorsArrayPosition).setConsultation();

                                        }else {
                                            // set another doctor
                                        }

                                    } else {
                                        warningLbl.setText("     This Time Period Is Invalided !");
                                    }

                                } else {
                                    warningLbl.setText("     All Doctors Are Available In 9am - 11pm !");
                                }

                            } catch (Exception ex) {
                                warningLbl.setText("     This Time Is Invalided !");
                            }

                        } else {
                            warningLbl.setText("    Enter Date Between Today And After One Year !");
                        }

                    } catch (Exception ex) {
                        warningLbl.setText("    This Date Is Invalided !");
                    }

                } catch (Exception ex) {
                    warningLbl.setText("    Fill All Details Correctly !");
                }

            }
        });
        btnPnl.add(submitBtn);
        warningPnl.add(warningLbl);
        dateAndTimePnl.add(btnPnl);
        dateAndTimePnl.add(warningPnl);


        return dateAndTimePnl;
    }
    private JPanel patientParts(SkinConsultationManager SCM){

        JPanel patientDetailsPnl = new JPanel(new GridLayout(7,1));

        // Name
        JPanel namePnl = new JPanel(new FlowLayout());
        JLabel nameLbl = new JLabel("Name");
        nameLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        namePnl.add(nameLbl);
        JTextField nameTxt = new JTextField(7);
        nameTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        namePnl.add(nameTxt);
        patientDetailsPnl.add(namePnl);

        // Surname
        JPanel surnamePnl = new JPanel(new FlowLayout());
        JLabel surnameLbl = new JLabel("Surame");
        surnameLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        surnamePnl.add(surnameLbl);
        JTextField surnameTxt = new JTextField(10);
        surnameTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        surnamePnl.add(surnameTxt);
        patientDetailsPnl.add(surnamePnl);

        // Date of Birth
        JPanel dateOfBirthPnl = new JPanel(new FlowLayout());
        JLabel dateOfBirthLbl = new JLabel("Date of Birth    Year");
        dateOfBirthLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        dateOfBirthPnl.add(dateOfBirthLbl);
        // Year
        JTextField dateOfBirthYearTxt = new JTextField(5);
        dateOfBirthYearTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        dateOfBirthPnl.add(dateOfBirthYearTxt);
        // Month
        JLabel dateOfBirthMonthLbl = new JLabel("Month");
        dateOfBirthMonthLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        dateOfBirthPnl.add(dateOfBirthMonthLbl);
        JTextField dateOfBirthMonthTxt = new JTextField(3);
        dateOfBirthMonthTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        dateOfBirthPnl.add(dateOfBirthMonthTxt);
        // Day
        JLabel dateOfBirthDayLbl = new JLabel("Day");
        dateOfBirthDayLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        dateOfBirthPnl.add(dateOfBirthDayLbl);
        TextField dateOfBirthDayTxt = new TextField(3);
        dateOfBirthDayTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        dateOfBirthPnl.add(dateOfBirthDayTxt);
        patientDetailsPnl.add(dateOfBirthPnl);

        // Mobile Number
        JPanel mobileNumberPnl = new JPanel(new FlowLayout());
        JLabel mobileNumberLbl = new JLabel("Mobile Number");
        mobileNumberLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        mobileNumberPnl.add(mobileNumberLbl);
        JTextField mobileNumberTxt = new JTextField(10);
        mobileNumberTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        mobileNumberPnl.add(mobileNumberTxt);
        patientDetailsPnl.add(mobileNumberPnl);

        // Patient ID
        JPanel IDPnl = new JPanel(new FlowLayout());
        JLabel IDLbl = new JLabel("Patient ID");
        IDLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        IDPnl.add(IDLbl);
        JTextField IDTxt = new JTextField(5);
        IDTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        IDPnl.add(IDTxt);
        patientDetailsPnl.add(IDPnl);

        // Submit Button And Warning Label
        JPanel btnPnl = new JPanel(new FlowLayout());
        JPanel warningPnl = new JPanel(new FlowLayout());

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("SansSerif",Font.BOLD,14));

        JLabel warningLbl = new JLabel();
        warningLbl.setFont(new Font("SansSerif",Font.BOLD,16));
        warningPnl.add(warningLbl);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat dateForm = new SimpleDateFormat("yyyy");
                    Date today = new Date();
                    int  thisYear = Integer.parseInt(dateForm.format(today));
                    if (Integer.parseInt(dateOfBirthMonthTxt.getText()) < 10 || Integer.parseInt(dateOfBirthDayTxt.getText()) < 10) {
                        dateOfBirthMonthTxt.setText((dateOfBirthMonthTxt.getText().length() != 2) ? "0"+dateOfBirthMonthTxt.getText() : dateOfBirthMonthTxt.getText());
                        dateOfBirthDayTxt.setText((dateOfBirthDayTxt.getText().length() != 2) ? "0"+dateOfBirthDayTxt.getText() : dateOfBirthDayTxt.getText());
                    }
                    // Name Validation
                    boolean nameValidate = (!(nameTxt.getText().equals("")) && !(surnameTxt.getText().equals("")));
                    // Date Validation
                    boolean dateValidate = ((thisYear >= Integer.parseInt(dateOfBirthYearTxt.getText())) &&
                                            ((thisYear+100) >= Integer.parseInt(dateOfBirthYearTxt.getText())) &&
                                            (Integer.parseInt(dateOfBirthMonthTxt.getText()) <= 12) &&
                                            (Integer.parseInt(dateOfBirthMonthTxt.getText()) > 0) &&
                                            (Integer.parseInt(dateOfBirthDayTxt.getText()) <= 12) &&
                                            (Integer.parseInt(dateOfBirthDayTxt.getText()) > 0));
                    // Mobile Number Validation
                    boolean mobileValidate = (mobileNumberTxt.getText().length() <= 12);
                    // Patient ID Validation
                    boolean IDValidate = !IDTxt.getText().equals("");

                    if (nameValidate) {
                        warningLbl.setText("");

                        if (dateValidate) {
                            warningLbl.setText("");

                            // Set Date Of Birth
                            LocalDate date = LocalDate.parse(dateOfBirthYearTxt.getText()+"-"+dateOfBirthMonthTxt.getText()+"-"+dateOfBirthDayTxt.getText());

                            if (mobileValidate) {
                                warningLbl.setText("");

                                if (IDValidate) {
                                    warningLbl.setText("");

                                    for (int i=0;i<SCM.getAllPatientIDs().size();i++) {
                                        if (SCM.getAllPatientID(i).equals(IDTxt.getText())) {
                                            checkID = false;
                                            warningLbl.setText("    This ID Already Entered !");
                                            break;
                                        }
                                    }

                                    if (checkID) {
                                        warningLbl.setText("");
                                        patient = new Patient(nameTxt.getText(),surnameTxt.getText(),date,mobileNumberTxt.getText(),IDTxt.getText());
                                    }

                                } else {
                                    warningLbl.setText("    Enter ID !");
                                }

                            } else {
                                warningLbl.setText("    This Mobile Number Is Incorrect !");
                            }

                        }else {
                            warningLbl.setText("    Enter Between This Year Or Hundred Back !");
                        }

                    }

                }catch (Exception ex) {
                    warningLbl.setText("    Fill All Details Correctly !");
                }

            }
        });
        btnPnl.add(submitBtn);
        patientDetailsPnl.add(btnPnl);
        patientDetailsPnl.add(warningPnl);


        return patientDetailsPnl;
    }
}
