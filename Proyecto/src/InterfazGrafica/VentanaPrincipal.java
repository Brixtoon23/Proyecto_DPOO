package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Galeria;
import Logica.Propietario;
import Logica.Servicios;
import Logica.Usuario;
import Persistencia.InicializadorDeClases;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    private JLabel lblTitulo;
    private JLabel lblIniciarSesion;
    private JLabel lblUsuario;
    private JLabel lblContrasenia;
    private JLabel lblNoEstaRegistrado;
    private JTextField txtUsuario;
    private JTextField txtContrasenia;
    private JButton btnIngresar;
    private JButton btnRegistrarse;
    private Galeria galeria;
    
    public VentanaPrincipal()
    {
        setTitle("Ventana principal");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        galeria = InicializadorDeClases.cargarGaleria();

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new GridBagLayout());

        JPanel organizadorN = new JPanel();
        organizadorN.setLayout(new GridLayout(2,1));
        organizadorN.add(Box.createVerticalStrut(20));

        lblTitulo = new JLabel("Bienvenido a la Galería");
        lblTitulo.setFont(new Font("Verdana",Font.BOLD,30));
        organizadorN.add(lblTitulo);

        add(organizadorN,BorderLayout.NORTH);

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridLayout(2,1,0,15));

        JPanel organizadorInicioSesion = new JPanel();
        organizadorInicioSesion.setLayout(new GridLayout(3,1,0,10));
        lblIniciarSesion = new JLabel("Iniciar Sesión");
        lblIniciarSesion.setFont(new Font("Verdana",Font.BOLD,20));
        organizadorInicioSesion.add(lblIniciarSesion);

        JPanel organizadorCampostxt = new JPanel();
        organizadorCampostxt.setLayout(new GridLayout(2,2,5,5));
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Verdana",Font.PLAIN,20));
        lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setFont(new Font("Verdana",Font.PLAIN,20));

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Verdana",Font.PLAIN,20));
        txtContrasenia = new JTextField();
        txtContrasenia.setFont(new Font("Verdana",Font.PLAIN,20));

        organizadorCampostxt.add(lblUsuario);
        organizadorCampostxt.add(txtUsuario);
        organizadorCampostxt.add(lblContrasenia);
        organizadorCampostxt.add(txtContrasenia);

        organizadorInicioSesion.add(organizadorCampostxt);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Verdana",Font.PLAIN,20));
        btnIngresar.setFocusable(false);
        btnIngresar.addActionListener(this);
        btnIngresar.setActionCommand("Ingresar");
        organizadorInicioSesion.add(btnIngresar);

        pnlCentro.add(organizadorInicioSesion);

        JPanel organizadorRegistro = new JPanel();
        organizadorRegistro.setLayout(new GridLayout(2,1,5,5));
        lblNoEstaRegistrado = new JLabel("No está registrado?");
        lblNoEstaRegistrado.setFont(new Font("Verdana",Font.PLAIN,20));
        lblNoEstaRegistrado.setForeground(Color.RED);
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setFont(new Font("Verdana",Font.PLAIN,20));
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.addActionListener(this);
        btnRegistrarse.setActionCommand("Registro");

        organizadorRegistro.add(lblNoEstaRegistrado);
        organizadorRegistro.add(btnRegistrarse);

        pnlCentro.add(organizadorRegistro);

        add(pnlCentro, BorderLayout.CENTER);

        add(Box.createHorizontalStrut(100),BorderLayout.WEST);
        add(Box.createHorizontalStrut(100),BorderLayout.EAST);

    }

    public static void main (String[] args)
    {
        VentanaPrincipal iniciar = new VentanaPrincipal();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Ingresar"))
        {
            inicioSesion();
        }

        else
        {
            this.dispose();
            VentanaRegistro ventana = new VentanaRegistro();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }
    }


    public void inicioSesion()
    {
        String nomUsuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();

        Usuario usuario = Servicios.inicioLogin(galeria, nomUsuario, contrasenia);

        if (usuario.getRol().equals("administrador"))
        {
            this.dispose();
            VentanaAdministrador ventana = new VentanaAdministrador();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

        else if (usuario.getRol().equals("operador"))
        {
            this.dispose();
            VentanaOperador ventana = new VentanaOperador();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);

        }

        else if (usuario.getRol().equals("cajero"))
        {
            this.dispose();
            VentanaCajero ventana = new VentanaCajero();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

        else if (usuario.getRol().equals("propietario"))
        {
            this.dispose();
            VentanaPropietario ventana = new VentanaPropietario((Propietario) usuario);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

        else if (usuario.getRol().equals("comprador"))
        {
            this.dispose();
            VentanaComprador ventana = new VentanaComprador();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

        
    }
}
