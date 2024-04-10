import java.util.*;
import java.io.*;

class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getCost() {
        return this.cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, start;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        start = Integer.parseInt(input[2]);

        int[] distanceGo = new int[n + 1];
        int[] distanceBack = new int[n + 1];
        for (int i = 0; i < n; i++) {
            distanceGo[i + 1] = Integer.MAX_VALUE;
            distanceBack[i + 1] = Integer.MAX_VALUE;
        }

        // 그래프 생성
        ArrayList<ArrayList<Node>> graphGo = new ArrayList<ArrayList<Node>>();
        ArrayList<ArrayList<Node>> graphBack = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n + 1; i++) {
            graphGo.add(new ArrayList<Node>());
            graphBack.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            String[] graphInput = br.readLine().strip().split(" ");
            int from, to, cost;
            from = Integer.parseInt(graphInput[0]);
            to = Integer.parseInt(graphInput[1]);
            cost = Integer.parseInt(graphInput[2]);
            graphGo.get(from).add(new Node(to, cost));
            graphBack.get(to).add(new Node(from, cost));
        }

        PriorityQueue<Node> queueGo = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getCost(), o2.getCost()));
        PriorityQueue<Node> queueBack = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getCost(), o2.getCost()));

        distanceGo[start] = 0;
        queueGo.offer(new Node(start, 0));

        while (!queueGo.isEmpty()) {
            Node curNode = queueGo.poll();
            int curIdx = curNode.getIdx();
            int curCost = curNode.getCost();

            if (distanceGo[curIdx] < curCost) {
                continue;
            }

            for (Node nextNode : graphGo.get(curIdx)) {
                int nextIdx = nextNode.getIdx();
                int nextCost = nextNode.getCost();

                if (distanceGo[nextIdx] > distanceGo[curIdx] + nextCost) {
                    distanceGo[nextIdx] = distanceGo[curIdx] + nextCost;
                    queueGo.offer(new Node(nextIdx, distanceGo[nextIdx]));
                }
            }
        }

        distanceBack[start] = 0;
        queueBack.offer(new Node(start, 0));

        while (!queueBack.isEmpty()) {
            Node curNode = queueBack.poll();
            int curIdx = curNode.getIdx();
            int curCost = curNode.getCost();

            if (distanceBack[curIdx] < curCost) {
                continue;
            }

            for (Node nextNode : graphBack.get(curIdx)) {
                int nextIdx = nextNode.getIdx();
                int nextCost = nextNode.getCost();

                if (distanceBack[nextIdx] > distanceBack[curIdx] + nextCost) {
                    distanceBack[nextIdx] = distanceBack[curIdx] + nextCost;
                    queueBack.offer(new Node(nextIdx, distanceBack[nextIdx]));
                }
            }
        }

        int[] answerList = new int[n];
        for (int i = 0; i < n; i++) {
            answerList[i] = distanceGo[i + 1] + distanceBack[i + 1];
        }
        Arrays.sort(answerList);
        System.out.println(answerList[n - 1]);
    }
}
