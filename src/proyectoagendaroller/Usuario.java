
package proyectoagendaroller;


public class Usuario {
    // atrubutos de los usuarios
    private String nombre;
    private int cedula;
    private long celular;
    private int tipoDePerfil;
    private String direccion;
    private String claveAcceso;
    private String preguntaSeguridad;
    
    // Constructor
    public Usuario(String nombre, int cedula, long celular, int tipoDePerfil, String direccion, String claveAcceso, String preguntaSeguridad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.tipoDePerfil = tipoDePerfil;
        this.direccion = direccion;
        this.claveAcceso = claveAcceso;
        this.preguntaSeguridad = preguntaSeguridad;
    }
    public Usuario(){}
    
    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre;
    }   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Metodos getter y setter para cedula
    
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    // Métodos getter y setter para celular
    public long getCelular() {
        return celular;
    }
    public void setCelular(long celular) {
        this.celular = celular;
    }

    // Métodos getter y setter para tipoDePerfil
    public int getTipoDePerfil() {
        return tipoDePerfil;
    }
    public void setTipoDePerfil(int tipoDePerfil) {
        this.tipoDePerfil = tipoDePerfil;
    }

    // Métodos getter y setter para direccion
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Métodos getter y setter para claveAcceso
    public String getClaveAcceso() {
        return claveAcceso;
    }
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    // Métodos getter y setter para preguntaSeguridad
    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }
    public void setPreguntaSeguridad(String preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }
    
}
