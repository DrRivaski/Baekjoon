import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] numArr = new int[n];

        for (int i = 0; i < n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0;i<n;i++) {
            numArr[i] = i + 1;
        }

        int curArrIdx = 0;
        int curNumArrIdx = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        while (curArrIdx < n && curNumArrIdx < n) {
            if (!stack.isEmpty()) {
                if (stack.peek() == arr[curArrIdx]) {
                    sb.append("-\n");
                    stack.pollFirst();
                    curArrIdx++;
                    continue;
                }
            }
            stack.addFirst(numArr[curNumArrIdx]);
            sb.append("+\n");
            curNumArrIdx++;
        }

        if (curNumArrIdx == n) {
            while (curArrIdx < n) {
                if (stack.peek() == arr[curArrIdx]) {
                    sb.append("-\n");
                    stack.pollFirst();
                    curArrIdx++;
                } else {
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }

    }
}
