package com.dombi.fileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader reader;
    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List getWordsOrderedAlphabetically(){
        String content = reader.readLines();
        List<String> letters = Arrays.asList(content.split(""));
        java.util.Collections.sort(letters);
        return letters;
    }

    public List getWordsContainingSubstring(String subString){
        String content = reader.readLines();
        List<String> goodWords = new ArrayList<>();
        List<String> allWords = Arrays.asList(content.split("[\n ]"));
        for (int i = 0; i < allWords.size() ; i++) {
            if(allWords.get(i).contains(subString)){
                goodWords.add(allWords.get(i));
            }
        }
        return goodWords;

    }
    public static boolean istPalindrom(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    public List getStringsWhichPalindromes (){

        String content = reader.readLines();
        String[] allWords = content.split("[\n ]");
        List<String> goodWords = new ArrayList<>();

        for(String word : allWords){
            if(istPalindrom(word.toCharArray())){
                goodWords.add(word);
            }
        }
        return goodWords;

    }



}
