import java.util.Arrays;

public class While
{
  public static void main(String[] args)
  {
    int  array[] = new int[5];
    int teller = 0;
    int verdi = 0;

    while(teller<5)
      {
	array[teller] = verdi + 1;
	teller = teller + 1;
	verdi = verdi + 1;
      }
    System.out.println(Arrays.toString(array));
  }
}
