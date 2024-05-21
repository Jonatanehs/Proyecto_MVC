package Vista;

import Modelo.GestionArray;
import Controlador.Controlador;

import java.util.Scanner;

public class InterfazUsuario {
    GestionArray listaUsuarios = new GestionArray();

    int opcion = 0;
    Scanner x = new Scanner(System.in);

    public int menuPrincipal(){
         do{
            System.out.println("1. Registrarse.");
            System.out.println("2. Iniciar Sesión.");
            System.out.println("3. Iniciar sesión como administrador.");
            System.out.println("4. Salir.");
            System.out.println("Elija una opción:");
            opcion = x.nextInt();
        }while(opcion >= 1 && opcion <= 4);
         return opcion;
    }

    public void interfazUsuario(String nameUser, String password){
        do{
            System.out.println("\nMenú usuario");
            System.out.println("1. Ver perfil");
            System.out.println("2. Actualizar datos");
            System.out.println("3. Buscar amigos");
            System.out.println("4. Realizar test");
            System.out.println("5. Eliminar cuenta");
            System.out.println("6. Desactivar cuenta");
            System.out.println("7. Ver novedades");
            System.out.println("8. Buscar novedades");
            System.out.println("9. Salir");
            System.out.println("Elija una opción: ");
            int opcion = x.nextInt();

        }while (opcion >= 1 && opcion <= 9);
    }

    public void conectar(){
        Controlador control = new Controlador();
        control.Control();
    }
}
