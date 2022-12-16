package consoleSystem_v1;

import java.time.LocalDate;

class Person {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String mobileNumber;

    // Set Method
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    // Get Method
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
}
