/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Bosko
 */
public class KorisnikSoket implements Serializable{
    private String korisnickoIme;
    private Socket soket;

    public KorisnikSoket() {
    }

    public KorisnikSoket(String korisnickoIme, Socket soket) {
        this.korisnickoIme = korisnickoIme;
        this.soket = soket;
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    
    
}
