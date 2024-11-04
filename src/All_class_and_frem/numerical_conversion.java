package All_class_and_frem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class numerical_conversion extends JFrame {
    private JPanel panel_numerical;
    private JPanel panel_input;
    private JPanel panel_output;
    private JButton button_back_;
    private JComboBox cb_input;
    private JTextField tf_input;
    private JComboBox cb_output;
    private JLabel lavel_ans;
    private JButton convertButton;
    private JButton button_clear;

    public numerical_conversion() {

    this.setContentPane(panel_numerical);
    this.setVisible(true);
    this.setSize(1000,600);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button_back_.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // back to home button
            numerical_conversion.this.hide();
            main_class ob_main = new main_class();
        }
    });
    convertButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // code convert

            if(tf_input.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Input field is empty");

            }
            else
            {
                int dec = 0;
                
                String input = tf_input.getText().toString();
                String ans = null;

                String input_item = cb_input.getSelectedItem().toString();
                String output_item = cb_output.getSelectedItem().toString();

                try {
                    if(input_item == "Decimal(10)")
                    {
                        dec = Integer.parseInt(input);
                    }
                    else if(input_item == "Octal(8)")
                    {
                        dec = Integer.parseInt(input, 8);
                    }
                    else if(input_item == "Hexadecimal(16)")
                    {
                        dec = Integer.parseInt(input,16);
                    }
                    else if(input_item == "Binary(2)")
                    {
                        dec = Integer.parseInt(input,2);
                    }
                }catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Error , Enter valid number");
                }

                if(output_item == "Decimal(10)")
                {
                    ans = Integer.toString(dec,10);
                }
                else if(output_item == "Octal(8)")
                {
                    ans = Integer.toString(dec,8);
                }
                else if(output_item == "Hexadecimal(16)")
                {
                    ans = Integer.toString(dec,16).toUpperCase();
                }
                else if(output_item == "Binary(2)")
                {
                    ans = Integer.toString(dec,2);
                }
                lavel_ans.setText("Ans is = "+ans);
            }
        }
    });
        button_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code clear
                tf_input.setText("");
                lavel_ans.setText("Ans is = ");
            }
        });
    }
}
