public class Record {
    private String[] campi;

    public Record (String[] campi) {
        this.campi = campi;
    }

    public int lunghezza() {
        int tot=0;
        for (int i =0; i < campi.length; i++) {
            tot += campi[i].length();
        }
        return tot;
    }
}