import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] answerList = {"1", "2", "4"};
        
        while (n > 0) {
            n--;
            int idx = n % 3;
            answer = answerList[idx] + answer;
            n = n / 3;
        }
        return answer;
    }
}