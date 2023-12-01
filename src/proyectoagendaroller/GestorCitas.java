
package proyectoagendaroller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static proyectoagendaroller.Perfiles.getConnection;


public class GestorCitas {
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

    

    // atributos correspondiestes para manipular las citas
    private static final int numeroCitasMax = 150;
    private static Cita[] citasRegistradas = new Cita[numeroCitasMax];
    private static int numeroCitasRegistradas = 0;
    
    public static int getNumeroCitasRegistradas() {
        return numeroCitasRegistradas;
    }
    
    public static Cita[] getCitasRegistradas() {
        return citasRegistradas;
    }

    public static void setCitasRegistradas(Cita[] citasRegistradas) {
        GestorCitas.citasRegistradas = citasRegistradas;
    }

    public static void setNumeroCitasRegistradas(int numeroCitasRegistradas) {
        GestorCitas.numeroCitasRegistradas = numeroCitasRegistradas;
    }
    
    public int cargarDatosRegistrados(){
        com.mysql.jdbc.Connection con = null;

        try{
            con = getConnection();

            //este codigo busca por medio de select * from y el tipo de perfil de lusuario en este caso es para los instructores
            ps= con.prepareStatement("SELECT * FROM citas");


            rs= ps.executeQuery();//codigo para informacion de la base de datos
            while (rs.next()) { 
                citasRegistradas[numeroCitasRegistradas] = new Cita();
                citasRegistradas[numeroCitasRegistradas].setIdCita(rs.getString("IdCita"));
                citasRegistradas[numeroCitasRegistradas].setCedula(Integer.parseInt(rs.getString("Documento")));
                citasRegistradas[numeroCitasRegistradas].setCelular(Long.parseLong(rs.getString("Celular")));
                citasRegistradas[numeroCitasRegistradas].setTipoDePerfil(Integer.parseInt(rs.getString("TipoPerfil")));
                citasRegistradas[numeroCitasRegistradas].setDireccion(rs.getString("Direccion"));
                citasRegistradas[numeroCitasRegistradas].setClaveAcceso(rs.getString("Clave"));
                citasRegistradas[numeroCitasRegistradas].setPreguntaSeguridad(rs.getString("PreguntaSeguridad"));
                citasRegistradas[numeroCitasRegistradas].setDiasDisponibles(rs.getString("DiasDisponibles").split(","));
                
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
    
    
    
    
    
}
