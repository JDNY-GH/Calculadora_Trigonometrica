//Tarea Investigativa Java
//Autores:
// - Alexa Herrera
// - Jordanny Hernández

import java.util.Scanner;   //Permite obtener datos de entrada en la terminal
//import java.math.*;

public class calc_trig {

    // Función/Metodo para imprimir mensaje con formato en terminal
    // 'msg' es el mensaje al que se le dara formato
    // 'repeatChar' es el caracter que desea repetir
    static void formatPrintl(String msg, char repeatChar) {      
        
        String titleDecoline = "";

        for (int i = 0; i < msg.length() ; i++) {
            titleDecoline += repeatChar;
        }

        System.out.println("\n" + titleDecoline);
        System.out.println(msg);
        System.out.println(titleDecoline + "\n");
    }

    // Función/Metodo para manejar datos de entrada del usuario

    static String userInput(String msg) {
        Scanner userInput = new Scanner(System.in);           //Define userInput como un objeto Scanner.

        System.out.println(msg);
        String input = userInput.nextLine();                 //Lee una línea de texto desde la entrada del usuario y la asigna a la variable 'input'
        userInput.close();
        return input;                                      //Devuelve el valor ingresado por el usuario
    }
    
    // Función/Metodo para obtener el ángulo a calcular por parte del usuario
    static int angleInput(Scanner userInput) {
        while (true) {
            System.out.println("Ángulo a calcular:");
            String line = userInput.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Se ha ingresado un dato no permitido. Intenta de nuevo.");
            }
        }
    }

    //Funciones/Metodos trigonometricos

    static void trigonom(Scanner userInput) {
        int angle = angleInput(userInput);     // Llama a angleInput() con el mismo Scanner
        double result = 0;
        String function = "";

        System.out.println("Seleccione la función trigonométrica que desea realizar");
        System.out.println(String.format("   1 - Seno(%d)", angle));
        System.out.println(String.format("   2 - Coseno(%d)", angle));
        System.out.println(String.format("   3 - Tangente(%d)", angle));

        String option = userInput.nextLine().trim();

        switch (option) {
            case "1":
                result = Math.sin(Math.toRadians(angle)); //Utiliza .toRadians para convertir el ángulo de grados a radianes antes de calcular el seno. Esto para todas las funciones trigonométricas
                function = String.format("Sen(%d)", angle);
                break;
            case "2":
                result = Math.cos(Math.toRadians(angle));
                function = String.format("Cos(%d)", angle);
                break;
            case "3":
                result = Math.tan(Math.toRadians(angle));
                function = String.format("Tan(%d)", angle);
                break;
            default:
                System.out.println("Opción no válida. Se usará Seno por defecto.");
                result = Math.sin(Math.toRadians(angle));
                function = String.format("Sen(%d)", angle);
                break;
        }

        System.out.println("Resultado:");
        System.out.println(String.format("%s = %f", function, result));
    }
    static void trigonomInv(Scanner userInput) {}
    static void trigonomHip(Scanner userInput) {}








    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione la operación que desea realizar");
            System.out.println("   1 - Operación trigonométrica");
            System.out.println("   2 - Operación trigonométrica inversa");
            System.out.println("   3 - Operación trigonométrica hiperbólica");
            System.out.println("   - - Salir");

            String option = userInput.nextLine().trim();                                  

            switch (option) { //Evalua "option" según el valor que tenga
                case "1":
                    trigonom(userInput);
                    break;
                case "2":
                    trigonomInv(userInput);
                    break;
                case "3":
                    trigonomHip(userInput);
                    break;
                case "-":
                    System.out.println("CERRAR");
                    userInput.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }

        }        
    }
}
