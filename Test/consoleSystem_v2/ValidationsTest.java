package consoleSystem_v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {

    Validations validations = new Validations();

    @Test
    void nameValidator_0() {
        assertTrue(validations.nameValidator("Kavindu", 0));
    }
    @Test
    void nameValidator_1() {
        assertTrue(validations.nameValidator("Lahiru", 1));
    }

    @Test
    void mobileNumberValidator() {
        assertTrue(validations.mobileNumberValidator("0987654321"));
    }

    @Test
    void validateID() {
        assertTrue(validations.validateID("S001"));
    }

    @Test
    void ageValidatorForDoctor() {
        assertTrue(validations.ageValidatorForDoctor("1995","04","25"));
    }

    @Test
    void ageValidatorForPatient() {
        assertTrue(validations.ageValidatorForPatient("2010","09","27"));
    }
}