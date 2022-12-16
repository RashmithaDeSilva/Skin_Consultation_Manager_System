package consoleSystem_v1;

import java.time.LocalDate;

public class Patient extends Person{

    private String patientID;

    // Constructors
    public Patient(){
        //The compiler will add default values
    }
    public Patient(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String patientID){
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setMobileNumber(mobileNumber);
        this.patientID = patientID;
    }

    // Set Methods
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    // Get Methods
    public String getPatientID() {
        return patientID;
    }
}
