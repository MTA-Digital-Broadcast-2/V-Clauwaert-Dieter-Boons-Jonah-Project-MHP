package hellotvxlet;

import java.awt.*;
import java.util.ArrayList;
import org.havi.ui.*;

public class MijnComponent extends HComponent{
    
    private Image player, sterren, enemy, playerLaser;
    int playerX = 300, playerY = 500, sterrenX = 0, sterrenY = 0, 
        playerLaserX = 0, playerLaserY = 0, enemyLaserX = 0, enemyLaserY = 0;
    int enemyX = 300, enemyY= 10;

    
    public MijnComponent(){
        this.setBounds(0,0,720,576);
        
        sterren = this.getToolkit().getImage("sterren.png");
        player = this.getToolkit().getImage("schip.png");
        enemy = this.getToolkit().getImage("enemy.png");
        playerLaser = this.getToolkit().getImage("playerLaser.png");

        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(sterren, 0);

        try {
            mt.waitForAll();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void verplaatsSterren(int x, int y){
        sterrenX += x;
        sterrenY += y;
        if (sterrenY>570) sterrenY-=570;
        this.repaint();
        //heeft maar 1 keer repaint nodig
    }
    
    /*public void verplaatsPlayer(int x, int y){
        if (playerX > 0 && playerX < 672)
        {
        playerX += x;
        if (playerX <= 0)
        {
            playerX=1;
        }
        else if (playerX >= 672)
        {
            playerX=671;
        }
        }
        //this.repaint();
    }
    public void verplaatsEnemy (int x, int y)
     {
         enemyX= enemyX + x * direction;
        if (enemyX < 0 || enemyX > 656)
        {
            direction*=-1; //richting veranderen
            enemyY+=50;
        }
         if (enemyY > 576)
         {
             //als enemy onderkant van scherm raakt ben je verloren
             //you LOSE!!!!
         }
         //this.repaint();
     }
    
    public void verplaatsPlayerLaser ()
    {
        if (playerLaserY>-20) playerLaserY -= 3;
    }
    
    public void playerShoot (int x, int y)
    {
        playerLaserX = x + 21;
        playerLaserY = y - 20;
        verplaatsPlayerLaser();
    }
    
    public void verplaatsEnemyLaser ()
    {
        enemyLaserY += 2;
    }
    
    public void enemyShoot (int x, int y)
    {
         
        if (enemyLaserY<577 && enemyX%20==0) 
        {
            enemyLaserX = x + 31;
            enemyLaserY = y + 64;
            verplaatsEnemyLaser();
        }
    }*/
    
    
    public void paint (Graphics g){
        g.drawImage(sterren, sterrenX, sterrenY, this);
        g.drawImage(sterren, sterrenX, sterrenY-570, this);
        //g.drawImage(player, playerX, playerY, this);
        //g.drawImage(enemy, enemyX, enemyY, this);
        //g.drawImage(playerLaser, playerLaserX, playerLaserY, this);

    }
}
