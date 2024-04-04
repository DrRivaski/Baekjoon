import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().trim().split(" ");
        int src = Integer.parseInt(arr[0]);
        int target = Integer.parseInt(arr[1]);

        int cnt = 0;

        while (target > src) {
            if (target % 2 == 0) {
                target = target / 2;
                cnt++;
                continue;
            }
            if (target % 10 == 1) {
                target = target / 10;
                cnt++;
                continue;
            } else {
                break;
            }
        }

        if (target == src) {
            System.out.println(cnt + 1);
        } else{
            System.out.println(-1);
        }
    }
}
