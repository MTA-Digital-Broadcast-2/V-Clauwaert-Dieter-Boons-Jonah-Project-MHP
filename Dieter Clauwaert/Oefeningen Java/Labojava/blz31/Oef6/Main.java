public class Main {

	public static void main(String args[])
	{
		Werknemer dieter = new Werknemer("Dieter", "Clauwaert", 1, 1000);
		Werknemer jasper = new Werknemer("Jasper", "Cludts", 2, 2000);
		Werknemer mats = new Werknemer("Mats", "Kennes", 3, 3000);
		Werknemer jonah = new Werknemer("Jonah", "Boons", 4, 4000);

		PartTimeWerknemer alex = new PartTimeWerknemer("Alex", "Spildooren", 5, 5000, 5);
		PartTimeWerknemer alexis = new PartTimeWerknemer("Alexis", "Guiette", 6, 6000, 6);
		
/*		
		dieter.salarisVerhogen(10);
		jasper.salarisVerhogen(10);
		mats.salarisVerhogen(10);
		jonah.salarisVerhogen(10);		

		System.out.println(dieter.voornaam + " verdient " + dieter.getsalaris());
		System.out.println(jasper.voornaam + " verdient " + jasper.getsalaris());
		System.out.println(mats.voornaam + " verdient " + mats.getsalaris());
		System.out.println(jonah.voornaam + " verdient " + jonah.getsalaris());	


		alex.salarisVerhogen(4);
		alexis.salarisVerhogen(4);
		
		System.out.println(alex.voornaam + " verdient " + alex.getsalaris() + " en werkt " + alex.urenGewerkt + " uur ");		
		System.out.println(alexis.voornaam + " verdient " + alexis.getsalaris() + " en werkt " + alexis.urenGewerkt + " uur ");
*/

		System.out.println(alex.voornaam + " betaalt " + alex.getRSZ() + " % RSZ ");		
		System.out.println(dieter.voornaam + " betaalt " + dieter.getRSZ() + " % RSZ ");
	}
}