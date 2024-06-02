package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPayU extends JFrame implements ActionListener {
    private JButton pagarDaviviendaButton;
    private JButton pagarBancolombiaButton;
    private JButton salirButton;

    public VentanaPayU() {
        setTitle("Pago con PayU");
        setSize(600, 400); // Tamaño doble
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        pagarDaviviendaButton = new JButton("Pagar con Davivienda");
        pagarDaviviendaButton.addActionListener(this);
        add(pagarDaviviendaButton);

        pagarBancolombiaButton = new JButton("Pagar con Bancolombia");
        pagarBancolombiaButton.addActionListener(this);
        add(pagarBancolombiaButton);

        salirButton = new JButton("Salir");
        salirButton.addActionListener(this);
        add(salirButton);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pagarDaviviendaButton) {
            // Abrir la ventana de Davivienda
            VentanaDavivienda ventanaDavivienda = new VentanaDavivienda();
            ventanaDavivienda.setVisible(true);
        } else if (e.getSource() == pagarBancolombiaButton) {
            // Abrir la ventana de Bancolombia
            VentanaBancolombia ventanaBancolombia = new VentanaBancolombia();
            ventanaBancolombia.setVisible(true);
        } else if (e.getSource() == salirButton) 
        {
            
        }

    }

    public static void main(String[] args) {
        VentanaPayU ventanaPayU = new VentanaPayU();
        ventanaPayU.setVisible(true);
    }
}
