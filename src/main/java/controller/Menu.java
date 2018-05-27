package controller;

import model.Dron;
import model.Komputer;
import model.Sklep;
import pliki.OperacjePlikowe;
import pliki.PlikiBinarne;
import pliki.PlikiJson;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Scanner;

public class Menu {


    public void wyswietlMenu() {

        Scanner skaner = new Scanner(System.in);


        System.out.println("Podaj sposob zapisu pliku: ");
        System.out.println("1 - JSON");
        System.out.println("2 - binarnie");

        String wyborPliku = skaner.nextLine();
        OperacjePlikowe pliki;

        switch (wyborPliku) {
            case "1":
                pliki = new PlikiJson();

                break;
            case "2":
                pliki = new PlikiBinarne();

                break;

            default:
                pliki = new PlikiJson();

                break;

        }


        Sklep sklep;
        try {
            sklep = pliki.wczytaj();
        } catch (Exception e) {
            System.out.println("Blad odczytu pliku. Startujemy z pustym sklepem.");
            sklep = new Sklep("www.amazon.com");
        }


        System.out.println("1 - Dodaj komputer");
        System.out.println("2 - Usun komputer");
        System.out.println("3 - Wyswietl liste produktow");
        System.out.println("4 - Dodaj drona");
        System.out.println("5 - Wyswietl posortowana liste wdg ceny");
        System.out.println("6 - Wyswietl posortowana liste po nazwie");
        System.out.println("q - Wyjdz");
        String wybor;


        do {
            System.out.print("Podaj operacje: ");
            wybor = skaner.nextLine();
            //wczytaj wybor uzytkownika

            System.out.println();

            switch (wybor) {
                case "1": {
                    //wczytywanie informacji o komputerze, dronie
                    //stworzyc obiekty typow Komputer i Dron
                    //wywolac metode dodaj klasy Sklep

                    System.out.println("Inicjalizowaie procesu dodawania komputera.");
                    System.out.println("Podaj nazwe:");
                    String nazwa = skaner.nextLine();
                    System.out.println("Podaj cene:");
                    BigDecimal cena = skaner.nextBigDecimal();
                    skaner.nextLine();
                    System.out.println("Podaj marke:");
                    String marka = skaner.nextLine();
                    System.out.println("Podaj ilosc GB pamieci RAM:");
                    int ram = skaner.nextInt();
                    skaner.nextLine(); //nextInt zostawia w buforze znak nowej linii


                    Komputer komputer = new Komputer(nazwa, cena, marka, ram);
                    sklep.dodaj(komputer);


                    break;
                }
                case "2":
                    //wczytaj id komputera do usuniecia
                    //usun komputer klasy sklep
                    System.out.println("Inicjowanie procesu usuwania produktu.");
                    System.out.println("Podaj id produktu do usuniecia:");
                    long id = skaner.nextLong();
                    skaner.nextLine();

                    sklep.usun(id);
                    break;

                case "3":
                    //Wywolac metode wyswietl klasy Sklep
                    sklep.wyswietl();
                    break;

                case "4": {

                    //wczytywanie informacji o komputerze, dronie
                    //stworzyc obiekty typow Komputer i Dron
                    //wywolac metode dodaj klasy Sklep

                    System.out.println("Inicjalizowaie procesu dodawania drona.");
                    System.out.println("Podaj nazwe:");
                    String nazwa = skaner.nextLine();
                    System.out.println("Podaj cene:");
                    BigDecimal cena = skaner.nextBigDecimal();
                    skaner.nextLine();
                    System.out.println("Podaj zasieg [metry]:");
                    double zasieg = skaner.nextDouble();
                    System.out.println("Podaj czy dron posiada kamere [false,true]:");
                    boolean czyMaKamere = skaner.nextBoolean();
                    skaner.nextLine(); //nextInt zostawia w buforze znak nowej linii


                    Dron dron = new Dron(nazwa, cena, zasieg, czyMaKamere);
                    sklep.dodaj(dron);

                    break;
                }
                case "5":
                    //POSORTOWAC I WYSWIETLIC
                    sklep.wyswietlPosortowanaCenowo();
                    break;

                case "6":
                    sklep.wyswietlPosortowanePoNazwie();
                    break;
                case "q":
                case "Q":
                    System.out.println("koniec");
                    //ZAPIS DO PLIKU

                    try {
                        pliki.zapisz(sklep);
                    } catch (Exception e) {
                        System.out.println("Blad zapisu do pliku");
                        e.printStackTrace();
                    }

                    break;
                default:
                    System.out.println("Bledny operacja");
                    break;

            }
        } while (!wybor.equalsIgnoreCase("q"));


    }


}
