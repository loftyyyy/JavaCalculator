package org.example;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Calculator {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JTextPane textPane;
    private String[] buttonLabel = {"C", "+/-", "%", "÷", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", "00", ".", "="};


    public static void main(String[] args){
        new Calculator().createGUI();

    }
    public void createGUI(){
        JFrame window = new JFrame("Calculator");
        JPanel textPanePanel = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(5,4));

        textPane = new JTextPane();
        textPane.setBorder(BorderFactory.createEmptyBorder(90,10,90,10));
        textPane.setEditable(false);
        Font bigFont = textPane.getFont().deriveFont(18f);

        textPane.setFont(bigFont);
        textPane.setForeground(Color.white);
        textPane.setBackground(Color.decode("#0C0C0C"));

//        StyledDocument doc = textPane.getStyledDocument();
//        SimpleAttributeSet right = new SimpleAttributeSet();
//        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
//        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
//        doc.setParagraphAttributes(0, doc.getLength(), right, false);
        
        textPanePanel.setBackground(Color.decode("#0C0C0C"));
        textPanePanel.add(textPane);

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
        window.getContentPane().add(BorderLayout.NORTH, textPanePanel);
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
                textPane.setText("");
            } else{
                textPane.setText(textPane.getText() + buttonLabel);
            }
            if(buttonLabel.equals("=")){
                Expression expression = new Expression(textPane.getText());
                try {
                    EvaluationValue result = expression.evaluate();
                    textPane.setText(String.valueOf(result.getNumberValue()));
                } catch (EvaluationException ex) {
                    throw new RuntimeException(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }
    }

}
