import java.lang.*;

public class Oef1 {
public static void main (String args[])
{
int getal = 1;
int tafel = 1;
while (tafel < 10)
{
while(getal <10)
{
int uitkomst = tafel * getal;
System.out.println(tafel + "x" +  getal + "= " + uitkomst);
getal ++;
}
getal = 1;
tafel ++;
}
}
}