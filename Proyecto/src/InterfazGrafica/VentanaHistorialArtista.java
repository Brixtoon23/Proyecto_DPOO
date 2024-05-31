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
import java.util.Map;

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

public class VentanaHistorialArtista extends JFrame implements ActionListener
{
    private JPanel organizadorE;
    private JPanel organizadorW;
    private JPanel organizadorC;
    private JPanel detallesVenta;
    private JButton btnVolver;
    private String ventanaAnterior;
    private JLabel titulo;
    private JTextField txtNombreArtist;
    private JLabel lblIngreseNombre;
    private JButton btnBuscar;
    private JLabel lblTituloPieza;
    private JLabel lblFechaCreacion;
    private JLabel lblValor;
    private JLabel lblFechaCompra;
    private JLabel imagenPieza;
    private JLabel lblNoEncontro;
    private JLabel lblNoEncontroInfoVenta;
    private JTextField txtTituloPieza;
    private JTextField txtFechaCreacion;
    private JTextField txtValor;
    private JTextField txtFechaCompra;
    private JButton btnPrimera;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltima;

    private int posHistorial;
    private Pieza piezaDesplegar;
    private String autor;
    private Galeria galeria;
    

    public VentanaHistorialArtista()
    {
        setTitle("Ventana Historial Artista");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        JPanel pnlCentro = new JPanel();

        pnlCentro.setLayout(new GridBagLayout());
        pnlCentro.add(Box.createVerticalStrut(20));

        JPanel organizador = new JPanel();
        organizador.setLayout(new GridLayout(3,1,0,10));        
        
        titulo = new JLabel("Historial de Artista");
        titulo.setFont(new Font("Verdana",Font.BOLD,30));
        organizador.add(titulo);

        JPanel arregloBusqueda = new JPanel();
        arregloBusqueda.setLayout(new FlowLayout());
        lblIngreseNombre = new JLabel("Ingrese el nombre del artista:");
        lblIngreseNombre.setFont(new Font("Verdana",Font.PLAIN,15));
        arregloBusqueda.add(lblIngreseNombre);
        txtNombreArtist = new JTextField();
        txtNombreArtist.setEditable(true);
        txtNombreArtist.setFont(new Font("Verdana",Font.PLAIN,15));
        txtNombreArtist.setPreferredSize(new Dimension(200,30));
        arregloBusqueda.add(txtNombreArtist);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Verdana",Font.PLAIN,15));
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(this);
        btnBuscar.setActionCommand("Buscar");
        arregloBusqueda.add(btnBuscar);

        organizador.add(arregloBusqueda);

        pnlCentro.add(organizador);

        add(pnlCentro,BorderLayout.CENTER);


        JPanel pnlSur = new JPanel();

        pnlSur.setLayout(new BorderLayout());

        organizadorE = new JPanel();
        organizadorE.setLayout(new GridLayout(3,1,0,10));

        JPanel organizadorInfo = new JPanel();
        organizadorInfo.setLayout(new GridLayout(2,2,5,5));
        
        lblTituloPieza = new JLabel("Título:");
        lblTituloPieza.setFont(new Font("Verdana",Font.PLAIN,15));
        txtTituloPieza = new JTextField();
        txtTituloPieza.setEditable(false);
        lblFechaCreacion = new JLabel("Fecha de creación:");
        lblFechaCreacion.setFont(new Font("Verdana",Font.PLAIN,15));
        txtFechaCreacion = new JTextField();
        txtFechaCreacion.setEditable(false);
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
        organizadorInfo.add(lblFechaCreacion);
        organizadorInfo.add(txtFechaCreacion);
        
        organizadorE.add(organizadorInfo);

        JPanel organizadorInfoVenta = new JPanel();
        organizadorInfoVenta.setLayout(new BorderLayout());

        detallesVenta = new JPanel();
        detallesVenta.setLayout(new GridLayout(2,2,5,5));
        detallesVenta.add(lblValor);
        detallesVenta.add(txtValor);
        detallesVenta.add(lblFechaCompra);
        detallesVenta.add(txtFechaCompra);
        
        //Este componente no es visible hasta que se obtenga la info de la pieza
        detallesVenta.setVisible(false);

        organizadorInfoVenta.add(detallesVenta,BorderLayout.WEST);
        
        lblNoEncontroInfoVenta = new JLabel("No se encontró información de la venta de esta pieza");
        lblNoEncontroInfoVenta.setFont(new Font("Verdana",Font.BOLD,15));
        lblNoEncontroInfoVenta.setForeground(Color.RED);
        //Este componente no es visible a menos de que no se encuentra info de la venta de la pieza
        lblNoEncontroInfoVenta.setVisible(false);

        organizadorInfoVenta.add(lblNoEncontroInfoVenta,BorderLayout.EAST);

        organizadorE.add(organizadorInfoVenta);
        
        JPanel organizadorBtns = new JPanel();
        organizadorBtns.setLayout(new GridLayout(1,4,5,0));
        btnPrimera = new JButton("Primera");
        btnPrimera.setFocusable(false);
        btnPrimera.setFont(new Font("Verdana",Font.PLAIN,15));
        btnPrimera.addActionListener(this);
        btnPrimera.setActionCommand("Pri");
        btnAnterior = new JButton("<<");
        btnAnterior.setFocusable(false);
        btnAnterior.setFont(new Font("Verdana",Font.PLAIN,15));
        btnAnterior.addActionListener(this);
        btnAnterior.setActionCommand("Antes");
        btnUltima = new JButton("Última");
        btnUltima.setFocusable(false);
        btnUltima.setFont(new Font("Verdana",Font.PLAIN,15));
        btnUltima.addActionListener(this);
        btnUltima.setActionCommand("Ult");
        btnSiguiente = new JButton(">>");
        btnSiguiente.setFocusable(false);
        btnSiguiente.setFont(new Font("Verdana",Font.PLAIN,15));
        btnSiguiente.addActionListener(this);
        btnAnterior.setActionCommand("Sig");

        organizadorBtns.add(btnPrimera);
        organizadorBtns.add(btnAnterior);
        organizadorBtns.add(btnSiguiente);
        organizadorBtns.add(btnUltima);

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
        lblNoEncontro = new JLabel("No se encontró información del artista. Inténtelo de nuevo.");
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
            desplegarInfoPieza();
        }

