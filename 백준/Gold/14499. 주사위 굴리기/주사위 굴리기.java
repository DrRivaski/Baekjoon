import java.util.*;
import java.io.*;

class Game {
    int[][] graph;
    int n, m, startX, startY;
    Dice dice;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Game() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().strip().split(" ");
        this.n = Integer.parseInt(input[0]);
        this.m = Integer.parseInt(input[1]);
        this.startX = Integer.parseInt(input[2]);
        this.startY = Integer.parseInt(input[3]);
        dice = new Dice();
    }

    public void makeGraph() throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] graphInput = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(graphInput[j]);
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void run() throws IOException{
        List<Integer> commands = new ArrayList<>();
        for (String c : br.readLine().strip().split(" ")) {
            commands.add(Integer.parseInt(c));
        }

        for (Integer c : commands) {
            rotateDice(c);
        }
    }

    public void rotateDice(int c) {
        if (c == 1) {
            rotateEast();
        } else if (c == 2) {
            rotateWest();
        } else if (c == 3) {
            rotateNorth();
        } else {
            rotateSouth();
        }
    }

    private void rotateEast() {
        int newX = startX;
        int newY = startY + 1;

        if (newY >= 0 && newY < m) {
            // 이동한 칸이 0이라면 주사위의 값을 복사
            if (graph[newX][newY] == 0) {
                dice.rotateEast();
                graph[newX][newY] = dice.getBottom();
                startX = newX;
                startY = newY;
            } else { // 아니라면 칸에 쓰인 값이 주사위 바닥으로 복사, 칸에 쓰인 값은 0
                dice.rotateEast();
                dice.setBottom(graph[newX][newY]);
                graph[newX][newY] = 0;
                startX = newX;
                startY = newY;
            }
            System.out.println(dice.getTop());
        }
    }

    private void rotateWest() {
        int newX = startX;
        int newY = startY - 1;

        if (newY >= 0 && newY < m) {
            // 이동한 칸이 0이라면 주사위의 값을 복사
            if (graph[newX][newY] == 0) {
                dice.rotateWest();
                graph[newX][newY] = dice.getBottom();
                startX = newX;
                startY = newY;
            } else {
                dice.rotateWest();
                dice.setBottom(graph[newX][newY]);
                graph[newX][newY] = 0;
                startX = newX;
                startY = newY;
            }
            System.out.println(dice.getTop());
        }
    }

    public void rotateSouth() {
        int newX = startX + 1;
        int newY = startY;

        if (newX >= 0 && newX < n) {
            // 이동한 칸이 0이라면 주사위의 값을 복사
            if (graph[newX][newY] == 0) {
                dice.rotateSouth();
                graph[newX][newY] = dice.getBottom();
                startX = newX;
                startY = newY;
            } else {
                dice.rotateSouth();
                dice.setBottom(graph[newX][newY]);
                graph[newX][newY] = 0;
                startX = newX;
                startY = newY;
            }
            System.out.println(dice.getTop());
        }
    }

    public void rotateNorth() {
        int newX = startX - 1;
        int newY = startY;

        if (newX >= 0 && newX < n) {
            // 이동한 칸이 0이라면 주사위의 값을 복사
            if (graph[newX][newY] == 0) {
                dice.rotateNorth();
                graph[newX][newY] = dice.getBottom();
                startX = newX;
                startY = newY;
            } else {
                dice.rotateNorth();
                dice.setBottom(graph[newX][newY]);
                graph[newX][newY] = 0;
                startX = newX;
                startY = newY;
            }
            System.out.println(dice.getTop());
        }
    }
}

class Dice {
    int[][] dice = {
            {-1, 0, -1},
            {0, 0, 0},
            {-1, 0, -1},
            {-1, 0, -1}};

    Dice() {

    }

    public void rotateEast() {
        int tmp = dice[3][1];
        dice[3][1] = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = tmp;
    }

    public void rotateWest() {
        int tmp = dice[3][1];
        dice[3][1] = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = tmp;
    }

    public void rotateSouth() {
        int tmp = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = tmp;
    }

    public void rotateNorth() {
        int tmp = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = tmp;
    }

    public int getTop() {
        return dice[1][1];
    }

    public int getBottom() {
        return dice[3][1];
    }

    public void setBottom(int num) {
        dice[3][1] = num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.makeGraph();
        game.run();
    }
}