import java.util.*;
import java.io.*;

class Solution {
    Comparator<String> comparator = new Comparator<>() {
        @Override
        public int compare(String s1, String s2) {
            int num1 = Integer.parseInt(s1 + s2);
            int num2 = Integer.parseInt(s2 + s1);
            return num2 - num1;
        }
    };

    public String solution(int[] numbers) {
        String answer = "";

        Arrays.sort(numbers);

        ArrayList<String> numberList = new ArrayList<>();

        for (int number : numbers) {
            numberList.add(Integer.toString(number));
        }
        
        Collections.sort(numberList, comparator);
        
        if (numberList.get(0).equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : numberList) {
            sb.append(s);
        }

        return sb.toString();
    }
}