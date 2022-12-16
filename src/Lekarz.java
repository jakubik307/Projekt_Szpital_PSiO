public class Lekarz extends Pracownik {
    private final String specjalizacja;

    public Lekarz(String imie, String nazwisko, int pesel, int wiek, int etat, String specjalizacja) {
        super(imie, nazwisko, pesel, wiek, etat);
        this.specjalizacja = specjalizacja;
    }

    public void leczPacjenta(Pacjent pacjent) {
        if (pacjent.isCzyChory()) {
            pacjent.setCzyChory(false);
            System.out.println("Pacjent ozdrowial");
        } else {
            System.out.println("Pacjent byl juz zdrowy");
        }
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    @Override
    public String toString() {
        return "Lekarz: " + super.toString() + " Specjalizacja: " + specjalizacja;
    }
}
