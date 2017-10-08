package zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListTest extends JFrame{
    private DefaultListModel model = new DefaultListModel();
    private boolean morzno;

    public ListTest() {
        JTextField jTextField = new JTextField();
        jTextField.addActionListener( (e) -> model.addElement(e.getActionCommand()));

        JList jList = new JList(model);
        jList.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.isAltDown())
                    morzno = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(!e.isAltDown())
                    morzno = false;
            }
        });
        jList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(morzno && model.getSize() != 0)
                    model.removeElementAt(jList.getSelectedIndex());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Container container = getContentPane();
        container.add(jTextField, "North");
        container.add(new JScrollPane(jList), "Center");
        setPreferredSize(new Dimension(400, 400));
        setTitle("String List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}