package InterfazGrafica;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridBagLayout;
public class PanelNorteAdministrador extends JPanel
{
    private JLabel titulo;
    public PanelNorteAdministrador()
    {
        setLayout(new GridBagLayout());
        titulo = new JLabel("Bienvenido al menú de Administrador");
        titulo.setFont(new Font("Verdana",Font.BOLD,30));
        add(titulo);
        add(Box.createVerticalStrut(200));
    }
}