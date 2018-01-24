package ie.dit;

//What public means is it can be used outside of the package
public class Matrix {
    //Make them private on the inside so only this class can use it
    private int rows;
    private int cols;

    //Private ensures only accessible by this class
    private float[][] elements;

    //Accessor
    public int getRows()
    {
        return rows;
    }//end getRows

    public int getCols()
    {
        return cols;
    }//end getRows

    //Setter
    public void setElement(int row, int col, float val)
    {
        //Exception handling would be good here
        elements[row][col] = val;
    }//end setElement

    public float getElement(int row, int col)
    {
        //Bounds checking here as well
        return elements[row][col];
    }//end getElement

    //Constructor
    public Matrix(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        elements = new float[rows][cols];
    }//end Matrix

    public void identity()
    {
        //Use for loop as know how many elements there are.
        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                //Assigning 1 to all diaganals and 0 to all other elemeents
                //If row and col are the same, set the value to be 1, otherwise 0
                elements[row][col] = (row == col) ? 1 : 0;
            }//end inner for
        }//end outer for
    }//end identity

    public String toString()
    {
        String ret = "";
        //Use for loop as know how many elements there are.
        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                //If row and col are the same, set the value to be 1, otherwise 0
                ret += elements[row][col] + "\t";
            }//end inner for
            ret += "\n";
        }//end outer for
        return ret;
    }//end toString

    //Will need to add an error check to ensure that matrices are of the same size
    public void add(Matrix m1)
    {
        //Use for loop as know how many elements there are.
        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                elements[row][col] = elements[row][col] + m1.elements[row][col];
            }//end inner for
        }//end outer for
    }

    public static Matrix MatrixAdd(Matrix a, Matrix b)
    {
        int rows, cols;
        //Hard coded values for rows and cols as since a static class, cannot access the instances outside of it
        rows = cols = 3;

        Matrix ans = new Matrix(3, 3);
        //Use for loop as know how many elements there are.
        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                ans.elements[row][col] = a.elements[row][col] + b.elements[row][col];
            }//end inner for
        }//end outer for

        return ans;
    }
}//end Matrix
