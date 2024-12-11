/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_demineurca;

import java.util.Scanner;

public class Projet_demineurCA {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenue dans le jeu Démineur !");
            System.out.print("Entrez le nombre de lignes : ");
            int lignes = scanner.nextInt();

            System.out.print("Entrez le nombre de colonnes : ");
            int colonnes = scanner.nextInt();

            System.out.print("Entrez le nombre de bombes : ");
            int bombes = scanner.nextInt();

            Partie partie = new Partie();
            partie.initialiserPartie(lignes, colonnes, bombes);  // Appel de la méthode correctement
            partie.demarrerPartie(scanner);
        }
    }
}
