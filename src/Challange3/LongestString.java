package Challange3;

import java.util.HashMap;
import java.util.Map;

/*
 * Longest Substring Without Repeating Characters
 * 		Given:
 * 			s of type String
 *		Result 
 *			finding longest string without any repeating chars
 *		Example:
 *			s = "abcabcbb"
 *			answer: 3 (abc)
 * 		Solution:
 * 		declare first element index;
 * 		declare set of chars
 * 		declare map : key -> index, value -> length
 * 			abcabcbb
 * 			1. a -> Add a : [a]  index = 0 , 
 * 			2. ab -> Add b : [a,b] index = 0
 * 			3. abc -> Add c : [a,b,c]
 * 			4. abca -> Can not add c [a,b,c], put index[set.length], set.empty
 * 		
 * */
public class LongestString {
	public static void main(String[] args) {
		String answer1 = "abcabcbb";
		String answer2 = "tmmzuxt";
		String answer3 = "pwwkew";
		String answer4 = "aab";
		String answer5 = "wobgrovw";
		String answer6 = "dvdf";
		String answer7 = "zwnigfunjwz";
		System.out.println("abcabcbb (3)-> " + (new LongestString()).lengthOfLongestSubstring(answer1));
		System.out.println("tmmzuxt (5) -> " + (new LongestString()).lengthOfLongestSubstring(answer2));
		System.out.println("pwwkew (3)-> " + (new LongestString()).lengthOfLongestSubstring(answer3));
		System.out.println("aab (2)-> " + (new LongestString()).lengthOfLongestSubstring(answer4));
		System.out.println("wobgrovw (6)-> " + (new LongestString()).lengthOfLongestSubstring(answer5));
		System.out.println("dvdf (3)-> " + (new LongestString()).lengthOfLongestSubstring(answer6));
		System.out.println("zwnigfunjwz (8)-> " + (new LongestString()).lengthOfLongestSubstring(answer7));
	}

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> distinctCharWithIndex = new HashMap<Character, Integer>();
		int maxLength = 0;
		char currentElement;
		int currentMaxLength = 0;
		int lastUpdatedIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			currentElement = s.charAt(i);
			if (!distinctCharWithIndex.containsKey(currentElement)) {
				++currentMaxLength;
				distinctCharWithIndex.put(currentElement, i);
			} else {
					currentMaxLength = 
							lastUpdatedIndex > distinctCharWithIndex.get(currentElement) ? i - lastUpdatedIndex
									: i - distinctCharWithIndex.get(currentElement);	
				if(lastUpdatedIndex < distinctCharWithIndex.get(currentElement)) {
					lastUpdatedIndex = distinctCharWithIndex.get(currentElement);
				}
				distinctCharWithIndex.put(currentElement,i);
			}
		
			if (currentMaxLength > maxLength) {
				maxLength = currentMaxLength;
			}
			
		}
		
		return maxLength;
	}
}
