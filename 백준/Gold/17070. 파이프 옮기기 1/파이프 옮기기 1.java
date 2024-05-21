import java.util.*;
import java.io.*;

// 벽은 -1
// 공간은 0
// 시작 두 칸은 1

class Solution {
    int n;
    int[][] board;
    Solution() {

    }

    int[][] makeBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().strip());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] boardInput = br.readLine().strip().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = -1;
                }
            }
        }

        board[0][0] = 1;
        board[0][1] = 1;
        return board;
    }

    boolean checkHorizontal(int fromX, int fromY) {
        int toX = fromX;
        int toY = fromY + 1;
        if (toY < n) {
            if (board[toX][toY] != -1) {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonal(int fromX, int fromY) {
        int toX = fromX + 1;
        int toY = fromY + 1;
        if (toX < n && toY < n) {
            if (board[toX][toY] != -1) {
                return true;
            }
        }
        return false;
    }

    boolean checkVertical(int fromX, int fromY) {
        int toX = fromX + 1;
        int toY = fromY;
        if (toX < n) {
            if (board[toX][toY] != -1) {
                return true;
            }
        }
        return false;
    }

    void printBoard() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("");
    }

    public void run() throws IOException {
        board = makeBoard();
        //printBoard();
        Deque<Pipe> queue = new ArrayDeque<>();
        queue.offer(new Pipe(0, 0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Pipe curPipe = queue.pollFirst();
            int type = curPipe.type;
            int fromX = curPipe.toX;
            int fromY = curPipe.toY;

            if (type == 0) {
                // 가로
                // 가로 체크
                if (checkHorizontal(fromX, fromY)) {
                    queue.offer(new Pipe(0, fromX, fromY, fromX, fromY + 1));
                    board[fromX][fromY + 1]++;
                }
                // 대각 체크
                if (checkHorizontal(fromX, fromY) && checkDiagonal(fromX, fromY) && checkVertical(fromX, fromY)) {
                    queue.offer(new Pipe(1, fromX, fromY, fromX + 1, fromY + 1));
                    board[fromX + 1][fromY + 1]++;
                }
            } else if (type == 1) {
                // 대각선
                // 가로 체크
                if (checkHorizontal(fromX, fromY)) {
                    queue.offer(new Pipe(0, fromX, fromY, fromX, fromY + 1));
                    board[fromX][fromY + 1]++;
                }
                // 대각 체크
                if (checkHorizontal(fromX, fromY) && checkDiagonal(fromX, fromY) && checkVertical(fromX, fromY)) {
                    queue.offer(new Pipe(1, fromX, fromY, fromX + 1, fromY + 1));
                    board[fromX + 1][fromY + 1]++;
                }
                // 세로 체크
                if (checkVertical(fromX, fromY)) {
                    queue.offer(new Pipe(2, fromX, fromY, fromX + 1, fromY));
                    board[fromX + 1][fromY]++;
                }
            } else {
                // 세로
                // 대각 체크
                if (checkHorizontal(fromX, fromY) && checkDiagonal(fromX, fromY) && checkVertical(fromX, fromY)) {
                    queue.offer(new Pipe(1, fromX, fromY, fromX + 1, fromY + 1));
                    board[fromX + 1][fromY + 1]++;
                }
                // 세로 체크
                if (checkVertical(fromX, fromY)) {
                    queue.offer(new Pipe(2, fromX, fromY, fromX + 1, fromY));
                    board[fromX + 1][fromY]++;
                }
            }
        }
        if (board[n - 1][n - 1] == -1) {
            System.out.println(0);
        } else {
            System.out.println(board[n - 1][n - 1]);
        }

    }
}

class Pipe {
    int fromX, fromY, toX, toY;
    int type; // 0 = 가로, 1 = 대각선, 2 = 세로
    Pipe(int type, int fromX, int fromY, int toX, int toY) {
        this.type = type;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
