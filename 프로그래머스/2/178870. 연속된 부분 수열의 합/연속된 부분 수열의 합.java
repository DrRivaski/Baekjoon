import java.util.*;

class Solution {
    public int[] calculateSequence(int[] sequence) {
        int length = sequence.length;
        int[] calculatedSequence = new int[length + 1];
        calculatedSequence[0] = 0;
        calculatedSequence[1] = sequence[0];
        
        for (int i = 2; i < length + 1; i++) {
            calculatedSequence[i] = calculatedSequence[i - 1] + sequence[i - 1];
        }
        return calculatedSequence;
    }
    
    public int findIndex(int[] calculatedSequence, int k) {
        for (int i = 1; i < calculatedSequence.length; i++) {
            if (calculatedSequence[i] >= k) {
                return i;
            }
        }
        return 1;
    }
    
    public Comparator<Data> comparator = new Comparator<>() {
        @Override
        public int compare(Data d1, Data d2) {
            if (d1.length == d2.length) {
                return d1.startIdx - d2.startIdx;
            } else {
                return d1.length - d2.length;
            }
        }
    };
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] calculatedSequence = calculateSequence(sequence);
        int start = 0;
        int end = findIndex(calculatedSequence, k);
        ArrayList<Data> answerList = new ArrayList<>();
        
        int curVal = calculatedSequence[end];
        int size = sequence.length;
        while (end <= size) {
            if (curVal > k) {
                while (start < end && curVal > k) {
                    start++;
                    curVal = calculatedSequence[end] - calculatedSequence[start];
                }
            }
            if (curVal == k) {
                answerList.add(new Data(start, end - 1, end - start));
            }
            end++;
            if (end <= size) {
                curVal = calculatedSequence[end] - calculatedSequence[start];
            }
        }
        
        Collections.sort(answerList, comparator);
        
        answer[0] = answerList.get(0).startIdx;
        answer[1] = answerList.get(0).endIdx;
        return answer;
    }
}

class Data {
    int startIdx;
    int endIdx;
    int length;
    Data(int startIdx, int endIdx, int length) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.length = length;
    }
}