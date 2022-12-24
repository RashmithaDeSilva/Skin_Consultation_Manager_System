package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;
import consoleSystem_v2.WestminsterSkinConsultationManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        WestminsterSkinConsultationManager w = new WestminsterSkinConsultationManager();
        LocalDate DOB = LocalDate.parse("2000-11-20");
        w.setDoctor(new Doctor("Ravindu","De silva",DOB,"+94769874188","S001","Super Doctor"));
        w.setDoctor(new Doctor("Rashmitha","De silva",DOB,"+94769874188","S002","Super Doctor"));
        w.setDoctor(new Doctor("Thamasha","De silva",DOB,"+94769874188","S003","Super Doctor"));
        w.setDoctor(new Doctor("Dewindi","silva",DOB,"+94769874188","S004","Super Doctor"));
        w.setDoctor(new Doctor("Sellahandi","De silva",DOB,"+94769874188","S005","Super Doctor"));
        w.setDoctor(new Doctor("Lahiru","De silva",DOB,"+94769874188","S006","Super Doctor"));
        w.setDoctor(new Doctor("Rashmitha","De silva",DOB,"+94769874188","S007","Super Doctor"));
        w.setDoctor(new Doctor("Thamasha","De silva",DOB,"+94769874188","S008","Super Doctor"));
        w.setDoctor(new Doctor("Dewindi","De silva",DOB,"+94769874188","S009","Super Doctor"));
        w.setDoctor(new Doctor("Sellahandi","De silva",DOB,"+94769874188","S010","Super Doctor"));

        //new MainMenuGUI(w).setVisible(true);
        new AddConsultationGUI().setVisible(true);

        //Random random = new Random();
        //int doctorPosition = random.nextInt(1);
        //System.out.println(doctorPosition);

        //System.out.println(checkDoctorAvailability(w.getDoctor(3),LocalDate.parse("2022-02-03"),LocalTime.parse("20:00")));
        //System.out.println(checkRandomlyAvailableDoctor(w.getDoctors(),LocalDate.parse("2022-02-03"),LocalTime.parse("20:00")));
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