        else if (e.getActionCommand().equals("Pri"))
        {
            
        }

        else if (e.getActionCommand().equals("Antes"))
        {
            
        }

        else if (e.getActionCommand().equals("Sig"))
        {
            
        }

        else
        {
            
        }
    }

    public void desplegarInfoPieza()
    {
        String nomArtista = txtNombreArtist.getText();
        Map<String,ArrayList<String>> autores = galeria.getAutores();

        if (autores.containsKey(nomArtista))
        {
            autor = nomArtista;
            piezaDesplegar = Servicios.buscarPieza(galeria, autores.get(nomArtista).get(0));
            txtTituloPieza.setText(piezaDesplegar.getTitulo());
            txtFechaCreacion.setText(((Integer)(piezaDesplegar.getAnioCreacion())).toString());
            
            if (piezaDesplegar.getHistorialPropietarios().size()>0)
            {
                txtFechaCompra.setText((String)piezaDesplegar.getHistorialPropietarios().get(0).get("fechaVenta"));
                txtValor.setText(((Integer)(piezaDesplegar.getHistorialPropietarios().get(0).get("valorCompra"))).toString());
                lblNoEncontroInfoVenta.setVisible(false);
                detallesVenta.setVisible(true);
            }

            else
            {
                lblNoEncontroInfoVenta.setVisible(true);
            }

            ImageIcon icono = new ImageIcon(piezaDesplegar.getRutaImagen());
            imagenPieza.setIcon(icono);
            posHistorial = 0;

            organizadorC.setVisible(false);
            organizadorE.setVisible(true);
            organizadorW.setVisible(true);
        }

        else
        {
            organizadorC.setVisible(true);
        }
    }

    public void cambioPieza(String autor,int posPieza)
    {
        Map<String,ArrayList<String>> autores = galeria.getAutores();

        piezaDesplegar = Servicios.buscarPieza(galeria, autores.get(autor).get(posPieza));
            txtTituloPieza.setText(piezaDesplegar.getTitulo());
            txtFechaCreacion.setText(((Integer)(piezaDesplegar.getAnioCreacion())).toString());
            
            if (piezaDesplegar.getHistorialPropietarios().size()>0)
            {
                txtFechaCompra.setText((String)piezaDesplegar.getHistorialPropietarios().get(0).get("fechaVenta"));
                txtValor.setText(((Integer)(piezaDesplegar.getHistorialPropietarios().get(0).get("valorCompra"))).toString());
                lblNoEncontroInfoVenta.setVisible(false);
                detallesVenta.setVisible(true);
            }

            else
            {
                lblNoEncontroInfoVenta.setVisible(true);
            }

            ImageIcon icono = new ImageIcon(piezaDesplegar.getRutaImagen());
            imagenPieza.setIcon(icono);
            posHistorial = posPieza;

    }

    public void actualizarInfo(String accion)
    {
        if((organizadorE.isVisible())&&(organizadorW.isVisible()))
        {
            if (accion.equals("Pri"))
            {
                cambioPieza(autor,0);
            }

            else if ((accion.equals("Antes"))&&((posHistorial-1)>=0))
            {
                cambioPieza(autor, posHistorial-1);
            }

            else if ((accion.equals("Sig"))&&((posHistorial+1)<=(galeria.getAutores().get(autor).size()-1)))
            {
                cambioPieza(autor,posHistorial+1);
            }

            else
            {
                cambioPieza(autor, (galeria.getAutores().get(autor).size()-1));
            }
        }
    }

    public void setVentanaAnterior(String anterior)
    {
        ventanaAnterior = anterior;
    }

    public void setGaleria (Galeria g)
    {
        galeria = g;
    }

}
