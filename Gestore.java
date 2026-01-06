public class Gestore {
    private Record[] records;
    private String nomeFile;
    private int counter;

    public Gestore (String nomeFile, int max){
        this.nomeFile = nomeFile;
        this.records = new Record[max];
        counter=0;
    }
}