import java.util.*;
import java.io.*;

class Solution {
    int n, m;
    Solution() {

    }

    public void run() throws IOException {
        // 진실 아는 사람 배열로 저장, 스택 or 큐에 넣기
        // 입력받아서 파티 클래스에 아이디, 사람 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        boolean[] partyVisited = new boolean[m];
        boolean[] peopleVisited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            partyVisited[i] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            peopleVisited[i] = false;
        }

        String[] truthPeople = br.readLine().strip().split(" ");
        Deque<Integer> queue = new ArrayDeque<>();
        if (!truthPeople[0].equals("0")) {
            for (int i = 1; i < truthPeople.length; i++) {
                queue.offer(Integer.parseInt(truthPeople[i]));
                peopleVisited[Integer.parseInt(truthPeople[i])] = true;
            }
        }

        ArrayList<Party> partyList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] partyInput = br.readLine().strip().split(" ");
            int size = Integer.parseInt(partyInput[0]);
            int[] people = new int[size];
            for (int j = 1; j < partyInput.length; j++) {
                people[j - 1] = Integer.parseInt(partyInput[j]);
            }
            partyList.add(new Party(i, n, people));
        }

        while (!queue.isEmpty()) {
            int curPerson = queue.pollFirst();
            for (int i = 0; i < m; i++) {
                Party p = partyList.get(i);
                if (!partyVisited[p.id]) {
                    if (p.available(curPerson)) {
                        partyVisited[p.id] = true;
                        int[] people = p.people;
                        for (int person : people) {
                            if (!peopleVisited[person]) {
                                peopleVisited[person] = true;
                                queue.offer(person);
                            }
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (boolean visited : partyVisited) {
            if (!visited) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Party {
    int id;
    int[] people;
    boolean[] isParticipate;

    Party(int id, int num, int[] people) {
        this.id = id;
        this.people = people;
        initializeIsParticipate(people, num);
    }

    void initializeIsParticipate(int[] people, int num) {
        isParticipate = new boolean[num + 1];
        for (int i = 1; i < num + 1; i++) {
            isParticipate[i] = false;
        }

        for (int i : people) {
            isParticipate[i] = true;
        }
    }

    boolean available(int idx) {
        return isParticipate[idx];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
