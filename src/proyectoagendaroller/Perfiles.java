
package proyectoagendaroller;

// imports de conexion a la base de datos
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import java.sql.Types;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import java.util.Comparator;

//import javax.lang.model.util.Types;

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
    
    public static Usuario logueado = new Usuario();
    //-------------------------------------------
    public static void logeadoUsuario(Usuario logueadoU) {
        logueado = logueadoU;
    }

    public static Usuario getLogueado() {
        return logueado;
    }
    
    
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

            //este codigo busca por medio de select * from y el tipo de perfil de lusuario en este caso es para los instructores
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
                
                //se agrega tambien a la lista general de usuarios registrados
                            usuariosRegistrados[numeroUsuariosRegistrados] = usuariosInstructores[numeroInstructores];
                            numeroUsuariosRegistrados++;
                //se aumenta en la variable el numero de instructore actual
                            numeroInstructores++;
                
                
            }
            //este codigo busca por medio de select * from y el tipo de perfil del usuario en este caso para los alumnos
            ps= con.prepareStatement("SELECT * FROM usuarios WHERE TipoPerfil =2");


            rs= ps.executeQuery();//codigo para informacion de la base de datos
            while (rs.next()) { 
                usuariosAlumnos[numeroAlumnos] = new Alumno();
                usuariosAlumnos[numeroAlumnos].setNombre(rs.getString("Nombre"));
                usuariosAlumnos[numeroAlumnos].setCedula(Integer.parseInt(rs.getString("Documento")));
                usuariosAlumnos[numeroAlumnos].setCelular(Long.parseLong(rs.getString("Celular")));
                usuariosAlumnos[numeroAlumnos].setTipoDePerfil(Integer.parseInt(rs.getString("TipoPerfil")));
                usuariosAlumnos[numeroAlumnos].setDireccion(rs.getString("Direccion"));
                usuariosAlumnos[numeroAlumnos].setClaveAcceso(rs.getString("Clave"));
                usuariosAlumnos[numeroAlumnos].setPreguntaSeguridad(rs.getString("PreguntaSeguridad"));
                usuariosAlumnos[numeroAlumnos].setNivel(rs.getString("Nivel"));
                usuariosAlumnos[numeroAlumnos].setDiasClase(rs.getString("DiasClase").split(","));
                
                String[] diasClaseMarca = rs.getString("DiasMarca").split(",");
                int[] marcacion = new int[diasClaseMarca.length];

                for (int i = 0; i < diasClaseMarca.length; i++) {
                    marcacion[i] = Integer.parseInt(diasClaseMarca[i]);
                } 
                usuariosAlumnos[numeroAlumnos].setDiaClaseMarca(marcacion);
                
                String[] horaClase = rs.getString("HorasClase").split(",");
                int[] horasClase = new int[horaClase.length];

                for (int i = 0; i < horaClase.length; i++) {
                    horasClase[i] = Integer.parseInt(horaClase[i]);
                } 
                usuariosAlumnos[numeroAlumnos].setHoraClase(horasClase);
                
                //se agrega tambien a la lista general de usuarios registrados
                            usuariosRegistrados[numeroUsuariosRegistrados] = usuariosAlumnos[numeroAlumnos];
                            numeroUsuariosRegistrados++;
                //se aumenta en la variable el numero de Alumnos actual
                            numeroAlumnos++;
                
                
            }
            
            //este codigo busca por medio de select * from y el tipo de perfil del usuario en este caso para los administradores
            ps= con.prepareStatement("SELECT * FROM usuarios WHERE TipoPerfil =3");


            rs= ps.executeQuery();//codigo para informacion de la base de datos
            while (rs.next()) { 
                usuariosAdministradores[numeroAdministradores] = new Administrador();
                usuariosAdministradores[numeroAdministradores].setNombre(rs.getString("Nombre"));
                usuariosAdministradores[numeroAdministradores].setCedula(Integer.parseInt(rs.getString("Documento")));
                usuariosAdministradores[numeroAdministradores].setCelular(Long.parseLong(rs.getString("Celular")));
                usuariosAdministradores[numeroAdministradores].setTipoDePerfil(Integer.parseInt(rs.getString("TipoPerfil")));
                usuariosAdministradores[numeroAdministradores].setDireccion(rs.getString("Direccion"));
                usuariosAdministradores[numeroAdministradores].setClaveAcceso(rs.getString("Clave"));
                usuariosAdministradores[numeroAdministradores].setPreguntaSeguridad(rs.getString("PreguntaSeguridad"));
                usuariosAdministradores[numeroAdministradores].setSegundaClave(rs.getString("SegundaClave"));

                
                //se agrega tambien a la lista general de usuarios registrados
                            usuariosRegistrados[numeroUsuariosRegistrados] = usuariosAdministradores[numeroAdministradores];
                            numeroUsuariosRegistrados++;
                //se aumenta en la variable el numero de Alumnos actual
                            numeroAdministradores++;
                
            }
            
                return 1;
        }catch(Exception e){
            System.err.println(e);
        }
    
        return -1;
    }
    
    public void guardarUsuariosRegistrados() {
    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = getConnection();

        // Aplicación de PreparedStatement para SELECT
        String selectQuery = "SELECT * FROM usuarios WHERE Documento = ?";
        PreparedStatement psSelect = con.prepareStatement(selectQuery);

        // Aplicación de PreparedStatement para INSERT
        String insertQuery = "INSERT INTO usuarios (Documento, Nombre, Celular, TipoPerfil, Direccion, Clave, PreguntaSeguridad, DiasDisponibles, DiasDisponiblesMarca, HorasDisponibles, Nivel, DiasClase, DiasMarca, HorasClase, SegundaClave) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(insertQuery);

        for (int i = 0; i < numeroUsuariosRegistrados; i++) {
            Usuario usuario = usuariosRegistrados[i];

            // Verificar si el usuario ya existe
            psSelect.setString(1, Integer.toString(usuario.getCedula()));
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                // Usuario ya existe, omitir la inserción
                System.out.println("Usuario con Documento " + usuario.getCedula() + " ya existe. Omitiendo la inserción.");
            } else {
                // Usuario no existe, proceder con la inserción
                // Establecer los valores de los parámetros del PreparedStatement para la inserción
                ps.setString(1, Integer.toString(usuario.getCedula()));
                ps.setString(2, usuario.getNombre());
                ps.setString(3, Long.toString(usuario.getCelular()));
                ps.setString(4, Integer.toString(usuario.getTipoDePerfil()));
                ps.setString(5, usuario.getDireccion());
                ps.setString(6, usuario.getClaveAcceso());
                ps.setString(7, usuario.getPreguntaSeguridad());

                if (usuario instanceof Instructor) {
                    Instructor instructor = (Instructor) usuario;
                    ps.setString(8, String.join(",", instructor.getDiasDisponibles()));
                    ps.setString(9, String.join(",", Arrays.stream(instructor.getDiasDisponiblesMarca()).mapToObj(Integer::toString).toArray(String[]::new)));
                    ps.setString(10, String.join(",", Arrays.stream(instructor.getHorasDisponibles()).mapToObj(Integer::toString).toArray(String[]::new)));
                } else if (usuario instanceof Alumno) {
                    Alumno alumno = (Alumno) usuario;
                    ps.setNull(8, Types.VARCHAR); // DíasDisponibles no aplicable a Alumno
                    ps.setNull(9, Types.VARCHAR); // DíasDisponiblesMarca no aplicable a Alumno
                    ps.setNull(10, Types.VARCHAR); // HorasDisponibles no aplicable a Alumno
                    ps.setString(11, alumno.getNivel());
                    ps.setString(12, String.join(",", alumno.getDiasClase()));
                    ps.setString(13, String.join(",", Arrays.stream(alumno.getDiaClaseMarca()).mapToObj(Integer::toString).toArray(String[]::new)));
                    ps.setString(14, String.join(",", Arrays.stream(alumno.getHoraClase()).mapToObj(Integer::toString).toArray(String[]::new)));
                } else if (usuario instanceof Administrador) {
                    Administrador administrador = (Administrador) usuario;
                    ps.setNull(8, Types.VARCHAR); // DíasDisponibles no aplicable a Administrador
                    ps.setNull(9, Types.VARCHAR); // DíasDisponiblesMarca no aplicable a Administrador
                    ps.setNull(10, Types.VARCHAR); // HorasDisponibles no aplicable a Administrador
                    ps.setNull(11, Types.INTEGER); // Nivel no aplicable a Administrador
                    ps.setNull(12, Types.VARCHAR); // DíasClase no aplicable a Administrador
                    ps.setNull(13, Types.VARCHAR); // DíasMarca no aplicable a Administrador
                    ps.setNull(14, Types.VARCHAR); // HorasClase no aplicable a Administrador
                    ps.setString(15, administrador.getSegundaClave());
                }

                // Ejecutar la consulta de inserción
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Inserción exitosa para el usuario con Documento " + usuario.getCedula());
                } else {
                    System.out.println("La inserción no tuvo éxito para el usuario con Documento " + usuario.getCedula());
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar PreparedStatements y Connection en el bloque finally
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public static String[] listadoInstructores() {
    String[] listado = new String[numeroInstructores];

    for (int i = 0; i < numeroInstructores; i++) {
        Instructor instructor = usuariosInstructores[i];
        String nombreInstructor = instructor.getNombre();
        String cedulaInstructor = String.valueOf(instructor.getCedula());
        listado[i] = "nombre: " + nombreInstructor +", Cedula: " + cedulaInstructor;
    }

    return listado;
}
    public static String[] listadoAlumnos() {
    String[] listado = new String[numeroAlumnos];

    for (int i = 0; i < numeroAlumnos; i++) {
        Alumno alumno = usuariosAlumnos[i];
        String nombreAlumno = alumno.getNombre();
        String cedulaAlumno = String.valueOf(alumno.getCedula());
        listado[i] = "nombre: " + nombreAlumno +", Cedula: " + cedulaAlumno;
    }

    return listado;
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
        // para que tambien lo registre a la lista general de usuarios registrados

        int nuevoTamanoUR = numeroUsuariosRegistrados + 1;
        Usuario[] nuevoArregloUR = new Usuario[nuevoTamanoUR];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArregloUR[0] = alumnoNuevo;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(usuariosRegistrados, 0, nuevoArregloUR, 1, numeroUsuariosRegistrados);

        usuariosRegistrados = nuevoArregloUR;
        numeroUsuariosRegistrados = nuevoTamanoUR;

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
        // para que tambien lo registre a la lista general de usuarios registrados

        int nuevoTamanoUR = numeroUsuariosRegistrados + 1;
        Usuario[] nuevoArregloUR = new Usuario[nuevoTamanoUR];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArregloUR[0] = instructorNuevo;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(usuariosRegistrados, 0, nuevoArregloUR, 1, numeroUsuariosRegistrados);

        usuariosRegistrados = nuevoArregloUR;
        numeroUsuariosRegistrados = nuevoTamanoUR;

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
        
        // para que tambien lo registre a la lista general de usuarios registrados

        int nuevoTamanoUR = numeroUsuariosRegistrados + 1;
        Usuario[] nuevoArregloUR = new Usuario[nuevoTamanoUR];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArregloUR[0] = administradorNuevo;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(usuariosRegistrados, 0, nuevoArregloUR, 1, numeroUsuariosRegistrados);

        usuariosRegistrados = nuevoArregloUR;
        numeroUsuariosRegistrados = nuevoTamanoUR;
    }
}
    public static Usuario buscarPerfilCedula(int busqueda){
        
        for (Usuario usuario : usuariosRegistrados) {
            int cedulaUsuario = usuario.getCedula();
            int cedulaBusqueda = busqueda;
            
            if (cedulaBusqueda == cedulaUsuario) {
                return usuario;   
            }   
        }
        
        // se  envia un usuario vacio en caso de no encontrar el de la bsuqueda
        Usuario noEncontrado = new Usuario();
        
        // el tipo de perfil 4 permite identificar los usuarios nulos cuanod no se encuentra algun usuario o es necesario identificarlo a lo largo del flujo
        noEncontrado.setTipoDePerfil(4);
        noEncontrado.setCedula(4);
        noEncontrado.setPreguntaSeguridad("1");
        noEncontrado.setNombre("4");
        noEncontrado.setCelular(4);
        noEncontrado.setDireccion("4");
        noEncontrado.setClaveAcceso("4");
        
        
                
        
        return noEncontrado;    
    }
    public static Usuario buscarPerfilNombre(String busqueda){
        
        for (Usuario usuario : usuariosRegistrados) {
            String nombreUsuario = usuario.getNombre();
            String nombreBusqueda = busqueda;
            
            if (nombreUsuario == nombreBusqueda) {
                return usuario;   
            }   
        }
        
        // se  envia un usuario vacio en caso de no encontrar el de la bsuqueda
        Usuario noEncontrado = new Usuario();
        
        // el tipo de perfil 4 permite identificar los usuarios nulos cuanod no se encuentra algun usuario o es necesario identificarlo a lo largo del flujo
        noEncontrado.setTipoDePerfil(4);
        
        return noEncontrado;    
    }
    public static String[] nombresInstructores(){
        Instructor[] listaActual = Perfiles.getUsuariosInstructores();
        int tamanoListaActual= Perfiles.getNumeroInstructores();
        String[] nombresInstructores = new String[tamanoListaActual];
        // Llenar el array con los nombres de los instructores
        for (int i = 0; i < tamanoListaActual; i++) {
            nombresInstructores[i] = listaActual[i].getNombre();  // Cambia esto según la propiedad que desees obtener
        }
        return nombresInstructores;
    
    }
    
    public static void modificarPerfilUsuario (Usuario modificado){
        System.out.println("Valor de modificado: " + modificado.toString());
        for (int i = 0; i < numeroUsuariosRegistrados - 1; i++) {
            if (usuariosRegistrados[i].getCedula()== modificado.getCedula()) {
                        //se asginan los valores al usuario
                        usuariosRegistrados[i].setCelular(modificado.getCelular());
                        usuariosRegistrados[i].setNombre(modificado.getNombre());
                        usuariosRegistrados[i].setDireccion(modificado.getDireccion());
                        if (modificado.getPreguntaSeguridad()== usuariosRegistrados[i].getPreguntaSeguridad()) {
                            usuariosRegistrados[i].setClaveAcceso(modificado.getClaveAcceso());                    
                }                    
            }
            
        }
        
        //public void modificarUsuarioEnBaseDeDatos(int cedula, String nuevoNombre, long nuevoCelular, String nuevaDireccion) {
        Connection con = null;
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;

        try {
            con = getConnection();

            // Aplicación de PreparedStatement para SELECT
            String selectQuery = "SELECT * FROM usuarios WHERE Documento = ?";
            psSelect = con.prepareStatement(selectQuery);
            psSelect.setInt(1, modificado.getCedula());
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                // Usuario encontrado, proceder con la modificación
                String updateQuery = "UPDATE usuarios SET Nombre = ?, Celular = ?, Direccion = ?, Clave = ? WHERE Documento = ?";
                psUpdate = con.prepareStatement(updateQuery);
                psUpdate.setString(1, modificado.getNombre());
                psUpdate.setLong(2, modificado.getCelular());
                psUpdate.setString(3, modificado.getDireccion());
                psUpdate.setString(4, modificado.getClaveAcceso());
                psUpdate.setInt(5, modificado.getCedula());
                

                // Ejecutar la consulta de actualización
                int filasAfectadas = psUpdate.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Modificación exitosa para el usuario con Documento " + modificado.getCedula());
                } else {
                    System.out.println("La modificación no tuvo éxito para el usuario con Documento " + modificado.getCedula());
                }
            } else {
                // Usuario no encontrado
                System.out.println("Usuario con Documento " + modificado.getCedula() + " no encontrado. No se realizó ninguna modificación.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar PreparedStatements y Connection en el bloque finally
            try {
                if (psSelect != null) {
                    psSelect.close();
                }
                if (psUpdate != null) {
                    psUpdate.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
    
    /*ordenarUsuariosRegistrados (se debe tener en cuenta todos los casos especiales.. nombre - dias ...)--- pendiente
    este metodo recibira un numero que correspondera al tipo de ordenamiento que el sistema hara.
    devolvera una confirmacion cuando el ordenamiento se haya jecutado para que otra accion muestre
    los cambios realizados
           1- nombre // listo falta prueba
           2- cedula // listo falta prueba
           3- solo alumnos nombre // listo falta prueba
           3- solo alumnos nivel // listo falta prueba
           3- solo alumnos horas clase // listo falta prueba
           4- solo instructores nombre// listo falta prueba
           4- solo instructores horas disponibles // listo falta prueba
           5- solo administradores nombre// listo falta pruebas*/
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
                          //Metodo ordenar los alumnos registrados por nivel uso del metodo burbuja de ordenamiento
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
                        // Filtrar los alumnos no nulos y calcular la suma de horas de clase
                        Alumno[] alumnosFiltrados = Arrays.copyOfRange(usuariosAlumnos, 0, numeroAlumnos);
                        Arrays.sort(alumnosFiltrados, Comparator.comparingInt(Alumno::obtenerSumaHorasClase).reversed());

                        // Actualizar la lista de alumnos ordenada
                        for (int i = 0; i < numeroAlumnos; i++) {
                        usuariosAlumnos[i] = alumnosFiltrados[i];
        }
                        

                        return 1;
                    default:
                        return -1;
                }
            case 4:
                switch (opcionaux) {
                    case 1:
                        //Metodo ordenar los Instructores registrados por nombre uso del metodo burbuja de ordenamiento
                        for (int i = 0; i < numeroInstructores - 1; i++) {
                            for (int j = 0; j < numeroInstructores - i - 1; j++) {
                                // Comparar los nombres de los usuarios y swap si es necesario
                                if (usuariosInstructores[j].getNombre().compareTo(usuariosInstructores[j + 1].getNombre()) > 0) {
                                // Intercambiar usuariosInstructores[j] y usuariosInstructores[j + 1]
                                Instructor temp = usuariosInstructores[j];
                                usuariosInstructores[j] = usuariosInstructores[j + 1];
                                usuariosInstructores[j + 1] = temp;
                                }
                            }
                        }
                        
                        return 1;
                    case 2:
                        // Filtrar los instructores no nulos y calcular la suma de horas de clase
                        Instructor[] instructoresFiltrados = Arrays.copyOfRange(usuariosInstructores, 0, numeroInstructores);
                        Arrays.sort(instructoresFiltrados, Comparator.comparingInt(Instructor::obtenerSumaHorasDisponibles).reversed());

                        // Actualizar la lista de alumnos ordenada
                        for (int i = 0; i < numeroInstructores; i++) {
                        usuariosInstructores[i] = instructoresFiltrados[i];
                        }
                        

                        return 1;
                        
                    default:
                        return -1;
                }
                
            case 5:
                //Metodo ordenar los Administradores registrados por nombre uso del metodo burbuja de ordenamiento
                        for (int i = 0; i < numeroAdministradores - 1; i++) {
                            for (int j = 0; j < numeroAdministradores - i - 1; j++) {
                                // Comparar los nombres de los usuarios y swap si es necesario
                                if (usuariosAdministradores[j].getNombre().compareTo(usuariosAdministradores[j + 1].getNombre()) > 0) {
                                // Intercambiar usuariosAdministradores[j] y usuariosAdministradores[j + 1]
                                Administrador temp = usuariosAdministradores[j];
                                usuariosAdministradores[j] = usuariosAdministradores[j + 1];
                                usuariosAdministradores[j + 1] = temp;
                                }
                            }
                        }
                        
                        return 1;
            default:
                return -1;
        }
    }
    
    public int borrarUsuario(int cedula){    
    
    // Buscar el usuario en los arreglos
    Usuario usuarioABorrar = buscarPerfilCedula(cedula);

    // Verificar si el usuario fue encontrado
    if (usuarioABorrar.getTipoDePerfil() != 4) {
        // Usuario encontrado, proceder con el borrado de los arreglos
        // primero borrar de la lista general
        for (int i = 0; i < numeroUsuariosRegistrados; i++) {
                    if (usuariosRegistrados[i].getCedula() == usuarioABorrar.getCedula()) {
                        // Encontrar la posición del usuario y borrarlo del arreglo
                        System.arraycopy(usuariosRegistrados, i + 1, usuariosRegistrados, i, numeroUsuariosRegistrados - i - 1);
                        usuariosRegistrados[numeroUsuariosRegistrados - 1] = null;
                        numeroUsuariosRegistrados--;
                    }
                }
        if (usuarioABorrar instanceof Instructor) {
                for (int i = 0; i < numeroInstructores; i++) {
                    if (usuariosInstructores[i].getCedula() == usuarioABorrar.getCedula()) {
                        // Encontrar la posición del usuario y borrarlo del arreglo
                        System.arraycopy(usuariosInstructores, i + 1, usuariosInstructores, i, numeroInstructores - i - 1);
                        usuariosInstructores[numeroInstructores - 1] = null;
                        numeroInstructores--;
                        
                    }
                }
                
        } else if (usuarioABorrar instanceof Alumno) {
            for (int i = 0; i < numeroAlumnos; i++) {
                    if (usuariosAlumnos[i].getCedula() == usuarioABorrar.getCedula()) {
                        // Encontrar la posición del usuario y borrarlo del arreglo
                        System.arraycopy(usuariosAlumnos, i + 1, usuariosAlumnos, i, numeroAlumnos - i - 1);
                        usuariosAlumnos[numeroAlumnos - 1] = null;
                        numeroAlumnos--;
                        
                    }
                }
                
        } else if (usuarioABorrar instanceof Administrador) {
            for (int i = 0; i < numeroAdministradores; i++) {
                    if (usuariosAdministradores[i].getCedula() == usuarioABorrar.getCedula()) {
                        // Encontrar la posición del usuario y borrarlo del arreglo
                        System.arraycopy(usuariosAdministradores, i + 1, usuariosAdministradores, i, numeroAdministradores - i - 1);
                        usuariosAdministradores[numeroAdministradores - 1] = null;
                        numeroAdministradores--;
                        
                    }
                }
        }
        Connection con = null;
        PreparedStatement psDelete = null;

        try {
            con = getConnection();

            // Aplicación de PreparedStatement para DELETE
            String deleteQuery = "DELETE FROM usuarios WHERE Documento = ?";
            psDelete = con.prepareStatement(deleteQuery);
            psDelete.setString(1, Integer.toString(cedula));

            // Ejecutar la consulta de eliminación
            int filasAfectadas = psDelete.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Borrado exitoso para el usuario con Documento " + cedula);
            } else {
                System.out.println("El borrado no tuvo éxito para el usuario con Documento " + cedula + ". Usuario no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar PreparedStatement y Connection en el bloque finally
            try {
                if (psDelete != null) {
                    psDelete.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    } else {
        // Usuario no encontrado en los arreglos, imprimir un mensaje
        System.out.println("Usuario con Documento " + cedula + " no encontrado en los arreglos. No se realizó ninguna acción.");
    }
    
    
    return -1;
        
    }
    
}
