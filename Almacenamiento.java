import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Almacenamiento {
    public static void setItem(String nombre, Object objeto) {
        try (FileOutputStream arcSalida = new FileOutputStream(nombre);
             ObjectOutputStream objSalida = new ObjectOutputStream(arcSalida)) {
            objSalida.writeObject(objeto);
            System.out.println("Objeto guardado correctamente en \n" + "" + nombre);
        } catch (Exception e) {
            System.err.println("Error al guardar el objeto: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Object getItem(String nombreArchivo) {
        Object objetoDes = null;
        try (FileInputStream arcEntrada = new FileInputStream(nombreArchivo);
             ObjectInputStream objEntrada = new ObjectInputStream(arcEntrada)) {
            objetoDes = objEntrada.readObject();
            System.out.println("Objeto recuperado correctamente de: \n" + " " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al recuperar el objeto: " + e.getMessage());
            e.printStackTrace();
        }
        return objetoDes;
    }
}