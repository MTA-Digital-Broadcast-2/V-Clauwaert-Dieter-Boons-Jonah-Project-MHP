package hellotvxlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Timer;
import javax.tv.xlet.*; //context
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HComponent;//scene


public class HelloTVXlet implements Xlet, UserEventListener {

  private Image user;
  int userX=50;
  int userY=500;
  private Image backGround;
  int backX;
  int backY;
  private Image enemy;
  int enemyX=50;
  int enemyY=10;
  public MijnComponent mc;
  int direction=1;
  
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      HScene scene = HSceneFactory.getInstance().getDefaultHScene();
      mc = new MijnComponent();
      scene.add(mc);
      scene.validate();
      scene.setVisible(true);
      UserEventRepository uev=new UserEventRepository("mijn verzameling");
      uev.addKey(HRcEvent.VK_LEFT);
      uev.addKey(HRcEvent.VK_RIGHT);
      //stuur de verzameling naar de EventManager (met link naar dit object)
      EventManager.getInstance().addUserEventListener(this,uev);
      
      Timer t=new Timer();
      MijnTimerTask mtt= new MijnTimerTask();
      mtt.setCallBack(this); // stuur link naar dit object door om callback aan te roepen
      t.scheduleAtFixedRate(mtt, 0, 100); //start op 0 ms, elke 100ms
      
      
      
     
    }
    
    public class MijnComponent extends HComponent {
            
            public MijnComponent() {
                this.setBounds(0,0,10000,10000);
                
                user=this.getToolkit().getImage("schip.png");
                MediaTracker mt = new MediaTracker(this);
                mt.addImage(user, 0);
                backGround=this.getToolkit().getImage("sterren.png");
                mt.addImage(backGround, 0);
                enemy=this.getToolkit().getImage("schip.png");
                mt.addImage(enemy, 0);
                try {
                    
                    mt.waitForAll();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
               
            
                }
            public void verplaatsSchip (int x, int y)
        {
            userX+=x;
            userY+=y;
            if (userX>710) userX=-40;
            if (userX<-40) userX=710;
            this.repaint();
        }
            
            public void verplaatsSterren (int x, int y)
            {
                backX+=x;
                backY+=y;
                if (backY>570) backY-=570; //terugspringen
                this.repaint();
            }
            
            public void verplaatsEnemy (int x, int y)
             {
                 enemyX= enemyX + x * direction;
                if (enemyX < 0 ||  enemyX > 700)
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
                 this.repaint();
             }
            
             public void paint(Graphics g) {
                g.setColor(new DVBColor (255,0,0,255));
                g.drawImage(backGround, backX, backY, this);
                g.drawImage(backGround, backX, backY-570, this);
                g.drawImage(user, userX, userY, this);
                g.drawImage(enemy, enemyX, enemyY, this);
            }
             
             
             
            }
    

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    public void callback() {
          System.out.println("callback");
          mc.verplaatsSterren(0,1);
          mc.verplaatsEnemy(5, 0);
      }
    public void userEventReceived(UserEvent e) {
    if (e.getType()==HRcEvent.KEY_PRESSED) { //enkel indrukken niet loslaten
        switch (e.getCode())
        {
            case HRcEvent.VK_LEFT:
            System.out.println("links");
            mc.verplaatsSchip(-10, 0);
            break;
            
            case HRcEvent.VK_RIGHT:
            System.out.println("rechts");
            mc.verplaatsSchip(10, 0);
            break;
            
            case HRcEvent.VK_SPACE:
            System.out.println("Shoot");
            //shoot methode
            break;
            
        }
    }
    }
}

