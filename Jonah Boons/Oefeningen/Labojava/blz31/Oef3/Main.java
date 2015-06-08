public class Main { //oef3

public static void main(String Args[])
	{
	Werknemer herman= new Werknemer("herman", "hermans", 1, 1000);
	Werknemer jonah= new Werknemer("jonah", "boons", 2, 50000);
	Werknemer jasper= new Werknemer("jasper", "cludts", 3, 10);
	Werknemer mats= new Werknemer("mats", "kennes", 4, 2145);

	System.out.println(jonah.voornaam + " verdient "+jonah.getSalaris());
	//oef2
	herman.salarisVerhogen(10);
	jonah.salarisVerhogen(100);

	System.out.println(herman.voornaam + " verdient "+herman.getSalaris());
	System.out.println(jonah.voornaam + " verdient "+jonah.getSalaris());
	//oef3
	PartTimeWerknemer ilse=new PartTimeWerknemer("ilse","luiaert",5,1200,10);
	PartTimeWerknemer peggy=new PartTimeWerknemer("peggy","foorwijf",6,1400,22);
	//oef4
	ilse.salarisVerhogen(10);
	peggy.salarisVerhogen(5);
	System.out.println(ilse.voornaam + " verdient "+ilse.getSalaris());
	System.out.println(peggy.voornaam + " verdient "+peggy.getSalaris());
	//oef5 //oef 6
	System.out.println(ilse.voornaam + " betaalt "+ilse.getRSZ() + "% RSZ");
	System.out.println(jonah.voornaam + " betaalt "+jonah.getRSZ() + "% RSZ");
	//oef7
	StudentWerknemer bert=new StudentWerknemer("bert", "blokker", 7, 8, 38);
	System.out.println(bert.voornaam + " betaalt "+bert.getRSZ() + "% RSZ");
	//oef8 //oef9
	bert.betaal();
	ilse.betaal();
	jonah.betaal();
	//oef 10
	Faktuur fakt1 = new Faktuur(99, 1);
	fakt1.betaal();

	//DEMO interfaces

	Betaalbaar tebetalen[] = new Betaalbaar[2];
	
	tebetalen[0]=bert;	//StudentWerknemer
	tebetalen[1]=fakt1;	//Faktuur
	
//ERROR: String is geen betaalbaar object!!!
	
	for (int i=0; i<2;i++)	//betaal alle objecten
		{
		tebetalen[i].betaal();
		}
	
	}
}