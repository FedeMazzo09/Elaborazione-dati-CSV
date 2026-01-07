public class Test {
    public static void main(String[] args) {
        Gestore g = new Gestore("Mazzoleni.csv", 1000);

        try {
            g.leggiFile();
            System.out.println("Record letti: " + g.getCounter());
        } catch (Exception e){
            System.out.println("Errore lettura del file");
        }
        }
}
