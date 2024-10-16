import java.util.*;
import java.io.*;

class Solution {
    int[] dirX = {1, 0, -1, 0};
    int[] dirY = {0, 1, 0, -1};

    Solution() {

    }

    private boolean[][] initializeVisited() {
        return new boolean[12][6];
    }

    private ArrayList<Node> getBlockList(String[][] map) {
        ArrayList<Node> blockList = new ArrayList<>();
        boolean[][] visited = initializeVisited();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (!visited[i][j]) {
                    if (map[i][j].equals(".")) {
                        visited[i][j] = true;
                    } else {
                        ArrayList<Node> tmpList = new ArrayList<>();
                        String color = map[i][j];
                        visited[i][j] = true;
                        Deque<Node> queue = new ArrayDeque<>();
                        queue.add(new Node(i, j));
                        tmpList.add(new Node(i, j));

                        while (!queue.isEmpty()) {
                            Node curNode = queue.pollFirst();
                            int curX = curNode.getX();
                            int curY = curNode.getY();

                            for (int k = 0; k < 4; k++) {
                                int newX = curX + dirX[k];
                                int newY = curY + dirY[k];
                                if (newX >= 0 && newX < 12 && newY >= 0 && newY < 6) {
                                    if (!visited[newX][newY] && map[newX][newY].equals(color)) {
                                        queue.add(new Node(newX, newY));
                                        tmpList.add(new Node(newX, newY));
                                        visited[newX][newY] = true;
                                    }
                                }
                            }
                        }

                        if (tmpList.size() >= 4) {
                            blockList.addAll(tmpList);
                        }
                    }
                }
            }
        }

        return blockList;
    }

    private void removeBlock(String[][] map, ArrayList<Node> removeBlockList) {
        for (Node n : removeBlockList) {
            map[n.getX()][n.getY()] = ".";
        }
    }

    private void moveDownBlock(String[][] map) {
        for (int j = 0; j < 6; j++) {
            ArrayList<String> tmpList = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                if (!map[i][j].equals(".")) {
                    tmpList.add(map[i][j]);
                }
            }

            for (int i = 0; i < 12; i++) {
                map[i][j] = ".";
            }

            int startIdx = 12 - tmpList.size();

            for (int i = startIdx; i < 12; i++) {
                map[i][j] = tmpList.get(i - startIdx);
            }
        }
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map = new String[12][6];
        int count = 0;

        for (int i = 0; i < 12; i++) {
            String[] input = br.readLine().strip().split("");
            for (int j = 0; j < 6; j++) {
                map[i][j] = input[j];
            }
        }

        while (true) {
            ArrayList<Node> removeBlockList = getBlockList(map);
            if (removeBlockList.isEmpty()) {
                break;
            } else {
                removeBlock(map, removeBlockList);
                count++;
                moveDownBlock(map);
            }
        }

        System.out.println(count);
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
