package All_class_and_frem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame {
    private JPanel panel_main_class;
    private JButton button_count;
    private JButton button_discount;
    private JButton button_BMI;
    private JButton button_temperature;
    private JButton numericalConversionButton;
    private JButton button_full_seceen;
public main_class() {
    this.setContentPane(panel_main_class);
    this.setVisible(true);
    this.setSize(1000,600);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button_count.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code word count button
            main_class.this.hide();
            word_count ob_word = new word_count();
        }
    });


    button_discount.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code discount button
            main_class.this.hide();
            discount ob_dis = new discount();
        }
    });
    button_BMI.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code BMI button
            main_class.this.hide();
            BMI_and_BMR ob_bmi = new BMI_and_BMR();
        }
    });
    button_temperature.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code temperature
            main_class.this.hide();
            temperature ob_temperature = new temperature();
        }
    });
    numericalConversionButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code numerical
            main_class.this.hide();
            numerical_conversion ob_new = new numerical_conversion();
        }
    });
}

    public static void main(String[] args) {
        main_class ob = new main_class();
    }


}
