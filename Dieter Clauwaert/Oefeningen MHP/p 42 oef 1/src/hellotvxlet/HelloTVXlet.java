package hellotvxlet;


import java.awt.event.*;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;


public class HelloTVXlet implements Xlet, HActionListener {
    
    private XletContext actueleXletContext;
    private HScene scene;
    
    private HStaticText tekstLabel1, tekstLabel2;
    private HTextButton knop1, knop2, knop3, knop4;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      this.actueleXletContext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
              new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
              new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      tekstLabel1 = new HStaticText("1+1="); 
      
      tekstLabel1.setLocation(100,20);
      tekstLabel1.setSize(200,50);
      tekstLabel1.setBackground(new DVBColor(0,0,0,179));
      tekstLabel1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1 = new HTextButton("2");
      knop1.setLocation(100,100);
      knop1.setSize(100, 50);
      knop1.setBackground(new DVBColor(0,0,0,179));
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop2 = new HTextButton("4");
      knop2.setLocation(300,100);
      knop2.setSize(100, 50);
      knop2.setBackground(new DVBColor(0,0,0,179));
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop3 = new HTextButton("3");
      knop3.setLocation(100,200);
      knop3.setSize(100, 50);
      knop3.setBackground(new DVBColor(0,0,0,179));
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop4 = new HTextButton("1");
      knop4.setLocation(300,200);
      knop4.setSize(100, 50);
      knop4.setBackground(new DVBColor(0,0,0,179));
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1.setFocusTraversal(null, knop3, null, knop2);
      knop2.setFocusTraversal(null, knop4, knop1, null);
      knop3.setFocusTraversal(knop1, null, null, knop4);
      knop4.setFocusTraversal(knop2, null, knop3, null);
      
      knop1.setActionCommand("Juist");
      knop2.setActionCommand("Fout");
      knop3.setActionCommand("Fout");
      knop4.setActionCommand("Fout");   
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      knop3.addHActionListener(this);
      knop4.addHActionListener(this);
      
      scene.add(tekstLabel1);
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      
      knop1.requestFocus();
    }
    
    public void actionPerformed(ActionEvent e) 
      {
          System.out.println(e.getActionCommand());
          if (e.getActionCommand().equals("Juist"))
          {
              tekstLabel2 = new HStaticText("Juist");
              tekstLabel2.setLocation(500,20);
              tekstLabel2.setSize(200,50);
              tekstLabel2.setBackground(new DVBColor(0,0,0,179));
              tekstLabel2.setBackgroundMode(HVisible.BACKGROUND_FILL);
              scene.add(tekstLabel2);
          }
          else
          {
              tekstLabel2 = new HStaticText("Fout");
              tekstLabel2.setLocation(500,20);
              tekstLabel2.setSize(200,50);
              tekstLabel2.setBackground(new DVBColor(0,0,0,179));
              tekstLabel2.setBackgroundMode(HVisible.BACKGROUND_FILL);
              scene.add(tekstLabel2);
          }
           scene.validate();
      }

    public void startXlet() {
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
