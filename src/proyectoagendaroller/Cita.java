
package proyectoagendaroller;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
public class Cita {
 //Atributos de las citas
    private int idCita;
    private int cedulaInstructor;
    private int cedulaAlumno;
    private Date fechaCita;
    private int horaCita;
    private String lugarCita;
    private String nivel;
    private String estadoCita;

    // Constructor
    public Cita(){}
    public Cita(int idCita, int cedulaInstructor, int cedulaAlumno, Date fechaCita, int horaCita, String lugarCita, String nivel, String estadoCita) {
        this.idCita = idCita;
        this.cedulaInstructor = cedulaInstructor;
        this.cedulaAlumno = cedulaAlumno;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.lugarCita = lugarCita;
        this.nivel = nivel;
        this.estadoCita = estadoCita;
    }
    
    public Cita(int cedulaInstructor, int cedulaAlumno, Date fechaCita, int horaCita, String lugarCita, String nivel, String estadoCita){
        this.idCita = generarID();
        this.cedulaInstructor = cedulaInstructor;
        this.cedulaAlumno = cedulaAlumno;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.lugarCita = lugarCita;
        this.nivel = nivel;
        this.estadoCita = estadoCita;
    }
    
    //geters y seters
    
    // Getter y Setter para idCita
    public int getIdCita() {
        return idCita;
    }
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    // Getter y Setter para cedulaInstructor
    public int getCedulaInstructor() {
        return cedulaInstructor;
    }
    public void setCedulaInstructor(int cedulaInstructor) {
        this.cedulaInstructor = cedulaInstructor;
    }

    // Getter y Setter para cedulaAlumno
    public int getCedulaAlumno() {
        return cedulaAlumno;
    }
    public void setCedulaAlumno(int cedulaAlumno) {
        this.cedulaAlumno = cedulaAlumno;
    }

    // Getter y Setter para fechaCita
    public Date getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    // Getter y Setter para horaCita
    public int getHoraCita() {
        return horaCita;
    }
    public void setHoraCita(int horaCita) {
        this.horaCita = horaCita;
    }

    // Getter y Setter para lugarCita
    public String getLugarCita() {
        return lugarCita;
    }
    public void setLugarCita(String lugarCita) {
        this.lugarCita = lugarCita;
    }

    // Getter y Setter para nivel
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    // Getter y Setter para estadoCita
    public String getEstadoCita() {
        return estadoCita;
    }
    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }
    public static int generarID() {
        Random random = new Random();
        return random.nextInt(9000) + 1000; // Generar un número aleatorio entre 1000 y 9999
    }

    public String mostrarCita(){
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("ID Cita: ").append(getIdCita()).append("\n")
                    .append("Cedula Instructor: ").append(getCedulaInstructor()).append("\n")
                    .append("Cedula Alumno: ").append(getCedulaAlumno()).append("\n")
                    .append("Fecha Cita: ").append(getFechaCita()).append("\n")
                    .append("Hora Cita: ").append(getHoraCita()).append("\n")
                    .append("Lugar Cita: ").append(getLugarCita()).append("\n")
                    .append("Nivel: ").append(getNivel()).append("\n")
                    .append("Estado Cita: ").append(getEstadoCita()).append("\n")
                    .append("-------------------").append("\n");

        return mensaje.toString();
    }
}
