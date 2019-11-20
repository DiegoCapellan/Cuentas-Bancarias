import java.util.Scanner;

public class Menu {

	public static int pintaMenu() {
		Scanner leer = new Scanner(System.in);
		
		int opc = 0;
		
		do {
			System.out.println("***********Menú Cuenta Bancaria***********");
			System.out.println("1. Ver el Titular de la Cuenta");
			System.out.println("2. Ver el Número de Cuenta Completo");
			System.out.println("3. Ver el Código de la Entidad");
			System.out.println("4. Ver el Código de la Oficina");
			System.out.println("5. Ver los Dígitos de Control de la Cuenta");
			System.out.println("6. Ver el Número de Cuenta");
			System.out.println("7. Realizar un Ingreso");
			System.out.println("8. Retirar Efectivo");
			System.out.println("9. Consultar Saldo");
			System.out.println("10. Salir de la Aplicación");
			System.out.println("*******************************************");
			opc = leer.nextInt();
		
		} while (opc<1 || opc>10);
		return opc;
	}
}
