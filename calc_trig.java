//Tarea Investigativa Java
//Autores:
// - Alexa Herrera
// - Jordanny Hernández

import java.util.Scanner;

public class calc_trig{

    static void formatPrintl(String msg, char repeatChar) {      
        String titleDecoline = "";
        for (int i = 0; i < msg.length(); i++) {
            titleDecoline += repeatChar;
        }
        System.out.println("\n" + titleDecoline);
        System.out.println(msg);
        System.out.println(titleDecoline + "\n");
    }

    static String userInput(String msg) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(msg);
        String input = userInput.nextLine();
        userInput.close();
        return input;
    }

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

    static void trigonom(Scanner userInput) {
        int angle = angleInput(userInput);
        double result = 0;
        String function = "";
        System.out.println("Seleccione la función trigonométrica que desea realizar");
        System.out.println(String.format("   1 - Seno(%d)", angle));
        System.out.println(String.format("   2 - Coseno(%d)", angle));
        System.out.println(String.format("   3 - Tangente(%d)", angle));
        String option = userInput.nextLine().trim();
        switch (option) {
            case "1":
                result = Math.sin(Math.toRadians(angle));
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

    static void trigonomInv(Scanner userInput) {
        System.out.println("Valor a calcular (entre -1 y 1 para arcsin/arccos):");
        double value = Double.parseDouble(userInput.nextLine().trim());
        double result = 0;
        String function = "";
        System.out.println("Seleccione la función trigonométrica inversa que desea realizar");
        System.out.println(String.format("   1 - Arcoseno(%f)", value));
        System.out.println(String.format("   2 - Arcocoseno(%f)", value));
        System.out.println(String.format("   3 - Arcotangente(%f)", value));
        String option = userInput.nextLine().trim();
        switch (option) {
            case "1":
                result = Math.toDegrees(Math.asin(value));
                function = String.format("arcsin(%f)", value);
                break;
            case "2":
                result = Math.toDegrees(Math.acos(value));
                function = String.format("arccos(%f)", value);
                break;
            case "3":
                result = Math.toDegrees(Math.atan(value));
                function = String.format("arctan(%f)", value);
                break;
            default:
                System.out.println("Opción no válida. Se usará Arcoseno por defecto.");
                result = Math.toDegrees(Math.asin(value));
                function = String.format("arcsin(%f)", value);
                break;
        }
        System.out.println("Resultado:");
        System.out.println(String.format("%s = %f°", function, result));
    }

    static void trigonomHip(Scanner userInput) {
        int angle = angleInput(userInput);
        double rad = Math.toRadians(angle);
        double result = 0;
        String function = "";
        System.out.println("Seleccione la función trigonométrica hiperbólica que desea realizar");
        System.out.println(String.format("   1 - Senh(%d)", angle));
        System.out.println(String.format("   2 - Cosh(%d)", angle));
        System.out.println(String.format("   3 - Tanh(%d)", angle));
        String option = userInput.nextLine().trim();
        switch (option) {
            case "1":
                result = Math.sinh(rad);
                function = String.format("sinh(%d)", angle);
                break;
            case "2":
                result = Math.cosh(rad);
                function = String.format("cosh(%d)", angle);
                break;
            case "3":
                result = Math.tanh(rad);
                function = String.format("tanh(%d)", angle);
                break;
            default:
                System.out.println("Opción no válida. Se usará Senh por defecto.");
                result = Math.sinh(rad);
                function = String.format("sinh(%d)", angle);
                break;
        }
        System.out.println("Resultado:");
        System.out.println(String.format("%s = %f", function, result));
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione la operación que desea realizar");
            System.out.println("   1 - Operación trigonométrica");
            System.out.println("   2 - Operación trigonométrica inversa");
            System.out.println("   3 - Operación trigonométrica hiperbólica");
            System.out.println("   - - Salir");
            String option = userInput.nextLine().trim();
            switch (option) {
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
                    System.out.println("Cerrando...");
                    userInput.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }
    }
}
