import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, String[]> hs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] users = br.readLine().split(" ");
            hs.put(i, users);
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                int age1 = Integer.parseInt(hs.get(num1)[0]);
                int age2 = Integer.parseInt(hs.get(num2)[0]);
                if (age1 < age2) {
                    return -1;
                } else if (age1 == age2) {
                    return num1.compareTo(num2);
                }
                return 1;
            }
        };

        List<Integer> keyList = new ArrayList<Integer>(hs.keySet());
        Collections.sort(keyList, comparator);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = "";
        for (Integer i : keyList) {
            bw.write(answer + hs.get(i)[0] + " " + hs.get(i)[1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
