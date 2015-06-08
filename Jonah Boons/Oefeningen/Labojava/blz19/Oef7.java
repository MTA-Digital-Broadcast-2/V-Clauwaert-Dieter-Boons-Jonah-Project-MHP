import java.lang.*;
import java.util.Arrays;

public class Oef7
{
	public static void main(String args[])
	{
	int a[] = {12,34,56,78,123,234,99,88};
	int b[] = new int[8];
	int grootstegetal =0;
	int j;
	for (int n=0; n<b.length;n++){
	grootstegetal = 0;
		for (int i = 0; i<a.length;i++){
			if ((a[i] > 0) && (a[i] > grootstegetal) )
			{
			grootstegetal = a[i];
			}
		}
		for(j = 0; j < a.length; j++) {
                	if(a[j] == grootstegetal)
			{
                   	 a[j] = 0;
                	}
           	 }		
			
		System.out.println("Het grootste getal is " + grootstegetal);
		b[n] = grootstegetal;
		System.out.println(Arrays.toString(b));
	}
}
}