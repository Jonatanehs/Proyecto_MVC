package Modelo;

public class Administrador {
    private String Admin = "Admin1";
    private String contra = "123456";
    private String pregunta ="";
    private String test = "";
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String correcta;
    private  String titulo;
    private String subtitulo;
    private  String tema;
    private String tipoUsuario;

    public Administrador(String admin, String contra) {
        Admin = admin;
        this.contra = contra;
        this.tipoUsuario = "admin";
    }
    public Administrador() {
    }

    public Administrador(String pregunta, String test, String respuesta1, String respuesta2, String respuesta3, String correcta) {
        this.pregunta = pregunta;
        this.test = test;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.correcta = correcta;
    }

    public Administrador(String titulo, String subtitulo, String tema) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getAdmin() {
        return Admin;
    }


    public void setAdmin(String admin) {
        Admin = admin;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return
                pregunta +
                        ". " + test  +
                        "\nA. " + respuesta1 +
                        "\nB. " + respuesta2 +
                        "\nC. " + respuesta3;

    }
    public String novedades() {
        return
                "\n" + titulo +
                        "\n"+subtitulo  +
                        "\n" + tema;
    }
}
