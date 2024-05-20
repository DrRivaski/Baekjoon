import java.util.*;
import java.io.*;

class Solution {
    ArrayList<String> answerList = new ArrayList<>();

    Solution() {

    }

    int calculateString(String[] s, int target) {
        ArrayList<String> numList = new ArrayList<>();
        ArrayList<String> opList = new ArrayList<>();
        String curNum = "1";
        for (int i = 0; i < target - 1; i++) {
            int curIndex = i * 2 + 1;
            String curOp = s[curIndex];
            if (curOp.equals(" ")) {
                curNum += s[curIndex + 1];
            } else {
                numList.add(curNum);
                opList.add(curOp);
                curNum = s[curIndex + 1];
            }
        }
        numList.add(curNum);
        int result = Integer.parseInt(numList.get(0));
        for (int i = 0; i < opList.size(); i++) {
            String curOp = opList.get(i);
            int nextNum = Integer.parseInt(numList.get(i + 1));
            if (curOp.equals("+")) {
                result += nextNum;
            } else {
                result -= nextNum;
            }
        }
        return result;
    }

    String[] makeArray(int target) {
        String[] returnValue = new String[target * 2 - 1];
        for (int i = 0; i < target; i++) {
            returnValue[i * 2] = Integer.toString(i + 1);
        }
        for (int i = 0; i < target - 1; i++) {
            returnValue[i * 2 + 1] = " ";
        }
        return returnValue;
    }

    String makeString(String[] s) {
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        return sb.toString();
    }

    void recursive(String[] s, int depth, int target) {
        if (depth == target - 1) {
            if (calculateString(s, target) == 0) {
                answerList.add(makeString(s));
            }
        } else {
            String[] s1 = new String[target * 2 - 1];
            String[] s2 = new String[target * 2 - 1];
            for (int i = 0; i < s.length; i++) {
                s1[i] = s[i];
                s2[i] = s[i];
            }
            s1[depth * 2 + 1] = "+";
            s2[depth * 2 + 1] = "-";
            recursive(s, depth + 1, target); // " "
            recursive(s1, depth + 1, target); // "+" 추가
            recursive(s2, depth + 1, target); // "-" 추가
        }
    }

    void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (String s : answerList) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }

    void sol(int target) {
        String[] s = makeArray(target);
        recursive(s, 0, target);
        printAnswer();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        for (int i = 0; i < n; i++) {
            answerList.clear();
            int target = Integer.parseInt(br.readLine().strip());
            sol(target);
            //System.out.println("");
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
