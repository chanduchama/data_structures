package com.implementation.interviews.workfusion;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NonRepeatingChar {

    public static void main(String[] args) {
        NonRepeatingChar prob = new NonRepeatingChar();
        Map<String, Integer> charMap = prob.getCharCount("ssata");
        Set<String> keys = charMap.keySet();
        for(String key : keys) {
            if(charMap.get(key) == 1) {
                System.out.println("First non repeating character is :" + key);
                break;
            }
        }
    }

    public Map<String, Integer> getCharCount(String inputString) {
        Map<String, Integer> charCount = new LinkedHashMap<String, Integer>();

        char[] charArray = inputString.toCharArray();
        for(char c : charArray) {
            String charKey = c+"";
            if(charCount.containsKey(charKey)) {
                int count = charCount.get(charKey);
                count++;
                charCount.put(charKey,count);
            } else {
                charCount.put(charKey,1);
            }
        }

        return charCount;
    }

}
