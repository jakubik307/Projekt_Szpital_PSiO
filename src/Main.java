import StrategiaKosztyLeczenia.Koszty;
import StrategiaKosztyLeczenia.KosztyDorosly;
import StrategiaKosztyLeczenia.KosztyDziecko;
import StrategiaPensja.Pensja;
import StrategiaPensja.PensjaLekarz;
import StrategiaPensja.PensjaPielegniarka;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<Osoba> osoby = new ArrayList<>();

    public static void stanPoczatkowy() {
        //Wczytanie poczatkowej bazy danych w przypadku gdy nie byla ona wczesniej utworzona;
        Koszty koszty = new KosztyDorosly();
        Pensja pensja = new PensjaLekarz();

        Lekarz chirurg = new Lekarz("Jan", "Kowalski", 1, 31, 40, "chirurg");
        chirurg.setPensja(pensja.liczeniePensji(chirurg.getEtat()));
        Lekarz ogolny = new Lekarz("Piotr", "Nowak", 2, 25, 50, "ogolny");
        ogolny.setPensja(pensja.liczeniePensji(ogolny.getEtat()));

        pensja = new PensjaPielegniarka();

        Pielegniarka pielegniarka = new Pielegniarka("Anna", "Kowalska", 3, 41, 40);
        pielegniarka.setPensja(pensja.liczeniePensji(pielegniarka.getEtat()));

        Dorosly dorosly1 = new Dorosly("Jakub", "Mak", 4, 22);
        dorosly1.setKosztyLeczenia(koszty.liczenieKosztowLeczenia(dorosly1.getWiek()));

        koszty = new KosztyDziecko();

        Dziecko dziecko1 = new Dziecko("Anna", "Górska", 5, 6);
        dziecko1.setKosztyLeczenia(koszty.liczenieKosztowLeczenia(dziecko1.getWiek()));

        osoby.add(chirurg);
        osoby.add(ogolny);
        osoby.add(pielegniarka);
        osoby.add(dorosly1);
        osoby.add(dziecko1);
    }

    public static void wczytajDane() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("bazadanych.ser"));
            Object obj1 = is.readObject();
            osoby = (ArrayList<Osoba>) obj1;
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Wczytano domyslna baze danych");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void zapiszDane() {

        try {
            ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("bazadanych.ser"));
            so.writeObject(osoby);
            so.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void wyswietlPracownikow() {
        System.out.println("Lista pracownikow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pracownik) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void wyswietlLekarzy() {
        System.out.println("Lista lekarzy: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Lekarz) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void wyswietlPielegniarki() {
        System.out.println("Lista pielegniarek: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pielegniarka) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void wyswietlPacjentow() {
        System.out.println("Lista pacjentow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Pacjent) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void dodajLekarza() {
        Scanner scanner = new Scanner(System.in);
        String imie, nazwisko, specjalizacja;
        int pesel, wiek, etat;
        Pensja pensja = new PensjaLekarz(); //Ustawienie wybranej strategii przyznawania pensji

        try {
            System.out.println("Podaj imie: ");
            imie = scanner.next();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scanner.next();
            System.out.println("Podaj pesel: ");
            pesel = scanner.nextInt();
            System.out.println("Podaj wiek: ");
            wiek = scanner.nextInt();
            System.out.println("Podaj etat: ");
            etat = scanner.nextInt();
            System.out.println("Podaj specjalizacje: ");
            specjalizacja = scanner.next();

            Lekarz lekarz = new Lekarz(imie, nazwisko, pesel, wiek, etat, specjalizacja);
            //Ustawienie pensji lekarza
            lekarz.setPensja(pensja.liczeniePensji(lekarz.getEtat()));

            //Dodanie lekarza do bazy danych
            osoby.add(lekarz);
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono bledne dane");
        }
    }

    public static void dodajPielegniarke() {
        Scanner scanner = new Scanner(System.in);
        String imie, nazwisko;
        int pesel, wiek, etat;
        Pensja pensja = new PensjaPielegniarka(); //Ustawienie wybranej strategii przyznawania pensji

        try {
            System.out.println("Podaj imie: ");
            imie = scanner.next();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scanner.next();
            System.out.println("Podaj pesel: ");
            pesel = scanner.nextInt();
            System.out.println("Podaj wiek: ");
            wiek = scanner.nextInt();
            System.out.println("Podaj etat: ");
            etat = scanner.nextInt();

            Pielegniarka pielegniarka = new Pielegniarka(imie, nazwisko, pesel, wiek, etat);
            //Ustawienie pensji pielegniarki
            pielegniarka.setPensja(pensja.liczeniePensji(pielegniarka.getEtat()));

            //Dodanie pielegniarki do bazy danych
            osoby.add(pielegniarka);
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono bledne dane");
        }
    }

    public static void dodajPacjenta() {
        Scanner scanner = new Scanner(System.in);
        String imie, nazwisko;
        int pesel, wiek;
        Koszty koszty;

        try {
            System.out.println("Podaj imie: ");
            imie = scanner.next();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scanner.next();
            System.out.println("Podaj pesel: ");
            pesel = scanner.nextInt();
            System.out.println("Podaj wiek: ");
            wiek = scanner.nextInt();

            if (wiek < 18) {
                Dziecko dziecko = new Dziecko(imie, nazwisko, pesel, wiek);

                //Zastosowanie strategii liczenia kosztow leczenia dla dziecka
                koszty = new KosztyDziecko();
                dziecko.setKosztyLeczenia(koszty.liczenieKosztowLeczenia(dziecko.getWiek()));

                osoby.add(dziecko);
            } else {
                Dorosly dorosly = new Dorosly(imie, nazwisko, pesel, wiek);

                //Zastosowanie strategii liczenia kosztow leczenia dla doroslego
                koszty = new KosztyDorosly();
                dorosly.setKosztyLeczenia(koszty.liczenieKosztowLeczenia(dorosly.getWiek()));

                osoby.add(dorosly);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono bledne dane");
        }
    }

    public static void szukajNazwisko() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwisko: ");
        String nazwisko = scanner.next();

        System.out.println("Lista wynikow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i).getNazwisko().equals(nazwisko)) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void szukajPacjentPesel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pesel pacjenta: ");
        int pesel = scanner.nextInt();

        System.out.println("Lista wynikow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i).getPesel() == pesel) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void szukajPracownikWiek() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj minimalny wiek: ");
        int wiek = scanner.nextInt();

        System.out.println("Lista wynikow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i).getWiek() == wiek) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    public static void szukajSpecjalizacja() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj specjalizacje: ");
        String specjalizacja = scanner.next();

        System.out.println("Lista wynikow: ");

        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Lekarz && ((Lekarz) osoby.get(i)).getSpecjalizacja().equals(specjalizacja)) {
                System.out.println("ID:" + i + " " + osoby.get(i));
                System.out.println();
            }
        }
        System.out.println("Nie znaleziono (innych) wynikow w bazie danych");
    }

    private static void leczenie() {
        int idlekarz, idpacjent;
        System.out.println("Leczenie pacjenta");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID lekarza");
        idlekarz = scanner.nextInt();
        System.out.println("Podaj ID pacjenta");
        idpacjent = scanner.nextInt();

        try {
            if (osoby.get(idlekarz) instanceof Lekarz lekarz && osoby.get(idpacjent) instanceof Pacjent pacjent) {
                lekarz.leczPacjenta(pacjent);
            } else {
                System.out.println("Nieprawidlowe dane");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nieprawidlowe ID");
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

        try {
            if (osoby.get(idpielegniarka) instanceof Pielegniarka pielegniarka && osoby.get(idpacjent) instanceof Pacjent pacjent) {
                pielegniarka.wykonajSzczepienie(pacjent);
            } else {
                System.out.println("Nieprawidlowe dane");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nieprawidlowe ID");
        }
    }

    private static void podwyzka() {
        int id;
        System.out.println("Dawanie podwyzki $$$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID pracownika");
        id = scanner.nextInt();
        try {
            if (osoby.get(id) instanceof Pielegniarka || osoby.get(id) instanceof Lekarz) {
                Pracownik pracownik = (Pracownik) osoby.get(id);
                Szpital.dajPodwyzke(pracownik);
                System.out.println("Przyznano wyplate");
            } else {
                System.out.println("Nieprawidlowe dane");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nieprawidlowe ID");
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
        System.out.println("11 : Szukaj po nazwisku");
        System.out.println("12 : Szukaj pacjenta po peselu");
        System.out.println("13 : Szukaj pracownika starszego niz");
        System.out.println("14 : Szukaj lekarza po specjalizacji");
        System.out.println("0 : Wyjście");
    }

    public static boolean menu(String opcja) {
        switch (opcja) {
            case "1":
                wyswietlPracownikow();
                wyswietlMenu();
                return true;
            case "2":
                wyswietlLekarzy();
                wyswietlMenu();
                return true;
            case "3":
                wyswietlPielegniarki();
                wyswietlMenu();
                return true;
            case "4":
                wyswietlPacjentow();
                wyswietlMenu();
                return true;
            case "5":
                dodajLekarza();
                wyswietlMenu();
                return true;
            case "6":
                dodajPielegniarke();
                wyswietlMenu();
                return true;
            case "7":
                dodajPacjenta();
                wyswietlMenu();
                return true;
            case "8":
                leczenie();
                wyswietlMenu();
                return true;
            case "9":
                szczepienie();
                wyswietlMenu();
                return true;
            case "10":
                podwyzka();
                wyswietlMenu();
                return true;
            case "11":
                szukajNazwisko();
                wyswietlMenu();
                return true;
            case "12":
                szukajPacjentPesel();
                wyswietlMenu();
                return true;
            case "13":
                szukajPracownikWiek();
                wyswietlMenu();
                return true;
            case "14":
                szukajSpecjalizacja();
                wyswietlMenu();
                return true;
            case "0":
                return false;
            default:
                System.out.println("Wprowadzono nieprawidlowa opcje\n");
                wyswietlMenu();
                return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        stanPoczatkowy(); //Dodanie domyslnych osob do bazy danych
        wczytajDane();
        wyswietlMenu();
        while (menu(scanner.next())) ; // Glowna petla obslugujaca menu
        zapiszDane();
    }
}