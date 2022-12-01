public class Lekarz extends Pracownik {
    private final String specjalizacja;

    public Lekarz(String imie, String nazwisko, int pesel, int wiek, int pensja, String specjalizacja) {
        super(imie, nazwisko, pesel, wiek, pensja);
        this.specjalizacja = specjalizacja;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void leczPacjenta(Pacjent pacjent) {
        if (pacjent.isCzyChory()) {
            pacjent.setCzyChory(false);
            System.out.println("Pacjent ozdrowial");
        } else {
            System.out.println("Pacjent byl juz zdrowy");
        }
    }

    @Override
    public String toString() {
        return "Lekarz: " + super.toString() + " Specjalizacja: " + specjalizacja;
    }
}
