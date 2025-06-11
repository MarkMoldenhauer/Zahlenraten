package zahlenraten;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean weiterspielen = true;

        System.out.println("Willkommen zum Zahlenratespiel!");
        System.out.println("Wähle einen Modus:");
        System.out.println("1. Einzelspieler-Modus");
        System.out.println("2. Versus-Modus");

        int modus;
        while (true) {
            System.out.print("Gib 1 oder 2 ein: ");
            if (scanner.hasNextInt()) {
                modus = scanner.nextInt();
                if (modus == 1 || modus == 2) {
                    break;
                } else {
                    System.out.println("Ungültige Eingabe. Bitte wähle 1 oder 2.");
                }
            } else {
                System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
                scanner.next();
            }
        }

        if (modus == 1) {
            new SinglePlayerMode().main(args);
        } else {
            new VersusMode().main(args);
        }

        scanner.close();
    }
}
