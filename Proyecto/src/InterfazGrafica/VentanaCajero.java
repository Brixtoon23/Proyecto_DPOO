package InterfazGrafica;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VentanaCajero extends JFrame implements ActionListener
{
    private JButton btnHistorialPieza;
    private JButton btnHistorialAutor;
    private JPanel panelN;
    private JPanel panelC;

    public VentanaCajero()
    {
        setTitle("Menú Cajero");
        setSize(750,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelN = new PanelNorteCajero();
        add(panelN,BorderLayout.NORTH);
        
        panelC = new PanelCentroCajero();
        add(panelC,BorderLayout.CENTER);
        btnHistorialAutor = new JButton("Consultar historial de un autor");
        btnHistorialPieza = new JButton("Consultar historial de una pieza");
        panelC.add(btnHistorialPieza);
        panelC.add(btnHistorialAutor);
        
    }

    public static void main(String[] args)
    {
        VentanaCajero iniciar = new VentanaCajero();
        iniciar.setVisible(true);
        iniciar.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
