package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultationDetailsGUI extends MenuOptionControllerGUI{

    public Font font;
    private JPanel optionNamePnl,viewPnl,viewTxtAndBtnPnl,warningPnl;
    private JLabel optionNameLbl,viewNumberLbl;
    private JScrollPane conList;
    private JTable cubsultationTable;
    private JTextField viewTxt;
    private JButton viewBtn;


    public ConsultationDetailsGUI(Doctor doctor){
        // Set Window
        setWindow(900,400,"Consultation Details");

        // Set Body
        setBody(doctor);
    }


    private void setBody(Doctor doctor){
        font = new Font("SansSerif",Font.BOLD,15);

        // Set Option Name
        optionNamePnl = new JPanel(new FlowLayout());
        optionNamePnl.setBackground(RGBColor);
        optionNameLbl = new JLabel("View List Of Doctors");
        optionNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        optionNamePnl.add(optionNameLbl);
        add("North",optionNamePnl);

        // Copy Consultation ArrayList Objs in to New Local ArrayList
        ArrayList<Consultation> consultationArrayList = new ArrayList<>();
        for(int i=0;i<doctor.getConsultationsArrayList().size();i++){
            consultationArrayList.add(doctor.getConsultation(i));
        }

        // Set Table
        conList = new JScrollPane(consultationList(consultationArrayList));
        add("Center",conList);

        // View Buttons
        viewPnl = new JPanel(new GridLayout(2,1));
        viewPnl.setBackground(RGBColor);
        viewTxtAndBtnPnl = new JPanel(new FlowLayout());
        viewTxtAndBtnPnl.setBackground(RGBColor);
        viewNumberLbl = new JLabel("Enter Number >");
        viewNumberLbl.setFont(font);
        viewTxtAndBtnPnl.add(viewNumberLbl);
        viewTxt = new JTextField(5);
        viewTxt.setFont(font);
        viewTxtAndBtnPnl.add(viewTxt);
        viewBtn = new JButton("View");
        viewBtn.setBackground(RGBColor2);
        viewBtn.setForeground(RGBColor3);
        viewBtn.setFont(font);
        viewBtn.addActionListener((e)-> viewBtnAddActionListener(doctor));
        viewTxtAndBtnPnl.add(viewBtn);
        viewPnl.add(viewTxtAndBtnPnl);
        add("South",viewPnl);

    }

    JTable consultationList(ArrayList<Consultation> conArrList){

        String[] columnNames = {"Number","Patient Name","Patient ID","Consultation Date","Consultation Time","Requested Time"};
        String[][] consultationArray = new String[conArrList.size()][columnNames.length];

        // Set Table
        cubsultationTable = new JTable(consultationArray,columnNames);

        // Set Doctors Values In To 2D Array
        for(int i=0;i<conArrList.size();i++){
            for(int j=0;j<columnNames.length;j++){
                if (j == 0) {
                    consultationArray[i][j] = "[ "+(i+1)+" ]";
                } else if (j == 1) {
                    consultationArray[i][j] = conArrList.get(i).getPatient().getName();
                } else if (j == 2) {
                    consultationArray[i][j] = conArrList.get(i).getPatient().getPatientID();
                } else if (j == 3) {
                    consultationArray[i][j] = String.valueOf(conArrList.get(i).getDate());
                } else if (j == 4) {
                    consultationArray[i][j] = String.valueOf(conArrList.get(i).getConsultationStartTime());
                } else {
                    consultationArray[i][j] = String.valueOf(conArrList.get(i).getRequestedTime())+" Hours";
                }
            }
        }



        // Set Table Data Font
        cubsultationTable.setFont(new Font("SansSerif",1,15));

        // Set Table Column Font
        cubsultationTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));

        return cubsultationTable;
    }

    private void viewBtnAddActionListener(Doctor doctor){

        if (!viewTxt.getText().equals("")) {
            try {
                if (doctor.getConsultationsArrayList().size() != 0) {

                    boolean valideID = false;
                    for (int i=0;i<doctor.getConsultationsArrayList().size();i++) {
                        if ((Integer.parseInt(viewTxt.getText())-1) <= doctor.getConsultationsArrayList().size() && (Integer.parseInt(viewTxt.getText())-1) >= 0) {
                            valideID = true;
                            new AllDetailsGUI(doctor,(Integer.parseInt(viewTxt.getText())-1),this).setVisible(true);
                            break;
                        }
                    }

                    if (!valideID) {
                        warningMassage("Invalid Number !","Warning");
                    }

                }else {
                    warningMassage("Doctor "+doctor.getFullName()+" Have Not Consultations !","Warning");
                }

            } catch (Exception e) {
                warningMassage("Enter Integer Value !","Warning");
            }

        } else {
            warningMassage("Enter Number !","Warning");
        }

    }

    @Override
    protected String getOptionName() {
        return null;
    }

    @Override
    protected String getOptionNumber() {
        return null;
    }

}
