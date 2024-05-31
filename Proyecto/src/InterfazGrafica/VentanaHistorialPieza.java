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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Galeria;
import Logica.Pieza;
import Logica.Servicios;

public class VentanaHistorialPieza extends JFrame implements ActionListener
{
    private String ventanaAnterior;
    private JLabel titulo;
    private JTextField txtNombrePieza;
    private JLabel lblIngreseNombre;
    private JButton btnBuscar;
    private JButton btnVolver;
    private JLabel lblTituloPieza;
    private JLabel lblPropietario;
    private JLabel lblValor;
    private JLabel lblFechaCompra;
    private JLabel imagenPieza;
    private JLabel lblNoEncontro;
    private JTextField txtTituloPieza;
    private JTextField txtPropietario;
    private JTextField txtValor;
    private JTextField txtFechaCompra;
    private JButton btnUltimo;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnPrimero;

    private JPanel organizadorE;
    private JPanel organizadorW;
    private JPanel organizadorC;

    private Pieza piezaDesplegar;
    private Galeria galeria;


    public VentanaHistorialPieza()
    {
        setTitle("Ventana Historial Pieza");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridBagLayout());
        pnlCentro.add(Box.createVerticalStrut(20));

        JPanel organizador = new JPanel();
        organizador.setLayout(new GridLayout(3,1,0,10));        
        
        titulo = new JLabel("Historial de Pieza");
        titulo.setFont(new Font("Verdana",Font.BOLD,30));
        organizador.add(titulo);

        JPanel arregloBusqueda = new JPanel();
        arregloBusqueda.setLayout(new FlowLayout());
        lblIngreseNombre = new JLabel("Ingrese el nombre de la pieza:");
        lblIngreseNombre.setFont(new Font("Verdana",Font.PLAIN,15));
        arregloBusqueda.add(lblIngreseNombre);
        txtNombrePieza = new JTextField();
        txtNombrePieza.setEditable(true);
        txtNombrePieza.setFont(new Font("Verdana",Font.PLAIN,15));
        txtNombrePieza.setPreferredSize(new Dimension(200,30));
        arregloBusqueda.add(txtNombrePieza);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Verdana",Font.PLAIN,15));
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(this);
        btnBuscar.setActionCommand("Buscar");
        arregloBusqueda.add(btnBuscar);

        organizador.add(arregloBusqueda);

        pnlCentro.add(organizador);

        add(pnlCentro,BorderLayout.CENTER);


