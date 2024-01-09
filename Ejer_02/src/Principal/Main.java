package Principal;

public class Main {
	public static void main(String[] args) {
		Cajero cajero = new Cajero();
		cajero.crearCuenta("Gabriel Benítez","1234", "2020", 500);
		cajero.crearCuenta("Eduardo Franco","5678", "0987", 500);
		cajero.crearCuenta("Mario Cano","3448", "0564", 1);
		cajero.eliminarCuenta("3448", "0564");
		cajero.iniciarCajero();
		
	}

}
