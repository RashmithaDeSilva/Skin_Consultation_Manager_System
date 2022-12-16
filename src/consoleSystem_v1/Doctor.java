package consoleSystem_v1;

import java.time.LocalDate;

public class Doctor extends Person{

    private String medicalLicenceNumber;
    private String specialisation;

    // Constructors
    public Doctor(){
        //The compiler will add default values
    }
    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialisation){
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
        setMobileNumber(mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    // Set Methods
    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    // Get Methods
    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }
    public String getSpecialisation() {
        return specialisation;
    }
}
