import java.util.*;
import java.io.*;

class Solution {
    int[] dirX = {1, 0, -1, 0};
    int[] dirY = {0, 1, 0, -1};

    Solution() {

    }

    private int getMaxHeight(int[][] map, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > result) {
                    result = map[i][j];
                }
            }
        }

        return result;
    }

    private int getMinHeight(int[][] map, int n) {
        int result = 100;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < result) {
                    result = map[i][j];
                }
            }
        }

        return result;
    }

    private boolean[][] initializeVisitedMap(int[][] map, int rainHeight, int n) {
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        // 이미 잠긴 곳은 visited 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= rainHeight) {
                    visited[i][j] = true;
                }
            }
        }

        return visited;
    }

    private int countSafeRegion(boolean[][] visited, int n) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    Node startNode = new Node(i, j);
                    visited[i][j] = true;
                    cnt++;
                    Deque<Node> queue = new ArrayDeque<>();
                    queue.add(startNode);

                    while (!queue.isEmpty()) {
                        Node curNode = queue.pollFirst();
                        int curX = curNode.getX();
                        int curY = curNode.getY();

                        for (int di = 0; di < 4; di++) {
                            int newX = curX + this.dirX[di];
                            int newY = curY + this.dirY[di];

                            if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                                if (!visited[newX][newY]) {
                                    visited[newX][newY] = true;
                                    queue.add(new Node(newX, newY));
                                }
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public void run() throws IOException {
        // 입력받아서 맵 만들기
        // 1부터 max까지 돌면서 하나씩 잠기게 하기
        // BFS를 이용해서 안잠긴 지역 개수 세기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        // 맵 만들기
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().strip().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int maxHeight = getMaxHeight(map, n);
        int minHeight = getMinHeight(map, n);

        int answer = 1;

        for (int rainHeight = minHeight; rainHeight <= maxHeight; rainHeight++) {
            boolean[][] visited = initializeVisitedMap(map, rainHeight, n);
            int safeRegionCnt = countSafeRegion(visited, n);
            if (answer < safeRegionCnt) {
                answer = safeRegionCnt;
            }
        }

        System.out.println(answer);
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}
