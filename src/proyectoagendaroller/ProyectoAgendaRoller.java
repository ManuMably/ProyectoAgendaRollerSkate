
package proyectoagendaroller;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import Interfaces.*;

public class ProyectoAgendaRoller {
    public static void main(String[] args) {  
        Perfiles perfilInicial = new Perfiles();
        GestorCitas gestorCitas = new GestorCitas();
        // carga inicial de los datos a la memoria local
        int datosCargados = perfilInicial.cargarDatosRegistrados();
        int datosCitas = gestorCitas.cargarDatosRegistrados();
        if (datosCargados == 1) {
            SwingUtilities.invokeLater(() -> {
            mostrarVentanaInicial();
                System.out.println(Perfiles.mostrarDatosUsuariosRegistrados());
        });
            
        }
        
        
        
        
    }
    private static void mostrarVentanaInicial() {
         Inicio_Sesion ventanaInicial = new Inicio_Sesion();
        ventanaInicial.setVisible(true);
    }
}
