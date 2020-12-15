package AppMananger;

import Figures.Triangle;

import javax.swing.*;
import java.awt.*;

public class CreateTriangleWindow extends JDialog{
    private JPanel HeadPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton applyButton;
    private JButton cancelButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public CreateTriangleWindow(OnAddedListener listener, int x, int y) {

        setContentPane(HeadPanel);
        setModal(true);

        setTitle("Create Triangle");
        setBounds(x, y, 300, 200);
        applyButton.setBackground(Color.GREEN);
        cancelButton.setBackground(Color.RED);

        applyButton.addActionListener(e -> {
            double a = 0;
            double b = 0;
            double c = 0;
            try {
                a = Double.parseDouble(textField1.getText());
                b = Double.parseDouble(textField2.getText());
                c = Double.parseDouble(textField3.getText());
            } catch (NumberFormatException exception) {
                label1.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);
            }

            if ((a <= 0 || b <= 0 || c <= 0)
                    || (a + b <= c || a + c <= b || b + c <= a)) {
                label1.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);

            } else {
                listener.onAdded(new Triangle(a, b, c));
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            dispose();
        });
    }
}
