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

    private String removeBAndRotate(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 2; i > -1; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().strip();
        String T = br.readLine().strip();
        int len = S.length();
        int answer = 0;

        String curWord = T;

        while (curWord.length() > len) {
            if (curWord.charAt(curWord.length() - 1) == 'A') {
                curWord = removeA(curWord);
            } else {
                curWord = removeBAndRotate(curWord);
            }
        }

        if (curWord.equals(S)) {
            answer = 1;
        } else {
            answer = 0;
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
