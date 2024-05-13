package Consola;
import Logica.Administrador;
import Logica.Cajero;
import Logica.Compra;
import Logica.Comprador;
import Logica.Escultura;
import Logica.Fotografia;
import Logica.Galeria;

import Logica.Mensaje;
import Logica.Oferta;
import Logica.Operador;
import Logica.Pieza;
import Logica.Pintura;
import Logica.Propietario;
import Logica.Servicios;
import Logica.Subasta;
import Logica.Usuario;
import Logica.Video;
import Persistencia.ImprimirJSON;
import Persistencia.InicializadorDeClases;
import Persistencia.UsuarioPersistencia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;




public class Main
{

    private static Scanner scanner = new Scanner(System.in);
    private static Galeria galeria = InicializadorDeClases.cargarGaleria();

    public static void main(String[] args) throws FileNotFoundException 
    {
        //AutoresPersistencia.registrarAutor("pixar ", "El rayo mquen");
        //Galeria gal = galeria;

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
                    System.out.print("Recuerde que si ingresa como comprdor se registrará instantaniamente como comprador y propietario: ");
                    System.out.print("y si se registro solamente como propietario no podrá ser comprador con el mismo login: ");


                    System.out.print("Ingrese su rol (cajero / administrador / comprador / operador / propietario): ");
                    rol = scanner.nextLine();

                    System.out.print("Ingrese su login: ");
                    String login1 = scanner.nextLine();
                    
                    login = login1+"_"+ rol;
                    
                    if (Servicios.verificarLoginRepetido(galeria, login))
                     {
                        System.out.println("Ya existe un usuario con ese login. Inténtelo de nuevo.");
                        return;
                     }
                    System.out.print("Ingrese su nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese su número de teléfono: ");
                    telefono = scanner.nextLine();
                    System.out.print("Ingrese su password: ");
                    password = scanner.nextLine() ;
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
                            Comprador comprador = new Comprador(login, nombre, password, rol, telefono, false, estadoCuenta, new ArrayList<Compra>(),0,
                            false,new ArrayList<Mensaje>(), new ArrayList<String>());
                        

                            Administrador.verificarComprador(comprador);
                            if (comprador.isVerificado())
                            {
                                String loginPropietario= login1 +"_propietario";
                                Propietario propiertario= new Propietario(loginPropietario, nombre, password, "propietario", telefono, salir, new ArrayList<String>(),  new ArrayList<String>());
                                Administrador.ingresarUsuario(comprador, galeria);
                                Administrador.ingresarUsuario(propiertario, galeria);
                                System.out.println("Su registro fue exitoso,  recuerde que automaticamente se creo una cuneta con el rol propietario. ");


                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
                            break;   
                            
                            
                      
                        case "operador":
                            
                            Operador operador = new Operador(login, nombre, password, rol, telefono, false, new ArrayList<String>());
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
                        case "propietario":

                            Propietario propiertario= new Propietario(login, nombre, password, "propietario", telefono, salir, new ArrayList<String>(),  new ArrayList<String>());
                            Administrador.verificarPropietario(propiertario);
                            if (propiertario.isVerificado())
                            {
                                Administrador.ingresarUsuario(propiertario, galeria);

                            }       
                            else
                            {
                                System.out.println("No se pudo verificar su cuenta. Intente nuevamente. ");
                            }     
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
                        System.out.println("No existe un usuario con ese login o su password es incoreccta Inténtelo de nuevo.");
                        continue;
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
                            menuComprador(usuario, login);
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
            System.out.println("1. ver historial de una pieza");
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
                verHistorialPieza(galeria);
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

    private static void menuAdministrador(Usuario usuario) 
    {
        boolean salir = false;
    
        while (!salir) {
            System.out.println("\nBienvenido al menu administrador");
            System.out.println("1. Cargar una pieza");
            System.out.println("2. Crear  uns subasta");
            System.out.println("3.  ver historial de una pieza");
            System.out.println("4.  ver historial de un comprador");

            System.out.println("5. Salir");
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

                    
                    System.out.print("Ingrese en que fecha adquirió la pieza su propietario actual (con formato   dia/mes/año ) : ");
                    String fecha = scanner.nextLine();


                    System.out.print("Ingrese en que valor adquirió la pieza propietario actual: ");
                    int valorCompra  = Integer.parseInt(scanner.nextLine());

                    
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

    
                    
                    System.out.print("Ingrese los valores separados por ',' (1:valorPrecioFijo, 2:valorMinimo, 3:ValorMaximo) : ");
                    String[] valoresArreglo = scanner.nextLine().split(",");
                    ArrayList<Integer> valores = new ArrayList<Integer>();
                    for (String valor : valoresArreglo) {
                        valores.add(Integer.parseInt(valor.trim()));
                    }

                    ArrayList<Map<String,Object>> propietarios = new ArrayList<Map<String,Object>>();
                    Map<String,Object> mapaPropietario = new HashMap<String,Object>();
                    System.out.print("Ingrese Login del propietario: ");
                    String loginPropietario = scanner.nextLine()+"_propietario";
                    mapaPropietario.put("loginPropietario", loginPropietario);
                    mapaPropietario.put("valorCompra", valorCompra);
                    mapaPropietario.put("fechaVenta",fecha);
                    propietarios.add(mapaPropietario);
                    
                    
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
                        
                    

    
                        Pintura pintura = new Pintura(titulo, loginPropietario, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, alto, ancho, peso, tecnica);
                        
                        Administrador.ingresarPieza(galeria, pintura);

                    } 
                    else if (tipo.equals("fotografia")) 
                    {
                        System.out.print("Ingrese la resolución: ");
                        resolucion = scanner.nextLine();
                        
                        System.out.print("Ingrese el tamaño en gigas: ");
                        tamanioGiga = Integer.parseInt(scanner.nextLine());
    
                        Fotografia fotografia = new Fotografia(titulo, loginPropietario, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, resolucion, tamanioGiga);
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
    
                        Escultura escultura = new Escultura(titulo, loginPropietario, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, alto, ancho, profundidad, peso, electricidad);
                        Administrador.ingresarPieza(galeria, escultura);

                    } else if (tipo.equals("video")) {
                        System.out.print("Ingrese la duración en minutos: ");
                        int duracion = Integer.parseInt(scanner.nextLine());
                        
                        
                        System.out.print("Ingrese el tamaño en gigas: ");
                        tamanioGiga = Integer.parseInt(scanner.nextLine());
                        
                        
                        System.out.print("Ingrese la resolución: ");
                        resolucion = scanner.nextLine();
                        
                        Video video = new Video(titulo, loginPropietario, anioCreacion, lugarCreacion, autores, disponible, tiempoConsignacion, subasta, valores, bodega, tipo, propietarios, duracion, tamanioGiga, resolucion);
                        
                        Administrador.ingresarPieza(galeria,video);
                        Administrador.ingresarAutor(galeria, autores, titulo);
    
                    }
    
                    // Después de cargar una pieza, volver al menú del administrador
                    break;
    

                case 2:

                    System.out.print("Ingrear ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Ingrese el titulo de las piezas que van a entrar en la subasta separados por una (,): ");
                    String[] piezasArreglo = scanner.nextLine().split(",");
                    ArrayList<String> piezas = new ArrayList<String>();
                    for (String pieza : piezasArreglo) 
                    {
                        piezas.add(pieza.trim()); 
                    }

                    Administrador.crearSusbasta(galeria, id, piezas);
                    




                    

                    break;

                case 3:
                    verHistorialPieza(galeria);
                    break;

                case 4:
                    verHistorialComprador(galeria);
                    break;
    
                case 5:
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    break;
    
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
    

    private static void menuComprador(Usuario usuario, String login) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nBienvenido al menu comprador");
            System.out.println("1. Ver Piezas Subasta");
            System.out.println("2. Ver piezas PrecioFijo");
            System.out.println("3. Comprar pieza a precio fijo");
            System.out.println("4. Hacer oferta para pieza subastada");
            System.out.println("5. ver Compra aprobadas por subasta");
            System.out.println("6. ver Compra no aprobadas por subasta");
            System.out.println("7. ver historial de una pieza");

            System.out.println("8. Salir");
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
                    ImprimirJSON.ImprimirPiezas(opcion);
                    break;
                case 2:
                    ImprimirJSON.ImprimirPiezas(opcion);
                    break;
                case 3:
                System.out.println("Ingrese el nombre de la pieza que desea comprar: ");
                String nomPieza = scanner.nextLine();
                Pieza piezaCompra = Servicios.buscarPiezaSubasta(galeria,nomPieza);

                System.out.println("Ingrese la fecha en el siguente formato dia/mes/año: ");
                String fecha = scanner.nextLine();


                if((piezaCompra.equals(null)) || (piezaCompra.isDisponible()==false))
                {
                    System.out.println("Esa pieza no está disponible para compra por un precio fijo");
                }
                else
                {
                    System.out.println("Ingrese el metodo de pago que va a usar: ");

                    String metdPago = scanner.nextLine();
                    Comprador comprador1= Servicios.buscarComprador(galeria, login);

                    boolean aprobar=Administrador.aprobarVentaPrecioFijo(comprador1, piezaCompra, metdPago, galeria, fecha);

                    if(aprobar== true)
                    {
                        System.out.println("La compra fue realizada exitosamente: ");
                       
                    }
                    else
                    {
                        System.out.println("Lo sentimos no se pudo realizar la compra. Revise su estado de cuenta o si está en mora");
                    }
                }
                    break;
                   
                    
                
                case 4:

                System.out.print("Ingrese el nombre de la pieza: ");
                String nombrePieza= scanner.nextLine();
                
                    
                System.out.print("Ingrese el valor ofertado: ");
                int valorOfertado= Integer.parseInt(scanner.nextLine());

                System.out.print("Ingrese el metodo de pago: ");
                String metodoPago= scanner.nextLine();

                System.out.println("Ingrese la fecha en el siguente formato dia/mes/año: ");
                String fecha1 = scanner.nextLine();
            

                Oferta oferta = new Oferta(login, valorOfertado, metodoPago,nombrePieza, fecha1); 
                Operador.registrarOferta(oferta, galeria.getSubastas(), galeria, fecha1);

                System.out.println("Revisa tus mensajes mensajes para saber si la venta fue exitosa");



               
                    break;
                case 5:
                    Comprador comprador= Servicios.buscarComprador(galeria, login);
                    List<Mensaje> mensajes= comprador.getMensajesSubasta();
                    if (mensajes.size()==0)
                    {
                        System.out.print("No tienes ventas aprobadas por subasta por el momento revisa más tarde ");
                    }
                    else
                    {
                        for (Mensaje mensaje : mensajes)
                    {
                        if (mensaje.isVendida()==true)
                        {
                            System.out.print(mensaje.getMensaj1());
                        }
                    }

                    }
                    
                    

                    break;


                case 6:
                     comprador= Servicios.buscarComprador(galeria, login);
                     mensajes= comprador.getMensajesSubasta();
            
                    if (mensajes.size()==0)
                    {
                        System.out.print("No tienes ventas no aprobadas por subasta por el momento revisa más tarde ");
                    }
                    else
                    {
                        for (Mensaje mensaje : mensajes)
                    {
                        if (mensaje.isVendida()==false)
                        {
                            System.out.print(mensaje.getMensaj1());
                        }
                    }

                    }

                

                case 7:
                    verHistorialPieza(galeria);
                    break;

                case 8:
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
            System.out.println("1. Cargar el historial de sus piezas");
            System.out.println("2. Ver estado piezas");
            System.out.println("3. ver historial de una pieza");

            System.out.println("4. Salir");
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
                    verHistorialPieza(galeria);
                    break;
                case 4:
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


    private static void verHistorialPieza(Galeria galeria) {
        System.out.print("Ingrese el nombre de la pieza de la cual desea saber su historial: ");
        String nombrePieza = scanner.nextLine();
        Pieza pieza = Servicios.buscarPiezaSubasta(galeria, nombrePieza);

        if (pieza != null) {
            System.out.println("El nombre de la pieza es " + pieza.getTitulo() + ".");
            System.out.println("El lugar de origen de la pieza es " + pieza.getLugarCreacion() + ".");
            System.out.println("El año de creación de la pieza es " + pieza.getAnioCreacion() + ".");
            System.out.println("El nombre del propietario actual es " + pieza.getLoginPropietarioActual() + ".");
            System.out.println("La pieza es identificada como " + pieza.getTipo() + ".");

            if (pieza.isBodega()) {
                System.out.println("La pieza está en bodega.");
            } else {
                System.out.println("La pieza se encuentra en exhibición.");
            }

            if (pieza.isDisponible()) {
                System.out.println("La pieza está disponible para la venta.");
            } else {
                System.out.println("La pieza no está disponible para la venta.");
            }

            if (pieza.getAutor().size() == 1) {
                System.out.println("El nombre del autor de la pieza es " + pieza.getAutor().get(0) + ".");
            } else {
                System.out.print("Los autores de la pieza son ");
                for (int i = 0; i < pieza.getAutor().size(); i++) {
                    if (i == pieza.getAutor().size() - 1) {
                        System.out.print(pieza.getAutor().get(i) + ".");
                    } else {
                        System.out.print(pieza.getAutor().get(i) + ", ");
                    }
                }
                System.out.println();
            }

            if (pieza.getValores().size() == 1 && !pieza.isSubasta()) {
                System.out.println("La pieza se venderá por precio fijo.");
                System.out.println("El valor de la pieza es " + pieza.getValores().get(0) + ".");
            } else {
                System.out.println("La pieza se venderá por medio de una subasta.");
                System.out.println("El valor de la pieza es " + pieza.getValores().get(0) + ".");
                System.out.println("El valor mínimo para ofertar es " + pieza.getValores().get(1) + ".");
                System.out.println("El valor máximo para ofertar es " + pieza.getValores().get(2) + ".");
            }

            System.out.println("A continuación se mostrará el historial de propietarios: ");
            ArrayList<Map<String, Object>> historialPropietarios = pieza.getHistorialPropietarios();
            
            for (Map<String,  Object> mapa :  historialPropietarios)
             {
                System.out.println("El login del propietario " + mapa.get("loginPropietario") + ", adquirió la pieza en la fecha " + mapa.get("fechaVenta") + " y su valor fue " + mapa.get("valorCompra") + ".");
             }
        } 
        else 
        {
            System.out.println("La pieza no se encuentra en la galería. Intente nuevamente.");
        }
    }

    private static void verHistorialComprador(Galeria  galeria)
    {

        System.out.println("Ingrese el login del comprador");
        String nombreComprador = scanner.nextLine()+"_comprador";
        Comprador comprador= Servicios.buscarComprador(galeria, nombreComprador);
        if (comprador!=null)
        {
            System.out.println("Acontinuación vera la piezas que ha comprado el cliente con su respectiva fecha");

            for(Compra compra: comprador.getHistorialCompras())
            {
                System.out.println("El nombre de la pieza es " + compra.getNombrepieza()+ "y fue comprada en "+ compra.getFecha()+".");


            }

            System.out.println("Acontinuación vera la piezas de las cueles el comprador es dueño.");

            for( String piezaNombre: comprador.getIdpiezasCompradas())
            {
                Pieza pieza = Servicios.buscarPiezaSubasta(galeria, piezaNombre);
                String loginPropiertario= comprador.getLogin().replace("_comprador", "_propietario");

                if (pieza.getLoginPropietarioActual()==loginPropiertario)

                {
                    System.out.println(pieza.getTitulo());
                }
            }

            System.out.println("El valor de la colección de cliente es: " + Administrador.montoColeccion(galeria, nombreComprador));






        }

        else
        {
            System.out.println("El comprador no se encuentra en la base de datos");

        }

       


        
    }
                








    
   
}
    