package consoleSystem_v2;

import java.time.LocalDate;

public class Patient extends Person {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String mobileNumber;
    private String patientID;


    // Constructors
    Patient(){
        //The compiler will add default values
    }
    Patient(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String patientID){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.patientID = patientID;
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

}
