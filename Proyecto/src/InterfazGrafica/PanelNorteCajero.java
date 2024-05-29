package InterfazGrafica;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNorteCajero extends JPanel
{
    private JLabel lblTitulo;
    public PanelNorteCajero()
    {
        setLayout(new BorderLayout());
        lblTitulo = new JLabel("Bienvenido al menú Cajero");
        add(lblTitulo,BorderLayout.CENTER);
    }
}
