//package ie.dit;

public class Main
{
	public void Dictionary()
    {
        Dictionary d = new Dictionary();
        String[] wordArr = Dictionary.copyToArray(d);
        //System.out.println(d);
        System.out.printf("\n\n");

        Stringfxns strf = new Stringfxns();
        String newStr = strf.withoutEnd(wordArr[1]);
        System.out.println(newStr);

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