package GUI_v2;

import consoleSystem_v2.Doctor;
import consoleSystem_v2.Patient;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;

public class AllDetailsGUI extends MenuOptionControllerGUI{

    private final String os = System.getProperty("os.name");
    private JPanel allConsultationDetailsPnl;
    private JLabel allConsultationDetailsLbl;
    private GridBagConstraints GBC;
    private Font font;
    private JPanel btnPnl,patientDetailsPnl,bodyPnl,doctorDetailsPnl,consultationDetailsPnl;
    private JLabel patientSkinImageLbl,imageNameLbl,patientMobileNumberLbl,patientDOBLbl,patientIDLbl,patientFullNameLbl,consultationNote,consultationCostLbl,consultationTimeLbl,consultationStartTimeLbl,consultationDateLbl,doctorFullNameLbl,doctorContactNumberLbl,doctorSpecialisationLbl;
    private JTextArea consultationNoteTxtAr;
    private JScrollPane consultationNoteSclPn;
    private File image;
    private JButton deleteBtn;


    public AllDetailsGUI(Doctor doctor,int consultationPosition,ConsultationDetailsGUI CDGUI) {
        // Set Window
        setWindow(600,685,"Consultation Details");

        // Set Body
        setBody(doctor,consultationPosition,CDGUI);
    }

