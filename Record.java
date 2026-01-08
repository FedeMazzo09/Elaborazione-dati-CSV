public class Record {
    private String[] campi;
    private int mioValore;
    private boolean cancellato;

    public Record(String[] campi) {
        this.campi = campi;
        mioValore = (int)(Math.random() * 11) + 10;
        cancellato = false;
    }

    public int lunghezza() {
        int tot = 0;
        for (int i = 0; i < campi.length; i++) {
            tot += campi[i].length();
        }
        return tot;
    }

    public int getNumeroCampi() {
        return campi.length + 2;
    }

    public String[] getCampi() {
        return campi;
    }

    public void setCampo(int index, String valore) {
        campi[index] = valore;
    }

    public void cancella() {
        cancellato = true;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < campi.length; i++) {
            s += campi[i] + " ";
        }
        s += mioValore + " " + cancellato;
        return s;
    }
}