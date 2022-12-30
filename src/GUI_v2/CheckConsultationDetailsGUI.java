package GUI_v2;

import consoleSystem_v2.SkinConsultationManager;

import javax.swing.*;
import java.awt.*;

public class CheckConsultationDetailsGUI extends MenuOptionControllerGUI{

    public CheckConsultationDetailsGUI(SkinConsultationManager SCM,MenuOptionControllerGUI MOC){
        // Set Window
        setWindow(600,400,"Check Consultation Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set Body
        setBody(SCM,MOC);
    }

    private void setBody(SkinConsultationManager SCM,MenuOptionControllerGUI MOC) {
        font = new Font("SansSerif",Font.BOLD,14);

        // Set Consultation Menu Name
        CheckConsultationDetailsNamePnl = new JPanel(new FlowLayout());
        CheckConsultationDetailsNameLbl = new JLabel("Check Consultation Details");
        CheckConsultationDetailsNameLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        CheckConsultationDetailsNamePnl.add(CheckConsultationDetailsNameLbl);
        add("North",CheckConsultationDetailsNamePnl);

        // Body Parts
        bodyPartPnl = new JPanel(new GridLayout(2,1));

        // Show Doctors Name And Select Doctor
        doctorsNamePnl = new JPanel(new GridBagLayout());
        GBC = new GridBagConstraints();
        doctorNames = new String[SCM.getDoctors().size()+1];
        doctorNames[0] = "   Select Doctor   ";
        for (int i=1;i<SCM.getDoctors().size()+1;i++) {
            doctorNames[i] = "  ["+i+"]  "+SCM.getDoctor(i-1).getFullName();
        }
        selectDoctorCmBx = new JComboBox<>(doctorNames);
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 1;
        GBC.gridy = 0;
        doctorsNamePnl.add(selectDoctorCmBx,GBC);
        bodyPartPnl.add(doctorsNamePnl);

        // Back Button
        btnPnl = new JPanel(new GridBagLayout());
        backBtn = new JButton("Back");
        backBtn.setFont(font);
        backBtn.addActionListener( (e) -> {
            MOC.setVisible(true);
            setVisible(false);
        });
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 1;
        btnPnl.add(backBtn,GBC);

        // Check Button
        checkBtn = new JButton("Check");
        checkBtn.setFont(font);
        checkBtn.addActionListener( (e) -> checkAddActionListener(SCM));
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 2;
        GBC.gridy = 1;
        btnPnl.add(checkBtn,GBC);
        bodyPartPnl.add(btnPnl);


        add("Center",bodyPartPnl);
    }

    private void checkAddActionListener(SkinConsultationManager SCM){
        // Get Select Doctor Number
        int selectDoctor = selectDoctorCmBx.getSelectedIndex();

        if (selectDoctor != 0) {
            new ConsultationDetailsGUI(SCM.getDoctor(selectDoctor-1)).setVisible(true);
        }

    }

    @Override
    protected String getOptionName() {
        return optionName;
    }

    @Override
    protected String getOptionNumber() {
        return optionNumber;
    }

    private String optionNumber = "[2]";
    private String optionName = "Check Consultation";
    private Font font;
    private JPanel CheckConsultationDetailsNamePnl;
    private JLabel CheckConsultationDetailsNameLbl;
    private JPanel bodyPartPnl;
    private JPanel doctorsNamePnl;
    private String[] doctorNames;
    private JComboBox selectDoctorCmBx;
    private GridBagConstraints GBC;
    private JPanel btnPnl;
    private JButton backBtn;
    private JButton checkBtn;
}

