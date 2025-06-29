class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        if(n == 1)  
            return new int[]{0};
        if(n == 2)  
            return new int[]{0,0};
        int[]adj1 = new int[n-1];
        int[]res = new int[n];
        int[]preMax = new int[n-1];
        int[]sufMax = new int[n-1];

        for(int i = 0; i < n-1; i += 1){
            int j = 0;
            while(j < Math.min(words[i].length(), words[i+1].length()) 
                && (words[i].charAt(j) == words[i+1].charAt(j))
            ){
                j++;
                adj1[i]++;
            }
            // System.out.print(adj1[i] + " ");
        }   
        // System.out.println();

        preMax[0] = adj1[0];
        sufMax[n-2] = adj1[n-2];
        for(int i = 1; i < n-1; i += 1){
            preMax[i] = Math.max(preMax[i-1], adj1[i]);
        }
        for(int i = n-3; i >= 0; i -= 1){
            sufMax[i] = Math.max(sufMax[i+1], adj1[i]);
        }

        res[0] = n > 1 ? sufMax[1] : 0;
        res[n-1] = n > 2 ? preMax[n-3]:0;

        for(int i = 0; i < n-1; i += 1){
            System.out.print(preMax[i] + " ");
        }
        System.out.println();
        

        for(int i = 0; i < n-1; i += 1){
            System.out.print(sufMax[i] + " ");
        }
        System.out.println();

        for(int i = 1; i < n-1; i+=1){
            int cnt = 0, j = 0;
            while(j < Math.min(words[i-1].length(), words[i+1].length()) 
                && (words[i-1].charAt(j) == words[i+1].charAt(j))
            ){
                j++;
                cnt++;
            }

            // System.out.println(i + " " + (i-2 >= 0 ?  preMax[i-2] : 0));
            // System.out.println(i + " " + (i+1 < n-1 ? sufMax[i+1] : 0));

            res[i] = Math.max(cnt, i+1 < n-1 ? sufMax[i+1] : 0);
            res[i] = Math.max(res[i], i-2 >= 0 ?  preMax[i-2] : 0);
        }

        return res;
    }
}