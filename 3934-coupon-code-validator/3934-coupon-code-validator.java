class Solution {
    public class Pair{
        String code, busLine;
        Pair(String code, String busLine){
            this.code = code;
            this.busLine = busLine;
        }
    }
    
    public boolean busValid(String b){
        return b.equals("electronics") || b.equals("grocery") || 
                b.equals("pharmacy") || b.equals("restaurant");
    }


    public boolean codeValid(String s){
        if(s.length() == 0)
            return false;
        for(var ch : s.toCharArray()){
            if(!('a' <= ch  && ch <= 'z') && !('A' <= ch && ch <= 'Z') && !('0' <= ch && ch <= '9') && !(ch == '_'))
                return false;
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Pair> arr = new ArrayList<>();

        for(int i = 0; i < n; i += 1){
            boolean isCodeValid = codeValid(code[i]);
            System.out.println(isCodeValid);
            if(!busValid(businessLine[i]) || !isActive[i] || !isCodeValid )
                continue;
            arr.add(new Pair(code[i], businessLine[i]));  
        }

        Collections.sort(arr, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                int result = a.busLine.compareTo(b.busLine);
                if(result == 0){
                    return a.code.compareTo(b.code);
                }
                return result;
            }
        });

        List<String> res = new ArrayList<>();
        for(var cur:arr)
            res.add(cur.code);
        return res;
    }
}