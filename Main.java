public class Main {
    public static void main(String[] args) throws OverfillExeption {
        System.out.println("KONTENER PŁYNY");
        // 1. Niebezpieczny, poprawna masa
        try {
            KontenerPlyny p1 = new KontenerPlyny(0, 200, 800, 300, "L", 5000, true);
            System.out.println("P1 numer: "+p1.getNumerSeryjny());
            p1.zaladowanieLadunku(2000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("P1: " + e.getMessage());
        }

        // 2. Niebezpieczny, za duża masa
        try {
            KontenerPlyny p2 = new KontenerPlyny(0, 200, 800, 300, "L", 5000, true);
            System.out.println("P2 numer: "+p2.getNumerSeryjny());
            p2.zaladowanieLadunku(3000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("P2: " + e.getMessage());
        }

        // 3. Zwykły, poprawna masa
        try {
            KontenerPlyny p3 = new KontenerPlyny(0, 200, 800, 300, "L", 5000, false);
            System.out.println("P3 numer: "+p3.getNumerSeryjny());
            p3.zaladowanieLadunku(4500);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("P3: " + e.getMessage());
        }

        // 4. Zwykły, za duża masa
        try {
            KontenerPlyny p4 = new KontenerPlyny(0, 200, 800, 300, "L", 5000, false);
            System.out.println("P4 numer: "+p4.getNumerSeryjny());
            p4.zaladowanieLadunku(4900);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("P4: " + e.getMessage());
        }

        System.out.println("KONTENER GAZY");
        // 1. Poprawna masa
        try {
            KontenerGazy g1 = new KontenerGazy(0, 210, 900, 320, "G", 5000, 8.0);
            System.out.println("G1 numer: "+g1.getNumerSeryjny());
            g1.zaladowanieLadunku(4000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("G1: " + e.getMessage());
        }

        // 2. Za duża masa
        try {
            KontenerGazy g2 = new KontenerGazy(0, 210, 900, 320, "G", 5000, 8.0);
            System.out.println("G2 numer: "+g2.getNumerSeryjny());
            g2.zaladowanieLadunku(6000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("G2: " + e.getMessage());
        }

        System.out.println("KONTENER CHŁODNICZY");
        try {
            KontenerChlodniczy c1 = new KontenerChlodniczy(0, 210, 900, 320, "C", 5000, "Fish", 3.0);
            System.out.println("C1 numer: " + c1.getNumerSeryjny());
            c1.zaladowanieLadunku(2000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("C1: " + e.getMessage());
        }

        // 2. Za niska temperatura
        try {
            KontenerChlodniczy c2 = new KontenerChlodniczy(0, 210, 900, 320, "C", 5000, "Fish", 1.0); // wymaga 2.0
            System.out.println("C2 numer: " + c2.getNumerSeryjny());
            c2.zaladowanieLadunku(2000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("C2: " + e.getMessage());
        }

        // 3. Nieznany produkt
        try {
            KontenerChlodniczy c3 = new KontenerChlodniczy(0, 210, 900, 320, "C", 5000, "Kefir", 4.0);
            System.out.println("C3 numer: " + c3.getNumerSeryjny());
            c3.zaladowanieLadunku(2000);
            System.out.println("W porządku");
        } catch (Exception e) {
            System.out.println("C3: " + e.getMessage());
        }

    }
}
