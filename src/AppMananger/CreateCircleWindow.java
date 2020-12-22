package AppMananger;

import Figures.Circle;

import javax.swing.*;
import java.awt.*;

public class CreateCircleWindow extends JDialog{
    private JPanel HeadPanel;
    private JButton cancelButton;
    private JButton applyButton;
    private JTextField textField1;
    private JLabel label;

    public CreateCircleWindow(OnAddedListener listener, int x, int y) {

        setContentPane(HeadPanel);
        setModal(true);

        setTitle("Create Circle");
        setBounds(x, y, 300, 200);

        applyButton.setBackground(Color.GREEN);
        cancelButton.setBackground(Color.RED);

        applyButton.addActionListener(e -> {
            double radius = 0;
            try {
                radius = Double.parseDouble(textField1.getText());
            } catch (NumberFormatException exception) {
                label.setVisible(true);
            }

            if (radius <= 0) {
                label.setVisible(true);
            }
            else {
                listener.onAdded(new Circle(radius));
                dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            dispose();
        });

    }
}

