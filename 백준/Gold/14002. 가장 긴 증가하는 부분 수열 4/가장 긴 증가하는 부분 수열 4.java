import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String[] input = br.readLine().strip().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[n];
        int[] indexDp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(indexDp, -1);

        for (int i = 1; i < n; i++) {
            int max = -1;
            int index = -1;
            for (int j = i - 1; j > -1; j--) {
                if (numbers[j] < numbers[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                        index = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            indexDp[i] = index;
        }

        // dp의 최대 인덱스 찾기
        int maxIndex = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                maxIndex = i;
                max = dp[i];
            }
        }

//        System.out.println(maxIndex);
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(indexDp));

        while (maxIndex != -1) {
            answerList.add(numbers[maxIndex]);
            maxIndex = indexDp[maxIndex];
        }
        System.out.println(answerList.size());
        for (int i = answerList.size() - 1; i > -1; i--) {
            sb.append(answerList.get(i)).append((" "));
        }
        System.out.println(sb.toString());
    }
}
