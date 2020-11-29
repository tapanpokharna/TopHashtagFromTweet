package twitterHandle;

import java.util.ArrayList;

public class Main {

	// the program requires an arraylist of tweets. Keeping the above comments for you to test the program.
	// NOTE : program considers that '#' is also a tweet and will have a empty entry in the output for it.
	// This is one corner case and I was not sure of the expected output here.
	public static void main(String[] args) {
		/*
		String Tweetdata1 = " # # # # Worlds greatest Crickter is #ratlam #Sachin #ratlam #Sachin #micromax #Sachin #one #Sachin #tapan #Sachin #tapan #Sachin #1 #2 #3 #4 #5 #5 #1 ";
		String Tweetdata2 = " # # # # Worlds greatest Crickter is #ratlam #Sachin #ratlam #Sachin #ratlam #Sachin #tapan #Sachin #tapan #Sachin #tapan #Sachin #1 #2 #3 #4 #5 #5  ";
		String Tweetdata3 = " # # # # Worlds greatest Crickter is #ratlam #Sachin #ratlam #Sachin #vinay #Sachin #tapan #Sachin #tapan #Sachin #tapan #Sachin #1 #2 #3 #4 #5   ";
		String Tweetdata4 = " # # # # Worlds greatest Crickter is #ratlam #valid #valid #micromax #lalita #Sachin #lalita #lalita #lalita #lalita #lalita #lalita #1 #2 #3 #4";
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
		TweetAnalyzer.inputTweets(tweets);
		ArrayList<String> topTweets = TweetAnalyzer.getTopHashtags();
		for(String word : topTweets) {
			System.out.println(word);
		}
	}
}