package twitterHandle;

import java.util.ArrayList;

public class Main {

	// the program requires an arraylist of tweets. Keeping the above comments for you to test the program.
	// NOTE : program considers that '#' is also a tweet and will have a empty entry in the output for it.
	// This is one corner case and I was not sure of the expected output here.
	public static void main(String[] args) {
		/*
		String Tweetdata1 = " # # # # # #a #A #a #Worlds greatest Crickter is #name1 #Sachin #name2 #Sachin #name2 #Sachin #name2 #Sachin #name3 #Sachin #name23 #Sachin #1 #2 #3 #4 #5 #5 #1 ";
		String Tweetdata2 = " #a #A #a #Worlds greatest Crickter is #name1 #Sachin #name2 #Sachin #name2 #Sachin #name2 #Sachin #name3 #Sachin #name3 #Sachin #1 #2 #3 #4 #5 #5 #1";
		String Tweetdata3 = " #a #A #A #Worlds greatest Crickter is #name1 #Sachin #name2 #Sachin #name2 #Sachin #name2 #Sachin #name3 #Sachin #name3 #Sachin #1 #2 #3 #4 #5 #5 #1";
		String Tweetdata4 = " #a #A #A #Worlds greatest Crickter is #name1 #Sachin #name2 #Sachin #name2 #Sachin #name2 #Sachin #name4 #Sachin #name3 #Sachin #1 #2 #3 #4 #5 #5";
		*/
		ArrayList<String> tweets = new ArrayList<String>();
		/*
		tweets.add(Tweetdata1);
		tweets.add(Tweetdata2);
		tweets.add(Tweetdata3);
		tweets.add(Tweetdata4);	
		*/

		if(tweets.isEmpty()) {
			System.out.println(" Empty Input\n This comment has been added intentionally");
			return;
		}
		TweetAnalyzer ta = new TweetAnalyzer();
		ta.inputTweets(tweets);
		ArrayList<String> topTweets = ta.getTopHashtags(10);
		for(String word : topTweets) {
			System.out.println(word);
		}
	}
}