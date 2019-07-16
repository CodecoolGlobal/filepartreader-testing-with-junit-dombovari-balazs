package com.dombi.fileReader;

public class Main {
    public static void main(String[] args) {
        FilePartReader reader = new FilePartReader();
        reader.setup("example", 2,4);
        String example = reader.read();
        String example2 = reader.readLines();
        System.out.println(example);
        System.out.println(example2);

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        System.out.println(analyzer.getWordsOrderedAlphabetically());

        System.out.println(analyzer.getWordsContainingSubstring("in"));

        System.out.println(analyzer.getStringsWhichPalindromes());

    }
}
