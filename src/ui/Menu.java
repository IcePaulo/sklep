package ui;

import java.math.BigDecimal;
import java.util.Scanner;

import model.Komputer;
import model.Produkt;
import model.Sklep;
import model.Szkolenie;

public class Menu {
	public void wyswietlMenu() {
		Sklep sklep = new Sklep("www.sklep.com");
		Scanner skaner = new Scanner(System.in);
		System.out.println("1 - dodaj komputer");
		System.out.println("2 - usun produkt");
		System.out.println("3 - edytuj komputer");
		System.out.println("4 - wyswietl produkty");
		System.out.println("5 - Dodaj szkolenie");
		System.out.println("6 - Wyœwietl Rabaty");

		System.out.println("q - wyjscie");
		String wybor;
		do {
			System.out.print("Podaj wybor: ");
			wybor = skaner.nextLine();

			switch (wybor) {
			case "1": {
				System.out.print("Podaj cene: ");
				BigDecimal cena = skaner.nextBigDecimal();
				skaner.nextLine();
				System.out.print("Podaj nazwe: ");
				String nazwa = skaner.next();
				skaner.nextLine();
				System.out.print("Podaj cpu: ");
				String cpu = skaner.next();
				skaner.nextLine();
				System.out.print("Podaj ram: ");
				String ram = skaner.next();
				skaner.nextLine();

				Komputer komputer = new Komputer(cena, nazwa, cpu, ram);

				sklep.dodajProdukt(komputer);
			}
				break;
			case "2": {

				if (sklep.czyPusty()) {
					System.out.println("Sklep pusty");

				} else {

					sklep.wyswietlListe();
					System.out.print("Podaj indeks do usuniecia: ");

					int index = skaner.nextInt();
					skaner.nextLine();

					if (sklep.sprawdzIndeks(index)) {
						sklep.usunProdukt(index);
						System.out.println("Produkt zosta³ poprawnie usuniety.");
					} else {
						System.out.println("Podales niepoprawny indeks");
					}
				}
			}
				break;
			case "3": {
				sklep.wyswietlListe();
				System.out.print("Który komputer chcesz edytowaæ: ");
				int index = skaner.nextInt();
				skaner.nextLine();
				Produkt produkt = sklep.znajdzProdukt(index);

				if (produkt instanceof Komputer) {
					Komputer komputer = (Komputer) sklep.znajdzProdukt(index);

					System.out.print("Podaj nowa cene (aktualna: " + komputer.getCena() + "): ");
					BigDecimal cena = skaner.nextBigDecimal();
					skaner.nextLine();

					System.out.print("Podaj nowa nazwe (aktualna: " + komputer.getNazwa() + "): ");
					String nazwa = skaner.nextLine();

					System.out.print("Podaj nowe cpu (aktualne: " + komputer.getCpu() + "): ");
					String cpu = skaner.nextLine();

					System.out.print("Podaj nowy ram (aktualny: " + komputer.getRam() + "): ");
					String ram = skaner.nextLine();

					// komputer.setCena(cena);
					// komputer.setNazwa(nazwa);
					// komputer.setCpu(cpu);
					// komputer.setRam(ram);

					komputer.zaktualizuj(cena, nazwa, cpu, ram);

					sklep.zmodyfikujProdukt(index, komputer);
				} else {
					System.out.println("To nie jest komputer!");
				}

			}
				break;
			case "4":
				sklep.wyswietlListe();
				break;
			case "5": {
				System.out.print("Podaj cene: ");
				BigDecimal cena = skaner.nextBigDecimal();
				skaner.nextLine();
				System.out.print("Podaj nazwe: ");
				String nazwa = skaner.next();
				skaner.nextLine();
				System.out.print("Podaj technologie: ");
				String technologia = skaner.next();
				skaner.nextLine();

				Szkolenie szkolenie = new Szkolenie(nazwa, cena, technologia);

				sklep.dodajProdukt(szkolenie);

			}
			break;
			
			case "6":
				
				sklep.wyswietlRabaty();
				
				break;
			
				
			case "q":
			case "Q":
				System.out.println("Koniec programu");
				break;
			default:
				System.out.println("Bledny wybor");
				break;
			}
		} while (!wybor.equalsIgnoreCase("q"));
	}
}