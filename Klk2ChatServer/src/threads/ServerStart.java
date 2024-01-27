/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import domain.KorisnikSoket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Kontroler;

/**
 *
 * @author Bosko
 */
public class ServerStart extends Thread{

    ServerSocket ss;
    
    
    @Override
    public void run() {
        try {
            ss=new ServerSocket(9000);
            while(true){
                Socket s=ss.accept();
                HandleClients hc=new HandleClients(s);
                hc.start();
                Kontroler.getInstance().getListaSoketa().add(new KorisnikSoket("", s));
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
