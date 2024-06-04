package InterfazGrafica;

import javax.swing.*;
import Logica.*;
import Persistencia.InicializadorDeClases;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDavivienda extends JFrame implements ActionListener {
    private JTextField usuarioField;
    private JPasswordField claveField;
    private JTextField csvField;
    private JTextField nombrePiezaField;
    private JTextField fechaField;
    private JButton pagarButton;
    private JButton volverButton;
    private JLabel resultadoLabel;
    private Galeria galeria;

    public VentanaDavivienda() {
        galeria = InicializadorDeClases.cargarGaleria();
        
        setTitle("Pago con Davivienda");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Usuario:"));
        usuarioField = new JTextField();
        add(usuarioField);

        add(new JLabel("Clave:"));
        claveField = new JPasswordField();
        add(claveField);

        add(new JLabel("CSV:"));
        csvField = new JTextField();
        add(csvField);

        add(new JLabel("Nombre de la pieza:"));
        nombrePiezaField = new JTextField();
        add(nombrePiezaField);

        add(new JLabel("Fecha (dia/mes/año):"));
        fechaField = new JTextField();
        add(fechaField);

        pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(this);
        add(pagarButton);

        volverButton = new JButton("Volver");
        volverButton.addActionListener(this);
        add(volverButton);

        resultadoLabel = new JLabel("");
        add(resultadoLabel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pagarButton) {
            // Obtener valores de los campos
            String usuario = usuarioField.getText();
            String clave = new String(claveField.getPassword());
            String csv = csvField.getText();
            String nombrePieza = nombrePiezaField.getText();
            String fecha = fechaField.getText();
            
            // Buscar la pieza
            Pieza piezaCompra = Servicios.buscarPieza(galeria, nombrePieza);

            // Validar pieza y disponibilidad
            if (piezaCompra == null || !piezaCompra.isDisponible()) {
                resultadoLabel.setText("Esa pieza no está disponible para compra por un precio fijo.");
                return;
            }

            // Procesar la compra
            Comprador comprador = Servicios.buscarComprador(galeria, usuario);
            if (comprador == null) {
                resultadoLabel.setText("Usuario no encontrado.");
                return;
            }
            
            String pasarela = "Davivienda"; // Asumimos que la pasarela es Davivienda
            String mensaje = Administrador.aprobarVentaPrecioFijo(comprador, piezaCompra, "tarjeta", galeria, fecha, pasarela, "davivienda", csv, clave);

            if (mensaje.equals("Pago realizado con éxito")) {
                resultadoLabel.setText("La compra fue realizada exitosamente.");
                // Limpiar los campos de texto después del pago
                usuarioField.setText("");
                claveField.setText("");
                csvField.setText("");
                nombrePiezaField.setText("");
                fechaField.setText("");
            } else {
                resultadoLabel.setText("Lo sentimos, no se pudo realizar la compra. " + mensaje);
            }
        } else if (e.getSource() == volverButton) {
            this.dispose();
            VentanaPasarelas ventanaPasarelas = new VentanaPasarelas();
            ventanaPasarelas.setVisible(true);
            ventanaPasarelas.setLocationRelativeTo(null);
        }
    }

    public static void main(String[] args) {
        VentanaDavivienda ventanaDavivienda = new VentanaDavivienda();
        ventanaDavivienda.setVisible(true);
    }
}
