import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 다익스트라로 최단
        // distance가 MAX_VALUE가 아닌 것들이 개수 세기 -> 감염된 컴퓨터 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().strip());

        Comparator<Node> comparator = new Comparator<>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        };

        for (int i = 0; i < t; i++) {
            int n, d, start;
            String[] input = br.readLine().strip().split(" ");
            n = Integer.parseInt(input[0]);
            d = Integer.parseInt(input[1]);
            start = Integer.parseInt(input[2]);

            // 거리 배열
            int[] distance = new int[n + 1];
            for (int j = 0; j < n + 1; j++) {
                distance[j] = Integer.MAX_VALUE;
            }
            distance[start] = 0;

            // 우선순위 큐
            PriorityQueue<Node> pq = new PriorityQueue<>(comparator);
            pq.offer(new Node(start, 0));

            // 그래프 생성
            ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
            for (int j =0;j<n+1;j++) {
                graph.add(new ArrayList<Node>());
            }
            for (int j = 0; j < d; j++) {
                String[] graphInput = br.readLine().strip().split(" ");
                int to, from, cost;
                to = Integer.parseInt(graphInput[0]);
                from = Integer.parseInt(graphInput[1]);
                cost = Integer.parseInt(graphInput[2]);
                graph.get(from).add(new Node(to, cost));
            }

            while (!pq.isEmpty()) {
                Node curNode = pq.poll();
                int curIdx = curNode.idx;
                int curCost = curNode.cost;

                if (distance[curIdx] < curCost) {
                    continue;
                }

                for (Node nextNode : graph.get(curIdx)) {
                    int nextIdx = nextNode.idx;
                    int nextCost = nextNode.cost;

                    if (distance[nextIdx] > distance[curIdx] + nextCost) {
                        distance[nextIdx] = distance[curIdx] + nextCost;
                        pq.offer(new Node(nextIdx, distance[nextIdx]));
                    }
                }
            }

            // 감염된 컴퓨터 대수
            int cnt = 0;
            for (int j = 0;j<n+1;j++) {
                if (distance[j] != Integer.MAX_VALUE) {
                    cnt++;
                }
            }

            // 걸리는 시간
            int time = 0;
            for (int dist : distance) {
                if (dist != Integer.MAX_VALUE && dist > time) {
                    time = dist;
                }
            }

            sb.append(cnt);
            sb.append(" ");
            sb.append(time);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

class Node {
    int idx, cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}
