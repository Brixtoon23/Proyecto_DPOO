package InterfazGrafica;

import java.awt.BorderLayout;
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

public class VentanaPiezasActuales extends JFrame implements ActionListener
{
    private JLabel titulo;
    private JLabel imagenPieza;
    private JLabel lblTituloPieza;
    private JLabel lblAutor;
    private JLabel lblAnioCreacion;
    private JLabel lblValorCompra;
    private JLabel lblFechaCompra;
    private JTextField txtTituloPieza;
    private JTextField txtAutor;
    private JTextField txtAnioCreacion;
    private JTextField txtValorCompra;
    private JTextField txtFechaCompra;
    private JButton btnPrimera;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnUltima;
    private JButton btnVolver;

    public VentanaPiezasActuales()
    {
        setTitle("Ventana piezas acuales");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel organizadorN = new JPanel();
        organizadorN.setLayout(new GridBagLayout());

        titulo = new JLabel("Mis piezas");
        titulo.setFont(new Font("Verdana",Font.BOLD,30));
        organizadorN.add(titulo);
        add(organizadorN,BorderLayout.CENTER);

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

        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new GridLayout(1,2));

        JPanel organizadorInfo = new JPanel();
        organizadorInfo.setLayout(new GridLayout(5,2));
        lblTituloPieza = new JLabel("Título:");
        lblTituloPieza.setFont(new Font("Verdana",Font.PLAIN,15));
        lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Verdana",Font.PLAIN,15));
        lblAnioCreacion = new JLabel("Año de creación:");
        lblAnioCreacion.setFont(new Font("Verdana",Font.PLAIN,15));
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
        organizadorInfo.add(lblValorCompra);
        organizadorInfo.add(txtValorCompra);
        organizadorInfo.add(lblFechaCompra);
        organizadorInfo.add(txtFechaCompra);

        JPanel organizadorBtns = new JPanel();
        organizadorBtns.setLayout(new GridLayout(1,4));

        btnPrimera = new JButton("Primera");
        btnPrimera.setFont(new Font("Verdana",Font.PLAIN,15));
        btnPrimera.setFocusable(false);
        btnSiguiente = new JButton(">>");
        btnSiguiente.setFont(new Font("Verdana",Font.PLAIN,15));
        btnSiguiente.setFocusable(false);
        btnAnterior = new JButton("<<");
        btnAnterior.setFont(new Font("Verdana",Font.PLAIN,15));
        btnAnterior.setFocusable(false);
        btnUltima = new JButton("Ultima");
        btnUltima.setFont(new Font("Verdana",Font.PLAIN,15));
        btnUltima.setFocusable(false);

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
        add(pnlSur,BorderLayout.SOUTH);
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
    }
    

}
