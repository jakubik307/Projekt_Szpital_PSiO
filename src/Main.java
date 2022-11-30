import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Osoba> osoby = new ArrayList<Osoba>();

    public static void stanPoczatkowy() {
        Lekarz chirurg = new Lekarz("Jan", "Kowalski", 1, 31, 8000, "chirurg");
        Lekarz ogolny = new Lekarz("Piotr", "Nowak", 2, 25, 4000, "ogolny");

        Pielegniarka pielegniarka = new Pielegniarka("Anna", "Kowalska", 3, 41, 5000);

        Pacjent pacjent1 = new Pacjent("Jakub", "Mak", 4, 22);

        osoby.add(chirurg);
        osoby.add(ogolny);
        osoby.add(pielegniarka);
        osoby.add(pacjent1);
    }

    public static void wczytajDane() {
//TODO
    }

    public static void zapiszDane() {
//TODO
    }

    public static void wyswietlPracownikow() {
        System.out.println("Lista pracownikow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pracownik) {
                System.out.println("#" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }


    public static void wyswietlLekarzy() {
        System.out.println("Lista lekarzy: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Lekarz) {
                System.out.println("#" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void wyswietlPielegniarki() {
        System.out.println("Lista pielegniarek: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pielegniarka) {
                System.out.println("#" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void wyswietlPacjentow() {
        System.out.println("Lista pacjentow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pacjent) {
                System.out.println("#" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void dodajLekarza() {
        Scanner scanner = new Scanner(System.in);
        String imie, nazwisko, specjalizacja;
        int pesel, wiek, pensja;

        System.out.println("Podaj imie: ");
        imie = scanner.next();
        System.out.println("Podaj nazwisko: ");
        nazwisko = scanner.next();
        System.out.println("Podaj pesel: ");
        pesel = scanner.nextInt();
        System.out.println("Podaj wiek: ");
        wiek = scanner.nextInt();
        System.out.println("Podaj pensje: ");
        pensja = scanner.nextInt();
        System.out.println("Podaj specjalizacje: ");
        specjalizacja = scanner.next();

        osoby.add(new Lekarz(imie, nazwisko, pesel, wiek, pensja, specjalizacja));
    }

    public static void dodajPielegniarke() {
        Scanner scanner = new Scanner(System.in);
        String imie, nazwisko;
        int pesel, wiek, pensja;

        System.out.println("Podaj imie: ");
        imie = scanner.next();
        System.out.println("Podaj nazwisko: ");
        nazwisko = scanner.next();
        System.out.println("Podaj pesel: ");
        pesel = scanner.nextInt();
        System.out.println("Podaj wiek: ");
        wiek = scanner.nextInt();
        System.out.println("Podaj pensje: ");
        pensja = scanner.nextInt();

        osoby.add(new Pielegniarka(imie, nazwisko, pesel, wiek, pensja));
    }

    public static void dodajPacjenta() {
        Scanner scanner = new Scanner(System.in);
        String imie, nazwisko;
        int pesel, wiek;

        System.out.println("Podaj imie: ");
        imie = scanner.next();
        System.out.println("Podaj nazwisko: ");
        nazwisko = scanner.next();
        System.out.println("Podaj pesel: ");
        pesel = scanner.nextInt();
        System.out.println("Podaj wiek: ");
        wiek = scanner.nextInt();

        osoby.add(new Pacjent(imie, nazwisko, pesel, wiek));
    }

    private static void leczenie() {
        int idlekarz, idpacjent;
        System.out.println("Leczenie pacjenta");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID lekarza");
        idlekarz = scanner.nextInt();
        System.out.println("Podaj ID pacjenta");
        idpacjent = scanner.nextInt();
        if (osoby.get(idlekarz) instanceof Lekarz && osoby.get(idpacjent) instanceof Pacjent) {
            Lekarz lekarz = (Lekarz) osoby.get(idlekarz);
            Pacjent pacjent = (Pacjent) osoby.get(idpacjent);
            lekarz.leczPacjenta(pacjent);
        } else {
            System.out.println("Nieprawidlowe dane");
        }
    }

    private static void szczepienie() {
        int idpielegniarka, idpacjent;
        System.out.println("Szczepienie pacjenta");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID pielegniarki");
        idpielegniarka = scanner.nextInt();
        System.out.println("Podaj ID pacjenta");
        idpacjent = scanner.nextInt();
        if (osoby.get(idpielegniarka) instanceof Pielegniarka && osoby.get(idpacjent) instanceof Pacjent) {
            Pielegniarka pielegniarka = (Pielegniarka) osoby.get(idpielegniarka);
            Pacjent pacjent = (Pacjent) osoby.get(idpacjent);
            pielegniarka.wykonajSzczepienie(pacjent);
        } else {
            System.out.println("Nieprawidlowe dane");
        }
    }

    private static void podwyzka() {
        int id;
        System.out.println("Dawanie podwyzki $$$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID pracownika");
        id = scanner.nextInt();
        if (osoby.get(id) instanceof Pielegniarka || osoby.get(id) instanceof Lekarz) {
            Pracownik pracownik = (Pracownik) osoby.get(id);
            Szpital.dajPodwyzke(pracownik);
            System.out.println("Przyznano wyplate");
        } else {
            System.out.println("Nieprawidlowe dane");
        }
    }

    public static void wyswietlMenu() {
        System.out.println("Menu : ");
        System.out.println("1 : Wyswietl pracownikow");
        System.out.println("2 : Wyswietl lekarzy");
        System.out.println("3 : Wyswietl pielegniarki");
        System.out.println("4 : Wyswietl pacjentow");
        System.out.println("5 : Dodaj lekarza");
        System.out.println("6 : Dodaj pielegniarke");
        System.out.println("7 : Dodaj pacjenta");
        System.out.println("8 : Lecz pacjenta");
        System.out.println("9 : Zaszczep pacjenta");
        System.out.println("10 : Daj podwyzke");
        System.out.println("0 : Wyjście");
    }

    public static boolean menu(int opcja) {
        switch (opcja) {
            case 1:
                wyswietlPracownikow();
                wyswietlMenu();
                return true;
            case 2:
                wyswietlLekarzy();
                wyswietlMenu();
                return true;
            case 3:
                wyswietlPielegniarki();
                wyswietlMenu();
                return true;
            case 4:
                wyswietlPacjentow();
                wyswietlMenu();
                return true;
            case 5:
                dodajLekarza();
                wyswietlMenu();
                return true;
            case 6:
                dodajPielegniarke();
                wyswietlMenu();
                return true;
            case 7:
                dodajPacjenta();
                wyswietlMenu();
                return true;
            case 8:
                leczenie();
                wyswietlMenu();
                return true;
            case 9:
                szczepienie();
                wyswietlMenu();
                return true;
            case 10:
                podwyzka();
                return true;
            default:
                return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stanPoczatkowy();
        wyswietlMenu();
        while (menu(scanner.nextInt())) ;
    }
}