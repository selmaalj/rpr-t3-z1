import org.example.*;
import org.example.Z3.Bazna;
import org.example.Z3.Neka;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestnaKlasa {
    @Test
    void testIzuzetka() {
        Assertions.assertThrows(Izuzetak.class, () -> {
            MobilniBroj m = new MobilniBroj(99, "ss");
        });

    }

    @Test
    void dodaj() {
        Imenik imenik = new Imenik();
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        imenik.dodaj("Hana Hanic", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(Grad.SARAJEVO, "123-456"));
        Assertions.assertEquals("033/123-456", imenik.dajBroj("Meho Mehic"));
    }

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Sara Sarac", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Pero Peric", new FiksniBroj(Grad.SARAJEVO, "123-656"));
        imenik.dodaj("Ivo Ivic", new MobilniBroj(61, "321-645"));
        imenik.dodaj("Jozo Jozic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Assertions.assertEquals("1. Ivo Ivic - 061/321-645", imenik.naSlovo('I').trim());
    }

    @Test
    void izGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(Grad.SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(Grad.SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<String> set = imenik.izGrada(Grad.SARAJEVO);
        String result = "";
        for (String ime : set)
            result += ime + ",";

        Assertions.assertEquals("Ivo Ivic,Meho Mehic,Sara Sarac,", result);
    }

    @Test
    void izGradaBrojevi() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(Grad.SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(Grad.SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(Grad.SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(Grad.SARAJEVO);
        String result = "";
        for (TelefonskiBroj broj : set)
            result += broj.ispisi() + ",";
        Assertions.assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }
    @Test
    void testIspisi(){
        FiksniBroj fb=new FiksniBroj(Grad.SARAJEVO, "623-645");
        MobilniBroj mb=new MobilniBroj(62, "557-870");
        MedunarodniBroj mdb=new MedunarodniBroj("+387", "62/557-870");
        Assertions.assertEquals("033/623-645", fb.ispisi());
        Assertions.assertEquals("062/557-870", mb.ispisi());
        Assertions.assertEquals("+38762/557-870", mdb.ispisi());
    }
    @Test
    void testMokito1(){
        Map<String,String> m= Mockito.mock(Map.class);
        m.put("bosna","sarajevo");
        m.put("srbija","beograd");
        m.put("hrvatska","zagreb");
        Mockito.when(m.get("bosna")).thenReturn("beograd");
        Assertions.assertEquals("beograd", m.get("bosna"));
    }
    @Test
    void testMokito2(){
        Bazna b=new Bazna();
        b.atr=Mockito.mock(Neka.class);
        Mockito.when(b.atr.metoda()).thenReturn(0);
        Assertions.assertEquals(0,b.metoda());
    }
}
