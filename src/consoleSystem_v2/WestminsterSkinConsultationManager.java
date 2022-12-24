package consoleSystem_v2;

import GUI_v2.MainMenu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);
    private ArrayList<String> allPatientIDs = new ArrayList<>();


    public static void main(String[] args) {

        WestminsterSkinConsultationManager WSCM = new WestminsterSkinConsultationManager();
        boolean loopBreak = true;
        System.out.println("\n");

        do{
            int menuNumber = WSCM.mainMenu();
            switch (menuNumber){
                case -1:
                    break;
                case 1:
                    WSCM.addNewDoctor();
                    break;
                case 2:
                    WSCM.deleteDoctor();
                    break;
                case 3:
                    WSCM.printDoctorsList();
                    break;
                case 4:
                    WSCM.saveFile();
                    break;
                case 5:
                    WSCM.openGUI();
                    break;
                case 6:
                    System.exit(0);
                    loopBreak = false;
                    break;
                default:
                    System.out.println("Invalid Value .....!\n");
            }
        }while(loopBreak);
    }

    public int intInput(){
        Scanner user = new Scanner(System.in);
        int input = -1;
        try{
            input = user.nextInt();
        }catch (Exception e){
            System.out.println("Enter Integer Value .....!\n");
        }
        return input;
    }
    public String strInput(){
        Scanner user = new Scanner(System.in);
        return user.nextLine();
    }
    public void spase(){
        System.out.println("\n");
        for(int i=0;i<100;i++){
            System.out.print(">");
        }
        System.out.println("\n");
    }
    public int mainMenu(){
        System.out.println("\t\t>>>>> Westminster Skin Consultation Management System <<<<<\n");
        System.out.println("\t[1] Add New Doctor");
        System.out.println("\t[2] Delete Doctor");
        System.out.println("\t[3] Print The List Of Doctors");
        System.out.println("\t[4] Save File");
        System.out.println("\t[5] Open a Graphical User Interface (GUI)");
        System.out.println("\t[6] Exit");
        System.out.print("\nEnter Menu Number > ");
        return intInput();
    }

    // Menu Option Methods
    @Override
    public void addNewDoctor() {

        boolean docSize = doctors.size() != 10;

        if(docSize){

            spase();

            String name, surname, medicalLicenceNumber, specialisation, mobileNumber;
            boolean loopBreak = true;
            LocalDate DOB = LocalDate.parse("2000-11-20");

            System.out.println("\t\t\tAdd New Doctor\n");

            do{
                System.out.print("Enter Doctor Name > ");
                name = strInput().trim();
                loopBreak = name.equals("");
            }while(loopBreak);

            loopBreak = true;
            do{
                System.out.print("Enter Doctor Surname > ");
                surname = strInput().trim();
                loopBreak = name.equals("");
            }while(loopBreak);

            loopBreak = true;
            do{
                System.out.println("Enter Doctor Date of Birth > ");
                String year, month, date;

                System.out.print("\tYear > ");
                year = strInput();
                System.out.print("\tMonth > ");
                month = strInput();
                if(Integer.parseInt(month) < 10){
                    month = "0"+String.valueOf(Integer.valueOf(month));
                }
                System.out.print("\tDate > ");
                date = strInput();
                if(Integer.parseInt(date) < 10){
                    date = "0"+String.valueOf(Integer.valueOf(date));
                }

                try{
                    SimpleDateFormat dateForm = new SimpleDateFormat("yyyy");
                    Date today = new Date();
                    int befor_25Years = (Integer.parseInt(dateForm.format(today)))-(25);
                    int befor_60Years = (Integer.parseInt(dateForm.format(today)))-(60);

                    if(befor_25Years >= Integer.parseInt(year) && befor_60Years <= Integer.parseInt(year)){
                        loopBreak = false;
                        DOB = LocalDate.parse(year+"-"+month+"-"+date);
                    } else {
                        System.out.println("Age Cannot be Entered in this \nThe Doctor Should be Between 25-60 Years of Age .....!\n");
                    }

                }catch(Exception e){
                    System.out.println("Invalid Date .....!\n");
                }
            }while(loopBreak);

            loopBreak = true;
            do{
                System.out.print("Enter Doctor Mobile Number > ");
                mobileNumber = strInput();
                loopBreak = name.equals("");
            }while(loopBreak);

            loopBreak = true;
            do {
                System.out.print("Enter Doctor Medical Licence Number > ");
                medicalLicenceNumber = strInput().trim();

                loopBreak = doctors.size() != 0;
                for (Doctor doctor : doctors) {
                    if (doctor.getMedicalLicenceNumber().equals(medicalLicenceNumber)) {
                        System.out.println("This Medical Licence Number is already Entered .....!\n");
                        break;
                    } else {
                        loopBreak = false;
                    }
                }
            }while(loopBreak);

            loopBreak = true;
            do{
                System.out.print("Enter Doctor Specialisation > ");
                specialisation = strInput().trim();
                loopBreak = name.equals("");
            }while(loopBreak);

            doctors.add(new Doctor(name, surname, DOB, mobileNumber, medicalLicenceNumber, specialisation));
            spase();

        }else {
            spase();
            System.out.println("\nMaximum Limit is 10 .....!");
            spase();
        }
    }
    @Override
    public void deleteDoctor() {

        spase();
        System.out.println("\t\t\tDelete Doctor\n");
        boolean doctorCount = (doctors.size() == 0) ? false : true;
        if (doctorCount){
            System.out.print("Enter the Doctor Medical License Number to be Deleted > ");
            String medicalLicenceNumber = strInput();

            for(int i=0;i<doctors.size();i++){
                if(doctors.get(i).getMedicalLicenceNumber().equals(medicalLicenceNumber)){
                    System.out.println("\nDoctor Name > " + doctors.get(i).getName());
                    System.out.println("Doctor Surname > " + doctors.get(i).getSurname());
                    System.out.println("Doctor Date of Birth > " + doctors.get(i).getDateOfBirth());
                    System.out.println("Doctor Mobile Number > " + doctors.get(i).getMobileNumber());
                    System.out.println("Doctor Specialisation > " + doctors.get(i).getSpecialisation());

                    boolean loopBreak = true;
                    do{
                        System.out.print("\nDo You Want Delete this Doctor (Y/N) > ");
                        String ans = strInput();
                        if(ans.equalsIgnoreCase("Y")){
                            doctors.remove(i);
                            System.out.println("Successfully Deleted .....!");
                            loopBreak = false;
                        } else if (ans.equalsIgnoreCase("N")) {
                            loopBreak = false;
                        }
                    }while (loopBreak);
                    break;
                }else {
                    System.out.println("This Medical License Number is Incorrect .....!");
                    break;
                }
            }
        }else {
            System.out.println("Doctors are not Available .....!");
        }
        spase();
    }
    @Override
    public void printDoctorsList() {

        boolean loopBreak = (doctors.size() != 0) ? true : false;
        spase();
        System.out.println("\t\t\tPrint Doctors List\n");

        if(loopBreak){
            ArrayList<String> tempSurname = new ArrayList<>(doctors.size());
            ArrayList<Doctor> tempDoctors = new ArrayList<>(doctors.size());
            ArrayList<String> potions = new ArrayList<>(doctors.size());

            // Add Surnames in to temp array
            for(int i=0;i<doctors.size();i++){
                tempSurname.add(doctors.get(i).getSurname());
                tempDoctors.add(doctors.get(i));
            }

            // Sort Temp Array
            Collections.sort(tempSurname);
            for(int i=0;i<doctors.size();i++){
                for(int j=0;j<doctors.size();j++){
                    if(tempSurname.get(i).equals(tempDoctors.get(j).getSurname())){
                        potions.add(String.valueOf(j));
                    }
                }
            }

            // Print Doctor List
            System.out.println("\t+---------------+-----------+---------------------------+-------------------+-------------------+---------------------------+");
            System.out.println("\t|\tSurname\t\t|\tName\t|\tMedical Licence Number\t|\tMobile Number\t|\tDate Of Birth\t|\t\tSpecialisation\t\t|");
            System.out.println("\t+---------------+-----------+---------------------------+-------------------+-------------------+---------------------------+");

            for(int i=0;i<doctors.size();i++){
                System.out.printf("\t| %-14s| %-10s| %-26s| %-18s| %-18s| %-26s|\n",tempDoctors.get(Integer.valueOf(potions.get(i))).getSurname(),tempDoctors.get(Integer.valueOf(potions.get(i))).getName(),tempDoctors.get(Integer.valueOf(potions.get(i))).getMedicalLicenceNumber(),tempDoctors.get(Integer.valueOf(potions.get(i))).getMobileNumber(),tempDoctors.get(Integer.valueOf(potions.get(i))).getDateOfBirth(),tempDoctors.get(Integer.valueOf(potions.get(i))).getSpecialisation());
            }
            System.out.println("\t+---------------+-----------+---------------------------+-------------------+-------------------+---------------------------+");

        }else {
            System.out.println("Doctor List Is Empty .....!");
        }
        spase();
    }
    @Override
    public void saveFile() {

        // Create File
        try {
            BufferedWriter saveData = new BufferedWriter(new FileWriter("Save_Data.txt"));

        }catch (Exception e){
            System.out.println(e);
        }



    }
    @Override
    public void openGUI() {
        new MainMenu(this).setVisible(true);
    }


    // Other Methods
    @Override
    public void openGUIWithOption(int GUI_MenuOptionNumber){
        MainMenu mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);
        mainMenu.openMainMenuOption(GUI_MenuOptionNumber);
    }


    // Set Methods
    public void setDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }
    @Override
    public void setAllPatientID(String ID){
        this.allPatientIDs.add(ID);
    }

    // Get Methods
    @Override
    public Doctor getDoctor(int position) {
        return doctors.get(position);
    }
    @Override
    public ArrayList<Doctor> getDoctors(){
        return doctors;
    }
    @Override
    public String getAllPatientID(int position){
        return allPatientIDs.get(position);
    }
    @Override
    public ArrayList<String> getAllPatientIDs(){
        return allPatientIDs;
    }

}