public abstract class Kontener {
    protected double masaLadunku;
    protected double wysokosc;
    protected double wagaWlasna;
    protected double glebokosc;
    protected String numerSeryjny;
    protected double maksymalnaLadownosc;
    private static int licznik = 1;


    public Kontener(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String typLadunku, double maksymalnaLadownosc) {
        this.masaLadunku = masaLadunku;
        this.wysokosc = wysokosc;
        this.wagaWlasna = wagaWlasna;
        this.glebokosc = glebokosc;
        this.numerSeryjny = stworzNumerSeryjny(typLadunku);
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }
    public void zaladowanieLadunku(double masaLadunku) throws OverfillExeption {
        if(masaLadunku > maksymalnaLadownosc) {
            throw new OverfillExeption("Masa ładunku jest większa niż maksymalna ładowność");
        }
        this.masaLadunku = masaLadunku;
        }

    public abstract void oproznienieLadunku();

    private String stworzNumerSeryjny(String typLadunku) {
        return "KON-"+typLadunku+"-"+licznik++;
    }

    @Override
    public String toString() {
        return "Numer seryjny: " + numerSeryjny + "\nMasa kontenera: " + (wagaWlasna + masaLadunku);
    }

    public double wagaCalkowita(){
        return (wagaWlasna+masaLadunku);
    }

    public double getMasaLadunku() {
        return masaLadunku;
    }

    public void setMasaLadunku(double masaLadunku) {
        this.masaLadunku = masaLadunku;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getWagaWlasna() {
        return wagaWlasna;
    }

    public void setWagaWlasna(double wagaWlasna) {
        this.wagaWlasna = wagaWlasna;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public void setGlebokosc(double glebokosc) {
        this.glebokosc = glebokosc;
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        this.numerSeryjny = numerSeryjny;
    }

    public double getMaksymalnaLadownosc() {
        return maksymalnaLadownosc;
    }

    public void setMaksymalnaLadownosc(double maksymalnaLadownosc) {
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }

    public static int getLicznik() {
        return licznik;
    }

    public static void setLicznik(int licznik) {
        Kontener.licznik = licznik;
    }
}


