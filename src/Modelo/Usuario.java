package Modelo;

public class Usuario {
    private String nombre;
    private String nombreUsuario;
    private String correo;
    private String contrasenia;
    private String tipoUsuario;

    public Usuario() {
    }
    public Usuario(String nombre, String nombreUsuario, String correo, String contrasenia) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipoUsuario = "usuario";
    }
    public Usuario(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombreApellido(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    @Override
    public String toString() {
        return "\nMi perfil" +
                "\nNombre: " + nombre +
                "\nNombre de usuario: " + nombreUsuario +
                "\nCorreo: " + correo +
                "\nContraseña: " + contrasenia;
    }
    public String imprimirDatosPerfil(){
        String datosPerfil = "Nombre: " + nombre + "\nNombre de usuario: " + nombreUsuario
                + "\nCorreo: " + correo;
        return datosPerfil;
    }
}
