package projetdéminuerfinal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferre
 */
public class Cellule {
    
    private boolean presenceBombe;
    boolean devoilee;
    private int nbBombesAdjacentes;

    // Constructeur
    public Cellule() {
        this.presenceBombe = false;
        this.devoilee = false;
        this.nbBombesAdjacentes = 0;
    }

    // Getter pour la présence de bombe
    public boolean getPresenceBombe() {
        return presenceBombe;
    }

    // Getter pour le nombre de bombes adjacentes
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

    // Définit le nombre de bombes adjacentes
    public void setNbBombesAdjacentes(int nb) {
        this.nbBombesAdjacentes = nb;
    }

    // Retourne une représentation textuelle de la cellule
    @Override
    public String toString() {
        if (!devoilee) return "?";
        if (presenceBombe) return "B";
        if (nbBombesAdjacentes > 0) return String.valueOf(nbBombesAdjacentes);
        return " ";
    }
}
