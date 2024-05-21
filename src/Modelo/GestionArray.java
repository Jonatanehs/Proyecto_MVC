package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionArray {
    GestionTest test = new GestionTest();
    GestionContenido contenido = new GestionContenido();

    private ArrayList<Usuario> listaUsuarios;

    public GestionArray(){
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Camilo Perez", "camilop88", "camiloperez1988@gmail.com", "camilo123"));
        listaUsuarios.add(new Usuario("Sandra Martinez", "sandramar99", "sandramartinez@hotmail.com", "sandra1999"));
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public boolean verificarNombreUsuario(String nombreUsuario){
        for (Usuario user : listaUsuarios) {
            if (user.getNombreUsuario().toLowerCase().equals(nombreUsuario)) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarCorreo(String correo){
        for (Usuario user : listaUsuarios) {
            if (user.getCorreo().toLowerCase().equals(correo)) {
                return false;
            }
        }
        return true;
    }
    public boolean verificacionContrasenia(String clave){
        for (Usuario user : listaUsuarios) {
            if (user.getContrasenia().equals(clave)) {
                return true;
            }
        }
        return false;
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
}

class GestionTest {
    Scanner x = new Scanner(System.in);
    private ArrayList<Administrador> testUsuarios;

    public GestionTest() {
        Administrador administrador = new Administrador();
        testUsuarios = new ArrayList<>();
        testUsuarios.add(new Administrador(1, "¿Cuál de los siguientes números no pertenece a la serie: 2, 3, 5, 7, 11, 14, 17?",
                "2", "14", "17", "B"));
        testUsuarios.add(new Administrador(2, "Si el día después de mañana es tres días antes del domingo, ¿qué día es hoy?",
                "Martes", "Miércoles", "Jueves", "C"));
        testUsuarios.add(new Administrador(3, "Si en una carrera adelantas al segundo, ¿en qué posición terminas?",
                "Primero", "Segundo", "Tercero", "B"));
        testUsuarios.add(new Administrador(4, "Un avión se estrella en la frontera entre Estados Unidos y Canadá. ¿Dónde entierran a los supervivientes?",
                "En Estados Unidos", "En Canadá", "No se entierran a los supervivientes", "C"));
        testUsuarios.add(new Administrador(5, "¿Cuál es la mitad de dos más dos?",
                "1", "2", "3", "C"));
        testUsuarios.add(new Administrador(6, "Si tienes 8 manzanas y tomas 7, ¿cuántas tienes?",
                "1", "7", "8", "B"));
        testUsuarios.add(new Administrador(7, "¿Cuál de las siguientes palabras no encaja? Manzana, Naranja, Plátano, Pera, Coche.",
                "Manzana", "Naranja", "Coche", "C"));
        testUsuarios.add(new Administrador(8, "Si algunos Smaps son Traps y algunos Traps son Mrap, entonces algunos Smaps son definitivamente Mrap.",
                "Verdadero", "Falso", "", "B"));
        testUsuarios.add(new Administrador(9, "¿Cuál de los siguientes números no pertenece a la serie: 1, 2, 4, 8, 16, 32, 64, 128, 256, 500, 1000?",
                "1", "500", "1000", "B"));

    }
}

class GestionContenido {

    Scanner x = new Scanner(System.in);
    private ArrayList<Administrador> contenido;

    public GestionContenido() {
        Administrador admin = new Administrador();
        contenido = new ArrayList<>();
        contenido.add(new Administrador("PRUEBA", "NOVEDADES", "El tema se trata de comprobar las novedades"));
        contenido.add(new Administrador("DOS", "ULTIMO", "quitar"));
    }

    public void mostrar() {
        for (int i = contenido.size() - 1; i >= 0; i--) {
            Administrador admin = contenido.get(i);
            System.out.println(admin.novedades());
        }
    }

    public boolean encuentro(String valor) {
        boolean encontrado = false;

        for (int i = 0; i < contenido.size(); i++) {
            Administrador administrador = contenido.get(i);
            if (administrador.getTitulo().equals(valor) || administrador.getSubtitulo().equals(valor)) {
                encontrado = true;
                System.out.println(administrador.novedades());
            }

        }
        if (encontrado == false) {
            encontrado = false;
        }
        return encontrado;
    }
}