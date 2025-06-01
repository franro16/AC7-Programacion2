// Paquete que contiene las clases modelo del sistema
package modelos;

public class Autor {
    // Atributos privados que representan las propiedades del autor
    private int id;             // Identificador único del autor
    private String nombre;      // Nombre del autor
    private String apellido;    // Apellido del autor

    // Constructor vacío, necesario para algunos frameworks o instancias sin inicializar
    public Autor() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Autor(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getter para obtener el ID del autor
    public int getId() {
        return id;
    }

    // Setter para establecer el ID del autor
    public void setId(int id) {
        this.id = id;
    }

    // Getter para obtener el nombre del autor
    public String getNombre() {
        return nombre;
    }

    // Setter para establecer el nombre del autor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener el apellido del autor
    public String getApellido() {
        return apellido;
    }

    // Setter para establecer el apellido del autor
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método sobrescrito para devolver una representación textual del objeto Autor
    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
