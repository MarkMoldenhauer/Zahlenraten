package zahlenraten;

import java.util.Random;
import java.util.Scanner;

public class SinglePlayerMode {

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean weiterspielen = true;

        System.out.println("\nWillkommen zum Zahlenratespiel - Einzelspieler-Modus!");

        while (weiterspielen) {

            int kleinsteZahl = 0;
            int groessteZahl = 0;

            while (true) {
                System.out.print("Bitte gib die Untergrenze ein: ");
                if (scanner.hasNextInt()) {
                	kleinsteZahl = scanner.nextInt();
                } else {
                    System.out.println("Bitte gib eine gültige ganze Zahl ein!");
                    scanner.next();
                    continue;
                }

                System.out.print("Bitte gib die Obergrenze ein: ");
                if (scanner.hasNextInt()) {
                	groessteZahl = scanner.nextInt();
                } else {
                    System.out.println("Bitte gib eine gültige ganze Zahl ein!");
                    scanner.next();
                    continue;
                }

                if (groessteZahl > kleinsteZahl) {
                    break;
                } else {
                    System.out.println("Die Obergrenze muss größer als die Untergrenze sein. Bitte erneut eingeben.");
                }
            }

            int zahl = random.nextInt(groessteZahl - kleinsteZahl + 1) + kleinsteZahl;
            System.out.println("Ich habe mir eine Zahl zwischen " + kleinsteZahl + " und " + groessteZahl + " ausgedacht. Rate sie!");

            boolean eingabeKorrekt = false;
            int versuche = 0;

            while (!eingabeKorrekt) {
                System.out.print("Gib bitte deine Zahl ein: ");
                int eingabe;

                if (!scanner.hasNextInt()) {
                    System.out.println("Bitte gib eine gültige ganze Zahl ein!");
                    scanner.next();
                    continue;
                }

                eingabe = scanner.nextInt();
                versuche++;

                if (eingabe == zahl) {
                    System.out.println("Richtig!");
                    System.out.println("Du hast " + versuche + " Versuch(e) gebraucht.");
                    eingabeKorrekt = true;
                } else {
                    System.out.println("Falsch! Versuch es noch mal!");
                }
            }

            System.out.print("\nNoch mal spielen? Wenn ja, tippe 1 (und Enter), sonst egal was (und Enter): ");
            String nochmal = scanner.next();

            if (!nochmal.equals("1")) {
                weiterspielen = false;
                System.out.println("\nTschüss! Bis zum nächsten Mal :-)");
            }
        }

        scanner.close();
    }
}