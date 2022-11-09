package org.example;

public class FiksniBroj extends TelefonskiBroj {
    private String broj;
    private Grad gradovi;
    public FiksniBroj(Grad gradovi, String broj){
        this.broj=broj;
        this.gradovi=gradovi;
    }

    public Grad getGradovi() {
        return gradovi;
    }

    @Override
    public String ispisi() {
        return gradovi.getBroj() + "/" + broj;
    }
    @Override
    public int hashCode() {
        return 0;
    }


    @Override
    public int compareTo(Object o) {
        FiksniBroj fb=(FiksniBroj) o;
        return this.ispisi().compareTo(fb.ispisi());
    }
}
