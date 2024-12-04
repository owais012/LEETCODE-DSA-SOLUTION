class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        for(int i = 0, j = 0; i < str1.length(); i += 1){
            if(str1.charAt(i) == str2.charAt(j) || (str1.charAt(i) == 'z' ? 'a' : str1.charAt(i)+1 )== str2.charAt(j))
                j+=1;

            if(j == str2.length())
                return true;
        }


        return false;
    }
}