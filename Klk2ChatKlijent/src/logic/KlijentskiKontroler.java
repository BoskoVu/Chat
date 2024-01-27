/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import forms.FrmKlijent;
import forms.FrmLogin;
import java.util.ArrayList;
import transfer.Response;

/**
 *
 * @author Bosko
 */
public class KlijentskiKontroler {
    private static KlijentskiKontroler instance;
    private FrmLogin fl;
    private String ulogovani;
    private FrmKlijent fk;

    private KlijentskiKontroler() {
    }

    public static KlijentskiKontroler getInstance() {
        if(instance==null){
            instance=new KlijentskiKontroler();
        }
        return instance;
    }

    public void uloguj(Response res) {
        if(res.isUspesno()){
            ulogovani=res.getIme();
        }
        fl.uloguj(res.isUspesno());
    }

    public FrmLogin getFl() {
        return fl;
    }

    public void setFl(FrmLogin fl) {
        this.fl = fl;
    }

    public String getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(String ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void setCB(ArrayList<String> ulogovani) {
        ulogovani.remove(this.ulogovani);
        fk.setCB(ulogovani);
    }

    public FrmKlijent getFk() {
        return fk;
    }

    public void setFk(FrmKlijent fk) {
        this.fk = fk;
    }

    public void postaviPoruku(Response res) {
        fk.postaviPoruku(res);
    }
}
