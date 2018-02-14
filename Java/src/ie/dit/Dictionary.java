//package ie.dit;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Dictionary
{
	ArrayList<String> words = new ArrayList<String>();
	
	//ArrayList<String> stringWords = new ArrayList<String>();

	public Dictionary()
	{
		 loadDictionary();
	}

	public static String[] copyToArray(Dictionary w)
	{
		
		String[] wordArr = new String[w.getWords().size()];
		wordArr = w.getWords().toArray(wordArr);

		for(String s : wordArr)
    		System.out.println(s);

    	return wordArr;
	}

	public ArrayList<String> getWords()
	{
		return words;
	}

	 public void loadDictionary()
	    {

	        // Adapted from: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
	        BufferedReader inputStream = null;

	        try 
	        {
	        	//Didn't work b4 as we didn't set the path for package >>>>>>>>>>>>>.<<<<<<<<<<<<<
	            inputStream = new BufferedReader(new FileReader("words.txt"));
	            
	            String l;
	            while ((l = inputStream.readLine()) != null) 
	            {
	                words.add(l);
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            if (inputStream != null) {
	                try
	                {
	                    inputStream.close();
	                }
	                catch(Exception e)
	                {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    public String toString()
	    {
	    	StringBuffer sb = new StringBuffer();
	    	for(String word: words)
	    	{
	    		sb.append(word + ", ");
	    	}
	    	return sb.toString();
	    }
}