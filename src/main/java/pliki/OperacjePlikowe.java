package pliki;

import model.Sklep;

public interface OperacjePlikowe {

    //tutaj jest wszystko public i abstrakcyjne (public abstruct)

    void zapisz(Sklep sklep) throws Exception;

    Sklep wczytaj() throws Exception;

}
