/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import threads.HandleServer;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Bosko
 */
public class Komunikacija {
    private static Komunikacija instance;
    Socket s;

    private Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if(instance==null){
            instance=new Komunikacija();
        }
        return instance;
    }
    
    public void poveziSe(){
        try {
            s=new Socket("localhost", 9000);
            HandleServer hs=new HandleServer();
            hs.start();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void posaljiZahtev(Request req){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(req);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Response primiOdgovor(){
        Response r=new Response();
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            r=(Response) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}
