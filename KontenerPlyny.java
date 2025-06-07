public class KontenerPlyny extends Kontener implements IHazardNotifier {
    private boolean czyNiebezpieczny;

    public KontenerPlyny(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String typLadunku, double maksymalnaLadownosc, boolean czyNiebezpieczny) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, typLadunku, maksymalnaLadownosc);
        this.czyNiebezpieczny = czyNiebezpieczny;
    }

    @Override
    public void zaladowanieLadunku(double masaLadunku) throws OverfillExeption {
        double limit;
        if (czyNiebezpieczny) {
            limit=0.5;
        }else{
            limit=0.9;
        }
        if(masaLadunku>maksymalnaLadownosc*limit){
            hazardNotified(numerSeryjny);
            throw new OverfillExeption("Próba wykonania niebezpiecznej operacji");
        }
        this.masaLadunku = masaLadunku;
    }

    @Override
    public void oproznienieLadunku() {
        this.masaLadunku=0;
    }

    @Override
    public void hazardNotified(String numerKontenera) {
        System.out.println("Niebezpieczna sytuacja "+numerKontenera);
    }

    @Override
    public String toString() {
        return "Kontener na płyny\nNumer seryjny: " + numerSeryjny + "\nMasa kontenera: " + (wagaWlasna + masaLadunku);
    }

    public boolean isCzyNiebezpieczny() {
        return czyNiebezpieczny;
    }

    public void setCzyNiebezpieczny(boolean czyNiebezpieczny) {
        this.czyNiebezpieczny = czyNiebezpieczny;
    }
}

