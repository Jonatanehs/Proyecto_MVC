package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String db = "usuarios_db";
    private String url = "jdbc:mysql://localhost:3306/" + db;
    private String user = "root";
    private String pass = "1234";

    Connection conec = null;

    public Connection Conecta(){
        try {
            conec = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión ok");
        }catch (Exception e){
            System.out.println("Error en la conexión: " + e);
        }
        return conec;
    }
}

