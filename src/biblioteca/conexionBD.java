// Paquete que contiene clases relacionadas con la base de datos
package biblioteca;

import java.sql.Connection;       // Clase para manejar conexiones a la base de datos
import java.sql.DriverManager;    // Clase que gestiona los drivers JDBC
import java.sql.SQLException;     // Excepciones relacionadas con SQL
import java.sql.Statement;        // Clase para ejecutar sentencias SQL

public class conexionBD {
    // Constantes con los datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca"; // URL de la base de datos MySQL
    private static final String USUARIO = "root";                                 // Usuario de MySQL
    private static final String CONTRASEÑA = "agus45353087";                     // Contraseña de MySQL

    /**
     * Método para conectar a la base de datos
     * @return una conexión activa a la base de datos
     * @throws SQLException si falla la conexión
     */
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }

    /**
     * Método que crea las tablas necesarias si no existen.
     * @param conn una conexión abierta a la base de datos
     * @throws SQLException si ocurre un error al ejecutar SQL
     */
    public static void crearTablas(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();  // Se usa para ejecutar sentencias SQL

        // SQL para crear la tabla Autor
        String crearAutor = """
            CREATE TABLE IF NOT EXISTS Autor (
                id INT PRIMARY KEY,                -- ID único del autor
                nombre VARCHAR(100)                -- Nombre completo del autor
            );
        """;

        // SQL para crear la tabla Libro, relacionada con Autor
        String crearLibro = """
            CREATE TABLE IF NOT EXISTS Libro (
                id INT PRIMARY KEY,                -- ID único del libro
                titulo VARCHAR(100),               -- Título del libro
                anio INT,                          -- Año de publicación
                autor_id INT,                      -- Clave foránea al autor
                FOREIGN KEY (autor_id) REFERENCES Autor(id) -- Relación con la tabla Autor
            );
        """;

        // SQL para crear la tabla Lector, relacionada con Libro
        String crearLector = """
            CREATE TABLE IF NOT EXISTS Lector (
                id INT PRIMARY KEY,                -- ID único del lector
                nombre VARCHAR(100),               -- Nombre del lector
                libro_id INT,                      -- Clave foránea al libro que está leyendo
                FOREIGN KEY (libro_id) REFERENCES Libro(id) -- Relación con la tabla Libro
            );
        """;

        // Ejecutar las sentencias para crear las tablas
        stmt.execute(crearAutor);
        stmt.execute(crearLibro);
        stmt.execute(crearLector);

        stmt.close(); // Cerrar el Statement para liberar recursos
    }
}
