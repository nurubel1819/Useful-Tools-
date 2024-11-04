package All_class_and_frem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class temperature extends JFrame {
    private JPanel panel_temperature_main;
    private JTextField tf_c;
    private JTextField tf_f;
    private JTextField tf_k;
    private JButton button_back_home;
    private JLabel lavel_user_instruction;
    private JButton button_clear;

    public temperature() {

        this.setContentPane(panel_temperature_main);
        this.setVisible(true);
        this.setSize(1000, 600);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Temperature converter");


        button_back_home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code back to home button
                temperature.this.hide();
                main_class ob_main = new main_class();
            }
        });

        tf_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code for celcius

                if(tf_c.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Input field is empty");

                }
                else
                {
                    double cel = Double.parseDouble(tf_c.getText());
                    double f = (cel*1.8)+32;
                    String far = String.format(Locale.US, "%.2f", f);
                    tf_f.setText(far);

                    double k = cel + 273.15;
                    String kel = String.format(Locale.US, "%.2f", k);
                    tf_k.setText(kel);

                }
            }
        });
        tf_f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code for fahrenheit
                if(tf_f.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Input field is empty");

                }
                else
                {
                    String value_f = tf_f.getText();
                    double far = Double.parseDouble(value_f);

                    double cel = (far-32)*0.55555556;
                    double kel = ((far-32)*0.55555556) + 273.15;

                    String c = String.format(Locale.US, "%.2f", cel);
                    String k = String.format(Locale.US, "%.2f", kel);

                    tf_c.setText(c);
                    tf_k.setText(k);
                }
            }
        });
        tf_k.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code for kalvin
                if(tf_k.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Input field is empty");

                }
                else
                {
                    String value_k = tf_k.getText();
                    double kel = Double.parseDouble(value_k);

                    double cel = kel - 273.15;
                    double far = (kel-273.15)*1.8+32;

                    String c = String.format(Locale.US, "%.2f", cel);
                    String f = String.format(Locale.US, "%.2f", far);

                    tf_c.setText(c);
                    tf_f.setText(f);
                }
            }
        });
        button_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code clear
                tf_k.setText("");
                tf_f.setText("");
                tf_c.setText("");
            }
        });
    }
}
