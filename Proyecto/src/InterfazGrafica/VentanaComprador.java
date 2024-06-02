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
        btnPiezasPrecioFijo = crearBoton("Ver Piezas a precio fijo");
        btnHacerOferta = crearBoton("Hacer oferta para pieza subastada");
        btnComprasAprobadas = crearBoton("Ver Compra no aprobadas por subasta");
        btnHistoriaPieza = crearBoton("Consultar historial de una pieza");
        btnHistoriaArtista = crearBoton("Consultar historial de un artista");
        btnSalir = crearBoton("Salir");
        btnSalir.setForeground(Color.RED);

        // Agregar los botones y el espacio fijo entre ellos
        agregarBotonConEspacio(btnPiezasSubasta);
        agregarBotonConEspacio(btnPiezasPrecioFijo);
        agregarBotonConEspacio(btnHacerOferta);
        agregarBotonConEspacio(btnComprasAprobadas);
        agregarBotonConEspacio(btnHistoriaPieza);
        agregarBotonConEspacio(btnHistoriaArtista);
        agregarBotonConEspacio(btnSalir);

        add(panelC, BorderLayout.CENTER);
    }

    // Método para crear un botón con el tamaño y la fuente especificados
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        
        boton.setFont(new Font("Verdana", Font.PLAIN, 15));
        boton.setFocusable(false);
        boton.setPreferredSize(new Dimension(500, 50));
        boton.addActionListener(this);
        boton.setActionCommand(texto); // Usar el texto del botón como comando de acción
        return boton;
    }

    // Método para agregar un botón con un espacio fijo debajo
    private void agregarBotonConEspacio(JButton boton) {
        panelC.add(boton);
        panelC.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio fijo vertical
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Manejar los eventos de los botones aquí
        String comando = e.getActionCommand();
        if (comando.equals("Salir")) {
            // Código para salir de la aplicación
        } else if (comando.equals("Consultar historial de una pieza")) {
            // Código para consultar historial de una pieza
        } else if (comando.equals("Consultar historial de un artista")) {
            // Código para consultar historial de un artista
        } else if (comando.equals("Ver Piezas Subasta")) {
            // Código para ver piezas en subasta
        } else if (comando.equals("Ver Piezas a precio fijo")) {
            // Código para ver piezas a precio fijo
        } else if (comando.equals("Hacer oferta para pieza subastada")) {
            // Código para hacer oferta por una pieza subastada
        } else if (comando.equals("Ver Compra no aprobadas por subasta")) {
            // Código para ver compras no aprobadas por subasta
        }
    }

    public static void main(String[] args)
    {
        VentanaComprador iniciar = new VentanaComprador();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}
