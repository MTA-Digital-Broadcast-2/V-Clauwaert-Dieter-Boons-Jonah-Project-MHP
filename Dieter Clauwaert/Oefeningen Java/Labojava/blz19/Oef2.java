import java.lang.*;

	public class Oef2 {

		public static void main(String args[])
		{
			String dagen[] = {"zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"};
			int i=1;
			int j=0;
			while (i<=28)
			{			
				if (j>6)
				{
					j=0;
				}
				System.out.println(dagen[j]+" "+i+" februari");
				i++;
				j++;
			}
		}
}