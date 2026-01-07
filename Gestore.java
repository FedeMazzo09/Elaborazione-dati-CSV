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

    public void leggiFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Mazzoleni.csv"));
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
}