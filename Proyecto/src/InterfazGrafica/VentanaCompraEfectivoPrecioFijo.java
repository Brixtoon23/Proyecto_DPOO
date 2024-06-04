package InterfazGrafica;

import javax.swing.*;
import Logica.Galeria;
import Logica.Pieza;
import Logica.Servicios;
import Logica.Comprador;
import Logica.Administrador;
import Persistencia.InicializadorDeClases;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCompraEfectivoPrecioFijo extends JFrame {
    private JTextField loginField;
    private JTextField nombrePiezaField;
    private JTextField fechaField;
    private JButton btnComprar;
    private JButton btnVolver;
    private Galeria galeria;

    public VentanaCompraEfectivoPrecioFijo() {
        setTitle("Compra Efectivo Precio Fijo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));

        panelCampos.add(new JLabel("Login:"));
        loginField = new JTextField();
        panelCampos.add(loginField);
        panelCampos.add(Box.createRigidArea(new Dimension(0, 10)));

        panelCampos.add(new JLabel("Nombre de la Pieza:"));
        nombrePiezaField = new JTextField();
        panelCampos.add(nombrePiezaField);
        panelCampos.add(Box.createRigidArea(new Dimension(0, 10)));

        panelCampos.add(new JLabel("Fecha (dia/mes/año):"));
        fechaField = new JTextField();
        panelCampos.add(fechaField);
        panelCampos.add(Box.createRigidArea(new Dimension(0, 10)));

        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnComprar = new JButton("Comprar");
        btnVolver = new JButton("Volver");
        panelBotones.add(btnComprar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCompra();
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaMetodosPago ventanaMetodosPago = new VentanaMetodosPago();
                ventanaMetodosPago.setVisible(true);
                ventanaMetodosPago.setLocationRelativeTo(null);
                dispose();
            }
        });
    }

    private void realizarCompra() {
        String login = loginField.getText();
        String nombrePieza = nombrePiezaField.getText();
        String fecha = fechaField.getText();
        String metdPago = "efectivo"; // Fijo como "efectivo" para esta ventana
        String pasarela = null; // No se usa pasarela para efectivo

        Pieza piezaCompra = Servicios.buscarPieza(galeria, nombrePieza);
        if (piezaCompra == null || !piezaCompra.isDisponible()) {
            JOptionPane.showMessageDialog(this, "Esa pieza no está disponible para compra por un precio fijo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Comprador comprador = Servicios.buscarComprador(galeria, login);
        if (comprador == null) {
            JOptionPane.showMessageDialog(this, "Comprador no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String mensaje=Administrador.aprobarVentaPrecioFijo(comprador, piezaCompra, metdPago, galeria, fecha, pasarela, "efectivo", "","" );
       
        boolean aprobar =  mensaje.equals("true");
        if (aprobar) {
            JOptionPane.showMessageDialog(this, "La compra fue realizada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos, no se pudo realizar la compra. Revise su estado de cuenta o si está en mora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        VentanaCompraEfectivoPrecioFijo ventana = new VentanaCompraEfectivoPrecioFijo();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}
