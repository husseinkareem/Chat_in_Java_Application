package uppgift8;

import javax.swing.*;

public class Gui extends JFrame{

    public Gui(){
        JButton buttonOne = new JButton("     Koppla ner     ");

        setTitle("Klass Chatt");

        JPanel p = new JPanel();
        this.add(p);

        p.add(buttonOne);

        JTextArea area = new JTextArea(20,40);
        p.add(area);


        JTextField t = new JTextField(40);
        p.add(t);
        String txt = t.getText();




        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


