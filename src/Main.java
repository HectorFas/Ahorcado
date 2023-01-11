import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

class Ahorcado {
        String palabra;
        int fallos = 0;

    public void play() {

        palabra = getRandomWord();
        int[] posicion = new int[20];
        posicion[0] = -1;
        String guiones = generaGuiones(palabra);
        System.out.println(palabra);
        System.out.print(guiones);

        for(;;) {
            char letra = pedirLetra();
            guiones = actualizarGuiones(palabra, letra, posicion);

            System.out.println(guiones);

        }
    }

    String getRandomWord() {
        try {
            Scanner scanner = new Scanner(new File("/usr/share/dict/spanish"));
            Random random = new Random();
            int numero = random.nextInt(80000);

            String palabra = "pepe";
            for (int i = 0; i < numero ; i++) {
                palabra = scanner.nextLine();
            }
            return palabra;
        } catch (FileNotFoundException e) {
            return  "pepe";
        }


    }

    String actualizarGuiones(String palabra, char letra, int[] posicion) {
        String resultat = "";

        for (int i = 0; i < palabra.length() ; i++) {
            if (palabra.charAt(i) == letra) {
                posicion[i] = i;
            } else {
                fallos++;
            }
        }
        for (int i = 0; i < palabra.length() ; i++) {
            if (i == posicion[i]) {
                System.out.print(palabra.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        return resultat;
    }




    char pedirLetra() {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        for (;;) {
            entrada = scanner.next();
            if (entrada.length() == 1) {
                break;
            } else {
                System.out.print("PON UNA LETRAAAAAAA");
            }
        }
        return  entrada.charAt(0);
    }

    String generaGuiones(String palabra) {
       return "-".repeat(palabra.length());
    }



}

public class Main {
    public static void main(String[] args) {
        new Ahorcado().play();

    }
}