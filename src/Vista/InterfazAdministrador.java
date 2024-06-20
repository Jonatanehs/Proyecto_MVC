package Vista;

import java.util.Scanner;

public class InterfazAdministrador {

    Scanner x = new Scanner(System.in);

    public int menu(){
        int opc = 0;
        System.out.println("\nMenú Administrador");
        System.out.println("1. Test\n2. Busqueda de usuarios");
        opc = x.nextInt();

        return opc;
    }
    public  String id(){
        String id = "";
        System.out.println("Ingrese el numero de la pregunta");
        id = x.next();
        return id;
    }
    public  String preguntas(){
        String pregunta = "";
        System.out.println("Ingrese la pregunta");
        x.nextLine();
        pregunta = x.nextLine();
        return  pregunta;
    }
    public String respuestas1(){
        String pregunta = "";
        System.out.println("Ingrese la respuesta 1");
        pregunta = x.nextLine();
        return  pregunta;
    }
    public String respuestas2(){
        String pregunta = "";
        System.out.println("Ingrese la respuesta 2");
        pregunta = x.nextLine();
        return  pregunta;
    }
    public String respuestas3(){
        String pregunta = "";
        System.out.println("Ingrese la respuesta 3");
        pregunta = x.nextLine();
        return  pregunta;

    }
    public String respuestas(){
        String pregunta = "";
        System.out.println("Ingrese la respuesta correcta");
        pregunta = x.nextLine();
        return  pregunta;
    }
    public int test(){
        int opc = 0;

        System.out.println("1. Editar el test\n2. Añadir nueva pregunta" +
                "\n3. Eliminar pregunta\n4. Buscar preguntas\n0. Volver al menu");
        opc = x.nextInt();
        return  opc;
    }
    public String seleccion(){
        System.out.println("Ingrese el numero de pregunta a cambiar");
        return  x.next();
    }
    public  int seleccio(){
        int opc = 0;
        System.out.println("1. Pregunta\n2. Respuesta 1 \n3. Respuesta 2" +
                "\n4.Respuesta 3\n5. Respuesta correcta");
        opc = x.nextInt();
        return  opc;
    }
    public String respuesta(){
        String respues = "";
        System.out.println("Ingrese el nuevo valor");
        x.nextLine();
        respues = x.nextLine();
        return respues;
    }
    public String usu(){
        String usuario = "";
        System.out.println("Ingrese el nombre de usuario");
        usuario = x.next();
        return usuario;
    }
    public void imprimir(String valor){
        System.out.println(valor);
    }

}
