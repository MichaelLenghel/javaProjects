package ie.dit;

import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
//import java.util.*;

public class Dictionary
{
	ArrayList<String> words = new ArrayList<String>();

	public Dictionary()
	{
		loadDictionary();
	}//emd Dictionary

    public void loadDictionary()
    {

        // Adapted from: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
        BufferedReader inputStream = null;

        try 
        {
        	//Didn't work b4 as we didn't set the path for package >>>>>>>>>>>>>.<<<<<<<<<<<<<
            inputStream = new BufferedReader(new FileReader("ie/dit/words.txt"));
            
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

    public String findClosest(String word)
    {
    	//Set at highest possible value to start
        float closestEd = Float.MAX_VALUE;
        //Initialise as empty
        String closestWord = ""; 

        for(String w:words)
        {
        	//Finds closest word to it
            float ed = EditDistance.MinimumEditDistance(word, w);
            //If distance is 0, then thats the word
            if (ed == 0)
            {
                return word;
            }
            //assign closest ed and word everytime distance is less
            if (ed < closestEd)
            {
                closestEd = ed;
                closestWord = w;
            }
        }
        //return word itself if no other word is found
        return closestWord;
    }

	public String toString()
	{
		//Create the buffer which will hold the words
		StringBuffer sb = new StringBuffer();
		for (String word:words) 
		{
			sb.append(word + ", ");
		}
		return sb.toString();
	}
}
