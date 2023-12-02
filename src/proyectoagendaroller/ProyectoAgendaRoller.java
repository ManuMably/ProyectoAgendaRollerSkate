
package proyectoagendaroller;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import Interfaces.*;

public class ProyectoAgendaRoller {

    
    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {
            mostrarVentanaInicial();
        });
        
        
        
    }
    private static void mostrarVentanaInicial() {
         Inicio_Sesion ventanaInicial = new Inicio_Sesion();
        ventanaInicial.setVisible(true);
    }
}
