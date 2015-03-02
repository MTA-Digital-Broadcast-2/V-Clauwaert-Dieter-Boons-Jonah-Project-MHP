/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;


import java.util.TimerTask;

/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask{

    
        HelloTVXlet mijnXlet;
    
        public void setCallBack(HelloTVXlet xlet)
        {
            mijnXlet=xlet;
        }
        public void run() {
        //timer wordt hier uitgevoerd
        //System.out.println("timer tick");
        if (mijnXlet != null) 
        { 
            mijnXlet.callback();
        }
    }
        
}
