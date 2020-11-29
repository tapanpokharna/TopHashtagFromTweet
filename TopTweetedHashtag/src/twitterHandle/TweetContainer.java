package twitterHandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TweetContainer {
	
	Map<String,Long> mapOfHashtag;  // here we will maintain Hashtag along with the count of occurance. 
	//this will store all value of Hashtag.
	ArrayList<Node> topHashtagArray;// array only for the top values
	
	// node added to sort the fields and store as a String and value pair
	class Node{
		long val;
		String word;
		public Node(long val, String word) {
			this.val=val;
			this.word=word;
		}
	}
	
	// Constructor for the class
	public TweetContainer() {
		mapOfHashtag = new HashMap<String,Long>();
		topHashtagArray = new ArrayList<Node>();
	}
	
	// method takes a hashtag and inserts it in the container. It also updates the top tweets array.
	public void addToContainer(ArrayList<String> hashtags) {
		for(String hashtag : hashtags) {
			long count =0;  // a variable which will keep track of occurrence of any hashtag
			if(mapOfHashtag.containsKey(hashtag)) {
				count = mapOfHashtag.get(hashtag)+1;
			}else {
				count =1;
			}
			
			// now we have the number of occurrence of current hashtag 
			
			//adding/updating the hashmap
			mapOfHashtag.put(hashtag,count);			
			
			// if the number of occurrence of current hashtag is less than that of top10, stop processing
			if (topHashtagArray.size() == 11 && count < topHashtagArray.get(topHashtagArray.size()-1).val) {
				continue;
			}
			// we will come here only when the topHashtagArray has to be modified.
			updateTopHashtagArray(hashtag, count); // function to update topHashtagArray
			
			//after updating the topHashtagArray, we need to sort it
			//sorting has priority to counts and if counts of a hashtag are same, then
			//lexicographical order
			Collections.sort(topHashtagArray, new Comparator<Node>(){
			     public int compare(Node o1, Node o2){
			         if(o1.val - o2.val == 0) {
			             return o1.word.compareTo(o2.word);
			         }
			         return (int) (o2.val - o1.val);
			     }
			});
		}
	}
	
	//Method to add and update the topHashtagArray
	private void updateTopHashtagArray(String hashtag, Long count) {
		for(int i =0; i < topHashtagArray.size()-1; i++) {
			Node n1 = topHashtagArray.get(i);
			if (n1.word.equals(hashtag)) {
				n1.val = count;
				topHashtagArray.set(i,n1);
				return;
			}
		}
		// if the array does not have 11 elements, we need to directly add the new hashtag
		// else we will check the count of the lowest hashtag in array and compare with the current hashtag
		// we are storing one extra value to ensure we do not lose any potential hashtag which has same count
		// but comes later. this can also be handled by an if condition and a specific check.
		if(topHashtagArray.size() < 11) {
			topHashtagArray.add(new Node (count,hashtag));			
		} else {
			topHashtagArray.set(topHashtagArray.size()-1,new Node (count,hashtag));			
		}
	}
	
	// this takes the top tweets and send in a List 
	public ArrayList<String> getTopHashtags(){
		ArrayList<String> ans = new ArrayList<String>();
		for(int i =0; i <10; i++) {
			Node n1 = topHashtagArray.get(i);
			ans.add(n1.word);
		}
		return ans;
	}
}
