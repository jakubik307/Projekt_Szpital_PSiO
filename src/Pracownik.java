public abstract class Pracownik extends Osoba {
    private int etat;
    private int pensja;

    public Pracownik(String imie, String nazwisko, int pesel, int wiek, int etat) {
        super(imie, nazwisko, pesel, wiek);
        this.etat = etat;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return super.toString() + " \nPensja: " + pensja;
    }
}
