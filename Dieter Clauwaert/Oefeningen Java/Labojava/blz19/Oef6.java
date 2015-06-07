import java.lang.*;

	public class Oef6 {
		
		public static void main(String args[])
		{
			int a[]={12,34,56,78,123,234,99,88};
			int grootstegetal = 0;

			for (int i=0;i<8;i++)
			{
				if (a[i]>grootstegetal)
				{
					grootstegetal = a[i];
				}
			}
			System.out.println("het grootste getal is " + grootstegetal);
		}
}