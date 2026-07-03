package radiobuttondemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class RADIOBUTTONDEMO extends JFrame implements ActionListener {

    JRadioButton bird, cat, dog, rabbit, pig;
    JLabel imageLabel;

    public RADIOBUTTONDEMO() {

        setTitle("Radio Button Demo");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Radio buttons
        bird = new JRadioButton("Bird");
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");
        rabbit = new JRadioButton("Rabbit");
        pig = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(bird);
        group.add(cat);
        group.add(dog);
        group.add(rabbit);
        group.add(pig);

        bird.addActionListener(this);
        cat.addActionListener(this);
        dog.addActionListener(this);
        rabbit.addActionListener(this);
        pig.addActionListener(this);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));

        leftPanel.add(bird);
        leftPanel.add(cat);
        leftPanel.add(dog);
        leftPanel.add(rabbit);
        leftPanel.add(pig);

        imageLabel = new JLabel();

        add(leftPanel);
        add(imageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pet = "";
        String imageName = "";

        if (bird.isSelected()) {
            pet = "Bird";
            imageName = "bird.png.jpg";
        } else if (cat.isSelected()) {
            pet = "Cat";
            imageName = "cat.png.jpg";
        } else if (dog.isSelected()) {
            pet = "Dog";
            imageName = "dog.png.jpg";
        } else if (rabbit.isSelected()) {
            pet = "Rabbit";
            imageName = "rabbit.png.jpg";
        } else if (pig.isSelected()) {
            pet = "Pig";
            imageName = "pig.png.jpg";
        }

        // Search directly inside the source packages structure 
        String path1 = "src/images/" + imageName;
        String path2 = "src/radiobuttondemo/images/" + imageName;
        
        File file1 = new File(path1);
        File file2 = new File(path2);
        
        String finalPath = null;
        
        if (file1.exists()) {
            finalPath = file1.getAbsolutePath();
        } else if (file2.exists()) {
            finalPath = file2.getAbsolutePath();
        }

        if (finalPath != null) {
            imageLabel.setIcon(new ImageIcon(finalPath));
            imageLabel.setText(""); // Wipe text when image is successfully shown
        } else {
            imageLabel.setIcon(null);
            // This prints out the exact path it tried so we can trace it down
            imageLabel.setText("<html><font color='red'>Missing file! Put your files in:<br>" 
                    + file1.getAbsolutePath() + "</font></html>");
        }

        JOptionPane.showMessageDialog(this, "You selected: " + pet);
    }

    public static void main(String[] args) {
        new RADIOBUTTONDEMO();
    }
}