/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.KorisnikSoket;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;

/**
 *
 * @author Bosko
 */
public class Kontroler {
    private static Kontroler instance;
    private ArrayList<String> listaKorisnika;
    private ArrayList<String> listaUlogovanih;
    private ArrayList<KorisnikSoket> listaSoketa;

    private Kontroler() {
        listaSoketa=new ArrayList<>();
        listaUlogovanih=new ArrayList<>();
        listaKorisnika=new ArrayList<>();
        listaKorisnika.add("Marko");
        listaKorisnika.add("Zarko");
        listaKorisnika.add("Pera");
    }

    public static Kontroler getInstance() {
        if(instance==null){
            instance=new Kontroler();
        }
        return instance;
    }

    public boolean uloguj(String korisnickoIme,Socket s) {
        for(String ime:listaKorisnika){
            if(ime.equals(korisnickoIme)){
                listaUlogovanih.add(ime);
                for(KorisnikSoket ks:listaSoketa){
                    if(ks.getSoket().equals(s)){
                        ks.setKorisnickoIme(korisnickoIme);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(ArrayList<String> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

    public ArrayList<String> getListaUlogovanih() {
        return listaUlogovanih;
    }

    public void setListaUlogovanih(ArrayList<String> listaUlogovanih) {
        this.listaUlogovanih = listaUlogovanih;
    }

    public String poruka(Request req) {
        String p=req.getKorisnickoIme()+": "+req.getPoruka();
        return p;
    }

    public ArrayList<KorisnikSoket> getListaSoketa() {
        return listaSoketa;
    }

    public void setListaSoketa(ArrayList<KorisnikSoket> listaSoketa) {
        this.listaSoketa = listaSoketa;
    }
     
}
