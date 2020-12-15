package AppMananger;

import Figures.Rectangle;

import javax.swing.*;
import java.awt.*;

public class CreateRectangleWindow extends JDialog{
    private JPanel HeadPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton applyButton;
    private JButton cancelButton;
    private JLabel label1;
    private JLabel label2;


    public CreateRectangleWindow(OnAddedListener listener, int x, int y) {

        setContentPane(HeadPanel);
        setModal(true);

        setTitle("Create Rectangle");
        setBounds(x, y, 300, 200);
        applyButton.setBackground(Color.GREEN);
        cancelButton.setBackground(Color.RED);

        applyButton.addActionListener(e -> {
            double a = 0;
            double b = 0;
            try {
                a = Double.parseDouble(textField1.getText());
                b = Double.parseDouble(textField2.getText());
            } catch (NumberFormatException exception) {
                label1.setVisible(true);
                label2.setVisible(true);
            }

            if (a <= 0 || b <= 0) {
                label1.setVisible(true);
                label2.setVisible(true);
            } else {
                listener.onAdded(new Rectangle(a, b));
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            dispose();
        });

    }
}
