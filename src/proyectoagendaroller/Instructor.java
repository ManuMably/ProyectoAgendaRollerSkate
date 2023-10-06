
package proyectoagendaroller;


public class Instructor extends Usuario {
    public Instructor(String nombre, int cedula, long celular, int tipoDePerfil, String direccion, String claveAcceso, String preguntaSeguridad) {
        super(nombre, cedula, celular, tipoDePerfil, direccion, claveAcceso, preguntaSeguridad);
    }
    //Atributos
    private String[] diasDisponibles;
    private int[] diasDisponiblesMarca;
    private int[] horasDisponibles;
    
    //Constructor
    public Instructor(){}
    
    //geters y seters
    
    // Getter para diasDisponibles
    public String[] getDiasDisponibles() {
        return diasDisponibles;
    }

    // Setter para diasDisponibles
    public void setDiasDisponibles(String[] diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }

    // Getter para diasDisponiblesMarca
    public int[] getDiasDisponiblesMarca() {
        return diasDisponiblesMarca;
    }

    // Setter para diasDisponiblesMarca
    public void setDiasDisponiblesMarca(int[] diasDisponiblesMarca) {
        this.diasDisponiblesMarca = diasDisponiblesMarca;
    }

    // Getter para horasDisponibles
    public int[] getHorasDisponibles() {
        return horasDisponibles;
    }

    // Setter para horasDisponibles
    public void setHorasDisponibles(int[] horasDisponibles) {
        this.horasDisponibles = horasDisponibles;
    }
    
}
