package InterfazGrafica;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPropietario extends JFrame implements ActionListener
{
    private JLabel lblTitulo;
    private JButton btnHistoriaPieza;
    private JButton btnHistoriaArtist;
    private JButton btnHistorialPiezas;
    private JButton btnMisPiezas;
    private JButton btnSalir;
    private JPanel panelN;
    private JPanel panelC;

    public VentanaPropietario()
    {
        setTitle("Menú Propietario");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelN = new JPanel();
        panelN.setLayout(new GridBagLayout());
        lblTitulo = new JLabel("Bienvenido al menú Propietario");
        lblTitulo.setFont(new Font("Verdana",Font.BOLD,30));
        panelN.add(lblTitulo);
        panelN.add(Box.createVerticalStrut(200));

        add(panelN,BorderLayout.NORTH);

        panelC = new JPanel();
        panelC.setLayout(new GridLayout(2,1,0,5));

        JPanel organizadorBtnsAction = new JPanel();
        organizadorBtnsAction.setLayout(new GridLayout(2,2));

        btnHistoriaPieza = new JButton("Consultar historial de una pieza");
        btnHistoriaPieza.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistoriaPieza.setFocusable(false);
        btnHistoriaPieza.addActionListener(this);
        btnHistoriaPieza.setActionCommand("HistPieza");
        btnHistoriaArtist = new JButton("Consultar historia de un artista");
        btnHistoriaArtist.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistoriaArtist.setFocusable(false);
        btnHistoriaArtist.addActionListener(this);
        btnHistoriaArtist.setActionCommand("HistArtist");
        btnHistorialPiezas = new JButton("Consultar piezas pasadas");
        btnHistorialPiezas.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistorialPiezas.setFocusable(false);
        btnHistorialPiezas.addActionListener(this);
        btnHistorialPiezas.setActionCommand("PiezasPast");
        btnMisPiezas = new JButton("Mis piezas");
        btnMisPiezas.setFont(new Font("Verdana",Font.PLAIN,20));
        btnMisPiezas.setFocusable(false);
        btnMisPiezas.addActionListener(this);
        btnMisPiezas.setActionCommand("MisPiezas");

        organizadorBtnsAction.add(btnHistoriaPieza);
        organizadorBtnsAction.add(btnHistoriaArtist);
        organizadorBtnsAction.add(btnHistorialPiezas);
        organizadorBtnsAction.add(btnMisPiezas);

        panelC.add(organizadorBtnsAction);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Verdana",Font.PLAIN,20));
        btnSalir.setForeground(Color.RED);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("Salir");

        JPanel espacioBtnSalir = new JPanel();
        espacioBtnSalir.setLayout(new GridBagLayout());
        espacioBtnSalir.add(btnSalir);

        panelC.add(espacioBtnSalir);

        add(panelC,BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("HistPieza"))
        {
            this.dispose();
            VentanaHistorialPieza ventana1 = new VentanaHistorialPieza();
            ventana1.setVentanaAnterior("Propietario");
            ventana1.setVisible(true);
            ventana1.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("HistArtist"))
        {
            this.dispose();
            VentanaHistorialArtista ventana2 = new VentanaHistorialArtista();
            ventana2.setVentanaAnterior("Propietario");
            ventana2.setVisible(true);
            ventana2.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("PiezasPast"))
        {
            this.dispose();
            VentanaPiezasPasadas ventana3 = new VentanaPiezasPasadas();
            ventana3.setVisible(true);
            ventana3.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("MisPiezas"))
        {
            this.dispose();
            VentanaPiezasActuales ventana4 = new VentanaPiezasActuales();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }

        else
        {
        }
    }

    public static void main(String[] args)
    {
        VentanaPropietario iniciar = new VentanaPropietario();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }

}
