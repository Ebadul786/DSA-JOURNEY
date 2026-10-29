class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] current = intervals[i];
            if(current[1]<newInterval[0]){
                ans.add(current);
            }else if(current[0]>newInterval[1]){
                ans.add(newInterval);
                newInterval = current;
            }else{
                newInterval[0] = Math.min(current[0],newInterval[0]);
                newInterval[1] = Math.max(current[1],newInterval[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}