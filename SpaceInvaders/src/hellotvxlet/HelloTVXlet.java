package hellotvxlet;


import java.awt.event.*;
import java.util.*;
import javax.tv.xlet.*;
import org.dvb.event.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, UserEventListener{
    
    MijnComponent mc;
    LaserManager laserman=new LaserManager();
    HScene scene;
    
    Random rgen=new Random();
    Player speler;
    Enemy enemy=new Enemy();
    int deler=0;    
    Timer t;
        
    public HelloTVXlet() {
        
    }
 public void initXlet(XletContext context) 
 {
     this.startSpel();
 }
    public void startSpel() {
        scene = HSceneFactory.getInstance().getDefaultHScene();   
        mc = new MijnComponent();     
        laserman.setScene(scene);
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        //voeg toetsen toe aan verzameling
        uev.addAllArrowKeys();
                
        //stuur de verzameling naar de EventManager (met link naar dit object)
        EventManager.getInstance().addUserEventListener(this, uev);

       
        speler=new Player();
        speler.move(300,500);
        scene.add(speler);
        scene.popToFront(speler);
        
        enemy=new Enemy();
        enemy.move(300,10);
        scene.add(enemy);
        scene.popToFront(enemy);
        
                t = new Timer();
        MijnTimerTask mtt = new MijnTimerTask();
        mtt.setCallBack(this); //stuur link naar dit object om callback aan te roepen
        t.scheduleAtFixedRate(mtt, 0, 10); //start op 0, elke 100 ms
    }
    
    void callback() {
        //System.out.println("callback()");
        
        mc.verplaatsSterren(0,1);
        if (enemy!=null) enemy.verplaatsEnemy(1);
        
        //mc.verplaatsPlayerLaser();
     //   mc.enemyShoot(mc.enemyX, mc.enemyY);
        deler++;
        if (rgen.nextInt(20)==10)
        {
        EnemyLaser eLaser=new EnemyLaser();
        eLaser.move(enemy.getX()+32, enemy.getY()+64);
        laserman.addEnemyLaser(eLaser);        
        scene.add(eLaser);
        scene.popToFront(eLaser);
        deler=0;
        }        
        //mc.verplaatsEnemyLaser();
        laserman.moveAllLasers();
        if (laserman.testPlayerCollision(speler)) System.out.println("YOU LOSE!!!!!");
        if (laserman.testEnemyCollision(enemy)) System.out.println("HIT!!!!!");
    }
    
    public void startXlet() {
    }

    public void pauseXlet() {
     
    }
    
    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        if (e.getType()==HRcEvent.KEY_PRESSED){ //enkel indrukken, niet loslaten
            switch (e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("links!!!");
                    speler.moverel(-10, 0);
                   
                    
                    scene.dispose(); 
                    //timer nog stoppen
                      t.cancel();
                      scene = HSceneFactory.getInstance().getDefaultHScene(); 
                      scene.add(new HStaticText("hallo",10,10,200,200));
                      scene.validate();
                      scene.setVisible(true);
                      //start
                      
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("rechts!!!");
                    speler.moverel(10, 0);
                    
                    
                      scene.dispose();
                      this.startSpel();
                      
                      
                    break;
                case HRcEvent.VK_UP:                    
                    System.out.println("player shoot!!!");
                    PlayerLaser pLaser=new PlayerLaser();
                    pLaser.move(speler.getX()+21, speler.getY()-20);
                    laserman.addPlayerLaser(pLaser);                     
                    scene.add(pLaser);
                    scene.popToFront(pLaser);
                    //mc.playerShoot(mc.playerX, mc.playerY);
                    break;
            }
        }
    }
}
