package consoleSystem_v2;

import java.time.LocalDate;
import java.time.LocalTime;


public class Consultation {

    private LocalDate date;
    private LocalTime consultationStartTime;
    private LocalTime consultationEndTime;
    private double cost;
    private String note;
    private Patient patient;


    // Constructors
    public Consultation(){
        //The compiler will add default values
    }
    public Consultation(LocalDate date, LocalTime consultationStartTime, LocalTime consultationEndTime, double cost, String note, Patient patient) {
        this.date = date;
        this.consultationStartTime = consultationStartTime;
        this.consultationEndTime = consultationEndTime;
        this.cost = cost;
        this.note = note;
        this.patient = patient;
    }


    // Set Methods
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setConsultationStartTime(LocalTime consultationStartTime) {
        this.consultationStartTime = consultationStartTime;
    }
    public void setConsultationEndTime(LocalTime consultationEndTime) {
        this.consultationEndTime = consultationEndTime;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    // Get Methods
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getConsultationStartTime() {
        return consultationStartTime;
    }
    public LocalTime getConsultationEndTime() {
        return consultationEndTime;
    }
    public double getCost() {
        return cost;
    }
    public String getNote() {
        return note;
    }
    public Patient getPatient() {
        return patient;
    }

}
