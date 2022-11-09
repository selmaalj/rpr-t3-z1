package org.example;

public class MobilniBroj extends TelefonskiBroj{
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        if(mobilnaMreza>79)
            throw new Izuzetak("Ne postoji");
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return "0"+mobilnaMreza+"/"+broj;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        FiksniBroj fb=(FiksniBroj)o;
        return this.ispisi().compareTo(fb.ispisi());
    }
}
