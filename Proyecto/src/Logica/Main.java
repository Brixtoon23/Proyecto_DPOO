package Logica;



import Persistencia.ImprimirJSON;
import Persistencia.InicializadorDeClases;

import Persistencia.UsuarioPersistencia;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;




public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static Galeria galeria = InicializadorDeClases.cargarGaleria();

    public static void main(String[] args) throws FileNotFoundException 
    {

        boolean salir = false;

        String rol;
        String nombre;
        String login;
        String password;
        String telefono;
        Usuario usuario;

        while (!salir) 
        {
            System.out.println("\nBienvenido al sistema de registro de usuarios");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion;
            try 
            {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) 
            {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;
            }
            

            switch (opcion) 
            {
                case 1:
                    
                    System.out.println("\n--- Registrarse ---");
                    System.out.print("Ingrese su rol (cajero / administrador / comprador / propietario / operador): ");
                    rol = scanner.nextLine();
                    System.out.print("Ingrese su login: ");
                    login = scanner.nextLine()+"_"+ rol ;
                    if (Servicios.verificarLoginRepetido(galeria, login))
                     {
                        System.out.println("Ya existe un usuario con ese login. Inténtelo de nuevo.");
                        return;
                     }
                    System.out.print("Ingrese su nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese su password: ");
                    password = scanner.nextLine() ;
                    System.out.print("Ingrese su número de teléfono: ");
                    telefono = scanner.nextLine();
                    switch (rol) 
                    {
                        case "cajero":

                            Cajero cajero=new Cajero(login, nombre, password,rol, telefono, false, new ArrayList<Compra>());
                            Administrador.verificarCajero(cajero);
                            if (cajero.isVerificado())
                            {
                                Administrador.ingresarUsuario(cajero, galeria);

                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
                            break;                
                            
                        case "administrador":
                            
                            Administrador administrador = new Administrador(login, nombre, password, rol, telefono, false);
                            Administrador.verificarAdministrador(administrador);
                            if (administrador.isVerificado())
                            {
                                Administrador.ingresarUsuario(administrador, galeria);

                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
                            break;    
                            
                        case "comprador":
                        
                            System.out.print("Ingrese su estado de cuenta: ");
                            Float estadoCuenta = Float.parseFloat(scanner.nextLine());
                            
                            

                            Comprador comprador = new Comprador(login, nombre, password, rol, telefono, false, estadoCuenta, new ArrayList<Compra>(), 0, false, new ArrayList<Pieza>());
                            Administrador.verificarComprador(comprador);
                            if (comprador.isVerificado())
                            {
                                Administrador.ingresarUsuario(comprador, galeria);

                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
                            break;   
                            
                            
                        case "propietario":
                            
                            Propietario propietario = new Propietario(login, nombre, password, rol, telefono, false, new ArrayList<>(), new ArrayList<>());
                            Administrador.verificarPropietario(propietario);
                            if (propietario.isVerificado())
                            {
                                Administrador.ingresarUsuario(propietario, galeria);

                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
                            break;   
                        case "operador":
                            
                            Operador operador = new Operador(login, nombre, password, rol, telefono, false, new ArrayList<Subasta>());
                            Administrador.verificarOperador(operador);
                            if (operador.isVerificado())
                            {
                                Administrador.ingresarUsuario(operador, galeria);

                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
                            break;   
                        default:
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                            break;
                    }
                    continue;

















                case 2:

                    System.out.println("\n--- Iniciar Sesión ---");
                    System.out.print("Ingrese su rol (cajero / administrador / comprador / propietario / operador): ");
                    rol = scanner.nextLine();
                    System.out.print("Ingrese su login: ");
                    login = scanner.nextLine()+"_"+rol;
                    System.out.print("Ingrese su contraseña: ");
                    password = scanner.nextLine();
                    usuario =  Servicios.inicioLogin(galeria, login, password);
                    if (usuario == null)
                    {
                        System.out.println("No existe un usuario con ese login. Inténtelo de nuevo.");
                        return;
                    }
                    System.out.println("Inicio de sesión exitoso como " + rol);
                    System.out.println("Bienvenido");
 
                    switch (rol) 
                    {
                        case "cajero":
                            menuCajero(usuario);
                            break;
                        case "administrador":
                            menuAdministrador(usuario);
                            break;
                        case "comprador":
                            menuComprador(usuario);
                            break;
                        case "propietario":
                            menuPropietario(usuario);
                            break;
                        case "operador":
                            menuOperador(usuario);
                            break;
                        default:
                            System.out.println("Rol no reconocido. No se puede abrir el menú.");
                    }

                case 3:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
        }
                
                



                    
    private static void menuCajero(Usuario  usuario) 
    {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al menu cajero");
            System.out.println("1. Registrar_Venta");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion;
            try 
            {
                opcion = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;
            }

            switch (opcion) 
            {
                case 1:
                    ;
                    break;
                case 2:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void menuAdministrador(Usuario usuario) {
        boolean salir = false;
    
        while (!salir) {
            System.out.println("\nBienvenido al menu administrador");
            System.out.println("1. Cargar_Pieza");
            System.out.println("2. Ver_Galeria");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;
            }
    
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.print("Ingrese su año de creación: ");
                    int anioCreacion = Integer.parseInt(scanner.nextLine());
                    
    
                    System.out.print("Ingrese lugar de creación: ");
                    String lugarCreacion = scanner.nextLine();
                    
                    System.out.print("Ingrese autor/es separados por ',' : ");
                    String[] autoresArreglo = scanner.nextLine().split(",");
                    ArrayList<String> autores = new ArrayList<>();
                    for (String autor : autoresArreglo) {
                        autores.add(autor.trim()); 
                    }
                    
                    System.out.print("¿Se encuentra disponible? (true/false): ");
                    boolean disponible = Boolean.parseBoolean(scanner.nextLine());
                    
                    
                    System.out.print("Tiempo de consignación (-1 si no aplica): ");
                    int tiempoConsignacion = Integer.parseInt(scanner.nextLine());
                    
                    
                    System.out.print("¿Se encuentra en subasta? (true/false): ");
                    boolean subasta = Boolean.parseBoolean(scanner.nextLine());
    
                    
                    System.out.print("Ingrese los valores separados por ',' : ");
                    String[] valoresArreglo = scanner.nextLine().split(",");
                    ArrayList<Integer> valores = new ArrayList<Integer>();
                    for (String valor : valoresArreglo) {
                        valores.add(Integer.parseInt(valor.trim()));
                    }
                    
                    System.out.print("Ingrese Login del propietario: ");
                    String loginPropietario = scanner.nextLine()+"_propietario";
                    
                    
                    
                    System.out.print("¿Se encuentra en bodega? (true/false): ");
                    boolean bodega = Boolean.parseBoolean(scanner.nextLine());
                    
                    System.out.print("Ingrese el tipo (pintura/escultura/video/fotografia): ");
                    String tipo = scanner.nextLine();
                    int alto;
                    int ancho;
                    int peso;
                    int tamanioGiga;
                    String resolucion;
    
                    if (tipo.equals("pintura")) {
                        System.out.print("Ingrese el alto: ");
                        alto = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Ingrese el ancho: ");
                        ancho = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Ingrese el peso: ");
                        peso = Integer.parseInt(scanner.nextLine());
    
                        
                        System.out.print("Ingrese la técnica: ");
                        String tecnica = scanner.nextLine();
    
                        Pintura pintura = new Pintura(titulo, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, loginPropietario, bodega, tipo, alto, ancho, peso, tecnica);
                        Administrador.ingresarPieza(galeria, pintura);
                    } else if (tipo.equals("fotografia")) {
                        System.out.print("Ingrese la resolución: ");
                        resolucion = scanner.nextLine();
                        
                        System.out.print("Ingrese el tamaño en gigas: ");
                        tamanioGiga = Integer.parseInt(scanner.nextLine());
    
                        Fotografia fotografia = new Fotografia(titulo, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, loginPropietario, bodega, tipo, tamanioGiga, resolucion);
                        Administrador.ingresarPieza(galeria, fotografia);
                    } else if (tipo.equals("escultura")) {
                        System.out.print("Ingrese el alto: ");
                        alto = Integer.parseInt(scanner.nextLine());
    
                        
                        System.out.print("Ingrese el ancho: ");
                        ancho = Integer.parseInt(scanner.nextLine());
    
                        
                        System.out.print("Ingrese la profundidad: ");
                        int profundidad = Integer.parseInt(scanner.nextLine());
    
                        
                        System.out.print("Ingrese el peso: ");
                        peso = Integer.parseInt(scanner.nextLine());
    
                        
                        System.out.print("¿Necesita electricidad? (true/false): ");
                        boolean electricidad = Boolean.parseBoolean(scanner.nextLine());
    
                        Escultura escultura = new Escultura(titulo, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, loginPropietario, bodega, tipo, alto, ancho, profundidad, peso, electricidad);
                        Administrador.ingresarPieza(galeria, escultura);
                    } else if (tipo.equals("video")) {
                        System.out.print("Ingrese la duración en minutos: ");
                        int duracion = Integer.parseInt(scanner.nextLine());
                        
                        
                        System.out.print("Ingrese el tamaño en gigas: ");
                        tamanioGiga = Integer.parseInt(scanner.nextLine());
                        
                        
                        System.out.print("Ingrese la resolución: ");
                        resolucion = scanner.nextLine();
                        
                        Video video = new Video(titulo, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, loginPropietario, bodega, tipo, duracion, tamanioGiga, resolucion);
                        
                        Administrador.ingresarPieza(galeria,video);
    
                    }
    
                    // Después de cargar una pieza, volver al menú del administrador
                    break;
    
                case 2:
                    // Ver Galeria
                    break;
    
                case 3:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
    
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
    

    private static void menuComprador(Usuario usuario) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al menu comprador");
            System.out.println("1. Ver Piezas Subasta");
            System.out.println("2. Ver piezas PrecioFijo");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    ImprimirJSON.ImprimirPiezas(opcion);;
                    break;
                case 2:
                    ImprimirJSON.ImprimirPiezas(opcion);;
                    break;
                case 3:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void menuPropietario(Usuario usuario) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al menu Propietario");
            System.out.println("1. Cargar el historial");
            System.out.println("2. Ver estado piezas");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    UsuarioPersistencia.iniciarSesion();
                    break;
                case 3:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
    private static void menuOperador(Usuario usuario) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al menu cajero");
            System.out.println("1. Registrar_Pujas");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
                








    
   
}
    