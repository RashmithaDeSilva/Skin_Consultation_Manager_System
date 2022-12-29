package GUI_v2;

import Test.DragAndDropPanel;
import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;
import consoleSystem_v2.Patient;
import consoleSystem_v2.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Demo extends JFrame {
    public static void main(String[] args) throws IOException {

        WestminsterSkinConsultationManager w = new WestminsterSkinConsultationManager();
        LocalDate DOB = LocalDate.parse("2000-11-20");
        w.setDoctor(new Doctor("Aavindu","Ze silva",DOB,"+94769874188","S001","Super Doctor"));
        w.setDoctor(new Doctor("Bashmitha","Ge silva",DOB,"+94769874188","S002","Super Doctor"));
        w.setDoctor(new Doctor("Chamasha","Je silva",DOB,"+94769874188","S003","Super Doctor"));
        w.setDoctor(new Doctor("Dewindi","Qilva",DOB,"+94769874188","S004","Super Doctor"));
        w.setDoctor(new Doctor("Eellahandi","Ve silva",DOB,"+94769874188","S005","Super Doctor"));
        w.setDoctor(new Doctor("Fahiru","Qe silva",DOB,"+94769874188","S006","Super Doctor"));
        w.setDoctor(new Doctor("Gashmitha","Ae silva",DOB,"+94769874188","S007","Super Doctor"));
        w.setDoctor(new Doctor("Hhamasha","Be silva",DOB,"+94769874188","S008","Super Doctor"));
        w.setDoctor(new Doctor("Iewindi","Ce silva",DOB,"+94769874188","S009","Super Doctor"));
        w.setDoctor(new Doctor("Jellahandi","Me silva",DOB,"+94769874188","S010","Super Doctor"));


        Doctor doc = new Doctor("Ravindu","De silva",DOB,"+94769874188","S001","Super Doctor");
        Consultation con = new Consultation();
        con.setDate(DOB);
        con.setConsultationStartTime(LocalTime.parse("19:20"));
        con.setRequestedTime(5);

        //new MainMenuGUI(w).setVisible(true);
        new AddConsultationGUI(5,con,w).setVisible(true);

        //new Demo().drag();g
        //new DragAndDropPanel();


    }

    private void drag(){
        setSize(400,400);
        setTitle("kjfchnsd");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        //setResizable(false);
        setLayout(new FlowLayout());

        JLabel label = new JLabel();
        JButton button = new JButton("iidhihsis");

        button.addActionListener( (e) -> System.exit(0));


        add(label);
        add(button);
        setVisible(true);
    }


    private static int checkRandomlyAvailableDoctor(ArrayList<Doctor> doctors, LocalDate date, LocalTime time){

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

    private static boolean checkDoctorAvailability(Doctor doctor, LocalDate date, LocalTime time){
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
}
