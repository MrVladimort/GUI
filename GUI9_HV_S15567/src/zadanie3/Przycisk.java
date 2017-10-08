package zadanie3;

import javax.swing.*;
import java.awt.*;

public class Przycisk extends JFrame{
	
	private JButton [] buttons = {
			new JButton("Przycisk 1"), 
			new JButton("P 2"), 
			new JButton("Większy przycisk numer 3"),
			new JButton("Przycisk 4"), 
			new JButton("P5")
	};

	private String [] layouts = {BorderLayout.NORTH, BorderLayout.WEST, BorderLayout.CENTER, BorderLayout.EAST, BorderLayout.SOUTH};
		
	public Przycisk() {
		String txt = "Choose an option A-G", option = "";
		while((option = JOptionPane.showInputDialog(txt, option)) != null){
			if(option.length() != 1 || option.charAt(0) < 65 || option.charAt(0) > 71) 
				txt = "Error: Choose an option A-G";
			else
				break;
		}		
		
		switch(option){
			case "A": 
				borderLayout();
				break;
			case "B":
				flowLayout();
				break;
			case "C":
				flowLayoutLewo();
				break;
			case "D":
				flowLayoutPrawo();
				break;
			case "E":
				gridLayoutRow();
				break;
			case "F":
				gridLayoutColumn();
				break;
			case "G":
				gridLayoutTable();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Error");
		}
		
		setPreferredSize(new Dimension(1024, 768));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	void borderLayout(){
		for(int i = 0; i < 5; i++) add(buttons[i], layouts[i]);
		setTitle("Border Layout");
	}
	
	void flowLayout(){
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		for(int i = 0; i < 5; i++) add(buttons[i]);
		setTitle("Flow Layout");
	}

	void flowLayoutLewo(){
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		setLayout(layout);
		for(int i = 0; i < 5; i++) add(buttons[i]);
		setTitle("Flow Layout Left");
	}
	
	void flowLayoutPrawo(){
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		setLayout(layout);
		for(int i = 0; i < 5; i++) add(buttons[i]);
		setTitle("Flow Layout Right");
	}
	
	void gridLayoutRow(){
		GridLayout layout = new GridLayout(1, 0);
		setLayout(layout);
		for(int i = 0; i < 5; i++) add(buttons[i]);
		setTitle("Grid Layout Row");
	}
	
	void gridLayoutColumn(){
		GridLayout layout = new GridLayout(0, 1);
		setLayout(layout);
		for(int i = 0; i < 5; i++) add(buttons[i]);
		setTitle("Grid Layout Column");
	}
	
	void gridLayoutTable(){
		GridLayout layout = new GridLayout(3, 2);
		setLayout(layout);
		for(int i = 0; i < 5; i++) add(buttons[i]);
		setTitle("Grid Layout Table");
	}
}