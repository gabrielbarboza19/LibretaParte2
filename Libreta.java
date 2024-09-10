import java.io.Serializable;
import java.util.ArrayList;

public class Libreta implements Serializable {
    private ArrayList<Nota> notas;

    public Libreta(Nota unaNota) {
        this.notas = new ArrayList<>();
        this.notas.add(unaNota);
    }

    public void agregarNota(Nota noti) {
        this.notas.add(noti);
    }

    public ArrayList<Nota> obtenerNotas() {
        return notas;
    }

    public void eliminarNota(int indice) {
        if (indice >= 0 && indice < notas.size()) {
            notas.remove(indice);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }
}