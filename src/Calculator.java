
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;


public class Calculator implements ActionListener{
    // The Values you will use throughout the app.
    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10]; // Holds numbers on the calculator.
    JButton[] functionButton = new JButton[9]; // Hold the function like subtract add ect.
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Monospaced",Font.BOLD,50);
    // The number values that get affected from when you use numberButton
    double num1 = 0, num2 = 0, results = 0;
    // The operator that you use when you use functionButton
    char operator;

    Calculator(){
        // this edits the size of the frame you will be using.
        frame = new JFrame("Riley Ray BaptisteIV Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,625);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.darkGray);
        //labels writes Riley calculator at the bottem
        JLabel label = new JLabel("Riley Calculator");
        label.setBounds(-10, 500, 400, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Monospaced", Font.BOLD, 14));
        label.setVisible(true);
        frame.add(label);

        //This edits the bar with the input
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        frame.add(textField);
        // the function buttons we will use.
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("Dl");
        equButton = new JButton("=");
        clrButton = new JButton("Cl");
        negButton = new JButton("-");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        for(int i = 0; i < 9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        for(int i = 0; i < 10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
       // creating the boundarys of the new panel inside the calculator
        panel = new JPanel();
        panel.setBounds(50, 100, 300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.black);
      //placing the buttons in the panel of the calculator
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel); // adds the panel very important
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++){
            if( e.getSource() == numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== decButton){
            textField.setText(textField.getText().concat("."));

        }
        if(e.getSource()== addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='+';
            textField.setText("");
        }
        if(e.getSource()== subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }
        if(e.getSource()== mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }
        if(e.getSource()== divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());
            switch(operator){
                case'+':
                    results = num1+num2;
                    break;
                case'-':
                    results = num1-num2;
                    break;
                case'*':
                    results= num1*num2;
                    break;
                case'/':
                    results= num1/num2;
                    break;
            }
            textField.setText(String.valueOf(results));
            num1 = results;
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i = 0;i < string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            Double temp = Double.parseDouble(textField.getText());
            temp*= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}