package model;

import java.io.Serializable;
import java.util.*;

public class Sklep implements Serializable {

    //////////OPEN-CLOSE PRINCIPLE - mozna dodawac nowe produkty, sklep nie musi wiedziec czym jest dany produkt

    //skladowe
    private Collection<Produkt> produkty;
    private String nazwa;


    public Sklep() {

    }

    public Sklep(String nazwa) {
        this.produkty = new ArrayList<>();
        this.nazwa = nazwa;
    }

    //metody
    public void dodaj(Produkt produkt) {
        produkty.add(produkt);
    }

    public void usun(long id) {
        System.out.println("Podaj id komputera do usuniecia");
        Iterator<Produkt> iterator = produkty.iterator();

        while(iterator.hasNext()) {
            Produkt produkt = iterator.next();
            if(produkt.getId() == id) {
                iterator.remove();
            }
        }

    }

    public void wyswietl() {
//        for(int i = 0; i < produkty.size(); i++) {
//            produkt.get(i)
//        } TO NIE POJDZIE
        if(produkty.isEmpty()) {
            System.out.println("Brak produktow w sklepie");
        } else {
            for(Produkt tmp: produkty) {
                System.out.println(tmp);
            }
        }

    }

    public void wyswietlPosortowanaCenowo() {
        List<Produkt> kopiaProdukty = new ArrayList<>(produkty);  ///////////////KOPIA KOLEKCJI NA LISTE
        Collections.sort(kopiaProdukty);

        if(kopiaProdukty.isEmpty()) {
            System.out.println("Brak produktow w sklepie");
        } else {
            for(Produkt tmp: kopiaProdukty) {
                System.out.println(tmp);
            }
        }

    }

    public Collection<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(Collection<Produkt> produkty) {
        this.produkty = produkty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void wyswietlPosortowanePoNazwie() {

        Comparator<Produkt> nazwaKomkparator = new Comparator<Produkt>() {          //KLASA ANONIMOWA
            @Override
            public int compare(Produkt o1, Produkt o2) {
                if(o1.nazwa.compareTo(o2.nazwa) < 0) {
                    return -1;
                } else if (o1.nazwa.compareTo(o2.nazwa) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        List<Produkt> kopiaProdukty = new ArrayList<>(produkty);  ///////////////KOPIA KOLEKCJI NA LISTE
        Collections.sort(kopiaProdukty);

        if(kopiaProdukty.isEmpty()) {
            System.out.println("Brak produktow w sklepie");
        } else {
            for(Produkt tmp: kopiaProdukty) {
                System.out.println(tmp);
            }
        }
    }
}
