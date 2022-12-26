package consoleSystem_v2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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



    public boolean nameValidator(String name){
        // Validate the name using the regular expression
        return NAME_PATTERN.matcher(name).matches();
    }

    public boolean mobileNumberValidator(String mobileNumber) {
        // Validate the mobile number using the regular expression
        return MOBILE_NUMBER_PATTERN.matcher(mobileNumber).matches();
    }

    public boolean ageValidator(String year,String month,String date){
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
                System.out.println("Age Cannot be Entered in this \nThe Doctor Should be Between 25-60 Years of Age .....!\n");
            }

        }catch(Exception e){
            System.out.println("Invalid Date .....!\n");
        }
        return returnBool;
    }

}
