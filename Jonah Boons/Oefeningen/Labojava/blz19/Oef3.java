/*import java.lang.*;

public class Oef3 {
public static void main (String args[])
{
int teller = 1;
int noemer = 1;
double term = teller / noemer;
double beginGetal =1; 
int aantalTermen = 10000;
//int getalBreuk[aantalTermen];
double uitkomst = 4 * term;

for (int i=1;i<aantalTermen;i++)
{
noemer = noemer + 2;
if (aantalTermen % 2 == 0)
{
//als het aantal termen even is: er komt een + na
beginGetal = beginGetal + teller/noemer;
}
else
{
//als het aantal termen oneven is: er komt een - na
beginGetal = beginGetal - teller/noemer;
}
System.out.println(noemer);

}
System.out.println("Pi = "  + uitkomst);
}
}*/
import java.lang.*;

public class Oef3
{
	public static void main(String args[])
	{

	int i;
        
	boolean bewerking = false;
        
	float som = 1;
 
       
	for(i = 1; i < 10001; i++) 
		{

            	if(!bewerking) 
			{
                
			som -= 1 / (float) (i + (i+1));
                
			bewerking = true;
  
			} 
		else 
			{
                
			som += 1 / (float) (i + (i+1));
                
			bewerking = false;
            
			}
       
		 }
        
		System.out.println("pi = " + (4 * som));
   
 	}
    
}
