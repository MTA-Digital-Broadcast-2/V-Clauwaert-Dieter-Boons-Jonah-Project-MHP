import java.lang.*;

public class Oef2 {
public static void main (String args[])
{
String maand = "februari";
String dag[] = {"zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"};
int datum = 1;
int arrayIndex = 0;

do {
System.out.println(dag[arrayIndex] + " " +  datum + " " + maand);
arrayIndex++;
datum++;
if (arrayIndex == 7)
{
arrayIndex = 0;
}
}
while (datum <29);

}
}