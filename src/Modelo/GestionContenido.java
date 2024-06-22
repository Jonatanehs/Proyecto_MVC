package Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public class GestionContenido {
    static LinkedHashMap<String,Administrador> contenido = new LinkedHashMap<>();

    Gson json = new GsonBuilder().setPrettyPrinting().create();

    public GestionContenido(){
        Administrador adm = new Administrador();
        contenido = new LinkedHashMap<>();
        deserializar();
    }

    public void serializar() {
        try (FileWriter writer = new FileWriter("contenido.json")) {
            json.toJson(contenido, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deserializar() {
        try (FileReader reader = new FileReader("contenido.json")) {
            Type type = new TypeToken<LinkedHashMap<String, Administrador>>() {}.getType();
            contenido = json.fromJson(reader, type);
            if (contenido == null){
                contenido = new LinkedHashMap<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String agregar(String clave,Administrador a){
        String mensaje = "Producto agregado";
        contenido.put(clave,a);
        serializar();
        return  mensaje;
    }

    public boolean comprobar(String valor){
        return  contenido.containsKey(valor);
    }
    public  boolean comproba (String val){
        boolean esta = false;
        new GestionTest().deserializar();
        for (Administrador p: contenido.values()){
            if (val.equals(p.getTitulo()) || val.equals(p.getSubtitulo())){
                esta = true;
                break;
            }

        }
        return esta;
    }
    public  boolean actualizar(String actu, int dato, Object nuevo){
        deserializar();
        boolean test = false;
        for (Administrador adm: contenido.values()){
            if (adm.getTitulo().equalsIgnoreCase(actu)|| adm.getSubtitulo().equalsIgnoreCase(actu)){
                switch (dato){
                    case 1:
                        adm.setTitulo(((String) nuevo).toUpperCase());
                        break;
                    case 2:
                        adm.setSubtitulo(((String) nuevo).toUpperCase());
                        break;
                    case 3:
                        adm.setTema((String) nuevo);
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

    public  boolean eliminarProducto(String producto) {
        String claveAEliminar;
        for (String clave : contenido.keySet()) {
            Administrador prod = contenido.get(clave);
            if (prod.getTitulo().equalsIgnoreCase(producto) || prod.getSubtitulo().equalsIgnoreCase(producto)) {
                claveAEliminar = clave;
                contenido.remove(claveAEliminar);
                serializar();
                return true;
            }

        }
        serializar();
        return false;
    }

    public String mostrar(String pr){
        String nota = "";
        for ( String kl: contenido.keySet()){
            Administrador prod = contenido.get(kl);
            if (prod.getTitulo().equalsIgnoreCase(pr) || prod.getSubtitulo().equalsIgnoreCase(pr)){
                nota = prod.novedades();
            }
        }
        return  nota;
    }
    public String mostra(){
        String nota = "";
        String[] keys = contenido.keySet().toArray(new String[0]);
        for (int i = keys.length - 1; i >= 0; i--) {
            Administrador prod = contenido.get(keys[i]);
            nota += prod.novedades() + "\n";
        }
        return nota;
    }

}
