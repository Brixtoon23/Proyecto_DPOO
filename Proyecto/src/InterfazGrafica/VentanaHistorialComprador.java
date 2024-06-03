package InterfazGrafica;

import javax.swing.*;
import Logica.Galeria;
import Logica.Comprador;
import Logica.Compra;
import Logica.Pieza;
import Persistencia.InicializadorDeClases;
import Logica.Administrador;
import Logica.Servicios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaHistorialComprador extends JFrame implements ActionListener {
    private Galeria galeria;
    private JTextField txtNombreComprador;
    private JTextArea txtAreaHistorial;
    private JButton btnBuscar;
    private JButton btnVolver;

    public VentanaHistorialComprador() {
        galeria = InicializadorDeClases.cargarGaleria();

        setTitle("Historial del Comprador");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        JLabel lblNombreComprador = new JLabel("Ingrese el login del comprador:");
        lblNombreComprador.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtNombreComprador = new JTextField();
        txtNombreComprador.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtNombreComprador.setMaximumSize(new Dimension(500, 30));

        txtAreaHistorial = new JTextArea();
        txtAreaHistorial.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtAreaHistorial.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaHistorial);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(this);
        btnBuscar.setActionCommand("Buscar");

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnVolver.setFocusable(false);
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("Volver");

        panelCentro.add(lblNombreComprador);
        panelCentro.add(txtNombreComprador);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(scrollPane);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(btnBuscar);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(btnVolver);

        add(panelCentro, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Buscar")) {
            String nombreComprador = txtNombreComprador.getText();
            Comprador comprador = Servicios.buscarComprador(galeria, nombreComprador);

            if (comprador != null) {
                StringBuilder historial = new StringBuilder();

                historial.append("A continuación verá las piezas que ha comprado el cliente con su respectiva fecha:\n\n");
                for (Compra compra : comprador.getHistorialCompras()) {
                    historial.append("El nombre de la pieza es " + compra.getNombrepieza() + " y fue comprada en " + compra.getFecha() + ".\n");
                }

                historial.append("\nA continuación verá las piezas de las cuales el comprador es dueño:\n\n");
                for (String piezaNombre : comprador.getIdpiezasCompradas()) {
                    Pieza pieza = Servicios.buscarPieza(galeria, piezaNombre);
                    String loginPropietario = comprador.getLogin().replace("_comprador", "_propietario");

                    if (pieza.getLoginPropietarioActual().equals(loginPropietario)) {
                        historial.append(pieza.getTitulo() + "\n");
                    }
                }

                historial.append("\nEl valor de la colección del cliente es: " + Administrador.montoColeccion(galeria, nombreComprador) + "\n");

                txtAreaHistorial.setText(historial.toString());
            } else {
                txtAreaHistorial.setText("El comprador no se encuentra en la base de datos.");
            }
        } else if (e.getActionCommand().equals("Volver")) {
            this.dispose();
            VentanaAdministrador ventanaAdmin = new VentanaAdministrador();
            ventanaAdmin.setVisible(true);
            ventanaAdmin.setLocationRelativeTo(null);
        }
    }

    public static void main(String[] args) {
        VentanaHistorialComprador iniciar = new VentanaHistorialComprador();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}

