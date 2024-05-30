package Logica;
public class Transferencia {

    private String tipo;
    private String id;


    
    public Transferencia(String tipo, String id) {
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
