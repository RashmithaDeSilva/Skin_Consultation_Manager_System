package consoleSystem_v2;

import java.io.Serializable;
import java.time.LocalDate;

abstract class Person implements Serializable {

    // Set Method
    abstract public void setName(String name);
    abstract public void setSurname(String surname);
    abstract public void setDateOfBirth(LocalDate dateOfBirth);
    abstract public void setMobileNumber(String mobileNumber);

    // Get Method
    abstract public String getName();
    abstract public String getSurname();
    abstract public LocalDate getDateOfBirth();
    abstract public String getMobileNumber();
}