
package InterfazGrafica;

import javax.swing.*;

import Logica.Administrador;
import Logica.Pintura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;




public class VentanaPintura extends JFrame {
    // Campos para los detalles de la pintura
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
    private JTextField pesoField;
    private JTextField tecnicaField;
    private JTextField rutaImagenField;
    private JTextField loginPropietarioField;
    private Galeria galeria;

    public VentanaPintura() {

        galeria = InicializadorDeClases.cargarGaleria();
        setTitle("Cargar Pintura");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al cargar la pintura
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5)); // Usar BorderLayout con espacio entre componentes

        // Panel para los campos de entrada de la pintura
        JPanel panelPintura = new JPanel(new GridLayout(0, 2, 5, 5));
        // Agregar campos de entrada para los detalles de la pintura al panel
        panelPintura.add(new JLabel("Título:"));
        tituloField = new JTextField();
        panelPintura.add(tituloField);

        panelPintura.add(new JLabel("Año de creación:"));
        anioCreacionField = new JTextField();
        panelPintura.add(anioCreacionField);

        panelPintura.add(new JLabel("Lugar de creación:"));
        lugarCreacionField = new JTextField();
        panelPintura.add(lugarCreacionField);

        panelPintura.add(new JLabel("Fecha de adquisición:"));
        fechaAdquisicionField = new JTextField();
        panelPintura.add(fechaAdquisicionField);

        panelPintura.add(new JLabel("Valor de compra:"));
        valorCompraField = new JTextField();
        panelPintura.add(valorCompraField);

        panelPintura.add(new JLabel("Autores:"));
        autoresField = new JTextField();
        panelPintura.add(autoresField);

        panelPintura.add(new JLabel("Disponible:"));
        disponibleField = new JTextField();
        panelPintura.add(disponibleField);

        panelPintura.add(new JLabel("Tiempo de consignación:"));
        tiempoConsignacionField = new JTextField();
        panelPintura.add(tiempoConsignacionField);

        panelPintura.add(new JLabel("Subasta:"));
        subastaField = new JTextField();
        panelPintura.add(subastaField);

        panelPintura.add(new JLabel("Valores:"));
        valoresField = new JTextField();
        panelPintura.add(valoresField);

        panelPintura.add(new JLabel("Bodega:"));
        bodegaField = new JTextField();
        panelPintura.add(bodegaField);

        panelPintura.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        panelPintura.add(tipoField);

        panelPintura.add(new JLabel("Alto:"));
        altoField = new JTextField();
        panelPintura.add(altoField);

        panelPintura.add(new JLabel("Ancho:"));
        anchoField = new JTextField();
        panelPintura.add(anchoField);

        panelPintura.add(new JLabel("Peso:"));
        pesoField = new JTextField();
        panelPintura.add(pesoField);

        panelPintura.add(new JLabel("Técnica:"));
        tecnicaField = new JTextField();
        panelPintura.add(tecnicaField);

        panelPintura.add(new JLabel("Ruta de la imagen:"));
        rutaImagenField = new JTextField();
        panelPintura.add(rutaImagenField);

        // Panel para el login del propietario
        JPanel panelPropietario = new JPanel(new GridLayout(0, 2, 5, 5));
        // Nuevo campo de entrada para el login del propietario
        panelPropietario.add(new JLabel("Login del Propietario:"));
        loginPropietarioField = new JTextField();
        panelPropietario.add(loginPropietarioField);

        // Panel principal para los campos de entrada
        JPanel panelEntrada = new JPanel(new BorderLayout());
        panelEntrada.add(panelPintura, BorderLayout.CENTER); // Agregar el panel de pintura en el centro
        panelEntrada.add(panelPropietario, BorderLayout.SOUTH); // Agregar el panel de propietario en el sur

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Botón para volver a la ventana VentanaCargarPieza
        JButton volverButton = new JButton("Volver a Cargar Pieza");
        panelBotones.add(volverButton);
        // Botón para cargar la pintura
        JButton cargarPinturaButton = new JButton("Cargar Pintura");
        panelBotones.add(cargarPinturaButton);

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

        // Acción del botón cargarPinturaButton
        cargarPinturaButton.addActionListener(new ActionListener() {
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
                for (String valor : valoresString) {valores.add(Integer.parseInt(valor.trim()));
                }
                boolean bodega = Boolean.parseBoolean(bodegaField.getText());
                String tipo = tipoField.getText();
                int alto = Integer.parseInt(altoField.getText());
                int ancho = Integer.parseInt(anchoField.getText());
                int peso = Integer.parseInt(pesoField.getText());
                String tecnica = tecnicaField.getText();
                String rutaImagen = rutaImagenField.getText();
                String loginPropietario = loginPropietarioField.getText(); // Obtener el login del propietario

                // Crear una lista de autores
                ArrayList<String> listaAutores = new ArrayList<>();
                for (String autor : autores) {
                    listaAutores.add(autor.trim());
                }

                // Crear y cargar la pintura con los detalles ingresados
                ArrayList<Map<String, Object>> propietarios = new ArrayList<>();
                Map<String, Object> mapaPropietario = new HashMap<>();
                mapaPropietario.put("loginPropietario", loginPropietario);
                mapaPropietario.put("valorCompra", valorCompra);
                mapaPropietario.put("fechaVenta", fechaAdquisicion);
                propietarios.add(mapaPropietario);

                Pintura pintura = new Pintura(titulo, loginPropietario, anioCreacion, lugarCreacion, listaAutores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, alto, ancho, peso, tecnica, rutaImagen);

                // Agregar la pintura a la galería y el autor si no existe
                Administrador.ingresarPieza(galeria, pintura);
                Administrador.ingresarAutor(galeria, listaAutores, titulo);

                // Cerrar esta ventana
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        VentanaPintura ventanaPintura = new VentanaPintura();
        ventanaPintura.pack(); // Ajustar tamaño automáticamente
        ventanaPintura.setVisible(true);
    }
}