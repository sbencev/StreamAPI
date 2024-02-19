package streamAPI;

public class Termek {

	private String megnevezes;
	private String tipus;
	private int ar;
	private boolean hasznalt;

	public Termek(String megnevezes, String tipus, int ar, boolean hasznalt) {
		this.megnevezes = megnevezes;
		this.tipus = tipus;
		this.ar = ar;
		this.hasznalt = hasznalt;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public String getTipus() {
		return tipus;
	}

	public int getAr() {
		return ar;
	}

	public boolean isHasznalt() {
		return hasznalt;
	}

	@Override
	public String toString() {
		return megnevezes + " " + tipus + " " + ar + " Ft " + (hasznalt ? "hasznalt" : "uj");
	}

}
