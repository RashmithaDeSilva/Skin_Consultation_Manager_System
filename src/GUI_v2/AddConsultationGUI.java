package GUI_v2;

import consoleSystem_v2.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Random;

public class AddConsultationGUI extends MenuOptionControllerGUI {

    private final String os = System.getProperty("os.name");
    private Font font;
    private JLabel photoLbl,imageLbl,noteLbl,consultationTimeLbl,consultationDateLbl,doctorNameLbl,notyLbl,costLbl,patientIDLbl,addConsultationLbl,firstNameLbl,surnameLbl,dateOfBirthLbl,yearLbl,monthLbl,dayLbl,mobileNumberLbl;
    private JPanel wanPnl,wanAndSubPnl,imageLblPnl,noteTxtPnl,notePnl,doctorDetailsPnl,btnPnl,notyPnl,costPnl,otherPnl,patientIDPnl,addConsultationPnl,bodyPartPnl,patientDetailsPnl,firstNamePnl,surnamePnl,dateOfBirthPnl,yearPnl,monthPnl,dayPnl,mobileNumberPnl;
    private JTextField costTxt,patientIDTxt,firstNameTxt,surnameTxt,yearTxt,monthTxt,dayTxt,mobileNumberTxt;
    private JButton submitBtn,imageSelectBtn,checkBtn,clearBtn;
    private GridBagConstraints GBC;
    private JTextArea noteTxtAr;
    private JScrollPane noteSclPn;


    // Constructor
    AddConsultationGUI(int doctorPosition, Consultation consultation, SkinConsultationManager SCM) {
        // Set Window
        setWindow(600,685,"Add Consultation");

        // Set Empty Patient
        consultation.setPatient(new Patient());
        consultation.getPatient().setKey(generateSecretKey());

        // Set Body
        GUIBody(doctorPosition,consultation,SCM);

    }


