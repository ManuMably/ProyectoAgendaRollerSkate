
package proyectoagendaroller;

// imports de conexion a la base de datos
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Perfiles {
    // datos de conexion
    //acceso ala base de datos segun el nombre que tiene la base de datos
     public static final String ubicacion="jdbc:mysql://localhost/agendaroller";
    //
     //nombre del usuario
    public static final String usuario = "root";

    //contraseña del usuario aqui no tiene 
    public static final String contraseña = "";

    PreparedStatement ps;//esto es para poner hablar java con mysql sin esto no hay coneccion

    ResultSet rs;// esto es el resultado de una consulta

    public static com.mysql.jdbc.Connection getConnection(){//coneccion 

        com.mysql.jdbc.Connection con=null;

        try { //se utiliza para que no se presenten tanto errores

            Class.forName("com.mysql.jdbc.Driver");//coneccion de la libreria con la base de datos

            //esto ase la coneccion entre la base de datos y la aplicacion
            con= (com.mysql.jdbc.Connection) DriverManager.getConnection(ubicacion,usuario,contraseña);

        } catch (Exception e) {
            System.out.println(e);//imprime los errores 

        }

        return con;//finaliza la ejecucion

    }
    
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
    
    public int cargarDatosRegistrados(){
        com.mysql.jdbc.Connection con = null;

        try{
            con = getConnection();

            //este codigo busca por medio de select * from y la cedula del usuario
            ps= con.prepareStatement("SELECT * FROM usuarios WHERE TipoPerfil =1");


            rs= ps.executeQuery();//codigo para informacion de la base de datos
            while (rs.next()) { 
                usuariosInstructores[numeroInstructores] = new Instructor();
                usuariosInstructores[numeroInstructores].setNombre(rs.getString("Nombre"));
                usuariosInstructores[numeroInstructores].setCedula(Integer.parseInt(rs.getString("Documento")));
                usuariosInstructores[numeroInstructores].setCelular(Long.parseLong(rs.getString("Celular")));
                usuariosInstructores[numeroInstructores].setTipoDePerfil(Integer.parseInt(rs.getString("TipoPerfil")));
                usuariosInstructores[numeroInstructores].setDireccion(rs.getString("Direccion"));
                usuariosInstructores[numeroInstructores].setClaveAcceso(rs.getString("Clave"));
                usuariosInstructores[numeroInstructores].setPreguntaSeguridad(rs.getString("PreguntaSeguridad"));
                usuariosInstructores[numeroInstructores].setDiasDisponibles(rs.getString("DiasDisponibles").split(","));
                
                String[] diasDisponiblesMarca = rs.getString("DiasDisponiblesMarca").split(",");
                int[] marcacion = new int[diasDisponiblesMarca.length];

                for (int i = 0; i < diasDisponiblesMarca.length; i++) {
                    marcacion[i] = Integer.parseInt(diasDisponiblesMarca[i]);
                } 
                usuariosInstructores[numeroInstructores].setDiasDisponiblesMarca(marcacion);
                
                String[] horasDisponibles = rs.getString("HorasDisponibles").split(",");
                int[] horasDisp = new int[horasDisponibles.length];

                for (int i = 0; i < horasDisponibles.length; i++) {
                    horasDisp[i] = Integer.parseInt(horasDisponibles[i]);
                } 
                usuariosInstructores[numeroInstructores].setHorasDisponibles(horasDisp);
                
                
            }
            

        }catch(Exception e){
            System.err.println(e);
        }
    
        return -1;
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
    
    public static void registrarUsuario(Usuario usuarioNuevo) {
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
    public static Usuario buscarPerfilCedula(Usuario busqueda){
        
        for (Usuario usuario : usuariosRegistrados) {
            int cedulaUsuario = usuario.getCedula();
            int cedulaBusqueda = busqueda.getCedula();
            
            if (cedulaBusqueda == cedulaUsuario) {
                return usuario;   
            }   
        }
        
        // se  envia un usuario vacio en caso de no encontrar el de la bsuqueda
        Usuario noEncontrado = new Usuario();
        
        // el tipo de perfil 4 permite identificar los usuarios nulos cuanod no se encuentra algun usuario o es necesario identificarlo a lo largo del flujo
        noEncontrado.setTipoDePerfil(4);
        
        return noEncontrado;    
    }
    
    public static void modificarPerfilUsuario (Usuario modificado){
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getCedula()== modificado.getCedula() && usuario.getTipoDePerfil() == modificado.getTipoDePerfil()) {
                int tipoPerfilModificado = modificado.getTipoDePerfil();
                switch (tipoPerfilModificado) {
                    case 1:                      
                        
                        //se asginan los valores de instructor al usuario
                        usuario.setCelular(modificado.getCelular());
                        usuario.setNombre(modificado.getNombre());
                        usuario.setDireccion(modificado.getDireccion());
                        usuario.setClaveAcceso(modificado.getClaveAcceso());
                        usuario.setPreguntaSeguridad(modificado.getPreguntaSeguridad());
                        ((Instructor) usuario).setDiasDisponibles(((Instructor)modificado).getDiasDisponibles());
                        ((Instructor) usuario).setDiasDisponiblesMarca(((Instructor)modificado).getDiasDisponiblesMarca());
                        ((Instructor) usuario).setHorasDisponibles(((Instructor)modificado).getHorasDisponibles());
                        
                        break;
                    case 2:
                        
                        // se asignan los valores de alumno al usuario
                        usuario.setCelular(modificado.getCelular());
                        usuario.setNombre(modificado.getNombre());
                        usuario.setDireccion(modificado.getDireccion());
                        usuario.setClaveAcceso(modificado.getClaveAcceso());
                        usuario.setPreguntaSeguridad(modificado.getPreguntaSeguridad());
                        ((Alumno) usuario).setNivel(((Alumno)modificado).getNivel());
                        ((Alumno) usuario).setDiasClase(((Alumno)modificado).getDiasClase());
                        ((Alumno) usuario).setDiaClaseMarca(((Alumno)modificado).getDiaClaseMarca());
                        ((Alumno) usuario).setHoraClase(((Alumno)modificado).getHoraClase());                        
                        
                        break;
                    case 3:
                        
                        // se asignan los valores de administrador al usuario
                        usuario.setCelular(modificado.getCelular());
                        usuario.setNombre(modificado.getNombre());
                        usuario.setDireccion(modificado.getDireccion());
                        usuario.setClaveAcceso(modificado.getClaveAcceso());
                        usuario.setPreguntaSeguridad(modificado.getPreguntaSeguridad());
                        ((Administrador) usuario).setSegundaClave(((Administrador)modificado).getSegundaClave());
                        
                        
                        
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
        }
    
    }
    public static int ordenarUsuariosRegistrados(int opcion, int opcionaux){
        switch (opcion) {
            case 1:
                //Metodo ordenar los usuarios registrados por nombre uso del metodo burbuja de ordenamiento
                for (int i = 0; i < numeroUsuariosRegistrados - 1; i++) {
                    for (int j = 0; j < numeroUsuariosRegistrados - i - 1; j++) {
                        // Comparar los nombres de los usuarios y swap si es necesario
                        if (usuariosRegistrados[j].getNombre().compareTo(usuariosRegistrados[j + 1].getNombre()) > 0) {
                        // Intercambiar usuariosRegistrados[j] y usuariosRegistrados[j + 1]
                        Usuario temp = usuariosRegistrados[j];
                        usuariosRegistrados[j] = usuariosRegistrados[j + 1];
                        usuariosRegistrados[j + 1] = temp;
                        }
                    }
                }
                return 1;
            case 2:
                // con metodo burbuja ordenamos los usuarios registrados por su cedula
                for (int i = 0; i < numeroUsuariosRegistrados - 1; i++) {
                    for (int j = 0; j < numeroUsuariosRegistrados - i - 1; j++) {
                        // Comparar las cédulas de los usuarios y swap si es necesario
                        if (usuariosRegistrados[j].getCedula() > usuariosRegistrados[j + 1].getCedula()) {
                            // Intercambiar usuariosRegistrados[j] y usuariosRegistrados[j + 1]
                            Usuario temp = usuariosRegistrados[j];
                            usuariosRegistrados[j] = usuariosRegistrados[j + 1];
                            usuariosRegistrados[j + 1] = temp;
                        }
                    }
                }
                
                return 1;
            case 3:
                // ordenar solo de los alumnos
                switch (opcionaux) {
                    case 1:
                        //Metodo ordenar los alumnos registrados por nombre uso del metodo burbuja de ordenamiento
                        for (int i = 0; i < numeroAlumnos - 1; i++) {
                            for (int j = 0; j < numeroAlumnos - i - 1; j++) {
                                // Comparar los nombres de los usuarios y swap si es necesario
                                if (usuariosAlumnos[j].getNombre().compareTo(usuariosAlumnos[j + 1].getNombre()) > 0) {
                                // Intercambiar usuariosRegistrados[j] y usuariosRegistrados[j + 1]
                                Alumno temp = usuariosAlumnos[j];
                                usuariosAlumnos[j] = usuariosAlumnos[j + 1];
                                usuariosAlumnos[j + 1] = temp;
                                }
                            }
                        }
                        
                        return 1;
                    case 2:
                          //Metodo ordenar los alumnos registrados por nombre uso del metodo burbuja de ordenamiento
                          for (int i = 0; i < numeroAlumnos - 1; i++) {
                                for (int j = 0; j < numeroAlumnos - i - 1; j++) {
                                    // Comparar los nombres de los usuarios y swap si es necesario
                                    if (usuariosAlumnos[j].getNivel().compareTo(usuariosAlumnos[j + 1].getNivel()) > 0) {
                                    // Intercambiar usuariosRegistrados[j] y usuariosRegistrados[j + 1]
                                    Alumno temp = usuariosAlumnos[j];
                                    usuariosAlumnos[j] = usuariosAlumnos[j + 1];
                                    usuariosAlumnos[j + 1] = temp;
                                    }
                                }
                            }
                        
                        return 1;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        return -1;
                }
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            default:
                return -1;
        }
    
        return -1;
    }
    
}
