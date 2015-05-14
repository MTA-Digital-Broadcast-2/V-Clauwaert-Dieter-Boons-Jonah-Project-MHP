package hellotvxlet;

import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;

public class MijnComponent extends HComponent{
    
    private Image schip, sterren, enemy, playerLaser, enemyLaser;
    int schipX = 300, schipY = 500, sterrenX = 0, sterrenY = 0;
    int enemyX = 300, enemyY= 10, direction=1;
    
    public MijnComponent(){
        this.setBounds(0,0,720,576);
        
        schip = this.getToolkit().getImage("schip.png");
        sterren = this.getToolkit().getImage("sterren.png");
        enemy = this.getToolkit().getImage("enemy.png");
        playerLaser = this.getToolkit().getImage("playerLaser.png");
        enemyLaser = this.getToolkit().getImage("enemyLaser.png");
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schip, 0);
        mt.addImage(sterren, 0);
        mt.addImage(enemy, 0);
        mt.addImage(playerLaser, 0);
        mt.addImage(enemyLaser, 0);
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
    
    public void verplaatsSchip(int x, int y){
        if (schipX > 0 && schipX < 672)
        {
        schipX += x;
        if (schipX <= 0)
        {
            schipX=1;
        }
        else if (schipX >= 672)
        {
            schipX=671;
        }
        }
        //this.repaint();
    }
    public void verplaatsEnemy (int x, int y)
             {
                 enemyX= enemyX + x * direction;
                if (enemyX < 0 ||  enemyX > 650)
                {
                    //700 nog aanpassen tot breedte van picturebox!
                    direction*=-1; //richting veranderen
                    enemyY+=50;
                }
                 if (enemyY > 500)
                 {
                     //als enemy onderkant van scherm raakt ben je verloren
                     //you LOSE!!!!
                 }
                 //this.repaint();
             }
    
    public void playerShoot (int x, int y)
    {
        System.out.println(x + " -- " + y);
    }
    
    public void paint (Graphics g){
        g.drawImage(sterren, sterrenX, sterrenY, this);
        g.drawImage(sterren, sterrenX, sterrenY-570, this);
        g.drawImage(schip, schipX, schipY, this);
        g.drawImage(enemy, enemyX, enemyY, this);
        g.drawImage(playerLaser, 60, 200, this);
        g.drawImage(enemyLaser, 50, 200, this);
        
        //laser hiden => coordinaten instellen tot buiten zichtbaar veld
    }
}
