public class Test {
    public static void main(String[] args) {
        Gestore g = new Gestore("Mazzoleni.csv", 100);

        try {
            g.leggiFile();
            System.out.println("Record letti: " + g.getCounter());
            System.out.println("Lunghezza massima record: " + g.lunghezzaMassimaRecord());
        } catch (Exception e){
            System.out.println("Errore lettura del file");
        }
    }
}
