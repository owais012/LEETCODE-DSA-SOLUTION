class Solution{
    public int[] intersect(int[] nums1, int[] nums2){
        List<Integer> res = new ArrayList<>();

        if(nums1.length < nums2.length){
            int[]temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        for(int i = 0; i < nums1.length; i++){
           map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
           System.out.print(nums1[i] + " ");
        }

        for(int i = 0; i < nums2.length; i++){
           map2.put(nums2[i], map2.getOrDefault(nums2[i], 0)+1);
        }
        System.out.println(map1);
        System.out.println(map2);

        for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
            if(map1.containsKey(entry.getKey()))
                for(int i = 0; i < Math.min(entry.getValue(), map1.get(entry.getKey())); i++)
                    res.add(entry.getKey());
        }

        int[] ans = new int[res.size()];
        for(int i=0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}