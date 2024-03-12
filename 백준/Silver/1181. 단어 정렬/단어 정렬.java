import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        List<String> words = new ArrayList<>(hs);
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return 1;
        };

        Collections.sort(words, comparator);
        for (String word : words) {
            System.out.println(word);
        }
    }
}
