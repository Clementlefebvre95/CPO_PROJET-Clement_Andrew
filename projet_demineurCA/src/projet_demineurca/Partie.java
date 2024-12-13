/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferre
 */

package projet_demineurca;

import java.util.Scanner;

public class Partie {
    private GrilleDeJeu grille;

    // Initialisation de la partie
    public void initialiserPartie(int lignes, int colonnes, int bombes) {
        grille = new GrilleDeJeu(lignes, colonnes, bombes);
    }

    // Démarrage de la partie
    public void demarrerPartie(Scanner scanner) {
        while (true) {
            System.out.println(grille.toString());
            System.out.println("Entrez les coordonnees pour reveler une cellule :");
            System.out.println("Envoyer la ligne puis ensuite la colonne");

            int ligne = scanner.nextInt();
            int colonne = scanner.nextInt();

            // Vérification des coordonnées
            if (ligne < 0 || ligne >= grille.getNbLignes() || colonne < 0 || colonne >= grille.getNbColonnes()) {
                System.out.println("Coordonnees invalides, essayez encore.");
                continue;
            }

            try {
                grille.revelerCellule(ligne, colonne);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}


