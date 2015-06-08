public class Werknemer implements Betaalbaar { //oef 3
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage=33.0f;

public Werknemer(String voornaam, String achternaam, int wNummer, float salaris)
	{
	this.voornaam=voornaam;
	this.achternaam=achternaam;
	werknemerNummer=wNummer;
	this.salaris=salaris;
	}

public void salarisVerhogen(int percentage)
	{
	float verhogingsfactor=(float)percentage/100;
	salaris+=salaris*verhogingsfactor;
	}

public float getSalaris()
	{
	return salaris;
	}
public float getRSZ() { return RSZpercentage; }

public void setRSZ(float RSZ) { 
	if (RSZ <0.0f) { return; }
	if (RSZ >100.0f) { return; }

	RSZpercentage=RSZ; 
	}
	
public void betaal() {
	System.out.println("Betaal " + getSalaris() + " aan " +this.voornaam);
}
}