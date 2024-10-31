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
        int k, n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        k = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        int[] lineList = new int[k];
        for (int i = 0; i < k; i++) {
            lineList[i] = Integer.parseInt(br.readLine().strip());
        }
        Arrays.sort(lineList);

        long bot = 1;
        long top = lineList[k - 1];
        long mid = (bot + top) / 2;

        long cnt = 0;
        while (bot <= top) {
            cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += lineList[i] / mid;
            }

            if (cnt < n) {
                top = mid - 1;
                mid = (bot + top) / 2;
            } else {
                bot = mid + 1;
                mid = (bot + top) / 2;
            }
        }

        System.out.println(mid);
    }
}