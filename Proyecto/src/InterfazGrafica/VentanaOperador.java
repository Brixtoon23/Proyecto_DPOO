package InterfazGrafica;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Logica.Galeria;
import Persistencia.InicializadorDeClases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOperador extends JFrame implements ActionListener
{
    private JPanel panelN;
    private JPanel panelC;
    private JButton btnHistoriaArtista;
    private JButton btnHistoriaPieza;
    private JButton btnSalir;
    private Galeria galeria; 

    public VentanaOperador()
    {
        setTitle("Menú Operador");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        panelN = new PanelNorteOperador();
        add(panelN, BorderLayout.NORTH);

        panelC = new PanelCentroOperador();
        btnHistoriaPieza = new JButton("Consultar historial de una pieza");
        btnHistoriaPieza.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistoriaPieza.setFocusable(false);
        btnHistoriaPieza.addActionListener(this);
        btnHistoriaPieza.setActionCommand("HistPieza");
        btnHistoriaArtista = new JButton("Consultar historial de un artista");
        btnHistoriaArtista.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHistoriaArtista.setFocusable(false);
        btnHistoriaArtista.addActionListener(this);
        btnHistoriaArtista.setActionCommand("HistArtista");
        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Verdana",Font.PLAIN,20));
        btnSalir.setForeground(Color.RED);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("Salir");
        panelC.add(Box.createVerticalStrut(15));
        panelC.add(btnHistoriaPieza);
        panelC.add(btnHistoriaArtista);
        panelC.add(btnSalir);
        panelC.add(Box.createVerticalStrut(10));
        add(panelC,BorderLayout.CENTER);

        add(Box.createHorizontalStrut(100),BorderLayout.WEST);
        add(Box.createHorizontalStrut(100),BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("HistPieza"))
        {
            this.dispose();
            VentanaHistorialPieza ventana1 = new VentanaHistorialPieza();
            ventana1.setVentanaAnterior("Operador");
            ventana1.setGaleria(galeria);
            ventana1.setVisible(true);
            ventana1.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("HistArtista"))
        {
            this.dispose();
            VentanaHistorialArtista ventana2 = new VentanaHistorialArtista();
            ventana2.setVentanaAnterior("Operador");
            ventana2.setGaleria(galeria);
            ventana2.setVisible(true);
            ventana2.setLocationRelativeTo(null);
        }
        
    }

    public static void main(String[] args)
    {
        VentanaOperador iniciar = new VentanaOperador();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }


}
