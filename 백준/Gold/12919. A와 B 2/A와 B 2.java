import java.util.*;
import java.io.*;

class Solution {
    Solution() {

    }

    private String removeA(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private String rotateAndRemoveB(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String S = br.readLine().strip();
        String T = br.readLine().strip();
        int len = S.length();

        Deque<String> queue = new ArrayDeque<>();
        queue.add(T);

        while (!queue.isEmpty()) {
            String curWord = queue.pollFirst();
            if (curWord.length() == len) {
                if (curWord.equals(S)) {
                    answer = 1;
                    break;
                }
            }

            if (curWord.endsWith("A")) {
                queue.add(removeA(curWord));
            }

            if (curWord.startsWith("B")) {
                queue.add(rotateAndRemoveB(curWord));
            }
        }

        System.out.println(answer);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
