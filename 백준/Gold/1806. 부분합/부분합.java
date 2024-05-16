import java.util.*;
import java.io.*;

public class Main {
    static int findStartIndex(int[] dp, int n, int s) {
        int idx = -1;
        for (int i = 0; i < n + 1; i++) {
            if (dp[i] >= s) {
                return i;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s;
        String[] input = br.readLine().strip().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        int[] numbers = new int[n];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        String[] numInput = br.readLine().strip().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numInput[i]);
            dp[i + 1] = numbers[i];
        }

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i] + dp[i - 1];
        }

        int startIndex = findStartIndex(dp, n, s);
        //System.out.println(startIndex);

        if (startIndex == -1) {
            System.out.println(0);
        } else {
            int length = 100000;
            for (int i = startIndex; i < n + 1; i++) {
                for (int j = i - 1; j > -1; j--) {
                    if (dp[i] - dp[j] >= s) {
                        if (i - j < length) {
                            length = i - j;
                            //System.out.println("startIdx = " + i + ", length = " + length);
                        }
                        break;
                    }
                }
            }
            System.out.println(length);
        }
    }
}
