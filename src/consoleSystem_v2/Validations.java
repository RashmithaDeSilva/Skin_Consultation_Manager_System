package consoleSystem_v2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class Validations {

    // Regular expression for a valid name
    private final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

    // Pattern object for the regular expression
    private final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    // Regular expression for a valid mobile number
    private final String MOBILE_NUMBER_REGEX = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

    // Pattern object for the regular expression
    private final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile(MOBILE_NUMBER_REGEX);


    public boolean nameValidator(String name,int validatePaton){
        // Validate the name using the regular expression
        boolean returnValue = false;

        // 0 = Name  Validations
        if (validatePaton == 0) {
            int nameLength = name.length();
            if (nameLength >= 3 && nameLength <= 30 && NAME_PATTERN.matcher(name).matches()) {
                returnValue = true;
            }

        } else if (validatePaton == 1) {
            // 1 = Other String Validations
            int nameLength = name.length();
            if (nameLength >= 5 && nameLength <= 100 && NAME_PATTERN.matcher(name).matches()) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    public boolean mobileNumberValidator(String mobileNumber) {
        // Validate the mobile number using the regular expression
        return MOBILE_NUMBER_PATTERN.matcher(mobileNumber).matches();
    }

    public boolean validateID(String ID) {

        // Check if the ID is empty
        if (ID == null || ID.length() < 4) {
            return false;
        }

        // Check if the ID contains only letters and digits
        for (int i = 0; i < ID.length(); i++) {
            char c = ID.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean ageValidatorForDoctor(String year,String month,String date){
        boolean returnBool = false;
        try{
            SimpleDateFormat dateForm = new SimpleDateFormat("yyyy");
            Date today = new Date();
            int befor_25Years = (Integer.parseInt(dateForm.format(today)))-(25);
            int befor_60Years = (Integer.parseInt(dateForm.format(today)))-(60);

            if(befor_25Years >= Integer.parseInt(year) && befor_60Years <= Integer.parseInt(year)){
                LocalDate DOB = LocalDate.parse(year+"-"+month+"-"+date);
                returnBool = true;
            } else {
                System.out.println("This Age Cannot be Entered \nThe Doctor Should be Between 25-60 Years of Age .....!\n");
            }

        }catch(Exception e){
            System.out.println("Invalid Date .....!\n");
        }
        return returnBool;
    }

    public boolean ageValidatorForPatient(String year,String month,String date){
        boolean returnBool = false;
        try{
            SimpleDateFormat dateForm = new SimpleDateFormat("yyyy");
            Date today = new Date();

            // World Oldest Person Age Is 118 So Only Input Age Range Is 125
            int befor_125Years = (Integer.parseInt(dateForm.format(today)))-(125);

            // Check For This Date
            dateForm = new SimpleDateFormat("yyyyMMdd");
            int thisYear = Integer.parseInt(dateForm.format(today));
            String tempInputDate = year+month+date;
            int inputDate = Integer.parseInt(tempInputDate);

            if(Integer.parseInt(month) < 10){
                month = "0"+String.valueOf(Integer.valueOf(month));
            }
            if(Integer.parseInt(date) < 10){
                date = "0"+String.valueOf(Integer.valueOf(date));
            }

            // The Patient Should be Between This Date And Before 125 Years Only
            if(thisYear >= inputDate && befor_125Years <= Integer.parseInt(year)){
                LocalDate DOB = LocalDate.parse(year+"-"+month+"-"+date);
                returnBool = true;
            }

        }catch(Exception e){
            //Invalid Date .....!
            //System.out.println(e);
        }
        return returnBool;
    }

}
