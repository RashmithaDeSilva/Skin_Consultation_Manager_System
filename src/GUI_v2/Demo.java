package GUI_v2;

import consoleSystem_v2.Doctor;
import consoleSystem_v2.WestminsterSkinConsultationManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
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

        new MainMenu(w).setVisible(true);

        //Random random = new Random();
        //int doctorPosition = random.nextInt(w.getDoctors().size());
        //System.out.println(doctorPosition);

        //System.out.println(checkDoctorAvailability(w.getDoctor(3),LocalDate.parse("2022-02-03"),LocalTime.parse("20:00")));
        //System.out.println(checkRandomlyAvailableDoctor(w.getDoctors(),LocalDate.parse("2022-02-03"),LocalTime.parse("20:00")));
    }


    private static int checkRandomlyAvailableDoctor(ArrayList<Doctor> doctors, LocalDate date, LocalTime time){
        System.out.println(doctors.size()+"\t"+String.valueOf(date)+"\t"+String.valueOf(time)); //

        Random random = new Random();
        int doctorPosition, count = 0;
        boolean loopBreak;
        int[] docPositions = new int[doctors.size()];

        // Set All Doctors Positions In to "docPositions" Int Array
        for (int i=0;i<docPositions.length;i++) {
            docPositions[i] = count++;
        }
        System.out.println(Arrays.toString(docPositions)); //

        // Randomly Select Available Doctor
        do {
            doctorPosition = random.nextInt(doctors.size());
            loopBreak = checkDoctorAvailability(doctors.get(doctorPosition),date,time);
            System.out.println(doctorPosition+"\t"+loopBreak); //
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
