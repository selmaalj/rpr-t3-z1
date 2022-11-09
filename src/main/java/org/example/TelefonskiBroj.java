package org.example;

public abstract class TelefonskiBroj implements Comparable {
    public abstract String ispisi();

    public abstract int hashCode();

   @Override
   public abstract int compareTo(Object o);
}
