package consoleSystem_v2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTest {

    Consultation consultation = new Consultation(LocalDate.parse("2000-11-10"), LocalTime.parse("14:00"),
            5,LocalTime.parse("19:00"),25.00,"Skin",new Patient()
    );

    // Set Methods
    @Test
    void setDate() {
        consultation.setDate(LocalDate.parse("2010-03-24"));
        assertEquals(LocalDate.parse("2010-03-24"),consultation.getDate());
    }

    @Test
    void setConsultationStartTime() {
        consultation.setConsultationStartTime(LocalTime.parse("20:00"));
        assertEquals(LocalTime.parse("20:00"),consultation.getConsultationStartTime());
    }

    @Test
    void setRequestedTime() {
        consultation.setRequestedTime(10);
        assertEquals(10,consultation.getRequestedTime());
    }

    @Test
    void setConsultationEndTime() {
        consultation.setConsultationEndTime(LocalTime.parse("12:00"));
        assertEquals(LocalTime.parse("12:00"),consultation.getConsultationEndTime());
    }

    @Test
    void setCost() {
        consultation.setCost(50.00);
        assertEquals(50.00,consultation.getCost());
    }

    @Test
    void setNote() {
        consultation.setNote("Skin Consultation");
        assertEquals("Skin Consultation",consultation.getNote());
    }

    @Test
    void setPatient() {
        Patient patient = new Patient();
        consultation.setPatient(patient);
        assertEquals(patient,consultation.getPatient());
    }


    // Get Methods
    @Test
    void getDate() {
        assertEquals(LocalDate.parse("2000-11-10"),consultation.getDate());
    }

    @Test
    void getConsultationStartTime() {
        assertEquals(LocalTime.parse("14:00"),consultation.getConsultationStartTime());
    }

    @Test
    void getRequestedTime() {
        assertEquals(5,consultation.getRequestedTime());
    }

    @Test
    void getConsultationEndTime() {
        assertEquals(LocalTime.parse("19:00"),consultation.getConsultationEndTime());
    }

    @Test
    void getCost() {
        assertEquals(25.00,consultation.getCost());
    }

    @Test
    void getNote() {
        assertEquals("Skin",consultation.getNote());
    }

    @Test
    void getPatient() {
        Patient patient = new Patient();
        consultation.setPatient(patient);
        assertEquals(patient,consultation.getPatient());
    }
}