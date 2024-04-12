import java.util.*;
import java.io.*;

class Solution {
    public int[] makeDistance(int N) {
        int[] distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[1] = 0;
        return distance;
    }
    
    public ArrayList<ArrayList<Node>> makeGraph(int N, int[][] road) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        int m = road.length;
        
        for (int i = 0; i < m; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        return graph;
    }
    
    public Comparator<Node> comparator = new Comparator<>() {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.cost - n2.cost;
        }
    };
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = makeDistance(N);
        ArrayList<ArrayList<Node>> graph = makeGraph(N, road);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(comparator);
        pq.offer(new Node(1, 0));
        
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
        
        for (int num : distance) {
            if (num <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}

class Node {
    int idx;
    int cost;
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}