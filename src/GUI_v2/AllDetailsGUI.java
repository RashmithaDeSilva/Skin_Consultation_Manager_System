package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class AllDetailsGUI extends MenuOptionControllerGUI{


    public AllDetailsGUI(Doctor doctor,int consultationPosition){
        // Set Window
        setWindow(400,450,"Consultation Details");

        // Set Body
        setBody(doctor,consultationPosition);
    }

    private void setBody(Doctor doctor,int consultationPosition){

        Font font = new Font("SansSerif",Font.BOLD,15);

        JPanel bodyPnl =new JPanel(new FlowLayout());
        JPanel doctorDetailsPnl = new JPanel(new GridBagLayout());

        JLabel doctorFullNameLbl = new JLabel("Doctor Name > Dr "+doctor.getFullName());
        JLabel doctorContactNumberLbl = new JLabel("Contact Number > "+doctor.getMobileNumber());
        JLabel doctorSpecialisationLbl = new JLabel("Specialisation > "+doctor.getSpecialisation());

        JPanel consultationDetailsPnl = new JPanel(new GridBagLayout());
        JLabel consultationDate = new JLabel("Consultation Date > "+String.valueOf(doctor.getConsultation(consultationPosition)));

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
