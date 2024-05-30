package Logica;
public abstract class MetodoPago
 
{
    private String nombre;
    private int monto;


    
    public MetodoPago(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getMonto() {
        return monto;
    }
    public void setMonto(int monto) {
        this.monto = monto;
    }

    

}

