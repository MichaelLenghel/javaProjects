package ie.dit;

public class stringFunctions
{
	public static void main(String[] args)
	{
		String test = "I wandered lonely as a cloud";

		System.out.println(test.startsWith("I w"));
		System.out.println(test.indexOf("lonely"));
		System.out.println(test.lastIndexOf("a"));

		//Up to 10 charcters
		System.out.println(test.indexOf("a",10));

		System.out.println(test.equals("hello"));

		System.out.println(test.toUpperCase());

		
		System.out.println(test.substring(2));

		//Want word wandered (end index -1):
		System.out.println(test.subString(2, 10));

		System.out.println(test.string.replace(2, 10));
	}
}