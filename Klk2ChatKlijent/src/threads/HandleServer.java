/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import kom.Komunikacija;
import konstante.Operacije;
import logic.KlijentskiKontroler;
import transfer.Response;

/**
 *
 * @author Bosko
 */
public class HandleServer extends Thread{

    @Override
    public void run() {
        while(true){
            Response res=Komunikacija.getInstance().primiOdgovor();
            switch (res.getOperacija()) {
                case Operacije.LOGIN:
                    KlijentskiKontroler.getInstance().uloguj(res);
                    break;
                case Operacije.VRATIULOGOVANE:
                    KlijentskiKontroler.getInstance().setCB(res.getUlogovani());
                    break;
                case Operacije.POSALJI:
                    KlijentskiKontroler.getInstance().postaviPoruku(res);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    
    
}
