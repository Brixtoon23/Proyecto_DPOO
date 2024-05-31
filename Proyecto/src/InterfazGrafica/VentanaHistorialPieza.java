package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaHistorialPieza extends JFrame implements ActionListener
{
    private String ventanaAnterior;
    private JPanel panelN;
    private JPanel panelS;
    private JButton btnVolver;

    public VentanaHistorialPieza()
    {
        setTitle("Ventana Historial Pieza");
        setSize(750,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelN = new PanelNorteHistoriaPieza();
        add(panelN,BorderLayout.CENTER);

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

        panelS = new PanelSurHistoriaPieza();
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


    /** 
    public static void main(String[] args)
    {
        VentanaHistorialPieza iniciar = new VentanaHistorialPieza();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }
    */
}
