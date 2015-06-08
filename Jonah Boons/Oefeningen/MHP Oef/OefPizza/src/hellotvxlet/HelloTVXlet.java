package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import org.davic.resources.*;

import org.havi.ui.event.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;


public class HelloTVXlet implements Xlet, ResourceClient, 
        HBackgroundImageListener, UserEventListener
{

    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg1 = new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage agrondimg2 = new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage agrondimg3 = new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage agrondimg4 = new HBackgroundImage("pizza4.m2v");
    public void notifyRelease(ResourceProxy proxy) {}
    public void release(ResourceProxy proxy) {}
    public boolean requestRelease(ResourceProxy proxy, Object requestData)
    {
        return false;
    }
    
    public void imageLoaded (HBackgroundImageEvent e)
    {
        try {
            bgConfiguration.displayImage(agrondimg1);
            bgConfiguration.displayImage(agrondimg2);
            bgConfiguration.displayImage(agrondimg3);
            bgConfiguration.displayImage(agrondimg4);
        }
        catch (Exception s) {
            System.out.println(s.toString());
        }
        }
    
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        //key shit
    UserEventRepository uev=new UserEventRepository("mijn verzameling");
    uev.addKey(HRcEvent.VK_LEFT);
    uev.addKey(HRcEvent.VK_RIGHT);
    //stuur de verzameling naar de EventManager (met link naar dit object)
    EventManager.getInstance().addUserEventListener(this, uev);
    
      //HScreen object opvragen
        screen = HScreen.getDefaultHScreen();
        
        //HBackgroundDevice opvragen
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        //HBackgroundDevice proberen te reserven
        if (bgDevice.reserveDevice(this)) {
            System.out.println("BackgroundImage device has been reserved");
        }
        else {
            System.out.println("Background image device cannot be reserved");
        }
        
        //Template maken
        bgTemplate = new HBackgroundConfigTemplate();
        
        //configuratieinstelling "STILL_IMAGE"
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
                HBackgroundConfigTemplate.REQUIRED);
        
        //configuratie aanvragen en activeren indien OK
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.
                getBestConfiguration(bgTemplate);
        try {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch (java.lang.Exception e){
            System.out.println(e.toString());
        }
     
    }

    public void startXlet() {
    System.out.println("startXlet");
    //image laden
    agrondimg1.load(this);
    }

    public void pauseXlet() {
     System.out.println("pauseXlet");
    }

    public void destroyXlet(boolean unconditional) {
     System.out.println("destroyXlet");
     agrondimg1.flush();
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void userEventReceived(UserEvent e) {
    if (e.getType()==HRcEvent.KEY_PRESSED) { //enkel indrukken niet loslaten
        switch (e.getCode())
        {
            case HRcEvent.VK_LEFT:
            System.out.println("links");
            
            agrondimg1.flush();
            agrondimg2.flush();
            agrondimg3.flush();
            agrondimg4.flush();
            agrondimg4.load(this);
            break;
            
            case HRcEvent.VK_RIGHT:
            System.out.println("rechts");
            agrondimg1.flush();
            agrondimg2.flush();
            agrondimg3.flush();
            agrondimg4.flush();
            agrondimg2.load(this);
            break;
            
        }
    }
    }
}
