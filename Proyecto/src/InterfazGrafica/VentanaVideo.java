package InterfazGrafica;

import javax.swing.*;

import Logica.Administrador;
import Logica.Video;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;

public class VentanaVideo extends JFrame {
    private JTextField tituloField;
    private JTextField anioCreacionField;
    private JTextField lugarCreacionField;
    private JTextField fechaAdquisicionField;
    private JTextField valorCompraField;
    private JTextField autoresField;
    private JTextField disponibleField;
    private JTextField tiempoConsignacionField;
    private JTextField subastaField;
    private JTextField valoresField;
    private JTextField bodegaField;
    private JTextField tipoField;
    private JTextField resolucionField;
    private JTextField tamanioGigaField;
    private JTextField rutaImagenField;
    private JTextField loginPropietarioField;
    private JTextField duracionField;
    private Galeria galeria;

    public VentanaVideo() {
        galeria = InicializadorDeClases.cargarGaleria();
        setTitle("Cargar Video");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al cargar el video
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5)); // Usar BorderLayout con espacio entre componentes

        // Panel para los campos de entrada del video
        JPanel panelVideo = new JPanel(new GridLayout(0, 2, 5, 5));
        // Agregar campos de entrada para los detalles del video al panel
        panelVideo.add(new JLabel("Título:"));
        tituloField = new JTextField();
        panelVideo.add(tituloField);

        panelVideo.add(new JLabel("Año de creación:"));
        anioCreacionField = new JTextField();
        panelVideo.add(anioCreacionField);

        panelVideo.add(new JLabel("Lugar de creación:"));
        lugarCreacionField = new JTextField();
        panelVideo.add(lugarCreacionField);

        panelVideo.add(new JLabel("Fecha de adquisición:"));
        fechaAdquisicionField = new JTextField();
        panelVideo.add(fechaAdquisicionField);

        panelVideo.add(new JLabel("Valor de compra:"));
        valorCompraField = new JTextField();
        panelVideo.add(valorCompraField);

        panelVideo.add(new JLabel("Autores:"));
        autoresField = new JTextField();
        panelVideo.add(autoresField);

        panelVideo.add(new JLabel("Disponible:"));
        disponibleField = new JTextField();
        panelVideo.add(disponibleField);

        panelVideo.add(new JLabel("Tiempo de consignación:"));
        tiempoConsignacionField = new JTextField();
        panelVideo.add(tiempoConsignacionField);

        panelVideo.add(new JLabel("Subasta:"));
        subastaField = new JTextField();
        panelVideo.add(subastaField);

        panelVideo.add(new JLabel("Valores:"));
        valoresField = new JTextField();
        panelVideo.add(valoresField);

        panelVideo.add(new JLabel("Bodega:"));
        bodegaField = new JTextField();
        panelVideo.add(bodegaField);

        panelVideo.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        panelVideo.add(tipoField);

        panelVideo.add(new JLabel("Resolución:"));
        resolucionField = new JTextField();
        panelVideo.add(resolucionField);

        panelVideo.add(new JLabel("Tamaño (Gigas):"));
        tamanioGigaField = new JTextField();
        panelVideo.add(tamanioGigaField);

        panelVideo.add(new JLabel("Duración (minutos):"));
        duracionField = new JTextField();
        panelVideo.add(duracionField);

        panelVideo.add(new JLabel("Ruta de la imagen:"));
        rutaImagenField = new JTextField();
        panelVideo.add(rutaImagenField);

        // Panel para el login del propietario
        JPanel panelPropietario = new JPanel(new GridLayout(0, 2, 5, 5));
        // Nuevo campo de entrada para el login del propietario
        panelPropietario.add(new JLabel("Login del Propietario:"));
        loginPropietarioField = new JTextField();
        panelPropietario.add(loginPropietarioField);

        // Panel principal para los campos de entrada
        JPanel panelEntrada = new JPanel(new BorderLayout());
        panelEntrada.add(panelVideo, BorderLayout.CENTER); // Agregar el panel de video en el centro
        panelEntrada.add(panelPropietario, BorderLayout.SOUTH); // Agregar el panel de propietario en el sur

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Botón para volver a la ventana VentanaCargarPieza
        JButton volverButton = new JButton("Volver a Cargar Pieza");
        panelBotones.add(volverButton);
        // Botón para cargar el video
        JButton cargarVideoButton = new JButton("Cargar Video");
        panelBotones.add(cargarVideoButton);

        // Agregar paneles al contenedor principal (BorderLayout)
        add(panelEntrada, BorderLayout.CENTER); // Agregar el panel de entrada en el centro
        add(panelBotones, BorderLayout.SOUTH); // Agregar el panel de botones en el sur

        // Acción del botón volverButton
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de la ventana anterior (VentanaCargarPieza)
                VentanaCargarPieza ventanaCargarPieza = new VentanaCargarPieza();
                // Mostrar la ventana VentanaCargarPieza y ocultar esta ventana
                ventanaCargarPieza.setVisible(true);
                setVisible(false);
            }
        });

        // Acción del botón cargarVideoButton
        cargarVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados por el usuario
                String titulo = tituloField.getText();
                int anioCreacion = Integer.parseInt(anioCreacionField.getText());
                String lugarCreacion = lugarCreacionField.getText();
                String fechaAdquisicion = fechaAdquisicionField.getText();
                int valorCompra = Integer.parseInt(valorCompraField.getText());
                String[] autores = autoresField.getText().split(",");
                boolean disponible = Boolean.parseBoolean(disponibleField.getText());
                int tiempoConsignacion = Integer.parseInt(tiempoConsignacionField.getText());
                boolean subasta = Boolean.parseBoolean(subastaField.getText());
                String[] valoresString = valoresField.getText().split(",");
                ArrayList<Integer> valores = new ArrayList<>();
                for (String valor : valoresString) {
                    valores.add(Integer.parseInt(valor.trim()));
                }
                boolean bodega = Boolean.parseBoolean(bodegaField.getText());
                String tipo = tipoField.getText();
                String resolucion = resolucionField.getText();
                int tamanioGiga = Integer.parseInt(tamanioGigaField.getText());
                int duracion = Integer.parseInt(duracionField.getText());
                String rutaImagen = rutaImagenField.getText();
                String loginPropietario = loginPropietarioField.getText(); // Obtener el login del propietario

                // Crear una lista de autores
                ArrayList<String> listaAutores = new ArrayList<>();
                for (String autor : autores) {
                    listaAutores.add(autor.trim());
                }

                // Crear y cargar el video con los detalles ingresados
                ArrayList<Map<String, Object>> propietarios = new ArrayList<>();
                Map<String, Object> mapaPropietario = new HashMap<>();
                mapaPropietario.put("loginPropietario", loginPropietario);
                mapaPropietario.put("valorCompra", valorCompra);
                mapaPropietario.put("fechaVenta", fechaAdquisicion);
                propietarios.add(mapaPropietario);

                Video video = new Video(titulo, loginPropietario, anioCreacion, lugarCreacion, listaAutores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, duracion, tamanioGiga, resolucion, rutaImagen);

                // Agregar el video a la galería y el autor si no existe
                Administrador.ingresarPieza(galeria, video);
                Administrador.ingresarAutor(galeria, listaAutores, titulo);

                // Cerrar esta ventana
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        VentanaVideo ventanaVideo = new VentanaVideo();
        ventanaVideo.pack(); // Ajustar tamaño automáticamente
        ventanaVideo.setVisible(true);
    }
}
