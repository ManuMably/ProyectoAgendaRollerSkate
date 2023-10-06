
package proyectoagendaroller;

public class Administrador extends Usuario {
    public Administrador(String nombre, int cedula, long celular, int tipoDePerfil, String direccion, String claveAcceso, String preguntaSeguridad) {
        super(nombre, cedula, celular, tipoDePerfil, direccion, claveAcceso, preguntaSeguridad);
    }
    //atributos
    private String segundaClave;
    
    //constructor
    public Administrador(){}
    
    // Getter para segundaClave
    public String getSegundaClave() {
        return segundaClave;
    }

    // Setter para segundaClave
    public void setSegundaClave(String segundaClave) {
        this.segundaClave = segundaClave;
    }
    
}
