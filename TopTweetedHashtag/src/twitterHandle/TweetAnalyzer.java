package twitterHandle;

import java.util.ArrayList;

// this class has 2 responsibilities, either it will input tweets or it will get the top 10 tweets.
//Assumption : inputTweets method will be called when all the tweets data is collected by Main program
public class TweetAnalyzer {
	static TweetContainer tweetContainer = new TweetContainer();
	
	public static void inputTweets(ArrayList<String> tweets) {	
		for(String tweet: tweets) {
			tweetContainer.addToContainer(Utils.findAllHashtagInATweet(tweet));
		}		
	}
	
	// return the top hashtags
	public static ArrayList<String> getTopHashtags() {
		return tweetContainer.getTopHashtags();
	}
}