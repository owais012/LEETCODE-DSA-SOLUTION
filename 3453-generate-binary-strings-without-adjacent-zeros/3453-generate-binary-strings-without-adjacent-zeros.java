class Solution{
    
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < (1 << n); i++){
            StringBuilder sb = new StringBuilder();
            boolean isValid = true;

            for(int j = 0; j < n; j++){
                int bit = 1 & (i >> j);
                sb.append(bit);
            }
            
            char prev = sb.charAt(0);
            for(int j = 1; j < sb.length(); j++){
                if(prev == '0' && sb.charAt(j) == '0'){
                    isValid = false;
                    break;
                }
                prev = sb.charAt(j);
            }

            if(isValid)
                res.add(sb.toString());
        }

        return res;
    }
}