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

public class VentanaComprador extends JFrame implements ActionListener
{ 

  
    private JPanel panelN;
    private JPanel panelC;
    private JButton btnHistoriaArtista;
    private JButton  btnPiezasSubasta;
    private JButton  btnPiezasPrecioFijo;
    private JButton btnHacerOferta;
    private JButton btnComprasAprobadas;
    private JButton btnHistoriaPieza;
    private JButton btnSalir;
    private Galeria galeria; 

   
       
    public VentanaComprador()
    {
        setTitle("Menú Comprador");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        panelN = new PanelNorteComprador();
        add(panelN, BorderLayout.NORTH);

        panelC = new PanelCentroOperador();

        btnPiezasSubasta = new JButton("Ver Piezas Subasta");
        btnPiezasSubasta.setFont(new Font("Verdana",Font.PLAIN,20));
        btnPiezasSubasta.setFocusable(false);
        btnPiezasSubasta.addActionListener(this);
        btnPiezasSubasta.setActionCommand("HistPieza");


        btnPiezasPrecioFijo = new JButton("Ver Piezas a precio fijo");
        btnPiezasPrecioFijo.setFont(new Font("Verdana",Font.PLAIN,20));
        btnPiezasPrecioFijo.setFocusable(false);
        btnPiezasPrecioFijo.addActionListener(this);
        btnPiezasPrecioFijo.setActionCommand("HistPieza");


        btnHacerOferta = new JButton("Hacer oferta para pieza subastada");
        btnHacerOferta.setFont(new Font("Verdana",Font.PLAIN,20));
        btnHacerOferta.setFocusable(false);
        btnHacerOferta.addActionListener(this);
        btnHacerOferta.setActionCommand("HistPieza");



        btnComprasAprobadas = new JButton("ver Compra no aprobadas por subasta");
        btnComprasAprobadas.setFont(new Font("Verdana",Font.PLAIN,20));
        btnComprasAprobadas.setFocusable(false);
        btnComprasAprobadas.addActionListener(this);
        btnComprasAprobadas.setActionCommand("HistPieza");



        




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
            ventana1.setVentanaAnterior("Comprador");
            ventana1.setGaleria(galeria);
            ventana1.setVisible(true);
            ventana1.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("HistArtista"))
        {
            this.dispose();
            VentanaHistorialArtista ventana2 = new VentanaHistorialArtista();
            ventana2.setVentanaAnterior("Comprador");
            ventana2.setGaleria(galeria);
            ventana2.setVisible(true);
            ventana2.setLocationRelativeTo(null);
        }
        
    }

    public static void main(String[] args)
    {
        VentanaComprador iniciar = new VentanaComprador();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }

}