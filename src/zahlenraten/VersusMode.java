package zahlenraten;

import java.util.Scanner;

public class VersusMode {

 public void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     boolean weiterspielen = true;
     int runde = 1;

     System.out.println("\nWillkommen zum Zahlenratespiel - Versus-Modus!");

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

         String denkSpieler = (runde % 2 == 1) ? "Spieler 1" : "Spieler 2";
         String ratSpieler  = (runde % 2 == 1) ? "Spieler 2" : "Spieler 1";

         System.out.println("\n" + denkSpieler + " denkt sich eine Zahl aus.");
         System.out.println(ratSpieler + " wird raten.");

         int geheimeZahl = 0;
         while (true) {
             System.out.print(denkSpieler + ": Bitte denke dir eine Zahl zwischen " + kleinsteZahl + " und " + groessteZahl + ": ");
             if (scanner.hasNextInt()) {
                 geheimeZahl = scanner.nextInt();
                 if (geheimeZahl >= kleinsteZahl && geheimeZahl <= groessteZahl) {
                     break;
                 } else {
                     System.out.println("Die Zahl muss innerhalb des gewählten Bereichs liegen.");
                 }
             } else {
                 System.out.println("Bitte gib eine gültige ganze Zahl ein!");
                 scanner.next();
             }
         }

         for (int i = 0; i < 30; i++) System.out.println();

         System.out.println("Ich habe mir eine Zahl zwischen " + kleinsteZahl + " und " + groessteZahl + " ausgedacht. Rate sie!");

         int versuche = 0;
         boolean korrekt = false;

         while (!korrekt) {
             System.out.print("Gib bitte deine Zahl ein: ");
             int tipp;

             if (!scanner.hasNextInt()) {
                 System.out.println("Bitte gib eine gültige ganze Zahl ein!");
                 scanner.next();
                 continue;
             }

             tipp = scanner.nextInt();
             versuche++;

             if (tipp == geheimeZahl) {
                 System.out.println("\nRichtig!");
                 System.out.println("Du hast " + versuche + " Versuch(e) gebraucht.");
                 korrekt = true;
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

         runde++;
     }

     scanner.close();
 }
}