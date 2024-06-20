package Modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GestionArray {
    GestionTest test = new GestionTest();
    GestionContenido contenido = new GestionContenido();
    Usuario usuario = new Usuario();
    static int contador = 1;
    static LinkedHashMap<String, Usuario> listaUsuarios = new LinkedHashMap<>();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public GestionArray(){
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
            Type tipoHashMap = new TypeToken<LinkedHashMap<String, Usuario>>() {}.getType();
            listaUsuarios = gson.fromJson(reader, tipoHashMap);
            if(listaUsuarios == null){
                listaUsuarios = new LinkedHashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean verificarNombreUsuario(String nombreUsuario){
        for (Usuario user : listaUsuarios.values()) {
            if (user.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return false;
            }
        }
        return true;
    }
    public boolean verificarCorreo(String correo){
        for (Usuario user : listaUsuarios.values()) {
            if (user.getCorreo().toLowerCase().equals(correo)) {
                return false;
            }
        }
        return true;
    }
    public boolean verificacionContrasenia(String clave){
        for (Usuario user : listaUsuarios.values()) {
            if (user.getContrasenia().equals(clave)) {
                return true;
            }
        }
        return false;
    }
    private String generarClaveUsuario() {
        return "user" + (contador++);
    }
    private void actualizarContador(){
        int maxNumero = 0;
        for(String clave: listaUsuarios.keySet()){
            if (clave.startsWith("user")){
                String numeroStr = clave.replace("user", "");
                if(numeroStr.matches("\\d+")){
                    try {
                        int numero = Integer.parseInt(numeroStr);
                        if(numero > maxNumero){
                            maxNumero = numero;
                        }
                    }catch (NumberFormatException e){

                    }
                }
            }
        }
        contador = maxNumero + 1;
    }
    public void registrarUsuario(Usuario usuario) {
        deserializar();
        actualizarContador();
        String nuevaClave = generarClaveUsuario();
        listaUsuarios.put(nuevaClave, usuario);
        serializar();
    }
    public boolean verificarCuenta(String usuario, String clave){
        boolean ingresado = false;
        int ingreso = 0;

        for (char c: usuario.toCharArray()) {
            if (c == '@') {
                ingreso +=1;
            }
        }
        if (ingreso > 0) {
            boolean verificacion = verificarCorreo(usuario);
            boolean contra = verificacionContrasenia(clave);
            if (verificacion == false && contra == true) {
                return true;
            } else {
                return false;
            }
        } else {
            boolean verificacion = verificarNombreUsuario(usuario);
            boolean contra = verificacionContrasenia(clave);
            if (verificacion == false && contra == true) {
                return true;
            } else {
                return false;
            }
        }
    }
    public boolean verificarTipoUser(String nameUsuario) {
        boolean tipoUsuario = false;
        for (Usuario usuario : listaUsuarios.values()) {
            if (usuario.getNombreUsuario().equals(nameUsuario)) {
                if (usuario.getTipoUsuario().equals("usuario")) {
                    tipoUsuario = true;
                    break;
                }
            }
        }
        return tipoUsuario;
    }
    public boolean verificarCorreoValido(String correo){
        if (correo.contains("@") && correo.contains(".com")) {
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
        for (Usuario user : listaUsuarios.values()) {
            if (user.getNombreUsuario().toLowerCase().equals(nameUser.toLowerCase())) {
                perfil = user.imprimirDatosPerfil();
            }
        }
        return perfil;
    }
    public boolean actualizarDatos(String nomUsuario, String dato, Object nuevoValor){
        deserializar();
        boolean datoActualizado = false;
        for (Usuario user : listaUsuarios.values()) {
            if(user.getNombreUsuario().equalsIgnoreCase(nomUsuario)) {
                switch (dato.toLowerCase()) {
                    case "nombre":
                        user.setNombreApellido((String) nuevoValor);
                        break;
                    case "usuario":
                        user.setNombreUsuario((String) nuevoValor);
                        break;
                    case "correo":
                        user.setCorreo((String) nuevoValor);
                        break;
                    case "contraseña":
                        user.setContrasenia((String) nuevoValor);
                        break;
                    default:
                        return datoActualizado;
                }
                datoActualizado = true;
                break;
            }
        }
        if (datoActualizado) {
            serializar();
        }
        return datoActualizado;
    }
    public boolean verificarUser(String nameUser){
        boolean userEncontrado = false;
        for (Usuario user : listaUsuarios.values()) {
            if (user.getNombreUsuario().toLowerCase().equals(nameUser)) {
                userEncontrado = true;
            }
        }
        return userEncontrado;
    }
    public boolean eliminarCuenta(String respuesta, String nombreUser) {
        if (respuesta.equalsIgnoreCase("si")) {
            String claveAEliminar = null;
            for (String clave : listaUsuarios.keySet()) {
                Usuario user = listaUsuarios.get(clave);
                if (user.getNombreUsuario().equalsIgnoreCase(nombreUser)) {
                    claveAEliminar = clave;
                    break;
                }
            }
            if (claveAEliminar != null) {
                listaUsuarios.remove(claveAEliminar);
                serializar();
                return true;
            }
        }
        return false;
    }
}
