import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    int h;

    public Node(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getH() {
        return this.h;
    }
}

public class Main {
    public static boolean checkZero(int[][][] graph, int m, int n, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void printGraph(int[][][] graph, int m, int n, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(graph[i][j]));
            }
            System.out.println("------");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, h;
        int days = 0;
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        int[][][] graph = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                int tmpIdx = 0;
                for (String s : br.readLine().strip().split(" ")) {
                    graph[i][j][tmpIdx] = Integer.parseInt(s);
                    tmpIdx++;
                }
            }
        }

        boolean[][][] visited = new boolean[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    visited[i][j][k] = false;
                }
            }
        }

        Deque<Node> queue = new ArrayDeque<>();
        // 시작 지점 큐에 넣기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 1) {
                        queue.add(new Node(j, k, i));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        int[] dirH = {1, -1};

        while (!queue.isEmpty()) {
            days++;
            Deque<Node> tmpQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                tmpQueue.push(queue.pollFirst());
            }

            while (!tmpQueue.isEmpty()) {
                Node curNode = tmpQueue.poll();
                int curX = curNode.getX();
                int curY = curNode.getY();
                int curH = curNode.getH();

                // 현재 레벨에서 앞뒤좌우
                for (int di = 0; di < 4; di++) {
                    int newX = curX + dirX[di];
                    int newY = curY + dirY[di];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                        if (graph[curH][newX][newY] == 0 && !visited[curH][newX][newY]) {
                            visited[curH][newX][newY] = true;
                            graph[curH][newX][newY] = 1;
                            queue.push(new Node(newX, newY, curH));
                        }
                    }
                }

                // 높이 위 아래
                for (int dh : dirH) {
                    int newH = curH + dh;
                    if (newH >= 0 && newH < h) {
                        if (graph[newH][curX][curY] == 0 && !visited[newH][curX][curY]) {
                            visited[newH][curX][curY] = true;
                            graph[newH][curX][curY] = 1;
                            queue.push(new Node(curX, curY, newH));
                        }
                    }
                }
            }
        }

        if (checkZero(graph, m, n, h)) {
            System.out.println(days - 1);
        } else {
            System.out.println(-1);
        }
    }
}
