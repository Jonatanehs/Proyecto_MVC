package Vista;

import Modelo.GestionArray;
import Controlador.Controlador;

import javax.swing.*;
import java.util.Scanner;

public class InterfazUsuario {
    GestionArray listaUsuarios = new GestionArray();
    int opcion = 0;
    Scanner x = new Scanner(System.in);

    public int menuPrincipal(){

        System.out.println("\n1. Registrarse.");
        System.out.println("2. Iniciar Sesión.");
        System.out.println("3. Iniciar sesión como administrador.");
        System.out.println("4. Salir.");
        System.out.println("Elija una opción:");
        opcion = x.nextInt();

        return opcion;
    }

    public String nombreRegis(){
        x.nextLine();
        System.out.println("Nombre: ");
        String nombreApellido = x.nextLine();
        return nombreApellido;
    }
    public String nombreUsuarioRegis(){
        System.out.println("Nombre de usuario: ");
        String nombreUsuario = x.next();
        return nombreUsuario;
    }
    public String correoRegis(){
        System.out.println("Correo: ");
        String correo = x.next();
        return correo;
    }
    public String contraseniaRegis(){
        System.out.println("La contraseña debe tener al menos una mayúscula, una minúscula, un número y un " +
                "caracter especial. Debe tener MÍNIMO 8 carateres. ");
        System.out.println("Contraseña: ");
        String clave = x.next();
        return clave;
    }
    public String datoInicioSesion(){
        System.out.println("\nIngrese su nombre de usuario o correo");
        String dato = x.next();
        return  dato;
    }
    public String claveInicioSesion(){
        System.out.println("Ingrese su clave");
        String clave = x.next();
        return clave;
    }
    public int interfazUsuario(String nameUsuario) {
        int opcion;
        do {
            System.out.println("\nMenú usuario");
            System.out.println("1. Ver perfil");
            System.out.println("2. Actualizar datos");
            System.out.println("3. Buscar amigos");
            System.out.println("4. Realizar test");
            System.out.println("5. Eliminar cuenta");
            System.out.println("6. Desactivar cuenta");
            System.out.println("7. Ver novedades");
            System.out.println("8. Buscar novedades");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = x.nextInt();
        } while (opcion < 0 || opcion > 8);
        return opcion;
    }
    public String datoActualizar() {
        System.out.println("¿Qué dato desea actualizar?(nombre, usuario, " +
                "correo, contraseña)");
        String actualizarDato = x.next();
        return actualizarDato;
    }
    public String nuevoNombre(){
        x.nextLine();
        System.out.println("Ingrese el nombre:");
        String nombre = x.nextLine();
        return nombre;
    }
    public String nuevoUsuario(){
        System.out.println("Ingrese el nombre de usuario:");
        String nombreUsuario = x.next();
        return nombreUsuario;
    }
    public String nuevoCorreo(){
        System.out.println("Ingrese el correo:");
        String correo = x.next();
        return correo;
    }
    public String nuevaContrasenia(){
        System.out.println("Ingrese la contraseña:");
        String contrasenia = x.next();
        return contrasenia;
    }
    public String buscarAmigo(){
        System.out.println("\nIngrese el nombre de usuario: ");
        String nameUsuario = x.next();
        return nameUsuario;
    }
    public String eliminarCuenta(){
        System.out.println("\n¿Desea eliminar su cuenta?");
        String respuesta = x.next();
        return respuesta;
    }
    public String desactivarCuenta(){
        System.out.println("\n¿Desea desactivar su cuenta?");
        String respuesta = x.next();
        return respuesta;
    }
    public String buscarNovedad(){
        System.out.println("Ingrese el titulo o subtitulo de la novedad");
        String tema = x.nextLine().toUpperCase();
        return tema;
    }
    public void imprimir(String texto){
        System.out.println(texto);
    }
    public void conectar(){
        Controlador control = new Controlador();
        control.Control();
    }
}
