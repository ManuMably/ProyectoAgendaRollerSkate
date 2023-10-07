
package proyectoagendaroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Perfiles {
    // atributos correspondiestes para manipular los perfiles
    private static Usuario[] usuariosRegistrados = new Usuario[220];
    private static int numeroUsuariosRegistrados = 0;
    
    private static final int numeroInstructoresMax = 50;
    private static Instructor[] usuariosInstructores = new Instructor[numeroInstructoresMax];
    private static int numeroInstructores = 0;
    
    private static final int numeroAlumnosMax = 150;
    private static Alumno[] usuariosAlumnos = new Alumno[numeroAlumnosMax];
    private static int numeroAlumnos = 0;
    
    private static final int numeroAdministradoresMax = 20;
    private static Administrador[] usuariosAdministradores = new Administrador[numeroAdministradoresMax];
    private static int numeroAdministradores = 0;
            
    //-------------------------------------------
    
    // Getter para numeroUsuariosRegistrados
    public static int getNumeroUsuariosRegistrados() {
        return numeroUsuariosRegistrados;
    }
    // Setter para numeroUsuariosRegistrados
    public static void setNumeroUsuariosRegistrados(int numero) {
        numeroUsuariosRegistrados = numero;
    }
    
    // Getter para numeroInstructores
    public static int getNumeroInstructores() {
        return numeroInstructores;
    }
    // Setter para numeroInstructores
    public static void setNumeroInstructores(int numero) {
        numeroInstructores = numero;
    }
    
    
    // Getter para numeroAlumnos
    public static int getNumeroAlumnos() {
        return numeroAlumnos;
    }
    // Setter para numeroAlumnos
    public static void setNumeroAlumnos(int numero) {
        numeroAlumnos = numero;
    }
    
    // Getter para numeroAdministradores
    public static int getNumeroAdministradores() {
        return numeroAdministradores;
    }
    // Setter para numeroAdministradores
    public static void setNumeroAdministradores(int numero) {
        numeroAdministradores = numero;
    }
    // Getter para usuariosRegistrados
    public static Usuario[] getUsuariosRegistrados() {
        return usuariosRegistrados;
    }
    // Setter para usuariosRegistrados
    public static void setUsuariosRegistrados(Usuario[] usuariosRegistrados) {
        Perfiles.usuariosRegistrados = usuariosRegistrados;
    }

    // Getter para usuariosInstructores
    public static Instructor[] getUsuariosInstructores() {
        return usuariosInstructores;
    }
    // Setter para usuariosInstructores
    public static void setUsuariosInstructores(Instructor[] usuariosInstructores) {
        Perfiles.usuariosInstructores = usuariosInstructores;
    }

    // Getter para usuariosAlumnos
    public static Alumno[] getUsuariosAlumnos() {
        return usuariosAlumnos;
    }
    // Setter para usuariosAlumnos
    public static void setUsuariosAlumnos(Alumno[] usuariosAlumnos) {
        Perfiles.usuariosAlumnos = usuariosAlumnos;
    }

    // Getter para usuariosAdministradores
    public static Administrador[] getUsuariosAdministradores() {
        return usuariosAdministradores;
    }
    // Setter para usuariosAdministradores
    public static void setUsuariosAdministradores(Administrador[] usuariosAdministradores) {
        Perfiles.usuariosAdministradores = usuariosAdministradores;
    }
    
    public static void cargarUsuariosRegistrados(){
        // se guarda la direccion del archivo plano en un string
        String archivoUsuariosRegistrados = "C:\\Users\\ROGER\\Documents\\NetBeansProjects\\ProyectoAgendaRoller\\src\\proyectoagendaroller\\ArchivosPlanos\\usuariosRegistrados.txt";
        
        // try para manejo de exepciones
        try {
                //en una variable tipo File guardamos el archivo plano
                File archivoPlano = new File(archivoUsuariosRegistrados);
                
                //luego se lee el archivo plano
                Scanner leer = new Scanner(archivoPlano);
                
                //contador de cada linea 
                int contadorLineas = 0;
                
                while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                
                String[] vectorDatosDivididos = linea.split(";");
                
                //antes de emepezar a llenar los vectores con los objetos verificamos el tipo de perfil para diferenciarlos
                //variable que define el perfil de cada linea
                int perfilTipo = Integer.parseInt(vectorDatosDivididos[3]);
                    switch (perfilTipo) {
                        case 1 -> {
                            // en caso de que el tipo de perfil sea 1 que corresponde al perfil de alumnos
                            
                            //en la posicion del contador del numero de alumnos se va agregando el alumno en el arreglo desde el archivo plano
                            usuariosAlumnos[numeroAlumnos] = new Alumno();
                            usuariosAlumnos[numeroAlumnos].setNombre(vectorDatosDivididos[0]);
                            usuariosAlumnos[numeroAlumnos].setCedula(Integer.parseInt(vectorDatosDivididos[1]));
                            usuariosAlumnos[numeroAlumnos].setCelular(Long.parseLong(vectorDatosDivididos[2]));
                            usuariosAlumnos[numeroAlumnos].setTipoDePerfil(Integer.parseInt(vectorDatosDivididos[3]));
                            usuariosAlumnos[numeroAlumnos].setDireccion(vectorDatosDivididos[4]);
                            usuariosAlumnos[numeroAlumnos].setClaveAcceso(vectorDatosDivididos[5]);
                            usuariosAlumnos[numeroAlumnos].setPreguntaSeguridad(vectorDatosDivididos[6]);
                            usuariosAlumnos[numeroAlumnos].setNivel(vectorDatosDivididos[7]);
                            usuariosAlumnos[numeroAlumnos].setDiasClase(vectorDatosDivididos[8].split(","));
                            
                            //al ser un arreglo de numeros se deben almacenar y luego castear
                            String[] arregloNumerosAuxiliar =vectorDatosDivididos[9].split(",");
                            int[] arregloDeNumeros = new int[arregloNumerosAuxiliar.length];
                            // Convertir cada "numero" a un número int y almacenar en el arreglo
                            for (int i = 0; i < arregloNumerosAuxiliar.length; i++) {
                                arregloDeNumeros[i] = Integer.parseInt(arregloNumerosAuxiliar[i]);
                            }
                            //luego ese arreglo de numeros se almacena en la marca de los dias de clase que es un arreglo de numeros
                            usuariosAlumnos[numeroAlumnos].setDiaClaseMarca(arregloDeNumeros);
                            
                            //al ser un arreglo de numeros se deben almacenar y luego castear
                            String[] arregloNumerosAuxiliar2 =vectorDatosDivididos[10].split(",");
                            int[] arregloDeNumeros2 = new int[arregloNumerosAuxiliar2.length];
                            // Convertir cada "numero" a un número int y almacenar en el arreglo
                            for (int i = 0; i < arregloNumerosAuxiliar.length; i++) {
                                arregloDeNumeros2[i] = Integer.parseInt(arregloNumerosAuxiliar2[i]);
                            }
                            //luego ese arreglo de numeros se almacena en la marca de los dias de clase que es un arreglo de numeros
                            usuariosAlumnos[numeroAlumnos].setHoraClase(arregloDeNumeros2);
                            
                            
                            
                            //se agrega tambien a la lista general de usuarios registrados
                            usuariosRegistrados[numeroUsuariosRegistrados] = usuariosAlumnos[numeroAlumnos];
                            numeroUsuariosRegistrados++;
                            //se aumenta en la variable el numero de alumnos actual
                            numeroAlumnos++;
                            
                        }
                        case 2 -> {
                            // en caso de que el tipo de perfil sea 2 que corresponde a los instructores
                            
                            // en la posicion del contador del numero de instructores se va agregando el instructor desde el archivo plano
                            usuariosInstructores[numeroInstructores] = new Instructor();
                            usuariosInstructores[numeroInstructores].setNombre(vectorDatosDivididos[0]);
                            usuariosInstructores[numeroInstructores].setCedula(Integer.parseInt(vectorDatosDivididos[1]));
                            usuariosInstructores[numeroInstructores].setCelular(Long.parseLong(vectorDatosDivididos[2]));
                            usuariosInstructores[numeroInstructores].setTipoDePerfil(Integer.parseInt(vectorDatosDivididos[3]));
                            usuariosInstructores[numeroInstructores].setDireccion(vectorDatosDivididos[4]);
                            usuariosInstructores[numeroInstructores].setClaveAcceso(vectorDatosDivididos[5]);
                            usuariosInstructores[numeroInstructores].setPreguntaSeguridad(vectorDatosDivididos[6]);
                            usuariosInstructores[numeroInstructores].setDiasDisponibles(vectorDatosDivididos[7].split(","));
                            
                            //al ser un arreglo de numeros se deben almacenar y luego castear
                            String[] arregloNumerosAuxiliar3 =vectorDatosDivididos[8].split(",");
                            int[] arregloDeNumeros3 = new int[arregloNumerosAuxiliar3.length];
                            // Convertir cada "numero" a un número int y almacenar en el arreglo
                            for (int i = 0; i < arregloNumerosAuxiliar3.length; i++) {
                                arregloDeNumeros3[i] = Integer.parseInt(arregloNumerosAuxiliar3[i]);
                            }
                            //luego ese arreglo de numeros se almacena en la marca de los dias de clase que es un arreglo de numeros
                            usuariosInstructores[numeroInstructores].setDiasDisponiblesMarca(arregloDeNumeros3);
                            
                            //al ser un arreglo de numeros se deben almacenar y luego castear
                            String[] arregloNumerosAuxiliar4 =vectorDatosDivididos[9].split(",");
                            int[] arregloDeNumeros4 = new int[arregloNumerosAuxiliar4.length];
                            // Convertir cada "numero" a un número int y almacenar en el arreglo
                            for (int i = 0; i < arregloNumerosAuxiliar4.length; i++) {
                                arregloDeNumeros4[i] = Integer.parseInt(arregloNumerosAuxiliar4[i]);
                            }
                            //luego ese arreglo de numeros se almacena en la marca de los dias de clase que es un arreglo de numeros
                            usuariosInstructores[numeroInstructores].setHorasDisponibles(arregloDeNumeros4);
                            
                            
                            //se agrega tambien a la lista general de usuarios registrados
                            usuariosRegistrados[numeroUsuariosRegistrados] = usuariosInstructores[numeroInstructores];
                            numeroUsuariosRegistrados++;
                            // se aumenta en la variable el numero de instructores actucal
                            numeroInstructores++;
                            
                            
                        }
                        case 3 -> {
                            // en caso de que el tipo de perfil sea 3 que corresponde a los Administradores
                            
                            // en la posicion del contador del numero de instructores se va agregando el instructor desde el archivo plano
                            usuariosAdministradores[numeroAdministradores] = new Administrador();
                            usuariosAdministradores[numeroAdministradores].setNombre(vectorDatosDivididos[0]);
                            usuariosAdministradores[numeroAdministradores].setCedula(Integer.parseInt(vectorDatosDivididos[1]));
                            usuariosAdministradores[numeroAdministradores].setCelular(Long.parseLong(vectorDatosDivididos[2]));
                            usuariosAdministradores[numeroAdministradores].setTipoDePerfil(Integer.parseInt(vectorDatosDivididos[3]));
                            usuariosAdministradores[numeroAdministradores].setDireccion(vectorDatosDivididos[4]);
                            usuariosAdministradores[numeroAdministradores].setClaveAcceso(vectorDatosDivididos[5]);
                            usuariosAdministradores[numeroAdministradores].setPreguntaSeguridad(vectorDatosDivididos[6]);
                            usuariosAdministradores[numeroAdministradores].setSegundaClave(vectorDatosDivididos[7]);
                            
                            //se agrega tambien a la lista general de usuarios registrados
                            usuariosRegistrados[numeroUsuariosRegistrados] = usuariosAdministradores[numeroAdministradores];
                            numeroUsuariosRegistrados++;
                            // se aumenta en la variable el numero de Administradores actucal
                            numeroAdministradores++;
                            
                            
                        }
                        default -> throw new AssertionError("no se encuentra el tipo en esta linea.");
                    }              
                }
                
                // Cerrar el scanner después de la lectura
                leer.close();
        }catch(FileNotFoundException e){
            System.err.println("El archivo '" + archivoUsuariosRegistrados + "' no se encontró.");
        }
    }
    
    
    public static String mostrarDatosUsuariosRegistrados() {
    StringBuilder mensaje = new StringBuilder(); // Usamos un StringBuilder para construir la cadena acumulativa

    for (int i = 0; i < numeroUsuariosRegistrados; i++) {
        mensaje.append("Nombre Usuario: ").append(usuariosRegistrados[i].getNombre()).append("\n")
            .append("Cedula Usuario: ").append(usuariosRegistrados[i].getCedula()).append("\n")
            .append("Celular Usuario: ").append(usuariosRegistrados[i].getCelular()).append("\n")
            .append("Tipo Usuario: ").append(usuariosRegistrados[i].getTipoDePerfil()).append("\n")
            .append("Direccion Usuario: ").append(usuariosRegistrados[i].getDireccion()).append("\n")
            .append("Clave Usuario: ").append(usuariosRegistrados[i].getClaveAcceso()).append("\n")
            .append("Pregunta Seguridad: ").append(usuariosRegistrados[i].getPreguntaSeguridad()).append("\n");

        // Añade más atributos específicos de cada tipo de usuario (alumno, instructor, administrador) según sea necesario
        if (usuariosRegistrados[i] instanceof Alumno) {
            // Agrega los atributos específicos de Alumno
            mensaje.append("Nivel Usuario: ").append(((Alumno) usuariosRegistrados[i]).getNivel()).append("\n");
            mensaje.append("Dias Clase Usuario: ").append(String.join(",", ((Alumno) usuariosRegistrados[i]).getDiasClase())).append("\n");
            mensaje.append("Marc Clase Usuario: ").append(String.join(",", Arrays.stream(((Alumno) usuariosRegistrados[i]).getDiaClaseMarca()).mapToObj(Integer::toString).toArray(String[]::new))).append("\n");
            mensaje.append("Hora Clase Usuario: ").append(String.join(",", Arrays.stream(((Alumno) usuariosRegistrados[i]).getHoraClase()).mapToObj(Integer::toString).toArray(String[]::new))).append("\n");

        } else if (usuariosRegistrados[i] instanceof Instructor) {
            // Agrega los atributos específicos de Instructor
            mensaje.append("Dias Disponible Usuario: ").append(String.join(",", ((Instructor) usuariosRegistrados[i]).getDiasDisponibles())).append("\n");
            mensaje.append("Marc Disponible Usuario: ").append(String.join(",", Arrays.stream(((Instructor) usuariosRegistrados[i]).getDiasDisponiblesMarca()).mapToObj(Integer::toString).toArray(String[]::new))).append("\n");
            mensaje.append("Hora Disponible Usuario: ").append(String.join(",", Arrays.stream(((Instructor) usuariosRegistrados[i]).getHorasDisponibles()).mapToObj(Integer::toString).toArray(String[]::new))).append("\n");

        } else if (usuariosRegistrados[i] instanceof Administrador) {
            // Agrega los atributos específicos de Administrador
            mensaje.append("Segunda Clave Usuario: ").append(((Administrador) usuariosRegistrados[i]).getSegundaClave()).append("\n");
        }
        // Agrega una línea en blanco entre cada usuario
        mensaje.append("\n");
    }

        return mensaje.toString();
    }
    
    public static void actualizarUsuariosRegistrados() {
    // Primero, reiniciamos el contador de usuarios registrados a 0
    numeroUsuariosRegistrados = 0;

    // Luego, copiamos los usuarios de cada tipo al arreglo usuariosRegistrados
    for (int i = 0; i < numeroAlumnos; i++) {
        usuariosRegistrados[numeroUsuariosRegistrados] = usuariosAlumnos[i];
        numeroUsuariosRegistrados++;
    }

    for (int i = 0; i < numeroInstructores; i++) {
        usuariosRegistrados[numeroUsuariosRegistrados] = usuariosInstructores[i];
        numeroUsuariosRegistrados++;
    }

    for (int i = 0; i < numeroAdministradores; i++) {
        usuariosRegistrados[numeroUsuariosRegistrados] = usuariosAdministradores[i];
        numeroUsuariosRegistrados++;
    }
}
    
    public static void guardarUsuariosRegistrados() {
    String archivoUsuariosRegistrados = "C:\\Users\\ROGER\\Documents\\NetBeansProjects\\ProyectoAgendaRoller\\src\\proyectoagendaroller\\ArchivosPlanos\\usuariosRegistrados.txt";

    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoUsuariosRegistrados))) {
        for (int i = 0; i < numeroUsuariosRegistrados; i++) {
            Usuario usuario = usuariosRegistrados[i];
            String linea = usuario.getNombre() + ";"
                    + usuario.getCedula() + ";"
                    + usuario.getCelular() + ";"
                    + usuario.getTipoDePerfil() + ";"
                    + usuario.getDireccion() + ";"
                    + usuario.getClaveAcceso() + ";"
                    + usuario.getPreguntaSeguridad() + ";";

            if (usuario instanceof Alumno) {
                Alumno alumno = (Alumno) usuario;
                linea += alumno.getNivel() + ";";
                linea += String.join(",", alumno.getDiasClase()) + ";";
                linea += String.join(",", Arrays.stream(alumno.getDiaClaseMarca()).mapToObj(Integer::toString).toArray(String[]::new)) + ";";
                linea += String.join(",", Arrays.stream(alumno.getHoraClase()).mapToObj(Integer::toString).toArray(String[]::new)) + ";";
            } else if (usuario instanceof Instructor) {
                Instructor instructor = (Instructor) usuario;
                linea += String.join(",", instructor.getDiasDisponibles()) + ";";
                linea += String.join(",", Arrays.stream(instructor.getDiasDisponiblesMarca()).mapToObj(Integer::toString).toArray(String[]::new)) + ";";
                linea += String.join(",", Arrays.stream(instructor.getHorasDisponibles()).mapToObj(Integer::toString).toArray(String[]::new)) + ";";
            } else if (usuario instanceof Administrador) {
                Administrador administrador = (Administrador) usuario;
                linea += administrador.getSegundaClave() + ";";
            }

            escritor.write(linea);
            escritor.newLine();
        }

        System.out.println("Usuarios registrados guardados en el archivo.");
    } catch (IOException e) {
        System.err.println("Error al guardar usuarios registrados en el archivo: " + e.getMessage());
    }
}
    
    public static void insertarUsuarios(Usuario usuarioNuevo) {
    if (usuarioNuevo instanceof Alumno) {
        Alumno alumnoNuevo = (Alumno) usuarioNuevo;

        int nuevoTamano = numeroAlumnos + 1;
        Alumno[] nuevoArreglo = new Alumno[nuevoTamano];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArreglo[0] = alumnoNuevo;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(usuariosAlumnos, 0, nuevoArreglo, 1, numeroAlumnos);

        usuariosAlumnos = nuevoArreglo;
        numeroAlumnos = nuevoTamano;

    } else if (usuarioNuevo instanceof Instructor) {
        Instructor instructorNuevo = (Instructor) usuarioNuevo;

        int nuevoTamano = numeroInstructores + 1;
        Instructor[] nuevoArreglo = new Instructor[nuevoTamano];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArreglo[0] = instructorNuevo;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(usuariosInstructores, 0, nuevoArreglo, 1, numeroInstructores);

        usuariosInstructores = nuevoArreglo;
        numeroInstructores = nuevoTamano;

    } else if (usuarioNuevo instanceof Administrador) {
        Administrador administradorNuevo = (Administrador) usuarioNuevo;

        int nuevoTamano = numeroAdministradores + 1;
        Administrador[] nuevoArreglo = new Administrador[nuevoTamano];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArreglo[0] = administradorNuevo;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(usuariosAdministradores, 0, nuevoArreglo, 1, numeroAdministradores);

        usuariosAdministradores = nuevoArreglo;
        numeroAdministradores = nuevoTamano;
    }
}
}
