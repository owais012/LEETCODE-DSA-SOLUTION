class Solution {
    public int numberOfSubstrings(String s, int k) {
        int cnt = 0, n = s.length();
        int r = 0, l = 0;

        for (int i = 0; i < n; i += 1) {
            int[] hash = new int[26];
            int max = 0;
            for (int j = i; j < n; j += 1) {
                hash[s.charAt(j)-'a'] += 1;
                max = Math.max(hash[s.charAt(j)-'a'], max);
                if(max >= k)
                    cnt += 1;
            }
        }
        return cnt;
    }
}