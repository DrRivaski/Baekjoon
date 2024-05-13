import java.io.*;
import java.util.*;

class Solution {
    Solution() {

    }

    void printBoard(int r, int c, int[][] board) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    void initializeTmpBoard(int r, int c, int[][] tmpBoard) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmpBoard[i][j] = 0;
            }
        }
    }

    // 확산
    void calculateBoard(int r, int c, int[][] board, int[][] tmpBoard) {
        int[] dirX = {1, 0, -1, 0};
        int[] dirY = {0, 1, 0, -1};
        int newX, newY;

        for (int curX = 0; curX < r; curX++) {
            for (int curY = 0; curY < c; curY++) {
                int curVal = board[curX][curY];
                if (curVal > 0) {
                    int divVal = curVal / 5;

                    for (int i = 0; i < 4; i++) {
                        newX = curX + dirX[i];
                        newY = curY + dirY[i];
                        if (newX >= 0 && newX < r && newY >= 0 && newY < c && board[newX][newY] != -1) {
                            tmpBoard[newX][newY] += divVal;
                            board[curX][curY] -= divVal;
                        }
                    }
                }
            }
        }
        addBoard(r, c, board, tmpBoard);
    }

    // tmpBoard의 값 원래 board에 더하기
    void addBoard(int r, int c, int[][] board, int[][] tmpBoard) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != -1) {
                    board[i][j] += tmpBoard[i][j];
                }
            }
        }
    }

    // 공기청정기 가동
    void rotateBoard(int r, int c, int[][] board, int[][] tmpBoard) {
        int apX1 = 0, apY1 = 0, apX2 = 0, apY2 = 0;
        for (int i = 0; i < r; i++) {
            if (board[i][0] == -1) {
                apX1 = i;
                break;
            }
        }
        apX2 = apX1 + 1;

        initializeTmpBoard(r, c, tmpBoard);
        tmpBoard[apX1][apY1] = -1;
        tmpBoard[apX2][apY2] = -1;

        for (int i = apX1 - 1; i > 0; i--) {
            tmpBoard[i][0] = board[i - 1][0];
        }

        for (int j = 0; j < c - 1; j++) {
            tmpBoard[0][j] = board[0][j + 1];
        }

        for (int i = 0; i < apX1; i++) {
            tmpBoard[i][c - 1] = board[i + 1][c - 1];
        }

        for (int j = c - 1; j > 1; j--) {
            tmpBoard[apX1][j] = board[apX1][j - 1];
        }

        for (int i = apX2 + 1; i < r - 1; i++) {
            tmpBoard[i][0] = board[i + 1][0];
        }

        for (int j = 0; j < c - 1; j++) {
            tmpBoard[r - 1][j] = board[r - 1][j + 1];
        }

        for (int i = r - 1; i > apX2; i--) {
            tmpBoard[i][c - 1] = board[i - 1][c - 1];
        }

        for (int j = c - 1; j > apY2 + 1; j--) {
            tmpBoard[apX2][j] = board[apX2][j - 1];
        }

        for (int i = 0; i < r; i++) {
            board[i][0] = tmpBoard[i][0];
            board[i][c - 1] = tmpBoard[i][c - 1];
        }

        for (int j = 0; j < c; j++) {
            board[0][j] = tmpBoard[0][j];
            board[r - 1][j] = tmpBoard[r - 1][j];
        }

        for (int j = 0; j < c; j++) {
            board[apX1][j] = tmpBoard[apX1][j];
            board[apX2][j] = tmpBoard[apX2][j];
        }
    }

    // 남은 미세먼지 총합 구하기
    int sumBoard(int r, int c, int[][] board) {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += board[i][j];
            }
        }
        return sum + 2;
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        int r, c, t;
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);

        // board, tmpBoard 초기화
        int[][] board = new int[r][c];
        int[][] tmpBoard = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] boardInput = br.readLine().strip().split(" ");
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(boardInput[j]);
            }
        }

        // t초만큼 반복
        for (int i = 0; i < t; i++) {
            initializeTmpBoard(r, c, tmpBoard);
            calculateBoard(r, c, board, tmpBoard);
            rotateBoard(r, c, board, tmpBoard);
        }

        // 최종 답
        System.out.println(sumBoard(r, c, board));
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
