/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetdéminuerfinal;

/**
 *
 * @author ferre
 */
import java.util.Scanner;

public class ProjetDéminuerFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Configuration de la partie
        
         Scanner scanner = new Scanner(System.in);

        // Saisie des paramètres de la grille
        System.out.println("Bienvenue dans le jeu de Démineur !");
        System.out.print("Entrez le nombre de lignes pour la grille : ");
        int lignes = scanner.nextInt();

        System.out.print("Entrez le nombre de colonnes pour la grille : ");
        int colonnes = scanner.nextInt();

        System.out.print("Entrez le nombre de bombes : ");
        int bombes = scanner.nextInt();

        // Vérification des paramètres
        if (lignes <= 0 || colonnes <= 0 || bombes <= 0 || bombes >= lignes * colonnes) {
            System.out.println("Paramètres invalides. Vérifiez que les dimensions sont positives et que le nombre de bombes est raisonnable.");
            return;
        }

        // Initialisation et démarrage de la partie
        try {
            Partie partie = new Partie(lignes, colonnes, bombes);
            partie.demarrerPartie();
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
        System.out.println("Merci d'avoir joué !");
    }
}

        
    


