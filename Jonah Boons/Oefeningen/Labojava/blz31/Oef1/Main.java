public class Main {

public static void main(String Args[])
	{
	Werknemer herman= new Werknemer("herman", "hermans", 1, 1000);
	Werknemer jonah= new Werknemer("jonah", "boons", 2, 50000);
	Werknemer jasper= new Werknemer("jasper", "cludts", 3, 10);
	Werknemer mats= new Werknemer("mats", "kennes", 4, 2145);

	System.out.println(jonah.voornaam + " verdient "+jonah.getSalaris());

	herman.salarisVerhogen(10);
	jonah.salarisVerhogen(100);

	System.out.println(herman.voornaam + " verdient "+herman.getSalaris());
	System.out.println(jonah.voornaam + " verdient "+jonah.getSalaris());
	
	}
}