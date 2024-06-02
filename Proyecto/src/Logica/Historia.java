package Logica;

public class Historia 
{
    private String loginComprador;
    private String fecha;
    private int monto;
    private boolean realizada;
    private int numero;
    private  String banco;
    public Historia(String loginComprador, String fecha, int monto, boolean realizada, int numero, String banco) {
        this.loginComprador = loginComprador;
        this.fecha = fecha;
        this.monto = monto;
        this.realizada = realizada;
        this.banco = banco;
        this.numero = numero;
        
    }
    public String getLoginComprador() {
        return loginComprador;
    }
    public String getFecha() {
        return fecha;
    }
    public int getMonto() {
        return monto;
    }
    
    public boolean isRealizada() {
        return realizada;
    }
    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
    public int getNumero() {
        return numero;
    }
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    

}
