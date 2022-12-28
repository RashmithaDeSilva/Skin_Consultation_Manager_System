package Test;

import java.io.*;

public class Image implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        se();
        File file = de();

        System.out.println(file.getAbsolutePath());


    }

    public static void se() throws IOException {
        File file = new File("D:\\CS\\2nd Year\\1 Sem\\OOP\\CW\\w1911221_CW_2ndYear\\src\\Images\\FB_IMG_1637932993891.jpg");

        FileOutputStream fileOutputStream = new FileOutputStream("Test.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(file);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("Successful !");
    }

    public static File de() throws IOException, ClassNotFoundException {
        File file = null;

        FileInputStream fileInputStream = new FileInputStream(".\\src\\Image");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        file = (File) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println(" Ok ");
        return file;

    }

}
