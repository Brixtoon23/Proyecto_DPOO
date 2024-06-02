package InterfazGrafica;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import Logica.Galeria;
import Persistencia.InicializadorDeClases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaComprador extends JFrame implements ActionListener
{ 

    private JPanel panelN;
    private JPanel panelC;
    private JPanel PiezasSubasta;
    private JPanel PiezasPrecioFijo;
    private JPanel HacerOferta;
    private JPanel ComprasAprobadas;

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
        panelN = new PanelNorteComprador();
        add(panelN, BorderLayout.NORTH);

        galeria = InicializadorDeClases.cargarGaleria();

        panelC = new JPanel();
      
        PiezasSubasta = new JPanel();
        PiezasPrecioFijo = new JPanel();
        HacerOferta = new JPanel();
        ComprasAprobadas = new JPanel();

        // Crear los botones con el tamaño y la fuente especificados
        btnPiezasSubasta = crearBoton("Ver Piezas Subasta");
        btnPiezasSubasta.setFocusable(false);
        btnPiezasSubasta.addActionListener(this);
        btnPiezasSubasta.setActionCommand("PiezaSubasta");
        

        btnPiezasPrecioFijo = crearBoton("Ver Piezas a precio fijo");
        btnPiezasPrecioFijo.setFocusable(false);
        btnPiezasPrecioFijo.addActionListener(this);
        btnPiezasPrecioFijo.setActionCommand("PiezaPrecioFijo");
        


        btnHacerOferta = crearBoton("Hacer oferta para pieza subastada");
        btnHacerOferta.setFocusable(false);
        btnHacerOferta.addActionListener(this);
        btnHacerOferta.setActionCommand("HacerOferta");


        btnComprasAprobadas = crearBoton("Ver Compra no aprobadas y aprobadas por subasta");
        btnComprasAprobadas.setFocusable(false);
        btnComprasAprobadas.addActionListener(this);
        btnComprasAprobadas.setActionCommand("ComprasAprobadas");


        btnHistoriaPieza = crearBoton("Consultar historial de una pieza");
        btnHistoriaPieza.setFocusable(false);
        btnHistoriaPieza.addActionListener(this);
        btnHistoriaPieza.setActionCommand("HistPieza");

        // Inicialización y configuración de btnHistoriaArtista
        btnHistoriaArtista = crearBoton("Consultar historial de un artista");
        btnHistoriaArtista.setFocusable(false);
        btnHistoriaArtista.addActionListener(this);
        btnHistoriaArtista.setActionCommand("HistArtista");
        
        btnSalir = crearBoton("Salir");
        btnSalir.setForeground(Color.RED);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("Salir");

        agregarBotonConEspacio(btnPiezasSubasta);
        agregarBotonConEspacio(btnPiezasPrecioFijo);
        agregarBotonConEspacio(btnHacerOferta);
        agregarBotonConEspacio(btnComprasAprobadas);
        agregarBotonConEspacio(btnHistoriaPieza);
        agregarBotonConEspacio(btnHistoriaArtista); 
        agregarBotonConEspacio(btnSalir);

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

        else if(e.getActionCommand().equals("PiezaSubasta"))
        {
            this.dispose();
            VentanaPiezasSubasta ventana3 = new VentanaPiezasSubasta();
            
            ventana3.setVisible(true);
            ventana3.setLocationRelativeTo(null);

        }

        else if(e.getActionCommand().equals("PiezaPrecioFijo"))
        {
            this.dispose();
            VentanaPiezasPrecioFijo ventana3 = new VentanaPiezasPrecioFijo();
            
            ventana3.setVisible(true);
            ventana3.setLocationRelativeTo(null);

        }


        else if(e.getActionCommand().equals("HacerOferta"))
        {

        }

        else if(e.getActionCommand().equals("ComprasAprobadas"))
        {

        }

       



        
    }

    public static void main(String[] args)
    {
        VentanaComprador iniciar = new VentanaComprador();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}
