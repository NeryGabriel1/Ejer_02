package Principal;

public class Cuenta {
	private String nombre;
	private String id;
	private String password;
	private double saldo;
	
	//Constructor 
	public Cuenta(String nom, String identificador, String pass, double sal) {
		nombre = nom;
		id = identificador;
		password = pass;
		saldo = sal;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// Para mostar el objeto cuenta
	public String toString() {
		return nombre;
	}
	

}
