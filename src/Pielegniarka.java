import java.util.Random;

public class Pielegniarka extends Pracownik {
    public Pielegniarka(String imie, String nazwisko, int pesel, int wiek, int pensja) {
        super(imie, nazwisko, pesel, wiek, pensja);
    }

    public void wykonajSzczepienie(Pacjent pacjent) {
        Random random = new Random();
        if (!pacjent.getCertyfikatSzczepienia().isCzySzczepiony()) {
            pacjent.getCertyfikatSzczepienia().setCzySzczepiony(true);
            pacjent.getCertyfikatSzczepienia().setNumerSzczepienia(random.nextInt(1000, 2000));
            System.out.println("Nadany numer certyfikatu szczepienia: " + pacjent.getCertyfikatSzczepienia().getNumerSzczepienia());
        } else {
            System.out.println("Pacjent już był szczepiony");
        }
    }

    @Override
    public String toString() {
        return "Pielegniarka: " + super.toString();
    }
}
