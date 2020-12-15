package AppMananger;

import Figures.Square;

import javax.swing.*;
import java.awt.*;

public class CreateSquareWindow extends JDialog {
    private JPanel HeadPanel;
    private JTextField textField1;
    private JButton applyButton;
    private JButton cancelButton;
    private JLabel label;

    public CreateSquareWindow(OnAddedListener listener, int x, int y) {

        setContentPane(HeadPanel);
        setModal(true);

        setTitle("Create Square");
        setBounds(x, y, 300, 200);
        applyButton.setBackground(Color.GREEN);
        cancelButton.setBackground(Color.RED);

        applyButton.addActionListener(e -> {
            double a = 0;
            try {
                a = Double.parseDouble(textField1.getText());
            } catch (NumberFormatException exception) {
                label.setVisible(true);
            }

            if (a <= 0) {
                label.setVisible(true);
            }
            else {
                listener.onAdded(new Square(a));
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            dispose();
        });

    }
}
