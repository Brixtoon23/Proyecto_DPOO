package InterfazGrafica;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Galeria;
import Logica.Pieza;
import Logica.Propietario;
import Logica.Servicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VentanaPiezasPasadas extends JFrame implements ActionListener
{
    private JLabel titulo;
    private JLabel imagenPieza;
    private JLabel lblTituloPieza;
    private JLabel lblAutor;
    private JLabel lblAnioCreacion;
    private JLabel lblPropietarioActual;
    private JLabel lblValorCompra;
    private JLabel lblFechaCompra;
    private JTextField txtTituloPieza;
    private JTextField txtAutor;
    private JTextField txtAnioCreacion;
    private JTextField txtPropietarioActual;
    private JTextField txtValorCompra;
    private JTextField txtFechaCompra;
    private JButton btnPrimera;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltima;
    private JButton btnVolver;
    private JPanel pnlSur;
    private JPanel pnlCentro;
    private JLabel lblHistorialVacio;
    private Propietario propietario;
    private Galeria galeria;
    private Pieza piezaDesplegar;
    private int posHistorial;

    public VentanaPiezasPasadas(Propietario propietario, Galeria galeria)
    {
        this.galeria = galeria;
        this.propietario = propietario;

        setTitle("Ventana piezas pasadas");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel organizadorN = new JPanel();
        organizadorN.setLayout(new GridBagLayout());

        titulo = new JLabel("Piezas Pasadas");
        titulo.setFont(new Font("Verdana",Font.BOLD,30));
        organizadorN.add(titulo);
        add(organizadorN,BorderLayout.NORTH);

        JPanel pnlRegresar = new JPanel();
        pnlRegresar.setLayout(new GridLayout(8,1));
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
        add(pnlRegresar,BorderLayout.WEST);

        pnlSur = new JPanel();
        pnlSur.setLayout(new GridLayout(1,2));

        JPanel organizadorInfo = new JPanel();
        organizadorInfo.setLayout(new GridLayout(6,2));
        lblTituloPieza = new JLabel("Título:");
        lblTituloPieza.setFont(new Font("Verdana",Font.PLAIN,15));
        lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Verdana",Font.PLAIN,15));
        lblAnioCreacion = new JLabel("Año de creación:");
        lblAnioCreacion.setFont(new Font("Verdana",Font.PLAIN,15));
        lblPropietarioActual = new JLabel("Propietario actual:");
        lblPropietarioActual.setFont(new Font("Verdana",Font.PLAIN,15));
        lblValorCompra = new JLabel("Valor de compra:");
        lblValorCompra.setFont(new Font("Verdana",Font.PLAIN,15));
        lblFechaCompra = new JLabel("Fecha de compra:");
        lblFechaCompra.setFont(new Font("Verdana",Font.PLAIN,15));

        txtTituloPieza = new JTextField();
        txtTituloPieza.setFont(new Font("Verdana",Font.PLAIN,15));
        txtTituloPieza.setEditable(false);
        txtAutor = new JTextField();
        txtAutor.setFont(new Font("Verdana",Font.PLAIN,15));
        txtAutor.setEditable(false);
        txtAnioCreacion = new JTextField();
        txtAnioCreacion.setFont(new Font("Verdana",Font.PLAIN,15));
        txtAnioCreacion.setEditable(false);
        txtPropietarioActual = new JTextField();
        txtPropietarioActual.setFont(new Font("Verdana",Font.PLAIN,15));
        txtPropietarioActual.setEditable(false);
        txtValorCompra = new JTextField();
        txtValorCompra.setFont(new Font("Verdana",Font.PLAIN,15));
        txtValorCompra.setEditable(false);
        txtFechaCompra = new JTextField();
        txtFechaCompra.setFont(new Font("Verdana",Font.PLAIN,15));
        txtFechaCompra.setEditable(false);

        organizadorInfo.add(lblTituloPieza);
        organizadorInfo.add(txtTituloPieza);
        organizadorInfo.add(lblAutor);
        organizadorInfo.add(txtAutor);
        organizadorInfo.add(lblAnioCreacion);
        organizadorInfo.add(txtAnioCreacion);
        organizadorInfo.add(lblPropietarioActual);
        organizadorInfo.add(txtPropietarioActual);
        organizadorInfo.add(lblValorCompra);
        organizadorInfo.add(txtValorCompra);
        organizadorInfo.add(lblFechaCompra);
        organizadorInfo.add(txtFechaCompra);

        JPanel organizadorBtns = new JPanel();
        organizadorBtns.setLayout(new GridLayout(1,4));

        btnPrimera = new JButton("Primera");
        btnPrimera.setFont(new Font("Verdana",Font.PLAIN,15));
        btnPrimera.setFocusable(false);
        btnPrimera.addActionListener(this);
        btnPrimera.setActionCommand("Pri");
        btnSiguiente = new JButton(">>");
        btnSiguiente.setFont(new Font("Verdana",Font.PLAIN,15));
        btnSiguiente.setFocusable(false);
        btnSiguiente.addActionListener(this);
        btnSiguiente.setActionCommand("Sig");
        btnAnterior = new JButton("<<");
        btnAnterior.setFont(new Font("Verdana",Font.PLAIN,15));
        btnAnterior.setFocusable(false);
        btnAnterior.addActionListener(this);
        btnAnterior.setActionCommand("Ant");
        btnUltima = new JButton("Ultima");
        btnUltima.setFont(new Font("Verdana",Font.PLAIN,15));
        btnUltima.setFocusable(false);
        btnUltima.addActionListener(this);
        btnUltima.setActionCommand("Ult");

        organizadorBtns.add(btnPrimera);
        organizadorBtns.add(btnAnterior);
        organizadorBtns.add(btnSiguiente);
        organizadorBtns.add(btnUltima);

        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new GridLayout(2,1,0,10));
        pnlInfo.add(organizadorInfo);
        pnlInfo.add(organizadorBtns);

        ImageIcon imagen = new ImageIcon("Proyecto/Imagenes/ImagenTest.png");
        imagenPieza = new JLabel();
        imagenPieza.setIcon(imagen);

        pnlSur.add(imagenPieza);
        pnlSur.add(pnlInfo);

        //Este panel es visible si el historial de piezas no está vacío
        pnlSur.setVisible(false);

        add(pnlSur,BorderLayout.SOUTH);

        pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridBagLayout());
        lblHistorialVacio = new JLabel("Su historial de piezas compradas está vació");
        lblHistorialVacio.setFont(new Font("Verdana",Font.BOLD,20));
        lblHistorialVacio.setForeground(Color.RED);
        pnlCentro.add(lblHistorialVacio);

        //Este panel no es visible a menos que el historial de piezas esté vacío
        pnlCentro.setVisible(false);

        add(pnlCentro,BorderLayout.CENTER);


        if(propietario.getHistorialPiezas().size()>0)
        {
            cambiarInfo(0);
            pnlSur.setVisible(true);
            posHistorial = 0;
        }

        else
        {
            pnlCentro.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("volver"))
        {
            this.dispose();
            VentanaPropietario ventana = new VentanaPropietario();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }

        else if ((e.getActionCommand().equals("Pri"))&&(pnlSur.isVisible()))
        {
            cambiarInfo(0);
            posHistorial = 0;
        }

        else if ((e.getActionCommand().equals("Ant"))&&(pnlSur.isVisible()))
        {
            if((posHistorial-1)>=0)
            {
                cambiarInfo(posHistorial-1);
                posHistorial--;
            }
        }

        else if ((e.getActionCommand().equals("Sig"))&&(pnlSur.isVisible()))
        {
            if ((posHistorial+1)<=(propietario.getHistorialPiezas().size()-1))
            {
                cambiarInfo(posHistorial+1);
                posHistorial++;
            }  
        }

        else if ((e.getActionCommand().equals("Ult"))&&(pnlSur.isVisible()))
        {
            cambiarInfo(propietario.getHistorialPiezas().size()-1);
            posHistorial = propietario.getHistorialPiezas().size()-1;
        }

    }


    public void cambiarInfo(int pos)
    {
        String nomPieza = propietario.getHistorialPiezas().get(pos);
        piezaDesplegar = Servicios.buscarPieza(galeria, nomPieza);
        
        txtTituloPieza.setText(nomPieza);
        String autores = "";
        for(int i=0;i<=piezaDesplegar.getAutor().size()-1;i++)
        {
            if((i==0)||(i==(piezaDesplegar.getAutor().size()-1)))
            {
                autores += piezaDesplegar.getAutor().get(i);
            }

            else
            {
                autores += (","+(piezaDesplegar.getAutor().get(i)));
            }
        }

        txtAutor.setText(autores);
        txtAnioCreacion.setText(((Integer)piezaDesplegar.getAnioCreacion()).toString());
        txtPropietarioActual.setText(piezaDesplegar.getLoginPropietarioActual());

        ArrayList<Map<String,Object>> propietariosPieza = piezaDesplegar.getHistorialPropietarios();

        Map <String, Object> mapaProp = propietariosPieza.get(0);
        txtValorCompra.setText(mapaProp.get("valorCompra").toString());
        txtFechaCompra.setText(mapaProp.get("fechaVenta").toString());

        ImageIcon icono = new ImageIcon(piezaDesplegar.getRutaImagen());
        imagenPieza.setIcon(icono);

    }

}
