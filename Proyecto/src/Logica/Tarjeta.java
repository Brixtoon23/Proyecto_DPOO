package Logica;
public class Tarjeta extends MetodoPago
 {
    private String  loginComprador;
    private int numero;
    private int pin;
    private int csv;
    public Tarjeta(String nombre, int monto, String loginComprador, int numero, int pin, int csv) {
        super(nombre, monto);
        this.loginComprador = loginComprador;
        this.numero = numero;
        this.pin = pin;
        this.csv = csv;
    }
    public String getLoginComprador() {
        return loginComprador;
    }
    public void setLoginComprador(String loginComprador) {
        this.loginComprador = loginComprador;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public int getCsv() {
        return csv;
    }
    public void setCsv(int csv) {
        this.csv = csv;
    }

    








}
