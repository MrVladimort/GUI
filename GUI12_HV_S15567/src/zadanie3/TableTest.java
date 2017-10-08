package zadanie3;

import javax.swing.*;
import java.awt.*;

public class TableTest extends JFrame{
    String [] columns = {"autor", "tytul", "cene", "okladke"};
    String [][] go = {{"kek", "kek", "kek", "kek"}};
    JTable jTable = new JTable(go, columns);

    TableTest(){
        Container container = getContentPane();
        container.add(new JScrollPane(jTable), "Center");

        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
