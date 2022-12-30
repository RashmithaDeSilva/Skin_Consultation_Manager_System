package consoleSystem_v2;

import java.io.File;
import java.time.LocalDate;


public class Patient extends Person {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String mobileNumber;
    private String patientID;
    private String skinEncryptImage;
    private String key;


    // Constructors
    public Patient(){
        //The compiler will add default values
    }
    public Patient(Patient patient){
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.dateOfBirth = patient.getDateOfBirth();
        this.mobileNumber = patient.getMobileNumber();
        this.patientID = patient.getPatientID();
    }
    public Patient(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String patientID){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.patientID = patientID;
    }
    public Patient(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String patientID, String skinEncryptImage, String key) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.patientID = patientID;
        this.skinEncryptImage = skinEncryptImage;
        this.key = key;
    }


    // Set Methods
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public void setSkinEncryptImage(String skinEncryptImage) {
        this.skinEncryptImage = skinEncryptImage;
    }
    public void setKey(String key) {
        this.key = key;
    }

    // Get Methods
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getPatientID() {
        return patientID;
    }
    public String getSkinEncryptImage() {
        return skinEncryptImage;
    }
    public String getKey() {
        return key;
    }
    public String getFullName() {
        return name+" "+surname;
    }

}
