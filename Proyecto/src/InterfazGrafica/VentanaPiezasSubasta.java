package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Logica.Galeria;
import Logica.Pieza;
import Logica.Servicios;
import Persistencia.InicializadorDeClases;

public class VentanaPiezasSubasta extends JFrame implements ActionListener {
    private List<Pieza> piezas;
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
    private Galeria galeria;

    public VentanaPiezasSubasta() {
        galeria = InicializadorDeClases.cargarGaleria();
        piezas = Servicios.hacerListaSubastas(galeria.getInventario().getPiezasExhibidad(), galeria.getInventario().getPiezasBodega());
        indiceActual = 0;

        setTitle("Piezas Subastadas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para mostrar la pieza actual
        JPanel piezaPanel = new JPanel();
        piezaPanel.setLayout(new BoxLayout(piezaPanel, BoxLayout.Y_AXIS));

        tituloLabel = new JLabel();
        propietarioLabel = new JLabel();
        anioLabel = new JLabel();
        lugarLabel = new JLabel();
        valorLabel = new JLabel();
        tipoLabel = new JLabel();
        fotoLabel = new JLabel();

        piezaPanel.add(tituloLabel);
        piezaPanel.add(propietarioLabel);
        piezaPanel.add(anioLabel);
        piezaPanel.add(lugarLabel);
        piezaPanel.add(valorLabel);
        piezaPanel.add(tipoLabel);
        piezaPanel.add(fotoLabel);

        // Panel para los botones de navegación
        JPanel botonesPanel = new JPanel();
        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");

        botonesPanel.add(anteriorButton);
        botonesPanel.add(siguienteButton);

        add(piezaPanel, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

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
        valorLabel.setText("Valor mínimo: " + pieza.getValores().get(1)); // Asegúrate de que 'getValores()' devuelve una lista con al menos dos elementos.
        tipoLabel.setText("Tipo: " + pieza.getTipo());

        // Cargar la imagen
        ImageIcon icon = new ImageIcon(pieza.getRutaImagen());
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
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
        });
    }
}
