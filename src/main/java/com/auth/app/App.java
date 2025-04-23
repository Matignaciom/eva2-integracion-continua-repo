package com.auth.app;

import com.auth.app.model.Persona;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Aplicación de autenticación
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sistema de Autenticación ===");
        System.out.print("Usuario: ");
        String username = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        
        boolean autenticado = AuthApp.autenticar(username, password);
        
        if (autenticado) {
            System.out.println("Autenticación exitosa!");
            
            // Obtener datos completos del usuario
            Persona persona = AuthApp.obtenerDatosCompletos(username, password);
            
            if (persona != null) {
                System.out.println("\nDatos del usuario:");
                System.out.println("RUT: " + persona.getRut());
                System.out.println("Nombre completo: " + persona.getNombres() + " " + 
                                  persona.getApellidoPaterno() + " " + 
                                  persona.getApellidoMaterno());
                System.out.println("Teléfono: " + persona.getTelefono());
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Fecha de ingreso: " + dateFormat.format(persona.getFechaIngreso()));
            } else {
                System.out.println("No se pudieron obtener los datos completos del usuario.");
            }
        } else {
            System.out.println("Error de autenticación. Usuario o contraseña incorrectos.");
        }
        
        scanner.close();
    }
}
