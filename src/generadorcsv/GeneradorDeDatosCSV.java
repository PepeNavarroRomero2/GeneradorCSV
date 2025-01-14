package generadorcsv;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneradorDeDatosCSV {

    public static void main(String[] args) {
        System.out.println("Cuantos datos necesitas generar?: ");
        Scanner sc = new Scanner(System.in);
        int cantidadDeDatos = sc.nextInt();
        String nombreArchivo = "datos_aleatorios.csv";

        // Obtener la ruta del escritorio
        String escritorio = System.getProperty("user.home") + "/Desktop/";

        // Asegurarse de que la ruta completa esté correcta
        String rutaCompleta = escritorio + nombreArchivo;

        // Crear el archivo CSV
        try (FileWriter writer = new FileWriter(rutaCompleta)) {
            // Escribir los encabezados en el archivo CSV
            writer.append("nombre,apellidos,correo,num_telefono,fecha_nacimiento\n");

            // Simulamos la generación de los datos
            for (int i = 0; i < cantidadDeDatos; i++) {
                // Generar un nombre aleatorio
                String nombre = generarNombre();

                // Generar apellidos aleatorios
                String apellidos = generarApellidos();

                // Generar un correo aleatorio
                String correo = generarCorreo(nombre, apellidos);

                // Generar un número de teléfono aleatorio
                String telefono = generarTelefono();

                // Generar una fecha de nacimiento aleatoria
                String fechaNacimiento = generarFechaNacimiento();

                // Escribir los datos en el archivo CSV
                writer.append(nombre + "," + apellidos + "," + correo + "," + telefono + "," + fechaNacimiento + "\n");
            }

            System.out.println("Archivo CSV generado exitosamente: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el archivo CSV: " + e.getMessage());
        }
    }

    // Método para generar un nombre aleatorio
    private static String generarNombre() {
        String[] nombres = {
    "Carlos", "Ana", "Pedro", "Laura", "Miguel", "Sofia", 
    "Luis", "María", "José", "Isabel", "Juan", "Elena", 
    "David", "Carmen", "Javier", "Marta", "Antonio", 
    "Lucía", "Raúl", "Beatriz", "Fernando", "Paula", 
    "Daniel", "Verónica", "Gabriel", "Esther", "Ricardo", 
    "Alberto", "Sandra", "Victor", "Julia", "Pablo", 
    "Nuria", "Héctor", "Adriana", "Tomás", "Inés", 
    "Ángel", "Raquel", "Santiago", "Vanessa", "Ricardo", 
    "Tania", "Alma", "Juan Carlos", "Cristina", "Ramón", 
    "Lidia", "Antonio José", "Patricia", "César", "Esteban", 
    "Martín", "Alba", "Gerardo", "Verónica", "Francisco", 
    "Teresa", "Eduardo", "Claudia", "Felipe", "Susana"
};

        return nombres[new Random().nextInt(nombres.length)];
    }

    // Método para generar apellidos aleatorios
    private static String generarApellidos() {
        String[] apellidos = {
    "Gomez", "Lopez", "Perez", "Martinez", "Rodriguez", 
    "Sanchez", "Garcia", "Fernandez", "Gonzalez", "Ramirez", 
    "Diaz", "Moreno", "Jimenez", "Ruiz", "Hernandez", 
    "Lozano", "Vazquez", "Castro", "Torres", "Alvarez", 
    "Romero", "Guerrero", "Ramos", "Serrano", "Gil", 
    "Mendoza", "Muñoz", "Herrera", "Ortiz", "Navarro", 
    "Moya", "Vega", "Cruz", "Marin", "Lara", 
    "Campos", "Paredes", "Bravo", "Castilla", "Santos", 
    "Barrio", "Soler", "Morales", "Calvo", "Ruiz", 
    "Martín", "Acosta", "Reyes", "Santos", "Carrillo"
};

        return apellidos[new Random().nextInt(apellidos.length)];
    }

    // Método para generar un correo aleatorio
    private static String generarCorreo(String nombre, String apellidos) {
        return nombre.toLowerCase() + "." + apellidos.toLowerCase() + "@gmail.com";
    }

    // Método para generar un teléfono aleatorio
    private static String generarTelefono() {
        Random rand = new Random();
        return ""+ (600000000 + rand.nextInt(1000000000));
    }

    // Método para generar una fecha de nacimiento aleatoria
    private static String generarFechaNacimiento() {
        Random rand = new Random();
        int dia = rand.nextInt(12) + 1;
        int mes = rand.nextInt(31) + 1;
        int anio = rand.nextInt(40) + 1980; // Genera un año entre 1980 y 2020
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }
}
