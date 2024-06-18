package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class GestionContenido {

    Scanner x = new Scanner(System.in);
    public static LinkedHashMap<String, Administrador> contenido = new LinkedHashMap<>();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    int contador = 0;
    public GestionContenido() {
        Administrador admin = new Administrador();
        contenido = new LinkedHashMap<>();
        /*contenido.add(new Administrador("PRUEBA", "NOVEDADES", "El tema se trata de comprobar las novedades"));
        contenido.add(new Administrador("DOS", "ULTIMO", "quitar"));*/
    }
    public static void serializar() {
        try (FileWriter nuevoJson = new FileWriter("contenido.json")) {
            gson.toJson(contenido, nuevoJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deserializar() {
        try (FileReader reader = new FileReader("usuarios.json")) {
            Type tipoHashMap = new TypeToken<LinkedHashMap<String, Administrador>>() {}.getType();
            contenido = gson.fromJson(reader, tipoHashMap);
            if(contenido== null){
                contenido = new LinkedHashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrar() {
        for (int i = contenido.size() - 1; i >= 0; i--) {
            Administrador admin = contenido.get(i);

        }
    }
    private String generarClaveNovedad() {
        return "user" + (contador++);
    }
    public void registrarNovedad(Administrador admin) {
        String nuevaClave = generarClaveNovedad();
        contenido.put(nuevaClave, admin);
        serializar();
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


   /* public void eliminar(String eliminar) {
        boolean encuentro = encuentro(eliminar);
        if (encuentro) {
            for (int i = 0; i < contenido.size(); i++) {
                Administrador admin = contenido.get(i);
                if (admin.getTitulo().equals(eliminar) || admin.getSubtitulo().equals(eliminar)) {
                    System.out.println("Seguro que deseas eliminar esta Novedad? S/N");
                    String respuesta = x.next().toUpperCase();
                    if (respuesta.equals("S")) {
                        contenido.remove(i);
                        System.out.println("La novedad se ha eliminado correctamente");
                    } else {
                        System.out.println("La novedad no se ha eliminado");
                    }
                }
            }
        } else {
            System.out.println("La novedad no existe");
        }
    }

    public void editar(String editar) {
        boolean encontrado = encuentro(editar);
        if (encontrado) {

            for (Administrador contenidos : contenido) {
                if (contenidos.getTitulo().equals(editar) || contenidos.getSubtitulo().equals(editar)) {
                    System.out.println("Seleccione los datos a cambiar" +
                            "\n1.Titulo \n2.Subtitulo  \n3.Tema ");
                    int cambio = x.nextInt();
                    switch (cambio) {
                        case 1:
                            x.nextLine();
                            System.out.println("Ingrese el nuevo titulo");
                            String pregunta = x.nextLine().toUpperCase();
                            contenidos.setTitulo(pregunta);
                            System.out.println("El titulo se ha cambiado con exito");
                            break;
                        case 2:
                            // x.nextLine();
                            System.out.println("Ingrese el nuevo subtitulo");
                            String respuesta1 = x.nextLine().toUpperCase();
                            contenidos.setSubtitulo(respuesta1);
                            System.out.println("El subtitulo se ha cambiado con exito");
                            break;
                        case 3:
                            // x.nextLine();
                            System.out.println("Ingrese el nuevo tema");
                            String respuesta2 = x.nextLine();
                            contenidos.setTema(respuesta2);
                            System.out.println("El tema se ha cambiado con exito");
                            break;

                        default:
                            System.out.println("No es una opcion valida");
                            break;
                    }
                }
            }
        } else {
            System.out.println("El tema no existe");
        }
    }

    */
}
