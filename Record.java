public class Record {
    private String[] campi;
    private int mioValore;
    private boolean cancellato;

    public Record (String[] campi) {
        this.campi = campi;
        mioValore = (int) (Math.random() * 11) + 10;
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
        return campi.length + 2;
    }

    public String[] getCampi() {
        return campi;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public void rendiLunghezzaFissa(int lunghezzaTarget) {
        int attuale = lunghezza();
        int spaziDaAggiungere = lunghezzaTarget - attuale;

        if (spaziDaAggiungere > 0) {
            campi[campi.length - 1] += " ".repeat(spaziDaAggiungere);
        }
    }

}