package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaHistorialArtista extends JFrame implements ActionListener
{
    private JPanel panelC;
    private JPanel panelS;
    private JButton btnVolver;
    private String ventanaAnterior;

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

        panelC = new PanelCentroHistArtist();
        add(panelC,BorderLayout.CENTER);

        panelS = new PanelSurHistArtist();
        add(panelS,BorderLayout.SOUTH);
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
    }

    public void setVentanaAnterior(String anterior)
    {
        ventanaAnterior = anterior;
    }

}
