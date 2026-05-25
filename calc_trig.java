//Tarea Investigativa Java
//Autores:
// - Alexa Herrera
// - Jordanny Hernández

import java.util.Scanner;   //Permite obtener datos de entrada en la terminal

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
    static int angleInput() {
        Scanner userInput = new Scanner(System.in);           //Define userInput como un objeto Scanner. NOTA: El nombre userInput se usa en general para definir el objeto Scanner en todo el codigo

        // El siguiente bloque de código se repite indefinidamente hasta que el usuario ingrese un dato válido (un entero). Si el usuario ingresa un dato no permitido, se muestra un mensaje de error y se limpia el buffer de entrada para permitir una nueva entrada. Una vez que se ingresa un dato válido, el bucle se rompe y se devuelve el valor del ángulo ingresado.
        while (true) {
            try {
                System.out.println("Ángulo a calcular:");
                int angle = userInput.nextInt();                 //Lee un entero desde la entrada del usuario y lo asigna a la variable 'angle'
                userInput.close();
                return angle;                                  //Devuelve el valor del ángulo ingresado
            } catch (Exception e) {
                System.out.println("Se ha ingresado un dato no permitido");
                userInput.nextLine();           // Limpia el buffer de entrada
            }
            
        }
    }

    //Funciones/Metodos trigonometricos

    static void trigonom() {
        int angle = angleInput();     //Llama a la función angleInput() para obtener el ángulo ingresado por el usuario y lo asigna a la variable 'angle'
        System.out.println("Ángulo ingresado: " + angle);   //Imprime el ángulo ingresado por el usuario
    }
    static void trigonomInv() {}
    static void trigonomHip() {}


    public static void main(String[] args) {
        //Se repite el código hasta que el usuario ingrese un "-"
        while (true) {
            Scanner userInput = new Scanner(System.in);

            formatPrintl("Calculadora Trigonométrica Java", '-');
            System.out.println("Seleccione la operación que desea realizar");
            System.out.println("   1 - Operación trigonométrica");
            System.out.println("   2 - Operación trigonométrica inversa");
            System.out.println("   3 - Operación trigonométrica hiperbólica");

            String option = userInput.nextLine();

            System.out.println(option); //Comprobar entrada de usuario



            switch (option) { //Evalua "option" según el valor que tenga
                case "1":
                    trigonom();
                    break;
                case "2":
                    trigonomInv();
                    break;
                case "3":
                default:
                    userInput.close();
                    break;
            }
        }        
    }
}
