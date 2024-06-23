package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JTextArea textArea;
    private String[] buttonLabel = {"C", "+/-", "%", "÷", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", "00", ".", "="};


    public static void main(String[] args){
        new Calculator().createGUI();

    }
    public void createGUI(){
        JFrame window = new JFrame("Calculator");
        JPanel textAreaPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(5,4));

        textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createEmptyBorder(90,10,90,10));
        textArea.setEditable(false);
        Font bigFont = textArea.getFont().deriveFont(18f);

        textArea.setFont(bigFont);
        textArea.setForeground(Color.white);
        textArea.setBackground(Color.decode("#0C0C0C"));
        textAreaPanel.setBackground(Color.decode("#0C0C0C"));
        textAreaPanel.add(textArea);

        for(int i = 0; i < 20; i++){
            JButton button = new JButton(buttonLabel[i]);
            Font buttonFont = new Font("Tahoma", Font.BOLD, 20);
            button.setFont(buttonFont);
            button.addActionListener(new BtnActionListener());
            button.setBorder(BorderFactory.createBevelBorder(3));
            if(buttonLabel[i].equals("÷") || buttonLabel[i].equals("x") || buttonLabel[i].equals("-") || buttonLabel[i].equals("+") || buttonLabel[i].equals("=") ){
                button.setBackground(Color.decode("#E0A75E"));
            }else if(buttonLabel[i].equals("C") || buttonLabel[i].equals("+/-") || buttonLabel[i].equals("%")){
                button.setBackground(Color.decode("#F2613F"));

            }else{
                button.setBackground(Color.decode("#E7D4B5"));

            }
            buttonPanel.add(button);
        }


        window.getContentPane().setBackground(Color.decode("#0C0C0C"));
        window.getContentPane().add(BorderLayout.NORTH, textAreaPanel);
        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);

        window.setVisible(true);
        window.setSize(400,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    class BtnActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonLabel = e.getActionCommand();
            if(buttonLabel.equals("C")){
                textArea.setText("");
            }else{
                textArea.append(buttonLabel);
            }

        }
    }

}
