import java.util.HashMap;

public class KontenerChlodniczy extends Kontener{
    private String typProduktu;
    private double temperatura;
    public KontenerChlodniczy(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String typLadunku, double maksymalnaLadownosc, String typProduktu, double temperatura) throws Exception {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, typLadunku, maksymalnaLadownosc);
        this.typProduktu = typProduktu;
        this.temperatura = temperatura;
        sprawdzTemperature(typProduktu, temperatura);
    }
    private static final HashMap<String, Double> wymaganaTemperatura=new HashMap<>();
    static {
        wymaganaTemperatura.put("Bananas", 13.3);
        wymaganaTemperatura.put("Chocolate", 18.0);
        wymaganaTemperatura.put("Fish", 2.0);
        wymaganaTemperatura.put("Meat", -15.0);
        wymaganaTemperatura.put("Ice cream", -18.0);
        wymaganaTemperatura.put("Frozen pizza", -30.0);
        wymaganaTemperatura.put("Cheese", 7.2);
        wymaganaTemperatura.put("Sausage", 5.0);
        wymaganaTemperatura.put("Butter", 20.5);
        wymaganaTemperatura.put("Eggs", 19.0);
    }
    public double sprawdzTemperature(String typProduktu, double temperatura) throws Exception {
        Double minimalnaTemperatura = wymaganaTemperatura.get(typProduktu);
        if (minimalnaTemperatura==null) {
            throw new Exception("Nieznany produkt"+typProduktu);
        }
        if (temperatura < minimalnaTemperatura) {
            throw new Exception("Temperatura w kontenerze jest zbyt niska, a powinna być " + minimalnaTemperatura);
        }
        return minimalnaTemperatura;
    }

    @Override
    public void oproznienieLadunku() {
        this.masaLadunku=0;
    }

    @Override
    public void zaladowanieLadunku(double masaLadunku) throws OverfillExeption {
        super.zaladowanieLadunku(masaLadunku);
    }


    @Override
    public String toString() {
        return "Kontener Chłodniczy\nNumer seryjny: " + numerSeryjny + "\nMasa kontenera: " + (wagaWlasna + masaLadunku);
    }

    public String getTypProduktu() {
        return typProduktu;
    }

    public void setTypProduktu(String typProduktu) {
        this.typProduktu = typProduktu;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

}


