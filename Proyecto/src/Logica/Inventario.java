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


    //TODO: revisar
    public Pieza buscarPieza(String nomPieza)
    {
        Pieza pRespuesta = null;
        boolean encontro = false;
        int i = 0;
        while((i<piezasBodega.size())&&(!encontro))
        {
            Pieza pBodega = piezasBodega.get(i);
            if (pBodega.getTitulo().equals(nomPieza))
            {
                pRespuesta = pBodega;
                encontro = true;
            }
            i++;
        }

        if(!encontro)
        {
            i = 0;
            while((i<piezasExhibidad.size())&&(!encontro))
            {
                Pieza pExhibicion = piezasExhibidad.get(i);
                if(pExhibicion.getTitulo().equals(nomPieza))
                {
                    pRespuesta = pExhibicion;
                    encontro = true;
                }
                i++;
            }
        }

        return pRespuesta;

    }
}
