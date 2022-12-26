package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "MY-SECRET-KEY".getBytes();

    public static byte[] encrypt(byte[] data) throws Exception {
        Key key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static void encryptAndSaveImage(String imageFile, String textFile) throws Exception {
        // Read the image file into a byte array
        File file = new File(imageFile);
        int length = (int) file.length();
        byte[] imageData = new byte[length];
        try (FileInputStream in = new FileInputStream(file)) {
            in.read(imageData);
        }

        // Encrypt the image data
        byte[] encryptedData = encrypt(imageData);

        // Write the encrypted data to the text file
        try (FileWriter out = new FileWriter(textFile)) {
            for (byte b : encryptedData) {
                out.write(b);
            }
        }
    }
}
