package InterfazGrafica;

import javax.swing.*;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Logica.Administrador;

public class VentanaCrearSubasta extends JFrame implements ActionListener {
    private Galeria galeria;
    private JTextField txtID;
    private JTextField txtPiezas;
    private JButton btnCrearSubasta;
    private JButton btnVolver;

    public VentanaCrearSubasta() {
        galeria = InicializadorDeClases.cargarGaleria();
        
        setTitle("Crear Subasta");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        JLabel lblID = new JLabel("Ingrese el ID de la subasta:");
        lblID.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtID = new JTextField();
        txtID.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtID.setMaximumSize(new Dimension(500, 30));

        JLabel lblPiezas = new JLabel("Ingrese los títulos de las piezas separados por una (,):");
        lblPiezas.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtPiezas = new JTextField();
        txtPiezas.setFont(new Font("Verdana", Font.PLAIN, 15));
        txtPiezas.setMaximumSize(new Dimension(500, 30));

        btnCrearSubasta = new JButton("Crear Subasta");
        btnCrearSubasta.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnCrearSubasta.setFocusable(false);
        btnCrearSubasta.addActionListener(this);
        btnCrearSubasta.setActionCommand("CrearSubasta");

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnVolver.setFocusable(false);
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("Volver");

        panelCentro.add(lblID);
        panelCentro.add(txtID);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(lblPiezas);
        panelCentro.add(txtPiezas);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(btnCrearSubasta);
        panelCentro.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCentro.add(btnVolver);

        add(panelCentro, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CrearSubasta")) {
            String id = txtID.getText();
            String[] piezasArreglo = txtPiezas.getText().split(",");
            ArrayList<String> piezas = new ArrayList<>();
            for (String pieza : piezasArreglo) {
                piezas.add(pieza.trim());
            }
            // Asume que tienes un método Administrador.crearSubasta
            boolean exito = Administrador.crearSusbasta(galeria, id, piezas);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Subasta creada satisfactoriamente.");
                // Limpiar los campos de texto después de mostrar el mensaje
                txtID.setText("");
                txtPiezas.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear la subasta.");
            }
        } else if (e.getActionCommand().equals("Volver")) {
            this.dispose();
            VentanaAdministrador ventanaAdmin = new VentanaAdministrador();
            ventanaAdmin.setVisible(true);
            ventanaAdmin.setLocationRelativeTo(null);
        }
    }

    public static void main(String[] args) {
        VentanaCrearSubasta iniciar = new VentanaCrearSubasta();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}
