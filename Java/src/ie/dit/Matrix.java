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

    //Adds a matrix to itself
    public void add(Matrix m2)
    {
        Matrix m1 = new Matrix(this.getRows(), this.getCols());
        if(this.getRows() < rows)
        {
            rows = this.getRows();
        }
        if(this.getCols() < cols)
        {
            cols = this.getCols();
        }
        //Use for loop as know how many elements there are.
        for (int row = 0;row < rows;row++ )
        {
            for (int col = 0;col < cols;col++ )
            {
                //Adds from matrix m1 and m2 to a new matrix
                //if()
                elements[row][col] += m2.elements[row][col] + m1.elements[row][col];
                //m2.set(rows, cols, m2.elements[row][col] + m1.elements[row][col]);
            }//end inner for
        }//end outer for
    }

//    public static Matrix add(Matrix a, Matrix b)
//    {
//
//    }
}//end Matrix
