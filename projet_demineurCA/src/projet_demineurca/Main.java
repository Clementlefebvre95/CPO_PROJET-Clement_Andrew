/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_demineurca;

import java.util.Scanner;

/**
 *
 * @author cleme
 */
// src/Demineur/Main.java

public class Main {
    public static void main(String[] args) {
        try {
            // Lancer la partie
            Partie partie = new Partie();
            Scanner scanner = null;
            partie.demarrerPartie(scanner);
        } catch (Exception e) {
            // Gérer les erreurs inattendues pour éviter un crash
            System.out.println("Une erreur s'est produite : " + e.getMessage());
            
        }
        
    }
  }
