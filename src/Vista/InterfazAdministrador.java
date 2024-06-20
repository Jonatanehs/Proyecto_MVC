package Vista;

import javax.swing.*;
import java.util.Scanner;

public class InterfazAdministrador {

    Scanner x = new Scanner(System.in);

    public int menu(){
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog("\nMenú Administrador \n1. Test \n2. Busqueda de usuarios"));
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }
    public  String id(){
        String id = "";
        id = JOptionPane.showInputDialog("Ingrese el numero de la pregunta");
        return id;
    }
    public  String preguntas(){
        String pregunta = "";
        pregunta = JOptionPane.showInputDialog("Ingrese la pregunta");
        return  pregunta;
    }
    public String respuestas1(){
        String pregunta = "";
        pregunta = JOptionPane.showInputDialog("Ingrese la respuesta 1");
        return  pregunta;
    }
    public String respuestas2(){
        String pregunta = "";
        pregunta = JOptionPane.showInputDialog("Ingrese la respuesta 2");
        return  pregunta;
    }
    public String respuestas3(){
        String pregunta = "";
        pregunta = JOptionPane.showInputDialog("Ingrese la respuesta 3");
        return  pregunta;

    }
    public String respuestas(){
        String pregunta = "";
        pregunta = JOptionPane.showInputDialog("Ingrese la respuesta correcta");
        return  pregunta;
    }
    public int test(){
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1. Editar el test\n2. Añadir nueva pregunta" +
                "\n3. Eliminar pregunta\n4. Buscar preguntas\n0. Volver al menu"));
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return  opc;
    }
    public String seleccion(){
        String opcion = JOptionPane.showInputDialog("Ingrese el numero de pregunta a cambiar");
        return  opcion;
    }
    public  int seleccio(){
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1. Pregunta\n2. Respuesta 1 \n3. Respuesta 2" +
                "\n4.Respuesta 3\n5. Respuesta correcta"));
        }catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return  opc;
    }
    public String respuesta(){
        String respues = "";
        respues = JOptionPane.showInputDialog("Ingrese el nuevo valor");
        return respues;
    }
    public String usu(){
        String usuario = "";
        usuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
        return usuario;
    }
    public void imprimir(String valor){
        JOptionPane.showInternalMessageDialog(null, valor);
    }
}
