import java.io.*;
import java.util.*;

class Solution {
    Solution() {

    }

    Comparator<Guitar> comparator = new Comparator<Guitar>() {
        @Override
        public int compare(Guitar o1, Guitar o2) {
            if (o1.length == o2.length) {
                if (o1.calculate() == o2.calculate()) {
                    return o1.serialNumber.compareTo(o2.serialNumber);
                } else {
                    return o1.value - o2.value;
                }
            } else {
                return o1.length - o2.length;
            }
        }
    };

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        ArrayList<Guitar> answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String serialNumber = br.readLine().strip();
            answerList.add(new Guitar(serialNumber));
        }

        Collections.sort(answerList, comparator);
        StringBuilder sb = new StringBuilder();
        for (Guitar g : answerList) {
            sb.append(g.serialNumber).append("\n");
        }
        System.out.println(sb.toString());
    }
}

class Guitar {
    String serialNumber;
    int length;
    int value = 0;

    Guitar(String serialNumber) {
        this.serialNumber = serialNumber;
        length = serialNumber.length();
        value = calculate();
    }

    public int calculate() {
        int result = 0;
        for (int i = 0; i < length; i++) {
            char curChar = serialNumber.charAt(i);
            if (curChar >= 'A' && curChar <= 'Z') {
                continue;
            } else {
                result += curChar - '0';
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
