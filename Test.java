public class Test {
    public static void main(String[] args) {
        Gestore g = new Gestore("Mazzoleni.csv", 100);

        try {
            g.leggiFile();
            System.out.println("Record letti: " + g.getCounter());
            System.out.println("Lunghezza massima record: " + g.lunghezzaMassimaRecord());
            System.out.println("Numero campi per record: " + g.getRecord(0).getNumeroCampi());
        } catch (Exception e){
            System.out.println("Errore lettura del file");
        }
    }
}
