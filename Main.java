import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws OverfillExeption {
        try {
            ArrayList<Kontener> listaKontenerow = new ArrayList<>();
            Kontenerowiec kontenerowiec = new Kontenerowiec("Atlanta", listaKontenerow,50, 3, 500);
            KontenerPlyny p1 = new KontenerPlyny(0, 200, 800, 300, "L", 5000, true);
            KontenerGazy g1 = new KontenerGazy(0, 210, 900, 320, "G", 5000, 8.0);
            KontenerChlodniczy c1 = new KontenerChlodniczy(0, 210, 900, 320, "C", 5000, "Fish", 3.0);
            p1.zaladowanieLadunku(800);
            p1.toString();
            g1.zaladowanieLadunku(300);
            g1.toString();
            c1.zaladowanieLadunku(500);
            c1.toString();
            kontenerowiec.dodajKontener(p1);
            kontenerowiec.dodajKontener(g1);
            kontenerowiec.dodajKontener(c1);
            kontenerowiec.wypiszInformacje();
        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
