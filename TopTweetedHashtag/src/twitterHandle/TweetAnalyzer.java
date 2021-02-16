package twitterHandle;

import java.util.ArrayList;

// this class has 2 responsibilities, either it will input tweets or it will get the top 10 tweets.
//Assumption : inputTweets method will be called when all the tweets data is collected by Main program
public class TweetAnalyzer {
	TweetContainer tweetContainer;
	public TweetAnalyzer() {
		tweetContainer = new TweetContainer();
	}
	
	public void inputTweets(ArrayList<String> tweets) {	
		for(String tweet: tweets) {
			tweetContainer.addToContainer(Utils.findAllHashtagInATweet(tweet));
		}		
	}
	
	// return the top hashtags
	public ArrayList<String> getTopHashtags(int n) {
		return tweetContainer.getTopHashtags(n);
	}
}