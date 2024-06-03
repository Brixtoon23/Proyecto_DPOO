package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Administrador;
import Logica.Cajero;
import Logica.Compra;
import Logica.Comprador;
import Logica.Galeria;
import Logica.Mensaje;
import Logica.Operador;
import Logica.Propietario;
import Logica.Servicios;
import Persistencia.InicializadorDeClases;

public class VentanaRegistro extends JFrame implements ActionListener
{
    private JLabel lblTitulo;

    private JPanel pnlSeleccionUser;
    private JLabel lblSeleccioneTipoUsuario;
    private JButton btnAdmin;
    private JButton btnComprador;
    private JButton btnPropietario;
    private JButton btnOperador;
    private JButton btnCajero;
    private String rol;
    
    private JPanel pnlEspacioLlenarInfo;
    private JLabel lblLogin;
    private JLabel lblNombre;
    private JLabel lblNumTel;
    private JLabel lblContrasenia;
    private JLabel lblEstadoCuenta;
    private JTextField txtLogin;
    private JTextField txtNombre;
    private JTextField txtNumTel;
    private JTextField txtContrasenia;
    private JTextField txtEstadoCuenta;
    private JButton btnRegistrarse;

    private JLabel lblIntenteDnuevo;
    private JLabel lblRegistroExitoso;
    private JLabel lblRecuerde;

    private JButton btnVolver;
    private Galeria galeria;

    public VentanaRegistro()
    {
        galeria = InicializadorDeClases.cargarGaleria();

        setTitle("Ventana registro");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pnlRegresar = new JPanel();
        pnlRegresar.setLayout(new GridLayout(10,1));
        btnVolver = new JButton("<");
        btnVolver.setFont(new Font("Verdana",Font.BOLD,25));
        btnVolver.setFocusable(false);
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");
        pnlRegresar.add(btnVolver);
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        add(pnlRegresar,BorderLayout.WEST);

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new GridBagLayout());
        JPanel organizadorN = new JPanel();
        organizadorN.setLayout(new GridLayout(2,1));
        organizadorN.add(Box.createVerticalStrut(10));

        lblTitulo = new JLabel("Registro");
        lblTitulo.setFont(new Font("Verdana",Font.BOLD,30));
        organizadorN.add(lblTitulo);

