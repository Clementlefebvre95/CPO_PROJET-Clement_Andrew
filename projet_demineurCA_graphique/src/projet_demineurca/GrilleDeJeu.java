/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferre
 */

package projet_demineurca ;

import java.util.Random;

public class GrilleDeJeu {

    static void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    final Cellule[][] matriceCellules;
    private final int nbLignes;
    private final int nbColonnes;
    private final int nbBombes;

    // Constructeur
    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.matriceCellules = new Cellule[nbLignes][nbColonnes];

        // Initialisation des cellules
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new Cellule();
            }
        }

        // Placement des bombes aléatoirement
        placerBombesAleatoirement(PROPERTIES, PROPERTIES);
        // Calcul des bombes adjacentes
        calculerBombesAdjacentes();
    }

    // Accesseurs
    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    // Place les bombes aléatoirement dans la grille
    private void placerBombesAleatoirement(int PROPERTIES, int PROPERTIES1) {
        Random rand = new Random();
        int bombesPlacees = 0;

        while (bombesPlacees < nbBombes) {
            int ligne = rand.nextInt(nbLignes);
            int colonne = rand.nextInt(nbColonnes);

            if (!matriceCellules[ligne][colonne].getPresenceBombe()) {
                matriceCellules[ligne][colonne].placerBombe();
                bombesPlacees++;
            }
        }
    }

    // Calcule le nombre de bombes adjacentes pour chaque cellule
    private void calculerBombesAdjacentes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].getPresenceBombe()) {
                    int bombesAdjacentes = compterBombesAdjacentes(i, j);
                    matriceCellules[i][j].setNbBombesAdjacentes(bombesAdjacentes);
                }
            }
        }
    }

    // Compte les bombes adjacentes à une cellule donnée
    private int compterBombesAdjacentes(int ligne, int colonne) {
        int compteur = 0;

        for (int i = ligne - 1; i <= ligne + 1; i++) {
            for (int j = colonne - 1; j <= colonne + 1; j++) {
                if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes) {
                    if (matriceCellules[i][j].getPresenceBombe()) {
                        compteur++;
                    }
                }
            }
        }

        return compteur;
    }

    // Révèle une cellule spécifique
    public void revelerCellule(int ligne, int colonne) {
        if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes) {
            return; // Indice hors limites
        }

        Cellule cellule = matriceCellules[ligne][colonne];
        if (cellule.getPresenceBombe()) {
            throw new RuntimeException("Bombe déclenchee !");
        }

        cellule.revelerCellule();

        // Si aucune bombe adjacente, révèle les cellules adjacentes
        if (cellule.getNbBombesAdjacentes() == 0) {
            for (int i = ligne - 1; i <= ligne + 1; i++) {
                for (int j = colonne - 1; j <= colonne + 1; j++) {
                    if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes) {
                        if (!matriceCellules[i][j].devoilee) {
                            revelerCellule(i, j);
                        }
                    }
                }
            }
        }
    }

    // Représente la grille sous forme de chaîne de caractères
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void initialiserGrille() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
