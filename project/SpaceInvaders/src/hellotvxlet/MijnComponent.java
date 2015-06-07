package hellotvxlet;

import java.awt.*;
import org.dvb.ui.*;
import org.havi.ui.*;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    
    private Image schip, sterren;
    int schipX = 300, schipY = 500, sterrenX = 0, sterrenY = 0;
    
    public MijnComponent(){
        this.setBounds(0,0,720,576);
        
        schip = this.getToolkit().getImage("spaceship.png");
        sterren = this.getToolkit().getImage("sterren.png");
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schip, 0);
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
    }
    
    public void verplaatsSchip(int x, int y){
        schipX += x;
        schipY += y;
        this.repaint();
    }
    
    public void paint (Graphics g){
        g.setColor(new DVBColor(255,0,0,255)); //RGBA
        g.drawLine(0,0,200,200);
        g.drawString("Testing, 1, 2, 3, ...", 70, 20); //deel van tekst valt weeg door bounds
        g.drawImage(sterren, sterrenX, sterrenY, this);
        g.drawImage(sterren, sterrenX, sterrenY-570, this);
        g.drawImage(schip, schipX, schipY, this);
    }
}
