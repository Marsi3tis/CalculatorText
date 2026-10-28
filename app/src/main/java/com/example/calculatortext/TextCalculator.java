package com.example.calculatortext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {
    public int countSentences(String text){
        String[] sentences = text.split("\\.");
        int count = 0;

        for (String sentence : sentences){
            if(!sentence.trim().isEmpty()){
                count++;
            }
        }
        return count;
    }
    public int countWords(String text){
        Pattern pattern = Pattern.compile("\\p{L}+");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while(matcher.find()){
            count++;
        }

        return count;
    }
    public int countPunctuation(String text){
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            char character = text.charAt(i);

            if (character == ' ' || character == ',' ||
                    character == '.' || character == '!' ||
                    character == '?' || character == ':' ||
                    character == ';') {
                count++;
            }
        }
        return count;
    }
    public int countNumbers(String text){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        return count;
    }

}
