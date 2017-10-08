package zadanie2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class LabelTest extends JFrame{
	Color [] cs = {Color.BLACK, Color.BLUE, Color.RED, Color.GRAY, Color.GREEN, Color.YELLOW};
	String [] layouts = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.SOUTH};
	
	public LabelTest(){
		for(int i = 0; i < 5; i++){	
			JLabel labels = new JLabel(i+"");
			labels.setFont(new Font("TimesRoman", Font.PLAIN, (int)(Math.random()*32)+23));
			labels.setHorizontalAlignment(JLabel.CENTER);
			labels.setToolTipText(i+1+"");
			labels.setBorder(BorderFactory.createLineBorder(cs[cs.length-i-1], BevelBorder.LOWERED));
			labels.setForeground(cs[cs.length-i-1]);
			labels.setBackground(cs[i]);
			labels.setOpaque(true);
			labels.setPreferredSize(new Dimension(100, 100));
			add(labels, layouts[i]);
		}
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
