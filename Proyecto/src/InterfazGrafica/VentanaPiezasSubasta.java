package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Logica.Galeria;
import Logica.Pieza;
import Logica.Servicios;
import Persistencia.InicializadorDeClases;


public class VentanaPiezasSubasta extends JFrame implements ActionListener {
    private ArrayList<Pieza> piezas;
    private int indiceActual;
    private JLabel tituloLabel;
    private JLabel propietarioLabel;
    private JLabel anioLabel;
    private JLabel lugarLabel;
    private JLabel valorLabel;
    private JLabel tipoLabel;
    private JLabel fotoLabel;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton volverButton; // Nuevo botón para volver a la ventana del comprador
    private Galeria galeria;

    public VentanaPiezasSubasta() 
    {
        galeria = InicializadorDeClases.cargarGaleria();
        ArrayList<Pieza> bodega = galeria.getInventario().getPiezasBodega();
        ArrayList<Pieza> exhibidas= galeria.getInventario().getPiezasExhibidad();

        
        piezas = Servicios.hacerListaSubastas(exhibidas, bodega);
        
        indiceActual = 0;


        setTitle("Piezas en Subastas");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Título de la ventana
        tituloLabel = new JLabel("Piezas en Subastas");
        tituloLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(tituloLabel, BorderLayout.NORTH);

        // Panel principal para la imagen y los detalles
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel para la imagen de la pieza
        JPanel imagenPanel = new JPanel();
        imagenPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Ajustar el diseño del panel de la imagen
        fotoLabel = new JLabel();
        imagenPanel.add(fotoLabel);
        mainPanel.add(imagenPanel, BorderLayout.WEST);

        // Panel para los detalles de la pieza
        JPanel detallesPanel = new JPanel();
        detallesPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 10); // Mover los detalles 10 píxeles a la izquierda

        Font font = new Font("Verdana", Font.PLAIN, 18);

        tituloLabel = new JLabel();
        tituloLabel.setFont(font);
        tituloLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        propietarioLabel = new JLabel();
        propietarioLabel.setFont(font);
        propietarioLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        anioLabel = new JLabel();
        anioLabel.setFont(font);
        anioLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lugarLabel = new JLabel();
        lugarLabel.setFont(font);
        lugarLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        valorLabel = new JLabel();
        valorLabel.setFont(font);
        valorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        tipoLabel = new JLabel();
        tipoLabel.setFont(font);
        tipoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        detallesPanel.add(tituloLabel, gbc);
        gbc.gridy++;
        detallesPanel.add(propietarioLabel, gbc);
        gbc.gridy++;
        detallesPanel.add(anioLabel, gbc);
        gbc.gridy++;
        detallesPanel.add(lugarLabel, gbc);
        gbc.gridy++;
        detallesPanel.add(valorLabel, gbc);
        gbc.gridy++;
        detallesPanel.add(tipoLabel, gbc);

        mainPanel.add(detallesPanel, BorderLayout.CENTER);

        // Panel para los botones de navegación
        JPanel botonesPanel = new JPanel();
        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");

        botonesPanel.add(anteriorButton);
        botonesPanel.add(siguienteButton);

        // Botón para volver a la ventana del comprador
        volverButton = new JButton("Volver al Menú Comprador");
        botonesPanel.add(volverButton);

        add(mainPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

        // Agregar ActionListener para el botón "Volver al Menú Comprador"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual y abrir la ventana del comprador
                dispose(); // Cerrar la ventana actual
                VentanaComprador ventanaComprador = new VentanaComprador();
                ventanaComprador.setVisible(true);
                ventanaComprador.setLocationRelativeTo(null);
            }
        });

        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual > 0) {
                    indiceActual--;
                    actualizarPieza();
                }
            }
        });

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual < piezas.size() - 1) {
                    indiceActual++;
                    actualizarPieza();
                }
            }
        });

        // Mostrar la primera pieza
        actualizarPieza();
    }

    private void actualizarPieza() {
        Pieza pieza = piezas.get(indiceActual);
        tituloLabel.setText("Título: " + pieza.getTitulo());
        propietarioLabel.setText("Propietario Actual: " + pieza.getLoginPropietarioActual());
        anioLabel.setText("Año de Creación: " + pieza.getAnioCreacion());
        lugarLabel.setText("Lugar de Creación: " + pieza.getLugarCreacion());
        valorLabel.setText("Valor mínimo: " + pieza.getValores().get(1));
        tipoLabel.setText("Tipo: " + pieza.getTipo());

        // Cargar la imagen
        ImageIcon icon = new ImageIcon(pieza.getRutaImagen());
        Image image = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajustar el tamaño de la imagen
        fotoLabel.setIcon(new ImageIcon(image));

        // Actualizar la interfaz
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementación del método actionPerformed si es necesario
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPiezasSubasta ventana = new VentanaPiezasSubasta();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        });
    }
}

