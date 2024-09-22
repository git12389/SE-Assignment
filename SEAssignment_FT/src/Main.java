 /* Near Miss, Fermat's Last Theorem
 * Main.java holds the Program
 * 
 * Programmer's Names: 
 * 		Manikanta Iskala Email Address: ManikantaIskala@lewisu.edu
 * 		Naga Manohar Sharma Sankaramanchi 
 * 
 * Course Name: FA24-CPSC-60500-002
 * 
 * Date of Submission: September 22, 2024
 * 
 * Step 1: n and k is user input
 * Step 2: left hand side (lhs): x power n + y power n is calculated
 * Step 3: To get value of z, take nth root of the result of lhs calculated previously
 * Step 4: For getting near miss value ==> "left hand side - z power n" and "(z+1) power n - left hand side" minimum value from these 2 will be near miss
 * Step 5: Calculated relative miss
 * Step 6: Compare relative miss with smallest miss to get  smallest possible miss
 *  
 * Just applied the formula given in instructions and Got the results, so no help from any out source material
 */
import java.util.Scanner;
import java.lang.Math;
public class Main {
	
	/*
	 * main function: It computes all the calculations from start to end.
	 */

	public static void main(String[] args) 
	{ 
		double smallest_miss = 9999999999999999.99;
		
		int lowerlimit = 10;
		int k = 0;//K for range
	    int n = 0;//n for power
		
	    //Long data type variables for x, y, and z since program would crash or overflow if we neglect to utilize it and can get rather extremely huge value.
		long x = lowerlimit;
	    long y = 0;
	    long z = 0;
	    long x_value = 0;
	    long y_value = 0;
	    
	    // taking user input
	    Scanner userinput = new Scanner(System.in);
	    
	    //do while loop to make sure program does not crash in case of wrong input
	    do {
	    	System.out.println("Enter value for K (K >=10 ) ::  ");
		    k = userinput.nextInt();
	    }while(k<10);
	    do {
	    	System.out.println("Enter Value for n (3>=n>=11): ");
		    n = userinput.nextInt();
	    }while(n<3 || n>11); 
	    
	    //while loop to compare every x with all possible y values
	    while(x<=k) 
	    {
	    	for (y = lowerlimit; y<=k; y++)
	    	{	
	    		
	        	//lhs = x power n + y power n
	        	long lhs = (long)((Math.pow (x, n))+(Math.pow (y, n)));
	        
	        	//taking nth root of left hand side to get the z value
	        	z = (int) Math.pow (lhs, 1.0/n);
	        
	        	//near miss for z and z+1
	        	long nearmiss = (long)(lhs - Math.pow (z, n));
	        	if(((long)(Math.pow (z+1, n) - lhs))<nearmiss)
	        	{
	        		nearmiss = (long)(Math.pow (z+1, n) - lhs);
	        	}
	        
	        	//relative miss
	        	double relativemiss = 1. * nearmiss / lhs;
	        
	        
	        	//smallest miss
	        	if(relativemiss<smallest_miss)
	        	{
	        		smallest_miss = relativemiss;

	        		x_value = x;
	        		y_value = y;
	        	}
	        	//System.out.println("Smallest Miss= "+smallest_miss);
	           
	        }
	    	x++;
	    }
	    System.out.println("x :: "+x_value+", y :: "+y_value+",  Relative Diff :: "+String.format("%.7f", smallest_miss));
	    
	}
}


