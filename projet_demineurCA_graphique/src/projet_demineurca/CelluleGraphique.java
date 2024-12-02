package projet_demineurca;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cleme
 */



import java.awt.Graphics;
import javax.swing.JButton;
import projet_demineurca.Cellule;

public class CelluleGraphique extends JButton {
        Cellule cellule ;
        int x ;
        int y ;

    public CelluleGraphique(Cellule cellule, int x, int y) {
        this.x = x;
        this.y = y;
        this.cellule = cellule;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(cellule.toString());
    }
}
    