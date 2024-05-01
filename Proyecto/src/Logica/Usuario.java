package Logica;

public abstract class Usuario {
	protected String login;
	protected String nombre;
	protected String password;
	protected String rol;
	protected String telefono;
	protected boolean verificado;
	
	
	public Usuario(String login, String nombre, String password, String rol, String telefono, boolean verificado) {
		
		this.login = login;
		this.nombre = nombre;
		this.password = password;
		this.rol = rol;
		this.telefono = telefono;
		this.verificado = verificado;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public boolean isVerificado() {
		return verificado;
	}


	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}
	
	
	
	
	
	
	
	
	
	

}
