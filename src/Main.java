import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

	public class Main {
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				String ruta = "películas.txt";
				File archivo = new File(ruta);
				if (!archivo.exists()) {
					try {
						archivo.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
				String linea = "";
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(ruta));
					try {
						linea = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					while (linea != null) {       
						String [] datos = linea.split("\\|\\|");
						System.out.println(datos[1]);
						Pelicula pelicula = new Pelicula(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]));
						peliculas.add(pelicula);
						try {
							linea = br.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Scanner sn = new Scanner(System.in);
				int opcion = 0;
				do {
					System.out.println("Introduzca el número de una opción: \n 1. Alta de película. "
							+ "\n 2. Baja de película. \n 3. Consulta de todas las peliculas "
							+ "\n 4. Consulta de dato de una película por el código de la película. "
							+ "\n 5.Salir.");
					opcion = sn.nextInt();
					switch (opcion) {
					case 1:
						peliculas.add(altaDePelicula());
						break;
					case 2:
						bajaDePelicula(peliculas);
						break;
					case 3:
						mostrarPeliculas(peliculas);
						break;
					case 4:
						mostrarDatosPelicula(peliculas);
						break;
					case 5:
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
							for (Pelicula p : peliculas) {
								BufferedReader br = new BufferedReader(new FileReader(ruta));
								if (br.readLine() != null) {
									bw.newLine();
									bw.write(p.getCod_peli() + " || " + p.getTitulo() + " || " + p.getAnno_estreno() + " || " + p.getNombre_actor() + " || " + String.valueOf(p.getCoste_prod()));
								}else {
									bw.write(p.getCod_peli() + " || " + p.getTitulo() + " || " + p.getAnno_estreno() + " || " + p.getNombre_actor() + " || " + String.valueOf(p.getCoste_prod()));
								}
							}
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Saliendo del programa...");
						break;

					default:
						System.out.println("Opción no válida.");
						break;
					}
				} while (opcion !=5);
			}
			public static Pelicula altaDePelicula () {
				Scanner sc = new Scanner(System.in);
				Scanner sn = new Scanner(System.in);
				Pelicula pelicula = new Pelicula();
				System.out.println("Introduzca el código de la película");
				pelicula.setCod_peli(sc.nextLine());
				System.out.println("Introduzca el título de la película");
				pelicula.setTitulo(sc.nextLine());
				System.out.println("Introduzca el año de estreno de la película");
				pelicula.setAnno_estreno(sc.nextLine());
				System.out.println("Introduzca el nombre del actor protagonista de la película");
				pelicula.setNombre_actor(sc.nextLine());
				System.out.println("Introduzca el coste de producción de la película");
				pelicula.setCoste_prod(sn.nextInt());
				return pelicula;
			}
			public static void bajaDePelicula (ArrayList<Pelicula> peliculas) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduzca el código de la película");
				String codigo = sc.nextLine();
				for (Pelicula p : peliculas) {
					if (p.getCod_peli().equalsIgnoreCase(codigo)) {
						peliculas.remove(p);
						break;
					}
				}
				
			}
			public static void mostrarPeliculas (ArrayList<Pelicula> peliculas) {
				for (Pelicula p : peliculas) {
					System.out.println(p.getCod_peli() + " - " + p.getTitulo());
				}
			}
			public static void mostrarDatosPelicula (ArrayList<Pelicula> peliculas) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduzca el código de la película");
				String codigo = sc.nextLine();
				for (Pelicula p : peliculas) {
					if (p.getCod_peli().equalsIgnoreCase(codigo)) {
						System.out.println(p.getCod_peli() + " || " + p.getTitulo() + " || " + p.getAnno_estreno() + " || " + p.getNombre_actor() + " || " + "c" + String.valueOf(p.getCoste_prod()));
						break;
					}
				}
			}
		}


