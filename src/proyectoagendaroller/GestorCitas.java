
package proyectoagendaroller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
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
                citasRegistradas[numeroCitasRegistradas].setIdCita(Integer.parseInt(rs.getString("IdCita")));
                citasRegistradas[numeroCitasRegistradas].setCedulaInstructor(Integer.parseInt(rs.getString("CedulaInstructor")));
                citasRegistradas[numeroCitasRegistradas].setCedulaAlumno(Integer.parseInt(rs.getString("CedulaAlumno")));
                citasRegistradas[numeroCitasRegistradas].setFechaCita(rs.getDate("FechaCita").toLocalDate());
                citasRegistradas[numeroCitasRegistradas].setHoraCita(rs.getInt("HoraCita"));   
                citasRegistradas[numeroCitasRegistradas].setLugarCita(rs.getString("LugarCita"));                
                citasRegistradas[numeroCitasRegistradas].setNivel(rs.getString("Nivel"));
                citasRegistradas[numeroCitasRegistradas].setEstadoCita(rs.getString("EstadoCita"));
                //se aumenta en la variable el numero de instructore actual
                numeroCitasRegistradas++;  
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

        // Aplicación de PreparedStatement para INSERT
        String insertQuery = "INSERT INTO citas (IdCita, CedulaInstructor, CedulaAlumno, FechaCita, HoraCita, LugarCita, Nivel, EstadoCita) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(insertQuery);

        for (int i = 0; i < numeroCitasRegistradas; i++) {
            Cita cita = citasRegistradas[i];

            // Verificar si la cita ya existe
            ps.setString(1, Integer.toString(cita.getIdCita()));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // la cita ya existe, omitir la inserción
                System.out.println("Usuario con Documento " + cita.getIdCita() + " ya existe. Omitiendo la inserción.");
            } else {
                // Cita no existe, proceder con la inserción
                // Establecer los valores de los parámetros del PreparedStatement para la inserción
                ps.setInt(1, cita.getIdCita());
                ps.setInt(2, cita.getCedulaInstructor());
                ps.setInt(3,cita.getCedulaAlumno());
                LocalDate fechaCita = cita.getFechaCita();
                Date fechaSql = Date.valueOf(fechaCita);
                ps.setDate(4, (java.sql.Date) fechaSql);
                
                
                ps.setInt(5, cita.getHoraCita());
                ps.setString(6, cita.getLugarCita());
                ps.setString(7, usuario.getPreguntaSeguridad());
                ps.setString(8, usuario.getPreguntaSeguridad());

                

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
}
