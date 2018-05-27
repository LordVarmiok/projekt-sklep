package model;

import java.math.BigDecimal;

public class Dron extends Produkt{

    private double zasieg;
    private boolean czyMaKamere;


    public Dron() {

    }

        //KONSTRUKTOR PARAMETRYCZNY

    public Dron(String nazwa, BigDecimal cena, double zasieg, boolean czyMaKamere) {
        super(nazwa, cena);

        this.nazwa = nazwa;
        this.cena = cena;
        this.zasieg = zasieg;
        this.czyMaKamere = czyMaKamere;
    }



    ////////////////////////////GETERY


    public double getZasieg() {
        return zasieg;
    }

    public void setZasieg(double zasieg) {
        this.zasieg = zasieg;
    }

    public boolean isCzyMaKamere() {
        return czyMaKamere;
    }

    public void setCzyMaKamere(boolean czyMaKamere) {
        this.czyMaKamere = czyMaKamere;
    }


    @Override
    public String toString() {
        return "Dron{" +
                "zasieg=" + zasieg +
                ", czyMaKamere=" + czyMaKamere +
                ", id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }
}
