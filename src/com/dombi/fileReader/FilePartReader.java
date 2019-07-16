package com.dombi.fileReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;
    private String oneLineContent;

    public Character getEndOfLine() {
        return endOfLine;
    }

    public void setEndOfLine(Character endOfLine) {
        this.endOfLine = endOfLine;
    }

    private Character endOfLine = '\n';
    public void setup(String filePath, Integer fromLine, Integer toLine){
        if(toLine < fromLine || fromLine < 1) throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read(){
        File file = new File(filePath);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String text;
            StringBuffer builder = new StringBuffer();
            while ((text = reader.readLine()) != null){
                builder.append(text).append(endOfLine);
            }
            oneLineContent = builder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return oneLineContent; // TODO: Is this the best way?
    }

    public String readLines(){
        String text = this.read();
        List<String> content = Arrays.asList(text.split("\n"));
        StringBuilder builder = new StringBuilder();
        for (int i = fromLine -1; i < toLine ; i++) { // TODO: why od I need -1?
            builder.append(content.get(i)).append(endOfLine);
        }
        return builder.toString();
    }


}
