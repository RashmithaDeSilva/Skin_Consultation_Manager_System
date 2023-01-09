package consoleSystem_v2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    Patient patient = new Patient(
            "Lahiru","De Silva", LocalDate.parse("2000-11-10"),"0987654321",
            "P001","ikjnfijsen3343b.jpg","ifhsdifdssdj"
    );

    // Set Methods
    @Test
    void setName() {
        patient.setName("Kavindu");
        assertEquals("Kavindu",patient.getName());
    }
    @Test
    void setSurname() {
        patient.setSurname("Kavindu");
        assertEquals("Kavindu",patient.getSurname());
    }

    @Test
    void setDateOfBirth() {
        patient.setDateOfBirth(LocalDate.parse("2010-09-06"));
        assertEquals(LocalDate.parse("2010-09-06"),patient.getDateOfBirth());
    }

    @Test
    void setMobileNumber() {
        patient.setMobileNumber("+94769123466");
        assertEquals("+94769123466",patient.getMobileNumber());
    }

    @Test
    void setPatientID() {
        patient.setPatientID("P005");
        assertEquals("P005",patient.getPatientID());
    }

    @Test
    void setSkinEncryptImage() {
        patient.setSkinEncryptImage("schsdicjjeoij344rf.jpg");
        assertEquals("schsdicjjeoij344rf.jpg",patient.getSkinEncryptImage());
    }

    @Test
    void setKey() {
        patient.setKey("suihasi234");
        assertEquals("suihasi234",patient.getKey());
    }


    // get Methods
    @Test
    void getName() {
        assertEquals("Lahiru",patient.getName());
    }

    @Test
    void getSurname() {
        assertEquals("De Silva",patient.getSurname());
    }

    @Test
    void getDateOfBirth() {
        assertEquals(LocalDate.parse("2000-11-10"),patient.getDateOfBirth());
    }

    @Test
    void getMobileNumber() {
        assertEquals("0987654321",patient.getMobileNumber());
    }

    @Test
    void getPatientID() {
        assertEquals("P001",patient.getPatientID());
    }

    @Test
    void getSkinEncryptImage() {
        assertEquals("ikjnfijsen3343b.jpg",patient.getSkinEncryptImage());
    }

    @Test
    void getKey() {
        assertEquals("ifhsdifdssdj",patient.getKey());
    }

    @Test
    void getFullName() {
        assertEquals("Lahiru De Silva",patient.getFullName());
    }
}