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
        
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();   
        mc = new MijnComponent();     
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        //voeg toetsen toe aan verzameling
        uev.addAllArrowKeys();
                
        //stuur de verzameling naar de EventManager (met link naar dit object)
        EventManager.getInstance().addUserEventListener(this, uev);
        
        Timer t = new Timer();
        MijnTimerTask mtt = new MijnTimerTask();
        mtt.setCallBack(this); //stuur link naar dit object om callback aan te roepen
        t.scheduleAtFixedRate(mtt, 0, 10); //start op 0, elke 100 ms
    }
    
    void callback() {
        //System.out.println("callback()");
        mc.verplaatsSterren(0,1);
        mc.verplaatsEnemy(1, 0);
        
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
                    mc.verplaatsSchip(-5, 0);
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("rechts!!!");
                    mc.verplaatsSchip(5, 0);
                    break;
                case HRcEvent.VK_UP:
                    System.out.println("player shoot!!!");
                    mc.playerShoot(mc.schipX, mc.schipY);
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("down!!!");
                    mc.verplaatsSchip(0, 5);
                    break;
            }
        }
    }
}
