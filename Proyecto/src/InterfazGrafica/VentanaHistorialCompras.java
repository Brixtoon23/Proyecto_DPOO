package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Logica.Compra;
import Logica.Galeria;
import Persistencia.InicializadorDeClases;

public class VentanaHistorialCompras extends JFrame {
    private Galeria galeria;
    private List<Compra> compras;

    public VentanaHistorialCompras() {
        galeria = InicializadorDeClases.cargarGaleria();
        compras = galeria.getCompras();
        
        setTitle("Historial de Compras");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarHistorial(g);
            }
        };
        getContentPane().add(panel);
        
        setLocationRelativeTo(null);
    }

    private void dibujarHistorial(Graphics g) {
        // Dibujar eje X
        g.drawLine(50, 500, 750, 500);
        g.drawLine(750, 500, 740, 495);
        g.drawLine(750, 500, 740, 505);
        g.drawString("Meses", 760, 520);

        // Dibujar eje Y
        g.drawLine(50, 500, 50, 50);
        g.drawLine(50, 50, 45, 60);
        g.drawLine(50, 50, 55, 60);
        g.drawString("Ventas", 20, 40);

        // Dibujar barras de ventas
        int anchoBarra = 20;
        int espacioEntreBarras = 10;
        int x = 100;
        int mes = 1;
        for (Compra compra : compras) {
            // Convertir la fecha de la compra al mes correspondiente
            String fechaCompra = compra.getFecha();
            String[] partesFecha = fechaCompra.split("/");
            int mesCompra = Integer.parseInt(partesFecha[1]); // Obtener el mes de la fecha
            int ventas = compra.getPrecio(); // Usar el precio como valor de ventas (podrías cambiar esto según tus necesidades)
            int alturaBarra = ventas * 4; // Escalar para que las barras se ajusten al tamaño de la ventana
            g.setColor(Color.blue);
            g.fillRect(x, 500 - alturaBarra, anchoBarra, alturaBarra);
            g.setColor(Color.black);
            g.drawString(String.valueOf(mesCompra), x + 5, 520); // Mostrar el mes de la compra
            x += anchoBarra + espacioEntreBarras;
            mes++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaHistorialCompras ventana = new VentanaHistorialCompras();
            ventana.setVisible(true);
        });
    }
}