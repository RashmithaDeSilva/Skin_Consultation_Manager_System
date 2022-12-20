package GUI;

import java.util.AbstractList;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
       String name = "Lahiru",name2 = "Rashmitha",name3 = "Lahiru";
       String a = "A", b = "B";

        AbstractList<String> d = new ArrayList<>(10);
        d.add(name);d.add(name2);d.add(name3);d.add("kavindu");d.add("Akila");

        for (int i=0;i<d.size()-1;i++) {
            for (int j=0;j<d.size();j++) {
                if (d.get(i).compareToIgnoreCase(d.get(i+1)) > 0) {
                    String temp = d.get(i);
                    d.set(i,d.get(i+1));
                    d.set((i+1),temp);
                }
            }
        }

        System.out.println(d);





    }
}
