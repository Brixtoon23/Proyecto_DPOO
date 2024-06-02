package InterfazGrafica;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPSE extends JFrame implements ActionListener {
    private JButton pagarDaviviendaButton;
    private JButton salirButton;

    public VentanaPSE() {
        setTitle("Pago con PayU");
        setSize(600, 400); // Tamaño doble
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        pagarDaviviendaButton = new JButton("Pagar con Davivienda");
        pagarDaviviendaButton.addActionListener(this);
        add(pagarDaviviendaButton);

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
        }
        else if (e.getSource() == salirButton) 
        {
            
        }
        
    }

    public static void main(String[] args) {
        VentanaPSE ventanaPSE = new VentanaPSE();
        ventanaPSE.setVisible(true);
    }
}

