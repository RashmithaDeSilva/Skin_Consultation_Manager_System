package GUI;

import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;

public class AddConsultationForm extends JFrame {

    private JLabel formName = new JLabel();

    AddConsultationForm(SkinConsultationManager SCM,int doctorsArrayPosition){

        // Set Window
        setWindow(600,400,"Add Consultation Form");

        // Set Main Menu Name
        JPanel formPnl = new JPanel(new FlowLayout());
        formName.setText("Add Consultation Form");
        formName.setFont(new Font("",1,25));
        formPnl.add(formName);
        add("North",formPnl);

        // Get Date And Time
        JPanel dateAndTimePnl = new JPanel(new GridLayout(8,1));

        // Date Part
        JPanel datePnl = new JPanel(new FlowLayout());
        JLabel dateLbl = new JLabel("   Date");
        dateLbl.setFont(new Font("SansSerif",Font.BOLD,16));
        dateAndTimePnl.add(dateLbl);

        JLabel yearLbl = new JLabel("   Year");
        yearLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(yearLbl);

        JTextField yearTxt = new JTextField(5);
        yearTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(yearTxt);

        JLabel monthLbl = new JLabel("Month");
        monthLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(monthLbl);

        JTextField monthTxt = new JTextField(5);
        monthTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(monthTxt);

        JLabel dayLbl = new JLabel("Date");
        dayLbl.setFont(new Font("SansSerif",Font.BOLD,14));
        datePnl.add(dayLbl);

        JTextField dayTxt = new JTextField(5);
        dayTxt.setFont(new Font("SansSerif",Font.BOLD,12));
        datePnl.add(dayTxt);

        dateAndTimePnl.add(datePnl);
        add("West",dateAndTimePnl);






    }

    // Set Window
    private void setWindow(int width, int height, String name){
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 3
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

}