    // Set Body
    private void GUIBody(int doctorPosition, Consultation consultation,SkinConsultationManager SCM) {

        // Set Main Menu Name
        addConsultationPnl = new JPanel(new FlowLayout());
        addConsultationPnl.setBackground(RGBColor);
        addConsultationLbl = new JLabel("Add Consultation");
        addConsultationLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        addConsultationPnl.add(addConsultationLbl);
        add("North",addConsultationPnl);

        // Main Body
        bodyPartPnl = new JPanel(new FlowLayout());
        bodyPartPnl.setBackground(RGBColor);
        font = new Font("SansSerif",Font.BOLD,14);


        // Doctor Details
        doctorDetailsPnl = new JPanel(new GridBagLayout());
        doctorDetailsPnl.setBackground(RGBColor);
        doctorDetailsPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,2), "Doctor Details"));
        doctorDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));
        GBC = new GridBagConstraints();

        // Doctor Name
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 0;
        doctorNameLbl = new JLabel("Doctor Name >   "+SCM.getDoctor(doctorPosition).getFullName());
        doctorNameLbl.setFont(font);
        doctorDetailsPnl.add(doctorNameLbl,GBC);
        GBC.insets = new Insets(5,15,5,20);
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
        patientDetailsPnl.setBackground(RGBColor);
        patientDetailsPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,2), "Patient Details"));
        patientDetailsPnl.setFont(new Font("SansSerif",Font.BOLD,14));

        // First name
        GBC.insets = new Insets(5,-55,5,0);
        GBC.gridx = 0;
        GBC.gridy = 0;
        firstNamePnl = new JPanel(new FlowLayout());
        firstNamePnl.setBackground(RGBColor);
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
        surnamePnl.setBackground(RGBColor);
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
        dateOfBirthPnl.setBackground(RGBColor);
        dateOfBirthLbl = new JLabel("Date Of Birth");
        dateOfBirthLbl.setFont(font);
        dateOfBirthPnl.add(dateOfBirthLbl);
        patientDetailsPnl.add(dateOfBirthPnl,GBC);

        // Year
        GBC.insets = new Insets(5,-280,5,0);
        GBC.gridx = 1;
        GBC.gridy = 1;
        yearPnl = new JPanel(new FlowLayout());
        yearPnl.setBackground(RGBColor);
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
        monthPnl.setBackground(RGBColor);
        monthLbl = new JLabel("M");
        monthLbl.setFont(font);
        monthPnl.add(monthLbl);
        monthTxt = new JTextField(3);
        monthTxt.setFont(font);
        monthPnl.add(monthTxt);
        patientDetailsPnl.add(monthPnl,GBC);
        // Date
        GBC.insets = new Insets(5,-100,5,115);
        GBC.gridx = 3;
        GBC.gridy = 1;
        dayPnl = new JPanel(new FlowLayout());
        dayPnl.setBackground(RGBColor);
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
        mobileNumberPnl.setBackground(RGBColor);
        mobileNumberLbl = new JLabel("Mobile Number");
        mobileNumberLbl.setFont(font);
        mobileNumberPnl.add(mobileNumberLbl);
        mobileNumberTxt = new JTextField(10);
        mobileNumberTxt.setFont(font);
        mobileNumberPnl.add(mobileNumberTxt);
        patientDetailsPnl.add(mobileNumberPnl,GBC);

        // Patient ID
        GBC.insets = new Insets(5,20,5,10);
        GBC.gridx = 1;
        GBC.gridy = 2;
        patientIDPnl = new JPanel(new FlowLayout());
        patientIDPnl.setBackground(RGBColor);
        patientIDLbl = new JLabel("Patient ID");
        patientIDLbl.setFont(font);
        patientIDPnl.add(patientIDLbl);
        patientIDTxt = new JTextField(6);
        patientIDTxt.setFont(font);
        patientIDPnl.add(patientIDTxt);
        patientDetailsPnl.add(patientIDPnl,GBC);
        bodyPartPnl.add(patientDetailsPnl);

        // Other Details
        otherPnl = new JPanel(new GridBagLayout());
        otherPnl.setBackground(RGBColor);
        otherPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,2), "Other Details"));
        otherPnl.setFont(new Font("SansSerif",Font.BOLD,14));

        // Cost
        GBC.insets = new Insets(5,5,0,0);
        GBC.gridx = 0;
        GBC.gridy = 0;
        costPnl = new JPanel(new FlowLayout());
        costPnl.setBackground(RGBColor);
        costLbl = new JLabel("Cost £ ");
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
        notyPnl.setBackground(RGBColor);
        notyLbl = new JLabel("£15 Per Hour Firs Time After £25");
        notyLbl.setFont(font);
        notyPnl.add(notyLbl);
        otherPnl.add(notyPnl,GBC);

        // Note
        GBC.insets = new Insets(0,5,0,0);
        GBC.gridx = 0;
        GBC.gridy = 1;
        notePnl = new JPanel(new FlowLayout());
        notePnl.setBackground(RGBColor);
        noteLbl = new JLabel("Extra Note");
        noteLbl.setFont(font);
        notePnl.add(noteLbl);
        otherPnl.add(notePnl,GBC);
        // Note Text Area
        GBC.insets = new Insets(0,10,0,2);
        GBC.gridx = 1;
        GBC.gridy = 1;
        noteTxtPnl = new JPanel(new FlowLayout());
        noteTxtPnl.setBackground(RGBColor);
        noteTxtAr = new JTextArea(4,30);
        noteTxtAr.setFont(font);
        noteSclPn = new JScrollPane(noteTxtAr);
        noteTxtPnl.add(noteSclPn);
        otherPnl.add(noteTxtPnl,GBC);

        // Image Input
        GBC.insets = new Insets(0,5,5,0);
        GBC.gridx = 0;
        GBC.gridy = 2;
        imageLblPnl = new JPanel(new FlowLayout());
        imageLblPnl.setBackground(RGBColor);
        imageLbl = new JLabel("Select Image");
        imageLbl.setFont(font);
        imageLblPnl.add(imageLbl);
        otherPnl.add(imageLblPnl,GBC);
        // Get Image Input
        GBC.insets = new Insets(0,-250,5,0);
        GBC.gridx = 1;
        GBC.gridy = 2;
        imageSelectBtn = new JButton("Select Image");
        imageSelectBtn.addActionListener( (e) -> {
            try {
                fileSelector(consultation.getPatient());
            } catch (IOException ex) {
                warningMassage("File Select Error !", "Warning");
            }
        });
        otherPnl.add(imageSelectBtn,GBC);
        GBC.insets = new Insets(0,-280,5,0);
        GBC.gridx = 2;
        GBC.gridy = 2;
        photoLbl = new JLabel();
        try {
            if (os.startsWith("Windows")) {
                photoLbl.setIcon(new ImageIcon(resizeImage(new File(".\\src\\Data\\Empty.jpg"),200,120)));
            } else if (os.startsWith("Mac")) {
                photoLbl.setIcon(new ImageIcon(resizeImage(new File(".\\src\\Data\\Empty.jpg"),200,120)));
            } else {
                photoLbl.setText("Image Is Not In Data Base Or Your OS Is Not Supported !");
            }

        } catch (Exception e) {
            warningMassage("Empty Image Is Not In Database !","Warning");
        }

        otherPnl.add(photoLbl,GBC);
        bodyPartPnl.add(otherPnl);

        // Submit Button
        wanAndSubPnl = new JPanel(new GridLayout(1,1));
        wanAndSubPnl.setBackground(RGBColor);
        btnPnl = new JPanel(new FlowLayout());
        btnPnl.setBackground(RGBColor);
        clearBtn = new JButton("Clear");
        clearBtn.setBackground(RGBColor2);
        clearBtn.setForeground(RGBColor3);
        clearBtn.setFont(font);
        clearBtn.addActionListener((e)-> {
            try {
                clearAddAction(consultation);
            } catch (IOException ex) {
                warningMassage("Clear Error !","Warning");
            }
        });
        clearBtn.addActionListener((e)->{});
        checkBtn = new JButton("Check");
        checkBtn.setBackground(RGBColor2);
        checkBtn.setForeground(RGBColor3);
        checkBtn.setFont(font);
        checkBtn.addActionListener((e)->checkBtnAddAction(SCM,consultation));
        submitBtn = new JButton("Submit");
        submitBtn.setBackground(RGBColor2);
        submitBtn.setForeground(RGBColor3);
        submitBtn.addActionListener( event -> submitAddAction(SCM,consultation,doctorPosition));
        submitBtn.setEnabled(false);
        submitBtn.setFont(font);
        btnPnl.add(clearBtn);
        btnPnl.add(checkBtn);
        btnPnl.add(submitBtn);
        wanAndSubPnl.add(btnPnl);


        add("Center",bodyPartPnl);
        add("South",wanAndSubPnl);
    }

    // File Selector
    private void fileSelector(Patient patient) throws IOException {

        boolean imageSelect = false;
        File file = null;

        // If Eny Image in already select then that image deletes and set new image
        if (patient.getSkinEncryptImage() != null) {
            // Delete old encrypt image
            try {
                file = new File(patient.getSkinEncryptImage());
            } catch (Exception e){
                // In Hear Haven't imaged It Will Happen Exception Now It Will Not Happen
            }
        }

        // This Programme Working With Windows And macOS

        if (os.startsWith("Windows")) { // Code to execute on Windows

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(".\\src\\Images"));
            int response = fileChooser.showOpenDialog(null); // Select File To Open

            // If Select Eny File It Will Return O If Cansel It Will Return 1
            if (response == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION or 0
                imageSelect = true;

                // Get File
                File imgFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                // Validate That File Is Image Or Not
                if (imageValidation(imgFile.getPath())) {

                    // Show Image File
                    photoLbl.setIcon(new ImageIcon(resizeImage(imgFile,200,120)));

                    // Encrypt Image
                    imageEncrypting(imgFile.getAbsolutePath(),patient);

                } else {
                    warningMassage("This Is Not Image !", "Warning");
                }
            }

        } else if (os.startsWith("Mac")) { // Code to execute on macOS

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("./src/Images"));
            int response = fileChooser.showOpenDialog(null); // Select File To Open

            // If Select Eny File It Will Return O If Cansel It Will Return 1
            if (response == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION or 0
                imageSelect = true;

                // Get File
                File imgFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                // Validate That File Is Image Or Not
                if (imageValidation(imgFile.getPath())) {

                    // Show Image File
                    photoLbl.setIcon(new ImageIcon(resizeImage(imgFile,200,120)));

                    // Encrypt Copy Image
                    imageEncrypting(imgFile.getAbsolutePath(),patient);

                } else {
                    warningMassage("This Is Not Image !", "Warning");
                }
            }

        } else {
            warningMassage("Try With Windows or MacOS !", "Warning");
        }

        if (imageSelect) {
            // Delete old encrypt image
            try {
                file.delete();
            } catch (Exception e){
                // In Hear Haven't imaged It Will Happen Exception Now It Will Not Happen
            }
        }
    }

    // Check Select File Is Image Or Not
    private boolean imageValidation(String imgPath){
        // Only Eligible File Types
        String[] extensions = {"jpg","jpeg","png"};
        File tempFile = new File(imgPath);
        boolean returnValue = false;

        // Check This Image Path Is Correct Or Not
        if (tempFile.exists()) { // If It Incorrect Return False
            String fileName = tempFile.getName();
            String fileExtension = "";

            // Get Last '.' Point Value For Get Extension
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
    private static BufferedImage resizeImage(File imageFile, int width, int height) throws IOException {

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
    private static String generateSecretKey(){
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        int randNum = random.nextInt(0,2);

        // This Secret Key Generate Will Simple Or Capital Secret Keys
        if (randNum == 0) {
            for (int i=0;i<16;i++) {
                randNum = random.nextInt(97,123);
                if(randNum == 92 || randNum == 47 || randNum == 46 || randNum == 34) {
                    key.append("!");
                } else {
                    key.append(String.valueOf((char)randNum));
                }
            }

        } else {
            for (int i=0;i<16;i++) {
                randNum = random.nextInt(65,91);
                if(randNum == 92 || randNum == 47 || randNum == 46 || randNum == 34) {
                    key.append("!");
                } else {
                    key.append(String.valueOf((char)randNum));
                }
            }
        }

        return key.toString();
    }

    // Image Encrypting
    private void imageEncrypting(String absolutePath,Patient patient) throws IOException {

        // This Programme Working With Windows And macOS
        String key = patient.getKey();
        String imgName = generateSecretKey();

        if (os.startsWith("Windows")) { // Code to execute on Windows
            try {

                FileInputStream in = new FileInputStream(absolutePath);
                // In Hear Encrypt Image name Is No Point
                // Then No One Can Understand What Patient Skin Image Is This
                FileOutputStream out = new FileOutputStream(".\\src\\Data\\"+imgName+".jpg");

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
                patient.setSkinEncryptImage(".\\src\\Data\\"+imgName+".jpg");
                patient.setKey(key);

            } catch (Exception e){
                photoLbl.setIcon(new ImageIcon(resizeImage(new File(".\\src\\Data\\Empty.jpg"),200,120)));
                warningMassage("Select Image Again !", "Warning");
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
                photoLbl.setIcon(new ImageIcon(resizeImage(new File("./src/Data/Empty.jpg"),200,120)));
                warningMassage("Select Image Again !", "Warning");
            }
        }
    }

    // Check Button Add Action Listener
    private void checkBtnAddAction(SkinConsultationManager SCM, Consultation consultation){

        Validations validations = new Validations();

        if (validations.nameValidator(firstNameTxt.getText(),0)) {
            if (validations.nameValidator(surnameTxt.getText(),0)) {
                if (validations.ageValidatorForPatient(yearTxt.getText(),monthTxt.getText(),dayTxt.getText())) {
                    if (validations.mobileNumberValidator(mobileNumberTxt.getText())) {
                        if (!patientIDTxt.getText().equals("")) {

                            // Date Validation
                            // If the user will enter a single number this code line will set that number with 0
                            // Because LocalDate requests values like this (2022-12-24)
                            if (Integer.parseInt(monthTxt.getText()) < 10 || Integer.parseInt(dayTxt.getText()) < 10) {
                                monthTxt.setText((monthTxt.getText().length() != 2) ? "0"+monthTxt.getText() : monthTxt.getText());
                                dayTxt.setText((dayTxt.getText().length() != 2) ? "0"+dayTxt.getText() : dayTxt.getText());
                            }

                            // Check All Patients List
                            int response = -1;
                            boolean patientIDCheck = false;
                            for (int i=0;i<SCM.getPatients().size();i++) {
                                if (SCM.getPatient(i).getPatientID().equals(patientIDTxt.getText())) {
                                    patientIDCheck = true;
                                    response = JOptionPane.showConfirmDialog(null,
                                            "This patient ID already exist\ndo you want to continue with that patient",
                                            "Conformation",
                                            JOptionPane.YES_NO_OPTION);
                                    if (response == 0) {

                                        firstNameTxt.setText(SCM.getPatient(i).getName());
                                        surnameTxt.setText(SCM.getPatient(i).getSurname());
                                        try {
                                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
                                            yearTxt.setText(String.format(SCM.getPatient(i).getDateOfBirth().format(formatter)));
                                            formatter = DateTimeFormatter.ofPattern("MM");
                                            monthTxt.setText(String.format(SCM.getPatient(i).getDateOfBirth().format(formatter)));
                                            formatter = DateTimeFormatter.ofPattern("dd");
                                            dayTxt.setText(String.format(SCM.getPatient(i).getDateOfBirth().format(formatter)));

                                        } catch (Exception e) {
                                            warningMassage("Data Getting Error !", "Warning");
                                        }
                                        mobileNumberTxt.setText(SCM.getPatient(i).getMobileNumber());

                                        firstNameTxt.setEditable(false);
                                        firstNameTxt.setBackground(Color.LIGHT_GRAY);
                                        surnameTxt.setEditable(false);
                                        surnameTxt.setBackground(Color.LIGHT_GRAY);
                                        yearTxt.setEditable(false);
                                        yearTxt.setBackground(Color.LIGHT_GRAY);
                                        monthTxt.setEditable(false);
                                        monthTxt.setBackground(Color.LIGHT_GRAY);
                                        dayTxt.setEditable(false);
                                        dayTxt.setBackground(Color.LIGHT_GRAY);
                                        mobileNumberTxt.setEditable(false);
                                        mobileNumberTxt.setBackground(Color.LIGHT_GRAY);
                                        patientIDTxt.setEditable(false);
                                        patientIDTxt.setBackground(Color.LIGHT_GRAY);

                                        // Check Cost And Set
                                        notyLbl.setText("£25 Per Hour :  h"+consultation.getRequestedTime()+"  x  £25  =  £"+(consultation.getRequestedTime()*25));
                                        submitBtn.setEnabled(true);
                                    }
                                    break;
                                }
                            }

                            if (!patientIDCheck) {
                                // Check Cost And Set
                                notyLbl.setText("£15 Per Hour :  h"+consultation.getRequestedTime()+"  x  £15  =  £"+(consultation.getRequestedTime()*15));
                                patientIDTxt.setEditable(false);
                                submitBtn.setEnabled(true);
                            }

                            // This will set cost automatically
                            if (!costTxt.getText().equals("")) {
                                if(!patientIDCheck) {
                                    costTxt.setText(""+consultation.getRequestedTime() * 15);
                                } else {
                                    costTxt.setText(""+consultation.getRequestedTime() * 25);
                                }
                            }

                        } else {
                            warningMassage("Enter Patient ID !","Warning");
                        }
                    } else {
                        warningMassage("Enter Mobile Number Correctly !","Warning");
                    }
                } else {
                    warningMassage("Enter Age Correctly \nIt Must Be In Today And Before 125 Years !","Warning");
                }
            } else {
                warningMassage("Enter Surname Name Correctly !","Warning");
            }
        } else {
            warningMassage("Enter First Name Correctly !","Warning");
        }
    }

    // Submit Button Add Action Listener
    private void submitAddAction(SkinConsultationManager SCM,Consultation consultation,int doctorPosition){

        Validations validations = new Validations();

        if (validations.nameValidator(firstNameTxt.getText(),0)) {
            if (validations.nameValidator(surnameTxt.getText(),0)) {
                if (validations.ageValidatorForPatient(yearTxt.getText(),monthTxt.getText(),dayTxt.getText())) {
                    if (validations.mobileNumberValidator(mobileNumberTxt.getText())) {
                        if (!patientIDTxt.getText().equals("")) {
                            if (!costTxt.getText().equals("")) {

                                // Date Validation
                                // If the user will enter a single number this code line will set that number with 0
                                // Because LocalDate requests values like this (2022-12-24)
                                if (Integer.parseInt(monthTxt.getText()) < 10 || Integer.parseInt(dayTxt.getText()) < 10) {
                                    monthTxt.setText((monthTxt.getText().length() != 2) ? "0"+monthTxt.getText() : monthTxt.getText());
                                    dayTxt.setText((dayTxt.getText().length() != 2) ? "0"+dayTxt.getText() : dayTxt.getText());
                                }

                                boolean checkID = false;
                                for (int i=0;i<SCM.getPatients().size();i++) {
                                    if (SCM.getPatient(i).getPatientID().equals(patientIDTxt.getText())) {
                                        checkID = true;
                                        // Create New Patient And Set All Details With In to Consultation
                                        Patient patient = new Patient(SCM.getPatient(i));
                                        try {
                                            patient.setKey(consultation.getPatient().getKey());
                                            patient.setSkinEncryptImage(consultation.getPatient().getSkinEncryptImage());
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "You Can Add Patient Skin Image To",
                                                    "Information",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        consultation.setPatient(patient);
                                        try {
                                            consultation.setCost(Integer.parseInt(costTxt.getText()));
                                            consultation.setNote(textEncrypting(noteTxtAr.getText(),
                                                    consultation.getPatient().getKey()));
                                        } catch (Exception e){
                                            warningMassage("Enter Cost Correctly !","Warning");
                                        }
                                        SCM.getDoctor(doctorPosition).setConsultation(consultation);

                                        // Successfully Massage
                                        JOptionPane.showMessageDialog(null,
                                                "Consultation Is Added Successfully",
                                                "Successfully",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        dispose();
                                        break;
                                    }
                                }

                                if (!checkID) {
                                    // Set All Consultation Details And Patient Details
                                    consultation.getPatient().setName(firstNameTxt.getText());
                                    consultation.getPatient().setSurname(surnameTxt.getText());
                                    try {
                                        LocalDate DOB = LocalDate.parse(yearTxt.getText()+"-"+monthTxt.getText()+"-"+dayTxt.getText());
                                        consultation.getPatient().setDateOfBirth(DOB);
                                        checkID = true;
                                    } catch (Exception e) {
                                        warningMassage("Enter Date Of Birth Correctly !","Warning");
                                    }
                                    consultation.getPatient().setMobileNumber(mobileNumberTxt.getText());
                                    consultation.getPatient().setPatientID(patientIDTxt.getText());
                                    consultation.setCost(Double.parseDouble(costTxt.getText()));
                                    try {
                                        consultation.setNote(textEncrypting(noteTxtAr.getText(),
                                                consultation.getPatient().getKey()));
                                    } catch (Exception e) {
                                        consultation.setNote(noteTxtAr.getText());
                                    }
                                    SCM.getDoctor(doctorPosition).setConsultation(consultation);

                                    if (checkID) {
                                        // Set New Patient In To WestminsterSkinConsultationManager Main Patient Array List
                                        Patient patient = new Patient(consultation.getPatient());
                                        SCM.setPatient(patient);

                                        // Successfully Massage
                                        JOptionPane.showMessageDialog(null,
                                                "Consultation Is Added Successfully",
                                                "Successfully",JOptionPane.INFORMATION_MESSAGE);
                                        dispose();
                                    }
                                }

                            } else {
                                warningMassage("Enter Cost Correctly !","Warning");
                            }
                        } else {
                            warningMassage("Enter Patient ID !","Warning");
                        }
                    } else {
                        warningMassage("Enter Mobile Number Correctly !","Warning");
                    }
                } else {
                    warningMassage("Enter Age Correctly \nIt Must Be In Today And Before 125 Years !","Warning");
                }
            } else {
                warningMassage("Enter Surname Name Correctly !","Warning");
            }
        } else {
            warningMassage("Enter First Name Correctly !","Warning");
        }

    }

    // Clear Button Action Listener
    private void clearAddAction(Consultation consultation) throws IOException {

        int response = JOptionPane.showConfirmDialog(null,
                "Are You Sure \nYou Want To Clear This",
                "Conformation",
                JOptionPane.YES_NO_OPTION);

        if (response == 0) {

            // Clear first name
            firstNameTxt.setText("");
            firstNameTxt.setEditable(true);
            firstNameTxt.setBackground(Color.WHITE);

            // Clear surname
            surnameTxt.setText("");
            surnameTxt.setEditable(true);
            surnameTxt.setBackground(Color.WHITE);

            // Clear year
            yearTxt.setText("");
            yearTxt.setEditable(true);
            yearTxt.setBackground(Color.WHITE);

            // Clear month
            monthTxt.setText("");
            monthTxt.setEditable(true);
            monthTxt.setBackground(Color.WHITE);

            // Clear date
            dayTxt.setText("");
            dayTxt.setEditable(true);
            dayTxt.setBackground(Color.WHITE);

            // Clear mobile number
            mobileNumberTxt.setText("");
            mobileNumberTxt.setEditable(true);
            mobileNumberTxt.setBackground(Color.WHITE);

            // Clear ID
            patientIDTxt.setText("");
            patientIDTxt.setEditable(true);
            patientIDTxt.setBackground(Color.WHITE);

            // Clear cost
            costTxt.setText("");

            // Set default
            notyLbl.setText("£15 Per Hour Firs Time After £25");

            // Clear note
            noteTxtAr.setText("");

            // Set default
            submitBtn.setEnabled(false);

            // Delete encrypt image
            try {
                File file = new File(consultation.getPatient().getSkinEncryptImage());
                file.delete();
            } catch (Exception e){
                // In Hear Haven't imaged It Will Happen Exception Now It Will Not Happen
            }

            // Clear encrypt image
            consultation.getPatient().setSkinEncryptImage(null);

            // Set default image
            if (os.startsWith("Windows")) {
                photoLbl.setIcon(new ImageIcon(resizeImage(new File(".\\src\\Data\\Empty.jpg"),200,120)));
            } else if (os.startsWith("Mac")) {
                photoLbl.setIcon(new ImageIcon(resizeImage(new File("./src/Data/Empty.jpg"),200,120)));
            }

        }
    }

    // Encrypting Text
    private String textEncrypting(String txt,String key) throws Exception {

        Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = cipher.doFinal(txt.getBytes());

        return Base64.getEncoder().encodeToString(ciphertext);
    }

    @Override
    public String getOptionName() {
        return null;
    }
    @Override
    public String getOptionNumber() {
        return null;
    }

}
