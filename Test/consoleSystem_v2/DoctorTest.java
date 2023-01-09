package consoleSystem_v2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    Doctor doctor = new Doctor("Lahiru","De Silva", LocalDate.parse("2000-11-10"),"0987654321",
            "D001","Super Doctor"
    );

    // Set Methods
    @Test
    void setName() {
        doctor.setName("Kavindu");
        assertEquals("Kavindu",doctor.getName());
    }

    @Test
    void setSurname() {
        doctor.setSurname("Sumanathilake");
        assertEquals("Sumanathilake",doctor.getSurname());
    }

    @Test
    void setDateOfBirth() {
        doctor.setDateOfBirth(LocalDate.parse("2010-12-15"));
        assertEquals(LocalDate.parse("2010-12-15"),doctor.getDateOfBirth());
    }

    @Test
    void setMobileNumber() {
        doctor.setMobileNumber("091342387");
        assertEquals("091342387",doctor.getMobileNumber());
    }

    @Test
    void setMedicalLicenceNumber() {
        doctor.setMedicalLicenceNumber("D005");
        assertEquals("D005",doctor.getMedicalLicenceNumber());
    }

    @Test
    void setSpecialisation() {
        doctor.setSpecialisation("Skin Doctor");
        assertEquals("Skin Doctor",doctor.getSpecialisation());
    }

    @Test
    void setConsultation() {
        Consultation consultation = new Consultation();
        doctor.setConsultation(consultation);
        assertEquals(consultation,doctor.getConsultation(0));
    }


    // Get Methods
    @Test
    void getName() {
        assertEquals("Lahiru",doctor.getName());
    }

    @Test
    void getSurname() {
        assertEquals("De Silva",doctor.getSurname());
    }

    @Test
    void getDateOfBirth() {
        assertEquals(LocalDate.parse("2000-11-10"),doctor.getDateOfBirth());
    }

    @Test
    void getMobileNumber() {
        assertEquals("0987654321",doctor.getMobileNumber());
    }

    @Test
    void getMedicalLicenceNumber() {
        assertEquals("D001",doctor.getMedicalLicenceNumber());
    }

    @Test
    void getSpecialisation() {
        assertEquals("Super Doctor",doctor.getSpecialisation());
    }

    @Test
    void getFullName() {
        assertEquals("Lahiru De Silva",doctor.getFullName());
    }

    @Test
    void getConsultation() {
        Consultation consultation = new Consultation();
        doctor.setConsultation(consultation);
        assertEquals(consultation,doctor.getConsultation(0));
    }

    @Test
    void getConsultationsArrayList() {
        assertEquals(0,doctor.getConsultationsArrayList().size());
    }
}