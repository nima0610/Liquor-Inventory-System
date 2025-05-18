import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumCalculator extends JFrame {
    private JTextField num1Field, num2Field, sumField;
    private JButton sumButton;

    public SumCalculator() {
        setTitle("Sum Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create components
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        sumField = new JTextField(10);
        sumField.setEditable(false); // Make sumField read-only
        sumButton = new JButton("Calculate Sum");

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(new JLabel("Number 1:"));
        add(num1Field);
        add(new JLabel("Number 2:"));
        add(num2Field);
        add(sumButton);
        add(new JLabel("Sum:"));
        add(sumField);

        // Add action listener to the button
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the numbers from the text fields
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                // Calculate the sum
                int sum = num1 + num2;

                // Display the sum in the sumField
                sumField.setText(Integer.toString(sum));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SumCalculator().setVisible(true);
            }
        });
    }
}