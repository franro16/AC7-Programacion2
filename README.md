Decidimos codificar el funcionamiento de una aplicación en Java que simula un sistema básico de gestión de una biblioteca, usamos el lenguaje Java con una base de datos MySQL para el almacenamiento de datos.
El sistema está compuesto por tres entidades principales:Autor,libro y lector.
Cada autor puede tener varios libros asociados, y cada lector puede estar vinculado a un único libro. 

El código realiza las siguientes funciones:
-Conexión con la base de datos mediante JDBC, utilizando un archivo dedicado para manejar la conexión (conexionBD.java).
-Creación automática de las tablas necesarias en la base de datos (si no existen).
-Carga inicial de datos: Se cargan varios autores, libros y lectores directamente desde el código Java.
-Relaciones entre datos: Se relacionan los libros con sus autores y los lectores con los libros que están leyendo.
-Consulta y visualización: Se realiza una consulta automática que muestra una lista de lectores junto con el título del libro que están leyendo y el nombre del autor del libro.
