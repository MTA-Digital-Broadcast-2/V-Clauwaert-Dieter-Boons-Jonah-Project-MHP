package hellotvxlet;

import javax.tv.xlet.*; //context
import org.havi.ui.*; //scene
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;



public class HelloTVXlet implements Xlet, HActionListener {

  private XletContext actueleXletContext; //in deze context kun je scene steken
  private HScene scene;
  //debuggen activeren of niet?
  private boolean debug=true;
  
  private HStaticText tekstLabel, answerLabel; //dit is je label
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
     
     tekstLabel = new HStaticText("Wat is de leukste programmeertaal?");
     //answerLabel = new HStaticText("");
     
     
     tekstLabel.setLocation(50,50);
     tekstLabel.setSize(500, 200);
     tekstLabel.setBackground(new DVBColor(0,0,0,255));
     tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
    /*answerLabel.setLocation(50,450);
     answerLabel.setSize(500, 100);
     answerLabel.setBackground(new DVBColor(0,0,0,255));
     answerLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);*/
     
     scene.add(tekstLabel);
     //scene.add(answerLabel);
     
     knop1 = new HTextButton("JAVA");
     knop2 = new HTextButton("C#");
     knop3 = new HTextButton("C++");
     knop4 = new HTextButton("PYTHON");
     
     knop1.setLocation(50,300);
     knop1.setSize(100, 100);
     knop1.setBackground(new DVBColor(214,214,255,150));
     knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     knop2.setLocation(200,300);
     knop2.setSize(100, 100);
     knop2.setBackground(new DVBColor(214,214,255,150));
     knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
    
     knop3.setLocation(350,300);
     knop3.setSize(100, 100);
     knop3.setBackground(new DVBColor(214,214,255,150));
     knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     knop4.setLocation(500,300);
     knop4.setSize(100, 100);
     knop4.setBackground(new DVBColor(214,214,255,150));
     knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
     
     //navigeren met pijltjes
     knop1.setFocusTraversal(null, null, knop4, knop2); //op, neer, links, rechts
     knop2.setFocusTraversal(null, null, knop1, knop3);
     knop3.setFocusTraversal(null, null, knop2, knop4);
     knop4.setFocusTraversal(null, null, knop3, knop1);
     
     
     scene.add(knop1);
     scene.add(knop2);
     scene.add(knop3);
     scene.add(knop4);
     
     //requestFocus moet NA de add knoppen toegevoegd worden!!!
     knop1.requestFocus();
     knop2.requestFocus();
     knop3.requestFocus();
     knop4.requestFocus();
     
     //button klik commands hieronder
     knop1.setActionCommand("juist");
     knop2.setActionCommand("fout");
     knop3.setActionCommand("fout");
     knop4.setActionCommand("fout");
     
     knop1.addHActionListener(this);
     knop2.addHActionListener(this);
     knop3.addHActionListener(this);
     knop4.addHActionListener(this);
    }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startXlet() throws XletStateChangeException {
       scene.validate();
       scene.setVisible(true);
       answerLabel.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("juist"))
        {
        /*answerLabel = new HStaticText("Juist!!");
        answerLabel.setVisible(true);
        answerLabel.setLocation(50,450);
        answerLabel.setSize(500, 100);
        answerLabel.setBackground(new DVBColor(0,0,0,255));
        answerLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(answerLabel);*/
        scene.validate();
        answerLabel.setVisible(true);
        scene.validate();
        }
        else
        {
        /*answerLabel = new HStaticText("fout, you suck titballs!");
        answerLabel.setVisible(true);
        answerLabel.setLocation(50,450);
        answerLabel.setSize(500, 100);
        answerLabel.setBackground(new DVBColor(0,0,0,255));
        answerLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
        scene.add(answerLabel);*/
        scene.validate();  
        }
        
        
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

}
