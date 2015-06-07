public class Main {

	public static void main(String args[])
	{
		Werknemer dieter = new Werknemer("Dieter", "Clauwaert", 1, 1000);
		Werknemer jasper = new Werknemer("Jasper", "Cludts", 2, 2000);
		Werknemer mats = new Werknemer("Mats", "Kennes", 3, 3000);
		Werknemer jonah = new Werknemer("Jonah", "Boons", 4, 4000);

		System.out.println(dieter.voornaam + " verdient " + dieter.getsalaris());	
	}
}