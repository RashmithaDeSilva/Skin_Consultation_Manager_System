package GUI_v2;

import consoleSystem_v2.Doctor;
import consoleSystem_v2.SkinConsultationManager;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ViewListOfDoctorsGUI extends MenuOptionControllerGUI {

    private String optionNumber = "[1]";
    private String optionName = "View List Of Doctors";
    private JPanel optionNamePnl;
    private JLabel optionNameLbl;
    private JTable doctorsTable;
    private JButton firstNameBtn,surnameBtn,refreshBtn,setDefaultBtn;
    private Font font;


    // Contractor
    ViewListOfDoctorsGUI(SkinConsultationManager SCM, MainMenuGUI mainMenu){

        // Set Window
        setWindow(800,400,"View List Of Doctors");

        // Set Body
        GUIBody(SCM,mainMenu);

    }


    // Set Body
    private void GUIBody(SkinConsultationManager SCM, MainMenuGUI mainMenu){

        font = new Font("SansSerif",Font.BOLD,12);

        // Set Option Name
        optionNamePnl = new JPanel(new FlowLayout());
        optionNamePnl.setBackground(RGBColor);
        optionNameLbl = new JLabel("List Of Doctors");
        optionNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        optionNamePnl.add(optionNameLbl);
        add("North",optionNamePnl);

        // Copy consoleSystem_v2 doctor ArrayList Objs in to New Local ArrayList
        ArrayList<Doctor> doctorsArrayList = new ArrayList<>(SCM.getDoctors());

        // Set Table
        JScrollPane docList = new JScrollPane(doctorList(doctorsArrayList));
        JScrollPane firstNameSort = new JScrollPane(sortFirstName(doctorsArrayList));
        JScrollPane surnameSort = new JScrollPane(sortSurname(doctorsArrayList));
        add("Center",docList);

        // Set Sort Button Types
        // Sort By First Name Button
        firstNameBtn = new JButton("Sort First Name");
        firstNameBtn.setBackground(RGBColor2);
        firstNameBtn.setForeground(RGBColor3);
        firstNameBtn.setFont(font);
        firstNameBtn.addActionListener( (e) -> {
            setVisible(false);
            remove(docList);
            remove(surnameSort);
            add("Center",firstNameSort);
            setVisible(true);
        });

        // Sort By Surname Button
        surnameBtn = new JButton("Sort Surname");
        surnameBtn.setBackground(RGBColor2);
        surnameBtn.setForeground(RGBColor3);
        surnameBtn.setFont(font);
        surnameBtn.addActionListener( (e) -> {
            setVisible(false);
            remove(docList);
            remove(firstNameSort);
            add("Center",surnameSort);
            setVisible(true);
        });

        // Set Default Button
        setDefaultBtn = new JButton("Set Default");
        setDefaultBtn.setBackground(RGBColor2);
        setDefaultBtn.setForeground(RGBColor3);
        setDefaultBtn.setFont(font);
        setDefaultBtn.addActionListener( (e) -> {
            setVisible(false);
            remove(firstNameSort);
            remove(surnameSort);
            add("Center",docList);
            setVisible(true);
        });

        // Refresh Button
        refreshBtn = new JButton("Refresh");
        refreshBtn.setBackground(RGBColor4);
        refreshBtn.setForeground(RGBColor5);
        refreshBtn.setFont(font);
        refreshBtn.addActionListener((e) -> {
            SCM.openGUIWithOption(1);
            mainMenu.dispose();
            dispose();
        });

        JPanel pnl = new JPanel(new FlowLayout());
        pnl.setBackground(RGBColor);
        pnl.add(firstNameBtn);
        pnl.add(surnameBtn);
        pnl.add(setDefaultBtn);
        pnl.add(refreshBtn);
        add("South",pnl);
    }

    // Set Doctor List
    private JTable doctorList(ArrayList<Doctor> doctorsArrayList){

        String[] columnNames = {"First Name","Surname","Date Of Birth","Mobile Number","Medical Licence Number","Specialisation"};
        String[][] doctorsArray = new String[doctorsArrayList.size()][columnNames.length];


        // Set Doctors Values In To 2D Array
        for(int i=0;i<doctorsArrayList.size();i++){
            for(int j=0;j<columnNames.length;j++){
                if (j == 0) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getName();
                } else if (j == 1) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getSurname();
                } else if (j == 2) {
                    doctorsArray[i][j] = String.valueOf(doctorsArrayList.get(i).getDateOfBirth());
                } else if (j == 3) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getMobileNumber();
                } else if (j == 4) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getMedicalLicenceNumber();
                } else {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getSpecialisation();
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

    // First Name Sort Method
    private JTable sortFirstName(ArrayList<Doctor> doctorsArrayList){

        String[] columnNames = {"First Name","Surname","Date Of Birth","Mobile Number","Medical Licence Number","Specialisation"};
        String[][] doctorsArray = new String[doctorsArrayList.size()][columnNames.length];

        // Sort First Names
        for(int i=0;i<doctorsArrayList.size()-1;i++){
            for(int j=i+1;j<doctorsArrayList.size();j++){
                //Compares Each Elements Of The Array To All The Remaining Elements
                if(doctorsArrayList.get(i).getName().compareToIgnoreCase(doctorsArrayList.get(j).getName()) > 0){
                    //Swapping Array Elements
                    Doctor temp = doctorsArrayList.get(i);
                    doctorsArrayList.set(i,doctorsArrayList.get(j));
                    doctorsArrayList.set(j,temp);
                }
            }
        }

        // Set Doctors Values In To 2D Array
        for(int i=0;i<doctorsArrayList.size();i++){
            for(int j=0;j<columnNames.length;j++){
                if (j == 0) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getName();
                } else if (j == 1) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getSurname();
                } else if (j == 2) {
                    doctorsArray[i][j] = String.valueOf(doctorsArrayList.get(i).getDateOfBirth());
                } else if (j == 3) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getMobileNumber();
                } else if (j == 4) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getMedicalLicenceNumber();
                } else {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getSpecialisation();
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
    private JTable sortSurname(ArrayList<Doctor> doctorsArrayList){

        String[] columnNames = {"Surname","First Name","Date Of Birth","Mobile Number","Medical Licence Number","Specialisation"};
        String[][] doctorsArray = new String[doctorsArrayList.size()][columnNames.length];

        // Sort First Names
        for(int i=0;i<doctorsArrayList.size()-1;i++){
            for(int j=i+1;j<doctorsArrayList.size();j++){
                //Compares Each Elements Of The Array To All The Remaining Elements
                if(doctorsArrayList.get(i).getSurname().compareToIgnoreCase(doctorsArrayList.get(j).getSurname()) > 0){
                    //Swapping Array Elements
                    Doctor temp = doctorsArrayList.get(i);
                    doctorsArrayList.set(i,doctorsArrayList.get(j));
                    doctorsArrayList.set(j,temp);
                }
            }
        }

        // Set Doctors Values In To 2D Array
        for(int i=0;i<doctorsArrayList.size();i++){
            for(int j=0;j<columnNames.length;j++){
                if (j == 0) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getSurname();
                } else if (j == 1) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getName();
                } else if (j == 2) {
                    doctorsArray[i][j] = String.valueOf(doctorsArrayList.get(i).getDateOfBirth());
                } else if (j == 3) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getMobileNumber();
                } else if (j == 4) {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getMedicalLicenceNumber();
                } else {
                    doctorsArray[i][j] = doctorsArrayList.get(i).getSpecialisation();
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


    @Override
    public String getOptionName() {
        return optionName;
    }
    @Override
    public String getOptionNumber() {
        return optionNumber;
    }
}
