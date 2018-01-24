package ie.dit;

import static ie.dit.Matrix.MatrixAdd;

public class Main
{
    public static void main(String[] args)
    {
        Matrix m1 = new Matrix(3, 3);
        m1.identity();
        System.out.println(m1);

        Matrix m2 = new Matrix(3, 3);
        m2.setElement(2, 1, 100);
        m2.setElement(1, 1, 8);
        System.out.println(m2.getElement(2, 1));
        System.out.println(m2);

        // m2.add(m1);
        // System.out.println(m2);

        Matrix m3 = new Matrix(3, 3);

        m3 = MatrixAdd(m1, m2);
        System.out.println(m3);


    }
}