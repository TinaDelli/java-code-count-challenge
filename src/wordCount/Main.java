package wordCount;

import java.util.*;
import java.util.regex.Pattern;


public class Main {
    
public static void main(String[] args)throws Exception{
    
    String passageTxt = new Passage().getThePassage();
    passageTxt = passageTxt.replaceAll("[[\\\"\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");

    String[] words = passageTxt.split(" +");
    System.out.println("There are " + words.length + " words in total");

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String word:words)
        {
            if (!map.containsKey(word))
            {
                map.put(word, 1);
            }
            else
            {
                map.put(word, map.get(word) + 1);
            }
        }
       
        ArrayList<HashMap.Entry<String, Integer>> sortedMap = new ArrayList<HashMap.Entry<String, Integer>>();
        sortedMap.addAll(map.entrySet());
        sortedMap.sort((o1, o2) -> o2.getValue() - o1.getValue());
        System.out.println("\nThe Top 10 Words Are:");
        for (int i = 0; i < 10 ; i++)
        {
            System.out.println("Common Word #" + (i+ 1) +  " (" + sortedMap.get(i).getKey() + ") occurs " + sortedMap.get(i).getValue() + " times");
        }
        String mostCommonWord = sortedMap.get(0).getKey();
        String passageSent = new Passage().getThePassage();
        passageSent.substring(passageSent.lastIndexOf("\n"));
        String[] sentences = passageSent.split("\\.");
        ArrayList<String> theSentences = new ArrayList<String>();
        for(String s: sentences)
        if(s.contains(mostCommonWord))
        {
            theSentences.add(new String(s + "\n"));
        }
        System.out.println("\nThe last sentence containing the most common word is:" + theSentences.get(theSentences.size() -1));


}

}