package InterfazGrafica;

import javax.swing.*;

import Logica.Galeria;
import Persistencia.InicializadorDeClases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VentanaCargarPieza extends  JFrame implements ActionListener {
 
    private JPanel panelC;
    private JPanel Fotografia;
    private JPanel Video;
    private JPanel Pintura;
    private JPanel Escultura;
    private JPanel Administrador; // Nuevo panel para el botón de administrador

    private JButton btnFotografia;
    private JButton  btnVideo;
    private JButton  btnPintura;
    private JButton btnEscultura;
    private JButton btnAdministrador; // Nuevo botón para ir a la ventana de administrador

    private Galeria galeria; 
    
    public VentanaCargarPieza() {
        setTitle("CargarPieza");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
       
        galeria = InicializadorDeClases.cargarGaleria();

        panelC = new JPanel();
        Fotografia = new JPanel();
        Video = new JPanel();
        Pintura= new JPanel();
        Escultura= new JPanel();
        Administrador = new JPanel(); // Inicializar el nuevo panel

        // Crear los botones con el tamaño y la fuente especificados
        btnFotografia = crearBoton("Fotografia");
        btnFotografia.setFocusable(false);
        btnFotografia.addActionListener(this);
        btnFotografia.setActionCommand("Fotografia");
        
        btnVideo= crearBoton("Video");
        btnVideo.setFocusable(false);
        btnVideo.addActionListener(this);
        btnVideo.setActionCommand("Video");
        
        btnPintura = crearBoton("Pintura");
        btnPintura.setFocusable(false);
        btnPintura.addActionListener(this);
        btnPintura.setActionCommand("Pintura");

        btnEscultura = crearBoton("Escultura");
        btnEscultura.setFocusable(false);
        btnEscultura.addActionListener(this);
        btnEscultura.setActionCommand("Escultura");
        
        // Nuevo botón para ir a la ventana de administrador
        btnAdministrador = crearBoton("volver al menú Administrador");
        btnAdministrador.setFocusable(false);
        btnAdministrador.addActionListener(this);
        btnAdministrador.setActionCommand("Administrador");

        // Agregar botones con espacio
        agregarBotonConEspacio(btnEscultura);
        agregarBotonConEspacio(btnFotografia);
        agregarBotonConEspacio(btnPintura);
        agregarBotonConEspacio(btnVideo);
        // Agregar el botón de administrador
        agregarBotonConEspacio(btnAdministrador);

        add(panelC, BorderLayout.CENTER);
    }

    // Método para crear botones
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Verdana", Font.PLAIN, 15));
        boton.setFocusable(false);
        boton.setPreferredSize(new Dimension(500, 50));
        return boton;
    }

    // Método para agregar botones con espacio
    private void agregarBotonConEspacio(JButton boton) {
        panelC.add(boton);
        panelC.add(Box.createRigidArea(new Dimension(0, 10))); 
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("Fotografia"))
        {
            this.dispose();
            VentanaFotografia ventana4 = new VentanaFotografia();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }
        else if (e.getActionCommand().equals("Pintura"))
        {
            this.dispose();
            VentanaPintura ventana4 = new VentanaPintura();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }
        else if (e.getActionCommand().equals("Video"))
        {
            this.dispose();
            VentanaVideo ventana4 = new VentanaVideo();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }
        else if (e.getActionCommand().equals("Escultura"))
        {
            this.dispose();
            VentanaEscultura ventana4 = new VentanaEscultura();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }
        // Abrir la ventana de administrador cuando se haga clic en el botón correspondiente
        else if (e.getActionCommand().equals("Administrador"))
        {
            this.dispose();
            VentanaAdministrador ventana4 = new VentanaAdministrador();
            ventana4.setVisible(true);
            ventana4.setLocationRelativeTo(null);
        }
    }

    public static void main(String[] args)
    {
        VentanaCargarPieza iniciar = new VentanaCargarPieza();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}
