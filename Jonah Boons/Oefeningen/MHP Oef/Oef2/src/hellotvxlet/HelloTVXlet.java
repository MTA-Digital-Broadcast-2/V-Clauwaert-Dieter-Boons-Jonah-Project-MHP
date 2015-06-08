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
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HComponent;//scene
import org.dvb.ui.DVBColor;



public class HelloTVXlet implements Xlet, UserEventListener {

 private Image schip;
 int schipx=10;
 int schipy=500;
 private Image sterren;
 int sterrenx=0;
 int sterreny=0;
 public MijnComponent mc;
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
      EventManager.getInstance().addUserEventListener(this, uev);
      
      Timer t=new Timer();
      MijnTimerTask mtt= new MijnTimerTask();
      mtt.setCallBack(this); // stuur link naar dit object door om callback aan te roepen
      t.scheduleAtFixedRate(mtt, 0, 100); //start op 0 ms, elke 100ms
      
      
    }
        public class MijnComponent extends HComponent {
            
            public MijnComponent() {
                this.setBounds(0,0,10000,10000);
                
                schip=this.getToolkit().getImage("schip.png");
                MediaTracker mt = new MediaTracker(this);
                mt.addImage(schip, 0);
                sterren=this.getToolkit().getImage("sterren.png");
                mt.addImage(sterren, 0);
                try {
                    
                    mt.waitForAll();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
               
            
                }
            
          
            public void verplaatsSchip (int x, int y)
        {
            schipx+=x;
            schipy+=y;
            if (schipx>710) schipx=-40;
            if (schipx<-40) schipx=710;
            this.repaint();
        }
            
            public void verplaatsSterren (int x, int y)
            {
                sterrenx+=x;
                sterreny+=y;
                if (sterreny>570) sterreny-=570; //terugspringen
                this.repaint();
            }
             public void paint(Graphics g) {
                g.setColor(new DVBColor (255,0,0,255));
                //g.drawLine(0,0,200,200);
                //g.drawString("Testing lel", 70, 20);
                g.drawImage(sterren, sterrenx, sterreny, this);
                g.drawImage(sterren, sterrenx, sterreny-570, this);
                g.drawImage(schip, schipx, schipy, this);
            }
             
            }
        
        
        
  
    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startXlet() throws XletStateChangeException {
       
        
        }
    

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }
    public void callback() {
          System.out.println("callback");
          mc.verplaatsSterren(0,1);
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
            
        }
    }
    }

}
