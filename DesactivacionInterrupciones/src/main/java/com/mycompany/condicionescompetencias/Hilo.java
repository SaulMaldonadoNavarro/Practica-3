package com.mycompany.condicionescompetencias;
import javax.swing.*;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean matar =  false;
    
    Hilo(JTextArea area, RCompartido rc){
        this.area =area;
        this.rc=rc;
    }
    
        public synchronized void play() {
        matar = false;
        this.start();
    }  
        
        
            public synchronized void Matar (){
        matar = true;
    }
            
            
    
    public void run(){
        while(!matar){
            try{
                synchronized (this){
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+"\n");
                sleep(1500);
                }
             } catch(InterruptedException ex){
                 System.err.println(ex);
             }
        }
    }    
}
