package ie.dit;

import static ie.dit.Matrix.Add;
import static ie.dit.Matrix.Mult;

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
        System.out.println("\n" + m2.getElement(2, 1));
        System.out.println("\n" + m2);

        //First add function
//        m2.add(m1);
//        System.out.println(m2);

        //Second add funciton
        Matrix m3 = new Matrix(3, 3);
//        m3 = Add(m1, m2);
//        System.out.println(m3);

        m3 = Mult(m1, m2);
        System.out.println("\n" + m3);
    }
}