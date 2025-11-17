package com.alura.moneyexchange;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Moneda");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas
        JLabel fromLabel = new JLabel("Moneda origen:");
        fromLabel.setBounds(20, 20, 120, 25);
        JLabel toLabel = new JLabel("Moneda destino:");
        toLabel.setBounds(20, 60, 120, 25);
        JLabel amountLabel = new JLabel("Cantidad:");
        amountLabel.setBounds(20, 100, 120, 25);

        // Listas desplegables dinámicas
        JComboBox<String> fromCombo = new JComboBox<>(CurrencyAPI.getCurrencies());
        fromCombo.setBounds(150, 20, 100, 25);
        JComboBox<String> toCombo = new JComboBox<>(CurrencyAPI.getCurrencies());
        toCombo.setBounds(150, 60, 100, 25);

        // Campo de cantidad
        JTextField amountField = new JTextField("100");
        amountField.setBounds(150, 100, 100, 25);

        // Botón de convertir
        JButton convertButton = new JButton("Convertir");
        convertButton.setBounds(150, 140, 100, 25);

        // Resultado
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 180, 400, 25);

        // Agregar componentes al frame
        frame.add(fromLabel);
        frame.add(toLabel);
        frame.add(amountLabel);
        frame.add(fromCombo);
        frame.add(toCombo);
        frame.add(amountField);
        frame.add(convertButton);
        frame.add(resultLabel);

        // Acción del botón
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String from = fromCombo.getSelectedItem().toString();
                    String to = toCombo.getSelectedItem().toString();
                    double amount = Double.parseDouble(amountField.getText());

                    double rate = CurrencyAPI.getRate(from, to);

                    if (rate != -1) {
                        double result = amount * rate;
                        resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, from, result, to));
                    } else {
                        resultLabel.setText("No se pudo obtener la tasa.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Ingrese un número válido.");
                }
            }
        });

        frame.setVisible(true);
    }
}
