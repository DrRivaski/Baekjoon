import java.util.*;

class Solution {
    public boolean checkX(String[] maps) {
        int m = maps.length;
        int n = maps[0].length();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char curChar = maps[i].charAt(j);
                if (curChar != 'X') {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int[][] makeGraph(String[] maps) {
        int m = maps.length;
        int n = maps[0].length();
        int[][] graph = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char curChar = maps[i].charAt(j);
                if (curChar == 'X') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = (int)curChar - '0';
                }
            }
        }
        return graph;
    }
    
    public boolean[][] makeVisited(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        return visited;
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        
        // 지낼 수 있는 땅이 없을때
        if (!checkX(maps)) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int m = maps.length;
        int n = maps[0].length();
        
        int[][] graph = makeGraph(maps);
        boolean[][] visited = makeVisited(m, n);
        
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        
        for (int sx = 0; sx < m; sx++) {
            for (int sy = 0; sy < n; sy++) {
                if (graph[sx][sy] != 0 && !visited[sx][sy]) {
                    Deque<Node> queue = new ArrayDeque<>();
                    Node start = new Node(sx, sy);
                    visited[sx][sy] = true;
                    queue.add(start);

                    int cnt = graph[sx][sy];
                    while (!queue.isEmpty()) {
                        Node curNode = queue.pollFirst();
                        int curX = curNode.x;
                        int curY = curNode.y;


                        for (int i = 0; i < 4; i++) {
                            int newX = curX + dirX[i];
                            int newY = curY + dirY[i];

                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && graph[newX][newY] != 0) {
                                cnt += graph[newX][newY];
                                visited[newX][newY] = true;
                                queue.add(new Node(newX, newY));
                            }
                        } 
                    }
                    answerList.add(cnt);
                }           
            }
        }
        Collections.sort(answerList);
        int size = answerList.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}