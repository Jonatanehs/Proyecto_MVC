package Vista;

import Modelo.GestionArray;
import Controlador.Controlador;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class InterfazUsuario {
    int opcion = 0;
    Scanner x = new Scanner(System.in);

    public int menuPrincipal(){
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("\n1. Registrarse. \n2. Iniciar Sesión. \n3. Salir. " +
                    "\nElija una opción:"));
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opcion;
    }
    public String nombreRegis(){
        String nombreApellido = JOptionPane.showInputDialog("Nombre: ");
        return nombreApellido;
    }
    public String nombreUsuarioRegis(){
        String nombreUsuario = JOptionPane.showInputDialog("Nombre de usuario: ");
        return nombreUsuario;

    }
    public String correoRegis(){
        String correo = JOptionPane.showInputDialog("Correo: ");
        return correo;
    }
    public String contraseniaRegis(){
        JOptionPane.showInternalMessageDialog(null,"La contraseña debe tener al menos una mayúscula, una minúscula, un número y un " +
                "caracter especial. Debe tener MÍNIMO 8 carateres. ");
        String clave = JOptionPane.showInputDialog("Contraseña: ");
        return clave;
    }
    public String datoInicioSesion(){
        String dato = JOptionPane.showInputDialog("\nIngrese su nombre de usuario o correo");
        return  dato;
    }
    public String claveInicioSesion(){
        String clave = JOptionPane.showInputDialog("Ingrese su clave");
        return clave;
    }
    public int interfazUsuario() {
        int opcion = 0;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("\nMenú usuario: \n1. Ver perfil. \n2. Actualizar datos." +
                    "\n3. Buscar amigos. \n4. Realizar test. \n5. Eliminar cuenta. \n6. Desactivar cuenta. \n7. Ver novedades." +
                    "\n8. Buscar novedades \n0. Salir. \nElija una opción: "));
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opcion;
    }
    public String datoActualizar() {
        String actualizarDato = JOptionPane.showInputDialog("¿Qué dato desea actualizar?(nombre, usuario, " +
                "correo, contraseña)");
        return actualizarDato;
}
    public String nuevoNombre(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        return nombre;
    }
    public String nuevoUsuario(){
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
        return nombreUsuario;
    }
    public String nuevoCorreo(){
        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        return correo;
    }
    public String nuevaContrasenia(){
        String contrasenia = JOptionPane.showInputDialog("Ingrese la contraseña:");
        return contrasenia;
    }
    public String buscarAmigo(){
        String nameUsuario = JOptionPane.showInputDialog("\nIngrese el nombre de usuario: ");
        return nameUsuario;
    }
    public String eliminarCuenta(){
        String respuesta = JOptionPane.showInputDialog("\n¿Desea eliminar su cuenta?");
        return respuesta;
    }
    public String desactivarCuenta(){
        String respuesta = JOptionPane.showInputDialog("\n¿Desea desactivar su cuenta?");
        return respuesta;
    }
    public String buscarNovedad(){
        String tema = JOptionPane.showInputDialog("Ingrese el titulo o subtitulo de la novedad");
        return tema;
    }
    public void imprimir(String texto){
        JOptionPane.showInternalMessageDialog(null, texto);
    }
    public void conectar(){
        Controlador control = new Controlador();
        control.Control();
    }
}
