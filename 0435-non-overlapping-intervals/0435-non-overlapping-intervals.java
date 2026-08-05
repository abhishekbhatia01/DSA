class Solution {
    public int eraseOverlapIntervals(int[][] interval) {
        if(interval.length == 0){
            return 0;
        }
        Arrays.sort(interval, (a, b) -> a[1] - b[1]);

        int max = 1;
        int lastEnd = interval[0][1];

        for(int i=1; i<interval.length; i++){
            if(interval[i][0] >= lastEnd){
                max++;
                lastEnd = interval[i][1];
            }
        }

        return interval.length-max;

    }
}