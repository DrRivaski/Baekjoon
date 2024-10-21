class Solution {
    private long calculateTime(int[] diffs, int[] times, int level) {
        long time = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            if (level >= diffs[i]) {
                time += times[i];
            } else {
                time += (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
            }
        }
        
        return time;
    } 
    
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int mid = 50000;
        long tmpLimit;
        
        while (mid != left && mid != right) {
            tmpLimit = calculateTime(diffs, times, mid);
            if (tmpLimit < limit) {
                right = mid;
                mid = (left + right) / 2;
            } else {
                left = mid;
                mid = (left + right) / 2;
            }
        }
        
        if (calculateTime(diffs, times, left) > limit) {
            return right;
        } else {
            return left;
        }
    }
}