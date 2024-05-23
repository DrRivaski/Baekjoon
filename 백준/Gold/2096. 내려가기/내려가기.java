import java.util.*;
import java.io.*;

class Solution {
    Solution() {

    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());
        String[] startInput = br.readLine().strip().split(" ");
        int[] start = new int[3];
        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(startInput[i]);
        }

        int[] left = new int[2];
        int[] middle = new int[2];
        int[] right = new int[2];
        
        left[0] = start[0];
        left[1] = start[0];
        right[0] = start[2];
        right[1] = start[2];
        middle[0] = start[1];
        middle[1] = start[1];
        int[] next = new int[3];

        for (int i = 1; i < n; i++) {
            int tmpLeftMin = Math.min(left[0], middle[0]);
            int tmpLeftMax = Math.max(left[1], middle[1]);
            int tmpRightMin = Math.min(middle[0], right[0]);
            int tmpRightMax = Math.max(middle[1], right[1]);
            int tmpMiddleMin = Math.min(Math.min(left[0], right[0]), middle[0]);
            int tmpMiddleMax = Math.max(Math.max(left[1], right[1]), middle[1]);
            String[] nextInput = br.readLine().strip().split(" ");
            for (int j = 0; j < 3; j++) {
                next[j] = Integer.parseInt(nextInput[j]);
            }
            left[0] = tmpLeftMin + next[0];
            left[1] = tmpLeftMax + next[0];
            middle[0] = tmpMiddleMin + next[1];
            middle[1] = tmpMiddleMax + next[1];
            right[0] = tmpRightMin + next[2];
            right[1] = tmpRightMax + next[2];
        }
        System.out.println(Math.max(Math.max(left[1], right[1]), middle[1]) + " " + Math.min(Math.min(left[0], right[0]), middle[0]));
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
