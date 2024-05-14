import java.util.*;
import java.io.*;

// 맵 입력받기
// 탐색하면서 cctv 위치 저장하기 (id, x, y), Node를 ArrayList로 저장
// DFS함수 재귀로 작성. ArrayList.get(depth)로 돌면서 depth가 cctv 개수보다 커지면 사각지대 카운트 하고 종료

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}

class Solution {
    ArrayList<Node> CCTVList = new ArrayList<>();
    int m, n;
    int finalDepth;
    int result = 1000000;

    void printBoard(int[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Integer.toString(board[i][j]) + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    int[][] makeBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        int[][] board = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] boardInput = br.readLine().strip().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        return board;
    }

    void findCCTV(int[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0 && board[i][j] != 6) {
                    Node node = new Node(board[i][j], i, j);
                    CCTVList.add(node);
                }
            }
        }
    }

    int countInvisible(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void DFS(int[][] board, int depth) {
        // 종료조건
        if (depth == finalDepth) {
            int cnt = countInvisible(board);
            if (result > cnt) {
                result = cnt;
            }
        } else {
            Node curNode = CCTVList.get(depth);
            int cId = curNode.id;
            int curX = curNode.x;
            int curY = curNode.y;

            if (cId == 1) {
                int[][] tmpBoard1 = new int[m][n];
                int[][] tmpBoard2 = new int[m][n];
                int[][] tmpBoard3 = new int[m][n];
                int[][] tmpBoard4 = new int[m][n];

                copyBoard(board, tmpBoard1);
                copyBoard(board, tmpBoard2);
                copyBoard(board, tmpBoard3);
                copyBoard(board, tmpBoard4);

                boardUp(tmpBoard1, curX, curY);
                boardDown(tmpBoard2, curX, curY);
                boardRight(tmpBoard3, curX, curY);
                boardLeft(tmpBoard4, curX, curY);

                DFS(tmpBoard1, depth + 1);
                DFS(tmpBoard2, depth + 1);
                DFS(tmpBoard3, depth + 1);
                DFS(tmpBoard4, depth + 1);
            } else if (cId == 2) {
                int[][] tmpBoard1 = new int[m][n];
                int[][] tmpBoard2 = new int[m][n];
                copyBoard(board, tmpBoard1);
                copyBoard(board, tmpBoard2);

                boardUp(tmpBoard1, curX, curY);
                boardDown(tmpBoard1, curX, curY);

                boardRight(tmpBoard2, curX, curY);
                boardLeft(tmpBoard2, curX, curY);

                DFS(tmpBoard1, depth + 1);
                DFS(tmpBoard2, depth + 1);
            } else if (cId == 3) {
                int[][] tmpBoard1 = new int[m][n];
                int[][] tmpBoard2 = new int[m][n];
                int[][] tmpBoard3 = new int[m][n];
                int[][] tmpBoard4 = new int[m][n];

                copyBoard(board, tmpBoard1);
                copyBoard(board, tmpBoard2);
                copyBoard(board, tmpBoard3);
                copyBoard(board, tmpBoard4);

                boardUp(tmpBoard1, curX, curY);
                boardRight(tmpBoard1, curX, curY);

                boardRight(tmpBoard2, curX, curY);
                boardDown(tmpBoard2, curX, curY);

                boardDown(tmpBoard3, curX, curY);
                boardLeft(tmpBoard3, curX, curY);

                boardLeft(tmpBoard4, curX, curY);
                boardUp(tmpBoard4, curX, curY);

                DFS(tmpBoard1, depth + 1);
                DFS(tmpBoard2, depth + 1);
                DFS(tmpBoard3, depth + 1);
                DFS(tmpBoard4, depth + 1);
            } else if (cId == 4) {
                int[][] tmpBoard1 = new int[m][n];
                int[][] tmpBoard2 = new int[m][n];
                int[][] tmpBoard3 = new int[m][n];
                int[][] tmpBoard4 = new int[m][n];

                copyBoard(board, tmpBoard1);
                copyBoard(board, tmpBoard2);
                copyBoard(board, tmpBoard3);
                copyBoard(board, tmpBoard4);

                boardLeft(tmpBoard1, curX, curY);
                boardUp(tmpBoard1, curX, curY);
                boardRight(tmpBoard1, curX, curY);

                boardUp(tmpBoard2, curX, curY);
                boardRight(tmpBoard2, curX, curY);
                boardDown(tmpBoard2, curX, curY);

                boardRight(tmpBoard3, curX, curY);
                boardDown(tmpBoard3, curX, curY);
                boardLeft(tmpBoard3, curX, curY);

                boardDown(tmpBoard4, curX, curY);
                boardLeft(tmpBoard4, curX, curY);
                boardUp(tmpBoard4, curX, curY);

                DFS(tmpBoard1, depth + 1);
                DFS(tmpBoard2, depth + 1);
                DFS(tmpBoard3, depth + 1);
                DFS(tmpBoard4, depth + 1);

            } else if (cId == 5) {
                int[][] tmpBoard = new int[m][n];
                copyBoard(board, tmpBoard);
                boardUp(tmpBoard, curX, curY);
                boardDown(tmpBoard, curX, curY);
                boardRight(tmpBoard, curX, curY);
                boardLeft(tmpBoard, curX, curY);
                DFS(tmpBoard, depth + 1);
            }
        }
    }

    void boardUp(int[][] board, int x, int y) {
        for (int i = x - 1; i > -1; i--) {
            if (board[i][y] == 0) {
                board[i][y] = -1;
            } else if (board[i][y] == 6) {
                break;
            }
        }
    }

    void boardDown(int[][] board, int x, int y) {
        for (int i = x + 1; i < m; i++) {
            if (board[i][y] == 0) {
                board[i][y] = -1;
            } else if (board[i][y] == 6) {
                break;
            }
        }
    }

    void boardRight(int[][] board, int x, int y) {
        for (int j = y + 1; j < n; j++) {
            if (board[x][j] == 0) {
                board[x][j] = -1;
            } else if (board[x][j] == 6) {
                break;
            }
        }
    }

    void boardLeft(int[][] board, int x, int y) {
        for (int j = y - 1; j > -1; j--) {
            if (board[x][j] == 0) {
                board[x][j] = -1;
            } else if (board[x][j] == 6) {
                break;
            }
        }
    }

    void copyBoard(int[][] src, int[][] dst) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dst[i][j] = src[i][j];
            }
        }
    }

    public void run() throws IOException {
        int[][] board = makeBoard();
        findCCTV(board);
        finalDepth = CCTVList.size();
        DFS(board, 0);

        System.out.println(result);
    }
}

class Node {
    int id, x, y;

    Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
