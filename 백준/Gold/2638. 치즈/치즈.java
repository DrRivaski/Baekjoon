import java.util.*;
import java.io.*;

class Solution {
    int m, n;
    int[] dirX = {1, 0, -1, 0};
    int[] dirY = {0, 1, 0, -1};
    Deque<Node> inside = new ArrayDeque<>();
    ArrayList<Node> cheese = new ArrayList<>();

    Solution() {

    }

    int[][] makeGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        m = Integer.parseInt(input[0]); // 세로
        n = Integer.parseInt(input[1]); // 가로
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] graphInput = br.readLine().strip().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(graphInput[j]);
            }
        }

        return graph;
    }

    boolean[][] makeVisitedGraph() {
        boolean[][] visitedGraph = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visitedGraph[i][j] = false;
            }
        }
        return visitedGraph;
    }

    void initializeVisitedGraph(boolean[][] visited) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    void fillOutSide(int[][] graph, boolean[][] visited) {
        initializeVisitedGraph(visited);
        graph[0][0] = -1;
        int curX, curY;

        Deque<Node> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.pollFirst();
            curX = curNode.x;
            curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int newX = curX + dirX[i];
                int newY = curY + dirY[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && graph[newX][newY] == 0) {
                    visited[newX][newY] = true;
                    queue.offer(new Node(newX, newY));
                    graph[newX][newY] = -1;
                }
            }
        }
    }

    void meltCheese(int[][] graph) {
        ArrayList<Node> outsideCheese = new ArrayList<>();

        for (Node curNode : cheese) {
            int curX = curNode.x;
            int curY = curNode.y;
            if (graph[curX][curY] == 1) {
                int tmpCnt = 0;
                for (int i = 0; i < 4; i++) {
                    int newX = curNode.x + dirX[i];
                    int newY = curNode.y + dirY[i];
                    if (graph[newX][newY] == -1) {
                        tmpCnt++;
                    }
                }
                if (tmpCnt >= 2) {
                    outsideCheese.add(new Node(curX, curY));
                }
            }
        }

        for (Node curNode : outsideCheese) {
            int curX = curNode.x;
            int curY = curNode.y;

            graph[curX][curY] = -1;
        }
    }

    void checkInOut(int[][] graph) {
        // 각 내부 공기와 연결된 위치 다 찾기
        // 그 중 하나라도 외부 공기와 연결돼있으면 모두 다 -1로 바꾸기

        Deque<Node> queue = new ArrayDeque<>();
        boolean[][] visited = makeVisitedGraph();
        for (Node curNode : inside) {
            boolean flag = false;
            int curX = curNode.x;
            int curY = curNode.y;
            if (!visited[curX][curY]) {
                queue.offer(new Node(curX, curY));
                visited[curX][curY] = true;
                ArrayList<Node> linkedInside = new ArrayList<>();
                linkedInside.add(new Node(curX,curY));
                while (!queue.isEmpty()) {
                    Node cur = queue.pollFirst();
                    for (int i = 0; i < 4; i++) {
                        int newX = cur.x + dirX[i];
                        int newY = cur.y + dirY[i];
                        if (!flag && graph[newX][newY] == -1) {
                            flag = true;
                        }
                        if (!visited[newX][newY] && graph[newX][newY] == 0) {
                            linkedInside.add(new Node(newX, newY));
                            visited[newX][newY] = true;
                            queue.offer(new Node(newX, newY));
                        }
                    }
                }
                if (flag) {
                    for (Node n : linkedInside) {
                        graph[n.x][n.y] = -1;
                    }
                }
            }
        }
    }

    void findInside(int[][] graph) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    inside.offer(new Node(i, j));
                }
            }
        }
    }

    void findCheese(int[][] graph) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    cheese.add(new Node(i, j));
                }
            }
        }
    }

    boolean checkGraph(int[][] graph) {
        for (Node curNode : cheese) {
            if (graph[curNode.x][curNode.y] == 1) {
                return false;
            }
        }
        return true;
    }

    void printGraph(int[][] graph) {
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }

    public void run() throws IOException {
        int[][] graph = makeGraph();
        boolean[][] visited = makeVisitedGraph();

        int cnt = 0;
        fillOutSide(graph, visited);
        findInside(graph);
        findCheese(graph);
        while (!checkGraph(graph)) {
            cnt++;
            meltCheese(graph);
            checkInOut(graph);
            //printGraph(graph);
            //System.out.println("");
        }
        System.out.println(cnt);
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
