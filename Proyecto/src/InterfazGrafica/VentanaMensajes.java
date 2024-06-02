package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Logica.Galeria;
import Logica.Mensaje;
import Logica.Servicios;
import Logica.Comprador;
import Persistencia.InicializadorDeClases;


public class VentanaMensajes extends JFrame 
{
    private Galeria galeria;
    private JTextField loginField;
    private JTextArea mensajesArea;

    public VentanaMensajes() 
    {
        galeria = InicializadorDeClases.cargarGaleria();

        setTitle("Mensajes de Subasta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Ingrese su login:"));
        loginField = new JTextField();
        inputPanel.add(loginField);

        JButton checkMessagesButton = new JButton("Verificar Mensajes");
        inputPanel.add(checkMessagesButton);

        add(inputPanel, BorderLayout.NORTH);

        mensajesArea = new JTextArea();
        mensajesArea.setEditable(false);
        add(new JScrollPane(mensajesArea), BorderLayout.CENTER);

        JButton backButton = new JButton("Volver al Menú");
        add(backButton, BorderLayout.SOUTH);

        // Action listener for the check messages button
        checkMessagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                Comprador comprador = Servicios.buscarComprador(galeria, login);
                List<Mensaje> mensajes = comprador.getMensajesSubasta();
                if (mensajes.size() == 0) {
                    mensajesArea.setText("No tienes ventas aprobadas por subasta por el momento. Revisa más tarde.");
                } else {
                    StringBuilder mensajesTexto = new StringBuilder();
                    for (Mensaje mensaje : mensajes) {
                        mensajesTexto.append(mensaje.getMensaj1()).append("\n");
                    }
                    mensajesArea.setText(mensajesTexto.toString());
                }
            }
        });

        // Action listener for the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaComprador ventanaComprador = new VentanaComprador();
                ventanaComprador.setVisible(true);
                dispose(); // Close the current window
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaMensajes iniciar = new VentanaMensajes();
                iniciar.setVisible(true);
                iniciar.setLocationRelativeTo(null);
            }
        });
    }

   
}
