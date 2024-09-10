import java.util.Scanner;

public class Applicacion {
    public static void main(String[] args) throws Exception {

        Nota unaNota = new Nota("Materia", "Contenido");
        Libreta unaLibreta = new Libreta(unaNota);
        Scanner leer = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----------------------------------------------");
            System.out.println("");
            System.out.println(" LIBRETA:");
            System.out.println("");
            System.out.println("    Ingrese la opción que desea realizar:");
            System.out.println("    1. Ingresar Nota.");
            System.out.println("    2. Leer Notas.");
            System.out.println("    3. Eliminar Nota.");
            System.out.println("    0. Salir.");
            System.out.println("");
            System.out.println("----------------------------------------------");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("----------------------------------------------");
                    System.out.println("Ingrese el título de la Nota: ");
                    String tit = scanner.nextLine();
                    Nota nuevaNota = new Nota(tit, "");
                    System.out.println("");
                    System.out.println("Ingrese el contenido de la nota: ");
                    String cont = scanner.nextLine();
                    nuevaNota.setContenido(cont);
                    unaLibreta.agregarNota(nuevaNota);
                    System.out.println("");
                    System.out.println("----------------------------------------------");
                    Almacenamiento.setItem("LibretaAlmacenada2.txt", unaLibreta);
                    break;

                case 2:

                    System.out.println("----------------------------------------------");
                    System.out.println("");
                    Libreta libretaAlmacenada = (Libreta) Almacenamiento.getItem("LibretaAlmacenada2.txt");
                    if (libretaAlmacenada != null) {
                        System.out.println("");
                        System.out.println("Las notas son: ");
                        for (int i = 0; i < libretaAlmacenada.obtenerNotas().size(); i++) {
                            System.out.println((i + 1) + ". " + libretaAlmacenada.obtenerNotas().get(i));
                        }
                    } else {
                        System.out.println("No hay notas almacenadas.");
                    }
                    System.out.println("");
                    break;

                case 3:

                    System.out.println("----------------------------------------------");
                    System.out.println("");
                    libretaAlmacenada = (Libreta) Almacenamiento.getItem("LibretaAlmacenada2.txt");

                    if (libretaAlmacenada.obtenerNotas() != null) {
                        System.out.println("");
                        System.out.println("Las notas son: ");
                        System.out.println("");

                        for (int i = 0; i < libretaAlmacenada.obtenerNotas().size(); i++) {
                            System.out.println((i + 1) + ". " + libretaAlmacenada.obtenerNotas().get(i));
                        }

                        System.out.println("");
                        System.out.println("¿Qué nota quieres borrar? (Ingrese el número de la nota)");
                        System.out.println("");
                        int indice = leer.nextInt() - 1;
                        libretaAlmacenada.eliminarNota(indice);
                        Almacenamiento.setItem("LibretaAlmacenada2.txt", libretaAlmacenada);
                        System.out.println("");

                    } else {
                        System.out.println("No hay notas almacenadas.");
                    }
                    System.out.println("");
                    break;

                case 0:

                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
        leer.close();
        scanner.close();
    }
}