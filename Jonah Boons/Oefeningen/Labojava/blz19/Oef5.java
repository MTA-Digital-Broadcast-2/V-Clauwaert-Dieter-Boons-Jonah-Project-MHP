/*import java.lang.*;

public class Oef5
{
	public static void main(String args[])
	{

		for (int i=3;i<99;i++)
		{
			for (int n=2;n<99;n++)
			{
				if (i != n)
				{
					if (i % n !=0)
					{
					System.out.println(i + " is een priemgetal");
					}
				}
				else if ((i%(-1) == 0) && (i%n > 0))
				{
				System.out.println(i + " is een priemgetal");
				}
			}
		}
		System.out.println("priemgetallen");
   
 	}
    
}
*/
import java.lang.*;

public class Oef5
{
	public static void main(String args[])
	{
int priemgetallen = 2;
int delers;    
boolean priem;

while (priemgetallen<100)
		{
		priemgetallen+=1;
		delers=2;
		priem=false;

		while((delers<priemgetallen) & (!priem)) {
		if ((priemgetallen%delers)==0) {
		priem=true;
		}
delers+=1;
		}	
if (!priem){
System.out.println(priemgetallen + " is geen priemgetal");
}
}
}
}
