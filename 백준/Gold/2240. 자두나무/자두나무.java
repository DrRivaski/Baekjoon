import java.util.*;
import java.io.*;

class Solution {
    Solution() {

    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        int t, w;
        t = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        int[][] dp = new int[t + 1][w + 1];
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < t + 1; i++) {
            int wood = Integer.parseInt(br.readLine().strip());

            for (int j = 0; j < w + 1; j++) {
                if (j == 0) {
                    if (wood % 2 == 1) { // 1번 나무
                        dp[i][j] = dp[i-1][j] + 1;
                    } else { // 2번 나무
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (wood % 2 == 1) { // 1번 나무
                        if (j % 2 == 0) { // 짝수 번 움직였을 때, 자두 먹을 수 있음
                            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                        } else { // 홀수 번 움직였을 때, 자두 못먹음
                            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                        }
                    } else { // 2번 나무
                        if (j % 2 == 0) {// 짝수 번 움직였을 때, 자두 못먹음
                            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                        } else { // 홀수 번 움직였을 때, 자두 먹을 수 있음
                            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int j = 0; j < w + 1; j++) {
            if (dp[t][j] > max) {
                max = dp[t][j];
            }
        }
        System.out.println(max);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
