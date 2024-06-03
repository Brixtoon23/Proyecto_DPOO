
package InterfazGrafica;

import javax.swing.*;

import Logica.Administrador;
import Logica.Fotografia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;

public class VentanaFotografia extends JFrame {
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
    private Galeria galeria;

    public VentanaFotografia()
    {
        galeria = InicializadorDeClases.cargarGaleria();
        setTitle("Cargar Fotografía");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al cargar la fotografía
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5)); // Usar BorderLayout con espacio entre componentes

        // Panel para los campos de entrada de la fotografía
        JPanel panelFotografia = new JPanel(new GridLayout(0, 2, 5, 5));
        // Agregar campos de entrada para los detalles de la fotografía al panel
        panelFotografia.add(new JLabel("Título:"));
        tituloField = new JTextField();
        panelFotografia.add(tituloField);

        panelFotografia.add(new JLabel("Año de creación:"));
        anioCreacionField = new JTextField();
        panelFotografia.add(anioCreacionField);

        panelFotografia.add(new JLabel("Lugar de creación:"));
        lugarCreacionField = new JTextField();
        panelFotografia.add(lugarCreacionField);

        panelFotografia.add(new JLabel("Fecha de adquisición:"));
        fechaAdquisicionField = new JTextField();
        panelFotografia.add(fechaAdquisicionField);

        panelFotografia.add(new JLabel("Valor de compra:"));
        valorCompraField = new JTextField();
        panelFotografia.add(valorCompraField);

        panelFotografia.add(new JLabel("Autores:"));
        autoresField = new JTextField();
        panelFotografia.add(autoresField);

        panelFotografia.add(new JLabel("Disponible:"));
        disponibleField = new JTextField();
        panelFotografia.add(disponibleField);

        panelFotografia.add(new JLabel("Tiempo de consignación:"));
        tiempoConsignacionField = new JTextField();
        panelFotografia.add(tiempoConsignacionField);

        panelFotografia.add(new JLabel("Subasta:"));
        subastaField = new JTextField();
        panelFotografia.add(subastaField);

        panelFotografia.add(new JLabel("Valores:"));
        valoresField = new JTextField();
        panelFotografia.add(valoresField);

        panelFotografia.add(new JLabel("Bodega:"));
        bodegaField = new JTextField();
        panelFotografia.add(bodegaField);

        panelFotografia.add(new JLabel("Tipo:"));
        tipoField = new JTextField();
        panelFotografia.add(tipoField);

        panelFotografia.add(new JLabel("Resolución:"));
        resolucionField = new JTextField();
        panelFotografia.add(resolucionField);

        panelFotografia.add(new JLabel("Tamaño (Gigas):"));
        tamanioGigaField = new JTextField();
        panelFotografia.add(tamanioGigaField);

        panelFotografia.add(new JLabel("Ruta de la imagen:"));
        rutaImagenField = new JTextField();
        panelFotografia.add(rutaImagenField);

        // Panel para el login del propietario
        JPanel panelPropietario = new JPanel(new GridLayout(0, 2, 5, 5));
        // Nuevo campo de entrada para el login del propietario
        panelPropietario.add(new JLabel("Login del Propietario:"));
        loginPropietarioField = new JTextField();
        panelPropietario.add(loginPropietarioField);

        // Panel principal para los campos de entrada
        JPanel panelEntrada = new JPanel(new BorderLayout());
        panelEntrada.add(panelFotografia, BorderLayout.CENTER); // Agregar el panel de fotografía en el centro
        panelEntrada.add(panelPropietario, BorderLayout.SOUTH); // Agregar el panel de propietario en el sur

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Botón para volver a la ventana VentanaCargarPieza
        JButton volverButton = new JButton("Volver a Cargar Pieza");
        panelBotones.add(volverButton);
        // Botón para cargar la fotografía
        JButton cargarFotografiaButton = new JButton("Cargar Fotografía");
        panelBotones.add(cargarFotografiaButton);

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

        // Acción del botón cargarFotografiaButton
        cargarFotografiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
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
                    String rutaImagen = rutaImagenField.getText();
                    String loginPropietario = loginPropietarioField.getText(); // Obtener el login del propietario

                    // Crear una lista de autores
                    ArrayList<String> listaAutores = new ArrayList<>();
                    for (String autor : autores) {
                        listaAutores.add(autor.trim());
                    }

                    // Crear y cargar la fotografía con los detalles ingresados
                    ArrayList<Map<String, Object>> propietarios = new ArrayList<>();
                    Map<String, Object> mapaPropietario = new HashMap<>();
                    mapaPropietario.put("loginPropietario", loginPropietario);
                    mapaPropietario.put("valorCompra", valorCompra);
                    mapaPropietario.put("fechaVenta", fechaAdquisicion);
                    propietarios.add(mapaPropietario);

                    Fotografia fotografia = new Fotografia(titulo, loginPropietario, anioCreacion, lugarCreacion, listaAutores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, resolucion, tamanioGiga, rutaImagen);

                    // Agregar la fotografía a la galería y el autor si no existe
                    Administrador.ingresarPieza(galeria, fotografia);
                    Administrador.ingresarAutor(galeria, listaAutores, titulo);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Fotografía cargada satisfactoriamente");

                    // Limpiar los campos
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje de error si hay algún campo numérico incorrecto
                    JOptionPane.showMessageDialog(null, "Error en el formato de algún campo numérico");
                }
            }
        });
    }

    // Método para limpiar los campos de entrada
    private void limpiarCampos() {
        tituloField.setText("");
        anioCreacionField.setText("");
        lugarCreacionField.setText("");
        fechaAdquisicionField.setText("");
        valorCompraField.setText("");
        autoresField.setText("");
        disponibleField.setText("");
        tiempoConsignacionField.setText("");
        subastaField.setText("");
        valoresField.setText("");
        bodegaField.setText("");
        tipoField.setText("");
        resolucionField.setText("");
        tamanioGigaField.setText("");
        rutaImagenField.setText("");
        loginPropietarioField.setText("");
    }

    public static void main(String[] args) {
        VentanaFotografia ventanaFotografia = new VentanaFotografia();
        ventanaFotografia.pack(); // Ajustar tamaño automáticamente
        ventanaFotografia.setVisible(true);
    }
}
