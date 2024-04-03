import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0;i<n;i++) {
            String command = br.readLine().trim();
            if (command.equals("top")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek() + "\n");
                } else{
                    sb.append("-1\n");
                }
                continue;
            }
            if(command.equals("size")) {
                sb.append(stack.size() + "\n");
                continue;
            }
            if (command.equals("empty")) {
                if (!stack.isEmpty()) {
                    sb.append("0\n");
                }else{
                    sb.append("1\n");
                }
                continue;
            }
            if (command.equals("pop")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek() + "\n");
                    stack.pollFirst();
                } else {
                    sb.append("-1\n");
                }
                continue;
            }

            String[] arr = command.split(" ");
            stack.addFirst(Integer.parseInt(arr[1]));
        }

        System.out.println(sb.toString());
    }
}
