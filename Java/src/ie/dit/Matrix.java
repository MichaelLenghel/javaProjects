package ie.dit;

//What public means is it can be used outside of the package
public class Matrix {
    //Make them private on the inside so only this class can use it
    private int rows;
    private int cols;

    //Private ensures only accessible by this class
    private float[][] elements;

    //Accessor
    private int getRows()
    {
        return rows;
    }//end getRows

    private int getCols()
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
    Matrix(int rows, int cols)
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
        StringBuilder ret = new StringBuilder();
        //Use for loop as know how many elements there are.
        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                //If row and col are the same, set the value to be 1, otherwise 0
                ret.append(elements[row][col]).append("\t");
            }//end inner for
            ret.append("\n");
        }//end outer for
        return ret.toString();
    }//end toString

    //Bug occures when two matrices are not of the same size!
    public void add(Matrix m1)
    {
        //Checks of rows and cols are equal
//        if(elements.length != m1.elements.length || elements[0].length != m1.elements[0].length)
//        {
//            System.out.println("The matrices do not have the same number of rows and cols.");
//        }//end if

        if(( getRows() != m1.getRows() ) || ( getCols() != m1.getCols() ))
        {
            System.out.println("Matrices must have the same number of rows");
            System.exit(0);
        }

        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                //Since m2 is this class, all we need to do is specify m1 for the other matrix passed
                //i.e. -> m2 = m2 + m1 is the operation we are currently doing
               elements[row][col] = elements[row][col] + m1.elements[row][col];
            }//end inner for
        }//end outer for

    }

    //Public by default so removed keyword
    static Matrix Add(Matrix a, Matrix b)
    {
//        //Check if rows and cols are equal
//        int rows = a.elements.length;
//        int cols = a.elements[0].length;
//        if(a.elements.length != b.elements.length || a.elements[0].length != b.elements[0].length)
//        {
//            System.out.println("The matrices do not have the same number of rows and cols.");
//        }//end if
        //Create the new variable which holds the sum of the two matrices
        int rows = a.getRows();
        int cols = a.getCols();
        //Check and make sure that have same no. of cols and rows for addition
        if(( a.getRows() != b.getRows() ) || ( a.getCols() != b.getCols() ))
        {
            System.out.println("Matrices must have the same number of rows");
            System.exit(0);
        }

        Matrix ans = new Matrix(rows, cols);

        for (int row = 0;row < rows ;row++ )
        {
            for (int col = 0;col < cols ;col++ )
            {
                //Since m2 is this class, all we need to do is specify m1 for the other matrix passed
                //i.e. -> m2 = m2 + m1 is the operation we are currently doing
                ans.elements[row][col] = a.elements[row][col] + b.elements[row][col];
            }//end inner for
        }//end outer for

        return ans;
    }

    static Matrix Mult(Matrix a, Matrix b)
    {
        int rows, cols;
        //Don't need to assign separately as in multipling same no. of rows as cols
        rows = cols = a.getRows();
        Matrix ans = new Matrix(rows, cols);
        if(a.getRows() != b.getRows() || a.getCols() != b.getCols())
        {
            System.out.println("Rows and cols must be the same for matrix multiplication");
            System.exit(0);
        }

        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                //In mult rows must be the same as columns
                for(int i = 0; i < rows; i++)
                {
                    ans.elements[row][i] += a.elements[row][i] * b.elements[i][col];
                }
            }
        }
        return ans;
    }
}//end Matrix
