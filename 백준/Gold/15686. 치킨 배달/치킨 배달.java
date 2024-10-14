import java.util.*;
import java.io.*;

class Solution {
    ArrayList<Node> homeList;
    ArrayList<Node> chickenList;
    ArrayList<Integer> distList;

    Solution() {

    }

    private ArrayList<Node> findHomeList(int[][] map, int n) {
        ArrayList<Node> homeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    homeList.add(new Node(i, j));
                }
            }
        }

        return homeList;
    }

    private ArrayList<Node> findChickenList(int[][] map, int n) {
        ArrayList<Node> chickenList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        return chickenList;
    }

    private void printVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            System.out.print(visited[i] + " ");
        }
        System.out.println("");
    }

    private void permutation(boolean[] visited, int start, int depth, int m, int chickenSize) {
        if (depth == m) {
            calculateMinimum(visited);
            return;
        }

        for (int i = start; i < chickenSize; i++) {
            visited[i] = true;
            permutation(visited, i + 1, depth + 1, m, chickenSize);
            visited[i] = false;
        }
    }

    private void calculateMinimum(boolean[] visited) {
        ArrayList<Node> tempChickenList = new ArrayList<>();
        int minimumDist = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                tempChickenList.add(chickenList.get(i));
            }
        }

        for (Node hn : homeList) {
            int hx = hn.getX();
            int hy = hn.getY();

            int dist = 1000000;

            for (Node cn : tempChickenList) {
                int cx = cn.getX();
                int cy = cn.getY();

                int tmpDist = Math.abs(cx - hx) + Math.abs(cy - hy);
                if (tmpDist < dist) {
                    dist = tmpDist;
                }
            }
            minimumDist += dist;
        }

        distList.add(minimumDist);
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] mapInput = br.readLine().strip().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput[j]);
            }
        }

        homeList = findHomeList(map, n);
        chickenList = findChickenList(map, n);
        distList = new ArrayList<>();

        boolean[] visited = new boolean[chickenList.size()];
        Arrays.fill(visited, false);
        permutation(visited, 0, 0, m, chickenList.size());

        Collections.sort(distList);
        System.out.println(distList.get(0));
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
        Solution s = new Solution();
        s.run();
    }
}
