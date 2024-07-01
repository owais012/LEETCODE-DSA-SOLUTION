class Solution {
    public int countTriplets(int[] arr) {
        int cnt = 0;

        for(int i = 0; i < arr.length; i++){
            int a = 0;
            a ^= arr[i];

            for(int j = i+ 1; j < arr.length; j++){
                int b = 0;
                b ^= arr[j];

                if(a == b)
                    cnt += 1;
                a ^= arr[j];
            }

            a = arr[i];
            for(int j = i+1; j < arr.length; j++){
                int b = arr[j];

                for(int k = j+1; k < arr.length; k++){
                    b ^= arr[k];

                    if(a == b)
                        cnt += 1;
                }

                a ^= arr[j];
            }
        }

        return cnt;
    }
}