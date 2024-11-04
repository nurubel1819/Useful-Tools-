package All_class_and_frem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;


public class word_count extends JFrame {
    private JPanel panel_word_count;
    private JTextArea textArea;
    private JPanel pnel_sub_word_count;
    private JButton button_textAria;
    private JButton button_save;
    private JButton button_clear;
    private JButton button_home;
    private JScrollPane scroll;
    private JPanel output;
    private JLabel lavel_total_word;
    private JLabel lavel_total_digit;
    private JLabel lavel_total_char;
    private JButton button_get_data;
    private JButton deleteDataButton;

    public word_count() {

    this.setContentPane(panel_word_count);
    this.setVisible(true);
    this.setSize(1000,600);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    button_textAria.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code text aria

            if (textArea.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Input area is empty");
            }
            else
            {
                int total_w=1,total_c=0,total_d=0;

                String str = textArea.getText();

                String words[] = str.split("\\s");

                for(char ch : str.toCharArray())
                {
                    if(Character.isDigit(ch)) total_d++;
                    else  if(Character.isLetter(ch)) total_c++;
                }

                lavel_total_char.setText(Integer.toString(total_c));
                lavel_total_digit.setText(Integer.toString(total_d));
                lavel_total_word.setText("" + words.length);
            }

        }
    });
    button_save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code for text file
            try {
                File fi = new File("data.txt");
            } catch (Exception exception_1) {
                JOptionPane.showMessageDialog(null, "Error can't save");
            }

            if (textArea.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Input area is empty");
            }
            else
            {
                try {
                    FileWriter fw = new FileWriter("data.txt");
                    fw.append(textArea.getText());
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Save successfully");
                } catch (Exception exception_2) {
                    JOptionPane.showMessageDialog(null, "Error can't save");
                }
            }
            textArea.setText("");
        }
    });
    button_get_data.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /// code get data form file
            try {
                // Create f1 object of the file to read data
                File f1 = new File("data.txt");
                Scanner dataReader = new Scanner(f1);
                String fileData = "";
                while (dataReader.hasNextLine()) {
                     fileData = fileData + dataReader.nextLine() + "\n";
                }
                if (fileData.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error can't see data");
                } else {
                    textArea.setText("");
                    textArea.setText(fileData);
                }
                dataReader.close();
            } catch (FileNotFoundException exception) {
                JOptionPane.showMessageDialog(null, "Error can't see data");
            }
        }
    });
    deleteDataButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /// code delete button
            textArea.setText("");
            try {
                File fi = new File("data.txt");
            } catch (Exception exception_1) {
                JOptionPane.showMessageDialog(null, "Error can't delete");
            }
            try {
                FileWriter fw = new FileWriter("data.txt");
                fw.append("");
                fw.close();
                JOptionPane.showMessageDialog(null, "delete successfully");
            } catch (Exception exception_2) {
                JOptionPane.showMessageDialog(null, "Error can't delete");
            }
        }
    });
    button_clear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code for clear button
            textArea.setText("");
            lavel_total_word.setText("");
            lavel_total_digit.setText("");
            lavel_total_char.setText("");
        }
    });
    button_home.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code for back to home button
            word_count.this.hide();
            main_class ob_main = new main_class();
        }
    });
        deleteDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /// code delete button
            }
        });
    }
}
