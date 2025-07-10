class Solution {
    public int maxFreeTime(int eventTime, int[] start, int[] end) {
        //for each meeting first, we check if this can be moved before i-1 and after i+1
        //if possible then we res = Math.max(res, startTime[i+1]-endTime[i-1]);
        //else  res = Math.max(res, (startTime[i+1]-endTime[i-1])-(startTime[i]-endTime[i]))
        int n = start.length;
        int[]left = new int[n];
        int[]right = new int[n];
        
        left[0] = start[0];
        right[n-1] = eventTime-end[n-1];

        for(int i = 1; i < n; i += 1){
            left[i] = Math.max(left[i-1], (start[i]-end[i-1]));
        }
        
        for(int i = n -2; i >= 0; i -= 1){
            right[i] = Math.max(right[i+1], start[i+1]-end[i]);
        }

        // for(int i = 0; i < n; i += 1){
        //    System.out.print(left[i] + " ");
        // }
        // System.out.println();

        // for(int i = 0; i < n; i += 1){
        //     System.out.print(right[i] + " ");
        // }
        // System.out.println();
        int res = 0;
        for(int i = 0; i < n; i += 1){
            if(i == 0){
                //check if current can removed,
                if(right[i+1] >= (end[i]-start[i])){
                    res = Math.max(res, start[i+1]);
                }else{
                    res = Math.max(res, (start[i+1]-(end[i]-start[i])));
                }
            }else if (i == n-1){
                if(left[i-1] >= (end[i]-start[i])){
                    res = Math.max(res, eventTime-end[i-1]);
                }else{
                    res = Math.max(res, (eventTime-end[i-1]) - (end[i]-start[i]));
                }
            }else{
                if(right[i+1] >= (end[i]-start[i])){
                    res = Math.max(res, start[i+1]-end[i-1]);
                    System.out.print("1 ");
                }else if(left[i-1] >= (end[i]-start[i])){
                    res = Math.max(res, start[i+1]-end[i-1]);
                    System.out.print("2 ");
                }else{
                    res = Math.max(res, (start[i+1]-end[i-1]) - (end[i]-start[i]));
                    System.out.print("3 ");
                }
            }
            // System.out.println(res);
        }
        return res;
    }
}