public class Test {
    public static void main(String[] args) {
        Gestore g = new Gestore("Mazzoleni.csv", 100);

        try {
            g.leggiFile();
            System.out.println("Record letti: " + g.getCounter());
            System.out.println("Lunghezza massima record: " + g.lunghezzaMassimaRecord());
            System.out.println("Numero campi per record: " + g.getRecord(0).getNumeroCampi());
            System.out.println("Ricerca per campo chiave:");
            Record risultato = g.ricercaPerCampoChiave("A538641", 0);
            if (risultato != null) {
                System.out.println("Record trovato con campo chiave 'Animal ID'");
            } else {
                System.out.println("Record non trovato con campo chiave 'Animal ID'");
            }
        } catch (Exception e){
            System.out.println("Errore lettura del file");
        }
    }
}
