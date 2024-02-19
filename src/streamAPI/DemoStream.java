package streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class DemoStream {

	public static void main(String[] args) {

		List<Termek> termekek = new ArrayList<Termek>();

		termekek.add(new Termek("Iphone", "mobil", 99000, true));
		termekek.add(new Termek("HP", "laptop", 150000, false));
		termekek.add(new Termek("Xiaomi", "mobil", 125000, false));
		termekek.add(new Termek("Samsung", "mobil", 320000, false));
		termekek.add(new Termek("Lenovo", "laptop", 85000, true));
		termekek.add(new Termek("Sony", "mobil", 75000, true));
		termekek.add(new Termek("Iphone", "mobil", 85000, true));

		System.out.println("A termekek osszerteke: " + termekek.stream().mapToInt(x -> x.getAr()).sum() + " Ft");
		System.out.println();

		System.out.println("Keszleten levo mobilok szama:"
				+ termekek.stream().filter(x -> x.getTipus().equalsIgnoreCase("mobil")).count() + " db");
		System.out.println();

		try {
			System.out.println("Legdragabb hasznalt laptop: "
					+ termekek.stream().filter(x -> x.getTipus().equalsIgnoreCase("laptop")).filter(x -> x.isHasznalt())
							.max(Comparator.comparing(Termek::getAr)).orElseThrow(NoSuchElementException::new));
			// dupla kettospont operator metodushivast jelent
		} catch (NoSuchElementException e) {
			System.out.println("Nincs eredmeny!");
		}
		System.out.println();

		List<Termek> olcsoTermekek = termekek.stream().filter(x -> x.getAr() < 100000)
				.sorted(Comparator.comparing(Termek::getMegnevezes)).toList();
		System.out.println("100 ezer Ft-nal olcsobb termekek abc sorrendben, uj listaban: ");
		for (Termek termek : olcsoTermekek) {
			System.out.println(termek);
		}

	}

}
