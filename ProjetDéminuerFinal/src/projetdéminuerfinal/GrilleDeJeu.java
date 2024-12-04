package projetdéminuerfinal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferre
 */




import java.util.Random;

public class GrilleDeJeu {
    // Attributs privés
    private Cellule[][] matriceCellules; // Grille de cellules
    private int nbLignes; // Nombre de lignes de la grille
    private int nbColonnes; // Nombre de colonnes de la grille
    private int nbBombes; // Nombre total de bombes

    // Constructeur
    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;

        // Initialisation de la matrice des cellules
        matriceCellules = new Cellule[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new Cellule();
            }
        }

        // Placement des bombes et calcul des bombes adjacentes
        placerBombesAleatoirement();
        calculerBombesAdjacentes();
    }

    // Getters
    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }

    // Place les bombes aléatoirement sur la grille
    private void placerBombesAleatoirement() {
        Random rand = new Random();
        int bombesPlacees = 0;
        while (bombesPlacees < nbBombes) {
            int i = rand.nextInt(nbLignes);
            int j = rand.nextInt(nbColonnes);

            // Place une bombe si la cellule n'en contient pas déjà
            if (!matriceCellules[i][j].getPresenceBombe()) {
                matriceCellules[i][j].placerBombe();
                bombesPlacees++;
            }
        }
    }

    // Calcule et met à jour le nombre de bombes adjacentes pour chaque cellule
    private void calculerBombesAdjacentes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].getPresenceBombe()) {
                    int compteur = 0;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ni = i + di;
                            int nj = j + dj;

                            // Vérifie que la cellule adjacente est valide et contient une bombe
                            if (ni >= 0 && ni < nbLignes && nj >= 0 && nj < nbColonnes &&
                                    matriceCellules[ni][nj].getPresenceBombe()) {
                                compteur++;
                            }
                        }
                    }
                    matriceCellules[i][j].setNbBombesAdjacentes(compteur);
                }
            }
        }
    }

    // Révèle une cellule spécifique
    public boolean revelerCellule(int ligne, int colonne) {
        // Vérifie les limites de la grille
        if (ligne < 0 || ligne >= nbLignes || colonne < 0 || colonne >= nbColonnes) {
            return false;
        }

        Cellule cellule = matriceCellules[ligne][colonne];

        // Si la cellule est déjà dévoilée, ne rien faire
        if (cellule.devoilee) {
            return false;
        }

        // Révèle la cellule
        cellule.revelerCellule();

        // Si c'est une bombe, la partie doit signaler une explosion
        if (cellule.getPresenceBombe()) {
            return true;
        }

        // Si aucune bombe adjacente, propager la révélation
        if (cellule.getNbBombesAdjacentes() == 0) {
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    if (di != 0 || dj != 0) {
                        revelerCellule(ligne + di, colonne + dj);
                    }
                }
            }
        }
        return false;
    }

    // Vérifie si toutes les cellules sûres sont révélées
    public boolean toutesCellulesRevelees() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                Cellule cellule = matriceCellules[i][j];
                if (!cellule.getPresenceBombe() && !cellule.devoilee) {
                    return false;
                }
            }
        }
        return true;
    }

    // Renvoie un booléen indiquant si une cellule contient une bombe
    public boolean getPresenceBombe(int i, int j) {
        if (i < 0 || i >= nbLignes || j < 0 || j >= nbColonnes) {
            return false;
        }
        return matriceCellules[i][j].getPresenceBombe();
    }

    // Génère une représentation textuelle de la grille
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

    void afficherGrille() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
