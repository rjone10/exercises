package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/
//D:\java\1.txt
public class Solution {
    public static void main(String[] args) throws IOException {
        String[] strings = new String[0];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            while (reader.ready()) {
                strings = reader.readLine().split(" ");
            }
        }
        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder res = new StringBuilder();
        if (words.length == 0) {
            return new StringBuilder("");
        }
        List<String> allWords = new LinkedList<>(Arrays.asList(words));
        int counter = 0;
        while (true) {
            Collections.shuffle(allWords);
            for (int i = 0; i < allWords.size() - 1; i++) {
                String firstCity = allWords.get(i).substring(allWords.get(i).length() - 1);
                String secondCity = allWords.get(i + 1).substring(0, 1);
                if (firstCity.equalsIgnoreCase(secondCity)) {
                    counter++;
                }
            }
            if (counter + 1 == allWords.size()) {
                break;
            } else {
                counter = 0;
            }
        }
        for (String string : allWords) {
            res.append(string).append(" ");
        }
        String s = res.toString().trim();

        return new StringBuilder(s);
    }
}

