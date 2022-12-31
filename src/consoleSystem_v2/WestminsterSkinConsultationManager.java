package consoleSystem_v2;

import GUI_v2.MainMenuGUI;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private final Validations validations = new Validations();
    private final String os = System.getProperty("os.name");


    public static void main(String[] args) {

        WestminsterSkinConsultationManager WSCM = new WestminsterSkinConsultationManager();
        WSCM.reloadData();

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
                default:
                    System.out.println("Invalid Value .....!\n");
            }
        }while(true);
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

        if(doctors.size() != 10){

            spase();

            String name, surname, medicalLicenceNumber, specialisation, mobileNumber;
            boolean loopBreak = true;
            LocalDate DOB = LocalDate.parse("2023-02-25");

            System.out.println("\t\t\tAdd New Doctor\n");

            do{
                System.out.print("Enter Doctor Name > ");
                name = strInput().trim();
                if (!validations.nameValidator(name,0)) {
                    System.out.println("Enter Correct Name .....!\n");
                }
            } while (!validations.nameValidator(name,0));

            do{
                System.out.print("Enter Doctor Surname > ");
                surname = strInput().trim();
                if (!validations.nameValidator(surname,0)) {
                    System.out.println("Enter Correct Name .....!\n");
                }
            } while (!validations.nameValidator(surname,0));

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

                loopBreak = !validations.ageValidatorForDoctor(year,month,date);
                if (!loopBreak){
                    DOB = LocalDate.parse(year+"-"+month+"-"+date);
                }

            }while(loopBreak);

            do{
                System.out.print("Enter Doctor Mobile Number > ");
                mobileNumber = strInput();
                if (!validations.mobileNumberValidator(mobileNumber)) {
                    System.out.println("Enter Correct Mobile Number .....!\n");
                }
            }while(!validations.mobileNumberValidator(mobileNumber));

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

            do{
                System.out.print("Enter Doctor Specialisation > ");
                specialisation = strInput().trim();
                if (!validations.nameValidator(specialisation,1)) {
                    System.out.println("Ente Specialisation Correctly .....!\n");
                }
            }while(!validations.nameValidator(specialisation,1));

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
        boolean doctorCount = doctors.size() != 0;
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

        // This Programme Work With only Windows And Mac Os
        File file;

        if (os.startsWith("Windows")) {
            file = new File(".\\src\\Data\\Data_File.txt");
            // If File Is Exists It Will Delete
            if (file.exists()) {
                file.delete();
            }

            // This Will Write All Object With The File Using Serializable Interface
            try (FileOutputStream fos = new FileOutputStream(".\\src\\Data\\Data_File.txt");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                // Write the object to the file
                oos.writeObject(doctors);
                oos.writeObject(patients);
            } catch (IOException e) {
                System.out.println(e);
            }

            System.out.println("Save Data Successfully");
            spase();

        } else if (os.startsWith("Mac")) {
            file = new File("./src/Data/Data_File.txt");
            // If File Is Exists It Will Delete
            if (file.exists()) {
                file.delete();
            }

            // This Will Write All Object With The File Using Serializable Interface
            try (FileOutputStream fos = new FileOutputStream("./src/Data/Data_File.txt");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                // Write the object to the file
                oos.writeObject(doctors);
                oos.writeObject(patients);
            } catch (IOException e) {
                System.out.println(e);
            }

            System.out.println("Save Data Successfully");
            spase();

        } else {
            System.out.println("This Programme Work With only Windows And Mac Os .....!");
            spase();
        }

    }
    @Override
    public void reloadData(){

        // This Programme Work With only Windows And Mac Os

        if (os.startsWith("Windows")) {
            File file = new File(".\\src\\Data\\Data_File.txt");
            if (file.exists()) {
                // Reload data
                try (FileInputStream fis = new FileInputStream(".\\src\\Data\\Data_File.txt");
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

                    // Read the two ArrayList objects from the file
                    doctors = (ArrayList<Doctor>) ois.readObject();
                    patients = (ArrayList<Patient>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e);
                }
                System.out.println("Reload Successful\n");
            } else {
                System.out.println("There Have No Data File .....!");
                spase();
            }

        } else if (os.startsWith("Mac")) {
            File file = new File("./src/Data/Data_File.txt");
            if (file.exists()) {
                // Reload data
                try (FileInputStream fis = new FileInputStream("./src/Data/Data_File.txt");
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

                    // Read the two ArrayList objects from the file
                    doctors = (ArrayList<Doctor>) ois.readObject();
                    patients = (ArrayList<Patient>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e);
                }
                System.out.println("Reload Successful\n");
            } else {
                System.out.println("There Have No Data File .....!");
                spase();
            }

        } else {
            System.out.println("This Programme Work With only Windows And Mac Os .....!");
            spase();
        }
    }
    @Override
    public void openGUI() {
        new MainMenuGUI(this).setVisible(true);
        spase();
    }


    // Other Methods
    @Override
    public void openGUIWithOption(int GUI_MenuOptionNumber){
        MainMenuGUI mainMenu = new MainMenuGUI(this);
        mainMenu.setVisible(true);
        mainMenu.openMainMenuOption(GUI_MenuOptionNumber);
    }


    // Set Methods
    public void setDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }
    @Override
    public void setPatient(Patient patient) {
        this.patients.add(patient);
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
    public ArrayList<Patient> getPatients() {
        return patients;
    }
    @Override
    public Patient getPatient(int position) {
        return patients.get(position);
    }
}