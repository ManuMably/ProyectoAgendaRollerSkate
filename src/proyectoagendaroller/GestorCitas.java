
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
import java.time.ZoneOffset;
import java.util.Comparator;
import proyectoagendaroller.Cita;
import static proyectoagendaroller.Perfiles.buscarPerfilCedula;
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
                citasRegistradas[numeroCitasRegistradas].setFechaCita(rs.getDate("FechaCita"));citasRegistradas[numeroCitasRegistradas].setHoraCita(rs.getInt("HoraCita"));   
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
    
    public void guardarCitasRegistradas(Cita citaNueva) {
        int nuevoTamano = numeroCitasRegistradas + 1;
        Cita[] nuevoArreglo = new Cita[nuevoTamano];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArreglo[0] = citaNueva;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(citasRegistradas, 0, nuevoArreglo, 1, numeroCitasRegistradas);

        citasRegistradas = nuevoArreglo;
        numeroCitasRegistradas = nuevoTamano;
        
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
                Date fechaCita = cita.getFechaCita();
                ps.setDate(4, java.sql.Date.valueOf(fechaCita.toString()));
                ps.setInt(5, cita.getHoraCita());
                ps.setString(6, cita.getLugarCita());
                ps.setString(7, cita.getNivel());
                ps.setString(8, cita.getEstadoCita());

                

                // Ejecutar la consulta de inserción
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Inserción exitosa para la cita: " + cita.getIdCita());
                } else {
                    System.out.println("La inserción no tuvo éxito para el usuario con Documento " + cita.getIdCita());
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
    public static int registrarCita(Cita citaNueva){
        int nuevoTamano = numeroCitasRegistradas + 1;
        Cita[] nuevoArreglo = new Cita[nuevoTamano];

        // Asignar el nuevo elemento en la primera posición del nuevo arreglo
        nuevoArreglo[0] = citaNueva;

        // Copiar los elementos del arreglo original al nuevo arreglo, empezando desde la posición 1
        System.arraycopy(citasRegistradas, 0, nuevoArreglo, 1, numeroCitasRegistradas);

        citasRegistradas = nuevoArreglo;
        numeroCitasRegistradas = nuevoTamano;
        return 1;
    
    }
    
    
    public static Cita buscarCita(int cedula, int idCita){
        
        for (Cita cita : citasRegistradas) {
            int cedulaInstructor = cita.getCedulaInstructor();
            int idCitaR = cita.getIdCita();
            
            
            if (cedulaInstructor == cedula && idCitaR == idCita ) {
                return cita;   
            }   
        }
        
        // se  envia un usuario vacio en caso de no encontrar el de la bsuqueda
        Cita noEncontrada = new Cita();
        
        
        
        return noEncontrada;    
    }
    
    
    
    public int borrarCita(int cedula, int idCitaB){    
    
    // Buscar el usuario en los arreglos
    Cita citaBorrar =  buscarCita(cedula, idCitaB);

    // Verificar si la cita fue encontrada
        Connection con = null;
        PreparedStatement psDelete = null;

        try {
            con = getConnection();

            // Aplicación de PreparedStatement para DELETE
            String deleteQuery = "DELETE FROM citas WHERE CedulaInstructor = ? AND IdCita = ?";
            psDelete = con.prepareStatement(deleteQuery);
            psDelete.setInt(1, citaBorrar.getCedulaInstructor()); // Establecer el valor para CedulaInstructor
            psDelete.setInt(2, citaBorrar.getIdCita()); // Establecer el valor para IdCita

            // Ejecutar la consulta de eliminación
            int filasAfectadas = psDelete.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Borrado exitoso para el la cita del profesor de cedula: " + cedula);
                return 1;
            } else {
                System.out.println("El borrado no tuvo éxito para  la cita del profesor de cedula: " + cedula + ". cita no encontrada.");
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
        return -1;
    }
    
    public static int modificarCita(Cita modificadaCita){
    for (Cita citaR : citasRegistradas) {
            if (citaR.getIdCita()== modificadaCita.getIdCita()) {
                citaR = modificadaCita;
                
            }
            
        }
        
        //public void modificarUsuarioEnBaseDeDatos(int cedula, String nuevoNombre, long nuevoCelular, String nuevaDireccion) {
        Connection con = null;
        PreparedStatement psSelect = null;
        PreparedStatement psUpdate = null;

        try {
            con = getConnection();

            // Aplicación de PreparedStatement para SELECT
            String selectQuery = "SELECT * FROM citas WHERE IdCita = ?";
            psSelect = con.prepareStatement(selectQuery);
            psSelect.setInt(1, modificadaCita.getIdCita());
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                // Usuario encontrado, proceder con la modificación
                String updateQuery = "UPDATE citas SET IdCita = ?, "
                        + "CedulaInstructor = ?,"
                        + " Direccion = ? "
                        + "WHERE Documento = ?";
                psUpdate = con.prepareStatement(updateQuery);
                psUpdate.setInt(1, modificadaCita.getIdCita());
                psUpdate.setInt(2, modificadaCita.getCedulaInstructor());
                psUpdate.setInt(3,modificadaCita.getCedulaAlumno());
                Date fechaCita = modificadaCita.getFechaCita();
                psUpdate.setDate(4, java.sql.Date.valueOf(fechaCita.toString())); 
               psUpdate.setInt(5, modificadaCita.getHoraCita());
                psUpdate.setString(6, modificadaCita.getLugarCita());
                psUpdate.setString(7, modificadaCita.getNivel());
                psUpdate.setString(8, modificadaCita.getEstadoCita());
                
                

                // Ejecutar la consulta de actualización
                int filasAfectadas = psUpdate.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Modificación exitosa para la cita con Id " + modificadaCita.getIdCita());
                    return 1;
                } else {
                    System.out.println("La modificación no tuvo éxito para la cita con Id " + modificadaCita.getIdCita());
                }
            } else {
                // Usuario no encontrado
                System.out.println("la cita con id " + modificadaCita.getIdCita()+ " no encontrado. No se realizó ninguna modificación.");
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
        return -1;
    }
    
    public void ordenarCitasPorFecha() {
        // funciones para ordenar y comparar las fechas
        Arrays.sort(citasRegistradas, Comparator.comparing(Cita::getFechaCita));
    }
    public void ordenarCitasPorId() {
        // funciones para ordenar y comparar los id
        Arrays.sort(citasRegistradas, Comparator.comparingInt(Cita::getIdCita));

        
    }
    
}