public class Pacjent extends Osoba {
    private final CertyfikatSzczepienia certyfikatSzczepienia;
    private boolean czyChory;

    public Pacjent(String imie, String nazwisko, int pesel, int wiek) {
        super(imie, nazwisko, pesel, wiek);
        this.certyfikatSzczepienia = new CertyfikatSzczepienia();
        this.czyChory = true;
    }

    public CertyfikatSzczepienia getCertyfikatSzczepienia() {
        return certyfikatSzczepienia;
    }

    public boolean isCzyChory() {
        return czyChory;
    }

    public void setCzyChory(boolean czyChory) {
        this.czyChory = czyChory;
    }

    @Override
    public String toString() {
        return "Pacjent: " + super.toString() + "\nChory: " + isCzyChory() + "\n" + certyfikatSzczepienia;
    }
}
