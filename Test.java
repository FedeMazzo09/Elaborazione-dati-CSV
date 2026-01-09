public class Test {
    public static void main(String[] args) {

        Gestore g = new Gestore("Mazzoleni.csv", 200);

        try {
            g.leggiFile();
            System.out.println("Record letti: " + g.getCounter());

            System.out.println("Lunghezza massima record: " + g.lunghezzaMassimaRecord());

            System.out.println("Il numero dei campi del file CSV è: " + g.getRecord(0).getNumeroCampi());

            g.visualizzaTreCampi(0, 1, 2);

            Record r = g.ricercaPerCampoChiave("A538641", 0);
            if (r != null) {
                System.out.println("Record trovato");
            }

            g.modificaRecord("A538641", 0, 1, "MODIFICATO");

            g.cancellaRecord("A538641", 0);

            String[] nuovo = {"ID999", "Nuovo", "Record"};
            g.aggiungiRecord(nuovo);

            g.rendiRecordFissi();

            System.out.println("Operazioni completate");

        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
