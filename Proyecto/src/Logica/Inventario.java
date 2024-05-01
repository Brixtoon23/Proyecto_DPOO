package Logica;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Pieza> piezasBodega;
    private ArrayList<Pieza> piezasExhibidad;

    public Inventario(ArrayList<Pieza> piezasBodega, ArrayList<Pieza> piezasExhibidad) {
        this.piezasBodega = piezasBodega;
        this.piezasExhibidad = piezasExhibidad;
    }

    public ArrayList<Pieza> getPiezasBodega() {
        return piezasBodega;
    }

    public ArrayList<Pieza> getPiezasExhibidad() {
        return piezasExhibidad;
    }
}
