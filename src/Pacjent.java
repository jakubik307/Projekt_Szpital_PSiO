import java.util.ArrayList;

public abstract class Pacjent extends Osoba {
    private ArrayList<CertyfikatSzczepienia> certyfikatySzczepienia;
    private boolean czyChory;
    private int kosztyLeczenia;

    public Pacjent(String imie, String nazwisko, int pesel, int wiek) {
        super(imie, nazwisko, pesel, wiek);
        this.certyfikatySzczepienia = new ArrayList<>();
        this.czyChory = true;
    }

    public ArrayList<CertyfikatSzczepienia> getCertyfikatySzczepienia() {
        return certyfikatySzczepienia;
    }

    public void setCertyfikatySzczepienia(ArrayList<CertyfikatSzczepienia> certyfikatySzczepienia) {
        this.certyfikatySzczepienia = certyfikatySzczepienia;
    }

    public boolean isCzyChory() {
        return czyChory;
    }

    public void setCzyChory(boolean czyChory) {
        this.czyChory = czyChory;
    }

    public int getKosztyLeczenia() {
        return kosztyLeczenia;
    }

    public void setKosztyLeczenia(int kosztyLeczenia) {
        this.kosztyLeczenia = kosztyLeczenia;
    }

    @Override
    public String toString() {
        return "Pacjent: " + super.toString() + "\nChory: " + isCzyChory() + "\n" + certyfikatySzczepienia + "\n" + "Koszty Leczenia: " + kosztyLeczenia;
    }
}
