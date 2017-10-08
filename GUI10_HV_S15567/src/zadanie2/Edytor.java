package zadanie2;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;

public class Edytor extends JFrame {
    private JFileChooser jFileChooser = new JFileChooser("./");
    private JTextArea jTextArea = new JTextArea(5, 30);
    private boolean haveChanged = false;
    private String path = "bez tytulu";
    private KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            haveChanged = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
    private JMenuBar jMenuBar = new JMenuBar();

    public Edytor() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(640, 480));
        setTitle("Prosty edytor - " + path);

        jTextArea.addKeyListener(keyListener);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        add(jScrollPane, BorderLayout.CENTER);

        setJMenuBar(jMenuBar);
        JMenu fileMenu = new magicFileMenu();
        JMenu editMenu = new magicEditMenu();
        JMenu optionsMenu = new magicOptionsMenu();
        jMenuBar.add(fileMenu); jMenuBar.add(editMenu); jMenuBar.add(optionsMenu);
        pack();
        setVisible(true);
    }

    private class magicFileMenu extends JMenu {
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save as ...");
        JMenuItem exit = new JMenuItem("Exit");

        public magicFileMenu() {
            super("File");
            //==========================================================================
            open.addActionListener(e -> {
                //saveOld();
                if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    readInFile(jFileChooser.getSelectedFile().getAbsolutePath());
                }
            });
            open.setMnemonic(KeyEvent.VK_O);
            open.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_O, ActionEvent.CTRL_MASK));
            open.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            //==========================================================================
            save.addActionListener(e -> {
                if (!path.equals("bez tytulu"))
                    saveFile(path);
                else
                    saveFileAs();
            });
            save.setMnemonic(KeyEvent.VK_S);
            save.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_S, ActionEvent.CTRL_MASK));
            save.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            //==========================================================================
            saveAs.addActionListener(e -> {
                saveFileAs();
            });
            saveAs.setMnemonic(KeyEvent.VK_A);
            saveAs.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_A, ActionEvent.CTRL_MASK));
            saveAs.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            //==========================================================================
            exit.addActionListener(e -> {
            /*
            if(haveChanged && JOptionPane.showConfirmDialog(this, "Czy chcesz zapisaД‡ ten plik ?",
                    "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                if (!path.equals("bez tytuЕ‚u"))
                    saveFile(path);
                else
                    saveFileAs();
            */
                System.exit(0);
            });
            exit.setMnemonic(KeyEvent.VK_X);
            exit.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_X, ActionEvent.CTRL_MASK));
            exit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            //==========================================================================

            add(open);
            add(save);
            add(saveAs);
            JMenuItem tmp = new JMenuItem();
            tmp.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            JSeparator jsp = new JSeparator();
            jsp.setForeground(Color.red);
            jsp.setBackground(Color.red);
            tmp.add(jsp, BorderLayout.CENTER);
            tmp.setPreferredSize(new Dimension(0, 10));
            add(tmp);
            add(exit);
        }

        private void readInFile(String absolutePath) {
            try {
                FileReader fr = new FileReader(absolutePath);
                jTextArea.read(fr, null);
                fr.close();
                path = absolutePath;
                setTitle("Prosty edytor - " + absolutePath);
                jFileChooser.setCurrentDirectory(new File(absolutePath));
                haveChanged = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void saveFile(String absolutePath) {
            try {
                FileWriter fw = new FileWriter(absolutePath);
                jTextArea.write(fw);
                fw.close();
                path = absolutePath;
                setTitle("Prosty edytor - " + absolutePath);
                haveChanged = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void saveFileAs() {
            if(jFileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
                saveFile(jFileChooser.getSelectedFile().getAbsolutePath());
        }

        private void saveOld() {
            if(haveChanged) {
                if(JOptionPane.showConfirmDialog(this, "Czy chcesz zapisac ten plik "+ path +" ?",
                        "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    saveFile(path);
            }
        }

    }

    private class magicEditMenu extends JMenu {
        public magicEditMenu(){
            super("Edit");
            JMenu adres = new JMenu("Adres");
            adres.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            JMenuItem[] items = {new JMenuItem("Praca"),
                    new JMenuItem("Szkola"),
                    new JMenuItem("Dom")
            };
            HashMap<String, String> adresy = new HashMap<String, String>();
            adresy.put(items[0].getText(), "adres pracy");
            adresy.put(items[1].getText(), "adres skoly");
            adresy.put(items[2].getText(), "adres domu");

            items[0].setMnemonic(KeyEvent.VK_P);
            items[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                    ActionEvent.SHIFT_MASK+InputEvent.CTRL_MASK));

            items[1].setMnemonic(KeyEvent.VK_S);
            items[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                    ActionEvent.SHIFT_MASK+InputEvent.CTRL_MASK));

            items[2].setMnemonic(KeyEvent.VK_D);
            items[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                    InputEvent.SHIFT_MASK+InputEvent.CTRL_MASK));


            for (int i = 0; i < items.length; i++) {
                items[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                int finalI = i;
                items[i].addActionListener((e -> jTextArea.insert(adresy.get(items[finalI].getText()),
                        jTextArea.getCaretPosition()))
                );
                adres.add(items[i]);
            }
            add(adres);
        }
    }

    private class magicOptionsMenu extends JMenu {
        String [] submenus = {"Foreground", "Background","Font size"};
        Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN,
                Color.GRAY, Color.YELLOW, Color.ORANGE, Color.PINK,
                Color.RED, Color.BLACK, Color.WHITE, Color.MAGENTA
        };
        String[] names = {"Blue", "Cyan", "Green",
                "Gray", "Yellow", "Orange", "Pink", "Red",
                "Black", "White", "Magenta"
        };

        private magicOptionsMenu() {
            super("Options");
            add(magicGround(submenus[0]));
            add(magicGround(submenus[1]));
            add(magicFont(submenus[2]));
        }

        private JMenu magicGround(String s) {
            JMenu jMenu = new JMenu(s);
            for (int i = 0; i < colors.length; i++) {
                JMenuItem jMenuItem = new JMenuItem(names[i], new KolorIcon(colors[i], 10));
                int finalI = i;
                if(s == "Foreground")
                    jMenuItem.addActionListener((e -> jTextArea.setForeground(colors[finalI])));
                else if(s == "Background")
                    jMenuItem.addActionListener((e -> jTextArea.setBackground(colors[finalI])));
                jMenuItem.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                jMenu.add(jMenuItem);
            }
            jMenu.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            return jMenu;
        }

        private JMenu magicFont(String s){
            JMenu jMenu = new JMenu(s);
            for (int i = 8; i <= 24; i=i+2) {
                JMenuItem jMenuItem = new JMenuItem(i + " pts");
                final int finalI = i;
                jMenuItem.addActionListener((e -> jTextArea.setFont(new Font("TimesRoman", Font.PLAIN, finalI))));
                jMenuItem.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                jMenu.add(jMenuItem);
            }
            jMenu.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            return jMenu;
        }

        private class KolorIcon implements Icon {
            private Color color;
            private int size;

            private KolorIcon(Color color, int size){
                this.color = color;
                this.size = size;
            }

            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Color oldColor = g.getColor();
                g.setColor(color);
                g.fillOval(getIconWidth()/2, getIconHeight()/2, getIconWidth(), getIconHeight());
                g.setColor(oldColor);
            }

            @Override
            public int getIconWidth() {
                return size;
            }

            @Override
            public int getIconHeight() {
                return size;
            }
        }
    }
}