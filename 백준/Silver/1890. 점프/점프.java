import java.util.*;
import java.io.*;

class Solution {
    Solution() {

    }

    private void printMap(int[][] map, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void printDp(long[][] dp, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().strip().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // printMap(map, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = map[i][j];

                if (value != 0) {
                    if (i + value < n) {
                        dp[i + value][j] += dp[i][j];
                    }

                    if (j + value < n) {
                        dp[i][j + value] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
