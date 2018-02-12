package ie.dit;

public class EditDistance
{
	public static float min3(float f1, float f2, float f3)
	{
		float min = f1;

		if (f2 < min) 
		{
			min = f2;
		}

		if(f3 < min)
		{
			min = f3;
		}

		return min;
	}//end min3
//3 shots
	public static float MinimumEditDistance(String needle, String haystack)
	{
		float min = 0.0f;
		int i, j;
		//needle will give the length of the array, but we need an extra space for 0 at the start
		int rows = needle.length() ;
		int cols = haystack.length();
		
		if (rows == 0 || cols == 0)
		{
			return 0.0f;
		}//end if
		
		//Create the matrix which will store the edits
		Matrix lev = new Matrix(rows, cols);

		//Initialise the first row of elements
		for (i = 0;i < rows;i++ ) 
		{
			//Assign for the first rows from 0 to what ever the length of the word is
			lev.elements[i][0] = i;
		}

		//Initialise the first columns of elements
		for (i = 0;i < cols;i++ ) 
		{
			//Assign for the first cols from 0 to what ever the length of the second word is
			lev.elements[0][i] = i;
		}
		
		//Its minus one as the first element just holds the placeholder values
		for (i = 0;i < rows - 1;i++ )
		{
			for (j = 0;j < cols - 1;j++ ) 
			{
				//lev.elements[i + 1][0] goes down the rows. (i + 1 since 0 is first element)
				
				//if (lev.elements[i + 1][0] == lev.elements[0][j + 1]) 

				//Check if element in row string is = element in col string
				if(needle.charAt(i) == haystack.charAt(j))
				{
					//Equate to the diagonal, since algorithm makes you ;)
					lev.elements[i + 1][j + 1] = lev.elements[(i + 1) - 1][(j + 1) - 1];
					min = lev.elements[i + 1][j + 1];
				}//end if
				else
				{
					//Check the element above, to the left and diagonally to the left and return minimum no.
					min = min3(lev.elements[i][j], lev.elements[i][j + 1], lev.elements[i + 1][j]);
					//Must increment min afterwards
					min++;
					lev.elements[i + 1][j + 1] = min;
				}//end else
			}//end nested for
		}//end outer for
		min++;
		//return the last element as it has the smallest value, kept track by min
		return(min);
		//return(lev.elements(row-1, col-1));
	}
}