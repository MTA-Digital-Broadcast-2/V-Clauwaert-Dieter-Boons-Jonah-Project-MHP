public class PartTimeWerknemer extends Werknemer {
		
	int urenGewerkt;
	public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urengw)
	{
		super(voornaam, achternaam, wNummer, salaris);
		urenGewerkt = urengw;
	}
}