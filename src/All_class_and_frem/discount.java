package All_class_and_frem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class discount extends JFrame {
    private JPanel panel_discount_main;
    private JPanel panel_get_price;
    private JPanel panel_get_discount;
    private JTextField tf_original_price;
    private JTextField tf_discount;
    private JButton button_getPrice;
    private JLabel label_price;
    private JTextField tf_list_price;
    private JTextField tf_paid_price;
    private JButton button_getDiscount;
    private JLabel lavel_discount;
    private JButton button_back_home;
    private JButton button_clear_price;
    private JButton button_clear_discount;

    public discount() {

    this.setContentPane(panel_discount_main);
    this.setVisible(true);
    this.setSize(1000,600);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button_getPrice.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code get price
            try {
                String original_price = tf_original_price.getText();
                String discount_price = tf_discount.getText();

                double o_p = Double.parseDouble(original_price);
                double dis = Double.parseDouble(discount_price);

                double final_price = o_p-(o_p*(dis/100));

                original_price = String.format(Locale.US, "%.2f",final_price);

                label_price.setText("Final price = "+original_price);
            } catch (Exception exception) {
                tf_original_price.setText("");
                tf_discount.setText("");
                label_price.setText("Final price = ");
                JOptionPane.showMessageDialog(null,"Wrong Input\n Enter Input again");
            }
        }
    });
    button_getDiscount.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //code get discount
            try {
                String list_price = tf_list_price.getText();
                String paid_price = tf_paid_price.getText();

                double l_p = Double.parseDouble(list_price);
                double p_p = Double.parseDouble(paid_price);

                double ans_discount = ((l_p-p_p)/l_p)*100;

                //list_price = Double.toString(ans_discount);

                list_price = String.format(Locale.US, "%.2f", ans_discount);

                lavel_discount.setText("Discount = "+list_price+"%");
            } catch (Exception exception) {
                tf_list_price.setText("");
                tf_discount.setText("");
                lavel_discount.setText("Discount = ");
                JOptionPane.showMessageDialog(null,"Wrong Input\n Enter input again");
            }
        }
    });
        button_clear_price.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clear price
                tf_original_price.setText("");
                tf_discount.setText("");
                label_price.setText("Final price = ");
            }
        });
        button_clear_discount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clear discount
                tf_list_price.setText("");
                tf_paid_price.setText("");
                lavel_discount.setText("Discount = ");
            }
        });
        button_back_home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code back to home button
                discount.this.hide();
                main_class ob_main = new main_class();
            }
        });
    }
}
