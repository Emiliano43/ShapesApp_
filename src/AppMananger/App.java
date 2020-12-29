package AppMananger;

import Figures.FiguresWriter;
import Figures.FileOperations;
import Figures.Shape;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends JDialog{
    private JPanel HeadPanel;
    private JList shapes;
    FileOperations<Shape> source;
    private JButton moveDownButton;
    private JButton moveUpButton;
    private JButton removeButton;
    private JButton createCircleButton;
    private JButton createSquareButton;
    private JButton createRectangleButton;
    private JButton createTriangleButton;

    public App() {

        setTitle("Shapes Application");
        setBounds(0, 0, 800, 400);

        setContentPane(HeadPanel);
        setModal(true);

        moveDownButton.setToolTipText("Select figure on the left and click to move it down");
        moveUpButton.setToolTipText("Select figure on the left and click to move it up");

        removeButton.setBackground(Color.RED);
        removeButton.setToolTipText("Select figure on the left and click to remove it from the list");

        createCircleButton.setBackground(Color.CYAN);
        createCircleButton.setToolTipText("Click to create new circle and add it to the list ");

        createSquareButton.setBackground(Color.CYAN);
        createSquareButton.setToolTipText("Click to create new square and add it to the list ");

        createRectangleButton.setBackground(Color.CYAN);
        createRectangleButton.setToolTipText("Click to create new rectangle and add it to the list ");

        createTriangleButton.setBackground(Color.CYAN);
        createTriangleButton.setToolTipText("Click to create new triangle and add it to the list ");

        source = new FiguresWriter("shapes.json");
        DefaultListModel<Shape> list = new DefaultListModel<>();

        try {
            list.addAll(source.getFromFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        shapes.setListData(list.toArray());

        list.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                shapes.setListData(list.toArray());
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
                shapes.setListData(list.toArray());
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                shapes.setListData(list.toArray());
            }
        });

        moveDownButton.addActionListener(e -> {
            int index = shapes.getSelectedIndex();

            if (index + 1 >= list.size())
                throw new IllegalArgumentException();

            Shape temp = list.set(index + 1, list.get(index));
            list.set(index, temp);

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        moveUpButton.addActionListener(e -> {
            int index = shapes.getSelectedIndex();

            if (index - 1 < 0)
                throw new IllegalArgumentException();

            Shape temp = list.set(index - 1, list.get(index));
            list.set(index, temp);

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        removeButton.addActionListener(e -> {
            list.remove(shapes.getSelectedIndex());

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });


        createCircleButton.addActionListener(e -> {
            CreateCircleWindow auxiliaryFrame = new CreateCircleWindow(list::addElement,
                    getX() + getWidth() / 5, getY() + getHeight() / 4);
            auxiliaryFrame.setVisible(true);

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        createSquareButton.addActionListener(e -> {
            CreateSquareWindow auxiliaryFrame = new CreateSquareWindow(list::addElement,
                    getX() + getWidth() / 5, getY() + getHeight() / 4);
            auxiliaryFrame.setVisible(true);

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        createRectangleButton.addActionListener(e -> {
            CreateRectangleWindow auxiliaryFrame = new CreateRectangleWindow(list::addElement,
                    getX() + getWidth() / 5, getY() + getHeight() / 4);
            auxiliaryFrame.setVisible(true);

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        createTriangleButton.addActionListener(e -> {
            CreateTriangleWindow auxiliaryFrame = new CreateTriangleWindow(list::addElement,
                    getX() + getWidth() / 5, getY() + getHeight() / 4);

            auxiliaryFrame.setVisible(true);

            try {
                List<Shape> updatedShapes = new ArrayList<>();
                Arrays.stream(list.toArray()).forEach(element -> updatedShapes.add((Shape) element));
                source.putToFile(updatedShapes);
            } catch (IOException ioException) {
                JOptionPane frame = new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "The data was not saved!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                    JOptionPane frame = new JOptionPane(e);
                    int response = JOptionPane.showConfirmDialog(frame,
                            "The data was not saved.\n Close anyway?",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        dispose();
                    } else if (response == JOptionPane.CANCEL_OPTION || response == JOptionPane.CLOSED_OPTION) {
                        e.getOppositeWindow().dispose();
                    }

            }
        });
    }
}
