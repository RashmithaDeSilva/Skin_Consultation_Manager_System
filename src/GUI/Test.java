package GUI;

import consoleSystem_v2.Doctor;
import consoleSystem_v2.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);
        WestminsterSkinConsultationManager w = new WestminsterSkinConsultationManager();
        LocalDate DOB = LocalDate.parse("2000-11-20");
        doctors.add(new Doctor("Lahiru","De silva",DOB,"+94769874188","S001","Super Doctor"));
        doctors.add(new Doctor("Rashmitha","De silva",DOB,"+94769874188","S002","Super Doctor"));
        doctors.add(new Doctor("Thamasha","De silva",DOB,"+94769874188","S003","Super Doctor"));
        doctors.add(new Doctor("Dewindi","De silva",DOB,"+94769874188","S004","Super Doctor"));
        doctors.add(new Doctor("Sellahandi","De silva",DOB,"+94769874188","S005","Super Doctor"));
        doctors.add(new Doctor("Lahiru","De silva",DOB,"+94769874188","S006","Super Doctor"));
        doctors.add(new Doctor("Rashmitha","De silva",DOB,"+94769874188","S007","Super Doctor"));
        doctors.add(new Doctor("Thamasha","De silva",DOB,"+94769874188","S008","Super Doctor"));
        doctors.add(new Doctor("Dewindi","De silva",DOB,"+94769874188","S009","Super Doctor"));
        doctors.add(new Doctor("Sellahandi","De silva",DOB,"+94769874188","S010","Super Doctor"));

        new MainMenu(doctors,w).setVisible(true);

    }
}
