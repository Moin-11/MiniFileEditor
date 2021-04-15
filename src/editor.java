
// Java Program to create a text editor using java
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.text.*;

public class editor {
    // Main class
    public static void main(String args[]) {

        JFrame frame = new JFrame();
        frame.setTitle("Class Grades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(25, 25));

        JTextArea textarea = new JTextArea();

        Font font = new Font("Segoe Script", Font.BOLD, 20);
        textarea.setFont(font);

        mainPanel.add(textarea, BorderLayout.CENTER);
        textarea.setBackground(Color.WHITE);
        textarea.setEditable(false);

        // creates menu bar
        JMenuBar mb = new JMenuBar();

        // Create file menu for menu

        JMenu fileMenu = new JMenu("File");

        JMenuItem New = new JMenuItem("New");
        JMenuItem Open = new JMenuItem("Open");
        JMenuItem Save = new JMenuItem("Save");
        JMenuItem Exit = new JMenuItem("Exit");

        fileMenu.add(New);
        fileMenu.add(Open);
        fileMenu.addSeparator();
        fileMenu.add(Save);
        fileMenu.addSeparator();
        fileMenu.add(Exit);

        // Create tool menu for menu
        JMenu toolMenu = new JMenu("Tools");

        JMenuItem GenerateTable = new JMenuItem("Generate Table");
        JMenuItem ComputeAverage = new JMenuItem("Compute Average");
        JMenuItem FindMaximum = new JMenuItem("Find Maximum");
        JMenuItem FindMinimum = new JMenuItem("Find Minimum");

        toolMenu.add(GenerateTable);
        toolMenu.addSeparator();
        toolMenu.add(ComputeAverage);
        toolMenu.add(FindMaximum);
        toolMenu.add(FindMinimum);

        // Create help menu for menu
        JMenu helpmenu = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        JMenuItem howto = new JMenuItem("How To");
        helpmenu.add(about);
        helpmenu.add(howto);

        // implement action Listeners and action performers

        // implement new option action Listeners
        New.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                textarea.setEditable(true);
                textarea.setText("ID; Name (first::last); Grade; Letter Grade\n");
            };
        });

        // implement open option action Listeners
        Open.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser("f:");

                int r = chooser.showOpenDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {

                    File file = new File(chooser.getSelectedFile().getAbsolutePath());

                    try {

                        String s = "", newline = "";

                        BufferedReader b = new BufferedReader(new

                        FileReader(file));
                        s = b.readLine();

                        while ((newline = b.readLine()) != null) {

                            s = s + "\n" + newline;
                        }

                        textarea.setText(s);
                        textarea.setEditable(true);
                        b.close();
                    }

                    catch (Exception err) {
                        JOptionPane.showMessageDialog(frame, err.getMessage());

                    }
                }
            }

        });

        // implement save option action Listeners
        Save.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JFileChooser chooser = new JFileChooser("f:");
                int r = chooser.showSaveDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    File file;
                    if (chooser.getSelectedFile().getAbsolutePath().contains(".txt")) {

                        file = new File(chooser.getSelectedFile().getAbsolutePath());
                    }

                    else {

                        file = new File(chooser.getSelectedFile().getAbsolutePath() + ".txt");

                    }

                    try {

                        FileWriter filewriter = new FileWriter(file);
                        String ans = textarea.getText();
                        filewriter.write(ans);
                        filewriter.close();

                    }

                    catch (Exception err)

                    {
                        JOptionPane.showMessageDialog(frame, err.getMessage());
                    }

                }

            }

        });

        // implement exit option action Listeners
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }

        });

        // implement about option action Listeners

        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String abouttheGUI = "About this Graphical User Interface \n\n The following GUI permits the user to do the following options:"
                        + "\nOpen existing file" + "\nCreate a new files" + "\nSave a file"
                        + "\n\nUpcoming future updates permits the user to do the following options:"
                        + "\nCompute Averages for Grades" + "\nGenerate Tables"
                        + "\nFind Maximum/Minimum grades of the students";

                textarea.setText(abouttheGUI);
                textarea.setEditable(false);

            }

        });

        // implement about option action Listeners

        howto.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String howtotheGUI = "Learn more of the program: \nNew: creates a new highly text file to add coursegrades"
                        + "\nSave: Saves the text file to a desired directory"
                        + "\nOpen: opens an existing text file from selected directory" + "\nExit: Exits the program. ";

                textarea.setText(howtotheGUI);
                textarea.setEditable(false);
            }

        });

        // add all the menuitems to the menu bar
        mb.add(fileMenu);
        mb.add(toolMenu);
        mb.add(helpmenu);
        frame.add(mainPanel);
        frame.setJMenuBar(mb);
        frame.setVisible(true);
    }
}
