import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}

class Solution {
    int[][] board;

    Solution() {

    }

    private void printBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private boolean isWallHit(Head head, int n) {
        int curX = head.getX();
        int curY = head.getY();
        if (curX >= 0 && curX < n && curY >= 0 && curY < n) {
            return false;
        }
        return true;
    }

    private boolean isTailHit(Head head, Deque<Node> tail) {
        int curX = head.getX();
        int curY = head.getY();

        for (Node n : tail) {
            if (n.getX() == curX && n.getY() == curY) {
                return true;
            }
        }

        return false;
    }

    private void printTail(Deque<Node> tail) {
        System.out.print("tail: ");
        for (Node n : tail) {
            System.out.print("(" + n.getX() + ", " + n.getY() + ")");
        }
        System.out.println("");
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());
        board = new int[n][n];

        int k = Integer.parseInt(br.readLine().strip());
        for (int i = 0; i < k; i++) {
            String[] appleInput = br.readLine().strip().split(" ");
            board[Integer.parseInt(appleInput[0]) - 1][Integer.parseInt(appleInput[1]) - 1] = 1;
        }

        // printBoard(n);

        Deque<Command> commands = new ArrayDeque<>();
        int l = Integer.parseInt(br.readLine().strip());
        for (int i = 0; i < l; i++) {
            String[] commandInput = br.readLine().strip().split(" ");
            commands.add(new Command(Integer.parseInt(commandInput[0]), commandInput[1].charAt(0)));
        }

        Head head = new Head(0, 0, 2);
        Deque<Node> tail = new ArrayDeque<>();
        tail.add(new Node(0, 0));
        Command nextCommand = commands.pollFirst();
        int curTime = 0;

        while (true) {
            curTime++;
            //System.out.print("curTime = " + curTime + ": ");

            head.move();

            if (isWallHit(head, n)) {
                break;
            }

            if (isTailHit(head, tail)) {
                break;
            }

            //System.out.println(head.getX() + ", " + head.getY());

            if (board[head.getX()][head.getY()] == 1) { // 사과 있을 때
                // 사과 없애기
                board[head.getX()][head.getY()] = 0;

                // 마지막 꼬리 하나 추가
                tail.addFirst(new Node(head.getX(), head.getY()));

            } else { // 사과 없을 때
                tail.addFirst(new Node(head.getX(), head.getY()));
                tail.pollLast();
            }

            if (nextCommand.getTime() == curTime) { // 만약 방향을 바꿨다면
                head.setDirection(nextCommand.getDirection());
                if (!commands.isEmpty()) {
                    nextCommand = commands.pollFirst();
                }
            }
            //printTail(tail);
        }

        System.out.println(curTime);
    }
}

class Head {
    private int x, y, direction;

    Head(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setDirection(char newDirection) {
        if (newDirection == 'D') {
            direction++;
            if (direction == 5) {
                direction = 1;
            }
        } else {
            direction--;
            if (direction == 0) {
                direction = 4;
            }
        }
    }

    public void move() {
        if (direction == 1) {
            this.x--;
        } else if (direction == 2) {
            this.y++;
        } else if (direction == 3) {
            this.x++;
        } else {
            this.y--;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDirection() {
        return this.direction;
    }
}

class Node {
    private int x, y;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Command {
    private int time;
    private char direction;

    Command(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return this.direction;
    }
}
