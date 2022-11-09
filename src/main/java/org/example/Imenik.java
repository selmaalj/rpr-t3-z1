package org.example;

import java.util.*;

public class Imenik {
    HashMap<String, TelefonskiBroj> imenik;
    public Imenik(){
        imenik=new HashMap<>();
    }
    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime) {
        for (HashMap.Entry<String, TelefonskiBroj> osoba : imenik.entrySet()) {
            if (osoba.getKey().equals(ime))
                return osoba.getValue().ispisi();
        }
        throw new NoSuchElementException("Korisnik bi makar trebao biti sposoban unijeti ispravno ime");
    }

    public String dajIme(TelefonskiBroj broj) {
        for (HashMap.Entry<String, TelefonskiBroj> osoba : imenik.entrySet())
            if (osoba.getValue().equals(broj)) {
                return osoba.getKey();
            }
        throw new NoSuchElementException("Korisnik bi makar trebao biti sposoban unijeti ispravan broj");
    }

    public String naSlovo(char s) {
        String kraj = "";
        int br = 1;
        for (HashMap.Entry<String, TelefonskiBroj> osoba : imenik.entrySet()) {
            if (osoba.getKey().charAt(0) == (s)) {
                kraj = kraj + br + ". " + osoba.getKey()+" - "+osoba.getValue().ispisi();
                br = br + 1;
            }
        }
        return kraj;
    }

    public Set<String> izGrada(Grad g) {
        TreeSet<String> sett = new TreeSet<>();
        for (HashMap.Entry<String, TelefonskiBroj> osoba : imenik.entrySet()) {
            if (osoba.getValue() instanceof FiksniBroj) {
                FiksniBroj fb = (FiksniBroj) osoba.getValue();
                if (fb.getGradovi().equals(g))
                    sett.add(osoba.getKey());
            }
        }
        return sett;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        TreeSet<TelefonskiBroj> sett = new TreeSet<>();
        for (HashMap.Entry<String, TelefonskiBroj> osoba : imenik.entrySet()) {
            if (osoba.getValue() instanceof FiksniBroj) {
                FiksniBroj fb = (FiksniBroj) osoba.getValue();
                if (fb.getGradovi().equals(g))
                    sett.add(osoba.getValue());
            }
        }
        return sett;
    }
}
