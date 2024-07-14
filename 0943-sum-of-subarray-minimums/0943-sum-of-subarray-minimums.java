
class Solution{
    public int[] prevEle(int[] arr){
        int[] prev = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            prev[i]= st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return prev;
    }

    public int[] nextEle (int [] arr){
        int[] next = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();

    
            next[i] = st.isEmpty() ? arr.length : st.peek();

            st.push(i);
        }

        return next;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] left = prevEle(arr);
        int[] right = nextEle(arr);

        long res = 0;
        int mod = (int) 1e9 + 7;

        for(int i = 0; i < arr.length; i++){
            res = (res + (long) arr[i]* (i -left[i]) *(right[i] - i))% mod;
        }

        return (int) res;
    }
}




