package uppgift8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gui extends JFrame implements ActionListener {
    public static  JTextArea area = new JTextArea(20,40);
    JTextField t = new JTextField(40);
    JTextField name = new JTextField("Name", 10);
    MulticastSender ms;

    MulticastReceiver mr;
    JButton buttonOne = new JButton("          Koppla ner          "); //Creating button
    public Gui(MulticastSender ms, MulticastReceiver mr){
        this.ms = ms;
        this.mr = mr;
        name.addActionListener(this);


        buttonOne.addActionListener(this);

        setTitle("Klass Chatt");
        JPanel p = new JPanel();
        this.add(p);
        p.add(name);
        p.add(buttonOne);
        p.add(area);
        p.add(t); // adding textfield to the panel
        String txt = t.getText();
        t.addActionListener(this);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == t){
            System.out.println(t.getText());
            try {
                ms.MulticastSend(name.getText() + ": " + t.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            t.setText("");
        } else if (e.getSource() == buttonOne) {
            System.out.println("disconneted");
            mr.interrupt();
            mr.disconnet();
            ms.close();
            t.setEditable(false); // close
            t.removeActionListener(this); // slutar lyssna
        }
    }
}


