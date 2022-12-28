package GUI_v2;

import consoleSystem_v2.Consultation;
import consoleSystem_v2.Doctor;
import consoleSystem_v2.Patient;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Key;
import java.util.Random;

public class AddConsultationGUI extends MenuOptionControllerGUI {

    // Constructor
    AddConsultationGUI(Doctor doctor, Consultation consultation) throws IOException {
        // Set Window
        setWindow(600,680,"Add Consultation");

        // Set Empty Patient
        consultation.setPatient(new Patient());

        // Set Body
        GUIBody(doctor,consultation);

    }


    // Set Body
    private void GUIBody(Doctor doctor, Consultation consultation) throws IOException {
        // Set Main Menu Name
        addConsultationPnl = new JPanel(new FlowLayout());
        addConsultationLbl = new JLabel("Add Consultation");
        addConsultationLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        addConsultationPnl.add(addConsultationLbl);
        add("North",addConsultationPnl);

        // Main Body
        bodyPartPnl = new JPanel(new FlowLayout());
        font = new Font("SansSerif",Font.BOLD,14);


        // Doctor Details
        doctorDetailsPnl = new JPanel(new GridBagLayout());
        doctorDetailsPnl.setBorder(BorderFactory.createTitledBorder("Doctor Details"));
        doctorDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));
        GBC = new GridBagConstraints();

        // Doctor Name
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        doctorNameLbl = new JLabel("Doctor Name >   "+doctor.getFullName());
        doctorNameLbl.setFont(font);
        doctorDetailsPnl.add(doctorNameLbl,GBC);
        GBC.insets = new Insets(5,20,5,20);
        GBC.gridx = 1;
        GBC.gridy = 0;
        doctorNameLbl = new JLabel("Requested Time >   "+String.valueOf(consultation.getRequestedTime()));
        doctorNameLbl.setFont(font);
        doctorDetailsPnl.add(doctorNameLbl,GBC);
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 1;
        consultationDateLbl = new JLabel("Consultation Date >   "+String.valueOf(consultation.getDate()));
        consultationDateLbl.setFont(font);
        doctorDetailsPnl.add(consultationDateLbl,GBC);
        GBC.insets = new Insets(5,20,5,20);
        GBC.gridx = 1;
        GBC.gridy = 1;
        consultationTimeLbl = new JLabel("Consultation Start Time >   "+String.valueOf(consultation.getConsultationStartTime()));
        consultationTimeLbl.setFont(font);
        doctorDetailsPnl.add(consultationTimeLbl,GBC);
        bodyPartPnl.add(doctorDetailsPnl);


        // Patient Details
        patientDetailsPnl = new JPanel(new GridBagLayout());
        patientDetailsPnl.setBorder(BorderFactory.createTitledBorder("Patient Details"));
        patientDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));

        // First name
        GBC.insets = new Insets(5,-55,5,0);
        GBC.gridx = 0;
        GBC.gridy = 0;
        firstNamePnl = new JPanel(new FlowLayout());
        firstNameLbl = new JLabel("First Name");
        firstNameLbl.setFont(font);
        firstNamePnl.add(firstNameLbl);
        firstNameTxt = new JTextField(6);
        firstNameTxt.setFont(font);
        firstNamePnl.add(firstNameTxt);
        patientDetailsPnl.add(firstNamePnl,GBC);

        // Surname
        GBC.insets = new Insets(5,-40,5,0);
        GBC.gridx = 1;
        GBC.gridy = 0;
        surnamePnl = new JPanel(new FlowLayout());
        surnameLbl = new JLabel("Surname");
        surnameLbl.setFont(font);
        surnamePnl.add(surnameLbl);
        surnameTxt = new JTextField(10);
        surnameTxt.setFont(font);
        surnamePnl.add(surnameTxt);
        patientDetailsPnl.add(surnamePnl,GBC);

        // Date Of Birth
        GBC.insets = new Insets(5,-120,5,0);
        GBC.gridx = 0;
        GBC.gridy = 1;
        dateOfBirthPnl = new JPanel(new FlowLayout());
        dateOfBirthLbl = new JLabel("Date Of Birth");
        dateOfBirthLbl.setFont(font);
        dateOfBirthPnl.add(dateOfBirthLbl);
        patientDetailsPnl.add(dateOfBirthPnl,GBC);

        // Year
        GBC.insets = new Insets(5,-280,5,0);
        GBC.gridx = 1;
        GBC.gridy = 1;
        yearPnl = new JPanel(new FlowLayout());
        yearLbl = new JLabel("Y");
        yearLbl.setFont(font);
        yearPnl.add(yearLbl);
        yearTxt = new JTextField(5);
        yearTxt.setFont(font);
        yearPnl.add(yearTxt);
        patientDetailsPnl.add(yearPnl,GBC);
        // Month
        GBC.insets = new Insets(5,-280,5,0);
        GBC.gridx = 2;
        GBC.gridy = 1;
        monthPnl = new JPanel(new FlowLayout());
        monthLbl = new JLabel("M");
        monthLbl.setFont(font);
        monthPnl.add(monthLbl);
        monthTxt = new JTextField(3);
        monthTxt.setFont(font);
        monthPnl.add(monthTxt);
        patientDetailsPnl.add(monthPnl,GBC);
        // Date
        GBC.insets = new Insets(5,-100,5,150);
        GBC.gridx = 3;
        GBC.gridy = 1;
        dayPnl = new JPanel(new FlowLayout());
        dayLbl = new JLabel("D");
        dayLbl.setFont(font);
        dayPnl.add(dayLbl);
        dayTxt = new JTextField(3);
        dayTxt.setFont(font);
        dayPnl.add(dayTxt);
        patientDetailsPnl.add(dayPnl,GBC);

        // Mobile Number
        GBC.insets = new Insets(5,3,5,0);
        GBC.gridx = 0;
        GBC.gridy = 2;
        mobileNumberPnl = new JPanel(new FlowLayout());
        mobileNumberLbl = new JLabel("Mobile Number");
        mobileNumberLbl.setFont(font);
        mobileNumberPnl.add(mobileNumberLbl);
        mobileNumberTxt = new JTextField(8);
        mobileNumberTxt.setFont(font);
        mobileNumberPnl.add(mobileNumberTxt);
        patientDetailsPnl.add(mobileNumberPnl,GBC);

        // Patient ID
        GBC.insets = new Insets(5,20,5,10);
        GBC.gridx = 1;
        GBC.gridy = 2;
        patientIDPnl = new JPanel(new FlowLayout());
        patientIDLbl = new JLabel("Patient ID");
        patientIDLbl.setFont(font);
        patientIDPnl.add(patientIDLbl);
        patientIDTxt = new JTextField(5);
        patientIDTxt.setFont(font);
        patientIDPnl.add(patientIDTxt);
        patientDetailsPnl.add(patientIDPnl,GBC);
        bodyPartPnl.add(patientDetailsPnl);

        // Other Details
        otherPnl = new JPanel(new GridBagLayout());
        otherPnl.setBorder(BorderFactory.createTitledBorder("Other Details"));
        otherPnl.setFont(new Font("SansSerif",Font.BOLD,14));

        // Cost
        GBC.insets = new Insets(5,5,0,0);
        GBC.gridx = 0;
        GBC.gridy = 0;
        costPnl = new JPanel(new FlowLayout());
        costLbl = new JLabel("Cost");
        costLbl.setFont(font);
        costPnl.add(costLbl);
        costTxt = new JTextField(5);
        costTxt.setFont(font);
        costPnl.add(costTxt);
        otherPnl.add(costPnl,GBC);
        // Cost Notification
        GBC.insets = new Insets(5,10,0,5);
        GBC.gridx = 1;
        GBC.gridy = 0;
        notyPnl = new JPanel(new FlowLayout());
        notyLbl = new JLabel("$15");
        notyLbl.setFont(font);
        notyPnl.add(notyLbl);
        otherPnl.add(notyPnl,GBC);

        // Note
        GBC.insets = new Insets(0,5,0,0);
        GBC.gridx = 0;
        GBC.gridy = 1;
        notePnl = new JPanel(new FlowLayout());
        noteLbl = new JLabel("Extra Note");
        noteLbl.setFont(font);
        notePnl.add(noteLbl);
        otherPnl.add(notePnl,GBC);
        // Note Text Area
        GBC.insets = new Insets(0,10,0,5);
        GBC.gridx = 1;
        GBC.gridy = 1;
        noteTxtPnl = new JPanel(new FlowLayout());
        noteTxtAr = new JTextArea(4,31);
        noteTxtAr.setFont(font);
        noteSclPn = new JScrollPane(noteTxtAr);
        noteTxtPnl.add(noteSclPn);
        otherPnl.add(noteTxtPnl,GBC);

        // Image Input
        GBC.insets = new Insets(0,5,5,0);
        GBC.gridx = 0;
        GBC.gridy = 2;
        imageLblPnl = new JPanel(new FlowLayout());
        imageLbl = new JLabel("Select Image");
        imageLbl.setFont(font);
        imageLblPnl.add(imageLbl);
        otherPnl.add(imageLblPnl,GBC);
        // Get Image Input
        GBC.insets = new Insets(0,-260,5,0);
        GBC.gridx = 1;
        GBC.gridy = 2;
        imageSelectBtn = new JButton("Select Image");
        imageSelectBtn.addActionListener( (e) -> {
            try {
                fileSelector(consultation.getPatient());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        otherPnl.add(imageSelectBtn,GBC);
        GBC.insets = new Insets(0,-270,5,0);
        GBC.gridx = 2;
        GBC.gridy = 2;
        photoLbl = new JLabel();
        photoLbl.setIcon(new ImageIcon(resizeImage(new File(".\\src\\Images\\Empty.jpg"),200,120)));
        otherPnl.add(photoLbl,GBC);
        bodyPartPnl.add(otherPnl);

        // Submit Button
        wanAndSubPnl = new JPanel(new GridLayout(2,1));
        wanPnl = new JPanel(new FlowLayout());
        warningLbl = new JLabel("^_^");
        warningLbl.setFont(font);
        wanPnl.add(warningLbl);
        wanAndSubPnl.add(wanPnl);
        btnPnl = new JPanel(new FlowLayout());
        submitBtn = new JButton("Submit");
        submitBtn.setFont(font);
        submitBtn.addActionListener( event -> submitBtnAddAction(doctor,consultation));
        btnPnl.add(submitBtn);
        wanAndSubPnl.add(btnPnl);


        add("West",new JLabel("          "));
        add("Center",bodyPartPnl);
        add("East",new JLabel("          "));
        add("South",wanAndSubPnl);
    }


    // File Selector
    private JPanel fileSelector(Patient patient) throws IOException {

        // This Programme Working With Windows And macOS
        JPanel panel = new JPanel(new FlowLayout());

        if (os.startsWith("Windows")) { // Code to execute on Windows

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(".\\src\\Images"));
            int response = fileChooser.showOpenDialog(null); // Select File To Open

            // If Select Eny File It Will Return O If Cansel It Will Return 1
            if (response == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION or 0
                warningLbl.setText("");

                // Get File
                File imgFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                // Validate That File Is Image Or Not
                if (imageValidation(imgFile.getPath())) {

                    // Show Image File
                    photoLbl.setIcon(new ImageIcon(resizeImage(imgFile,200,120)));

                    // Encrypt Image
                    imageEncrypting(imgFile.getAbsolutePath(),patient);

                } else {
                    warningLbl.setText("This Is Not Image");
                }
            }
            panel.add(fileChooser);

        } else if (os.startsWith("Mac")) { // Code to execute on macOS

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("./src/Images"));
            int response = fileChooser.showOpenDialog(null); // Select File To Open

            // If Select Eny File It Will Return O If Cansel It Will Return 1
            if (response == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION or 0
                warningLbl.setText("");

                // Get File
                File imgFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                // Validate That File Is Image Or Not
                if (imageValidation(imgFile.getPath())) {

                    // Show Image File
                    photoLbl.setIcon(new ImageIcon(resizeImage(imgFile,200,120)));

                    // Encrypt Copy Image
                    imageEncrypting(imgFile.getAbsolutePath(),patient);

                } else {
                    warningLbl.setText("This Is Not Image");
                }
            }
            panel.add(fileChooser);

        } else {
            warningLbl.setText("try with windows or macOS");
        }

        return new JPanel();
    }

    // Check Select File Is Image Or Not
    private boolean imageValidation(String imgPath){
        // Only Eligible File Types
        String[] extensions = {"jpg","jpeg","png"};
        File tempFile = new File(imgPath);
        boolean returnValue = false;

        // Check This Image Path Is Correct Or Not
        if (!tempFile.exists()) { // If It Incorrect Return False
            returnValue = false;

        } else {
            String fileName = tempFile.getName();
            String fileExtension = "";
            // Get Last . Point Value For Get Extension
            int lastIndex = fileName.lastIndexOf(".");

            if (lastIndex >= 0) {
                fileExtension = fileName.substring(lastIndex+1);
            }

            for (int i=0;i<extensions.length;i++) {
                if (fileExtension.equals(extensions[i])) {
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    // Resizer Image
    private BufferedImage resizeImage(File imageFile, int width, int height) throws IOException {

        // Read the image file into a BufferedImage object
        BufferedImage originalImage = ImageIO.read(imageFile);

        // Create a new BufferedImage object with the desired size
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Get the graphics context for the resized image
        Graphics graphics = resizedImage.getGraphics();

        // Draw the original image on the resized image
        graphics.drawImage(originalImage, 0, 0, width, height, null);
        graphics.dispose();

        return resizedImage;
    }

    // Secret Key Generate
    public static String generateSecretKey(){
        Random random = new Random();
        String key = "";
        for (int i=0;i<16;i++) {
            key += (random.nextInt(32,127) != 46) ? (char)random.nextInt(32,127) : "!";
        }
        return key;
    }

    // Image Encrypting
    private void imageEncrypting(String absolutePath,Patient patient) {

        // This Programme Working With Windows And macOS
        String key = generateSecretKey();
        String imgName = generateSecretKey();

        if (os.startsWith("Windows")) { // Code to execute on Windows
            try {

                FileInputStream in = new FileInputStream(absolutePath);
                // In Hear Encrypt Image name Is No Point
                // Then No One Can Understand What Patient Skin Image Is This
                FileOutputStream out = new FileOutputStream(".\\src\\Data\\"+imgName+"p.jpg");

                Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);

                byte[] input = new byte[64];
                int bytesRead;
                while ((bytesRead = in.read(input)) != -1) {
                    byte[] output = cipher.update(input, 0, bytesRead);
                    if (output != null)
                        out.write(output);
                }

                byte[] output = cipher.doFinal();
                if (output != null)
                    out.write(output);

                in.close();
                out.flush();
                out.close();

                // Set Encrypt Key And Image Absolute Path In To Patient
                patient.setSkinEncryptImage(".\\src\\Data\\"+imgName+"p.jpg");
                patient.setKey(key);

            } catch (Exception e){
                warningLbl.setText(e.getMessage());
            }

        } else if (os.startsWith("Mac")) { // Code to execute on macOS
            try {

                FileInputStream in = new FileInputStream(absolutePath);
                FileOutputStream out = new FileOutputStream("./src/Data/"+imgName+"p.jpg");

                Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);

                byte[] input = new byte[64];
                int bytesRead;
                while ((bytesRead = in.read(input)) != -1) {
                    byte[] output = cipher.update(input, 0, bytesRead);
                    if (output != null)
                        out.write(output);
                }

                byte[] output = cipher.doFinal();
                if (output != null)
                    out.write(output);

                in.close();
                out.flush();
                out.close();

                // Set Encrypting And Key In To Patient
                patient.setSkinEncryptImage("./src/Data/"+imgName+"p.jpg");
                patient.setKey(key);

            } catch (Exception e){
                warningLbl.setText(e.getMessage());
            }
        }
    }

    // Submit Button Add Action Listener
    private void submitBtnAddAction(Doctor doctor, Consultation consultation){

    }


    @Override
    public String getOptionName() {
        return null;
    }
    @Override
    public String getOptionNumber() {
        return null;
    }


    private final String os = System.getProperty("os.name");
    private Font font;
    private JLabel warningLbl;
    private JPanel addConsultationPnl;
    private JLabel addConsultationLbl;
    private JPanel bodyPartPnl;
    private JPanel patientDetailsPnl;
    private JPanel firstNamePnl;
    private JLabel firstNameLbl;
    private JTextField firstNameTxt;
    private JPanel surnamePnl;
    private JLabel surnameLbl;
    private JTextField surnameTxt;
    private JPanel dateOfBirthPnl;
    private JLabel dateOfBirthLbl;
    private JLabel yearLbl;
    private JTextField yearTxt;
    private JLabel monthLbl;
    private JTextField monthTxt;
    private JLabel dayLbl;
    private JTextField dayTxt;
    private JPanel yearPnl;
    private JPanel monthPnl;
    private JPanel dayPnl;
    private JPanel mobileNumberPnl;
    private JLabel mobileNumberLbl;
    private JTextField mobileNumberTxt;
    private JPanel patientIDPnl;
    private JLabel patientIDLbl;
    private JTextField patientIDTxt;
    private JPanel otherPnl;
    private JPanel costPnl;
    private JLabel costLbl;
    private JTextField costTxt;
    private JPanel notyPnl;
    private JLabel notyLbl;
    private JPanel btnPnl;
    private JButton submitBtn;
    private JPanel doctorDetailsPnl;
    private JLabel doctorNameLbl;
    private JLabel consultationDateLbl;
    private JLabel consultationTimeLbl;
    private GridBagConstraints GBC;
    private JPanel notePnl;
    private JLabel noteLbl;
    private JPanel noteTxtPnl;
    private JTextArea noteTxtAr;
    private JScrollPane noteSclPn;
    private JPanel imageLblPnl;
    private JLabel imageLbl;
    private JLabel photoLbl;
    private JButton imageSelectBtn;
    private JPanel wanAndSubPnl;
    private JPanel wanPnl;

}
