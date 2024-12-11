package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import items.Mouse;
import items.Laptop;
import items.LCDscreen;
import items.Desktop;
import methods.Calculations;

public class ShippingCalculator extends JFrame {
    private JTextField laptopQuantityField;
    private JTextField mouseQuantityField;
    private JTextField desktopQuantityField;
    private JTextField lcdScreenQuantityField;
    private JButton calculateButton;
    private JTextArea resultTextArea;

    private Calculations calculation;
    private boolean calculationPerformed;

    public ShippingCalculator() {
        calculation = new Calculations();
        calculationPerformed = false;

        setTitle("Shipping Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
     // Create input fields and labels for each item
        JLabel laptopLabel = new JLabel("Laptop:");
        laptopQuantityField = new JTextField();
        inputPanel.add(laptopLabel);
        inputPanel.add(laptopQuantityField);

        JLabel mouseLabel = new JLabel("Mouse:");
        mouseQuantityField = new JTextField();
        inputPanel.add(mouseLabel);
        inputPanel.add(mouseQuantityField);

        JLabel desktopLabel = new JLabel("Desktop:");
        desktopQuantityField = new JTextField();
        inputPanel.add(desktopLabel);
        inputPanel.add(desktopQuantityField);

        JLabel lcdScreenLabel = new JLabel("LCD Screen:");
        lcdScreenQuantityField = new JTextField();
        inputPanel.add(lcdScreenLabel);
        inputPanel.add(lcdScreenQuantityField);

        add(inputPanel, BorderLayout.NORTH);
        // Create calculate button and result text area
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!calculationPerformed) {
                    calculateShipping();
                    calculationPerformed = true;
                    calculateButton.setEnabled(false);
                }
            }
        });

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultPanel.add(calculateButton, BorderLayout.NORTH);
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);

        add(resultPanel, BorderLayout.CENTER);
    }

    private void calculateShipping() {
        try {
        	// Get quantities from the input fields
            int laptopQuantity = Integer.parseInt(laptopQuantityField.getText());
            int mouseQuantity = Integer.parseInt(mouseQuantityField.getText());
            int desktopQuantity = Integer.parseInt(desktopQuantityField.getText());
            int lcdScreenQuantity = Integer.parseInt(lcdScreenQuantityField.getText());
         // Add items to the calculation
            calculation.addItems(new Laptop(), laptopQuantity);
            calculation.addItems(new Mouse(), mouseQuantity);
            calculation.addItems(new Desktop(), desktopQuantity);
            calculation.addItems(new LCDscreen(), lcdScreenQuantity);
            // Perform calculations and retrieve results
            int[] shippingMethod = calculation.bestShipping();
            double totalPrice = calculation.shippingPrice();
            double totalWeight = calculation.totalWeight();
            double totalVolume = calculation.totalVolume();
            // Build the result string
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append("Order Information: ").append(calculation.printItem());
            resultBuilder.append("\nTotal Weight of all items: ").append(totalWeight).append(" kg\n");
            resultBuilder.append("\nTotal Volume of all items: ").append(totalVolume).append(" m3\n");
            resultBuilder.append("\nBest Shipping Method: ").append(shippingMethod[0]).append(" Big Container(s), ")
                    .append(shippingMethod[1]).append(" Small Container(s)\n");
            resultBuilder.append("\nTotal Shipping Price: ").append(totalPrice).append(" €.");
            
         // Set the result string in the text area and have a number format exception, so that the user enters only numbers.
            resultTextArea.setText(resultBuilder.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid quantity.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShippingCalculator().setVisible(true);
            }
        });
    }
}
