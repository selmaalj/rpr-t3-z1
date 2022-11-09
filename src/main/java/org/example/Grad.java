package org.example;

public enum Grad {
    SARAJEVO("033"),TUZLA("036"),ZENICA("031"), Brcko("035"), Mostar("037");
    private String broj;

        Grad(String broj) {
            this.broj=broj;
        }

    public String getBroj() {
        return broj;
    }
}
