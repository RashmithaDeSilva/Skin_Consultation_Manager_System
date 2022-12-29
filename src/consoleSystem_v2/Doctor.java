package consoleSystem_v2;

import java.time.LocalDate;
import java.util.ArrayList;


public class Doctor extends Person {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String mobileNumber;
    private String medicalLicenceNumber;
    private String specialisation;
    private ArrayList<Consultation> consultations = new ArrayList<>();


    // Constructors
    public Doctor(){
        //The compiler will add default values
    }
    public Doctor(String name, String surname, LocalDate dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialisation){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
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
    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    public void setConsultation(Consultation consultation) {
        this.consultations.add(consultation);
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
    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }
    public String getSpecialisation() {
        return specialisation;
    }
    public String getFullName(){
        return name+" "+surname;
    }
    public Consultation getConsultation(int position) {
        return consultations.get(position);
    }
    public ArrayList<Consultation> getConsultationsArrayList(){
        return consultations;
    }

}
