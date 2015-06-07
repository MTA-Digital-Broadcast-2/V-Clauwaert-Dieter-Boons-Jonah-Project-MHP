public class Main {

	public static void main(String args[])
	{
		Werknemer dieter = new Werknemer("Dieter", "Clauwaert", 1, 1000);
		Werknemer jasper = new Werknemer("Jasper", "Cludts", 2, 2000);
		Werknemer mats = new Werknemer("Mats", "Kennes", 3, 3000);
		Werknemer jonah = new Werknemer("Jonah", "Boons", 4, 4000);
		
		dieter.salarisVerhogen(10);
		jasper.salarisVerhogen(10);
		mats.salarisVerhogen(10);
		jonah.salarisVerhogen(10);		

		System.out.println(dieter.voornaam + " verdient " + dieter.getsalaris());
		System.out.println(jasper.voornaam + " verdient " + jasper.getsalaris());
		System.out.println(mats.voornaam + " verdient " + mats.getsalaris());
		System.out.println(jonah.voornaam + " verdient " + jonah.getsalaris());	
	}
}