package Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.Key;
import java.util.Random;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File(".\\src\\Images\\s001.jpg");
        //imageEncryption(file,"@bs2rox94na52-;+","s002.jpg");
        //imageDecryption(file,"@bs2rox94na52-;+","s002.jpg");
        //file.delete();



    }

    // Secret Key Generate
    public static String generateSecretKey(){
        Random random = new Random();
        String key = "";
        for (int i=0;i<16;i++) {
            key += (char)random.nextInt(32,127);
        }
        return key;
    }

    // Image Encryption
    public static void imageEncryption(File file,String key,String encryptName) {
        // Key Needs To Be At Least 16 Characters For AES
        try {

            FileInputStream in = new FileInputStream(file.getAbsolutePath());
            FileOutputStream out = new FileOutputStream(".\\src\\Data\\"+encryptName+"p.jpg");

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

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void imageDecryption(File file,String key,String encryptName){
        try {
            FileInputStream in = new FileInputStream(".\\src\\Data\\"+encryptName+".jpg");
            FileOutputStream out = new FileOutputStream(".\\src\\Data\\1111"+encryptName+".jpg");

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

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
