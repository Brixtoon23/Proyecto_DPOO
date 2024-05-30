package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSurHistoriaPieza extends JPanel
{
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

    public PanelSurHistoriaPieza()
    {
        setLayout(new BorderLayout());

        JPanel organizadorE = new JPanel();
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

        add(organizadorE,BorderLayout.EAST);

        JPanel organizadorW = new JPanel();
        organizadorW.setLayout(new FlowLayout());

        ImageIcon imagen = new ImageIcon("Proyecto/Imagenes/ImagenTest.png");
        imagenPieza = new JLabel();
        imagenPieza.setIcon(imagen);

        organizadorW.add(Box.createHorizontalStrut(50));
        organizadorW.add(imagenPieza);

        //No es visible hasta que se encuentre la pieza
        organizadorW.setVisible(false);

        add(organizadorW,BorderLayout.WEST);

        add(Box.createVerticalStrut(20),BorderLayout.SOUTH);

        JPanel organizadorC = new JPanel();
        organizadorC.setLayout(new FlowLayout());
        organizadorC.add(Box.createHorizontalStrut(15));
        lblNoEncontro = new JLabel("No se encontró la pieza. Inténtelo de nuevo.");
        lblNoEncontro.setFont(new Font("Verdana",Font.BOLD,15));
        lblNoEncontro.setForeground(Color.RED);

        //No es visible a menos que no se encuentre la pieza
        organizadorC.setVisible(false);

        organizadorC.add(lblNoEncontro);
        add(organizadorC,BorderLayout.CENTER);
        
    }
}
