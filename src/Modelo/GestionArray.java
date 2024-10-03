package Modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Scanner;

import Vista.InterfazUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.plaf.nimbus.State;

public class GestionArray {
    Usuario usuario = new Usuario();
    InterfazUsuario vistaUsuario = new InterfazUsuario();
    static LinkedHashMap<String, Usuario> listaUsuarios = new LinkedHashMap<>();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Conexion cnn = new Conexion();
    Connection conexion = cnn.Conecta();
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet res = null;

    public GestionArray() {
        listaUsuarios = new LinkedHashMap<>();
        deserializar();
        /*listaUsuarios.add(new Usuario("Camilo Perez", "camilop88", "camiloperez1988@gmail.com", "camilo123"));
        listaUsuarios.add(new Usuario("Sandra Martinez", "sandramar99", "sandramartinez@hotmail.com", "sandra1999"));*/
    }

    public LinkedHashMap<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedHashMap<String, Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String convertirAJson() {
        return gson.toJson(listaUsuarios);
    }

    public static void serializar() {
        try (FileWriter nuevoJson = new FileWriter("usuarios.json")) {
            gson.toJson(listaUsuarios, nuevoJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deserializar() {
        try (FileReader reader = new FileReader("usuarios.json")) {
            Type tipoHashMap = new TypeToken<LinkedHashMap<String, Usuario>>() {
            }.getType();
            listaUsuarios = gson.fromJson(reader, tipoHashMap);
            if (listaUsuarios == null) {
                listaUsuarios = new LinkedHashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarNombreUsuario(String nombreUser) {
        try {
            String sql = "select * from usuario where Nombre_Usuario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreUser);
            res = ps.executeQuery();
            if (res.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println();
        }
        return false;
    }

    public boolean verificarCorreo(String correo) {
        try {
            String sql = "select * from usuario where Correo = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            res = ps.executeQuery();
            if (res.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return false;
    }

    public boolean verificacionContrasenia(String clave) {
        try {
            String sql = "select * from usuario where Contrasenia = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, clave);
            res = ps.executeQuery();
            if (res.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return false;
    }

    public boolean registrarUsuario(Usuario usuario) {
        boolean resultado = verificarCorreo(usuario.getCorreo());
        try {
            if (!resultado) {
                String sql = "insert into usuario (Nombre, Nombre_Usuario, Correo, Contrasenia) " +
                        "values(?, ?, ?, ?)";
                ps = conexion.prepareStatement(sql);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getNombreUsuario());
                ps.setString(3, usuario.getCorreo());
                ps.setString(4, usuario.getContrasenia());
                resultado = ps.executeUpdate() > 0;
            } else {
                vistaUsuario.imprimir("Usuario ya registrado");
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        }
        return resultado;
    }

    public boolean verificarCuenta(String usuario, String clave) {
        int ingreso = 0;

        for (char c : usuario.toCharArray()) {
            if (c == '@') {
                ingreso += 1;
            }
        }
        if (ingreso > 0) {
            boolean verificacion = false;
            boolean contra = verificacionContrasenia(clave);
            if (verificacion == false && contra == true) {
                return true;
            } else {
                return false;
            }
        } else {
            boolean verificacion = false;
            boolean contra = verificacionContrasenia(clave);
            if (verificacion == false && contra == true) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String verificarTipoUser(String nameUsuario) {
        try {
            String sql = "select Tipo_Usuario from usuario where Nombre_Usuario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nameUsuario);
            res = ps.executeQuery();

            if (res.next()) {
                return res.getString("Tipo_Usuario");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return null;
    }

    public boolean verificarCorreoValido(String correo){
        if (correo.contains("@") && correo.contains(".com") || correo.contains(".co") ||
                correo.contains(".es")) {
            return true;
        }
        return false;
    }
    public boolean verificarContrasenia(String clave) {
        boolean correcto = false;
        int mayus = 0;
        int minus = 0;
        int num = 0;
        int charEspecial = 0;

        if (clave.length() >= 8) {
            for (int i = 0; i < clave.length(); i++) {
                char caracter = clave.charAt(i);

                if (Character.isUpperCase(caracter)) {
                    mayus++;
                } else if (Character.isLowerCase(caracter)) {
                    minus++;
                } else if (Character.isDigit(caracter)) {
                    num++;
                } else if (!Character.isLetterOrDigit(caracter)) {
                    charEspecial++;
                }
            }
            if (mayus >= 1 && minus >= 1 && num >= 1 && charEspecial >= 1) {
                correcto = true;
            } else {
                correcto = false;
            }
        }
        return correcto;
    }
    public String imprimirPerfil(String nameUser) {
        String perfil = "";
        try {
            String sql = "SELECT Nombre, Nombre_Usuario, Correo FROM usuario WHERE Nombre_Usuario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nameUser);
            res = ps.executeQuery();
            if (res.next()) {
                String nombre = res.getString("Nombre");
                String nombreUsuario = res.getString("Nombre_Usuario");
                String correo = res.getString("Correo");

                perfil = "Nombre: " + nombre + "\n" +
                        "Nombre de Usuario: " + nombreUsuario + "\n" +
                        "Correo: " + correo;
            } else {
                perfil = "Usuario no encontrado.";
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return perfil;
    }

    public boolean actualizarDatos(String nomUsuario, String dato, Object nuevoValor) {
        boolean datoActualizado = false;
        String sql = "";
        switch (dato.toLowerCase()) {
            case "nombre":
                sql = "UPDATE usuario SET Nombre = ? WHERE Nombre_Usuario = ?";
                break;
            case "usuario":
                sql = "UPDATE usuario SET Nombre_Usuario = ? WHERE Nombre_Usuario = ?";
                break;
            case "correo":
                sql = "UPDATE usuario SET Correo = ? WHERE Nombre_Usuario = ?";
                break;
            case "contraseña":
                sql = "UPDATE usuario SET Contrasenia = ? WHERE Nombre_Usuario = ?";
                break;
            default:
                vistaUsuario.imprimir("Campo no válido para actualizar.");
                return false;
        }
        try {
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, nuevoValor);
            ps.setString(2, nomUsuario);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                datoActualizado = true;
                vistaUsuario.imprimir("Datos actualizados correctamente.");
            } else {
                vistaUsuario.imprimir("No se encontró el usuario o no se actualizó ningún dato.");
            }

        } catch (SQLException ex) {
            System.out.println("Error al actualizar los datos: " + ex.getMessage());
        }
        return datoActualizado;
    }

    public boolean verificarUser(String nameUser){
        boolean userEncontrado = verificarNombreUsuario(nameUser);
            if (userEncontrado) {
               return true;
            }
        return false;
    }
    public boolean eliminarCuenta(String respuesta, String nombreUser) {
        if (respuesta.equalsIgnoreCase("si")) {
            try {
                String sql = "DELETE FROM usuario WHERE Nombre_Usuario = ?";
                ps = conexion.prepareStatement(sql);
                ps.setString(1, nombreUser);

                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Error en la consulta: " + ex.getMessage());
            }
        }
        return false;
    }

}
