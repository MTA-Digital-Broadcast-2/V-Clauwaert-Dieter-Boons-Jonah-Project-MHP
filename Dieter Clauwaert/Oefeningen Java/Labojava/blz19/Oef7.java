import java.lang.*;
import java.util.Arrays;

	public class Oef7 {

		public static void main(String args[])
		{
			int a[]={12,34,56,78,123,234,99,88};
			int b[]=new int[8];
			int grootstegetal = 0;
			int index = 0;
			for (int i=0;i<8;i++)
			{
				for (int j=0;j<8;j++)
				{
					if (a[j]>grootstegetal)
					{
						grootstegetal = a[j];
						index = Ints.indexOf(a, grootstegetal);
					}
				}
				b[i]=grootstegetal;
				a[index]=0;
				grootstegetal=0;
			}
			System.out.println(Arrays.toString(b));
		}
}