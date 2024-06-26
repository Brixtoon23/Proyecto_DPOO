package InterfazGrafica;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador extends JFrame implements ActionListener {
    private JPanel panelN;
    private JPanel panelC;

    private JButton btnHistoriaArtista;
    private JButton btnCrearSubasta;
    private JButton btnCargarPieza;
    private JButton btnHistorialComprador;
    private JButton btnHistoriaPieza;
    private JButton btnHistorialCompras;

    private JButton btnSalir;
    private Galeria galeria;

    public VentanaAdministrador() {
        setTitle("Menú Administrador");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelN = new PanelNorteAdministrador();
        add(panelN, BorderLayout.NORTH);

        galeria = InicializadorDeClases.cargarGaleria();

        panelC = new JPanel();

        // Crear los botones con el tamaño y la fuente especificados
        btnCrearSubasta = crearBoton("Crear Subasta");
        btnCrearSubasta.setFocusable(false);
        btnCrearSubasta.addActionListener(this);
        btnCrearSubasta.setActionCommand("CrearSubasta");

        btnCargarPieza = crearBoton("Cargar Pieza");
        btnCargarPieza.setFocusable(false);
        btnCargarPieza.addActionListener(this);
        btnCargarPieza.setActionCommand("CargarPieza");

        btnHistorialComprador = crearBoton("Ver Historial Comprador");
        btnHistorialComprador.setFocusable(false);
        btnHistorialComprador.addActionListener(this);
        btnHistorialComprador.setActionCommand("HistorialComprador");

        btnHistoriaPieza = crearBoton("Consultar historial de una pieza");
        btnHistoriaPieza.setFocusable(false);
        btnHistoriaPieza.addActionListener(this);
        btnHistoriaPieza.setActionCommand("HistPieza");

        btnHistoriaArtista = crearBoton("Consultar historial de un artista");
        btnHistoriaArtista.setFocusable(false);
        btnHistoriaArtista.addActionListener(this);
        btnHistoriaArtista.setActionCommand("HistArtista");

        btnHistorialCompras = crearBoton("Ver historial de compras en un año");
        btnHistorialCompras.setFocusable(false);
        btnHistorialCompras.addActionListener(this);
        btnHistorialCompras.setActionCommand("HistorialCompras");

        btnSalir = crearBoton("Salir");
        btnSalir.setForeground(Color.RED);
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);
        btnSalir.setActionCommand("Salir");

        agregarBotonConEspacio(btnCargarPieza);
        agregarBotonConEspacio(btnCrearSubasta);
        agregarBotonConEspacio(btnHistorialComprador);
        agregarBotonConEspacio(btnHistoriaPieza);
        agregarBotonConEspacio(btnHistoriaArtista);
        agregarBotonConEspacio(btnHistorialCompras);
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
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("HistPieza")) {
            this.dispose();
            VentanaHistorialPieza ventana1 = new VentanaHistorialPieza();
            ventana1.setVentanaAnterior("Admin");
            ventana1.setGaleria(galeria);
            ventana1.setVisible(true);
            ventana1.setLocationRelativeTo(null);
        } 
        
        else if (e.getActionCommand().equals("HistArtista")) {
            this.dispose();
            VentanaHistorialArtista ventana2 = new VentanaHistorialArtista();
            ventana2.setVentanaAnterior("Admin");
            ventana2.setGaleria(galeria);
            ventana2.setVisible(true);
            ventana2.setLocationRelativeTo(null);
        } 
        
        else if (e.getActionCommand().equals("CrearSubasta")) {
            this.dispose();
            VentanaCrearSubasta ventana4 = new VentanaCrearSubasta();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        } 
        
        else if (e.getActionCommand().equals("CargarPieza")) {
            this.dispose();
            VentanaCargarPieza ventana4 = new VentanaCargarPieza();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }
        
        else if (e.getActionCommand().equals("HistorialComprador")) {

            this.dispose();
            VentanaHistorialComprador ventana4 = new VentanaHistorialComprador();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
            
        }

        else if (e.getActionCommand().equals("HistorialCompras")) {

            this.dispose();
            //VentanaHistorialCompras ventana4 = new VentanaHistorialCompras();
            //ventana4.setVisible(true);
            //ventana4.setLocationRelativeTo(null);
            
        }
        

        else if(e.getActionCommand().equals("Salir"))
        {
            this.dispose();
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

       

       



        
    }

    public static void main(String[] args) {
        VentanaAdministrador iniciar = new VentanaAdministrador();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}




