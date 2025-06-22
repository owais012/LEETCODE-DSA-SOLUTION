class Solution {
    public int minSwaps(int[] nums) {
        //if n is even the , |oddCount-evenCount| == 0
        //else |oddCount-evenCount| == 1
        //if not then return -1;
        int n = nums.length;
        int evenCount = 0, oddCount = 0;
        for (var v : nums)
            if ((v & 1) > 0)
                oddCount += 1;
            else
                evenCount += 1;

        if (Math.abs(oddCount - evenCount) > 1) {
            return -1;
        }

        //for even there can be 2 possibilities , array start with even at 0th index or odd at 0th
        //we compute both possibilities

        if ((n & 1) == 0) {
            List<Integer> even1 = new ArrayList<>();
            List<Integer> odd1 = new ArrayList<>();
            List<Integer> even2 = new ArrayList<>();
            List<Integer> odd2 = new ArrayList<>();

            //even at 0th index
            for (int i = 0; i < n; i += 1) {
                if (i % 2 != nums[i] % 2) {
                    if (nums[i] % 2 == 0) {
                        even1.add(i);
                    } else {
                        odd1.add(i);
                    }
                }
                if (i % 2 == nums[i] % 2) {
                    if (nums[i] % 2 == 0) {
                        odd2.add(i);
                    } else {
                        even2.add(i);
                    }
                }
            }

            int res1 = 0, res2 = 0;
            for (int i = 0; i < even1.size(); i += 1) {
                res1 += (Math.abs(even1.get(i) - odd1.get(i)));
            }
            for(int i = 0; i < even2.size(); i +=1 ){
                res2 += (Math.abs(even2.get(i) - odd2.get(i)));
            }
            System.out.println(res1 + "   " + res2);
            return Math.min(res1, res2);
        } else {
            List<Integer> odd = new ArrayList<>();
            List<Integer> even = new ArrayList<>();

            if (evenCount > oddCount) {
                for (int i = 0; i < n; i += 1) {
                    if (i % 2 != nums[i] % 2) {
                        if (nums[i] % 2 == 0) {
                            even.add(i);
                        } else {
                            odd.add(i);
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i += 1) {
                    if (i % 2 == nums[i] % 2) {
                        if (nums[i] % 2 == 0) {
                            odd.add(i);
                        } else {
                            even.add(i);
                        }
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < even.size(); i += 1) {
                res += Math.abs(even.get(i) - odd.get(i));
            }
            return res;
        }

    }
}