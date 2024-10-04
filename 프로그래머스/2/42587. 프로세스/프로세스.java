import java.util.*;
import java.io.*;

class Node {
    int loc;
    int priority;
    
    Node(int loc, int priority) {
        this.loc = loc;
        this.priority = priority;
    }
    
    public int getLoc() {
        return this.loc;
    }
    
    public int getPriority() {
        return this.priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int priorityLen = priorities.length;
        
        int[] sortedPriorities = new int[priorityLen];
        
        for (int i = 0; i < priorityLen; i++) {
            sortedPriorities[i] = priorities[i];
        }
        Arrays.sort(sortedPriorities);
        
        Deque<Node> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorityLen; i++) {
            queue.add(new Node(i, priorities[i]));
        }
        
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            Node curNode = queue.pollFirst();
            int curPri = curNode.getPriority();
            int curLoc = curNode.getLoc();
            int maxPri = sortedPriorities[priorityLen - cnt - 1];
            
            if (curPri < maxPri) {
                queue.add(curNode);
            } else {
                cnt++;
                
                if (curLoc == location) {
                    break;
                }
            }
            
            
        }
        
        return cnt;
    }
}