import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Kontenerowiec {
    private String nazwa;
    private List<Kontener> kontenery;
    private double maksymalnaPredosc;
    private int maksymalnaLiczbaKontenerow;
    private double maksymalnaLacznaWaga;

    public Kontenerowiec(String nazwa, List<Kontener> kontenery, double maksymalnaPredosc, int maksymalnaLiczbaKontenerow, double maksymalnaLacznaWaga) {
        this.nazwa = nazwa;
        this.kontenery=new ArrayList<>(kontenery);
        this.maksymalnaPredosc = maksymalnaPredosc;
        this.maksymalnaLiczbaKontenerow = maksymalnaLiczbaKontenerow;
        this.maksymalnaLacznaWaga = maksymalnaLacznaWaga;
    }
    public void dodajKontener(Kontener k) throws Exception {
        if (kontenery.size()>=maksymalnaLiczbaKontenerow) {
            throw new Exception("Za dużo kontenerów na statku");
        }
        if(obliczWage()+k.wagaCalkowita()>maksymalnaLacznaWaga*1000){
            throw new Exception("Za duża waga całkowita");
        }
        kontenery.add(k);
    }
    public void usunKontener(String numer){
        for(int i=0; i<kontenery.size(); i++){
            if(kontenery.get(i).getNumerSeryjny().equals(numer)){
                kontenery.remove(i);
                break;
            }
        }
    }
    public void zamienKontener(String numer, Kontener nowy){
        for(int i=0; i<kontenery.size(); i++){
            if(kontenery.get(i).getNumerSeryjny().equals(numer)){
                kontenery.set(i, nowy);
                break;
            }
        }
    }
    public void przeniesKontener(Kontenerowiec inny, String numer)throws Exception{
        for(int i=0; i<kontenery.size(); i++){
            if(kontenery.get(i).getNumerSeryjny().equals(numer)){
                inny.dodajKontener(kontenery.get(i));
                kontenery.remove(i);
                break;
            }
        }
    }
    public double obliczWage() {
        double suma = 0.0;
        for(int i=0; i<kontenery.size(); i++){
            suma+=kontenery.get(i).wagaCalkowita();
        }
        return suma;
    }
    public void wypiszInformacje(){
        System.out.println("Kontenerowiec"+nazwa);
        for(int i=0; i<kontenery.size(); i++){
            System.out.println(kontenery.get(i));
        }
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
