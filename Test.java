public class Test {
    public static void main(String[] args) {
        Gestore g = new Gestore("Mazzoleni.csv", 200);

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
            g.rendiRecordAFissalunghezza();
            System.out.println("Record dopo la modifica:");
            for (int i = 0; i < g.getCounter(); i++) {
                Record rec = g.getRecord(i);
                System.out.println("Record " + i + ": " + String.join(", ", rec.getCampi()));
            }

        } catch (Exception e){
            System.out.println("Errore lettura del file");
        }
    }
}
