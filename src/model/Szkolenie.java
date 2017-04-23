package model;

import java.math.BigDecimal;

public class Szkolenie extends Produkt {

	private String technologia;

	public Szkolenie(String nazwa, BigDecimal cena, String technologia) {
		super(cena, nazwa);

		this.technologia = technologia;
	}

	public String getTechnologia() {
		return technologia;
	}

	public void setTechnologia(String technologia) {
		this.technologia = technologia;
	}

	@Override
	public String toString() {
		return "Szkolenie [nazwa=" + nazwa + ", cena=" + cena + ", technologia=" + technologia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cena == null) ? 0 : cena.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((technologia == null) ? 0 : technologia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Szkolenie other = (Szkolenie) obj;
		if (cena == null) {
			if (other.cena != null)
				return false;
		} else if (!cena.equals(other.cena))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (technologia == null) {
			if (other.technologia != null)
				return false;
		} else if (!technologia.equals(other.technologia))
			return false;
		return true;
	}

	public String dajRabat() {
		return "-15%";
	}

}
