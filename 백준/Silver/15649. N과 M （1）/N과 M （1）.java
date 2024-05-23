import java.util.*;
import java.io.*;

class Solution {
    boolean[] visited;
    int n, m;
    ArrayList<String> answerList = new ArrayList<>();

    Solution() {

    }

    void recursive(int depth, String curString) {
        if (depth <= m) {
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    recursive(depth + 1, curString + i + " ");
                    visited[i] = false;
                }
            }
        } else {
            answerList.add(curString);
        }
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        recursive(1, "");
        StringBuilder sb = new StringBuilder();
        for (String s : answerList) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
