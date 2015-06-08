/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Enemy extends Sprite {
     int direction=1;
             
    public Enemy()
    {
        super("enemy.png");
    }
    public void verplaatsEnemy (int a)
     {
        this.x = x + a * direction;
        if (x< 0 || x > 656)
        {
            direction*=-1; //richting veranderen
            this.y+=50;
        }
         if (y > 576)
         {
             //als enemy onderkant van scherm raakt ben je verloren
             //you LOSE!!!!
         }
         //this.repaint();
        this.setBounds(x,y,this.getWidth(),this.getHeight());
     }
}
