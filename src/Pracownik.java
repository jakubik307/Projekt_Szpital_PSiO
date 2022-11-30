public abstract class Pracownik extends Osoba {
    private int pensja;

    public Pracownik(String imie, String nazwisko, int pesel, int wiek, int pensja) {
        super(imie, nazwisko, pesel, wiek);
        this.pensja = pensja;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return super.toString() + " \nPensja: " + pensja;
    }
}
