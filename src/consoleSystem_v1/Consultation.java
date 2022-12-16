package consoleSystem_v1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consultation {
    private ArrayList<LocalDate> date = new ArrayList<LocalDate>(10);
    private ArrayList<LocalTime> time = new ArrayList<LocalTime>(10);
    private ArrayList<String> cost = new ArrayList<String>(10);
    private ArrayList<String> note = new ArrayList<String>(10);


    // Set Methods
    public void setDate(LocalDate date) {
        this.date.add(date);
    }
    public void setTime(LocalTime time) {
        this.time.add(time);
    }
    public void setCost(double cost) {
        this.cost.add(String.valueOf(cost));
    }
    public void setNote(String note) {
        this.note.add(note);
    }

    // Get Methods
    public LocalDate getDate(int position) {
        return date.get(position);
    }
    public LocalTime getTime(int position) {
        return time.get(position);
    }
    public double getCost(int position) {
        return Double.valueOf(this.cost.get(position));
    }
    public String getNote(int position) {
        return note.get(position);
    }

}
