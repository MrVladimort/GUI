package zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Gravv on 19.05.2017.
 */

public class PrzyciskTest extends JFrame {
    Color [] colors = {Color.BLUE, Color.CYAN, Color.GREEN,
            Color.GRAY, Color.YELLOW, Color.ORANGE, Color.PINK};
    static int licznik = 0;
    JButton button = new JButton("Zmien kolor");

    public PrzyciskTest(){
        button.setPreferredSize(new Dimension(400, 300));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button.setBackground(colors[licznik]);
                if(licznik == colors.length-1)
                    licznik = 0;
                else
                    licznik++;
            }
        });

        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(button);
        pack();
        setVisible(true);
    }
}
