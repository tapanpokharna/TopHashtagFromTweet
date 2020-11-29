package twitterHandle;

import java.util.ArrayList;
import java.util.StringTokenizer;
// This class has one method which will take a String as Input and return 
// all the hashtag's found in that String. 

// Assumption: One tweet(String) can have multiple hashtags. Hence, return
// type is an ArrayList of Strings
public class Utils {

	public static ArrayList<String> findAllHashtagInATweet(String tweet){
		ArrayList<String> tags = new ArrayList<String>();
		StringTokenizer st= new StringTokenizer(tweet); // breaking String to components
		// this will check if all the words of input string were checked
		while(st.hasMoreTokens()) {  
			String temp = st.nextToken();
			if(temp.charAt(0) == '#') {
				tags.add(temp.substring(1,temp.length()));
			}
		}
		return tags;
	}
}
