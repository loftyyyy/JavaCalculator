package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private String[] buttonLabel = {"C", "+/-", "%", "÷", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", "0", ".", "="};


    public static void main(String[] args){
        new Calculator().createGUI();

    }
    public void createGUI(){
        JFrame window = new JFrame("Calculator");
        JPanel textAreaPanel = new JPanel();
        JPanel buttonPanel = new JPanel();



        window.setVisible(true);
        window.setSize(400,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
