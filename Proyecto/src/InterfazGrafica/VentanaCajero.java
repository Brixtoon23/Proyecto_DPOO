package InterfazGrafica;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Galeria;
import Persistencia.InicializadorDeClases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaCajero extends JFrame implements ActionListener
{
    private JButton btnHistorialPieza;
    private JButton btnHistorialAutor;
    private JButton btnSalir;
    private JButton btnPago;
    private JLabel lblTitulo;
    private Galeria galeria;

    public VentanaCajero()
    {
        setTitle("Menú Cajero");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new GridBagLayout());
        lblTitulo = new JLabel("Bienvenido al menú de Cajero");
        lblTitulo.setFont(new Font("Verdana",Font.BOLD,30));
        pnlNorte.add(lblTitulo);
        pnlNorte.add(Box.createVerticalStrut(200));

        add(pnlNorte,BorderLayout.NORTH);

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridLayout(6,1,20,20));
        pnlCentro.setPreferredSize(new Dimension(200,200));
        
        btnHistorialPieza = new JButton("Consultar historial de una pieza");
        btnHistorialPieza.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistorialPieza.setFocusable(false);
        btnHistorialPieza.addActionListener(this);
        btnHistorialPieza.setActionCommand("HistPieza");
        btnHistorialAutor = new JButton("Consultar historial de un artista");
        btnHistorialAutor.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistorialAutor.setFocusable(false);
        btnHistorialAutor.addActionListener(this);
        btnHistorialAutor.setActionCommand("HistArtista");
        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Verdana",Font.PLAIN,20));
        btnSalir.setForeground(Color.RED);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("Salir");
        btnPago = new JButton("Consultar info medio de pago");
        btnPago.setFont(new Font("Verdana",Font.PLAIN,20));
        btnPago.setFocusable(false);
        btnPago.addActionListener(this);
        btnPago.setActionCommand("Pago");

        pnlCentro.add(Box.createVerticalStrut(15));
        pnlCentro.add(btnHistorialPieza);
        pnlCentro.add(btnHistorialAutor);
        pnlCentro.add(btnPago);
        pnlCentro.add(btnSalir);
        pnlCentro.add(Box.createVerticalStrut(10));

        add(pnlCentro, BorderLayout.CENTER);

        add(Box.createHorizontalStrut(100),BorderLayout.WEST);
        add(Box.createHorizontalStrut(100),BorderLayout.EAST);
    }

    public static void main(String[] args)
    {
        VentanaCajero iniciar = new VentanaCajero();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("HistPieza"))
        {
            this.dispose();
            VentanaHistorialPieza ventana1 = new VentanaHistorialPieza();
            ventana1.setVentanaAnterior("Cajero");
            ventana1.setGaleria(galeria);
            ventana1.setVisible(true);
            ventana1.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("HistArtista"))
        {
            this.dispose();
            VentanaHistorialArtista ventana2 = new VentanaHistorialArtista();
            ventana2.setVentanaAnterior("Cajero");
            ventana2.setGaleria(galeria);
            ventana2.setVisible(true);
            ventana2.setLocationRelativeTo(null);
        }
    }
}
