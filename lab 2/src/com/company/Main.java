package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        try {

            // create text forms
            JTextArea field1 = new JTextArea("123");
            JTextArea field2 = new JTextArea("123");
            JTextArea field3 = new JTextArea(2,0);
            JTextArea field4 = new JTextArea(2, 0);
            field1.setBounds(300, 20, 200, 30);
            field2.setBounds(300, 60, 200, 30);
            field3.setBounds(50, 200, 200, 150);
            field4.setBounds(340, 200,200, 150);

            // create labels
            JLabel label1 = new JLabel("Lambda: ");
            JLabel label2 = new JLabel("K: ");
            JLabel label3 = new JLabel("Expected results:");
            JLabel label4 = new JLabel("Actual results:");
            label1.setBounds(80, 10, 200, 30);
            label2.setBounds(80, 60, 200, 30);
            label3.setBounds(50, 160, 200, 30);
            label4.setBounds(340, 160, 200, 30);
            // create buttons
            JButton button1 = new JButton("Calculate");
            JButton button2 = new JButton("Clear");
            button1.setBounds(50, 120, 100, 30);
            button2.setBounds(170, 120, 100, 30);
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Model model = new Model(field1.getText(), field2.getText());
                    double[] array = model.genArrayValues();
                    double mathExp = model.countMathExpectation(array);

                    field3.setText("MathExpectation "+ String.format("%.7f", model.mathExpectation()) + "\n\n"+
                            "Dispersion "+String.format("%.7f", model.dispersion()));

                    field4.setText("MathExpectation "+ String.format("%.7f", mathExp) + "\n\n"+
                            "Dispersion "+String.format("%.7f", model.countDispersion(array, mathExp)));

                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    field1.setText("");
                    field2.setText("");
                    field3.setText("");
                    field4.setText("");
                }
            });

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.add(field1);
            frame.add(field2);
            frame.add(field3);
            frame.add(field4);
            frame.add(label1);
            frame.add(label2);
            frame.add(label3);
            frame.add(label4);
            frame.add(button1);
            frame.add(button2);
            frame.setVisible(true);



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



