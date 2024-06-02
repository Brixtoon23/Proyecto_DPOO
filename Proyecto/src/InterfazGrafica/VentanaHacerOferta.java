package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.Galeria;
import Logica.Oferta;
import Logica.Operador;

public class VentanaHacerOferta extends JFrame {
    private Galeria galeria;
    private JTextField nombrePiezaField;
    private JTextField valorOfertadoField;
    private JTextField metodoPagoField;
    private JTextField fechaField;
    private JTextField LoginField;

    public VentanaHacerOferta() {
        setTitle("Hacer oferta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5)); // Adjusted to fit extra button

        // Labels and TextFields
        add(new JLabel("Ingrese su login:"));
        LoginField = new JTextField();
        add(LoginField);

        add(new JLabel("Ingrese el nombre de la pieza:"));
        nombrePiezaField = new JTextField();
        add(nombrePiezaField);

        add(new JLabel("Ingrese el valor ofertado:"));
        valorOfertadoField = new JTextField();
        add(valorOfertadoField);

        add(new JLabel("Ingrese el método de pago:"));
        metodoPagoField = new JTextField();
        add(metodoPagoField);

        add(new JLabel("Ingrese la fecha (dia/mes/año):"));
        fechaField = new JTextField();
        add(fechaField);

        // Button to submit the offer
        JButton submitButton = new JButton("Hacer oferta");
        add(submitButton);

        // Label to show the result
        JLabel resultLabel = new JLabel("");
        add(resultLabel);

        // Button to go back to the main menu
        JButton backButton = new JButton("Volver al Menú");
        add(backButton);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePieza = nombrePiezaField.getText();
                int valorOfertado;
                try {
                    valorOfertado = Integer.parseInt(valorOfertadoField.getText());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("El valor ofertado debe ser un número.");
                    return;
                }
                String login = LoginField.getText();
                String metodoPago = metodoPagoField.getText();
                String fecha = fechaField.getText();

                Oferta oferta = new Oferta(login, valorOfertado, metodoPago, nombrePieza, fecha);
                Operador.registrarOferta(oferta, galeria.getSubastas(), galeria, fecha);

                resultLabel.setText("Revisa tus mensajes para saber si la venta fue exitosa");
            }
        });

        // Action listener for the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaComprador ventanaComprador = new VentanaComprador();
                ventanaComprador.setVisible(true);
                dispose(); // Close the current window
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaHacerOferta iniciar = new VentanaHacerOferta();
                iniciar.setVisible(true);
                iniciar.setLocationRelativeTo(null);
            }
        });
    }
}


