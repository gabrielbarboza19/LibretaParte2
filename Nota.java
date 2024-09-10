import java.io.Serializable;

public class Nota implements Serializable {
    private String titulo;
    private String contenido;

    public Nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public void setTitulo(String titu) {
        this.titulo = titu;
    }

    public void setContenido(String conte) {
        this.contenido = conte;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "- Titulo: (" + titulo + ") | Contenido: (" + contenido + ").";
    }
}