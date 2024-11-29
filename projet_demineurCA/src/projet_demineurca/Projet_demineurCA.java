/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_demineurca;

/**
 *
 * @author cleme
 */
public class Projet_demineurCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Création d'une instance de Partie
        Partie partie = new Partie();

        // Initialisation de la partie avec une grille 5x5 et 5 bombes (modifiable)
        partie.initialiserPartie(5, 5, 5);

        // Démarrage de la partie
        partie.demarrerPartie();
    }
    }
    
