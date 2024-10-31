import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}

class Solution {
    int[] arr;

    Solution() {

    }

    private int getAnswer(int n, int m) {
        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        int cnt = 0;

        if (m == 0) {
            return 0;
        }

        while (left < n) {
            while (right < n && arr[right] - arr[left] < m) {
                right++;
            }

            if (right == n) {
                break;
            }

            if (arr[right] - arr[left] >= m && arr[right] - arr[left] < answer) {
                answer = arr[right] - arr[left];
            }
            left++;
        }
        return answer;
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        int n, m;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().strip());
        }
        Arrays.sort(arr);

        System.out.println(getAnswer(n, m));
    }
}
