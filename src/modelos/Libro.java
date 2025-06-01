// Paquete que contiene las clases modelo del sistema
package modelos;

public class Libro {
    // Atributos privados que representan las propiedades del libro
    private int id;         // Identificador único del libro
    private String titulo;  // Título del libro
    private int anio;       // Año de publicación
    private int autorId;    // ID del autor del libro (clave foránea)

    // Constructor vacío (útil para frameworks, serialización o instanciación sin valores iniciales)
    public Libro() {
    }

    // Constructor con parámetros para inicializar todos los atributos del libro
    public Libro(int id, String titulo, int anio, int autorId) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.autorId = autorId;
    }

    // Getter para obtener el ID del libro
    public int getId() {
        return id;
    }

    // Setter para establecer el ID del libro
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el título del libro
    public String getTitulo() {
        return titulo;
    }

    // Setter para establecer el título del libro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter para obtener el año de publicación del libro
    public int getAnio() {
        return anio;
    }

    // Setter para establecer el año de publicación del libro
    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Getter para obtener el ID del autor asociado al libro
    public int getAutorId() {
        return autorId;
    }

    // Setter para establecer el ID del autor asociado al libro
    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    // Método sobrescrito para devolver una representación en texto del objeto Libro
    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", autorId=" + autorId +
                '}';
    }
}
