package Modelo;

public class Usuario {
    private String nombreApellido;
    private String nombreUsuario;
    private String correo;
    private String contrasenia;

    public Usuario() {
    }
    public Usuario(String nombreApellido, String nombreUsuario, String correo, String contrasenia) {
        this.nombreApellido = nombreApellido;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public Usuario(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
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

    @Override
    public String toString() {
        return "\nMi perfil" +
                "\nNombre: " + nombreApellido  +
                "\nNombre de usuario: " + nombreUsuario +
                "\nCorreo: " + correo +
                "\nContraseña: " + contrasenia;
    }
    public String imprimirDatosPerfil(){
        String datosPerfil = "Nombre: " + nombreApellido + "\nNombre de usuario: " + nombreUsuario;
        return datosPerfil;
    }
}
