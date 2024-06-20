package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class GestionTest {
    Scanner x = new Scanner(System.in);
    static LinkedHashMap<String, Administrador> testUsuarios = new LinkedHashMap<>();

    Gson json = new GsonBuilder().setPrettyPrinting().create();

    public GestionTest() {
        Administrador administrador = new Administrador();
        testUsuarios = new LinkedHashMap<>();
        deserializar();
    }
    public void serializar() {
        try (FileWriter writer = new FileWriter("test.json")) {
            json.toJson(testUsuarios, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deserializar() {
        try (FileReader reader = new FileReader("test.json")) {
            Type type = new TypeToken<LinkedHashMap<String, Administrador>>() {}.getType();
            testUsuarios = json.fromJson(reader, type);
            if (testUsuarios == null){
                testUsuarios = new LinkedHashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String agregar(Administrador a){
        String mensaje = JOptionPane.showInputDialog("Producto agregado");
        testUsuarios.put(a.getPregunta(),a);
        serializar();
        return  mensaje;
    }

    public boolean comprobar(String valor){
        return  testUsuarios.containsKey(valor);
    }
    public int correcta(int numero){
        int numero1 = numero;
        int correctas = 0;
        correctas+=numero1;
        return correctas;
    }
    public int incorrecta(int numero){
        int numero1 = numero;
        int incorrectas = 0;
        incorrectas+=numero1;
        return incorrectas;
    }
    public  String examen(String llave){
        String mostrar ="";
        Administrador admin = testUsuarios.get(llave);
        mostrar += admin.toString() +"\n";
        return mostrar;
    }
    public String respuestas(String llave, String respuesta){
        String res = "";
        Administrador admin = testUsuarios.get(llave);

        if (respuesta.equals(admin.getCorrecta()) ){
            correcta(1);
            res = JOptionPane.showInputDialog("Es correcta");
        }
        else {
            incorrecta(1);
            res = JOptionPane.showInputDialog("Es incorrecta");
        }
        return res;
    }
    public String cantidad(){
        int cr = correcta(0);
        int ic = incorrecta(0);
        String cor = "";
        if (cr>=7){
            cor = JOptionPane.showInputDialog("Felicidades pasaste el examen, explora nuestros modulos");
        }else{
            cor = JOptionPane.showInputDialog("Intenta probar con nuestro modulo de logica");
        }
        return  cor;
    }
    public int tamanio (){
        return testUsuarios.size();
    }
    public String busqueda(String dato){
        String impr = "";
        Administrador admin = testUsuarios.get(dato);
        impr += admin.toString() +"\n";

        return  impr;
    }
    public  boolean comproba (String val){
        boolean esta = false;
        new GestionTest().deserializar();
        for (Administrador p: testUsuarios.values()){
            if (val.equals(p.getTest()) || val.equals(p.getPregunta())){
                esta = true;
                break;
            }
        }
        return esta;
    }
    public String eliminar(String pregunta){
        String mensje = "";
        String preguntaAEliminar;
        for (String ref: testUsuarios.keySet()){
            Administrador adm = testUsuarios.get(ref);
            if (adm.getPregunta().equalsIgnoreCase(pregunta)|| adm.getTest().equalsIgnoreCase(pregunta)){
                preguntaAEliminar = ref;
                testUsuarios.remove(preguntaAEliminar);
                mensje = JOptionPane.showInputDialog("Pregunta eliminada");
            }
        }
        serializar();
        return mensje;

    }

    public  boolean actualizar(String actu, int dato, Object nuevo){
        new GestionTest().deserializar();
        boolean test = false;
        for (Administrador adm: testUsuarios.values()){
            if (adm.getTest().equalsIgnoreCase(actu)|| adm.getPregunta().equalsIgnoreCase(actu)){
                switch (dato){
                    case 1:
                        adm.setTest((String) nuevo);
                        break;
                    case 2:
                        adm.setRespuesta1((String) nuevo);
                        break;
                    case 3:
                        adm.setRespuesta2((String) nuevo);
                        break;
                    case 4:
                        adm.setRespuesta3((String) nuevo);
                        break;
                    case 5:
                        adm.setCorrecta((String) nuevo);
                        break;
                    default:
                        return false;
                }
                test = true;
                break;
            }
        }
        if (test){
            serializar();
        }
        return test;
    }

}
