import java.util.*;
import java.io.*;

class Solution {
    Comparator<Node> comparator = new Comparator<>() {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.getCost() - n2.getCost();
        }
    };
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < costs.length; i++) {
            graph.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            graph.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(comparator);
        pq.add(new Node(0, 0));
        
        boolean[] visited = new boolean[n];
        //visited[0] = true;
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int idx = curNode.getIdx();
            int cost = curNode.getCost();
            
            
            if(visited[idx]) {
                continue;
            }
            
            visited[idx] = true;
            answer += cost;
            
            for (Node nextNode : graph.get(idx)) {
                if(!visited[nextNode.getIdx()]) {
                    pq.add(nextNode);
                }
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
    
    public int getIdx() {
        return this.idx;
    }
    
    public int getCost() {
        return this.cost;
    }
}