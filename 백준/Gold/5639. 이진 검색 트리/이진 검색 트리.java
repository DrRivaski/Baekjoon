import java.io.*;

class Solution {
    Solution() {

    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootValue = Integer.parseInt(br.readLine().strip());
        Tree t = new Tree(rootValue);
        String str = "";

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            int val = Integer.parseInt(str);
            t.addNode(val);
        }

        t.traverseLRC();
    }
}

class Tree {
    Node root;

    Tree(int rootValue) {
        root = new Node(rootValue);
    }

    public void addNode(int value) {
        add(root, value);
    }

    private void add(Node curNode, int value) {
        if (curNode != null) {
            int curVal = curNode.value;
            if (value < curVal) {
                if (curNode.left == null) {
                    curNode.setLeft(new Node(value));
                } else {
                    add(curNode.left, value);
                }
            } else {
                if (curNode.right == null) {
                    curNode.setRight(new Node(value));
                } else {
                    add(curNode.right, value);
                }

            }
        }
    }

    public void traverseLRC() {
        traverseNodeLRC(root);
    }

    private void traverseNodeLRC(Node curNode) {
        if (curNode.left != null) {
            traverseNodeLRC(curNode.left);
        }
        if (curNode.right != null) {
            traverseNodeLRC(curNode.right);
        }
        System.out.println(curNode.value);

    }
}

class Node {
    int value;
    Node left = null;
    Node right = null;

    Node(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.run();
    }
}
