// Paquete que agrupa las clases modelo del sistema
package modelos;

public class Lector {
    // Atributos públicos que representan las propiedades del lector
    public int id;          // Identificador único del lector
    public String nombre;   // Nombre del lector
    public int libroId;     // ID del libro que está leyendo

    // Constructor vacío requerido por algunas herramientas y frameworks
    public Lector() {
    }

    // Constructor principal para inicializar un lector con sus datos
    // ⚠️ Nota: el orden de los parámetros puede ser confuso (primero libroId, luego nombre, luego id)
    public Lector(int libroId, String nombre, int id) {
        this.libroId = libroId;
        this.nombre = nombre;
        this.id = id;
    }

    // Getter para obtener el ID del lector
    public int getId() {
        return id;
    }

    // Setter para establecer el ID del lector
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el nombre del lector
    public String getNombre() {
        return nombre;
    }

    // Setter para establecer el nombre del lector
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener el ID del libro que está leyendo el lector
    public int getLibroId() {
        return libroId;
    }

    // Setter para establecer el ID del libro que está leyendo el lector
    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    // Método sobrescrito para representar el lector como un string legible
    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", libroId=" + libroId +
                '}';
    }
}
