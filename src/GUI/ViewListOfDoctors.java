package GUI;

import consoleSystem_v2.Doctor;
import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewListOfDoctors extends MenuOptionController {
    private String optionNumber = "[1]";
    private String optionName = "View List Of Doctors";
    private JLabel optionNameLbl;
    private JTable doctorsTable;
    private JButton firstNameBtn;
    private JButton surnameBtn;
    private JButton refresh;

    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }


    // Contractor
    ViewListOfDoctors(SkinConsultationManager SCM,JFrame jFrame){

        // Set Window
        setWindow(800,400,"View List Of Doctors");

        // Set Option Name
        JPanel optionNamePnl = new JPanel(new FlowLayout());
        optionNameLbl = new JLabel("View List Of Doctors");
        optionNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        optionNamePnl.add(optionNameLbl);
        add("North",optionNamePnl);

        // Set Table
        JScrollPane firstNameSort = new JScrollPane(sortFirstName(SCM));
        JScrollPane surnameSort = new JScrollPane(sortSurname(SCM));
        add("Center",surnameSort);

        // Set Sort Button Types
        firstNameBtn = new JButton("Sort First Name");
        firstNameBtn.setFont(new Font("SansSerif",Font.BOLD,15));
        firstNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                remove(surnameSort);
                add("Center",firstNameSort);
                setVisible(true);
            }
        });
        surnameBtn = new JButton("Sort Surname");
        surnameBtn.setFont(new Font("SansSerif",Font.BOLD,15));
        surnameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                remove(firstNameSort);
                add("Center",surnameSort);
                setVisible(true);
            }
        });

        refresh = new JButton("Refresh");
        refresh.setFont(new Font("SansSerif",Font.BOLD,15));
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                jFrame.setVisible(false);

            }
        });


        JPanel pnl = new JPanel(new FlowLayout());
        pnl.add(firstNameBtn);
        pnl.add(surnameBtn);
        add("South",pnl);
    }


    // Methords

    // First Name Sort Method
    private JTable sortFirstName(SkinConsultationManager SCM){

        // Copy consoleSystem_v2 doctor ArrayList Objs in to New Local ArrayList
        ArrayList<Doctor> doctorsArrayList = new ArrayList<>();
        for(int i=0;i<SCM.getDoctors().size();i++){
            doctorsArrayList.add(SCM.getDoctors().get(i));
        }

        String[] columnNames = {"First Name","Surname","Date Of Birth","Mobile Number","Medical Licence Number","Specialisation"};
        String[][] doctorsArray = new String[doctorsArrayList.size()][columnNames.length];
        String[] firstName = new String[doctorsArrayList.size()];
        int[] potion = new int[firstName.length];

        // Copy First Names
        for(int i=0;i<firstName.length;i++){
            firstName[i] = doctorsArrayList.get(i).getName();
        }

        // Sort First Names
        for(int i=0;i<firstName.length-1;i++){
            for(int j=0;j<firstName.length-1;j++){
                //Compares Each Elements Of The Array To All The Remaining Elements
                if(firstName[i].compareToIgnoreCase(firstName[j+1])>0){
                    //Swapping Array Elements
                    String temp = firstName[i];
                    firstName[i] = firstName[j];
                    firstName[j] = temp;
                }
            }
        }

        // After Sort Check New Potions
        for(int i=0;i<potion.length;i++){
            for(int j=0;j<potion.length;j++){
                if(firstName[i].equals(doctorsArrayList.get(j).getName())){
                    potion[i] = j;
                }
            }
        }

        // Set Doctors Values In To 2D Array
        for(int i=0;i<potion.length;i++){
            for(int j=0;j<columnNames.length;j++){
                //doctorsArray[i][j] =
                if (j == 0) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getName();
                } else if (j == 1) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getSurname();
                } else if (j == 2) {
                    doctorsArray[i][j] = String.valueOf(doctorsArrayList.get(potion[i]).getDateOfBirth());
                } else if (j == 3) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getMobileNumber();
                } else if (j == 4) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getMedicalLicenceNumber();
                } else {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getSpecialisation();
                }
            }
        }

        // Set Table
        doctorsTable = new JTable(doctorsArray,columnNames);

        // Set Table Data Font
        doctorsTable.setFont(new Font("SansSerif",1,15));

        // Set Table Column Font
        doctorsTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));

        return doctorsTable;
    }

    // Surname Sort Method
    private JTable sortSurname(SkinConsultationManager SCM){

        // Copy consoleSystem_v2 doctor ArrayList Objs in to New Local ArrayList
        ArrayList<Doctor> doctorsArrayList = new ArrayList<>();
        for(int i=0;i<SCM.getDoctors().size();i++){
            doctorsArrayList.add(SCM.getDoctors().get(i));
        }

        String[] columnNames = {"Surname","First Name","Date Of Birth","Mobile Number","Medical Licence Number","Specialisation"};
        String[][] doctorsArray = new String[doctorsArrayList.size()][columnNames.length];
        String[] surname = new String[doctorsArrayList.size()];
        int[] potion = new int[surname.length];

        // Copy First Names
        for(int i=0;i<surname.length;i++){
            surname[i] = doctorsArrayList.get(i).getSurname();
        }

        // Sort First Names
        for(int i=0;i<surname.length-1;i++){
            for(int j=i+1;j<surname.length;j++){
                //Compares Each Elements Of The Array To All The Remaining Elements
                if(surname[i].compareToIgnoreCase(surname[j])>0){
                    //Swapping Array Elements
                    String temp = surname[i];
                    surname[i] = surname[j];
                    surname[j] = temp;
                }
            }
        }

        // After Sort Check New Potions
        for(int i=0;i<potion.length;i++){
            for(int j=0;j<potion.length;j++){
                if(surname[i].equals(doctorsArrayList.get(j).getSurname())){
                    potion[i] = j;
                }
            }
        }

        // Set Doctors Values In To 2D Array
        for(int i=0;i<potion.length;i++){
            for(int j=0;j<columnNames.length;j++){
                //doctorsArray[i][j] =
                if (j == 0) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getSurname();
                } else if (j == 1) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getName();
                } else if (j == 2) {
                    doctorsArray[i][j] = String.valueOf(doctorsArrayList.get(potion[i]).getDateOfBirth());
                } else if (j == 3) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getMobileNumber();
                } else if (j == 4) {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getMedicalLicenceNumber();
                } else {
                    doctorsArray[i][j] = doctorsArrayList.get(potion[i]).getSpecialisation();
                }
            }
        }

        // Set Table
        doctorsTable = new JTable(doctorsArray,columnNames);

        // Set Table Data Font
        doctorsTable.setFont(new Font("SansSerif",1,15));

        // Set Table Column Font
        doctorsTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));

        return doctorsTable;
    }
}
