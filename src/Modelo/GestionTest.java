package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class GestionTest {
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;

    Scanner x = new Scanner(System.in);
    static LinkedHashMap<String, Administrador> testUsuarios = new LinkedHashMap<>();
    List<String> numeros = new ArrayList<String>();


    Gson json = new GsonBuilder().setPrettyPrinting().create();

    public GestionTest() {
        Administrador administrador = new Administrador();
        testUsuarios = new LinkedHashMap<>();
        deserializar();
    }
    public void organizar() {
        numeros.clear();
        numeros.addAll(testUsuarios.keySet());
        Collections.shuffle(numeros);
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
        String mensaje = "Producto agregado";
        testUsuarios.put(a.getPregunta(),a);
        serializar();
        return  mensaje;
    }

    public boolean comprobar(String valor){
        return  testUsuarios.containsKey(valor);
    }
    public int correcta() {
        respuestasCorrectas++;
        return respuestasCorrectas;
    }

    public int incorrecta() {
        respuestasIncorrectas++;
        return respuestasIncorrectas;
    }

    public String examen(String llave, String recibo) {
        String mostrar = "";
        int indice = Integer.parseInt(llave);
        String orden = String.valueOf(numeros.get(indice));
        Administrador admin = testUsuarios.get(orden);
        admin.setPregunta(recibo);
        mostrar += admin.toString() + "\n";
        return mostrar;
    }

    public String respuestas(String llave, String respuesta) {
        String res = "";
        int indice = Integer.parseInt(llave);
        String orden = String.valueOf(numeros.get(indice));
        Administrador admin = testUsuarios.get(orden);

        if (respuesta.equals(admin.getCorrecta())) {
            correcta();
            res = "Es correcta";
        } else {
            incorrecta();
            res = "Es incorrecta";
        }
        return res;
    }

    public String cantidad() {
        String cor = "";
        if (respuestasCorrectas >= 7) {
            cor = "Felicidades pasaste el examen, explora nuestros módulos";
        } else {
            cor = "Intenta probar con nuestro módulo de lógica";
        }
        return cor;
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

        Administrador adm = testUsuarios.get(pregunta);

        testUsuarios.remove(pregunta);
        mensje = "Pregunta eliminada";



        serializar();
        return mensje;

    }


    public boolean actualizar(String actu, int dato, Object nuevo) {
        new GestionTest().deserializar();
        boolean test = false;

        Administrador adm = testUsuarios.get(actu);

        if (adm == null) {

            return false;
        }
        switch (dato) {
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


        serializar();
        return true;
    }

}
