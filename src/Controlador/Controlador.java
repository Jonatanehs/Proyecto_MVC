package Controlador;

import Modelo.*;
import Vista.InterfazAdministrador;
import Vista.InterfazUsuario;

public class Controlador {
    Usuario usuario = new Usuario();
    GestionArray listaUsuarios = new GestionArray();
    GestionTest test = new GestionTest();
    GestionContenido contenido = new GestionContenido();
    InterfazUsuario vistaUsuario = new InterfazUsuario();
    InterfazAdministrador vistaAdmin = new InterfazAdministrador();

    public void Control(){
        boolean salir = false;
        boolean control = true;
        while(control) {
            int opcion = vistaUsuario.menuPrincipal();
            switch (opcion) {
                case 1:
                    String nombre = "";
                    String nombreUsu = "";
                    nombre = vistaUsuario.nombreRegis();
                    boolean nombreUsuarioDisponible;
                    do {
                        nombreUsuarioDisponible = listaUsuarios.verificarNombreUsuario(nombreUsu = vistaUsuario.nombreUsuarioRegis());
                        if (nombreUsuarioDisponible) {
                            vistaUsuario.imprimir("El nombre de usuario ya está en uso");
                        } else {
                            vistaUsuario.imprimir("Nombre de usuario disponible");
                        }
                    } while (nombreUsuarioDisponible);
                    String correo;
                    boolean correoEncontrado;
                    do {
                        correoEncontrado = listaUsuarios.verificarCorreo(correo = vistaUsuario.correoRegis());
                        if (correoEncontrado) {
                            vistaUsuario.imprimir("El correo ya está en uso");
                        }
                        boolean correoValido;
                        do {
                            correoValido = listaUsuarios.verificarCorreoValido(correo);
                            if (correoValido) {
                                vistaUsuario.imprimir("Correo válido");
                            } else {
                                vistaUsuario.imprimir("Debe ingresar un correo válido");
                                correo = vistaUsuario.correoRegis();
                            }
                        } while (!correoValido);
                    } while (correoEncontrado);
                    String clave;
                    String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!#$%&]).{8,}$";
                    do {
                        clave = vistaUsuario.contraseniaRegis();
                        listaUsuarios.verificarContrasenia(clave);
                    } while (!clave.matches(regex) || clave.length() < 8);

                    Usuario nuevoUsuario = new Usuario(nombre, nombreUsu, correo, clave);
                    listaUsuarios.convertirAJson();
                    listaUsuarios.registrarUsuario(nuevoUsuario);
                    vistaUsuario.imprimir("Usuario registrado exitosamente.");
                    break;
                case 2:
                    boolean iniciarSesion;
                    int intentos = 0;
                    String nameUsuario = "";
                    do {
                        nameUsuario = vistaUsuario.datoInicioSesion();
                        iniciarSesion = listaUsuarios.verificarCuenta(nameUsuario, vistaUsuario.claveInicioSesion());

                        if (!iniciarSesion) {
                            intentos++;
                            if (intentos < 3) {
                                vistaUsuario.imprimir("Datos incorrectos. Intento " + intentos + " de 3 intentos.");
                            } else {
                                vistaUsuario.imprimir("Datos incorrectos. Intento " + intentos + " de 3 intentos.");
                                vistaUsuario.imprimir("Acceso denegado");
                                break;
                            }
                        }
                        if (iniciarSesion) {
                            String tipoUsuario = listaUsuarios.verificarTipoUser(nameUsuario);
                            if ("usuario".equals(tipoUsuario)) {
                                while (!salir) {
                                    int opcionUsuario = vistaUsuario.interfazUsuario();
                                    switch (opcionUsuario) {
                                        case 1:
                                            vistaUsuario.imprimir("Datos del perfil");
                                            vistaUsuario.imprimir(listaUsuarios.imprimirPerfil(nameUsuario));
                                            break;
                                        case 2:
                                            String dato = vistaUsuario.datoActualizar();
                                            switch (dato.toLowerCase()) {
                                                case "nombre":
                                                    String nuevoName = vistaUsuario.nuevoNombre();
                                                    listaUsuarios.actualizarDatos(nameUsuario, dato, nuevoName);
                                                    break;
                                                case "usuario":
                                                    String nuevoUser;
                                                    boolean nombreUserDisponible;
                                                    do {
                                                        nombreUserDisponible = listaUsuarios.verificarNombreUsuario(nuevoUser = vistaUsuario.nuevoUsuario());
                                                        if (!nombreUserDisponible) {
                                                            vistaUsuario.imprimir("El nombre de usuario ya está en uso");
                                                        } else {
                                                            vistaUsuario.imprimir("Nombre de usuario disponible");
                                                        }
                                                    } while (!nombreUserDisponible);
                                                    listaUsuarios.actualizarDatos(nameUsuario, dato, nuevoUser);
                                                    break;
                                                case "correo":
                                                    String nuevoEmail;
                                                    boolean emailEncontrado;
                                                    do {
                                                        emailEncontrado = listaUsuarios.verificarCorreo(nuevoEmail = vistaUsuario.nuevoCorreo());
                                                        if (!emailEncontrado) {
                                                            vistaUsuario.imprimir("El correo ya está en uso");
                                                        }
                                                        boolean correoValido;
                                                        do {
                                                            correoValido = listaUsuarios.verificarCorreoValido(nuevoEmail);
                                                            if (correoValido) {
                                                                vistaUsuario.imprimir("Correo válido");
                                                            } else {
                                                                vistaUsuario.imprimir("Debe ingresar un correo válido");
                                                                nuevoEmail = vistaUsuario.correoRegis();
                                                            }
                                                        } while (!correoValido);
                                                    } while (!emailEncontrado);
                                                    listaUsuarios.actualizarDatos(nameUsuario, dato, nuevoEmail);
                                                    break;
                                                case "contraseña":
                                                    String nuevaClave;
                                                    regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!#$%&]).{8,}$";
                                                    do {
                                                        nuevaClave = vistaUsuario.nuevaContrasenia();
                                                        listaUsuarios.verificarContrasenia(nuevaClave);
                                                    } while (!nuevaClave.matches(regex) || nuevaClave.length() < 8);
                                                    listaUsuarios.actualizarDatos(nameUsuario, dato, nuevaClave);
                                                    break;
                                                default:
                                                    vistaUsuario.imprimir("Opción no válida.");
                                                    return;
                                            }
                                            vistaUsuario.imprimir("El dato se ha actualizado exitosamente");
                                            break;
                                        case 3:
                                            String user;
                                            boolean encontrado = listaUsuarios.verificarUser(user = vistaUsuario.buscarAmigo());
                                            if (!encontrado) {
                                                vistaUsuario.imprimir("Usuario no encontrado.");
                                            } else {
                                                vistaUsuario.imprimir("Datos del perfil");
                                                vistaUsuario.imprimir(listaUsuarios.imprimirPerfil(user));
                                            }
                                            break;
                                        case 4:
                                            int ingreso = test.tamanio();
                                            test.organizar();
                                            int llave = 0;
                                            for (int i = 0; i <ingreso; i++) {
                                                llave +=1;
                                                String numeropregunta = String.valueOf(llave);
                                                String in = String.valueOf(i);
                                                vistaAdmin.imprimir(test.examen(in,numeropregunta));
                                                vistaAdmin.imprimir(test.respuestas(in, vistaAdmin.respuestas()));
                                            }
                                            vistaAdmin.imprimir(test.cantidad());
                                            break;
                                        case 5:
                                            String respuesta = vistaUsuario.eliminarCuenta();
                                            if (listaUsuarios.eliminarCuenta(respuesta, nameUsuario)) {
                                                vistaUsuario.imprimir("La cuenta se ha eliminado");
                                                salir = true;
                                            } else {
                                                vistaUsuario.imprimir("La cuenta NO se ha eliminado");
                                            }
                                            break;
                                        case 6:
                                            String resp = vistaUsuario.desactivarCuenta();
                                            if (resp.equalsIgnoreCase("si")) {
                                                vistaUsuario.imprimir("La cuenta se ha desactivado");
                                                salir = true;
                                            } else {
                                                vistaUsuario.imprimir("La cuenta NO se ha eliminado");
                                            }
                                            break;
                                        case 7:
                                            vistaUsuario.imprimir( contenido.mostra());
                                            break;
                                        case 8:
                                            String termino = vistaAdmin.busc();
                                            boolean comprobado = contenido.comproba(termino);
                                            if (comprobado) {
                                                vistaAdmin.imprimir(contenido.mostrar(termino));
                                            }else{
                                                vistaAdmin.imprimir("Novedad no encontrada");
                                            }
                                            break;
                                        case 0:
                                            vistaUsuario.imprimir("Saliendo de la aplicación...");
                                            salir = true;
                                            break;
                                        default:
                                            vistaUsuario.imprimir("Escoja una opción válida");
                                            break;
                                    }
                                }
                            }else if ("admin".equals(tipoUsuario)){
                                while (!salir) {
                                    int opc = vistaAdmin.menu();
                                    switch (opc) {
                                        case 1:
                                            int c = vistaAdmin.test();
                                            switch (c) {
                                                case 1:
                                                    String dato = vistaAdmin.seleccion();
                                                    boolean comprobacion = test.comprobar(dato);
                                                    if (!comprobacion) {
                                                        vistaAdmin.imprimir("La pregunta no existe");
                                                    } else {
                                                        test.actualizar(dato, vistaAdmin.seleccio(), vistaAdmin.respuesta());
                                                        vistaAdmin.imprimir("Producto actualizado");
                                                    }
                                                    break;
                                                case 2:
                                                    String pregunta = vistaAdmin.id();
                                                    boolean comprobacio = test.comprobar(pregunta);

                                                    if (!comprobacio) {
                                                        Administrador ad = new Administrador("", vistaAdmin.preguntas(), vistaAdmin.respuestas1(), vistaAdmin.respuestas2(), vistaAdmin.respuestas3(), vistaAdmin.respuestas());
                                                        test.agregar(ad);
                                                    } else {
                                                        vistaAdmin.imprimir("La pregunta ya existe");
                                                    }
                                                    break;
                                                case 3:
                                                    pregunta = vistaAdmin.id();
                                                    comprobacio = test.comprobar(pregunta);
                                                    if (comprobacio) {
                                                        test.eliminar(pregunta);
                                                        vistaAdmin.imprimir("Pregunta eliminado");
                                                    } else {
                                                        vistaAdmin.imprimir("No existe la pregunta");
                                                    }
                                                    break;
                                                case 4:
                                                    pregunta = vistaAdmin.id();
                                                    comprobacio = test.comprobar(pregunta);
                                                    if (comprobacio) {
                                                        vistaUsuario.imprimir(test.busqueda(pregunta));
                                                    } else {
                                                        vistaAdmin.imprimir("La pregunta no existe");
                                                    }
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            vistaAdmin.imprimir(listaUsuarios.imprimirPerfil(vistaAdmin.usu()));
                                            break;
                                        case 3:
                                            int inicio = vistaAdmin.contenido();
                                            switch (inicio) {
                                                case 1:
                                                    String dato = vistaAdmin.actualizar();
                                                    boolean comprobacion = contenido.comproba(dato);
                                                    if (!comprobacion) {
                                                        vistaAdmin.imprimir("La novedad no existe");
                                                    } else {
                                                        int f = vistaAdmin.cambio();
                                                        String n = vistaAdmin.actualizado();
                                                        contenido.actualizar(dato, f, n);
                                                        vistaAdmin.imprimir("Producto actualizado");
                                                    }
                                                    break;
                                                case 2:
                                                    String pregunta = vistaAdmin.clave();
                                                    String tit = vistaAdmin.titulo();
                                                    String subt = vistaAdmin.subtitulo();
                                                    boolean comprobacio = contenido.comprobar(pregunta);
                                                    boolean comproba =contenido.comproba(tit);
                                                    boolean compro = contenido.comproba(subt);


                                                    if (!comprobacio || !comproba || !compro) {
                                                        Administrador ad = new Administrador(tit, subt, vistaAdmin.conten());
                                                        vistaAdmin.imprimir( contenido.agregar(pregunta, ad));
                                                    } else {
                                                        vistaAdmin.imprimir("La pregunta ya existe");
                                                    }
                                                    break;

                                                case 3:
                                                    dato = vistaAdmin.elim();
                                                    comprobacion = contenido.eliminarProducto(dato);
                                                    if (comprobacion){
                                                        vistaAdmin.imprimir("El producto fue eliminado");
                                                    }else{
                                                        vistaAdmin.imprimir("El producto no existe");
                                                    }
                                                case 4:
                                                    String termino = vistaAdmin.busc();
                                                    boolean comprobado = contenido.comproba(termino);
                                                    if (comprobado) {
                                                        vistaAdmin.imprimir(contenido.mostrar(termino));
                                                    }else{
                                                        vistaAdmin.imprimir("Novedad no encontrada");
                                                    }
                                            }
                                            break;
                                        case 0:
                                            salir = true;
                                            break;
                                        default:
                                            vistaAdmin.imprimir("Escoja una opción válida");
                                            break;
                                    }
                                }
                            }
                        }
                    } while (!iniciarSesion);
                    break;
                case 4:
                    vistaUsuario.imprimir("Saliendo de la aplicación...");
                    salir = true;
                    break;
                default:
                    vistaUsuario.imprimir("Escoja una opción válida");
                    break;
            }
        }
    }
}
