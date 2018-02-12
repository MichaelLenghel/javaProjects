package ie.dit;

public class Main
{
    public void matrixMult()
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
        //m2.add(m1);
        //System.out.println(m2);

        //Second add funciton
        Matrix m3 = new Matrix(3, 3);
        m3 = Matrix.Add(m1, m2);
        System.out.println(m3);

        m3 = Matrix.Mult(m1, m2);
        System.out.println("\n" + m3);
        System.out.println("\n\n\n");
    }

    public void editDistance()
    {
        String sa = "I love DIT";
        String sb = "I love Tunepal";

        //int addToMakeWorkOffBy1 = 1;

        System.out.println("Min distance between " + sa + " and " + sb + " is " + EditDistance.MinimumEditDistance(sa, sb));

        sa = "Games Fleadh";
        sb = "Imagine Cup";
        System.out.println("Min distance between " + sa + " and " + sb + " is " + EditDistance.MinimumEditDistance(sa, sb));
    }

    public void Strings()
    {
        String s = "I love star Trek";
        System.out.println(s.length());
        System.out.println(s.contains("I love"));
        System.out.println(s.startsWith("I love"));
        System.out.println(s.endsWith("I love"));
        System.out.println(s.equals("I love"));

        //ss going to be equal to star Trek
        String ss = s.substring(7);

        System.out.println(ss);
        //Correct way to compare strings: (Added IgnoreCase as well)
        if (ss.equalsIgnoreCase("Star Trek"))
        {
            System.out.println("Same");    
        }
        else
        {

            System.out.println("Different");
        }
        //Tells it to stop at the fifth paramater
        String star = ss.substring(0, 5);
        //Puts to caps
        System.out.println(star.toUpperCase());
    }

    public void Dictionary()
    {
        Dictionary d = new Dictionary();
        System.out.println(d);
        System.out.println(d.findClosest("bread"));
        System.out.println(d.findClosest("militarry"));
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        //main.matrixMult();
        //main.editDistance();
        //main.Strings();
        main.Dictionary();
    }
}