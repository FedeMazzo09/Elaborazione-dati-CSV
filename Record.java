public class Record {
    private String[] campi;
    private int mioValore;
    private boolean cancellato;

    public Record (String[] campi) {
        this.campi = campi;
        mioValore = (int) (Math.random()*11)+10;
        cancellato = false;
    }

    public int lunghezza() {
        int tot=0;
        for (int i =0; i < campi.length; i++) {
            tot += campi[i].length();
        }
        return tot;
    }

    public int getNumeroCampi() {
        return campi.length;
    }
}