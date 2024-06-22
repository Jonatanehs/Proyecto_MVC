package Vista;

import javax.swing.*;

public class InterfazAdministrador {

    public int menu() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "\nMenú Administrador \n1. Test \n2. Busqueda de usuarios\n3. Contenidos"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }

    public String id() {
        return JOptionPane.showInputDialog("Ingrese el numero de la pregunta");
    }

    public String preguntas() {
        return JOptionPane.showInputDialog("Ingrese la pregunta");
    }

    public String respuestas1() {
        return JOptionPane.showInputDialog("Ingrese la respuesta 1");
    }

    public String respuestas2() {
        return JOptionPane.showInputDialog("Ingrese la respuesta 2");
    }

    public String respuestas3() {
        return JOptionPane.showInputDialog("Ingrese la respuesta 3");
    }

    public String respuestas() {
        return JOptionPane.showInputDialog("Ingrese la respuesta correcta");
    }

    public int test() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Editar el test\n2. Añadir nueva pregunta\n3. Eliminar pregunta\n4. Buscar preguntas\n0. Volver al menu"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }

    public String seleccion() {
        return JOptionPane.showInputDialog("Ingrese el numero de pregunta a cambiar");
    }

    public int seleccio() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Pregunta\n2. Respuesta 1 \n3. Respuesta 2\n4. Respuesta 3\n5. Respuesta correcta"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }

    public String respuesta() {
        return JOptionPane.showInputDialog("Ingrese el nuevo valor");
    }

    public String usu() {
        return JOptionPane.showInputDialog("Ingrese el nombre de usuario");
    }

    public String clave() {
        return JOptionPane.showInputDialog("Ingrese el numero de la novedad");
    }

    public String titulo() {
        return JOptionPane.showInputDialog("Ingrese el titulo del contenido").toUpperCase();
    }

    public String subtitulo() {
        return JOptionPane.showInputDialog("Ingrese el subtitulo del contenido").toUpperCase();
    }

    public String conten() {
        return JOptionPane.showInputDialog("Ingrese el contenido de la novedad");
    }

    public String busc() {
        return JOptionPane.showInputDialog("Titulo o subtitulo a buscar").toUpperCase();
    }

    public String elim() {
        return JOptionPane.showInputDialog("Titulo o subtitulo a eliminar").toUpperCase();
    }

    public int contenido() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Editar el contenido\n2. Añadir nuevo contenido\n3. Eliminar contenido\n4. Buscar novedad\n0. Volver al menu"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }

    public String actualizar() {
        return JOptionPane.showInputDialog("Ingrese el titulo o subtitulo a cambiar").toUpperCase();
    }

    public int cambio() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Titulo\n2. Subtitulo \n3. Contenido"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }

    public String actualizado() {
        return JOptionPane.showInputDialog("Ingrese el nuevo valor");
    }

    public void imprimir(String valor) {
        JOptionPane.showMessageDialog(null, valor);
    }
}
