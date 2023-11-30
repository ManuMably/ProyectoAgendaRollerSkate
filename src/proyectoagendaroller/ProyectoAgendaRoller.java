
package proyectoagendaroller;

import java.util.Scanner;

public class ProyectoAgendaRoller {

    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        Perfiles perfilActual = new Perfiles();
        
        int respuesta = perfilActual.cargarDatosRegistrados();
        
        Administrador admin = new Administrador("Royer Pineda", 103666576, 5787836, 3, "ad45", "0000", "rosita");
        Perfiles.registrarUsuario(admin);
        
        Perfiles.actualizarUsuariosRegistrados();
        
        perfilActual.guardarUsuariosRegistrados();
        
        System.out.println(Perfiles.mostrarDatosUsuariosRegistrados());
        
        
        
        
    }
    
}