    private void setBody(Doctor doctor,int consultationPosition,ConsultationDetailsGUI CDGUI){

        // Set Main Menu Name
        allConsultationDetailsPnl = new JPanel(new FlowLayout());
        allConsultationDetailsPnl.setBackground(RGBColor);
        allConsultationDetailsLbl = new JLabel("All Consultation Details");
        allConsultationDetailsLbl.setFont(new Font("SansSerif",Font.BOLD,25));
        allConsultationDetailsPnl.add(allConsultationDetailsLbl);
        add("North",allConsultationDetailsPnl);

        font = new Font("SansSerif",Font.BOLD,14);
        bodyPnl =new JPanel(new FlowLayout());
        bodyPnl.setBackground(RGBColor);

        // Doctor Details
        doctorDetailsPnl = new JPanel(new GridBagLayout());
        doctorDetailsPnl.setBackground(RGBColor);
        doctorDetailsPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,2), "Doctor Details"));
        doctorDetailsPnl.setFont(font);
        GBC = new GridBagConstraints();
        // Doctor Name
        GBC.insets = new Insets(5,100,5,100);
        GBC.gridx = 0;
        GBC.gridy = 0;
        doctorFullNameLbl = new JLabel("Doctor Name > Dr "+doctor.getFullName());
        doctorFullNameLbl.setFont(font);
        doctorDetailsPnl.add(doctorFullNameLbl,GBC);
        // Contact Number
        GBC.insets = new Insets(5,100,5,100);
        GBC.gridx = 0;
        GBC.gridy = 1;
        doctorContactNumberLbl = new JLabel("Contact Number > "+doctor.getMobileNumber());
        doctorContactNumberLbl.setFont(font);
        doctorDetailsPnl.add(doctorContactNumberLbl,GBC);
        // Specialisation
        GBC.insets = new Insets(5,100,5,100);
        GBC.gridx = 0;
        GBC.gridy = 2;
        doctorSpecialisationLbl = new JLabel("Specialisation > "+doctor.getSpecialisation());
        doctorSpecialisationLbl.setFont(font);
        doctorDetailsPnl.add(doctorSpecialisationLbl,GBC);
        bodyPnl.add(doctorDetailsPnl);

        // Consultation Details
        consultationDetailsPnl = new JPanel(new GridBagLayout());
        consultationDetailsPnl.setBackground(RGBColor);
        consultationDetailsPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,2), "Consultation Details"));
        consultationDetailsPnl.setFont(font);
        //Consultation Date
        GBC.insets = new Insets(5,5,5,70);
        GBC.gridx = 0;
        GBC.gridy = 0;
        consultationDateLbl = new JLabel("Consultation Date > " + doctor.getConsultation(consultationPosition).getDate());
        consultationDateLbl.setFont(font);
        consultationDetailsPnl.add(consultationDateLbl,GBC);
        // Consultation Start Time
        GBC.insets = new Insets(5,5,5,10);
        GBC.gridx = 1;
        GBC.gridy = 0;
        consultationStartTimeLbl = new JLabel("Consultation Start Time > " + doctor.getConsultation(consultationPosition).getConsultationStartTime());
        consultationStartTimeLbl.setFont(font);
        consultationDetailsPnl.add(consultationStartTimeLbl,GBC);
        // Consultation Requested Time
        GBC.insets = new Insets(5,5,5,55);
        GBC.gridx = 0;
        GBC.gridy = 1;
        consultationTimeLbl = new JLabel("Consultation Requested Time > " + doctor.getConsultation(consultationPosition).getRequestedTime());
        consultationTimeLbl.setFont(font);
        consultationDetailsPnl.add(consultationTimeLbl,GBC);
        // Consultation Cost
        GBC.insets = new Insets(5,-33,5,5);
        GBC.gridx = 1;
        GBC.gridy = 1;
        consultationCostLbl = new JLabel("Consultation Cost > £ " + doctor.getConsultation(consultationPosition).getCost());
        consultationCostLbl.setFont(font);
        consultationDetailsPnl.add(consultationCostLbl,GBC);
        // Extra Note
        GBC.insets = new Insets(5,-185,5,5);
        GBC.gridx = 0;
        GBC.gridy = 2;
        consultationNote = new JLabel("Extra Note > ");
        consultationNote.setFont(font);
        consultationDetailsPnl.add(consultationNote,GBC);
        // Extra Note Text Area
        GBC.insets = new Insets(5,-220,5,5);
        GBC.gridx = 1;
        GBC.gridy = 2;
        consultationNoteTxtAr = new JTextArea(4,30);
        try {
            consultationNoteTxtAr.setText(textDecrypting(
                    doctor.getConsultation(consultationPosition).getNote(),
                    doctor.getConsultation(consultationPosition).getPatient().getKey()
            ));
        } catch (Exception e) {
            consultationNoteTxtAr.setText(doctor.getConsultation(consultationPosition).getNote());
        }
        consultationNoteTxtAr.setFont(font);
        consultationNoteTxtAr.setEnabled(false);
        consultationNoteSclPn = new JScrollPane(consultationNoteTxtAr);
        consultationDetailsPnl.add(consultationNoteSclPn,GBC);
        bodyPnl.add(consultationDetailsPnl);

        // Patient Details
        patientDetailsPnl = new JPanel(new GridBagLayout());
        patientDetailsPnl.setBackground(RGBColor);
        patientDetailsPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,2), "Patient Details"));
        patientDetailsPnl.setFont(font);
        GBC.insets = new Insets(5,5,5,-80);
        // Patient Name
        GBC.gridx = 0;
        GBC.gridy = 0;
        patientFullNameLbl = new JLabel("Patient Name > "+doctor.getConsultation(consultationPosition).getPatient().getFullName());
        patientFullNameLbl.setFont(font);
        patientDetailsPnl.add(patientFullNameLbl,GBC);
        GBC.insets = new Insets(5,5,5,-70);
        // Patient ID
        GBC.gridx = 1;
        GBC.gridy = 0;
        patientIDLbl = new JLabel("Patient ID > "+doctor.getConsultation(consultationPosition).getPatient().getPatientID());
        patientIDLbl.setFont(font);
        patientDetailsPnl.add(patientIDLbl,GBC);
        GBC.insets = new Insets(5,5,5,-80);
        // Patient Date Of Birth
        GBC.gridx = 0;
        GBC.gridy = 1;
        patientDOBLbl = new JLabel("Patient Date Of Birth > " + doctor.getConsultation(consultationPosition).getPatient().getDateOfBirth());
        patientDOBLbl.setFont(font);
        patientDetailsPnl.add(patientDOBLbl,GBC);
        // Patient Mobile Number
        GBC.insets = new Insets(5,5,5,-110);
        GBC.gridx = 0;
        GBC.gridy = 2;
        patientMobileNumberLbl = new JLabel("Patient Mobile Number > "+doctor.getConsultation(consultationPosition).getPatient().getMobileNumber());
        patientMobileNumberLbl.setFont(font);
        patientDetailsPnl.add(patientMobileNumberLbl,GBC);
        // Image Name
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 0;
        GBC.gridy = 3;
        imageNameLbl = new JLabel("Skin Image > ");
        imageNameLbl.setFont(font);
        patientDetailsPnl.add(imageNameLbl,GBC);
        // Image
        GBC.insets = new Insets(5,5,5,5);
        GBC.gridx = 1;
        GBC.gridy = 3;
        patientSkinImageLbl = new JLabel();
        try {
            // Decryption Patient Skin Image and Resize And Set It In Window
            image = imageDecryption(doctor.getConsultation(consultationPosition).getPatient());
            if (image != null) {
                patientSkinImageLbl.setIcon(new ImageIcon(resizeImage(image,300,120)));
            } else {
                // If Patient have Not Imaged It Will Set Default Image
                if (os.startsWith("Windows")) {
                    image = new File(".\\src\\Data\\Empty.jpg");
                } else if (os.startsWith("Mac")) {
                    image = new File("./src/Data/Empty.jpg");
                }
                patientSkinImageLbl.setIcon(new ImageIcon(resizeImage(image,300,120)));
            }
        } catch (Exception e) {
            // If Patient Image Is Note In Data Base It Will Show This
            patientSkinImageLbl.setText("This Image Is Not in Data Base");
        }
        patientDetailsPnl.add(patientSkinImageLbl,GBC);
        bodyPnl.add(patientDetailsPnl);

        // After Show Delete Temp Image
        if (!image.getName().equals("Empty.jpg")) {
            image.delete();
        }
        add(bodyPnl);

        // Delete Button
        btnPnl = new JPanel(new FlowLayout());
        btnPnl.setBackground(RGBColor);
        deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(RGBColor2);
        deleteBtn.setForeground(RGBColor3);
        deleteBtn.setFont(font);
        deleteBtn.addActionListener((e) -> {
            int response = JOptionPane.showConfirmDialog(null,
                    "Are You Sure\nDo You Want To Delete This Consultation !",
                    "Conformation",
                    JOptionPane.YES_NO_OPTION);
            if (response == 0) { // 0 = Yes
                CDGUI.dispose();
                dispose();
                new File(doctor.getConsultation(consultationPosition).getPatient().getSkinEncryptImage()).delete();
                doctor.getConsultationsArrayList().remove(consultationPosition);
            }
        });
        btnPnl.add(deleteBtn);
        add("South",btnPnl);
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
    private static String generateSecretKey(){

        Random random = new Random();
        StringBuilder key = new StringBuilder();
        int randNum = random.nextInt(0,2);

        // This Secret Key Generate Will Generate Simple Or Capital Secret Keys
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

    // Image Decrypting
    private File imageDecryption(Patient patient){
        String encryptName = patient.getSkinEncryptImage();
        String key = patient.getKey();
        String newTempName = generateSecretKey();

        FileInputStream in;
        FileOutputStream out;
        File file = null;

        // This Programme Run With Windows And Mac

        try {

            if (os.startsWith("Windows")) { // Windows Part

                in = new FileInputStream(encryptName);
                out = new FileOutputStream(".\\src\\Data\\"+newTempName+".jpg");

                Key secretKey2 = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher2 = Cipher.getInstance("AES");
                cipher2.init(Cipher.DECRYPT_MODE, secretKey2);

                byte[] input2 = new byte[64];
                int bytesRead2;
                while ((bytesRead2 = in.read(input2)) != -1) {
                    byte[] output2 = cipher2.update(input2, 0, bytesRead2);
                    if (output2 != null)
                        out.write(output2);
                }

                byte[] output2 = cipher2.doFinal();
                if (output2 != null)
                    out.write(output2);

                in.close();
                out.flush();
                out.close();
                file = new File(".\\src\\Data\\"+newTempName+".jpg");

            } else if (os.startsWith("Mac")) { // Mac Part

                in = new FileInputStream(encryptName);
                out = new FileOutputStream("./src/Data/"+newTempName+".jpg");

                Key secretKey2 = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher2 = Cipher.getInstance("AES");
                cipher2.init(Cipher.DECRYPT_MODE, secretKey2);

                byte[] input2 = new byte[64];
                int bytesRead2;
                while ((bytesRead2 = in.read(input2)) != -1) {
                    byte[] output2 = cipher2.update(input2, 0, bytesRead2);
                    if (output2 != null)
                        out.write(output2);
                }

                byte[] output2 = cipher2.doFinal();
                if (output2 != null)
                    out.write(output2);

                in.close();
                out.flush();
                out.close();
                file = new File("./src/Data/"+newTempName+".jpg");
            }

        } catch (Exception e) {

        }
        return file;
    }

    // Text Decrypting
    private String textDecrypting(String encodedCiphertext, String key) throws Exception {

        Key Key = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, Key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encodedCiphertext));

        return new String(decrypted);
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
