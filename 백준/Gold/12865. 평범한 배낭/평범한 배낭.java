import java.util.*;
import java.io.*;

class Solution {
    Solution() {

    }

    int[][] makeDp(int idx, int weight) {
        int[][] dp = new int[idx + 1][weight + 1];
        for (int i = 0; i < idx + 1; i++) {
            for (int j = 0; j < weight + 1; j++) {
                dp[i][j] = 0;
            }
        }
        return dp;
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        String[] input = br.readLine().strip().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        int[][] dp = makeDp(n, k);

        int[][] weightList = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            String[] weightInput = br.readLine().strip().split(" ");
            weightList[i + 1][0] = Integer.parseInt(weightInput[0]); // weight
            weightList[i + 1][1] = Integer.parseInt(weightInput[1]); // value
        }

        for (int w = 1; w < k + 1; w++) {
            for (int i = 1; i < n + 1; i++) {
                if (weightList[i][0] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    int curValue = weightList[i][1];
                    int curWeight = weightList[i][0];
                    if (dp[i - 1][w] > dp[i - 1][w - curWeight] + curValue) {
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        dp[i][w] = dp[i - 1][w - curWeight] + curValue;
                    }
                }
            }
        }
        
        System.out.println(dp[n][k]);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
