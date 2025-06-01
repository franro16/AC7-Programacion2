// Importaciones de paquetes personalizados y librerías estándar
import biblioteca.conexionBD;           // Clase que maneja la conexión a la base de datos y creación de tablas
import modelos.Autor;                  // Clase modelo que representa un autor
import modelos.Lector;                 // Clase modelo que representa un lector
import modelos.Libro;                  // Clase modelo que representa un libro
import java.sql.*;                     // Librería para trabajar con bases de datos SQL en Java
import java.util.List;                 // Utilidad para usar listas inmutables

public class Main {
    public static void main(String[] args) {
        // Intentamos establecer conexión a la base de datos (usa try-with-resources para cerrarse automáticamente)
        try (Connection conn = conexionBD.conectar()) {
            System.out.println("Conectado a la base de datos.");

            // Crear las tablas necesarias si no existen (Autor, Libro, Lector)
            conexionBD.crearTablas(conn);

            // Limpiar las tablas: se eliminan todos los datos de Lector, Libro y Autor (en ese orden por claves foráneas)
            Statement limpiar = conn.createStatement();
            limpiar.executeUpdate("DELETE FROM Lector");
            limpiar.executeUpdate("DELETE FROM Libro");
            limpiar.executeUpdate("DELETE FROM Autor");
            limpiar.close();

            // Crear una lista de autores para insertar
            List<Autor> autores = List.of(
                    new Autor(1, "Franco", "Romero"),
                    new Autor(2, "Leandro", "Delgado"),
                    new Autor(3, "Agustin", "Heredia")
            );

            // Insertar cada autor en la base de datos
            for (Autor a : autores) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Autor (id, nombre) VALUES (?, ?)");
                ps.setInt(1, a.getId());
                ps.setString(2, a.getNombre() + " " + a.getApellido()); // Se concatena nombre y apellido en un solo campo
                ps.executeUpdate();
                ps.close();
            }

            // Crear una lista de libros para insertar
            List<Libro> libros = List.of(
                    new Libro(1, "Mein Kapft", 2015, 1),
                    new Libro(2, "Programacion 1", 2025, 2),
                    new Libro(3, "Base de Datos 2", 2021, 3)
            );

            // Insertar cada libro en la base de datos
            for (Libro l : libros) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Libro (id, titulo, anio, autor_id) VALUES (?, ?, ?, ?)");
                ps.setInt(1, l.getId());
                ps.setString(2, l.getTitulo());
                ps.setInt(3, l.getAnio());
                ps.setInt(4, l.getAutorId());
                ps.executeUpdate();
                ps.close();
            }

            // Crear una lista de lectores para insertar
            List<Lector> lectores = List.of(
                    new Lector(1, "Soledad", 1),
                    new Lector(2, "Francisco", 2),
                    new Lector(3, "Sofia", 3)
            );

            // Insertar cada lector en la base de datos
            for (Lector le : lectores) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Lector (id, nombre, libro_id) VALUES (?, ?, ?)");
                ps.setInt(1, le.id);
                ps.setString(2, le.nombre);
                ps.setInt(3, le.libroId);
                ps.executeUpdate();
                ps.close();
            }

            // Realizar una consulta para obtener lectores, los libros que están leyendo y el autor del libro
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("""
                SELECT Lector.nombre AS lector, Libro.titulo AS libro, Autor.nombre AS autor
                FROM Lector
                JOIN Libro ON Lector.libro_id = Libro.id
                JOIN Autor ON Libro.autor_id = Autor.id
            """);

            // Mostrar los resultados de la consulta
            System.out.println("LECTORES Y SUS LIBROS:");
            while (rs.next()) {
                System.out.printf("%s está leyendo \"%s\" de %s\n",
                        rs.getString("lector"),
                        rs.getString("libro"),
                        rs.getString("autor")
                );
            }

            // Cerrar recursos
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            // Capturar e imprimir cualquier error de base de datos
            e.printStackTrace();
        }
    }
}
