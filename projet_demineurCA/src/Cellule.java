/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferre
 */
public class Cellule {
    

    // Attributs privés
    private boolean presenceBombe; // Indique si une bombe est présente
    boolean devoilee;      // Indique si la cellule est dévoilée
    private int nbBombesAdjacentes; // Nombre de bombes adjacentes

    // Constructeur
    public Cellule() {
        this.presenceBombe = false;
        this.devoilee = false;
        this.nbBombesAdjacentes = 0;
    }

    // Accesseur pour la présence d'une bombe
    public boolean getPresenceBombe() {
        return presenceBombe;
    }

    // Accesseur pour le nombre de bombes adjacentes
    public int getNbBombesAdjacentes() {
        return nbBombesAdjacentes;
    }

    // Place une bombe dans la cellule
    public void placerBombe() {
        this.presenceBombe = true;
    }

    // Révèle la cellule
    public void revelerCellule() {
        this.devoilee = true;
    }

    // Modifie le nombre de bombes adjacentes
    public void setNbBombesAdjacentes(int nb) {
        this.nbBombesAdjacentes = nb;
    }

    // Représente la cellule sous forme de chaîne de caractères
    @Override
    public String toString() {
        if (!devoilee) {
            return "?"; // Cellule non dévoilée
        } else if (presenceBombe) {
            return "B"; // Bombe révélée
        } else if (nbBombesAdjacentes > 0) {
            return Integer.toString(nbBombesAdjacentes); // Nombre de bombes adjacentes
        } else {
            return " "; // Cellule vide
        }
    }
}