        JPanel pnlRegresar = new JPanel();
        pnlRegresar.setLayout(new GridLayout(12,1));
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
        pnlRegresar.add(Box.createVerticalStrut(15));
        pnlRegresar.add(Box.createVerticalStrut(15));
        add(pnlRegresar,BorderLayout.WEST);


        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new BorderLayout());

        organizadorE = new JPanel();
        organizadorE.setLayout(new GridLayout(2,1,0,10));

        JPanel organizadorInfo = new JPanel();
        organizadorInfo.setLayout(new GridLayout(4,2,5,5));
        
        lblTituloPieza = new JLabel("Título:");
        lblTituloPieza.setFont(new Font("Verdana",Font.PLAIN,15));
        txtTituloPieza = new JTextField();
        txtTituloPieza.setEditable(false);
        lblPropietario = new JLabel("Propietario:");
        lblPropietario.setFont(new Font("Verdana",Font.PLAIN,15));
        txtPropietario = new JTextField();
        txtPropietario.setEditable(false);
        lblValor = new JLabel("Valor:");
        lblValor.setFont(new Font("Verdana",Font.PLAIN,15));
        txtValor = new JTextField();
        txtValor.setEditable(false);
        lblFechaCompra = new JLabel("Fecha de compra:");
        lblFechaCompra.setFont(new Font("Verdana",Font.PLAIN,15));
        txtFechaCompra = new JTextField();
        txtFechaCompra.setEditable(false);

        organizadorInfo.add(lblTituloPieza);
        organizadorInfo.add(txtTituloPieza);
        organizadorInfo.add(lblPropietario);
        organizadorInfo.add(txtPropietario);
        organizadorInfo.add(lblValor);
        organizadorInfo.add(txtValor);
        organizadorInfo.add(lblFechaCompra);
        organizadorInfo.add(txtFechaCompra);

        organizadorE.add(organizadorInfo);
        
        JPanel organizadorBtns = new JPanel();
        organizadorBtns.setLayout(new GridLayout(1,4,5,0));
        btnUltimo = new JButton("Último");
        btnUltimo.setFocusable(false);
        btnUltimo.setFont(new Font("Verdana",Font.PLAIN,15));
        btnAnterior = new JButton("<<");
        btnAnterior.setFocusable(false);
        btnAnterior.setFont(new Font("Verdana",Font.PLAIN,15));
        btnPrimero = new JButton("Primero");
        btnPrimero.setFocusable(false);
        btnPrimero.setFont(new Font("Verdana",Font.PLAIN,15));
        btnSiguiente = new JButton(">>");
        btnSiguiente.setFocusable(false);
        btnSiguiente.setFont(new Font("Verdana",Font.PLAIN,15));

        organizadorBtns.add(btnUltimo);
        organizadorBtns.add(btnAnterior);
        organizadorBtns.add(btnSiguiente);
        organizadorBtns.add(btnPrimero);

        organizadorE.add(organizadorBtns);

        //No es visible hasta que se encuentre la pieza
        organizadorE.setVisible(false);

        pnlSur.add(organizadorE,BorderLayout.EAST);

        organizadorW = new JPanel();
        organizadorW.setLayout(new FlowLayout());

        ImageIcon imagen = new ImageIcon("Proyecto/Imagenes/ImagenTest.png");
        imagenPieza = new JLabel();
        imagenPieza.setIcon(imagen);

        organizadorW.add(Box.createHorizontalStrut(50));
        organizadorW.add(imagenPieza);

        //No es visible hasta que se encuentre la pieza
        organizadorW.setVisible(false);

        pnlSur.add(organizadorW,BorderLayout.WEST);

        pnlSur.add(Box.createVerticalStrut(20),BorderLayout.SOUTH);

        organizadorC = new JPanel();
        organizadorC.setLayout(new FlowLayout());
        organizadorC.add(Box.createHorizontalStrut(15));
        lblNoEncontro = new JLabel("No se encontró la pieza. Inténtelo de nuevo.");
        lblNoEncontro.setFont(new Font("Verdana",Font.BOLD,15));
        lblNoEncontro.setForeground(Color.RED);

        //No es visible a menos que no se encuentre la pieza
        organizadorC.setVisible(false);

        organizadorC.add(lblNoEncontro);

        pnlSur.add(organizadorC,BorderLayout.CENTER);

        add(pnlSur,BorderLayout.SOUTH);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("volver"))
        {
            if (ventanaAnterior.equals("Operador"))
            {
                this.dispose();
                VentanaOperador menu = new VentanaOperador();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            }

            else if (ventanaAnterior.equals("Propietario"))
            {
                this.dispose();
                VentanaPropietario menu = new VentanaPropietario();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            }
            
        }

        else if (e.getActionCommand().equals("Buscar"))
        {
            desplegarInfoPiezaEncontrada();
        }
       
    }

    public void setVentanaAnterior(String anterior)
    {
        ventanaAnterior = anterior;
    }


    public void desplegarInfoPiezaEncontrada()
    {
        String nomPieza = txtNombrePieza.getText();
        piezaDesplegar = Servicios.buscarPieza(galeria, nomPieza);

        if (piezaDesplegar==null)
        {
            organizadorC.setVisible(true);
        }

        else
        {
            txtTituloPieza.setText(piezaDesplegar.getTitulo());
            txtPropietario.setText((String)piezaDesplegar.getHistorialPropietarios().get(0).get("loginPropietario"));
            txtFechaCompra.setText((String)piezaDesplegar.getHistorialPropietarios().get(0).get("fechaVenta"));
            txtValor.setText((String)piezaDesplegar.getHistorialPropietarios().get(0).get("valorCompra"));

            ImageIcon imgPieza = new ImageIcon(piezaDesplegar.getRutaImagen());
            imagenPieza.setIcon(imgPieza);

            organizadorE.setVisible(true);
            organizadorW.setVisible(true);
        }
    }

    public void setGaleria (Galeria g)
    {
        galeria = g;
    }

    /** 
    public static void main(String[] args)
    {
        VentanaHistorialPieza iniciar = new VentanaHistorialPieza();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
    */
}
