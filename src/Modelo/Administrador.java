package Modelo;

public class Administrador {
    private String pregunta ="";
    private String test = "";
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String correcta;
    private  String titulo;
    private String descripcion;
    private  String autor;
    private  String url;
    private  String fecha;
    private  String tipoCont;
    private  String detalle;
    private  String categoria;
    private String tipoUsuario;

    public Administrador() {
    }

    public Administrador(String pregunta, String test, String respuesta1, String respuesta2,
                         String respuesta3, String correcta) {
        this.pregunta = pregunta;
        this.test = test;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.correcta = correcta;
    }
    public Administrador(String titulo, String descripcion, String autor, String url, String fecha,
                         String tipoCont, String detalle, String categoria, String tipoUsuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.url = url;
        this.fecha = fecha;
        this.tipoCont = tipoCont;
        this.detalle = detalle;
        this.categoria = categoria;
        this.tipoUsuario = tipoUsuario;
    }

    public Administrador(String titulo) {
        this.titulo = titulo;
    }

    public Administrador(String tit, String descrip, String autor, String url, String fecha, String tipo, String detalle, String categ) {
        this.titulo = tit;
        this.descripcion = descrip;
        this.autor = autor;
        this.url = url;
        this.fecha = fecha;
        this.tipoCont = tipo;
        this.detalle = detalle;
        this.categoria = categ;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCont() {
        return tipoCont;
    }

    public void setTipoCont(String tipoCont) {
        this.tipoCont = tipoCont;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
//    public String novedades() {
//        return
//                "\n" + titulo +
//                        "\n"+subtitulo  +
//                        "\n" + tema;
//    }
}
