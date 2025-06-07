import java.util.ArrayList;
import java.util.List;

public class Kontenerowiec {
    private List<Kontener> kontenery;
    private double maksymalnaPredosc;
    private int maksymalnaLiczbaKontenerow;
    private double maksymalnaLacznaWaga;

    public Kontenerowiec(List<Kontener> kontenery, double maksymalnaPredosc, int maksymalnaLiczbaKontenerow, double maksymalnaLacznaWaga) {
        this.kontenery = new ArrayList<>(kontenery);
        this.maksymalnaPredosc = maksymalnaPredosc;
        this.maksymalnaLiczbaKontenerow = maksymalnaLiczbaKontenerow;
        this.maksymalnaLacznaWaga = maksymalnaLacznaWaga;
    }
    public boolean dodajKontener(Kontener k) {
        if (kontenery.size() >= maksymalnaLiczbaKontenerow) {
            System.out.println("Kontenerowiec jest już zapełniony");
            return false;
        }
        double aktualnaWaga = 0;
        for (Kontener kontener : kontenery) {
            aktualnaWaga += kontener.getWagaWlasna() + kontener.getMasaLadunku();
        }
        double nowaWaga = aktualnaWaga + k.getMasaLadunku()+k.getWagaWlasna();
        if (nowaWaga > maksymalnaLacznaWaga*1000) {
            System.out.println("Kontenerowiec nie może przyjąć kontenera o takiej wadze");
            return false;
        }
        kontenery.add(k);
        System.out.println("Dodano kontener: "+k.getNumerSeryjny());
        return true;
    }

    public List<Kontener> getKontenery() {
        return kontenery;
    }

    public void setKontenery(List<Kontener> kontenery) {
        this.kontenery = kontenery;
    }

    public double getMaksymalnaPredosc() {
        return maksymalnaPredosc;
    }

    public void setMaksymalnaPredosc(double maksymalnaPredosc) {
        this.maksymalnaPredosc = maksymalnaPredosc;
    }

    public int getMaksymalnaLiczbaKontenerow() {
        return maksymalnaLiczbaKontenerow;
    }

    public void setMaksymalnaLiczbaKontenerow(int maksymalnaLiczbaKontenerow) {
        this.maksymalnaLiczbaKontenerow = maksymalnaLiczbaKontenerow;
    }

    public double getMaksymalnaLacznaWaga() {
        return maksymalnaLacznaWaga;
    }

    public void setMaksymalnaLacznaWaga(double maksymalnaLacznaWaga) {
        this.maksymalnaLacznaWaga = maksymalnaLacznaWaga;
    }
}
