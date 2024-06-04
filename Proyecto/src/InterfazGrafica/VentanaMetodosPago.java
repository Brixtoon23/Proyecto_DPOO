package InterfazGrafica;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaMetodosPago extends JFrame implements ActionListener {
    private JPanel panelC;
    private JPanel Efectivo;
    private JPanel Tarjeta;
    private JPanel Transferencia;

    private JButton btnEfectivo;
    private JButton btnTarjeta;
    private JButton btnTransferencia;
    private JButton btnVolver;
    private Galeria galeria;

    public VentanaMetodosPago() {
        setTitle("Métodos de Pago");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        panelC = new JPanel();
        panelC.setLayout(new BoxLayout(panelC, BoxLayout.Y_AXIS));

        btnEfectivo = crearBoton("Efectivo");
        btnTarjeta = crearBoton("Tarjeta");
        btnTransferencia = crearBoton("Transferencia");
        btnVolver = crearBoton("Volver");

        agregarBotonConEspacio(btnEfectivo);
        agregarBotonConEspacio(btnTarjeta);
        agregarBotonConEspacio(btnTransferencia);
        agregarBotonConEspacio(btnVolver);

        add(panelC, BorderLayout.CENTER);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Verdana", Font.PLAIN, 15));
        boton.setFocusable(false);
        boton.setPreferredSize(new Dimension(500, 50));
        boton.addActionListener(this);
        boton.setActionCommand(texto); 
        return boton;
    }

    private void agregarBotonConEspacio(JButton boton) {
        panelC.add(boton);
        panelC.add(Box.createRigidArea(new Dimension(0, 10))); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Efectivo":
                VentanaCompraEfectivoPrecioFijo ventanaEfectivo = new VentanaCompraEfectivoPrecioFijo();
                ventanaEfectivo.setVisible(true);
                ventanaEfectivo.setLocationRelativeTo(null);
                break;
            case "Tarjeta":
                VentanaPasarelas ventanaPasarelas = new VentanaPasarelas();
                ventanaPasarelas.setVisible(true);
                ventanaPasarelas.setLocationRelativeTo(null);
                break;
            case "Transferencia":
                VentanaPayU ventanaTransferencia = new VentanaPayU();
                ventanaTransferencia.setVisible(true);
                ventanaTransferencia.setLocationRelativeTo(null);
                break;
            case "Volver":
                VentanaComprador ventanaComprador = new VentanaComprador();
                ventanaComprador.setVisible(true);
                ventanaComprador.setLocationRelativeTo(null);
                this.dispose();
                break;
        }
    }

    public static void main(String[] args) {
        VentanaMetodosPago iniciar = new VentanaMetodosPago();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}

