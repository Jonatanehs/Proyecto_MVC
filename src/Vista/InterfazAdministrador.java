package Vista;

import javax.swing.*;

public class InterfazAdministrador {

    public int menu() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "\nMenú Administrador " +
                    "\n1. Test \n2. Busqueda de usuarios\n3. Contenidos \n0. Salir"));
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
            opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Editar el test\n2. Añadir nueva pregunta\n3. Eliminar pregunta\n" +
                            "4. Buscar preguntas\n0. Volver al menu"));
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
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Pregunta\n2. Respuesta " +
                    "1 \n3. Respuesta 2\n4. Respuesta 3\n5. Respuesta correcta"));
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

    public String titulo() {
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo del contenido: ");
        System.out.println("Título ingresado: " + titulo);
        return titulo;
    }
    public String descripcion() {
        return JOptionPane.showInputDialog("Ingrese el contenido de la novedad: ");
    }
    public String autor() {
        return JOptionPane.showInputDialog("Ingrese el nombre del autor: ");
    }
    public String url() {
        return JOptionPane.showInputDialog("Ingrese la url: ");
    }
    public String fechaPublic() {
        return JOptionPane.showInputDialog("Ingrese la fecha: ");
    }
    public String tipoContent() {
        return JOptionPane.showInputDialog("Ingrese el tipo de contenido: ");
    }
    public String contDetalle() {
        return JOptionPane.showInputDialog("Ingrese los detalles del contenido: ");
    }
    public String categoria() {
        return JOptionPane.showInputDialog("Ingrese la categoria del contenido: ");
    }

    public String busc() {
        return JOptionPane.showInputDialog("Titulo o subtitulo a buscar");
    }

    public String elim() {
        return JOptionPane.showInputDialog("Titulo o subtitulo a eliminar");
    }

    public int contenido() {
        int opc = 0;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Editar el contenido\n" +
                    "2. Añadir nuevo contenido\n3. Eliminar contenido\n4. Buscar novedad\n0. Volver al menu"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: debe ingresar solo números.");
        }
        return opc;
    }

    public String actualizar() {
        return JOptionPane.showInputDialog("Ingrese el titulo ");
    }

    public int cambio() {
        int opc = 0;
        boolean valido = false;
        while (!valido) {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Titulo\n" +
                        "2. Descripción \n3. Autor \n4. Url \n5. Fecha Publicación \n6. Tipo de " +
                        "contenido \n7. Detalle del contenido \n8. Categoria"));

                if (opc < 1 || opc > 8) {
                    throw new NumberFormatException();
                }
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: debe ingresar un número entre 1 y 8.");
            }
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

