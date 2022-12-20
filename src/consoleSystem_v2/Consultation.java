package consoleSystem_v2;

import java.time.LocalDate;
import java.time.LocalTime;


public class Consultation {

    private LocalDate date;
    private LocalTime time;
    private double cost;
    private String note;
    private Patient patient;


    // Constructors
    public Consultation(){
        //The compiler will add default values
    }
    public Consultation(LocalDate date, LocalTime time, double cost, String note, Patient patient) {
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.note = note;
        this.patient = patient;
    }


    // Set Methods
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
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
    public LocalTime getTime() {
        return time;
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
