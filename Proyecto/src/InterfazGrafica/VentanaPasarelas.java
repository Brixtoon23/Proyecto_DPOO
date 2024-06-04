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



public class VentanaPasarelas extends JFrame implements ActionListener {
    
    private JPanel panelC;
    private JPanel PayU;
    private JPanel Pse;


    private JButton btnPayU;
    private JButton btnPse;
    private JButton btnVolver;
    private Galeria galeria;


    public VentanaPasarelas()
    {
        setTitle("Métodos de Pago");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        panelC = new JPanel();
        panelC.setLayout(new BoxLayout(panelC, BoxLayout.Y_AXIS));

        btnPayU = crearBoton("PayU");
        btnPse = crearBoton("PSE");
        btnVolver = crearBoton("Volver");

        agregarBotonConEspacio( btnPayU);
        agregarBotonConEspacio(btnPse);
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
            case "Pse":
                VentanaPSE ventanaPSE = new VentanaPSE();
                ventanaPSE.setVisible(true);
                ventanaPSE.setLocationRelativeTo(null);
                break;
            case "PayU":
                VentanaPayU ventanaPayU = new VentanaPayU();
                ventanaPayU.setVisible(true);
                ventanaPayU.setLocationRelativeTo(null);
                break;

                case "Volver":
                VentanaMetodosPago ventanaMetodosPago = new VentanaMetodosPago();
                ventanaMetodosPago.setVisible(true);
                ventanaMetodosPago.setLocationRelativeTo(null);
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
