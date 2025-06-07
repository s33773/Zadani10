public class KontenerGazy extends Kontener implements IHazardNotifier {
    private double cisnienie;

    public KontenerGazy(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String typLadunku, double maksymalnaLadownosc, double cisnienie) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, typLadunku, maksymalnaLadownosc);
        this.cisnienie = cisnienie;
    }

    @Override
    public void oproznienieLadunku(){
        this.masaLadunku = this.masaLadunku*0.05;

    }

    @Override
    public void zaladowanieLadunku(double masaLadunku) throws OverfillExeption {
        super.zaladowanieLadunku(masaLadunku);
    }

    @Override
    public void hazardNotified(String numerKontenera) {
        System.out.println("Niebezpieczne zdarzenie"+numerKontenera);
    }

    public double getCisnienie() {
        return cisnienie;
    }

    public void setCisnienie(double cisnienie) {
        this.cisnienie = cisnienie;
    }
}
