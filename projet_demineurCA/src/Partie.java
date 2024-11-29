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
    private GrilleDeJeu grille;

    // Initialisation de la partie
    public void initialiserPartie(int lignes, int colonnes, int bombes) {
        grille = new GrilleDeJeu(lignes, colonnes, bombes);
    }

    // Démarrage de la partie
    public void demarrerPartie() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(grille.toString());
            System.out.println("Entrez les coordonnées (ligne et colonne) pour révéler une cellule :");

            int ligne = scanner.nextInt();
            int colonne = scanner.nextInt();

            try {
                grille.revelerCellule(ligne, colonne);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        scanner.close();
    }
}
    

