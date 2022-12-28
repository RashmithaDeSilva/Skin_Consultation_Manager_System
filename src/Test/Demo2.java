package Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.Random;

public class Demo2 extends JFrame {
    public void frame(){
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
    private static void imageEncrypting(File img){
        Random random = new Random();
        int generateRandomEncryptKey = random.nextInt(2,5);

        char[] imgCharArray = img.getAbsolutePath().toCharArray();
        for (char c: imgCharArray) {

        }

    }


    public static void main(String[] args) {
        new Demo2().frame();
    }
}
