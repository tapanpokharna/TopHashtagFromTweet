package twitterHandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class TweetContainer {
	
	Map<String, Integer> mapOfHashtag;  // here we will maintain Hashtag along with the count of occurance. 
	
	// Constructor for the class
	public TweetContainer() {
		mapOfHashtag = new HashMap<String,Integer>();
	}
	
	// method takes a hashtag and inserts it in the container. It also updates the top tweets array.
	public void addToContainer(ArrayList<String> hashtags) {
		for(String hashtag : hashtags) {
			int count =0;  // a variable which will keep track of occurrence of any hashtag
			if(mapOfHashtag.containsKey(hashtag)) {
				count = mapOfHashtag.get(hashtag)+1;
			}else {
				count =1;
			}
			// now we have the number of occurrence of current hashtag 
			//adding/updating the hashmap
			mapOfHashtag.put(hashtag,count);			
		}
	}
	
	// this takes the top tweets and send in a List 
	public ArrayList<String> getTopHashtags(int n){
		ArrayList<String> ans = new ArrayList<String>(); // final value's to be returned
		
		// taking the hashmap and putting it inside an array to sort based on count & lexicographically 
	    ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(mapOfHashtag.entrySet());
	    Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
	        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
	            if (b.getValue().equals(a.getValue()))
	                return a.getKey().compareTo(b.getKey());
	            else
	                return b.getValue().compareTo(a.getValue());
	        }
	    });
	    int i =0;
	    for (Map.Entry<String, Integer> entry : entries) {
	        ans.add(entry.getKey());
	        i++;
	        if(i ==n) break;
	    }
		return ans;
	}
}
