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



    private JButton btnFotografia;
    private JButton  btnVideo;
    private JButton  btnPintura;
    private JButton btnEscultura;

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

        
        agregarBotonConEspacio(btnEscultura);
        agregarBotonConEspacio(btnFotografia);
        agregarBotonConEspacio(btnPintura);
        agregarBotonConEspacio(btnVideo);
      

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


       

       



        
    }

    public static void main(String[] args)
    {
        VentanaCargarPieza iniciar = new VentanaCargarPieza();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
}

