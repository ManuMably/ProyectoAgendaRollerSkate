
package proyectoagendaroller;


public class Alumno extends Usuario {
    public Alumno(String nombre, int cedula, long celular, int tipoDePerfil, String direccion, String claveAcceso, String preguntaSeguridad) {
        super(nombre, cedula, celular, tipoDePerfil, direccion, claveAcceso, preguntaSeguridad);
    }
    //Atributos
    private String nivel;
    private String[] diasClase = new String[7];
    private int[] diaClaseMarca = new int[7];
    private int[] horaClase = new int[7];
    
    //Constructor
    public Alumno(){}
    
    public Alumno(String nombre, int cedula, long celular, int tipoDePerfil, String direccion, String claveAcceso, String preguntaSeguridad, String nivel, String[] diasClase, int[] diaClaseMarca, int[] horaClase){
        this.nivel = nivel;
        this.diasClase = diasClase;
        this.diaClaseMarca = diaClaseMarca;
        this.horaClase = horaClase;       
    }
    
    // Getter para nivel
    public String getNivel() {
        return nivel;
    }

    // Setter para nivel
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    // Getter para diasClase
    public String[] getDiasClase() {
        return diasClase;
    }

    // Setter para diasClase
    public void setDiasClase(String[] diasClase) {
        this.diasClase = diasClase;
    }

    // Getter para diaClaseMarca
    public int[] getDiaClaseMarca() {
        return diaClaseMarca;
    }

    // Setter para diaClaseMarca
    public void setDiaClaseMarca(int[] diaClaseMarca) {
        this.diaClaseMarca = diaClaseMarca;
    }

    // Getter para horaClase
    public int[] getHoraClase() {
        return horaClase;
    }

    // Setter para horaClase
    public void setHoraClase(int[] horaClase) {
        this.horaClase = horaClase;
    }
    
    public int obtenerSumaHorasClase() {
        int suma = 0;
        for (int hora : horaClase) {
            suma += hora;
        }
        return suma;
    }

}
