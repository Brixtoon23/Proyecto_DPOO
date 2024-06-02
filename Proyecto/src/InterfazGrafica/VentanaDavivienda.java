package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDavivienda extends JFrame implements ActionListener {
    private JTextField usuarioField;
    private JPasswordField claveField;
    private JTextField csvField;
    private JButton pagarButton;
    private JLabel resultadoLabel;

    public VentanaDavivienda() {
        setTitle("Pago con Davivienda");
        setSize(600, 400); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Usuario:"));
        usuarioField = new JTextField();
        add(usuarioField);

        add(new JLabel("Clave:"));
        claveField = new JPasswordField();
        add(claveField);

        add(new JLabel("CSV:"));
        csvField = new JTextField();
        add(csvField);

        pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(this);
        add(pagarButton);

        resultadoLabel = new JLabel("");
        add(resultadoLabel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pagarButton) {
            // Aquí iría la lógica para procesar el pago con Davivienda
            // Puedes adaptar el código de tu clase menuDavivienda aquí

            // Por ahora, simplemente mostraremos un mensaje de éxito
            resultadoLabel.setText("Pago realizado con éxito");
        }
    }

    public static void main(String[] args) {
        VentanaDavivienda ventanaDavivienda = new VentanaDavivienda();
        ventanaDavivienda.setVisible(true);
    }
}
