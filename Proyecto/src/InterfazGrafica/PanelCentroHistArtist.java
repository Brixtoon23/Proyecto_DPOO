package InterfazGrafica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCentroHistArtist extends JPanel implements ActionListener
{
    private JLabel titulo;
    private JTextField txtNombreArtist;
    private JLabel lblIngreseNombre;
    private JButton btnBuscar;
    
    public PanelCentroHistArtist()
    {
        setLayout(new GridBagLayout());
        add(Box.createVerticalStrut(20));

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
        arregloBusqueda.add(btnBuscar);

        organizador.add(arregloBusqueda);

        add(organizador);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
}
