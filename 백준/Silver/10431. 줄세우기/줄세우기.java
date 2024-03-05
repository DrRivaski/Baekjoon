import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int countNumbers(ArrayList<Integer> intArr) {
        int cnt = 0;
        int len = intArr.size();
        for (int i = 0; i < len; i++) {
            int cur = intArr.get(i);
            for (int j = 0; j < i + 1; j++) {
                if (intArr.get(j) > cur) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            ArrayList<Integer> intArr = new ArrayList<>();

            for (String s : strArr) {
                intArr.add(Integer.parseInt(s));
            }

            intArr.remove(0);

            System.out.print(i + 1);
            System.out.print(" ");
            System.out.println(countNumbers(intArr));
        }
    }

}
