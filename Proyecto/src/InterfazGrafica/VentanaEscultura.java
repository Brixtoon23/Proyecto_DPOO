package InterfazGrafica;
import javax.swing.*;

import Logica.Administrador;
import Logica.Escultura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;
import Logica.Escultura;

public class VentanaEscultura extends JFrame 
{
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
    private JTextField altoField;
    private JTextField anchoField;
    private JTextField profundidadField;
    private JTextField pesoField;
    private JTextField electricidadField;
    private JTextField rutaImagenField;
    private JTextField loginPropietarioField;
    private Galeria galeria;

    public VentanaEscultura() {
    galeria = InicializadorDeClases.cargarGaleria();
    setTitle("Cargar Escultura");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al cargar la escultura
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5)); // Usar BorderLayout con espacio entre componentes

        // Panel para los campos de entrada de la escultura
        JPanel panelEscultura = new JPanel(new GridLayout(0, 2, 5, 5));
        // Agregar campos de entrada para los detalles de la escultura al panel
        panelEscultura.add(new JLabel("Título:"));
        tituloField = new JTextField();
        panelEscultura.add(tituloField);

        panelEscultura.add(new JLabel("Año de creación:"));
        anioCreacionField = new JTextField();
        panelEscultura.add(anioCreacionField);

        panelEscultura.add(new JLabel("Lugar de creación:"));
        lugarCreacionField = new JTextField();
        panelEscultura.add(lugarCreacionField);

        panelEscultura.add(new JLabel("Fecha de adquisición:"));
        fechaAdquisicionField = new JTextField();
        panelEscultura.add(fechaAdquisicionField);

        panelEscultura.add(new JLabel("Valor de compra:"));
        valorCompraField = new JTextField();
        panelEscultura.add(valorCompraField);

        panelEscultura.add(new JLabel("Autores:"));
        autoresField = new JTextField();
        panelEscultura.add(autoresField);

        panelEscultura.add(new JLabel("Disponible:"));
        disponibleField = new JTextField();
        panelEscultura.add(disponibleField);

        panelEscultura.add(new JLabel("Tiempo de consignación:"));
        tiempoConsignacionField = new JTextField();
        panelEscultura.add(tiempoConsignacionField);

        panelEscultura.add(new JLabel("Subasta:"));
        subastaField = new JTextField();
        panelEscultura.add(subastaField);

        panelEscultura.add(new JLabel("Valores:"));
        valoresField = new JTextField();
        panelEscultura.add(valoresField);

        panelEscultura.add(new JLabel("Bodega:"));
        bodegaField = new JTextField();
        panelEscultura.add(bodegaField);

        panelEscultura.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        panelEscultura.add(tipoField);

        panelEscultura.add(new JLabel("Alto:"));
        altoField = new JTextField();
        panelEscultura.add(altoField);

        panelEscultura.add(new JLabel("Ancho:"));
        anchoField = new JTextField();
        panelEscultura.add(anchoField);

        panelEscultura.add(new JLabel("Profundidad:"));
        profundidadField = new JTextField();
        panelEscultura.add(profundidadField);

        panelEscultura.add(new JLabel("Peso:"));
        pesoField = new JTextField();
        panelEscultura.add(pesoField);

        panelEscultura.add(new JLabel("¿Necesita electricidad? (true/false):"));
        electricidadField = new JTextField();
        panelEscultura.add(electricidadField);

        panelEscultura.add(new JLabel("Ruta de la imagen:"));
        rutaImagenField = new JTextField();
        panelEscultura.add(rutaImagenField);

        // Panel para el login del propietario
        JPanel panelPropietario = new JPanel(new GridLayout(0, 2, 5, 5));
        // Nuevo campo de entrada para el login del propietario
        panelPropietario.add(new JLabel("Login del Propietario:"));
        loginPropietarioField = new JTextField();
        panelPropietario.add(loginPropietarioField);

        // Panel principal para los campos de entrada
        JPanel panelEntrada = new JPanel(new BorderLayout());
        panelEntrada.add(panelEscultura, BorderLayout.CENTER); // Agregar el panel de escultura en el centro
        panelEntrada.add(panelPropietario, BorderLayout.SOUTH); // Agregar el panel de propietario en el sur

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Botón para volver a la ventana VentanaCargarPieza
        JButton volverButton = new JButton("Volver a Cargar Pieza");
        panelBotones.add(volverButton);
        // Botón para cargar la escultura
        JButton cargarEsculturaButton = new JButton("Cargar Escultura");
        panelBotones.add(cargarEsculturaButton);

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

        // Acción del botón cargarEsculturaButton
        cargarEsculturaButton.addActionListener(new ActionListener() {
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
                int alto = Integer.parseInt(altoField.getText());
                int ancho = Integer.parseInt(anchoField.getText());
                int profundidad = Integer.parseInt(profundidadField.getText());
                int peso = Integer.parseInt(pesoField.getText());
                boolean electricidad = Boolean.parseBoolean(electricidadField.getText());
                String rutaImagen = rutaImagenField.getText();
                String loginPropietario = loginPropietarioField.getText(); // Obtener el login del propietario

                // Crear una lista de autores
                ArrayList<String> listaAutores = new ArrayList<>();
                for (String autor : autores) {
                    listaAutores.add(autor.trim());
                }

                // Crear y cargar la escultura con los detalles ingresados
                ArrayList<Map<String, Object>> propietarios = new ArrayList<>();
                Map<String, Object> mapaPropietario = new HashMap<>();
                mapaPropietario.put("loginPropietario", loginPropietario);
                mapaPropietario.put("valorCompra", valorCompra);
                mapaPropietario.put("fechaVenta", fechaAdquisicion);
                propietarios.add(mapaPropietario);

                Escultura escultura = new Escultura(titulo, loginPropietario, anioCreacion, lugarCreacion, listaAutores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, alto, ancho, profundidad, peso, electricidad, rutaImagen);

                // Agregar la escultura a la galería y el autor si no existe
                Administrador.ingresarPieza(galeria, escultura);
                Administrador.ingresarAutor(galeria, listaAutores, titulo);

                // Cerrar esta ventana
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        VentanaEscultura ventanaEscultura = new VentanaEscultura();
        ventanaEscultura.pack(); // Ajustar tamaño automáticamente
        ventanaEscultura.setVisible(true);
    }
}
    
