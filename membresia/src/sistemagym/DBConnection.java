package sistemagym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/sistemagym";
        private static final String USER = "root";
        private static final String PASSWORD = "";
        private static Connection conexion = null;

        public static Connection getConnection() throws SQLException {
            if(conexion == null || conexion.isClosed()) {
                try {
                    conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println("Conexion establecida");

                } catch (SQLException e ) {
                    System.err.println("Error al conectar con la base de datos");
                    throw e;
                }
            }
            return conexion;
        }

        public static void cerrarConexion() throws SQLException {
            if (conexion != null) {
                try {
                    conexion.close();
                    System.out.println("Conexion Cerrada");
                } catch (SQLException e) {
                    System.err.println("No se pudo cerrar la conexion");
                    throw e;
                }
            }
        }

    }
