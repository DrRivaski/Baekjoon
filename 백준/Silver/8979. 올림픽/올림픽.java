import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        ArrayList<country> countryList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx, g, s, b;
            String[] countryInput = br.readLine().strip().split(" ");
            idx = Integer.parseInt(countryInput[0]);
            g = Integer.parseInt(countryInput[1]);
            s = Integer.parseInt(countryInput[2]);
            b = Integer.parseInt(countryInput[3]);
            countryList.add(new country(idx, g, s, b));
        }

        Comparator<country> comparator = new Comparator<>() {
            @Override
            public int compare(country o1, country o2) {
                if (o1.gold == o2.gold) {
                    if (o1.silver == o2.silver) {
                        return o2.bronze - o1.bronze;
                    } else {
                        return o2.silver - o1.silver;
                    }
                } else {
                    return o2.gold - o1.gold;
                }
            }
        };

        int targetGold = 0;
        int targetSilver = 0;
        int targetBronze = 0;

        for (country c : countryList) {
            if (c.idx == k) {
                targetGold = c.gold;
                targetSilver = c.silver;
                targetBronze = c.bronze;
            }
        }

        Collections.sort(countryList, comparator);

        int rank = 0;
        for (country c : countryList) {
            if (c.gold == targetGold && c.silver == targetSilver && c.bronze == targetBronze) {
                break;
            } else{
                rank++;
            }
        }
        System.out.println(rank + 1);
    }
}

class country {
    int idx;
    int gold;
    int silver;
    int bronze;

    country(int idx, int g, int s, int b) {
        this.idx = idx;
        this.gold = g;
        this.silver = s;
        this.bronze = b;
    }
}
