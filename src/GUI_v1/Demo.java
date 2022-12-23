package GUI_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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

        LocalDate da1 = LocalDate.of(2022,12,02);
        LocalDate da2 = LocalDate.parse("2022-12-02");
        //System.out.println(da1.equals(da2));

        LocalTime lT = LocalTime.of(23,00);
        LocalTime lT2 = LocalTime.of(23,45);
        System.out.println(lT.compareTo(lT2));

        SimpleDateFormat dateForm = new SimpleDateFormat("yyyy");
        Date today = new Date();
        String  thisYear = String.valueOf(dateForm.format(today));
        System.out.println(thisYear);
        //System.out.println(127/60);
        abc();







    }

    private static JComboBox<String> comboBox;
    public static void abc(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,800);
        jFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 3
        jFrame.setLayout(new GridLayout(3,1));

        String[] cb = {"AM or PM","AM","PM"};
        comboBox = new JComboBox<>(cb);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();
                System.out.println(index);
            }
        });



        //jFrame.add(comboBox);

        // Note
        //JPanel Pnl = new JPanel(new FlowLayout());
        JPanel notePnl = new JPanel(new GridLayout(1,3));
        notePnl.add(new JLabel("          "));
        JTextArea noteTxtAr = new JTextArea(5,10);
        noteTxtAr.setFont(new Font("SansSerif",Font.BOLD,12));
        JScrollPane noteSP = new JScrollPane(noteTxtAr,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        noteSP.setBorder(BorderFactory.createTitledBorder("Note"));

        notePnl.add(noteSP);
        notePnl.add(new JLabel("            "));
        jFrame.add(new JButton("AJjhSKJJ"));
        jFrame.add(notePnl);


        jFrame.setVisible(true);





    }

}
