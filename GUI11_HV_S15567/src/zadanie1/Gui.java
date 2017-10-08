package zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

    private JLabel operator = new JLabel();
    private JLabel result = new JLabel();
    private JPanel numbOperator = new JPanel(new FlowLayout());
    private JPanel panel = new JPanel();
    private String operation = "";
    private Calc calc = new Calc();
    private boolean isResult = false;
    private JButton[] numb ={
            new JButton("0"),
            new JButton("1"),
            new JButton("2"),
            new JButton("3"),
            new JButton("4"),
            new JButton("5"),
            new JButton("6"),
            new JButton("7"),
            new JButton("8"),
            new JButton("9")
    };

    JButton operations [] = {new JButton("+"),
            new JButton("/"),
            new JButton("-"),
            new JButton("*"),
            new JButton("="),
            new JButton("AC")
    };

    public Gui(){
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        operator.setName("op");
        operator.setPreferredSize(new Dimension(100,20));

        result.setName("res");
        result.setText("0.0");
        result.setPreferredSize(new Dimension(100,20));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(operator);
        panel.add(result);

        add(panel);
        makeNumbers();
        addOperationNumbers();
        add(numbOperator);
        pack();
        setVisible(true);
    }

    private void addOperationListener(JButton[] jButtons){
        for (int i = 0; i < jButtons.length-1; i++)
            jButtons[i].addActionListener((ActionEvent e)->{
                if (isResult){
                    isResult = false;
                    operation = result.getText();
                    result.setText("");
                }

                operation += " " + e.getActionCommand() + " ";
                operator.setText(operation);
                if (e.getActionCommand().equals("=")) {
                    double tmp = calc.calculate(operation);
                    if (!(tmp % 1 == 0))
                        result.setText(tmp + "");
                    else
                        result.setText((int)(tmp) + "");

                    isResult = true;
                }
            });
        jButtons[5].addActionListener((ActionEvent e)-> clear());
    }

    private void addOperationNumbers(){
        JPanel jPanel = new JPanel(new GridLayout(4,2));

        for (int i = 0; i < operations.length; i++)
            jPanel.add(operations [i]);

        addOperationListener(operations );
        numbOperator.add(jPanel);
    }

    private void makeNumbers(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4,3));

        for (int i = 2; i>=0; i--)
            for (int j = 0; j<3; j++)
                jPanel.add(numb[3*i+j+1]);

        jPanel.add(numb[0]);
        addNumListener(numb);
        numbOperator.add(jPanel);
    }

    private void addNumListener(JButton[] numbers){
        for (int i = 0; i < numbers.length; i++)
            numbers[i].addActionListener((ActionEvent e)->{
                if (isResult) { clear(); isResult = false; }
                operation += e.getActionCommand();
                operator.setText(operation);
            });
    }

    private void clear(){
        result.setText("0.0");
        operation = "";
        operator.setText("");
    }
}