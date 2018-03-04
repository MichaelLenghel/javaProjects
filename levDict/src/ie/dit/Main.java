package ie.dit;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main
{
	void matrixMultiplication()
	{
		Matrix a = new Matrix(4, 5);
		a.identity();
		a.setElement(2, 3, 7);
		a.setElement(3, 1, 2);
		a.setElement(3, 0, 4);

		Matrix b = new Matrix(4, 4);
		b.identity();
		b.setElement(2, 3, 1);
		b.setElement(3, 1, 9);
		b.setElement(3, 0, -7);

		//a.mult(b); // Add b to a. This is like a+= b;

		Matrix c = null;
		// Add b to a, without changing a. Instead create a new matrix and return it
		// This is like c = a + b

		try
		{
			c = Matrix.mult(a, b); // How to call a static method
		}
		catch(MatrixException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		finally
		{
			System.out.println("This always happens");
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

	public void editDistance()
	{
		String sa = "I love DIT";
		String sb = "I love Tunepal";
		System.out.println("Edit distance between: " + sa + " and: " + sb + " is " + EditDistance.MinimumEditDistance(sa, sb));

		sa = "Games Fleadh";
		sb = "Imagine Cup";
		System.out.println("Edit distance between: " + sa + " and: " + sb + " is " + EditDistance.MinimumEditDistance(sa, sb));
	}

	public void dictionary()
	{
		Dictionary d = new Dictionary();
		Scanner scanner = new Scanner (System.in);
		String w = null;
		do
		{
			System.out.print("Enter your word: ");  
			w = scanner.next(); // Get what the user types.
			if (w.equals("quit")) 
			{
				break;
			}
			else
			{
				String[] ret = d.findClosest(w, 10);
				if (ret[0].equals(w)) 
				{
					System.out.println("String " + w + " matches");
				}
				else
				{
					for (int i = 0;i < 10 ;i++ ) 
					{
						System.out.println(ret[i]);
					}
				}//end else
				
			}
		}while(true);
		

		//System.out.println(d.findClosest("bread"));
		//System.out.println(d.findClosest("militarry"));

		//String[] words = d.findClosest("helo", 10);
		// for(int i = 0 ; i < words.length ; i ++)
		// {
		// 	System.out.println(words[i]);
		// }
	}
	public void strings()
	{
		String s = "I love Star Trek";

		System.out.println(s.length());
		System.out.println(s.contains("love"));
		System.out.println(s.contains("hate"));
		System.out.println(s.startsWith("I love"));
		System.out.println(s.endsWith("cats"));
		System.out.println(s.equals("Hello"));
		
		String ss = s.substring(7);

		System.out.println(ss);
		// Incorrect way to compare strings
		if (ss == "Star Trek")
		{
			System.out.println("Same");
		}
		else
		{
			System.out.println("Different");
		}
		// Correct way to compare strings
		if (ss.equalsIgnoreCase("Star Trek"))
		{
			System.out.println("Same");
		}
		else
		{
			System.out.println("Different");
		}

		String star = ss.substring(0, 5);
		System.out.println(star.toUpperCase());

	}

	public void transform()
	{
		try
		{
			Vector v = new Vector(5, 10);
			Matrix trans = Matrix.translation(2, -11);

			System.out.println(trans.transform(v));

			Matrix scale = Matrix.scaling(2, 3);
			
			System.out.println(scale.transform(v));

			Matrix combined = Matrix.mult(scale, trans);

			System.out.println(combined.transform(v));
		}
		catch(MatrixException e)
		{
			e.printStackTrace();
		}
		finally
		{

		}
	}

	public void tuneFinder()
	{
		JFrame tf  = new TuneFinder();

		tf.setVisible(true);
		tf.setSize(500, 500);

	}

	public static void main(String[] args)
	{
		Main main = new Main();
		//main.matrixMultiplication();
		//main.editDistance();
		//main.strings();
		//main.dictionary();
		//main.transform();

		//main.matrixMultiplication();
		//main.tuneFinder();
		main.dictionary();
	}


}