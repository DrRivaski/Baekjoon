import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[num];

        for (int i = 0; i < num; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < num; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            arr[i].add(weight);
            arr[i].add(height);
        }

        ArrayList<Integer> answerList = new ArrayList<Integer>();

        for (int i = 0; i < num; i++) {
            int curWeight = arr[i].get(0);
            int curHeight = arr[i].get(1);
            int cnt = 1;
            for (int j = 0; j < num; j++) {
                if (arr[j].get(0) > curWeight & arr[j].get(1) > curHeight) {
                    cnt++;
                }
            }
            answerList.add(cnt);
        }

        for (int i = 0; i < num; i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }
}
