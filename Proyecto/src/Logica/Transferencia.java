package Logica;
public class Transferencia extends MetodoPago
{

    private String tipo;
    private String id;
    public Transferencia(String nombre, int monto, String tipo, String id) {
        super(nombre, monto);
        this.tipo = tipo;
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    
    


}
