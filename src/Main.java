import Modelo.Conexion;
import Vista.InterfazUsuario;

public class Main {
    public static void main(String[] args) {
        InterfazUsuario vista = new InterfazUsuario();
        vista.conectar();

        /*Conexion prueba = new Conexion();
        prueba.Conecta();*/
    }
}
