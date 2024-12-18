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

    static void setVisible(boolean b)  {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private GrilleDeJeu grille;
    private int vies;

    // Initialisation de la partie
    public void initialiserPartie(int lignes, int colonnes, int bombes) {
        grille = new GrilleDeJeu(lignes, colonnes, bombes);
        vies = 3;
    }

    // Démarrage de la partie
    public void demarrerPartie(Scanner scanner) {
        while (vies>0) {
            System.out.println(grille.toString());
            System.out.println("Entrez les coordonnees pour reveler une cellule :");
            System.out.println("Saisir la ligne");

            int ligne = scanner.nextInt();
            System.out.println("saisir la colonne");
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
                vies--;
                afficherViesRestantes();
                
                if (vies==0){
                    System.out.println("Vous avez perdu toutes vos vies");
                    System.out.println("La partie est termine");
                    break;
                }
            }
        
        } }      
    
private void afficherViesRestantes(){
                System.out.println("Vies restantes: "+ vies);
            

        }
}
    



