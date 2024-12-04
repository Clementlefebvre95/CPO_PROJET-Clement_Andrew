package projetdéminuerfinal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferre
 */
import java.util.Scanner;

public class Partie {
    private final GrilleDeJeu grille;
    private int vies;

    // Initialisation de la partie avec configuration de la grille et des points de vie
    public Partie(int lignes, int colonnes, int bombes) {
        this.vies = 3; // Nombre initial de points de vie
        this.grille = new GrilleDeJeu(lignes, colonnes, bombes); // Grille de jeu
    }

    // Méthode principale pour démarrer et gérer la partie
    public void demarrerPartie() {
    System.out.println("Bienvenue dans le jeu de Démineur !");
    int cellulesRevelees = 0; // Compteur pour suivre les cellules découvertes

    while (vies > 0 && cellulesRevelees < (grille.getNbLignes() * grille.getNbColonnes() - grille.getNbBombes())) {
        grille.afficherGrille();
        System.out.println("Il vous reste " + vies + " vies.");
        System.out.print("Entrez une ligne : ");
        int ligne = scanner.nextInt();
        System.out.print("Entrez une colonne : ");
        int colonne = scanner.nextInt();

        // Vérification des coordonnées
        if (ligne < 0 || ligne >= grille.getNbLignes() || colonne < 0 || colonne >= grille.getNbColonnes()) {
            System.out.println("Coordonnées invalides. Veuillez réessayer !");
            continue;
        }

        // Révélation de la cellule
        if (grille.revelerCellule(ligne, colonne)) {
            vies--; // Une bombe a été trouvée
            System.out.println("BOUM ! Vous avez perdu une vie.");
        } else {
            System.out.println("Cellule sûre !");
            cellulesRevelees++;
        }

        // Vérification de victoire
        if (cellulesRevelees == (grille.getNbLignes() * grille.getNbColonnes() - grille.getNbBombes())) {
            System.out.println("Félicitations, vous avez gagné !");
            return;
        }
    }

    // Si on sort de la boucle avec vies == 0
    if (vies == 0) {
        System.out.println("Vous avez perdu toutes vos vies ! Game over.");
    }
}

            // Fermeture du scanner pour libérer les ressources
}
    

