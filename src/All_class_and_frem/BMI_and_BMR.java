package All_class_and_frem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class BMI_and_BMR extends JFrame {
    private JPanel panel_BMI_main;
    private JPanel panel_bmi;
    private JPanel panel_bmr;
    private JTextField tf_bmi_weight;
    private JComboBox cb_bmi_weight;
    private JTextField tf_bmi_height_feet;
    private JTextField tf_bmr_weight;
    private JComboBox cb_bmr_weight;
    private JTextField tf_bmr_height_feet;
    private JButton button_bmi;
    private JButton button_bmr;
    private JButton button_back_to_home;
    private JLabel label_bmi;
    private JButton button_bmi_clear;
    private JLabel lavel_bmr;
    private JButton button_bmr_clear;
    private JTextField tf_bmr_age;
    private JTextField tf_bmi_height_inche;
    private JTextField tf_bmr_height_inche;

    public BMI_and_BMR() {

    this.setContentPane(panel_BMI_main);
    this.setVisible(true);
    this.setSize(1200,600);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button_back_to_home.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // code button back to home
            BMI_and_BMR.this.hide();
            main_class ob_main = new main_class();
        }
    });
    button_bmi.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code button bmi
            try {
                String bmi_weight;
                String bmi_height_feet;
                String bmi_height_inche;

                double bmi_w = 0;
                double bmi_h_f=0;
                double bmi_h_i=0;
                double bmi_h=0;
                if(tf_bmi_weight.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Weight is empty");
                }
                else {
                    bmi_weight = tf_bmi_weight.getText();
                    bmi_w = Double.parseDouble(bmi_weight);
                }
                if(tf_bmi_height_feet.getText().isEmpty()) {
                    bmi_h_f=0;
                }
                else {
                    bmi_height_feet = tf_bmi_height_feet.getText();
                    bmi_h_f = Double.parseDouble(bmi_height_feet);
                }
                if(tf_bmi_height_inche.getText().isEmpty()) {
                    if(bmi_h_f == 0) JOptionPane.showMessageDialog(null, "Error,Height can't zero");
                    else {
                        bmi_h_i = 0;
                    }
                }
                else {
                    bmi_height_inche = tf_bmi_height_inche.getText();
                    bmi_h_i = Double.parseDouble(bmi_height_inche);
                }

                bmi_h = (bmi_h_f*12)+bmi_h_i;
                bmi_h = (bmi_h * 2.54)/100;

                String bmi_weight_select = cb_bmi_weight.getSelectedItem().toString();
                if(bmi_weight_select == "Pound")
                {
                    bmi_w = bmi_w * 0.4536;
                }

                double bmi = bmi_w/(bmi_h*bmi_h);  //bmi formula

                String bmi_ans = String.format(Locale.US, "%.2f", bmi);

                label_bmi.setText("BMI is = "+bmi_ans);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,"Enter valid Input");
            }
        }
    });
    button_bmr.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code button bmr
            try {
                String bmr_weight;
                String bmr_height_feet;
                String bmr_height_inche;
                String bmr_age ;

                double bmr_w =0;
                double bmr_h_f ;
                double bmr_h_i =0;
                double bmr_a =0;

                if(tf_bmr_weight.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error,weight can't empty");
                }
                else {
                    bmr_weight = tf_bmr_weight.getText();
                    bmr_w = Double.parseDouble(bmr_weight);
                }
                if(tf_bmr_height_feet.getText().isEmpty()) {
                    bmr_h_f = 0;
                }
                else {
                    bmr_height_feet = tf_bmr_height_feet.getText();
                    bmr_h_f = Double.parseDouble(bmr_height_feet);
                }
                if(tf_bmr_height_inche.getText().isEmpty()) {
                    if(bmr_h_f == 0.0) JOptionPane.showMessageDialog(null, "Error,Height can't empty");
                    else {
                        bmr_h_i = 0;
                    }
                }
                else {
                    bmr_height_inche = tf_bmr_height_inche.getText();
                    bmr_h_i = Double.parseDouble(bmr_height_inche);
                }
                if(tf_bmr_age.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error,Age can't empty");
                }
                else {
                    bmr_age = tf_bmr_age.getText();
                    bmr_a = Double.parseDouble(bmr_age);
                }

                double bmr_h = (bmr_h_f * 12) + bmr_h_i;
                bmr_h = bmr_h * 2.54 ;



                double bmr_m = (10 * bmr_w) + (6.25 * bmr_h) - (5 * bmr_a + 5); //formula bmr male
                double bmr_f = (10 * bmr_w) + (6.25 * bmr_h) - (5 * bmr_a - 16); //formula bmr female

                String bmr_m_ans = String.format(Locale.US, "%.2f", bmr_m);
                String bmr_f_ans = String.format(Locale.US, "%.2f", bmr_f);

                lavel_bmr.setText("<html>BMR Man = "+bmr_m_ans+" Kcal/Day<br>BMR Women = "+bmr_f_ans+" Kcal/Day</html>");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,"Enter valid Input");
            }
        }
    });
    button_bmi_clear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code button bmi clear
            tf_bmi_weight.setText("");
            tf_bmi_height_feet.setText("");
            tf_bmi_height_inche.setText("");
            label_bmi.setText("BMI is :");
        }
    });
    button_bmr_clear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code bmr clear
            tf_bmr_weight.setText("");
            tf_bmr_height_feet.setText("");
            tf_bmr_height_inche.setText("");
            tf_bmr_age.setText("");
            lavel_bmr.setText("BMR is :");
        }
    });
}
}
