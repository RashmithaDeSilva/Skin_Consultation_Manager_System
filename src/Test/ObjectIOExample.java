package Test;

import java.io.*;

public class ObjectIOExample {
    public static void main(String[] args) {
        String filename = "object.txt";

        // Create an object to save
        MyObject obj = new MyObject();
        obj.setField1("hello");
        obj.setField2(123);
        obj.a.name = "Rashmitha";
        obj.a.age = 22;

        // Save the object to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(obj);
        } catch (IOException e) {
            System.out.println(e);
        }

        // Load the object from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            MyObject obj2 = (MyObject) in.readObject();
            System.out.println(obj2.getField1());  // prints "hello"
            System.out.println(obj2.getField2());  // prints 123
            System.out.println(obj2.a.name); // Lahiru
            System.out.println(obj2.a.age); // 22
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}

class A implements Serializable{
    String name;
    int age;
}
class MyObject implements Serializable {
    private String field1;
    private int field2;
     A a = new A();


    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }
}