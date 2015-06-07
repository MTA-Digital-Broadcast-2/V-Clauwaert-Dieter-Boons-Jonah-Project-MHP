public class PartTimeWerknemer extends Werknemer {
		
	int urenGewerkt;
	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urengw)
	{
		super(voornaam, achternaam, wNummer, salaris);
		urenGewerkt = urengw;
	}

	
	public void salarisVerhogen(int percentage)
	{
		if (percentage > 5) 
		{
			System.out.println("Fout: partimemers kunnnen maar 5% opslag krijgen");
		}
		else
		{
			super.salarisVerhogen(percentage);
		}
	}
}