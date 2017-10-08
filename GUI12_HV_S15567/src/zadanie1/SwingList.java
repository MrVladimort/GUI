package zadanie1;

import java.awt.*;
import javax.swing.*;

public class SwingList extends JFrame{
	public SwingList(){
		Container cp = getContentPane();
        JList list = new JList(new TempList());
		cp.add(new JScrollPane(list), "Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Temp");
		setVisible(true);
		pack();
	}
}