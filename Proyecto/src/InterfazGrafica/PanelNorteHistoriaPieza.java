package InterfazGrafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelNorteHistoriaPieza extends JPanel
{
    private JLabel titulo;
    private JTextField txtNombrePieza;
    private JLabel lblIngreseNombre;
    private JButton btnBuscar;
    
    public PanelNorteHistoriaPieza()
    {
        setLayout(new GridBagLayout());
        add(Box.createVerticalStrut(20));

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
        arregloBusqueda.add(btnBuscar);

        organizador.add(arregloBusqueda);

        add(organizador);

    }
}
