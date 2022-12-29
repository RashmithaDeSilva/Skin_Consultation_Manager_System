package Test;

import GUI_v2.AddConsultationGUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;

public class Demo2 extends JFrame {
    public void frame() {
        setSize(300,300);
        setLayout(new FlowLayout());
        JButton btn = new JButton("Add Image");
        JLabel wan = new JLabel("Select Img");
        btn.addActionListener( (e) -> btnAddActionListener());

        add(btn);
        setVisible(true);
    }

    public void btnAddActionListener(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".\\src\\Images"));
        int response = fileChooser.showOpenDialog(null); // Select File To Open

        // If Select Eny File It Will Return O If Cansel It Will Return 1
        if (response == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION or 0

            File originalFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            if (imageValidation(originalFile.getPath())) {

                String ID = "s001";
                File copyFile = new File(".\\src\\Images\\"+ID+".jpg");

                try {
                    // Create New Copy
                    Files.copy(originalFile.toPath(),copyFile.toPath());
                } catch (Exception e) {
                    System.out.println("This Image Already Exist .....!");
                }

                //imageEncrypting(copyFile)

            } else {
                System.out.println("This Is Not Image .....!");
            }
        }

    }

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

    // Encrypting
    private static String generateSecretKey(){
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        for (int i=0;i<16;i++) {
            int randNum = random.nextInt(32,127);
            if(randNum == 92 || randNum == 47 || randNum == 46) {
                System.out.println((char) randNum);
                key.append("!");
                System.out.println(key.toString());
            } else {

                key.append(String.valueOf((char)randNum));
            }
        }
        return key.toString();
    }


    public static void main(String[] args) {
        //new Demo2().frame();
        for (int i=0;i<100;i++) {
            generateSecretKey();
        }

        //3+uKs'_!']G_-Q&!
        //Ryv9a(>+8jd+?54
        // #_3M`}Xez*N-dur[
        // C[)Mi_?Mm0%z-FTl

    }



}
