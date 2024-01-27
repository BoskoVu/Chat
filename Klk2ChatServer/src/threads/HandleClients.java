/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import domain.KorisnikSoket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logic.Kontroler;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Bosko
 */
public class HandleClients extends Thread{
    
    Socket soket;

    public HandleClients(Socket soket) {
        this.soket = soket;
    }
    
    
    @Override
    public void run() {
        while(true){
            Request req=primiZahtev();
            Response res=new Response();
            switch (req.getOperacija()) {
                case Operacije.LOGIN:
                    boolean uspesno=Kontroler.getInstance().uloguj(req.getKorisnickoIme(),soket);
                    res.setOperacija(Operacije.LOGIN);
                    res.setUspesno(uspesno);
                    res.setIme(req.getKorisnickoIme());
                    posaljiOdgovor(res);
                    break;
                case Operacije.VRATIULOGOVANE:
                    res.setUlogovani(Kontroler.getInstance().getListaUlogovanih());
                    res.setOperacija(Operacije.VRATIULOGOVANE);
                    posaljiOdgovor(res);
                    
                    break;
                case Operacije.POSALJI:
                    String poruka=Kontroler.getInstance().poruka(req);
                    res.setOperacija(Operacije.POSALJI);
                    res.setPoruka(poruka);
                    if(req.getKome().equals("Svima")){
                        for(KorisnikSoket ks:Kontroler.getInstance().getListaSoketa()){
                            posaljiOdgovor(res, ks.getSoket());
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    public void posaljiOdgovor(Response req){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(req);
        } catch (IOException ex) {
            Logger.getLogger(HandleClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void posaljiOdgovor(Response req,Socket s){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(req);
        } catch (IOException ex) {
            Logger.getLogger(HandleClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Request primiZahtev(){
        Request r=new Request();
        try {
            ObjectInputStream ois=new ObjectInputStream(soket.getInputStream());
            r=(Request) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(HandleClients.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HandleClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}
