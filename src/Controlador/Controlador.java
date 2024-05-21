package Controlador;

import Modelo.GestionArray;
import Modelo.Usuario;
import Vista.InterfazUsuario;

public class Controlador {
    Usuario usuario = new Usuario();
    GestionArray listaUsuarios = new GestionArray();
    InterfazUsuario vistaUsuario = new InterfazUsuario();



    public void Control(){
        boolean control = true;
        while(control) {
            int opcion = vistaUsuario.menuPrincipal();
            switch (opcion) {
                case 1:
                    break;
            }
        }

    }
}
