class Solution{

    public void helper2(int ind, String cur, String num, List<String> arr, int[] fix){
        if(cur.length() == 3){
            arr.add(cur);
            return;
        }
        
        for(int i = 0; i < num.length(); i += 1){

            if(fix[i]==0){
                fix[i] = 1;
                helper2(ind+1, cur+String.valueOf(num.charAt(i)), num, arr, fix);
                fix[i] = 0;
            }
        }
    }

    public List<String> getPermutation(String num){
        int n = num.length();
        int[]fix = new int[n];
        List<String> arr = new ArrayList<>();
        helper2(0, "", num, arr, fix);
        return arr;
    }

    public int helper(int i, String num, int[] digits,HashSet<String> set){
        if(num.length() > 3)
            return 0;

        if(num.length() == 3){
            int cnt =0;
            List<String> arr = getPermutation(num);
            for(String s : arr){
                if(Integer.valueOf(s) < 100)
                    continue; 

                if((s.charAt(2)-'0')%2 != 0)
                    continue;
                if(set.contains(s))
                    continue;
                set.add(s);
                cnt += 1;
            }
            return cnt;
        }

        if(i >= digits.length)
            return 0;

        int take = helper(i+1, num + String.valueOf(digits[i]), digits, set);
        int notTake = helper(i+1, num, digits, set);

        return take + notTake;
    }

    public int totalNumbers(int[] digits) {
        //make every digit as last 
        HashSet<String> set = new HashSet<>();

        return helper(0, "",  digits, set);
    }
}