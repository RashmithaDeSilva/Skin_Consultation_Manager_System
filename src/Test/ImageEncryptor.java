package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ImageEncryptor {

    public static void main(String[] args) throws Exception {
        String key = "Your secret key"; // needs to be at least 16 characters for AES

        // encrypt the image
        FileInputStream in = new FileInputStream("plainimage.jpg");
        FileOutputStream out = new FileOutputStream("encryptedimage.jpg");

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

        // decrypt the image
        FileInputStream in2 = new FileInputStream("encryptedimage.jpg");
        FileOutputStream out2 = new FileOutputStream("decryptedimage.jpg");

        Key secretKey2 = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher2 = Cipher.getInstance("AES");
        cipher2.init(Cipher.DECRYPT_MODE, secretKey2);

        byte[] input2 = new byte[64];
        int bytesRead2;
        while ((bytesRead2 = in2.read(input2)) != -1) {
            byte[] output2 = cipher2.update(input2, 0, bytesRead2);
            if (output2 != null)
                out2.write(output2);
        }

        byte[] output2 = cipher2.doFinal();
        if (output2 != null)
            out2.write(output2);

        in2.close();
        out2.flush();
        out2.close();
    }
}
