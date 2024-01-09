package Principal;

import java.util.*;

public class Cajero {
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void agregarCuenta(Cuenta cuenta) {
		cuentas.add(cuenta);
	}

	public void crearCuenta(String nombre, String id, String password, double saldo) {

		Cuenta cuentaNueva = new Cuenta(nombre, id, password, saldo);
		agregarCuenta(cuentaNueva);
	}

	public void eliminarCuenta(String id, String password) {
		int indexCuenta = verificarCuenta(id, password);

		if (indexCuenta != -1 && !cuentas.isEmpty()) {
			cuentas.remove(indexCuenta);
		}

	}

	public void iniciarCajero() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Tienes una cuenta (sí or no): ");
		String tieneCuenta = sc.nextLine();
		boolean continuar = tieneCuenta.equalsIgnoreCase("sí");
		if (!continuar) {
			System.out.println("Necesitas una cuenta");
		}
		while (continuar) {

			System.out.println("\n¡Bien venido!");
			System.out.println("1. Iniciar sesión");
			System.out.println("2. Salir");
			System.out.print("Seleccione una opción: ");

			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				iniciarSesion(sc);
				break;
			case 2:
				continuar = !continuar;
				System.out.println("Gracias por usar nuestro servicio. Hasta luego");
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		}
		sc.close();
	}

	public void iniciarSesion(Scanner sc) {
		System.out.println("\nIntruduce su identificador: ");
		String identificador = sc.next();

		System.out.print("Ahora introduce su contraseña: ");
		String password = sc.next();

		// Comprobamos si tiene cuenta
		int indexCuenta = verificarCuenta(identificador, password);
		if (indexCuenta != -1) {
			mostrarMenu(sc, indexCuenta);
		} else {
			System.out.println("Error de identificación");
		}
	}

	public int verificarCuenta(String id, String contraseña) {
		int index = 0;
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getId().equals(id) && cuenta.getPassword().equals(contraseña)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public void mostrarMenu(Scanner sc, int indexUsuario) {
		boolean continuar = true;
		Cuenta cuenta = cuentas.get(indexUsuario);
		while (continuar) {
			System.out.println("\nBienvenido, " + cuenta + "\n- Menú Principal");
			System.out.println("1. Consultar saldo");
			System.out.println("2. Retirar dinero");
			System.out.println("3. Depositar dinero");
			System.out.println("4. Cerrar sesión");
			System.out.print("Seleccione una opción: ");

			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Tu saldo actual es de " + cuenta.getSaldo() + " €.");
				break;
			case 2:
				System.out.print("Ingrese el monto que quieres retirar: ");
				double montoRetiro = sc.nextDouble();
				retirarDinero(cuenta, montoRetiro);
				break;
			case 3:
				System.out.print("Ingrese el monto que quieres depositar: ");
				double montoDepositar = sc.nextDouble();
				depositarDinero(cuenta, montoDepositar);
				break;
			case 4:
				System.out.println("Cerrando sesión...");
				continuar = !continuar;
				break;
			default:
				System.out.println("Opción inválida. Inténtelo de nuevo");
				break;
			}
		}
	}

	// Método para retirar dinero
	public void retirarDinero(Cuenta cuenta, double montoAretirar) {
		if (cuenta.getSaldo() >= montoAretirar) {
			cuenta.setSaldo(cuenta.getSaldo() - montoAretirar);
			System.out.println("El retiro se realizó con exito");
		} else {
			System.out.println("No dispones de saldo suficiente");
		}
	}

	// Método para depositar dinero
	public void depositarDinero(Cuenta cuenta, double montoAdepositar) {
		if (montoAdepositar > 0) {
			cuenta.setSaldo(cuenta.getSaldo() + montoAdepositar);
			System.out.println("El deposito se realizó con exito");
		} else {
			System.out.println("El monto tiene que ser mayor a cero");
		}

	}

}
