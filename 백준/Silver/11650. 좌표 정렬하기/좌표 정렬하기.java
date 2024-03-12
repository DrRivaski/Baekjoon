import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> posList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            String[] pos = br.readLine().split(" ");
            ArrayList<Integer> tmpPosList = new ArrayList<>();
            tmpPosList.add(Integer.parseInt(pos[0]));
            tmpPosList.add(Integer.parseInt(pos[1]));
            posList.add(tmpPosList);
        }

        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
                if (arr1.get(0) < arr2.get(0)) {
                    return -1;
                } else if (arr1.get(0).equals(arr2.get(0))) {
                    return arr1.get(1).compareTo(arr2.get(1));
                }
                return 1;
            }
        };

        Collections.sort(posList, comparator);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = "";
        for (ArrayList<Integer> pos : posList) {
            bw.write(answer + pos.get(0) + " " + pos.get(1) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
