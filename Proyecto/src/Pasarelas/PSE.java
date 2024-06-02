package Pasarelas;

import java.util.Scanner;

import Logica.Historia;

public class PSE 
{
    private static Scanner scanner = new Scanner(System.in);
    
    boolean respuesta = false;

    public static boolean menuPSE(Historia historia)
    {
        historia.setBanco("");
        boolean respuesta = false;

            System.out.println("\nBienvenido al sistema de pagos PayU");
            System.out.println("1. Pagos Davivienda");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            String opcion = scanner.nextLine();
            switch (opcion) 
            {
                case "1":
                    historia.setBanco("Davivienda");
                    respuesta = menuDavivienda.menu(historia);
                    
                	
                break;

                case "2":

                break;
            }

        return respuesta;
            
    }
    

}