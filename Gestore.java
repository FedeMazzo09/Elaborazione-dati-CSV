import java.io.*;

public class Gestore {
    private Record[] records;
    private String nomeFile;
    private int counter;

    public Gestore (String nomeFile, int max){
        this.nomeFile = nomeFile;
        this.records = new Record[max];
        counter=0;
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

    public int lunghezzaMassimaRecord() {
        int max = 0;
        for (int i = 0; i < counter; i++) {
            int lunghezza = records[i].lunghezza();
            if (lunghezza > max) {
                max = lunghezza;
            }
        }
        return max;
    }

    public void aggiungiRecord(Record r) {
        if (counter < records.length) {
            records[counter] = r;
            counter++;
        }
    }

    public Record ricercaPerCampoChiave(String valoreChiave, int indiceCampo) {
        for (int i = 0; i < counter; i++) {
            Record rec = records[i];
            String[] campi = rec.getCampi();
            String valore = campi[indiceCampo];
            if (valore != null && valore.equals(valoreChiave)) {
                return rec;
            }
        }
        return null;
    }

    public void rendiRecordAFissalunghezza() {
        int max = lunghezzaMassimaRecord();

        for (int i = 0; i < counter; i++) {
            records[i].rendiLunghezzaFissa(max);
        }
    }
}