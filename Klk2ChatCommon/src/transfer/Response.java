/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Bosko
 */
public class Response implements Serializable{
    private int operacija;
    private boolean uspesno;
    private ArrayList<String> ulogovani;
    private String ime;
    private String poruka;

    public Response() {
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public void setUspesno(boolean uspesno) {
        this.uspesno = uspesno;
    }

    public ArrayList<String> getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(ArrayList<String> ulogovani) {
        this.ulogovani = ulogovani;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
    
}
