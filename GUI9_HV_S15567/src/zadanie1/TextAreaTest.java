package zadanie1;

import javax.swing.*;
import java.awt.*;

public class TextAreaTest extends JFrame {
	
	public TextAreaTest(){
		setPreferredSize(new Dimension(1024, 768));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTextArea jta = new JTextArea(5, 20);
		jta.setBackground(Color.BLUE);
		jta.setForeground(Color.YELLOW);
		jta.setFont(new Font(Font.DIALOG, Font.ITALIC , 14));
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		pack();
		setVisible(true);
	}
}
