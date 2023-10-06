
package proyectoagendaroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Perfiles {
    // atributos correspondiestes para manipular los perfiles
    private static Usuario[] usuariosRegistrados;
    private static Instructor[] usuariosInstructores;
    private static int numeroInstructores = 0;
    private static Alumno[] usuariosAlumnos;
    private static int numeroAlumnos = 0;
    private static Administrador[] usuariosAdministradores;
    private static int numeroAdministradores = 0;
    
    // Getter para usuariosRegistrados
    public static Usuario[] getUsuariosRegistrados() {
        return usuariosRegistrados;
    }
    // Setter para usuariosRegistrados
    public static void setUsuariosRegistrados(Usuario[] usuariosRegistrados) {
        Perfiles.usuariosRegistrados = usuariosRegistrados;
    }

    // Getter para usuariosInstructores
    public static Instructor[] getUsuariosInstructores() {
        return usuariosInstructores;
    }
    // Setter para usuariosInstructores
    public static void setUsuariosInstructores(Instructor[] usuariosInstructores) {
        Perfiles.usuariosInstructores = usuariosInstructores;
    }

    // Getter para usuariosAlumnos
    public static Alumno[] getUsuariosAlumnos() {
        return usuariosAlumnos;
    }
    // Setter para usuariosAlumnos
    public static void setUsuariosAlumnos(Alumno[] usuariosAlumnos) {
        Perfiles.usuariosAlumnos = usuariosAlumnos;
    }

    // Getter para usuariosAdministradores
    public static Administrador[] getUsuariosAdministradores() {
        return usuariosAdministradores;
    }
    // Setter para usuariosAdministradores
    public static void setUsuariosAdministradores(Administrador[] usuariosAdministradores) {
        Perfiles.usuariosAdministradores = usuariosAdministradores;
    }
    
    public static void cargarUsuariosRegistrados(){
        // se guarda la direccion del archivo plano en un string
        String archivoUsuariosRegistrados = "C:\\Users\\ROGER\\Documents\\NetBeansProjects\\ProyectoAgendaRoller\\src\\proyectoagendaroller\\ArchivosPlanos\\usuariosRegistrados.txt";
        
        // try para manejo de exepciones
        try {
                //en una variable tipo File guardamos el archivo plano
                File archivoPlano = new File(archivoUsuariosRegistrados);
                
                //luego se lee el archivo plano
                Scanner leer = new Scanner(archivoPlano);
                
                //contador de cada linea 
                int contadorLineas = 0;
                
                while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                
                String[] vectorDatosDivididos = linea.split(";");
                
                //antes de emepezar a llenar los vectores con los objetos verificamos el tipo de perfil para diferenciarlos
                //variable que define el perfil de cada linea
                int perfilTipo = Integer.parseInt(vectorDatosDivididos[3]);
                    switch (perfilTipo) {
                        case 1:
                            usuariosAlumnos[contadorLineas] = new Alumno();
                            usuariosAlumnos[contadorLineas].setNombre(vectorDatosDivididos[0]);
                            usuariosAlumnos[contadorLineas].setCedula(Integer.parseInt(vectorDatosDivididos[1]));
                            usuariosAlumnos[contadorLineas].setCelular(Integer.parseInt(vectorDatosDivididos[2]));
                            usuariosAlumnos[contadorLineas].setTipoDePerfil(Integer.parseInt(vectorDatosDivididos[3]));
                            usuariosAlumnos[contadorLineas].setDireccion(vectorDatosDivididos[4]);
                            usuariosAlumnos[contadorLineas].setClaveAcceso(vectorDatosDivididos[5]);
                            usuariosAlumnos[contadorLineas].setPreguntaSeguridad(vectorDatosDivididos[6]);
                            usuariosAlumnos[contadorLineas].setNivel(vectorDatosDivididos[7]);
                            usuariosAlumnos[contadorLineas].setDiasClase(vectorDatosDivididos[8].split(","));
                            
                            //al ser un arreglo de numeros se deben almacenar y luego castear
                            String[] arregloNumerosAuxiliar =vectorDatosDivididos[9].split(",");
                            int[] arregloDeNumeros = new int[arregloNumerosAuxiliar.length];
                            // Convertir cada "numero" a un número int y almacenar en el arreglo
                            for (int i = 0; i < arregloNumerosAuxiliar.length; i++) {
                                arregloDeNumeros[i] = Integer.parseInt(arregloNumerosAuxiliar[i]);
                            }
                            //luego ese arreglo de numeros se almacena en la marca de los dias de clase que es un arreglo de numeros
                            usuariosAlumnos[contadorLineas].setDiaClaseMarca(arregloDeNumeros);
                            
                            //al ser un arreglo de numeros se deben almacenar y luego castear
                            String[] arregloNumerosAuxiliar2 =vectorDatosDivididos[10].split(",");
                            int[] arregloDeNumeros2 = new int[arregloNumerosAuxiliar2.length];
                            // Convertir cada "numero" a un número int y almacenar en el arreglo
                            for (int i = 0; i < arregloNumerosAuxiliar.length; i++) {
                                arregloDeNumeros2[i] = Integer.parseInt(arregloNumerosAuxiliar2[i]);
                            }
                            //luego ese arreglo de numeros se almacena en la marca de los dias de clase que es un arreglo de numeros
                            usuariosAlumnos[contadorLineas].setHoraClase(arregloDeNumeros2);
                            
                            
                            
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        default:
                            throw new AssertionError();
                    }              
                }
                
                // Cerrar el scanner después de la lectura
                leer.close();
        }catch(FileNotFoundException e){
            System.err.println("El archivo '" + archivoUsuariosRegistrados + "' no se encontró.");
        }
    }
    
}
