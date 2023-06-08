import java.util.ArrayList;
import java.util.Scanner;

public class Mascota {

	
	String nombre;
	String especie;
	String color ;
	int edad;
	
	ArrayList<Mascota> mascotas; 

	public Mascota(String nombre, int edad, String color, String especie) {
	setNombre(nombre);
	setEspecie(especie);
	setColor(color);
	setEdad(edad);
	}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getEspecie() {return especie;}
	public void setEspecie(String especie) {this.especie = especie;}
	
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}

	public int getEdad() {return edad;}
	public void setEdad(int edad) {this.edad = edad;}
	
	public void dormir() {
		System.out.println(nombre + " Zzz...");
	}
	public void comer() {
		System.out.println(nombre + " Estoy comiendo.");
	}
	public void correr() {
		System.out.println(nombre + " Estoy corriendo.");
	}
	public void saltar() {
		System.out.println(nombre + " ¡Saltando!");
	}
	public void hacereSonido () {
		if (getEspecie().equalsIgnoreCase("perro")) {
			System.out.println("Guau Guau...");
		} else if(getEspecie().equalsIgnoreCase("gato")) {
			System.out.println("Miau...");
		}
	}

	public void iniciar() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------menu----------\n" + 
				"1. Registrar mascota. \n"
			  + "2. Buscar Mascota por nombre.\n"
			  + "3. Imprimir lista de Mascotas registrados.\n"
			  + "4. Salir. ");
		int opc = scanner.nextInt();
	
		
		switch (opc) {
		case 1:
			ingresarDatos();
			break;
		case 2: 
			buscarPerroPorNombre();
			break;
			
		case 3: 
			obtenerInformacion();
			break;
			
		case 4:
			System.out.println("Chao!");
			break;
		default:
			System.out.println("Opcion no valida");
			break;
		}
		
	
		
		
		

	}
	
	public void obtenerInformacion() {
		
		for (Mascota mascota : mascotas) {
			System.out.println("------------Lista de registrados----------------");
			System.out.println("Nombre: " + mascota.nombre);
			System.out.println("Especie: " + mascota.especie );
			System.out.println("Color: " + mascota.color);
			System.out.println("Edad: " + mascota.edad + " años");
			System.out.println("----------------------------");

		}
		iniciar();
	}
	
	public void buscarPerroPorNombre() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nIngrese el nombre del perro a buscar: ");

		String nombreBuscado = scanner.next();

		Mascota mascotaEncontrado = null;

		for (Mascota perro : mascotas) {
			if (perro.getNombre().equalsIgnoreCase(nombreBuscado)) {
				mascotaEncontrado = perro;
				break;
			}
		}

		if (mascotaEncontrado != null) {
			System.out.println("\nInformación de la mascota:");
			System.out.println("Nombre: " + mascotaEncontrado.getNombre());
			System.out.println("Especie: " + mascotaEncontrado.getEspecie());
			System.out.println("Color: " + mascotaEncontrado.getColor());
			System.out.println("Edad: " + mascotaEncontrado.getEdad());

			System.out.println("\nAcciones:");
			mascotaEncontrado.hacereSonido();
			mascotaEncontrado.dormir();
			mascotaEncontrado.comer();
			mascotaEncontrado.correr();
			mascotaEncontrado.saltar();
		} else {
			System.out.println("No se encontró ningúna mascota con el nombre ingresado.");
		}
		iniciar();
	}

	public void ingresarDatos() {
		mascotas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de mascotas a registrar: ");
		int cantmascotas = scanner.nextInt();

		for (int i = 1; i <= cantmascotas; i++) {
			System.out.println("Ingrese los datos de la mascota #" + i + ":");

			System.out.print("Nombre: ");
			String nombre = scanner.next();
			
			System.out.print("Especie: ");
			String especie = scanner.next();
			
			System.out.print("Color: ");
			String color = scanner.next();

			System.out.print("Edad: ");
			int edad = scanner.nextInt();

			Mascota mascota = new Mascota(nombre , edad ,color , especie);
			mascotas.add(mascota);
			
	

		}
		iniciar();
	}
}
