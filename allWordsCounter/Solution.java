package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

//        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        Map<Character, Integer> treeMap = new LinkedHashMap<>();
        for (Character character : alphabet) {
            treeMap.put(character, 0);
        }


        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            for (String str : list) {
                String[] arr = str.split("");
                for (int i = 0; i < arr.length; i++) {
                    if (String.valueOf(entry.getKey()).equals(arr[i])) {
                        entry.setValue(entry.getValue() + 1);
                    }
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
