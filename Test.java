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

            g.cancellaRecord("DAISY", 3);

            String[] nuovo = {"A666999", "CONFISCATE", "20/03/2009", "MELEYS", "BIRD", "2 YEARS", "SMALL", "RED", "COLD", "F", "http://www.petharbor.com/get_image.asp?res=DETAIL&id=A494274&location=MONT", "\"18200 LOST KNIFE CIR, MONTGOMERY VILLAGE MD 20886\""};

            g.aggiungiRecord(nuovo);

            g.rendiRecordFissi();

            System.out.println("Operazioni completate");

            g.scriviFile("Mazzoleni_copia.csv");
            System.out.println("File Mazzoleni_copia.csv creato con le modifiche");
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
