package hellotvxlet;

import java.io.IOException;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.davic.resources.*;
import org.dvb.event.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {
    
    public int teller = 0;
    
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage bgimgA=new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage bgimgB=new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage bgimgC=new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage bgimgD=new HBackgroundImage("pizza4.m2v");
    
    public void notifyRelease(ResourceProxy proxy) { }
    public void release(ResourceProxy proxy) { }
    public boolean requestRelease(ResourceProxy proxy, Object requestData) {return false;}
    
    public void imageLoaded(HBackgroundImageEvent e)
    {
        try {
            bgConfiguration.displayImage(bgimgA);
        }
        catch (Exception s){
            System.out.println("Image kan niet geladen worden.");
        }
    }
    public void imageLoadFailed(HBackgroundImageEvent e)
    {
        System.out.println("Image kan niet geladen worden");
    }
        
    public void initXlet(XletContext context) {
        //HScreen object opvragen
        screen = HScreen.getDefaultHScreen();
        
        //HBackgroundDevice opvragen
        bgDevice = screen.getDefaultHBackgroundDevice();
        
        //HBackgroundDevice proberen te reserveren
        if (bgDevice.reserveDevice(this)){
            System.out.println("BackgroundImage device has been reserved");
        } 
        else {
            System.out.println("BackgroundImage device could not be reserved");
        }
        
        //Template maken
        bgTemplate = new HBackgroundConfigTemplate();
        
        //Configuratieinstelling "STILL_IMAGE"
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        //Configuratie aanvragen en activeren indien OK
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        
        try{
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch (java.lang.Exception e){
            System.out.println(e.toString());
        }
        
        UserEventRepository uev = new UserEventRepository("mijn verzameling");
        uev.addAllArrowKeys();
        EventManager.getInstance().addUserEventListener(this, uev);
    }
    
    public void startXlet() {
        System.out.println("startXlet");
        //image laden
        bgimgA.load(this);
    }

    public void pauseXlet() {
        System.out.println("pauseXlet");
    }
    
    public void destroyXlet(boolean unconditional) {
        System.out.println("destroyXlet");
        bgimgA.flush();
    }
    
    public void userEventReceived(UserEvent e) {
        if (e.getType()==HRcEvent.KEY_PRESSED){ //enkel indrukken, niet loslaten
            switch (e.getCode())
            {
                case HRcEvent.VK_LEFT:
                    System.out.println("links!!!");
                    switch (teller)
                    {
                        case 0:
                            teller = 3;
                            bgimgA.flush();
                            try {
                                bgConfiguration.displayImage(bgimgD);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgD.load(this);                    
                            break;
                        case 1:
                            teller = 0;
                            bgimgB.flush();
                            try {
                                bgConfiguration.displayImage(bgimgA);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgA.load(this);                    
                            break;
                        case 2:
                            teller = 1;
                            bgimgC.flush();
                            try {
                                bgConfiguration.displayImage(bgimgB);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgB.load(this);                    
                            break;
                        case 3:
                            teller = 2;
                            bgimgD.flush();
                            try {
                                bgConfiguration.displayImage(bgimgC);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgC.load(this);                    
                            break;                                                        
                    }
                    break;
                case HRcEvent.VK_RIGHT:                    
                    System.out.println("rechts!!!");switch (teller)
                    {
                        case 0:
                            teller = 1;
                            bgimgA.flush();
                            try {
                                bgConfiguration.displayImage(bgimgB);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgB.load(this);                           
                            break;
                        case 1:
                            teller = 2;
                            bgimgB.flush();
                            try {
                                bgConfiguration.displayImage(bgimgC);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgC.load(this);                    
                            break;
                        case 2:
                            teller = 3;
                            bgimgC.flush();
                            try {
                                bgConfiguration.displayImage(bgimgD);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgD.load(this);                    
                            break;
                        case 3:
                            teller = 0;
                            bgimgD.flush();
                            try {
                                bgConfiguration.displayImage(bgimgA);
                            } 
                            catch (Exception s){
                                System.out.println("Image kan niet geladen worden.");
                            }
                            bgimgA.load(this);                    
                            break;                                                        
                    }
                    break;
            }
        }
    }
}
