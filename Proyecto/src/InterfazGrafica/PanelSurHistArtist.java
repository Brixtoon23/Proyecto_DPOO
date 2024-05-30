package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSurHistArtist extends JPanel implements ActionListener
{
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

    public PanelSurHistArtist()
    {
                setLayout(new BorderLayout());

        JPanel organizadorE = new JPanel();
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

        JPanel detallesVenta = new JPanel();
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
        btnAnterior = new JButton("<<");
        btnAnterior.setFocusable(false);
        btnAnterior.setFont(new Font("Verdana",Font.PLAIN,15));
        btnUltima = new JButton("Última");
        btnUltima.setFocusable(false);
        btnUltima.setFont(new Font("Verdana",Font.PLAIN,15));
        btnSiguiente = new JButton(">>");
        btnSiguiente.setFocusable(false);
        btnSiguiente.setFont(new Font("Verdana",Font.PLAIN,15));

        organizadorBtns.add(btnPrimera);
        organizadorBtns.add(btnAnterior);
        organizadorBtns.add(btnSiguiente);
        organizadorBtns.add(btnUltima);

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
        lblNoEncontro = new JLabel("No se encontró información del artista. Inténtelo de nuevo.");
        lblNoEncontro.setFont(new Font("Verdana",Font.BOLD,15));
        lblNoEncontro.setForeground(Color.RED);

        //No es visible a menos que no se encuentre la pieza
        organizadorC.setVisible(false);

        organizadorC.add(lblNoEncontro);
        add(organizadorC,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
