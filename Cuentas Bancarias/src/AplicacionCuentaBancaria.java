
import java.util.Scanner;

public class AplicacionCuentaBancaria {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);

		CuentaBancaria cB;
		String nombreTitular = "";
		String codigoCC = "";
		double saldo = 0;
		int opc = 0;

		System.out.println("Ingrese el Nombre del Titular de la Cuenta");
		nombreTitular = leer.nextLine();

		do {
			System.out.println("Ingrese los Veinte Dígitos del Código de Cuenta Cliente: ");
			codigoCC = leer.nextLine();
			cB = new CuentaBancaria(nombreTitular, codigoCC.substring(0, 4), codigoCC.substring(4, 8),
					codigoCC.substring(10, 20), codigoCC.substring(8, 10), saldo);

		} while (cB.validarCodigoCC() == false);

		do {
			opc = Menu.pintaMenu();
			
			switch (opc) {
			case 1:
				System.out.println(cB.getNombreTitular());
				break;
			case 2:
				System.out.println(cB.getCodigoEntidad() + cB.getCodigoOficina() + cB.calculoDigitosControl()
						+ cB.getNumeroCuenta());
				break;
			case 3:
				System.out.println(cB.getCodigoEntidad());
				break;
			case 4:
				System.out.println(cB.getCodigoOficina());
				break;
			case 5:
				System.out.println(cB.calculoDigitosControl());
				break;
			case 6:
				System.out.println(cB.getNumeroCuenta());
				break;
			case 7:
				cB.realizarIngreso();
				break;
			case 8:
				cB.retirarEfectivo();
				break;
			case 9:
				System.out.println(cB.getSaldo());
				break;
			case 10:
				System.out.println("Cuenta Bancaria Cerrada");
				break;
			}
		} while (opc!=10);

	}
}
