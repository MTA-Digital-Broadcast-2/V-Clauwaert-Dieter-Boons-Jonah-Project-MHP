public class Faktuur implements Betaalbaar {

	int bedrag = 0;
	int factnr = 0;

	public Faktuur(int bedrag, int factnr)
	{
		this.bedrag = bedrag;
		this.factnr = factnr;
	}

	public void betaal()
	{
		System.out.println("Betaal het factuur " + factnr + " met het bedrag " + bedrag);
	}
}