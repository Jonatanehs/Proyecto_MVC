package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.LinkedHashMap;

public class GestionContenido {
    static LinkedHashMap<String,Administrador> contenido = new LinkedHashMap<>();
    Gson json = new GsonBuilder().setPrettyPrinting().create();
    Administrador adm = new Administrador();
    Conexion cnn = new Conexion();
    Connection conexion = cnn.Conecta();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet res = null;

    public GestionContenido(){
        Administrador adm = new Administrador();
        contenido = new LinkedHashMap<>();
        deserializar();
    }

    public void serializar() {
        try (FileWriter writer = new FileWriter("contenido.json")) {
            json.toJson(contenido, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deserializar() {
        try (FileReader reader = new FileReader("contenido.json")) {
            Type type = new TypeToken<LinkedHashMap<String, Administrador>>() {}.getType();
            contenido = json.fromJson(reader, type);
            if (contenido == null){
                contenido = new LinkedHashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean comproba(String val) {
        try {
            String sql = "SELECT * FROM contenido WHERE Titulo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, val);
            res = ps.executeQuery();

            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return false;
    }

        public boolean agregar(Administrador cont) {
        boolean resultado = comproba(cont.getTitulo());
        //System.out.println("Título dentro de agregar(): " + cont.getTitulo());
        try {
            if (!resultado) {
                String sql = "insert into contenido (Titulo, Descripcion, Autor, Url, " +
                        "Fecha_publicacion, Tipo_contenido, Contenido_detalle, Categoria)" +
                        " values(?, ?, ?, ?, ?, ?, ?, ?)";
                ps = conexion.prepareStatement(sql);
                ps.setString(1, cont.getTitulo());
                ps.setString(2, cont.getDescripcion());
                ps.setString(3, cont.getAutor());
                ps.setString(4, cont.getUrl());
                ps.setString(5, cont.getFecha());
                ps.setString(6, cont.getTipoCont());
                ps.setString(7, cont.getDetalle());
                ps.setString(8, cont.getCategoria());
                resultado = ps.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        }
        return resultado;
    }

    public boolean actualizar(String actu, int dato, Object nuevo) {
        boolean datoActualizado = false;
        boolean resultado = comproba(actu);
        String sql = "";

        if (resultado) {
            switch (dato) {
                case 1:
                    sql = "update contenido set Titulo = ? where Titulo = ?";
                    break;
                case 2:
                    sql = "update contenido set Descripcion = ? where Titulo = ?";
                    break;
                case 3:
                    sql = "update contenido set Autor = ? where Titulo = ?";
                    break;
                case 4:
                    sql = "update contenido set Url = ? where Titulo = ?";
                    break;
                case 5:
                    sql = "update contenido set Fecha_publicacion = ? where Titulo = ?";
                    break;
                case 6:
                    sql = "update contenido set Tipo_contenido = ? where Titulo = ?";
                    break;
                case 7:
                    sql = "update contenido set Contenido_detalle = ? where Titulo = ?";
                    break;
                case 8:
                    sql = "update contenido set Categoria = ? where Titulo = ?";
                    break;
                default:
                    return false;
            }

            if (!sql.isEmpty()) {
                try {
                    ps = conexion.prepareStatement(sql);
                    ps.setObject(1, nuevo);
                    ps.setString(2, actu);

//                    System.out.println("Ejecutando consulta: " + sql);
//                    System.out.println("Nuevo valor: " + nuevo);
//                    System.out.println("Valor a buscar (Título): " + actu);

                    int filasActualizadas = ps.executeUpdate();
                    datoActualizado = (filasActualizadas > 0);

//                    if (!datoActualizado) {
//                        System.out.println("No se actualizó ningún dato. Verifique si el valor de búsqueda es correcto.");
//                    }

                } catch (SQLException ex) {
                    System.out.println("Error al actualizar los datos: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } else {
            System.out.println();
        }
        return datoActualizado;
    }



    public  boolean eliminarProducto(String producto) {
        try {
            String sql = "delete from contenido where Titulo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, producto);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return false;
    }

    public String mostrar(String pr){
        String nota = "";
        try {
            String sql = "select * from contenido where Titulo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, pr);
            res = ps.executeQuery();
            if (res.next()) {
                String titulo = res.getString("Titulo");
                String descripcion = res.getString("Descripcion");
                String autor = res.getString("Autor");
                String url = res.getString("Url");
                String fecha = res.getString("Fecha_publicacion");
                String detalle = res.getString("Contenido_detalle");
                String cat = res.getString("Categoria");

                nota = "Titulo: " + titulo + "\n" +
                        "Descripción: " + descripcion + "\n" +
                        "Autor: " + autor+ "\n" +
                        "URL: " + url + "\n" +
                        "Fecha publicación: " + fecha + "\n" +
                        "Contenido: " + detalle + "\n" +
                        "Categoría: " + cat;
            } else {
                nota = "No hay publicaciones.";
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return  nota;
    }

    public String mostra(){
        String nota = "";
        try {
            String sql = "select * from contenido";
            ps = conexion.prepareStatement(sql);
            res = ps.executeQuery();
            if (res.next()) {
                String titulo = res.getString("Titulo");
                String descripcion = res.getString("Descripcion");
                String autor = res.getString("Autor");
                String url = res.getString("Url");
                String fecha = res.getString("Fecha_publicacion");
                String detalle = res.getString("Contenido_detalle");
                String cat = res.getString("Categoria");

                nota = "Titulo: " + titulo + "\n" +
                        "Descripción: " + descripcion + "\n" +
                        "Autor: " + autor+ "\n" +
                        "URL: " + url + "\n" +
                        "Fecha publicación: " + fecha + "\n" +
                        "Contenido: " + detalle + "\n" +
                        "Categoría: " + cat;
            } else {
                nota = "No hay publicaciones.";
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return nota;
    }

}
