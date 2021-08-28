package Challange5;

import java.util.HashMap;
import java.util.Map;


public class FindLongestPalindromicString{
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
        char[] characters = s.toCharArray();
        Map<Character,Element> characterAndLongestStubstringSize = new HashMap<>();
        Element currentElement = new Element();
        for(int i = 0; i < characters.length; i++ ){
            if(characterAndLongestStubstringSize.containsKey(characters[i])){
                currentElement = characterAndLongestStubstringSize.get(characters[i]);
               if(currentElement.longestPalindrome.length() < i - currentElement.index +1){
                    currentElement.longestPalindrome= s.substring(currentElement.index, i+1);
                    currentElement.index = i;
                    characterAndLongestStubstringSize.put(characters[i],currentElement);
                }
            }else{
                characterAndLongestStubstringSize.put(characters[i], new Element(i,String.valueOf(characters[i])));
            }
        } 
        return characterAndLongestStubstringSize.values().stream()
                    .sorted((e1,e2)-> e1.longestPalindrome.length() - e2.longestPalindrome.length()).filter((element) ->{
                        if(element.longestPalindrome.length() <= 1){
                            return true;
                        }
                        if(element.longestPalindrome.length()%2 != 0){
                            return element.longestPalindrome.substring(0,element.longestPalindrome.length()/2)
                            .equals(element.longestPalindrome.substring(element.longestPalindrome.length()/2-1));
                        }else{
                            return element.longestPalindrome.substring(1,element.longestPalindrome.length()/2)
                            .equals(element.longestPalindrome.substring(element.longestPalindrome.length()/2));
                        }
                    }).findFirst().orElse(null).longestPalindrome;
    }
}
class Element{
    int index;
    List<String> longestPalindrome;
    Element(int index,String longestPolindrome){
        this.index = index;
        this.longestPalindrome = longestPolindrome;
    }
    Element(){}
}

/*
    babad
    1. b -> map +1 element = [b,0]
    2.a -> map +1 element =[{b,0},{a,0}s]
*/
