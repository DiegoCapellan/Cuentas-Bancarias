import java.util.Scanner;

public class CuentaBancaria {

	private String nombreTitular;
	private String codigoEntidad;
	private String codigoOficina;
	private String numeroCuenta;
	private String digitosControl;
	private double saldo;
	
	public CuentaBancaria() {
		nombreTitular = "";
		codigoEntidad = "";
		codigoOficina = "";
		numeroCuenta = "";
		digitosControl = "";
		saldo = 0;
	}

	public CuentaBancaria(String nombreTitular, String codigoEntidad, String codigoOficina, String numeroCuenta,
			String digitosControl, double saldo) {
		this.nombreTitular = nombreTitular;
		this.codigoEntidad = codigoEntidad;
		this.codigoOficina = codigoOficina;
		this.digitosControl = digitosControl;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}
	
	
	
	//Vamos a generar los digitos de control de nuestro numero de Cuenta Cliente a partir de:
	//los codigos de entidad, oficina y numeros de cuenta.
	
	public int calculoDigitosControl() {
	
		
		int digitoC1, digitoC2;
		int suma1, suma2;
		int valorResto1, valorResto2;
		int numeroC1, numeroC2, numeroC3, numeroC4, numeroC5, numeroC6, numeroC7, numeroC8, numeroC9, numeroC10;
		
		
		//Primer digito de control
		 suma1 =  Integer.valueOf(getCodigoEntidad().substring(0, 1)) *4;
		 suma1 += Integer.valueOf(getCodigoEntidad().substring(1, 2)) *8;
		 suma1 += Integer.valueOf(getCodigoEntidad().substring(2, 3)) *5;
		 suma1 += Integer.valueOf(getCodigoEntidad().substring(3, 4)) *10;
		 
		 suma1 += Integer.valueOf(getCodigoOficina().substring(0, 1)) *9;
		 suma1 += Integer.valueOf(getCodigoOficina().substring(1, 2)) *7;
		 suma1 += Integer.valueOf(getCodigoOficina().substring(2, 3)) *3;
		 suma1 += Integer.valueOf(getCodigoOficina().substring(3, 4)) *6;
		  
		 valorResto1 = (suma1%11);
		 
		 digitoC1 = (11-valorResto1);
		 
		 if (digitoC1==10) {
			 digitoC1=1;
		 }else if (digitoC1==11) {
			 digitoC1=0;
		 }
		 
		 //Segundo digito de control
		 suma2 = Integer.valueOf(getNumeroCuenta().substring(0,1)) *1;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(1,2)) *2;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(2,3)) *4;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(3,4)) *8;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(4,5)) *5;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(5,6)) *10;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(6,7)) *9;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(7,8)) *7;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(8,9)) *3;
		 suma2 += Integer.valueOf(getNumeroCuenta().substring(9,10)) *6;
		
		valorResto2 = (suma2%11);
		
		digitoC2 = (11-valorResto2);
		
		if (digitoC2==10) {
			digitoC2=1;
		}else if (digitoC2==11) {
			digitoC2=0;
		}
		
		String aux = Integer.toString(digitoC1) + Integer.toString(digitoC2);
		
		
		return Integer.parseInt(aux);
	}

	
	public boolean validarCodigoCC() {
		//True: el Codigo de Cuenta Cliente es válido, False: no es válido
		String codigoCC = this.codigoEntidad + this.codigoOficina + this.digitosControl + this.numeroCuenta;
		boolean valido = false;
		
		if ((codigoCC.length()==20) && (Integer.valueOf(digitosControl)==calculoDigitosControl())) {
			
			System.out.println("El Codigo de Cuenta Cliente Introducido es Válido.");
			valido = true;
			
		}else {
			System.out.println("El Codigo de Cuenta Cliente Introducido no es Válido. ");
			valido = false;
		}
		return valido;
	}
	
	
	
	public void realizarIngreso() {
		Scanner leer = new Scanner(System.in);
		int saldo = 0;
        
		System.out.println("Ingrese la Cantidad a Añadir:");
		saldo = leer.nextInt();
		
		for (int i = 0; i < 1; i++) {
			if (saldo < 0) {
				System.out.println("Imposible Ingresar esa Cantidad de Saldo.");
			}else {
				setSaldo(getSaldo() + saldo);
				
				System.out.println("Saldo Ingresado.");
				System.out.println("Saldo Final: " + getSaldo() + " euros.");
				break;
			}
		}
    }
	
	
	public void retirarEfectivo() {
        Scanner leer = new Scanner(System.in);
        int efectivo = 0;
        
        System.out.println("Ingrese la Cantidad de Efectivo a Retirar:");
        efectivo = leer.nextInt();
        
        for (int i = 0; i < 1; i++) {
        	if (efectivo > getSaldo()) {
        		System.out.println("Saldo Insuficiente para Retirar.");
        		
        	}else if (efectivo < 0) {
        		System.out.println("Imposible Retirar esa Cantidad de Efectivo");
        		
        		}else {
        		setSaldo(getSaldo() - efectivo);
        		
        		System.out.println("Efectivo Retirado.");
        		System.out.println("Saldo Restante: " + getSaldo() + " euros.");
        		break;
        	}
        }
    }
	
	
	//Setter's y Getter's
	
	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getCodigoEntidad() {
		return codigoEntidad;
	}

	public void setCodigoEntidad(String codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}

	public String getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getDigitosControl() {
		return digitosControl;
	}

	public void setDigitosControl(String digitosControl) {
		this.digitosControl = digitosControl;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	
}
