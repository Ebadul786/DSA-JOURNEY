class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });
        int maxend=0,count=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>maxend){
                maxend = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}