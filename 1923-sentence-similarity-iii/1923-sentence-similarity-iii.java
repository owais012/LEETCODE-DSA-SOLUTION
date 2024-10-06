class Solution {
    public boolean matchString(String[] s1, String[] s2) {
        // we can traverse the sentence 2 , from both side with i & j;

        int i = 0, j = s2.length - 1;
        int l = 0, r = s1.length - 1;

        while (i <= j && l <= r) {
            if (!s1[l].equals(s2[i]) && !s1[r].equals(s2[j]))
                break;

            if (s1[l].equals(s2[i])) {
                i++;
                l++;
            }

            if (s1[r].equals(s2[j])) {
                j--;
                r--;
            }

        }

        System.out.println(i + " " + j);
        return i > j;

    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[]s1 = sentence1.split(" ");
        String[]s2 = sentence2.split(" ");

        return matchString(s1, s2 ) || matchString(s2, s1);
    }
}