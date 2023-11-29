
package proyectoagendaroller;

import java.util.Scanner;

public class ProyectoAgendaRoller {

    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        boolean volverAlMenu = true;
        while(volverAlMenu){
            System.out.println("Bienvenido Al Prototipo Agenda Roller Skate \n"
                    + "en el momento estan habilitadas Las siguientes opciones: \n"
                    + "presiona 1 para registrar un Usuario.\n"
                    + "presiona 2 para mostrar los usuarios registrados.\n"
                    + "presiona 3 para guardar los usuarios registrados en la base de datos.\n"
                    + "presiona 4 para cargar los usuarios desde la base de datos. \n"
                    + "presiona 5 para actualizar datos en memoria local y visualizar con mostrar\n");
            int menu = leer.nextInt();
            
            switch (menu) {
                case 1:
                    System.out.println("Has seleccionado registrar un usuario:\n"
                            + "Selecciona el tipo de Perfil que tendra el usuario:\n"
                            + "presiona 1 para un Usuario Alumno.\n"
                            + "presiona 2 para un Usuario Instructor.\n"
                            + "presiona 3 para un Usuario Administrador. \n");
                    int tipoUsuario = leer.nextInt();
                        switch (tipoUsuario) {
                            case 1:
                                Alumno alumnoNuevo = new Alumno();
                                System.out.println("Ingrese el nombre del Alumno: \n");
                                alumnoNuevo.setNombre(leer.next());
                                System.out.println("ingrese la cedula del Alumno: \n");
                                alumnoNuevo.setCedula(leer.nextInt());
                                System.out.println("ingrese el celular del Alumno: \n");
                                alumnoNuevo.setCelular(leer.nextLong());
                                alumnoNuevo.setTipoDePerfil(tipoUsuario);
                                System.out.println("Ingrese la direccion: \n");
                                alumnoNuevo.setDireccion(leer.next());
                                System.out.println("Ingrese la clave de acceso: \n");
                                alumnoNuevo.setClaveAcceso(leer.next());
                                System.out.println("ingrese la pregunta de seguridad: \n");
                                alumnoNuevo.setPreguntaSeguridad(leer.next());
                                System.out.println("Ingrese el nuvel del Alumno: \n");
                                alumnoNuevo.setNivel(leer.next());
                                String[] diasdeclaseString = new String[7];
                                    diasdeclaseString[0] = "lunes";
                                    diasdeclaseString[1] = "martes";
                                    diasdeclaseString[2] = "miercoles";
                                    diasdeclaseString[3] = "jueves";
                                    diasdeclaseString[4] = "viernes";
                                    diasdeclaseString[5] = "sabado";
                                    diasdeclaseString[6] = "domingo";
                                alumnoNuevo.setDiasClase(diasdeclaseString);
                                int[] diasdeclasemarcaInt = new int[7];
                                    diasdeclasemarcaInt[0] = 0;
                                    diasdeclasemarcaInt[1] = 0;
                                    diasdeclasemarcaInt[2] = 0;
                                    diasdeclasemarcaInt[3] = 0;
                                    diasdeclasemarcaInt[4] = 0;
                                    diasdeclasemarcaInt[5] = 0;
                                    diasdeclasemarcaInt[6] = 0;
                                alumnoNuevo.setDiaClaseMarca(diasdeclasemarcaInt);
                                int[] horasClase = new int[7];
                                    horasClase[0] = 0;
                                    horasClase[1] = 0;
                                    horasClase[2] = 0;
                                    horasClase[3] = 0;
                                    horasClase[4] = 0;
                                    horasClase[5] = 0;
                                    horasClase[6] = 0;
                                alumnoNuevo.setHoraClase(horasClase);
                                
                                //aqui se inserta con el metodo de perfiles al nuevo alumno
                                Perfiles.registrarUsuario(alumnoNuevo);
                                System.out.println("Se ha insertado correctamente, Actualizar la lista de usuarios registrados para visualizarlo.");
                                

                                break;
                            case 2:
                                Instructor instructorNuevo = new Instructor();
                                System.out.println("Ingrese el nombre del Instructor: \n");
                                instructorNuevo.setNombre(leer.next());
                                System.out.println("ingrese la cedula del Instructor: \n");
                                instructorNuevo.setCedula(leer.nextInt());
                                System.out.println("ingrese el celular del Instructor: \n");
                                instructorNuevo.setCelular(leer.nextLong());
                                instructorNuevo.setTipoDePerfil(tipoUsuario);
                                System.out.println("Ingrese la direccion: \n");
                                instructorNuevo.setDireccion(leer.next());
                                System.out.println("Ingrese la clave de acceso: \n");
                                instructorNuevo.setClaveAcceso(leer.next());
                                System.out.println("ingrese la pregunta de seguridad: \n");
                                instructorNuevo.setPreguntaSeguridad(leer.next());
                                
                                String[] diasDisponibles = new String[7];
                                    diasDisponibles[0] = "lunes";
                                    diasDisponibles[1] = "martes";
                                    diasDisponibles[2] = "miercoles";
                                    diasDisponibles[3] = "jueves";
                                    diasDisponibles[4] = "viernes";
                                    diasDisponibles[5] = "sabado";
                                    diasDisponibles[6] = "domingo";
                                instructorNuevo.setDiasDisponibles(diasDisponibles);
                                int[] diasdeclasemarcaInt2 = new int[7];
                                    diasdeclasemarcaInt2[0] = 0;
                                    diasdeclasemarcaInt2[1] = 0;
                                    diasdeclasemarcaInt2[2] = 0;
                                    diasdeclasemarcaInt2[3] = 0;
                                    diasdeclasemarcaInt2[4] = 0;
                                    diasdeclasemarcaInt2[5] = 0;
                                    diasdeclasemarcaInt2[6] = 0;
                                instructorNuevo.setDiasDisponiblesMarca(diasdeclasemarcaInt2);
                                int[] horasDisponible = new int[7];
                                    horasDisponible[0] = 0;
                                    horasDisponible[1] = 0;
                                    horasDisponible[2] = 0;
                                    horasDisponible[3] = 0;
                                    horasDisponible[4] = 0;
                                    horasDisponible[5] = 0;
                                    horasDisponible[6] = 0;
                                instructorNuevo.setHorasDisponibles(horasDisponible);
                                
                                //aqui se inserta con el metodo insertar usuarios a la lista el instructor nuevo
                                Perfiles.registrarUsuario(instructorNuevo);
                                System.out.println("Se ha insertado correctamente, Actualizar la lista de usuarios registrados para visualizarlo.");
                            
                                break;
                            case 3:
                                Administrador administradorNuevo = new Administrador();
                                System.out.println("Ingrese el nombre del Administrador: \n");
                                administradorNuevo.setNombre(leer.next());
                                System.out.println("ingrese la cedula del Administrador: \n");
                                administradorNuevo.setCedula(leer.nextInt());
                                System.out.println("ingrese el celular del Administrador: \n");
                                administradorNuevo.setCelular(leer.nextLong());
                                administradorNuevo.setTipoDePerfil(tipoUsuario);
                                System.out.println("Ingrese la direccion: \n");
                                administradorNuevo.setDireccion(leer.next());
                                System.out.println("Ingrese la clave de acceso: \n");
                                administradorNuevo.setClaveAcceso(leer.next());
                                System.out.println("ingrese la pregunta de seguridad: \n");
                                administradorNuevo.setPreguntaSeguridad(leer.next());
                                System.out.println("ingrese la segunda clave: \n");
                                administradorNuevo.setSegundaClave(leer.next());
                                
                                //aqui se inserta con el metodo insertar usuarios a la lista el administrador nuevo
                                Perfiles.registrarUsuario(administradorNuevo);
                                System.out.println("Se ha insertado correctamente, Actualizar la lista de usuarios registrados para visualizarlo.");
                            
                                break;
                        default:
                            throw new AssertionError();
                    }
                        System.out.println("""
                                       Desea volver al menu Principal?
                                       1 si
                                       2 cerrar programa
                                       """);
                        int resp1 = leer.nextInt();
                        if (resp1 == 1) {
                            
                    }else{volverAlMenu=false;}
                    
                    break;
                case 2:
                    System.out.println("Acontinuacion los usuarios registrados son: \n");
                    
                    
                    String mensaje = Perfiles.mostrarDatosUsuariosRegistrados();
                    System.out.println(mensaje);
                    
                    System.out.println("""
                                       Desea volver al menu Principal?
                                       1 si
                                       2 cerrar programa
                                       """);
                        int resp2 = leer.nextInt();
                        if (resp2 == 1) {
                            
                    }else{volverAlMenu=false;}
                    break;
                case 3:
                    Perfiles.guardarUsuariosRegistrados();
                    System.out.println("se han guardado los usuarios registrados actuales.");
                    System.out.println("""
                                       Desea volver al menu Principal?
                                       1 si
                                       2 cerrar programa
                                       """);
                        int resp3 = leer.nextInt();
                        if (resp3 == 1) {
                            
                    }else{volverAlMenu=false;}
                    break;
                case 4:
                    Perfiles.cargarUsuariosRegistrados();
                    System.out.println("se han cargado los usuarios registrados a la memoria.");
                    
                    System.out.println("""
                                       Desea volver al menu Principal?
                                       1 si
                                       2 cerrar programa
                                       """);
                        int resp4 = leer.nextInt();
                        if (resp4 == 1) {
                            
                    }else{volverAlMenu=false;}
                    break;
                case 5:
                    Perfiles.actualizarUsuariosRegistrados();
                    System.out.println("se han actualizado los usuarios registrados en la memoria temporal.");
                    
                    System.out.println("""
                                       Desea volver al menu Principal?
                                       1 si
                                       2 cerrar programa
                                       """);
                        int resp5 = leer.nextInt();
                        if (resp5 == 1) {
                            
                    }else{volverAlMenu=false;}
                    break;
                default:
                    throw new AssertionError();
            }
            
        }   
        
        
        
        
    }
    
}
