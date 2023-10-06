
package proyectoagendaroller;

public class ProyectoAgendaRoller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //programa principal
        Alumno alumnoCualquiera = new Alumno();
        
        alumnoCualquiera.setNombre("pablito");
        
        alumnoCualquiera.setCedula(1036665842);
        
        alumnoCualquiera.setCelular(3216499956L);
        
        alumnoCualquiera.setTipoDePerfil(1);
        
        alumnoCualquiera.setDireccion("cra 87b #44-55 int 508");
        
        alumnoCualquiera.setClaveAcceso("pasword");
        
        alumnoCualquiera.setPreguntaSeguridad("clave");
        
        alumnoCualquiera.setNivel("basico");
        
        String[] diasdeclaseString = new String[7];
        diasdeclaseString[0] = "lunes";
        diasdeclaseString[1] = "martes";
        diasdeclaseString[2] = "miercoles";
        diasdeclaseString[3] = "jueves";
        diasdeclaseString[4] = "viernes";
        diasdeclaseString[5] = "sabado";
        diasdeclaseString[6] = "domingo";
        alumnoCualquiera.setDiasClase(diasdeclaseString);
        
        int[] diasdeclasemarcaInt = new int[7];
        diasdeclasemarcaInt[0] = 0;
        diasdeclasemarcaInt[1] = 1;
        diasdeclasemarcaInt[2] = 0;
        diasdeclasemarcaInt[3] = 1;
        diasdeclasemarcaInt[4] = 0;
        diasdeclasemarcaInt[5] = 1;
        diasdeclasemarcaInt[6] = 0;
        alumnoCualquiera.setDiaClaseMarca(diasdeclasemarcaInt);
        
        int[] horasClase = new int[7];
        horasClase[0] = 0;
        horasClase[1] = 12;
        horasClase[2] = 0;
        horasClase[3] = 0;
        horasClase[4] = 0;
        horasClase[5] = 20;
        horasClase[6] = 0;
        alumnoCualquiera.setHoraClase(horasClase);
        
        
        
        
        
        
        
        
    }
    
}