        pnlNorte.add(organizadorN);
        add(pnlNorte,BorderLayout.NORTH);


        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BorderLayout());

        pnlSeleccionUser = new JPanel();
        pnlSeleccionUser.setLayout(new GridLayout(2,1,0,5));
        lblSeleccioneTipoUsuario = new JLabel("Seleccione un tipo de usuario");
        lblSeleccioneTipoUsuario.setFont(new Font("Verdana",Font.BOLD,20));
        pnlSeleccionUser.add(lblSeleccioneTipoUsuario);
        
        JPanel ordenBtns = new JPanel();
        ordenBtns.setLayout(new GridLayout(1,5));
        btnAdmin = new JButton("Administrador");
        btnAdmin.setFocusable(false);
        btnAdmin.setFont(new Font("Verdana",Font.PLAIN,12));
        btnAdmin.addActionListener(this);
        btnAdmin.setActionCommand("Admin");
        ordenBtns.add(btnAdmin);
        btnCajero = new JButton("Cajero");
        btnCajero.setFocusable(false);
        btnCajero.setFont(new Font("Verdana",Font.PLAIN,12));
        btnCajero.addActionListener(this);
        btnCajero.setActionCommand("Caje");
        ordenBtns.add(btnCajero);
        btnComprador = new JButton("Comprador");
        btnComprador.setFocusable(false);
        btnComprador.setFont(new Font("Verdana",Font.PLAIN,12));
        btnComprador.addActionListener(this);
        btnComprador.setActionCommand("Compra");
        ordenBtns.add(btnComprador);
        btnOperador = new JButton("Operador");
        btnOperador.setFocusable(false);
        btnOperador.setFont(new Font("Verdana",Font.PLAIN,12));
        btnOperador.addActionListener(this);
        btnOperador.setActionCommand("Oper");
        ordenBtns.add(btnOperador);
        btnPropietario = new JButton("Propietario");
        btnPropietario.setFocusable(false);
        btnPropietario.setFont(new Font("Verdana",Font.PLAIN,12));
        btnPropietario.addActionListener(this);
        btnPropietario.setActionCommand("Prop");
        ordenBtns.add(btnPropietario);
        pnlSeleccionUser.add(ordenBtns);

        pnlCentro.add(pnlSeleccionUser,BorderLayout.NORTH);

        pnlEspacioLlenarInfo = new JPanel();
        pnlEspacioLlenarInfo.setLayout(new GridLayout(2,1,0,10));

        JPanel espacioInfo = new JPanel();
        espacioInfo.setLayout(new GridLayout(5,2));
        lblLogin = new JLabel("Login:");
        lblLogin.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(lblLogin);
        txtLogin = new JTextField();
        txtLogin.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(txtLogin);
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(txtNombre);
        lblNumTel = new JLabel("Número de teléfono:");
        lblNumTel.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(lblNumTel);
        txtNumTel = new JTextField();
        txtNumTel.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(txtNumTel);
        lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(lblContrasenia);
        txtContrasenia = new JTextField();
        txtContrasenia.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(txtContrasenia);
        lblEstadoCuenta = new JLabel("Estado de cuenta:");
        lblEstadoCuenta.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(lblEstadoCuenta);
        txtEstadoCuenta = new JTextField();
        txtEstadoCuenta.setFont(new Font("Verdana",Font.PLAIN,12));
        espacioInfo.add(txtEstadoCuenta);

        pnlEspacioLlenarInfo.add(espacioInfo);
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setPreferredSize(new Dimension(150,50));
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setFont(new Font("Verdana",Font.PLAIN,12));
        btnRegistrarse.addActionListener(this);
        btnRegistrarse.setActionCommand("Regis");
        JPanel espacioBtnRegis = new JPanel();
        espacioBtnRegis.setLayout(new GridLayout(3,3));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(btnRegistrarse);
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        espacioBtnRegis.add(Box.createHorizontalStrut(15));
        pnlEspacioLlenarInfo.add(espacioBtnRegis);

        pnlCentro.add(pnlEspacioLlenarInfo);

        //El panel para llenar la info no es visible hasta seleccionar un tipo de usuario
        pnlEspacioLlenarInfo.setVisible(false);

        //Estado Cuenta no aparece a menos que se elija Comprador
        lblEstadoCuenta.setVisible(false);
        txtEstadoCuenta.setVisible(false);

        add(pnlCentro,BorderLayout.CENTER);

        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new FlowLayout());
        lblIntenteDnuevo = new JLabel("No se pudo hacer su registro inténtelo de nuevo");
        lblIntenteDnuevo.setFont(new Font("Verdana",Font.PLAIN,20));
        lblIntenteDnuevo.setForeground(Color.RED);
        pnlSur.add(lblIntenteDnuevo);
        lblRegistroExitoso = new JLabel("Su registro fue exitoso");
        lblRegistroExitoso.setFont(new Font("Verdana",Font.PLAIN,20));
        lblRegistroExitoso.setForeground(Color.RED);
        pnlSur.add(lblRegistroExitoso);
        lblRecuerde = new JLabel("Recuerde que también ha sido registrado como propietario");
        lblRecuerde.setFont(new Font("Verdana",Font.PLAIN,20));
        lblRecuerde.setForeground(Color.RED);
        pnlSur.add(lblRegistroExitoso);

        //El mensaje de intentar de nuevo no aparece a menos de que no se haya dado el registro
        lblIntenteDnuevo.setVisible(false);

        //El mensaje de registro exitoso aparece se dio el registro
        lblRegistroExitoso.setVisible(false);
        lblRecuerde.setVisible(false);

        add(pnlSur,BorderLayout.SOUTH);

        
    }

    public static void main (String[] args)
    {
        VentanaRegistro iniciar = new VentanaRegistro();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("volver"))
        {
            this.dispose();
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

        else if (e.getActionCommand().equals("Admin"))
        {
            rol = "administrador";
            pnlEspacioLlenarInfo.setVisible(true);
        }

        else if (e.getActionCommand().equals("Caje"))
        {
            rol = "cajero";
            pnlEspacioLlenarInfo.setVisible(true);
        }

        else if (e.getActionCommand().equals("Compra"))
        {
            rol = "comprador";
            lblEstadoCuenta.setVisible(true);
            txtEstadoCuenta.setVisible(true);
            pnlEspacioLlenarInfo.setVisible(true);
        }

        else if (e.getActionCommand().equals("Prop"))
        {
            rol = "propietario";
            pnlEspacioLlenarInfo.setVisible(true); 
        }

        else if (e.getActionCommand().equals("Oper"))
        {
            rol = "operador";
            pnlEspacioLlenarInfo.setVisible(true);
        }

        else if (e.getActionCommand().equals("Regis"))
        {
            registrarUsuario(rol);
        }

    }

    private void registrarUsuario(String rol)
    {
        String login = txtLogin.getText();
        String nombre = txtNombre.getText();
        String numTel = txtNumTel.getText();
        String contrasenia = txtContrasenia.getText();

        String loginFinal = login+"_"+rol;

        if(Servicios.verificarLoginRepetido(galeria, loginFinal))
        {
            lblIntenteDnuevo.setVisible(true);
        }

        if (rol.equals("cajero"))
        {
            Cajero cajero=new Cajero(loginFinal, nombre, contrasenia,rol, numTel, false, new ArrayList<Compra>());
            Administrador.verificarCajero(cajero);

            if (cajero.isVerificado())
            {
                Administrador.ingresarUsuario(cajero, galeria);
                lblRegistroExitoso.setVisible(true);
            }

            else
            {
                lblIntenteDnuevo.setVisible(true);
            }
        }

        else if (rol.equals("operador"))
        {
            Operador operador = new Operador(loginFinal, nombre, contrasenia,rol, numTel, false, new ArrayList<Compra>());
            Administrador.verificarOperador(operador);

            if (operador.isVerificado())
            {
                Administrador.ingresarUsuario(operador, galeria);
                lblRegistroExitoso.setVisible(true);
            }

            else
            {
                lblIntenteDnuevo.setVisible(true);
            }
        }

        else if (rol.equals("propietario"))
        {
            Propietario propiertario= new Propietario(loginFinal, nombre, contrasenia, "propietario", numTel, false, new ArrayList<String>(),  new ArrayList<String>());
            Administrador.verificarPropietario(propiertario);
            if (propiertario.isVerificado())
            {
                Administrador.ingresarUsuario(propiertario, galeria);
                lblRegistroExitoso.setVisible(true);
            }       

            else
            {
                lblIntenteDnuevo.setVisible(true);
            }
        }

        else if (rol.equals("administrador"))
        {
            Administrador administrador = new Administrador(loginFinal, nombre,contrasenia, rol, numTel, false);
            Administrador.verificarAdministrador(administrador);
            if (administrador.isVerificado())
            {
                Administrador.ingresarUsuario(administrador, galeria);
                lblRegistroExitoso.setVisible(true);

            }    

            else
            {
                lblIntenteDnuevo.setVisible(true);
            }
        }

        else if (rol.equals("comprador"))
        {
            float estadoCuenta = Float.parseFloat(txtEstadoCuenta.getText());
            Comprador comprador = new Comprador(loginFinal, nombre, contrasenia, rol, numTel, false, estadoCuenta, new ArrayList<Compra>(),0,
            false,new ArrayList<Mensaje>(), new ArrayList<String>());
                        

            Administrador.verificarComprador(comprador);
            if (comprador.isVerificado())
            {
                String loginPropietario= login +"_propietario";
                Propietario propiertario= new Propietario(loginPropietario, nombre, contrasenia, "propietario", numTel, false, new ArrayList<String>(),  new ArrayList<String>());
                Administrador.ingresarUsuario(comprador, galeria);
                Administrador.ingresarUsuario(propiertario, galeria);
                lblRegistroExitoso.setVisible(true);
                lblRecuerde.setVisible(true);
            }    

            else
            {
                lblIntenteDnuevo.setVisible(true);
            }
        }


        
    }

}
