package consoleSystem_v2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.io.NotSerializableException;

public class Test {

    private static ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);

    public static void main(String[] args) throws IOException {

        /*
        LocalDate DOB = LocalDate.parse("2000-11-20");

        doctors.add(new Doctor("lahiru","De silva",DOB,"099999999999","s001","sfisdhfijhs"));

        // Create File
        try {
            BufferedWriter saveData = new BufferedWriter(new FileWriter("Save_Data.txt"));


            // Print Doctor List
            saveData.write("\t+---------------+-----------+---------------------------+-------------------+-------------------+---------------------------+\n");
            saveData.write("\t|\tSurname\t\t|\tName\t|\tMedical Licence Number\t|\tMobile Number\t|\tDate Of Birth\t|\t\tSpecialisation\t\t|\n");
            saveData.write("\t+---------------+-----------+---------------------------+-------------------+-------------------+---------------------------+\n");

            for(int i=0;i<doctors.size();i++){
                saveData.write("\t|"+doctors.get(i).getSurname()+"\t"+doctors.get(i).getName()+"\t"+doctors.get(i).getMedicalLicenceNumber()+"\t"+doctors.get(i).getMobileNumber()+"\t"+doctors.get(i).getDateOfBirth()+"\t"+doctors.get(i).getSpecialisation()+"|\n");
            }
            saveData.write("\t+---------------+-----------+---------------------------+-------------------+-------------------+---------------------------+\n");

            //saveData.write();



            saveData.close();
        }catch (Exception e){
            System.out.println(e);
        }
         */


        for (int i=0;i<2;i++){
            doctors.add(new Doctor());
        }

        try{
            File file = new File("Obj_Data.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            Iterator iterator = doctors.iterator();
            while (iterator.hasNext()){
                Doctor doctor = (Doctor) iterator.next();
                objectOutputStream.writeObject(doctor);
            }

        }catch (Exception e){
            System.out.println(e);
        }


    }
}
