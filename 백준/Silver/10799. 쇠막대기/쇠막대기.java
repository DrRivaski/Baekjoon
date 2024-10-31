import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}

class Solution {
    Solution() {

    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().strip();

        Deque<Character> stack = new ArrayDeque<>();
        char prev = '(';
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);

            if (curChar == '(') {
                stack.add(curChar);
            } else {
                stack.pollLast();

                if (curChar != prev) {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
            prev = curChar;
        }

        System.out.println(answer);
    }
}