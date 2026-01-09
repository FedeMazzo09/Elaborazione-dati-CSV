import java.io.*;

public class Gestore {
    private Record[] records;
    private String nomeFile;
    private int counter;

    public Gestore(String nomeFile, int max) {
        this.nomeFile = nomeFile;
        records = new Record[max];
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public Record getRecord(int index) {
        return records[index];
    }

    public void leggiFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nomeFile));
        String riga;

        br.readLine();

        while ((riga = br.readLine()) != null && counter < records.length) {
            String[] campi = riga.split(",");
            records[counter] = new Record(campi);
            counter++;
        }
        br.close();
    }

    public void aggiungiRecord(String[] campi) {
        if (counter < records.length) {
            records[counter] = new Record(campi);
            counter++;
        }
    }

    public void modificaRecord(String valoreChiave, int indiceChiave, int campoDaModificare, String nuovoValore) {
        Record r = ricercaPerCampoChiave(valoreChiave, indiceChiave);
        if (r != null) {
            r.setCampo(campoDaModificare, nuovoValore);
        }
    }

    public void cancellaRecord(String valoreChiave, int indiceChiave) {
        Record r = ricercaPerCampoChiave(valoreChiave, indiceChiave);
        if (r != null) {
            r.cancella();
        }
    }

    public int lunghezzaMassimaRecord() {
        int max = 0;
        for (int i = 0; i < counter; i++) {
            int l = records[i].lunghezza();
            if (l > max) {
                max = l;
            }
        }
        return max;
    }

    public void rendiRecordFissi() {
        int max = lunghezzaMassimaRecord();

        for (int i = 0; i < counter; i++) {
            int diff = max - records[i].lunghezza();
            String[] campi = records[i].getCampi();
            campi[campi.length - 1] += " ".repeat(diff);
        }
    }

    public void visualizzaTreCampi(int i1, int i2, int i3) {
        for (int i = 0; i < counter; i++) {
            if (!records[i].isCancellato()) {
                String[] c = records[i].getCampi();
                System.out.println(c[i1] + " | " + c[i2] + " | " + c[i3]);
            }
        }
    }

    public Record ricercaPerCampoChiave(String valore, int indiceCampo) {
        for (int i = 0; i < counter; i++) {
            if (!records[i].isCancellato()) {
                if (records[i].getCampi()[indiceCampo].equals(valore)) {
                    return records[i];
                }
            }
        }
        return null;
    }
}
