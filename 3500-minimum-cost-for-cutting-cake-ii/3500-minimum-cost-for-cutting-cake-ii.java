class Solution {
    public static void _sort(int[] arr, boolean isAscending) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int ele : arr) list.add(ele);
        Collections.sort(list);
        if (!isAscending) Collections.reverse(list);
        for (int i = 0; i < n; i++) arr[i] = list.get(i);
    }

    public long minimumCost(int m, int n, int[] h, int[] v) {
        _sort(h, false);
        _sort(v,false);

        int hCut = 1, vCut = 1;

        int i = 0, j = 0;
        long minCost = 0;

        while(i < m-1 && j < n-1){
            if(h[i] <= v[j]){
                minCost += hCut * v[j];
                vCut += 1;
                j += 1;
            }else{
                minCost += vCut * h[i];
                hCut += 1;
                i += 1;
            }
        }

        while(i < m-1){
            minCost += vCut * h[i];
            i++;
        }

        while(j < n-1){
            minCost += hCut * v[j];
            j++;
        }

        return  minCost;
    }
}