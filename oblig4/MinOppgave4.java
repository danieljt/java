import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

/*
  Program for reading a file with two information lines
  and then two columns of coordinates. Program inserts coordinates
  into arrays and then calculates the velocities
  of each coordinate vector with respect to time. 
 */

public class MinOppgave4
{
  public static void main(String[] args) throws Exception
  {
    Scanner reader = new Scanner(System.in);

    // Read filename from command line
    System.out.print("Enter the filename of the gps coordinates: ");
    String filename = reader.nextLine();

    // Read file and scan
    File inputfile = new File(filename);
    Scanner file = new Scanner(inputfile);

    // Arrays for coordinates
    double[] x = new double[20];
    double[] y = new double[20];
    
    // Skip first two lines
    file.nextLine();
    file.nextLine();

    // Loop rest of file and aquire x and y coordinates
    int i = 0;
    while (file.hasNextDouble())
      {
	double value1 = file.nextDouble();
	double value2 = file.nextDouble();
	x[i] = value1;
	y[i] = value2;
	i += 1;
      }
    // close file
    file.close(); 

    // Calculate velocities
    double[] xvel = velocity(x);
    double[] yvel = velocity(y);
    
    // Print velocities for controll
    System.out.println(Arrays.toString(xvel));
    System.out.println(Arrays.toString(yvel));
  }
  /**
     Method for calculating the numerical derivative
     of a an array. returns a new array with the 
     computed velocities.
     @param array The array with coordinates.
     @returns The velocities of the array.
   */
  static double[] velocity(double[] array)
  {
    // Time step
    double dt = 0.1;

    // Compute Velocities and insert to array
    double[] vel = new double[array.length-1];
    for (int k=0; k < array.length-1; k++)
      {
	double velocity = (array[k+1] - array[k])/dt;
	vel[k] = velocity;
      }
    return vel;
  }
}
